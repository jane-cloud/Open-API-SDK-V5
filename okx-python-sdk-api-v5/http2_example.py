import asyncio
import json
import time

import okx_http2.Account_api as Account
import okx_http2.Funding_api as Funding
import okx_http2.Market_api as Market
import okx_http2.Public_api as Public
import okx_http2.Trade_api as Trade
import okx_http2.TradingData_api as TradingData
import okx_http2.subAccount_api as SubAccount
import okx.Broker_api as Broker

async def http2_request(request, parameters):
    while 1:
        begin = time.time()
        if type(parameters) is list:
            result = request(*parameters)
        else:
            result = request(**parameters)

        end = time.time()
        cost = end - begin
        print(f'request_cost:{cost}\nresponse_body:{json.dumps(result)}')


api_key = ""
secret_key = ""
passphrase = ""
# flag是实盘与模拟盘的切换参数 flag is the key parameter which can help you to change between demo and real trading.
# flag = '1'  # 模拟盘 demo trading
flag = '0'  # 实盘 real tradiang

if __name__ == '__main__':
    # account api
    accountAPI = Account.AccountAPI(api_key, secret_key, passphrase, False, flag)
    # 查看账户持仓风险 GET Position_risk
    # request = accountAPI.get_position_risk
    # parameters = ['SWAP']
    # 查看账户余额  Get Balance
    # request = accountAPI.get_account
    # parameters = ['BTC']
    # 查看持仓信息  Get Positions
    # request = accountAPI.get_positions
    # parameters = ['FUTURES', 'BTC-USD-210402']
    # 账单流水查询（近七天） Get Bills Details (recent 7 days)
    # request = accountAPI.get_bills_detail
    # parameters = ['FUTURES', 'BTC', 'cross']
    # 账单流水查询（近三个月） Get Bills Details (recent 3 months)
    # request = accountAPI.get_bills_details
    # parameters = ['FUTURES', 'BTC','cross']
    # 查看账户配置  Get Account Configuration
    # request = accountAPI.get_account_config
    # parameters = []
    # 设置持仓模式  Set Position mode
    # request = accountAPI.get_position_mode
    # parameters = ['long_short_mode']
    # 设置杠杆倍数  Set Leverage
    # request = accountAPI.set_leverage
    # parameters = {'instId': 'BTC-USDT', 'lever': '10', 'mgnMode': 'cross'}
    # 获取最大可交易数量  Get Maximum Tradable Size For Instrument
    # request = accountAPI.get_maximum_trade_size
    # parameters = ['BTC-USDT-210402', 'cross', 'USDT']
    # 获取最大可用数量  Get Maximum Available Tradable Amount
    # request = accountAPI.get_max_avail_size
    # parameters = ['BTC-USDT-210402', 'isolated', 'BTC']
    # 调整保证金  Increase/Decrease margint
    # request = accountAPI.Adjustment_margin
    # parameters = ['BTC-USDT-210409', 'long', 'add', '100']
    # 获取杠杆倍数 Get Leverage
    # request = accountAPI.get_leverage
    # parameters = ['BTC-USDT', 'isolated']
    # 获取币币逐仓杠杆最大可借  Get the maximum loan of isolated MARGIN
    # request = accountAPI.get_max_load
    # parameters = ['BTC-USDT', 'cross', 'BTC']
    # 获取当前账户交易手续费费率  Get Fee Rates
    # request = accountAPI.get_fee_rates
    # parameters = {'instType': 'FUTURES', 'category': '1'}
    # 获取计息记录  Get interest-accrued
    # request = accountAPI.get_interest_accrued
    # parameters = ['BTC-USDT', 'BTC', 'isolated', '', '', '10']
    # 获取用户当前杠杆借币利率 Get Interest-accrued
    # request = accountAPI.get_interest_rate
    # parameters = []
    # 期权希腊字母PA / BS切换  Set Greeks (PA/BS)
    # request = accountAPI.set_greeks
    # parameters = ['BS']
    # 逐仓交易设置 Set Isolated Mode
    # result = accountAPI.set_isolated_mode
    # parameters = []
    # 查看账户最大可转余额  Get Maximum Withdrawals
    # request = accountAPI.get_max_withdrawal
    # parameters = []
    # 尊享借币还币 GET Enjoy borrowing and returning money
    # request = accountAPI.borrow_repay
    # parameters = []
    # 获取尊享借币还币历史 Get the privileged currency borrowing and repayment history
    # request = accountAPI.get_borrow_repay_history
    # parameters = []
    # 获取借币利率与限额 GET Obtain borrowing rate and limit
    # request = accountAPI.get_interest_limits
    # parameters = []
    # 组合保证金的虚拟持仓保证金计算 POST Simulated Margin
    # result = accountAPI.get_simulated_margin
    # parameters = []
    # 查看账户Greeks GET GREEKS
    # result = accountAPI.get_greeks()

    # funding api
    fundingAPI = Funding.FundingAPI(api_key, secret_key, passphrase, False, flag)
    # 获取充值地址信息  Get Deposit Address
    # request = fundingAPI.get_deposit_address
    # parameters = []
    # 获取资金账户余额信息  Get Balance
    # request = fundingAPI.get_balances
    # parameters = ['BTC']
    # 资金划转  Funds Transfer
    # request = fundingAPI.funds_transfer
    # parameters = {'ccy': '', 'amt': '', 'type': '', 'from': '', 'to': '', 'subAcct': ''}
    # 获取资金划转状态 Transfer State
    # result = fundingAPI.transfer_state
    # parameters = {}
    # 提币  Withdrawal
    # request = fundingAPI.coin_withdraw
    # parameters = ['usdt', '2', '3', '', '', '0']
    # 获取充值记录  Get Deposit History
    # request = fundingAPI.get_deposit_history
    # parameters = []
    # 撤销提币 CANCEL_WITHDRAWAL
    # result = fundingAPI.cancel_withdrawal
    # parameters = ['BTC']
    # 获取提币记录  Get Withdrawal History
    # request = fundingAPI.get_withdrawal_history
    # parameters = []
    # 小额资产兑换 CONVERT_DUST_ASSETS
    # result = fundingAPI.convert_dust_assets
    # parameters = []
    # 获取币种列表  Get Currencies
    # request = fundingAPI.get_currency
    # parameters = []
    # 余币宝申购/赎回  PiggyBank Purchase/Redemption
    # request = fundingAPI.purchase_redempt
    # parameters = ['BTC', '1', 'purchase']
    # 资金流水查询  Asset Bills Details
    # request = fundingAPI.get_bills
    # parameters = []
    # 获取余币宝余额 PIGGY BALABCE
    # result = fundingAPI.get_piggy_balance
    # parameters = []
    # 闪电网络充币
    # result = fundingAPI.get_deposit_lightning
    # 闪电网络提币
    # result = fundingAPI.withdrawal_lightning
    # parameters =[]
    # 获取账户资产估值 GET Obtain account asset valuation
    # result = fundingAPI.get_asset_valuation
    # parameters =[]
    # 设置余币宝借贷利率 POST SET LENDING RATE
    # result = fundingAPI.set_lending_rate
    # parameters =[]
    # 获取余币宝出借明细 GET LENDING HISTORY
    # result = fundingAPI.get_lending_rate
    # parameters =[]
    # 获取市场借贷信息（公共) GET LENDING RATE HISTORY
    # result = fundingAPI.get_lending_rate_history
    # parameters =[]
    # 获取市场借贷历史（公共）GET LENDING RATE SUMMARY
    # result = fundingAPI.get_lending_rate_summary
    # parameters =[]

    # convert api
    convertAPI = Convert.ConvertAPI(api_key, secret_key, passphrase, False, flag)
    # 获取闪兑币种列表  Get Currencies
    # result = convertAPI.get_currencies
    # parameters = []
    # 获取闪兑币对信息  Get Currency-pair
    # result = convertAPI.get_currency_pair
    # parameters = []
    # 闪兑预估询价  Estimate-quote
    # result = convertAPI.estimate_quote
    # parameters = []
    # 闪兑交易  Convert-trade
    # result = convertAPI.convert_trade
    # parameters = []
    # 获取闪兑交易历史  Get Convert-history
    # result = convertAPI.get_convert_history
    # parameters = []

    # market api
    marketAPI = Market.MarketAPI(api_key, secret_key, passphrase, False, flag)
    # 获取所有产品行情信息  Get Tickers
    # request = marketAPI.get_tickers
    # parameters = ['SPOT']
    # 获取单个产品行情信息  Get Ticker
    # request = marketAPI.get_ticker
    # parameters = ['BTC-USDT']
    # 获取指数行情  Get Index Tickers
    # request = marketAPI.get_index_ticker
    # parameters = ['BTC', 'BTC-USD']
    # 获取产品深度  Get Order Book
    # request = marketAPI.get_orderbook
    # parameters = ['BTC-USDT', '400']
    # 获取所有交易产品K线数据  Get Candlesticks
    # request = marketAPI.get_candlesticks
    # parameters = ['BTC-USDT-210924']
    # 获取交易产品历史K线数据（仅主流币实盘数据）  Get Candlesticks History（top currencies in real-trading only）
    # request = marketAPI.get_history_candlesticks
    # parameters = ['BTC-USDT']
    # 获取指数K线数据  Get Index Candlesticks
    # request = marketAPI.get_index_candlesticks
    # parameters = ['BTC-USDT']
    # 获取标记价格K线数据  Get Mark Price Candlesticks
    # request = marketAPI.get_markprice_candlesticks
    # parameters = ['BTC-USDT']
    # 获取交易产品公共成交数据  Get Trades
    # request = marketAPI.get_trades
    # parameters = ['BTC-USDT', '400']
    # 获取平台24小时成交总量  Get Platform 24 Volume
    # request = marketAPI.get_volume
    # parameters = []a
    # Oracle 上链交易数据 GET Oracle
    # request = marketAPI.get_oracle
    # parameters = []
    # 获取法币汇率 GET exchange rate in legal currency
    # request = marketAPI.get_exchange_rate
    # parameters = []

    # public api
    publicAPI = Public.PublicAPI(api_key, secret_key, passphrase, False, flag)
    # 获取交易产品基础信息  Get instrument
    # request = publicAPI.get_instruments
    # parameters = ['FUTURES', 'BTC-USDT']
    # 获取交割和行权记录  Get Delivery/Exercise History
    # request = publicAPI.get_deliver_history
    # parameters = ['FUTURES', 'BTC-USD']
    # 获取持仓总量  Get Open Interest
    # request = publicAPI.get_open_interest
    # parameters = ['SWAP']
    # 获取永续合约当前资金费率  Get Funding Rate
    # request = publicAPI.get_funding_rate
    # parameters = ['BTC-USD-SWAP']
    # 获取永续合约历史资金费率  Get Funding Rate History
    # request = publicAPI.funding_rate_history
    # parameters = ['BTC-USD-SWAP']
    # 获取限价  Get Limit Price
    # request = publicAPI.get_price_limit
    # parameters = ['BTC-USDT']
    # 获取期权定价  Get Option Market Data
    # request = publicAPI.get_opt_summary
    # parameters = ['BTC-USD']
    # 获取预估交割/行权价格  Get Estimated Delivery/Excercise Price
    # request = publicAPI.get_estimated_price
    # parameters = ['ETH-USD-210611']
    # 获取免息额度和币种折算率  Get Discount Rate And Interest-Free Quota
    # request = publicAPI.discount_interest_free_quota
    # parameters = []
    # 获取系统时间  Get System Time
    # request = publicAPI.get_system_time
    # parameters = []
    # 获取平台公共爆仓单信息  Get Liquidation Orders
    # request = publicAPI.get_liquidation_orders
    # parameters = {'instType': 'FUTURES', 'uly': 'BTC-USDT', 'alias': 'next_quarter', 'state': 'filled'}
    # 获取标记价格  Get Mark Price
    # request = publicAPI.get_mark_price
    # parameters = ['FUTURES']
    # 获取合约衍生品仓位档位 Get Tier
    # request = publicAPI.get_tier
    # parameters = {'instType': 'MARGIN', 'instId': 'BTC-USDT', 'tdMode': 'cross'}
    # 获取尊享借币杠杆利率和借币限额 GET Obtain the privileged currency borrowing leverage rate and currency borrowing limit
    # request = publicAPI.get_vip_interest_rate_loan_quota
    # parameters = {}

    # 交易数据API Trading data API
    tradingDataAPI = TradingData.TradingDataAPI(api_key, secret_key, passphrase, False, flag)
    # 获取支持币种 Get support coin
    # request = tradingDataAPI.get_support_coin
    # parameters ={}
    # 获取币币或衍生品主动买入/卖出情况 Get taker volume
    # request = tradingDataAPI.get_taker_volume
    # parameters = {'ccy': 'BTC', 'instType': 'SPOT', 'period': '5m'}
    # 获取杠杆多空比 Get Margin lending ratio
    # request = tradingDataAPI.get_margin_lending_ratio
    # parameters = {'ccy': 'BTC', 'period': '5m'}
    # 获取多空持仓人数比 Get Long/Short ratio
    # request = tradingDataAPI.get_long_short_ratio
    # parameters = ['BTC']
    # 获取持仓总量及交易量 Get contracts open interest and volume
    # request = tradingDataAPI.get_contracts_interest_volume
    # parameters = ['BTC']
    # 获取期权合约持仓总量及交易量 Get Options open interest and volume
    # request = tradingDataAPI.get_options_interest_volume
    # parameters = ['BTC']
    # 看涨/看跌期权合约 持仓总量比/交易总量比 Get Put/Call ratio
    # request = tradingDataAPI.get_put_call_ratio
    # parameters = ['BTC']
    # 看涨看跌持仓总量及交易总量（按到期日分） Get open interest and volume (expiry)
    # request = tradingDataAPI.get_interest_volume_expiry
    # parameters = ['BTC']
    # 看涨看跌持仓总量及交易总量（按执行价格分）Get open interest and volume (strike)
    # request = tradingDataAPI.get_interest_volume_strike
    # parameters = ['BTC', '20210924']
    # 看跌/看涨期权合约 主动买入/卖出量  Get Taker flow
    # request = tradingDataAPI.get_taker_flow
    # parameters = ['BTC']

    # trade api
    tradeAPI = Trade.TradeAPI(api_key, secret_key, passphrase, False, flag)
    # 下单  Place Order
    # request = tradeAPI.place_order
    # parameters = {'instId': '', 'tdMode': '', 'side': '', 'ordType': '', 'px': '','posSide':'', 'sz': '','tgtCcy':''}
    # 批量下单  Place Multiple Orders
    # request = tradeAPI.place_multiple_orders
    # parameters = [[
    #     {'instId': 'BTC-USD-210402', 'tdMode': 'isolated', 'side': 'buy', 'ordType': 'limit', 'sz': '1', 'px': '17400',
    #      'posSide': 'long',
    #      'clOrdId': 'a12344', 'tag': 'test1210','tgtCcy':''},
    #     {'instId': 'BTC-USD-210409', 'tdMode': 'isolated', 'side': 'buy', 'ordType': 'limit', 'sz': '1', 'px': '17359',
    #      'posSide': 'long',
    #      'clOrdId': 'a12344444', 'tag': 'test1211','tgtCcy':''}
    # ]]

    # 撤单  Cancel Order
    # request = tradeAPI.cancel_order
    # parameters = ['BTC-USD-201225', '257164323454332928']
    # 批量撤单  Cancel Multiple Orders
    # request = tradeAPI.cancel_multiple_orders
    # parameters = [[
    #     {"instId": "BTC-USD-210402", "ordId": "297389358169071616"},
    #     {"instId": "BTC-USD-210409", "ordId": "297389358169071617"}
    # ]]

    # 修改订单  Amend Order
    # request = tradeAPI.amend_order
    # parameters = ['BTC-USDT']
    # 批量修改订单  Amend Multiple Orders
    # request = tradeAPI.amend_multiple_orders
    # parameters = [[{'instId': 'BTC-USD-201225', 'cxlOnFail': 'false', 'ordId': '257551616434384896', 'newPx': '17880'},
    #                {'instId': 'BTC-USD-201225', 'cxlOnFail': 'false', 'ordId': '257551616652488704', 'newPx': '17882'}
    #                ]]
    # 市价仓位全平  Close Positions
    # request = tradeAPI.close_positions
    # parameters = ['BTC-USDT-210409', 'isolated', 'long']
    # 获取订单信息  Get Order Details
    # request = tradeAPI.get_orders
    # parameters = ['BTC-USD-201225', '257173039968825345']
    # 获取未成交订单列表  Get Order List
    # request = tradeAPI.get_order_list
    # parameters = []
    # 获取历史订单记录（近七天） Get Order History (last 7 days）
    # request = tradeAPI.get_orders_history
    # parameters = ['FUTURES']
    # 获取历史订单记录（近三个月） Get Order History (last 3 months)
    # request = tradeAPI.orders_history_archive
    # parameters = ['FUTURES']
    # 获取成交明细(三天)  Get Transaction Details
    # request = tradeAPI.get_fills
    # parameters = []
    # 获取成交明细(三个月)  Get Transaction Details History
    # result = tradeAPI.get_fills_history
    # parameters = ['SPOT']
    # 策略委托下单  Place Algo Order
    # request = tradeAPI.place_algo_order
    # parameters = {'instId': 'BTC-USDT', 'side': 'buy', 'ordType': 'conditional', 'sz': '1', 'tpTriggerPx': '1','tdMode':'cash'
    #                ,'tpOrdPx': '1','tgtCcy':'', 'tpTriggerPxType':'last', 'slTriggerPxType':'last'}
    # 撤销策略委托订单  Cancel Algo Order
    # request = tradeAPI.cancel_algo_order
    # parameters = [[{'algoId': '297394002194735104', 'instId': 'BTC-USDT-210409'}]]
    #撤销高级策略委托订单
    # result = tradeAPI.cancel_advance_algos
    # parameters = [{"algoId":"198273485","instId":"BTC-USDT"}]
    # 获取未完成策略委托单列表  Get Algo Order List
    # request = tradeAPI.order_algos_list
    # parameters = {'ordType': 'conditional', 'instType': 'FUTURES'}
    # 获取历史策略委托单列表  Get Algo Order History
    # request = tradeAPI.order_algos_history
    # parameters = {'ordType': 'conditional', 'instType': 'FUTURES', 'state': 'canceled'}

    # 子账户API subAccount
    subAccountAPI = SubAccount.SubAccountAPI(api_key, secret_key, passphrase, False, flag)
    # 查询子账户的交易账户余额(适用于母账户) Query detailed balance info of Trading Account of a sub-account via the master account
    # request = subAccountAPI.balances
    # parameters = {'subAcct': ''}
    # 查询子账户转账记录(仅适用于母账户) History of sub-account transfer(applies to master accounts only)
    # request = subAccountAPI.bills
    # parameters = []
    # 删除子账户APIKey(仅适用于母账户) Delete the APIkey of sub-accounts (applies to master accounts only)
    # request = subAccountAPI.delete
    # parameters = {'pwd': '', 'subAcct': '', 'apiKey': ''}
    # 重置子账户的APIKey(仅适用于母账户) Reset the APIkey of a sub-account(applies to master accounts only)
    # request = subAccountAPI.reset
    # parameters = {'pwd': '', 'subAcct': '', 'label': '', 'perm': '', 'apiKey': ''}
    # 创建子账户的APIKey(仅适用于母账户) Create an APIkey for a sub-account(applies to master accounts only)
    # request = subAccountAPI.create
    # parameters = {'pwd': '', 'subAcct': '', 'label': '', 'Passphrase': ''}
    # 查询子账户的APIKey(仅适用于母账户) Create an APIkey for a sub-account(applies to master accounts only)
    # result = subAccountAPI.watch
    # parameters = []
    # 查看子账户列表(仅适用于母账户) View sub-account list(applies to master accounts only)
    # request = subAccountAPI.view_list
    # parameters = []
    # 子账户间划转 Transfer between subAccounts
    # result = subAccountAPI.subAccount_transfer
    # parameters = []

    # BrokerAPI
    BrokerAPI = Broker.BrokerAPI(api_key, secret_key, passphrase, False, flag)
    # 获取独立经纪商账户信息 GET Obtain independent broker account information
    # request = BrokerAPI.broker_info
    # parameters = []
    # 创建子账户 Create sub account
    # request = BrokerAPI.create_subaccount
    # parameters = []
    # 删除子账户 Delete sub account
    # request = BrokerAPI.delete_subaccount
    # parameters = []
    # 获取子账户列表 Get sub account list
    # request = BrokerAPI.subaccount_info
    # parameters = []
    # 设置子账户的账户等级 Set account level of sub account
    # request = BrokerAPI.set_subaccount_level
    # parameters = []
    # 设置子账户的交易手续费费率 Set transaction fee rate of sub account
    # request = BrokerAPI.set_subaccount_fee_rate
    # parameters = []
    # 创建子账户充值地址 Create sub account recharge address
    # request = BrokerAPI.subaccount_deposit_address
    # parameters = []
    # 获取子账户获取充值记录 Get sub account recharge record
    # request = BrokerAPI.subaccount_deposit_history
    # parameters = []
    # 获取子账户返佣记录 Get rebate record of sub account
    # request = BrokerAPI.rebate_daily
    # parameters = []

    loop = asyncio.get_event_loop()
    loop.run_until_complete(http2_request(request, parameters))
    loop.close()
