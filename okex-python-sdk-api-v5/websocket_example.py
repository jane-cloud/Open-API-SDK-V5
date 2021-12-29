import asyncio
import base64
import datetime
import hmac
import json
import time
import zlib
import requests
import websockets


def get_timestamp():
    now = datetime.datetime.now()
    t = now.isoformat("T", "milliseconds")
    return t + "Z"


def get_server_time():
    url = "https://www.okex.com/api/v5/public/time"
    response = requests.get(url)
    if response.status_code == 200:
        return response.json()['data'][0]['ts']
    else:
        return ""


def get_local_timestamp():
    return int(time.time())


def login_params(timestamp, api_key, passphrase, secret_key):
    message = timestamp + 'GET' + '/users/self/verify'

    mac = hmac.new(bytes(secret_key, encoding='utf8'), bytes(message, encoding='utf-8'), digestmod='sha256')
    d = mac.digest()
    sign = base64.b64encode(d)

    login_param = {"op": "login", "args": [{"apiKey": api_key,
                                            "passphrase": passphrase,
                                            "timestamp": timestamp,
                                            "sign": sign.decode("utf-8")}]}
    login_str = json.dumps(login_param)
    return login_str


def partial(res):
    data_obj = res['data'][0]
    bids = data_obj['bids']
    asks = data_obj['asks']
    instrument_id = res['arg']['instId']
    # print('全量数据bids为：' + str(bids))
    # print('档数为：' + str(len(bids)))
    # print('全量数据asks为：' + str(asks))
    # print('档数为：' + str(len(asks)))
    return bids, asks, instrument_id


def update_bids(res, bids_p):
    # 获取增量bids数据
    bids_u = res['data'][0]['bids']
    # print('增量数据bids为：' + str(bids_u))
    # print('档数为：' + str(len(bids_u)))
    # bids合并
    for i in bids_u:
        bid_price = i[0]
        for j in bids_p:
            if bid_price == j[0]:
                if i[1] == '0':
                    bids_p.remove(j)
                    break
                else:
                    del j[1]
                    j.insert(1, i[1])
                    break
        else:
            if i[1] != "0":
                bids_p.append(i)
    else:
        bids_p.sort(key=lambda price: sort_num(price[0]), reverse=True)
        # print('合并后的bids为：' + str(bids_p) + '，档数为：' + str(len(bids_p)))
    return bids_p


def update_asks(res, asks_p):
    # 获取增量asks数据
    asks_u = res['data'][0]['asks']
    # print('增量数据asks为：' + str(asks_u))
    # print('档数为：' + str(len(asks_u)))
    # asks合并
    for i in asks_u:
        ask_price = i[0]
        for j in asks_p:
            if ask_price == j[0]:
                if i[1] == '0':
                    asks_p.remove(j)
                    break
                else:
                    del j[1]
                    j.insert(1, i[1])
                    break
        else:
            if i[1] != "0":
                asks_p.append(i)
    else:
        asks_p.sort(key=lambda price: sort_num(price[0]))
        # print('合并后的asks为：' + str(asks_p) + '，档数为：' + str(len(asks_p)))
    return asks_p


def sort_num(n):
    if n.isdigit():
        return int(n)
    else:
        return float(n)


def check(bids, asks):
    # 获取bid档str
    bids_l = []
    bid_l = []
    count_bid = 1
    while count_bid <= 25:
        if count_bid > len(bids):
            break
        bids_l.append(bids[count_bid - 1])
        count_bid += 1
    for j in bids_l:
        str_bid = ':'.join(j[0: 2])
        bid_l.append(str_bid)
    # 获取ask档str
    asks_l = []
    ask_l = []
    count_ask = 1
    while count_ask <= 25:
        if count_ask > len(asks):
            break
        asks_l.append(asks[count_ask - 1])
        count_ask += 1
    for k in asks_l:
        str_ask = ':'.join(k[0: 2])
        ask_l.append(str_ask)
    # 拼接str
    num = ''
    if len(bid_l) == len(ask_l):
        for m in range(len(bid_l)):
            num += bid_l[m] + ':' + ask_l[m] + ':'
    elif len(bid_l) > len(ask_l):
        # bid档比ask档多
        for n in range(len(ask_l)):
            num += bid_l[n] + ':' + ask_l[n] + ':'
        for l in range(len(ask_l), len(bid_l)):
            num += bid_l[l] + ':'
    elif len(bid_l) < len(ask_l):
        # ask档比bid档多
        for n in range(len(bid_l)):
            num += bid_l[n] + ':' + ask_l[n] + ':'
        for l in range(len(bid_l), len(ask_l)):
            num += ask_l[l] + ':'

    new_num = num[:-1]
    int_checksum = zlib.crc32(new_num.encode())
    fina = change(int_checksum)
    return fina


