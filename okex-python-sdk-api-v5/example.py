import okex.Account_api as Account
import okex.Funding_api as Funding
import okex.Market_api as Market
import okex.Public_api as Public
import okex.Trade_api as Trade
import json


if __name__ == '__main__':
    api_key = ""
    seceret_key = ""
    passphrase = ""

    # account api
    accountAPI = Account.AccountAPI(api_key, seceret_key, passphrase, False)
    # 查看账户余额  Get Balance
    # result = accountAPI.get_account('')
    # 查看持仓信息  Get Positions
    # result = accountAPI.get_positions('', '')
    # 账单流水查询（近七天） Get Bills Details (recent 7 days)
    # result = accountAPI.get_bills_detail('', '')
    # 账单流水查询（近三个月） Get Bills Details (recent 3 months)
    # result = accountAPI.get_bills_details('', '')
    # 查看账户配置  Get Account Configuration
    # result = accountAPI.get_account_config()
    # 设置持仓模式  Set Position mode
    # result = accountAPI.get_position_mode('long_short_mode')
    # 设置杠杆倍数  Set Leverage
    # result = accountAPI.set_leverage('5', 'cross', 'BTC-USDT')
    # 获取最大可交易数量  Get Maximum Tradable Size For Instrument
    # result = accountAPI.get_maximum_trade_size('BTC-USDT-201225', 'cross', 'USDT')
    # 获取最大可用数量  Get Maximum Available Tradable Amount
    # result = accountAPI.get_max_avail_size('BTC-USDT-201225', 'isolated', 'BTC')
    # 调整保证金  Increase/Decrease margint
    # result = accountAPI.Adjustment_margin('BTC-USDT-201225', 'long', 'add', '1')
    # 获取杠杆倍数 Get Leverage
    # result = accountAPI.get_leverage('BTC-USDT-201225', 'isolated')
    # 获取币币逐仓杠杆最大可借  Get the maximum loan of isolated MARGIN
    # result = accountAPI.get_max_load('BTC-USDT')
    # 获取当前账户交易手续费费率  Get Fee Rates
    # result = accountAPI.get_fee_rates('SPOT', '', category='1')
    # 获取计息记录  Get interest-accrued
    # result = accountAPI.get_interest_accrued('BTC-USDT', 'BTC', 'isolated', '', '', '10')
    # 期权希腊字母PA / BS切换  Set Greeks (PA/BS)
    # result = accountAPI.set_greeks('BS')
    # 查看账户最大可转余额  Get Maximum Withdrawals
    # result = accountAPI.get_max_withdrawal('BTC')

    # funding api
    fundingAPI = Funding.FundingAPI(api_key, seceret_key, passphrase, False)
    # 获取充值地址信息  Get Deposit Address
    # result = fundingAPI.get_deposit_address('BTC')
    # 获取资金账户余额信息  Get Balance
    # result = fundingAPI.get_balances()
    # 资金划转  Funds Transfer
    # result = fundingAPI.funds_transfer('usdt', '1', '1', '3')
    # 提币  Withdrawal
    # result = fundingAPI.coin_withdraw('usdt', '2', '3', '', '', '0')
    # 充值记录  Get Deposit History
    # result = fundingAPI.get_deposit_history()
    # 提币记录  Get Withdrawal History
    # result = fundingAPI.get_withdrawal_history()
    # 获取币种列表  Get Currencies
    # result = fundingAPI.get_currency()
    # 余币宝申购/赎回  PiggyBank Purchase/Redemption
    # result = fundingAPI.purchase_redempt('BTC', '1', 'purchase')
    # 资金流水查询  Asset Bills Details
    # result = fundingAPI.get_bills('BTC')

    # market api
    marketAPI = Market.MarketAPI(api_key, seceret_key, passphrase, False)
    # 获取所有产品行情信息  Get Tickers
    # result = marketAPI.get_tickers('SWAP', 'BTC-USD')
    # 获取单个产品行情信息  Get Ticker
    # result = marketAPI.get_ticker('BTC-USDT-SWAP')
    # 获取指数行情  Get Index Tickers
    # result = marketAPI.get_index_ticker('BTC')
    # 获取产品深度  Get Order Book
    # result = marketAPI.get_orderbook('BTC-USDT')
    # 获取所有交易产品K线数据  Get Candlesticks
    # result = marketAPI.get_candlesticks('BTC-USDT')
    # 获取交易产品历史K线数据（仅主流币）  Get Candlesticks History（top currencies only）
    # result = marketAPI.get_history_candlesticks('BTC-USD-SWAP')
    # 获取指数K线数据  Get Index Candlesticks
    # result = marketAPI.get_index_candlesticks('BTC-USDT')
    # 获取标记价格K线数据  Get Mark Price Candlesticks
    # result = marketAPI.get_markprice_candlesticks('BTC-USDT')
    # 获取交易产品公共成交数据  Get Trades
    # result = marketAPI.get_trades('BTC-USDT')

    # public api
    publicAPI = Public.PublicAPI(api_key, seceret_key, passphrase, False)
    # 获取交易产品基础信息  Get instrument
    # result = publicAPI.get_instruments('SPOT')
    # 获取交割和行权记录  Get Delivery/Exercise History
    # result = publicAPI.get_deliver_history('FUTURES', 'BTC-USD')
    # 获取持仓总量  Get Open Interest
    # result = publicAPI.get_open_interest('FUTURES')
    # 获取永续合约当前资金费率  Get Funding Rate
    # result = publicAPI.get_funding_rate('BTC-USD-SWAP')
    # 获取永续合约历史资金费率  Get Funding Rate History
    # result = publicAPI.funding_rate_history('BTC-USD-SWAP')
    # 获取限价  Get Limit Price
    # result = publicAPI.get_price_limit('BTC-USD-SWAP')
    # 获取期权定价  Get Option Market Data
    # result = publicAPI.get_opt_summary('BTC-USD')
    # 获取预估交割/行权价格  Get Estimated Delivery/Excercise Price
    # result = publicAPI.get_estimated_price('BTC-USD-201225')
    # 获取免息额度和币种折算率  Get Discount Rate And Interest-Free Quota
    # result = publicAPI.discount_interest_free_quota('')
    # 获取系统时间  Get System Time
    # result = publicAPI.get_system_time()
    # 获取平台公共爆仓单信息  Get Liquidation Orders
    # result = publicAPI.get_liquidation_orders('SWAP', uly='BTC-USD')
    # 获取标记价格  Get Mark Price
    # result = publicAPI.get_mark_price('MARGIN')

    # trade api
    tradeAPI = Trade.TradeAPI(api_key, seceret_key, passphrase, False)
    # 下单  Place Order
    # result = tradeAPI.place_order('BTC-USDT', 'cash', 'buy', 'limit', '1', px='17896')
    # 批量下单  Place Multiple Orders
    # result = tradeAPI.place_multiple_orders([
    #     {'instId': 'BTC-USD-201225', 'tdMode': 'isolated', 'side': 'buy', 'ordType': 'limit', 'sz': '1', 'px': '17400', 'posSide': 'long',
    #      'clOrdId': 'a123', 'tag': 'test1210'},
    #     {'instId': 'BTC-USD-201225', 'tdMode': 'isolated', 'side': 'buy', 'ordType': 'limit', 'sz': '1', 'px': '17359', 'posSide': 'long',
    #      'clOrdId': 'a1234', 'tag': 'test1211'}
    # ])

    # 撤单  Cancel Order
    # result = tradeAPI.cancel_order('BTC-USD-201225', '257164323454332928')
    # 批量撤单  Cancel Multiple Orders
    # result = tradeAPI.cancel_multiple_orders([
    #     {"instId": "BTC-USD-201225", "ordId": "257173039964631040"},
    #     {"instId": "BTC-USD-201225", "ordId": "257173039968825345"}
    # ])

    # 修改订单  Amend Order
    # result = tradeAPI.amend_order('BTC-USDT', 'false', '260420008988258304', newSz='3')
    # 批量修改订单  Amend Multiple Orders
    # result = tradeAPI.amend_multiple_orders(
    #     [{'instId': 'BTC-USD-201225', 'cxlOnFail': 'false', 'ordId': '257551616434384896', 'newPx': '17880'},
    #      {'instId': 'BTC-USD-201225', 'cxlOnFail': 'false', 'ordId': '257551616652488704', 'newPx': '17882'}
    #      ])

    # 市价仓位全平  Close Positions
    # result = tradeAPI.close_postions('BTC-USD-201225', 'isolated', 'long', '')
    # 获取订单信息  Get Order Details
    # result = tradeAPI.get_orders('BTC-USD-201225', '257173039968825345')
    # 获取未成交订单列表  Get Order List
    # result = tradeAPI.get_order_list()
    # 获取历史订单记录（近七天） Get Order History (last 7 days）
    # result = tradeAPI.get_orders_history('FUTURES')
    # 获取历史订单记录（近三个月） Get Order History (last 3 months)
    # result = tradeAPI.orders_history_archive('FUTURES')
    # 获取成交明细  Get Transaction Details
    # result = tradeAPI.get_fills()
    # 策略委托下单  Place Algo Order
    # result = tradeAPI.place_algo_order('BTC-USDT-201225', 'isolated', 'buy', 'trigger', '1', posSide='long', triggerPx='19300', orderPx='19270')
    # 撤销策略委托订单  Cancel Algo Order
    # result = tradeAPI.cancel_algo_order([{'algoId': '258550365751226368', 'instId': 'BTC-USDT-201225'}])
    # 获取未完成策略委托单列表  Get Algo Order List
    # result = tradeAPI.order_algos_list('trigger', instType='FUTURES')
    # 获取历史策略委托单列表  Get Algo Order History
    # result = tradeAPI.order_algos_history('trigger', 'canceled', instType='FUTURES')

    print(json.dumps(result))