def change(num_old):
    num = pow(2, 31) - 1
    if num_old > num:
        out = num_old - num * 2 - 2
    else:
        out = num_old
    return out


# subscribe channels un_need login
async def subscribe_without_login(url, channels, verbose=False):
    depth_list = []
    while True:
        try:
            async with websockets.connect(url) as ws:
                sub_param = {"op": "subscribe", "args": channels}
                sub_str = json.dumps(sub_param)
                await ws.send(sub_str)
                if verbose:
                    print(f"send: {sub_str}")

                while True:
                    try:
                        res = await asyncio.wait_for(ws.recv(), timeout=25)
                    except (asyncio.TimeoutError, websockets.ConnectionClosed) as e:
                        try:
                            await ws.send('ping')
                            res = await ws.recv()
                            if verbose:
                                print(res)
                            continue
                        except Exception as e:
                            print("连接关闭，正在重连……")
                            break

                    # if verbose:
                    #     print(get_timestamp() + res)
                    res = eval(res)

                    if 'event' in res:
                        continue
                    for i in res['arg']:
                        if 'books' in res['arg'][i] and 'books5' not in res['arg'][i]:
                            # 订阅频道是深度频道
                            if res['action'] == 'snapshot':
                                for depth in depth_list:
                                    if res['arg']['instId'] == depth['instrument_id']:
                                        depth_list.remove(depth)
                                # 获取首次全量深度数据
                                bids_p, asks_p, instrument_id = partial(res)
                                depth = {'instrument_id': instrument_id, 'bids_p': bids_p, 'asks_p': asks_p}
                                depth_list.append(depth)

                            elif res['action'] == 'update':
                                for depth in depth_list:
                                    if res['arg']['instId'] == depth['instrument_id']:
                                        # 获取全量数据
                                        bids_p = depth['bids_p']
                                        asks_p = depth['asks_p']
                                        # 获取合并后数据
                                        bids_p = update_bids(res, bids_p)
                                        asks_p = update_asks(res, asks_p)

                            # 校验checksum
                            checksum = res['data'][0]['checksum']
                            # print('推送数据的checksum为：' + str(checksum))
                            check_num = check(bids_p, asks_p)
                            # print('校验后的checksum为：' + str(check_num))
                            if check_num == checksum:
                                if verbose:
                                    print("校验结果为：True")
                            else:
                                if verbose:
                                    print("校验结果为：False，正在重新订阅……")
                                # 取消订阅
                                await unsubscribe_without_login(url, channels)
                                # 发送订阅
                                async with websockets.connect(url) as ws:
                                    sub_param = {"op": "subscribe", "args": channels}
                                    sub_str = json.dumps(sub_param)
                                    await ws.send(sub_str)
                                    if verbose:
                                        print(f"send: {sub_str}")

                    # Generate the latest result
                    yield res
        except Exception as e:
            if verbose:
                print("连接断开，正在重连……")
            continue


# subscribe channels need login
async def subscribe(url, api_key, passphrase, secret_key, channels, verbose=False):
    while True:
        try:
            async with websockets.connect(url) as ws:
                # login
                timestamp = str(get_local_timestamp())
                login_str = login_params(timestamp, api_key, passphrase, secret_key)
                await ws.send(login_str)
                if verbose:
                    print(f"send: {login_str}")
                res = await ws.recv()
                if verbose:
                    print(res)

                # subscribe
                sub_param = {"op": "subscribe", "args": channels}
                sub_str = json.dumps(sub_param)
                await ws.send(sub_str)
                if verbose:
                    print(f"send: {sub_str}")

                while True:
                    try:
                        res = await asyncio.wait_for(ws.recv(), timeout=25)
                    except (asyncio.TimeoutError, websockets.ConnectionClosed) as e:
                        try:
                            await ws.send('ping')
                            res = await ws.recv()
                            if verbose:
                                print(res)
                            continue
                        except Exception as e:
                            if verbose:
                                print("连接关闭，正在重连……")
                            break

                    # if verbose:
                    #     print(get_timestamp() + res)
                    # Generate the latest result
                    yield res

        except Exception as e:
            if verbose:
                print("连接断开，正在重连……")
            continue


# trade
async def trade(url, api_key, passphrase, secret_key, trade_param, verbose=False):
    while True:
        try:
            async with websockets.connect(url) as ws:
                # login
                timestamp = str(get_local_timestamp())
                login_str = login_params(timestamp, api_key, passphrase, secret_key)
                await ws.send(login_str)
                if verbose:
                    print(f"send: {login_str}")
                res = await ws.recv()
                if verbose:
                    print(res)

                # trade
                sub_str = json.dumps(trade_param)
                await ws.send(sub_str)
                if verbose:
                    print(f"send: {sub_str}")

                while True:
                    try:
                        res = await asyncio.wait_for(ws.recv(), timeout=25)
                    except (asyncio.TimeoutError, websockets.ConnectionClosed) as e:
                        try:
                            await ws.send('ping')
                            res = await ws.recv()
                            if verbose:
                                print(res)
                            continue
                        except Exception as e:
                            if verbose:
                                print("连接关闭，正在重连……")
                            break

                    # if verbose:
                    #     print(get_timestamp() + res)
                    # Generate the latest result
                    yield res

        except Exception as e:
            if verbose:
                print("连接断开，正在重连……")
            continue


# unsubscribe channels
async def unsubscribe(url, api_key, passphrase, secret_key, channels, verbose=False):
    async with websockets.connect(url) as ws:
        # login
        timestamp = str(get_local_timestamp())
        login_str = login_params(timestamp, api_key, passphrase, secret_key)
        await ws.send(login_str)
        if verbose:
            print(f"send: {login_str}")

        res = await ws.recv()
        if verbose:
            print(f"recv: {res}")

        # unsubscribe
        sub_param = {"op": "unsubscribe", "args": channels}
        sub_str = json.dumps(sub_param)
        await ws.send(sub_str)
        if verbose:
            print(f"send: {sub_str}")

        res = await ws.recv()
        if verbose:
            print(f"recv: {res}")


# unsubscribe channels
async def unsubscribe_without_login(url, channels, verbose=False):
    async with websockets.connect(url) as ws:
        # unsubscribe
        sub_param = {"op": "unsubscribe", "args": channels}
        sub_str = json.dumps(sub_param)
        await ws.send(sub_str)
        if verbose:
            print(f"send: {sub_str}")

        res = await ws.recv()
        if verbose:
            print(f"recv: {res}")


api_key = ""
secret_key = ""
passphrase = ""

# WebSocket公共频道 public channels
# 实盘 real trading
url = "wss://ws.okex.com:8443/ws/v5/public"
# 模拟盘 demo trading
# url = "wss://ws.okex.com:8443/ws/v5/public?brokerId=9999"

# WebSocket私有频道 private channels
# 实盘 real trading
# url = "wss://ws.okex.com:8443/ws/v5/private"
# 模拟盘 demo trading
# url = "wss://ws.okex.com:8443/ws/v5/private?brokerId=9999"

'''
公共频道 public channel
:param channel: 频道名
:param instType: 产品类型
:param instId: 产品ID
:param uly: 合约标的指数

'''

# 产品频道  Instruments Channel
# channels = [{"channel": "instruments", "instType": "FUTURES"}]
# 行情频道 tickers channel
channels = [{"channel": "tickers", "instId": "BTC-USDT"}, {"channel": "tickers", "instId": "BTC-USDT-SWAP"}]
# 持仓总量频道 Open interest Channel
# channels = [{"channel": "open-interest", "instId": "BTC-USD-210326"}]
# K线频道 Candlesticks Channel
# channels = [{"channel": "candle1m", "instId": "BTC-USD-210326"}]
# 交易频道 Trades Channel
# channels = [{"channel": "trades", "instId": "BTC-USD-201225"}]
# 预估交割/行权价格频道 Estimated delivery/exercise Price Channel
# channels = [{"channel": "estimated-price", "instType": "FUTURES", "uly": "BTC-USD"}]
# 标记价格频道 Mark Price Channel
# channels = [{"channel": "mark-price", "instId": "BTC-USDT-210326"}]
# 标记价格K线频道 Mark Price Candlesticks Channel
# channels = [{"channel": "mark-price-candle1D", "instId": "BTC-USD-201225"}]
# 限价频道 Price Limit Channel
# channels = [{"channel": "price-limit", "instId": "BTC-USD-201225"}]
# 深度频道 Order Book Channel
# channels = [{"channel": "books", "instId": "BTC-USD-SWAP"}]
# 期权定价频道 OPTION Summary Channel
# channels = [{"channel": "opt-summary", "uly": "BTC-USD"}]
# 资金费率频道 Funding Rate Channel
# channels = [{"channel": "funding-rate", "instId": "BTC-USD-SWAP"}]
# 指数K线频道 Index Candlesticks Channel
# channels = [{"channel": "index-candle1m", "instId": "BTC-USDT"}]
# 指数行情频道 Index Tickers Channel
# channels = [{"channel": "index-tickers", "instId": "BTC-USDT"}]
# status频道 Status Channel
# channels = [{"channel": "status"}]

'''
私有频道 private channel
:param channel: 频道名
:param ccy: 币种
:param instType: 产品类型
:param uly: 合约标的指数
:param instId: 产品ID

'''

# 账户频道 Account Channel
# channels = [{"channel": "account", "ccy": "BTC"}]
# 持仓频道 Positions Channel
# channels = [{"channel": "positions", "instType": "FUTURES", "uly": "BTC-USDT", "instId": "BTC-USDT-210326"}]
# 余额和持仓频道 Balance and Position Channel
# channels = [{"channel": "balance_and_position"}]
# 订单频道 Order Channel
# channels = [{"channel": "orders", "instType": "FUTURES", "uly": "BTC-USD", "instId": "BTC-USD-201225"}]
# 策略委托订单频道 Algo Orders Channel
# channels = [{"channel": "orders-algo", "instType": "FUTURES", "uly": "BTC-USD", "instId": "BTC-USD-201225"}]
#高级策略委托订单频道 Cancel Advance Algos
# channels = [{"channel": "algo-advance", "instType": "SPOT","instId": "BTC-USD-201225","algoId":"12345678"}]
# 爆仓风险预警推送频道
# channels = [{"channel": "liquidation-warning", "instType": "SWAP","instType": "","uly":"","instId":""}]

'''
交易 trade
'''

# 下单 Place Order
# trade_param = {"id": "1512", "op": "order", "args": [{"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19777", "sz": "1"}]}
# 批量下单 Place Multiple Orders
# trade_param = {"id": "1512", "op": "batch-orders", "args": [
#         {"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19666", "sz": "1"},
#         {"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19633", "sz": "1"}
#     ]}
# 撤单 Cancel Order
# trade_param = {"id": "1512", "op": "cancel-order", "args": [{"instId": "BTC-USDT", "ordId": "259424589042823169"}]}
# 批量撤单 Cancel Multiple Orders
# trade_param = {"id": "1512", "op": "batch-cancel-orders", "args": [
#         {"instId": "BTC-USDT", "ordId": "259432098826694656"},
#         {"instId": "BTC-USDT", "ordId": "259432098826694658"}
#     ]}
# 改单 Amend Order
# trade_param = {"id": "1512", "op": "amend-order", "args": [{"instId": "BTC-USDT", "ordId": "259432767558135808", "newSz": "2"}]}
# 批量改单 Amend Multiple Orders
# trade_param = {"id": "1512", "op": "batch-amend-orders", "args": [
#         {"instId": "BTC-USDT", "ordId": "259435442492289024", "newSz": "2"},
#         {"instId": "BTC-USDT", "ordId": "259435442496483328", "newSz": "3"}
#     ]}


# 输出频道推送
async def print_yield(async_generator, *args):
    # async_generator为异步生成器，当频道推送时迭代
    async for item in async_generator(*args):
        print(item)
        # 其他相应操作如判断、储存


if __name__ == '__main__':
    loop = asyncio.get_event_loop()

    # 公共频道 不需要登录（行情，持仓总量，K线，标记价格，深度，资金费率等）subscribe public channel
    loop.run_until_complete(print_yield(subscribe_without_login, url, channels, True))

    # 私有频道 需要登录（账户，持仓，订单等）subscribe private channel
    loop.run_until_complete(print_yield(subscribe, url, api_key, passphrase, secret_key, channels, True))

    # 交易（下单，撤单，改单等）trade
    trade_param = {}
    loop.run_until_complete(print_yield(trade, url, api_key, passphrase, secret_key, trade_param, True))

    loop.close()
