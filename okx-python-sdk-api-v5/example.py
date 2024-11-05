import json

import okx.Account_api as Account
import okx.Funding_api as Funding
import okx.Market_api as Market
import okx.Public_api as Public
import okx.Trade_api as Trade
import okx.status_api as Status
import okx.subAccount_api as SubAccount
import okx.TradingData_api as TradingData
import okx.Broker_api as Broker
import okx.Convert_api as Convert
import okx.FDBroker_api as FDBroker
import okx.Rfq_api as Rfq
import okx.TradingBot_api as TradingBot
import okx.Finance_api as Finance
import okx.Copytrading_api as Copytrading
import okx.Recurring_api as Recurring
import okx.SprdApi_api as Sprd
import okx.Singal_api as Signal

if __name__ == '__main__':
    api_key = ""
    secret_key = ""
    passphrase = ""

    # flag是实盘与模拟盘的切换参数 flag is the key parameter which can help you to change between demo and real trading.
    flag = '1'  # 模拟盘 demo trading
    # flag = '0'  # 实盘 real trading

    # account api
    accountAPI = Account.AccountAPI(api_key, secret_key, passphrase, False, flag)
    # 获取交易产品基础信息
    # result = accountAPI.get_account_instruments(instType = 'SWAP', uly = '', instFamily = '', instId = '')
    # 查看账户持仓风险 GET Position_risk
    # result = accountAPI.get_position_risk('SWAP')
    # 查看账户余额  Get Balance
    # result = accountAPI.get_account('BTC')
    # 查看持仓信息  Get Positions
    # result = accountAPI.get_positions('FUTURES', 'BTC-USD-210402')
    # 查看历史持仓信息
    # result = accountAPI.get_positions_history(instType = '', instId = '', mgnMode = '', type = '', after = '', before = '', limit = '', posId = '359410150083538946')
    # 账单流水查询（近七天） Get Bills Details (recent 7 days)
    # result = accountAPI.get_bills_detail(instType = 'SWAP', ccy = 'BTC', mgnMode = 'cross', instId = 'BTC-USDT-SWAP')
    # 账单流水查询（近三个月） Get Bills Details (recent 3 months)
    # result = accountAPI.get_bills_details('FUTURES', 'BTC', 'cross')
    # 查看账户配置  Get Account Configuration
    # result = accountAPI.get_account_config()
    # 设置持仓模式  Set Position mode
    # result = accountAPI.get_position_mode('long_short_mode')
    # 设置杠杆倍数  Set Leverage
    # result = accountAPI.set_leverage(instId='BTC-USD-210402', lever='10', mgnMode='cross')
    # 获取最大可交易数量  Get Maximum Tradable Size For Instrument
    # result = accountAPI.get_maximum_trade_size(instId='BTC-USDT-SWAP', tdMode='cross',ccy='',px='',leverage='10',unSpotOffset='false')
    # 获取最大可用数量  Get Maximum Available Tradable Amount
    # result = accountAPI.get_max_avail_size(instId='BTC-USDT-SWAP', tdMode='isolated', ccy='BTC', reduceOnly='', unSpotOffset='false',quickMgnType='')
    # 调整保证金  Increase/Decrease margint
    # result = accountAPI.Adjustment_margin('BTC-USDT-210409', 'long', 'add', '100')
    # 获取杠杆倍数 Get Leverage
    # result = accountAPI.get_leverage(instId = 'BTC-USDT-SWAP', mgnMode = 'isolated', ccy = '')
    # 获取交易产品最大可借  Get the maximum loan of instrument
    # result = accountAPI.get_max_load('BTC-USDT', 'cross', 'BTC')
    # 获取当前账户交易手续费费率  Get Fee Rates
    # result = accountAPI.get_fee_rates(instType = 'FUTURES',instId = '', category='1',instFamily = '',ruleType = '')
    # 获取计息记录  Get interest-accrued
    # result = accountAPI.get_interest_accrued('BTC-USDT', 'BTC', 'isolated', '', '', '10', '')
    # 获取用户当前杠杆借币利率 Get interest rate
    # result = accountAPI.get_interest_rate()
    # 期权希腊字母PA / BS切换  Set Greeks (PA/BS)
    # result = accountAPI.set_greeks('BS')
    # 逐仓交易设置 Set Isolated Mode
    # result = accountAPI.set_isolated_mode()
    # 查看账户最大可转余额  Get Maximum Withdrawals
    # result = accountAPI.get_max_withdrawal('')
    # 查看账户特定风险状态 Get account risk state (Only applicable to Portfolio margin account)
    # result = accountAPI.get_account_risk()
    # 一键借币模式手动借币还币
    # result = accountAPI.quick_margin_borrow_repay(instId='BTC-USDT', ccy='BTC', side='borrow', amt='1')
    # 获取一键借币还币历史
    # result = accountAPI.quick_margin_borrow_repay_history(instId='', ccy='', side='', after='', before='', begin='', end='', limit='')
    # 尊享借币还币 GET Enjoy borrowing and returning money
    # result = accountAPI.borrow_repay(ccy = 'BTC', side = 'borrow', amt = '10', ordId = '')
    # 获取尊享借币还币历史 Get the privileged currency borrowing and repayment history
    # result = accountAPI.get_borrow_repay_history(ccy = '', after = '', before = '', limit = '')
    # 获取尊享借币计息记录
    # result = accountAPI.vip_interest_accrued(ccy = '', ordId = '', after = '', before = '', limit = '')
    # 获取尊享借币扣息记录
    # result = accountAPI.vip_interest_deducted(ordId = '', ccy = '', after = '', before = '', limit = '')
    # 尊享借币订单列表
    # result = accountAPI.vip_loan_order_list(ordId = '', state = '', ccy = '', after = '', before = '', limit = '')
    # 尊享借币订单详情
    # result = accountAPI.vip_loan_order_detail(ordId = '123', ccy = '', after = '', before = '', limit = '')
    # 设置子账户尊享借币比率 POST SET LOAN ALLOCATION
    # result = accountAPI.set_loan_allocation(enable = 'true',subAcct = '',loanAlloc = '')
    # 获取子账户借币利率与限额 GET INTEREST LIMITS
    # result = accountAPI.insterst_limits(subAcct = '',ccy = '')
    # 获取借币利率与限额 GET Obtain borrowing rate and limit
    # result = accountAPI.get_interest_limits(type = '2', ccy = 'ETH')
    # 组合保证金的虚拟持仓保证金计算 POST Simulated Margin
    # result = accountAPI.get_simulated_margin(instType = '', inclRealPos = '', spotOffsetType = '', simPos = [{"instId":"BTC-USDT-SWAP","pos":"1"}])
    # 查看账户Greeks GET GREEKS
    # result = accountAPI.get_greeks()
    # 获取组合保证金模式全仓限制
    # result = accountAPI.position_tiers(instType = 'SWAP', uly = 'BTC-USDT')
    # 设置组合保证金账户风险对冲模式
    # result = accountAPI.set_riskOffset_type(type = '1')
    # 开通期权交易
    # result = accountAPI.activate_option()
    # 设置自动借币
    # result = accountAPI.set_auto_loan(autoLoan = '')
    # 重置 MMP 状态
    # result = accountAPI.mmp_reset()
    # 设置MMP
    # result = accountAPI.mmp_config(instFamily='',timeInterval='',frozenInterval='',qtyLimit='')
    # 查看 MMP 配置
    # result = accountAPI.mmp(instFamily='')
    # 设置账户模式 POST /api/v5/account/set-account-level
    # result  = accountAPI.set_account_level(acctLv='')
    # 仓位创建器 POST /api/v5/account/position-builder
    # result = accountAPI.position_builder()
    # 设置现货对冲占用 POST /api/v5/account/set-riskOffset-amt
    # result = accountAPI.set_riskOffset_amt(ccy = 'BTC', clSpotInUseAmt = '0.01')
    # 获取固定借币限额 GET /api/v5/account/fixed-loan/borrowing-limit
    # result = accountAPI.get_fixed_loan_borrowing_limit()
    # 获取固定借币询价 GET /api/v5/account/fixed-loan/borrowing-quote
    # result = accountAPI.get_fixed_loan_borrowing_quote(type = '', ccy = '', amt = '', maxRate = '', term = '', ordId = '')
    # 固定借币下单 POST /api/v5/account/fixed-loan/borrowing-order
    # result = accountAPI.fixed_loan_borrowing_order(ccy = '', amt = '', maxRate = '', term = '', reborrow = '', reborrowRate = '')
    # 修改固定借币订单 POST /api/v5/account/fixed-loan/amend-borrowing-order
    # result = accountAPI.fixed_loan_amend_borrowing_order(ordId = '111111111111', reborrow = '', renewMaxRate = '')
    # 固定借币手动续借 POST /api/v5/account/fixed-loan/manual-reborrow
    # result = accountAPI.fixed_loan_manual_reborrow(ordId = '111111111111', maxRate = '0.01')
    # 固定借币手动还币 POST /api/v5/account/fixed-loan/repay-borrowing-order
    # result = accountAPI.fixed_loan_repay_borrowing_order(ordId = '111111111111')
    # 固定借币转市场借币 POST /api/v5/account/fixed-loan/convert-to-market-loan
    # result = accountAPI.convert_to_market_loan(ordId = '')
    # 固定借币减少负债
    # result = accountAPI.reduce_liabilities(ordId = '1', pendingRepay = '')
    # 获取固定借币订单信息 GET /api/v5/account/fixed-loan/borrowing-orders-list
    # result = accountAPI.get_fixed_loan_borrowing_orders_list(ordId = '', ccy = '', state = '', after = '', before = '', limit = '', term = '')
    # 手动借/还币 POST /api/v5/account/spot-manual-borrow-repay
    # result = accountAPI.spot_manual_borrow_repay(ccy = 'BTC', side = 'borrow', amt = '0.1')
    # 设置自动还币 POST /api/v5/account/set-auto-repay
    # result = accountAPI.set_auto_repay(autoRepay = 'true')
    # 获取借/还币历史
    # result = accountAPI.get_spot_borrow_repay_history(ccy = '', type = '', after = '', before = '', limit = '')
    # 获取账户限速 GET /api/v5/trade/account-rate-limit
    # result = accountAPI.account_rate_limit()
    # 申请账单流水（自 2021 年）
    # result = accountAPI.bills_history_archive(year = '', quarter = '')
    # 获取账单流水（自 2021 年）
    # result = accountAPI.get_bills_history_archive(year = '', quarter = '')

    # funding api
    fundingAPI = Funding.FundingAPI(api_key, secret_key, passphrase, False, flag)
    # 获取充值地址信息  Get Deposit Address
    # result = fundingAPI.get_deposit_address('')
    # 获取资金账户余额信息  Get Balance
    # result = fundingAPI.get_balances('BTC')
    # 资金划转  Funds Transfer
    # result = fundingAPI.funds_transfer(ccy='USDT', amt='1', type='1', froms="6", to="18",subAcct='',loanTrans='',clientId='',omitPosRisk='')
    # 获取资金划转状态 Transfer State
    # result = fundingAPI.transfer_state(transId='', type='')
    # 提币  Withdrawal
    # result = fundingAPI.coin_withdraw(ccy='', amt='', dest='', toAddr='', fee='', chain='', areaCode='', clientId='')
    # 获取充值记录  Get Deposit History
    # result = fundingAPI.get_deposit_history()
    # 获取币种列表  Get Currencies
    # result = fundingAPI.get_currency('ETH,BTC')
    # 资金流水查询  Asset Bills Details
    # result = fundingAPI.get_bills()
    # 闪电网络充币
    # result = fundingAPI.get_deposit_lightning(ccy='BTC',amt='0.01')
    # 闪电网络提币
    # result = fundingAPI.withdrawal_lightning(ccy='BTC',invoice='0.01',memo='')
    # 撤销提币 CANCEL_WITHDRAWAL
    # result = fundingAPI.cancel_withdrawal(wdId='BTC')
    # 获取提币记录  Get Withdrawal History
    # result = fundingAPI.get_withdrawal_history()
    # 获取充值/提现的详细状态
    # result = fundingAPI.deposit_withdraw_status(wdId = '', txId = '', ccy = '', to = '', chain = '')
    # 小额资产兑换CONVERT_DUST_ASSETS （已经下线）
    # result = fundingAPI.convert_dust_assets()
    # 获取账户资产估值 GET Obtain account asset valuation
    # result = fundingAPI.get_asset_valuation(ccy = 'USDT')
    # 获取市场借贷信息（公共) GET LENDING RATE HISTORY
    # result = fundingAPI.get_lending_rate_history(ccy = '')
    # 获取市场借贷历史（公共）GET LENDING RATE SUMMARY
    # result = fundingAPI.get_lending_rate_summary(ccy = '')
    # 获取交易所列表
    # result = fundingAPI.exchange_list()
    # 申请月结单 (近一年)
    # result = fundingAPI.monthly_statement(month='')
    # 获取月结单 (近一年)
    # result = fundingAPI.monthly_statement(month='')

    # convert api
    convertAPI = Convert.ConvertAPI(api_key, secret_key, passphrase, False, flag)
    # 获取闪兑币种列表  Get Currencies
    # result = convertAPI.get_currencies()
    # 获取闪兑币对信息  Get Currency-pair
    # result = convertAPI.get_currency_pair(fromCcy = 'USDT', toCcy = 'BTC')
    # 闪兑预估询价  Estimate-quote
    # result = convertAPI.estimate_quote(baseCcy = 'OKB', quoteCcy = 'USDT', side = 'sell', rfqSz = '1', rfqSzCcy = 'USDT', clQReqId = '')
    # 闪兑交易  Convert-trade
    # result = convertAPI.convert_trade(quoteId='quoterOKB-USDT16480319751107680', baseCcy='OKB', quoteCcy='USDT',
    #                                   side='sell', sz='1', szCcy='USDT', clTReqId='',tag='')
    # 获取闪兑交易历史  Get Convert-history
    # result = convertAPI.get_convert_history(after = '', before = '', limit = '')

    # market api
    marketAPI = Market.MarketAPI(api_key, secret_key, passphrase, True, flag)
    # 获取所有产品行情信息  Get Tickers
    # result = marketAPI.get_tickers('SPOT')
    # 获取单个产品行情信息  Get Ticker
    # result = marketAPI.get_ticker('BTC-USDT')
    # 获取指数行情  Get Index Tickers
    # result = marketAPI.get_index_ticker('BTC', 'BTC-USD')
    # 获取产品深度  Get Order Book
    # result = marketAPI.get_orderbook('BTC-USDT-210402', '400')
    # 获取产品轻量深度（该接口已下线）
    # result = marketAPI.get_books_lite(instId = 'BTC-USDT')
    # 获取产品完整深度 GET /api/v5/market/books-full
    # result = marketAPI.books_full()
    # 获取所有交易产品K线数据  Get Candlesticks
    # result = marketAPI.get_candlesticks('BTC-USDT-210924', bar='1m')
    # 获取交易产品历史K线数据（仅主流币实盘数据）  Get Candlesticks History（top currencies in real-trading only）
    # result = marketAPI.get_history_candlesticks('BTC-USDT')
    # 获取指数K线数据  Get Index Candlesticks
    # result = marketAPI.get_index_candlesticks('BTC-USDT')
    # 获取指数历史K线数据  Get History Index Candlesticks
    # result = marketAPI.get_history_index_candlesticks(instId = 'BTC-USDT', after = '', before = '', bar = '', limit = '')
    # 获取标记价格K线数据  Get Mark Price Candlesticks
    # result = marketAPI.get_markprice_candlesticks('BTC-USDT')
    # 获取标记价格历史K线数据  Get Mark Price Candlesticks
    # result = marketAPI.get_history_markprice_candlesticks(instId = 'BTC-USDT', after = '', before = '', bar = '', limit = '')
    # 获取交易产品公共成交数据  Get Trades
    # result = marketAPI.get_trades('BTC-USDT', '400')
    # 获取期权品种公共成交数据
    # result = marketAPI.instrument_family_trades(instFamily = 'BTC-USD')
    # 获取平台24小时成交总量  Get Platform 24 Volume
    # result = marketAPI.get_volume()
    # Oracle 上链交易数据 GET Oracle
    # result = marketAPI.get_oracle()
    # 获取指数成分数据 GET Index Components
    # result = marketAPI.get_index_components(index='')
    # 获取法币汇率 GET exchange rate in legal currency
    # result = marketAPI.get_exchange_rate()
    # 获取交易产品公共历史成交数据
    # result = marketAPI.get_history_trades(instId = 'BTC-USDT', after = '', before = '', limit = '')
    # 获取大宗交易所有产品行情信息
    # result = marketAPI.get_block_tickers(instType = 'SWAP', uly = 'BTC-USDT')
    # 获取大宗交易单个产品行情信息
    # result = marketAPI.get_block_ticker(instId = 'BTC-USDT')
    # 获取大宗交易公共成交数据
    # result = marketAPI.get_block_trades(instId = 'BTC-USDT')
    # 集合竞价信息 GET /api/v5/market/call-auction-details
    # result = marketAPI.get_call_auction_details(instId = 'BTC-USDT')

    # public api
    publicAPI = Public.PublicAPI(api_key, secret_key, passphrase, False, flag)
    # 获取交易产品基础信息  Get instrument
    # result = publicAPI.get_instruments(instType = 'FUTURES', uly = '', instFamily = 'BTC-USDT', instId = '')
    # 获取交割和行权记录  Get Delivery/Exercise History
    # result = publicAPI.get_deliver_history('FUTURES', 'BTC-USD')
    # 获取持仓总量  Get Open Interest
    # result = publicAPI.get_open_interest('SWAP')
    # 获取永续合约当前资金费率  Get Funding Rate
    # result = publicAPI.get_funding_rate('BTC-USD-SWAP')
    # 获取永续合约历史资金费率  Get Funding Rate History
    # result = publicAPI.funding_rate_history('BTC-USD-SWAP')
    # 获取限价  Get Limit Price
    # result = publicAPI.get_price_limit('BTC-USD-210402')
    # 获取期权定价  Get Option Market Data
    # result = publicAPI.get_opt_summary('BTC-USD')
    # 获取预估交割/行权价格  Get Estimated Delivery/Excercise Price
    # result = publicAPI.get_estimated_price('ETH-USD-210326')
    # 获取免息额度和币种折算率  Get Discount Rate And Interest-Free Quota
    # result = publicAPI.discount_interest_free_quota('')
    # 获取系统时间  Get System Time
    # result = publicAPI.get_system_time()
    # 获取平台公共爆仓单信息  Get Liquidation Orders
    # result = publicAPI.get_liquidation_orders('FUTURES', uly='BTC-USDT', alias='next_quarter', state='filled')
    # 获取标记价格  Get Mark Price
    # result = publicAPI.get_mark_price('FUTURES')
    # 获取合约衍生品仓位档位 Get Position Tiers
    # result = publicAPI.get_tier(instType='MARGIN', instId='BTC-USDT', tdMode='cross')
    # 获取杠杆利率和借币限额公共信息 Get Interest Rate and Loan Quota
    # result = publicAPI.get_interest_loan()
    # 获取合约衍生品标的指数 Get underlying
    # result = publicAPI.get_underlying(instType='FUTURES')
    # 获取尊享借币杠杆利率和借币限额 GET Obtain the privileged currency borrowing leverage rate and currency borrowing limit
    # result = publicAPI.get_vip_interest_rate_loan_quota()
    # 获取风险准备金余额
    # result = publicAPI.get_insurance_fund(instType = 'SWAP', type = '', uly = 'BTC-USDT', ccy = '', before = '', after = '', limit = '')
    # 张币转换
    # result = publicAPI.convert_contract_coin(type = '2', instId = 'BTC-USDT-SWAP', sz = '1', px = '',
    #                                          unit = '', opType='')
    # 获取期权价格梯度
    # result = publicAPI.instrument_tick_bands(instType = 'OPTION', instFamily = '')
    # 获取期权公共成交数据
    # result = publicAPI.option_trades(instId = '', instFamily = 'BTC-USD', optType = '')

    # trading data
    tradingDataAPI = TradingData.TradingDataAPI(api_key, secret_key, passphrase, False, flag)
    # 获取支持币种 Get support coin
    # result = tradingDataAPI.get_support_coin()
    # 获取获取合约持仓量历史
    # result = tradingDataAPI.get_open_interest_history(instId = 'BTC-USDT-SWAP', period = '5m', end = '1597027383085', begin = '1597027383085', limit = '')
    # 获取币币或衍生品主动买入/卖出情况 Get taker volume
    # result = tradingDataAPI.get_taker_volume(ccy='BTC', instType='SPOT')
    # 获取合约主动买入/卖出情况
    # result = tradingDataAPI.get_taker_volume_contract(instId = 'BTC-USDT-SWAP')
    # 获取杠杆多空比 Get Margin lending ratio
    # result = tradingDataAPI.get_margin_lending_ratio('BTC')
    # 获取精英交易员合约多空持仓人数比
    # result = tradingDataAPI.get_long_short_account_ratio_contract_top_trader(instId = 'BTC-USDT-SWAP', period = '', end = '', begin = '', limit = '')
    # 获取精英交易员合约多空持仓仓位比
    # result = tradingDataAPI.get_long_short_position_ratio_contract_top_trader(instId = 'BTC-USDT-SWAP', period = '', end = '', begin = '', limit = '')
    # 获取合约多空持仓人数比
    # result = tradingDataAPI.get_long_short_account_ratio_contract(instId = 'BTC-USDT-SWAP', period = '', end = '', begin = '', limit = '')
    # 获取多空持仓人数比 Get Long/Short ratio
    # result = tradingDataAPI.get_long_short_ratio('BTC')
    # 获取持仓总量及交易量 Get contracts open interest and volume
    # result = tradingDataAPI.get_contracts_interest_volume('BTC')
    # 获取期权合约持仓总量及交易量 Get Options open interest and volume
    # result = tradingDataAPI.get_options_interest_volume('BTC')
    # 看涨/看跌期权合约 持仓总量比/交易总量比 Get Put/Call ratio
    # result = tradingDataAPI.get_put_call_ratio('BTC')
    # 看涨看跌持仓总量及交易总量（按到期日分） Get open interest and volume (expiry)
    # result = tradingDataAPI.get_interest_volume_expiry('BTC')
    # 看涨看跌持仓总量及交易总量（按执行价格分）Get open interest and volume (strike)
    # result = tradingDataAPI.get_interest_volume_strike('BTC', '20210924')
    # 看跌/看涨期权合约 主动买入/卖出量  Get Taker flow
    # result = tradingDataAPI.get_taker_flow('BTC')

    # trade api
    tradeAPI = Trade.TradeAPI(api_key, secret_key, passphrase, False, flag)
    # 下单  Place Order
    # result = tradeAPI.place_order(instId='BTC-USDT-SWAP', tdMode='cross', side='sell', posSide='',
    #                               ordType='market', sz='100',tgtCcy='',banAmend='',quickMgnType='auto_borrow',
    #                               tpTriggerPx = '1111', tpOrdPx = '1000', slTriggerPx = '', slOrdPx = '', tpTriggerPxType = '', slTriggerPxType = '')
    # 批量下单  Place Multiple Orders
    # result = tradeAPI.place_multiple_orders([
    #     {'instId': 'BTC-USD-210402', 'tdMode': 'isolated', 'side': 'buy', 'ordType': 'limit', 'sz': '1', 'px': '17400',
    #      'posSide': 'long',
    #      'clOrdId': 'a12344', 'tag': 'test1210','tgtCcy':''},
    #     {'instId': 'BTC-USD-210409', 'tdMode': 'isolated', 'side': 'buy', 'ordType': 'limit', 'sz': '1', 'px': '17359',
    #      'posSide': 'long',
    #      'clOrdId': 'a12344444', 'tag': 'test1211','tgtCcy':''}
    # ])

    # 撤单  Cancel Order
    # result = tradeAPI.cancel_order('BTC-USD-201225', '257164323454332928')
    # 批量撤单  Cancel Multiple Orders
    # result = tradeAPI.cancel_multiple_orders([
    #     {"instId": "BTC-USD-210402", "ordId": "297389358169071616"},
    #     {"instId": "BTC-USD-210409", "ordId": "297389358169071617"}
    # ])

    # 修改订单  Amend Order
    # result = tradeAPI.amend_order()
    # 批量修改订单  Amend Multiple Orders
    # result = tradeAPI.amend_multiple_orders(
    #     [{'instId': 'BTC-USD-201225', 'cxlOnFail': 'false', 'ordId': '257551616434384896', 'newPx': '17880'},
    #      {'instId': 'BTC-USD-201225', 'cxlOnFail': 'false', 'ordId': '257551616652488704', 'newPx': '17882'}
    #      ])

    # 市价仓位全平  Close Positions
    # result = tradeAPI.close_positions(instId='ADA-USDT-SWAP', posSide='', mgnMode='cross',ccy='', autoCxl='',clOrdId='',tag='')
    # 获取订单信息  Get Order Details
    # result = tradeAPI.get_orders('BTC-USD-201225', '257173039968825345')
    # 获取未成交订单列表  Get Order List
    # result = tradeAPI.get_order_list(instType = '', uly = '', instFamily = '', instId = '', ordType = '', state = '', after = '', before = '', limit = '')
    # 获取历史订单记录（近七天） Get Order History (last 7 days）
    # result = tradeAPI.get_orders_history(instType = 'SWAP', uly = '', instFamily = '', instId = '', ordType = '', state = '', category = '', after = '', before = '', begin = '', end = '', limit = '')
    # 获取历史订单记录（近三个月） Get Order History (last 3 months)
    # result = tradeAPI.orders_history_archive(instType = 'SWAP', uly = '', instFamily = '', instId = '', ordType = '', state = '', category = '', after = '', before = '', begin = '', end = '', limit = '')
    # 获取成交明细(三天)  Get Transaction Details
    # result = tradeAPI.get_fills(instType = '', uly = '', instFamily = '', instId = '', ordId = '', after = '', before = '', begin = '', end = '', limit = '')
    # 获取成交明细(三个月)  Get Transaction Details History
    # result = tradeAPI.get_fills_history(instType='SPOT')
    # 策略委托下单  Place Algo Order
    # result = tradeAPI.place_algo_order('BTC-USDT-SWAP', 'isolated', 'buy', ordType='conditional',
    #                                    sz='100',posSide='long', tpTriggerPx='60000', tpOrdPx='59999',
    #                                   tpTriggerPxType = 'last', slTriggerPxType = 'last', algoClOrdId ='123456',
    #                                    quickMgnType='', closeFraction = '1',cxlOnClosePos= '', attachAlgoClOrdId='',
    #                                    )
    # 撤销策略委托订单  Cancel Algo Order
    # result = tradeAPI.cancel_algo_order([{'algoId': '297394002194735104', 'instId': 'BTC-USDT-210409'}])
    # 修改策略委托订单 POST AMEND ALGOS
    # result = tradeAPI.amend_algos(instId = '', algoId = '', algoClOrdId = '', cxlOnFail = '', reqId = '', newSz = '',
    #     newTpTriggerPx = '', newTpOrdPx = '', newTpTriggerPxType = '',
    #     newSlTriggerPx = '', newSlOrdPx = '', newSlTriggerPxType = '',
    #     newTriggerPx = '', newOrdPx = '', newTriggerPxType ='',
    #     attachAlgoOrds = [{"newTpTriggerPx":"","newTpTriggerPxType":"","newTpOrdPx":"",
    #     "newSlTriggerPx":"","newSlTriggerPxType":"","newSlOrdPx":""}]
    # )
    # 撤销高级策略委托订单
    # result = tradeAPI.cancel_advance_algos([ {"algoId":"198273485","instId":"BTC-USDT"}])
    # 获取策略委托单信息
    # result = tradeAPI.get_order_algo(algoId = '', algoClOrdId = '')
    # 获取未完成策略委托单列表  Get Algo Order List
    # result = tradeAPI.order_algos_list('conditional', instType='FUTURES')
    # 获取历史策略委托单列表  Get Algo Order History
    # result = tradeAPI.order_algos_history('conditional', 'canceled', instType='FUTURES')
    # 获取一键兑换主流币币种列表
    # result = tradeAPI.easy_convert_currency_list(source = '1')
    # 一键兑换主流币交易
    # result = tradeAPI.easy_convert(fromCcy = '', toCcy = '', source = '')
    # 获取一键兑换主流币历史记录
    # result = tradeAPI.easy_convert_history(after = '', before = '', limit = '')
    # 获取一键还债币种列表
    # result = tradeAPI.one_click_repay_currency_list(debtType = '')
    # 一键还债交易
    # result = tradeAPI.one_click_repay(debtCcy = '', repayCcy = '')
    # 获取一键还债历史记录
    # result = tradeAPI.one_click_repay_history(after = '', before = '', limit = '')
    # 撤销 MMP 订单
    # result =tradeAPI.mass_cancel(instType = '', instFamily = '', lockInterval = '')
    # 倒计时全部撤单
    # result = tradeAPI.cancel_all_after(timeOut = '10', tag = '')
    # 申请成交明细（近两年） POST /api/v5/trade/fills-archive （已下线）
    # result = tradeAPI.fills_archive()
    # 获取成交明细（近两年） GET /api/v5/trade/fills-archive （已下线）
    # result = tradeAPI.fills_archives()
    # 订单预检查 POST /api/v5/trade/order-precheck
    # result = tradeAPI.order_precheck(instid = '', tdMode = '', side = '', posSide = '', ordType = '', sz = '', px = '',
    #     reduceOnly = '', tgtCcy = '', attachAlgoOrds = [{"attachAlgoClOrdId":"","tpTriggerPx":"","tpOrdPx":"",
    #     "tpOrdKind":"","slTriggerPx":"","slOrdPx":"","tpTriggerPxType":"","slTriggerPxType":"","sz":""}])


    # 价差撮合交易 SprdAPI
    sprdAPI = Sprd.SprdAPI(api_key, secret_key, passphrase, False, flag)
    # 下单 POST /api/v5/sprd/order
    # result = sprdAPI.place(sprdId='',clOrdId='',tag='',side='',ordType='',sz='',px='')
    # 撤单 POST /api/v5/sprd/cancel-order
    # result = sprdAPI.cancel_order(ordId='',clOrdId='')
    # 全部撤单 POST /api/v5/sprd/mass-cancel
    # result = sprdAPI.mass_cancel(sprdId='')
    # 修改订单（仅适用白名单用户） POST /api/v5/sprd/amend-order
    # result = sprdAPI.amend_cancel(reqId='',ordId='', clOrdId='', newSz='', newPx='')
    # 获取订单信息 GET /api/v5/sprd/order
    # result = sprdAPI.order(ordId='',clOrdId='')
    # 获取未成交订单列表 GET /api/v5/sprd/orders-pending
    # result = sprdAPI.orders_pending(sprdId='',ordType='',state='',beginId='',endId='',limit='')
    # 获取历史订单记录（近21天) GET /api/v5/sprd/orders-history (按创建时间倒叙排序)
    # result = sprdAPI.orders_history(sprdId='',ordType='',state='',beginId='',endId='',begin='',end='',limit='')
    # 获取历史订单记录（近三月)
    # result = sprdAPI.orders_history_archive(sprdId='',ordType='',state='',beginId='',endId='',begin='',end='',limit='')
    # 获取历史成交数据（近七天）GET /api/v5/sprd/trades (按时间倒叙排序)
    # result = sprdAPI.trades(sprdId='',tradeId='',ordId='',beginId='',endId='',begin='',end='',limit='')
    # 获取Spreads（公共）GET /api/v5/sprd/spreads
    # result = sprdAPI.spreads(baseCcy='',instId='',sprdId='',state='')
    # 获取Spread产品深度（公共）GET /api/v5/sprd/books
    # result = sprdAPI.books(sprdId='',sz='')
    # 获取单个Spread产品行情信息（公共） GET /api/v5/sprd/ticker
    # result = sprdAPI.ticker(sprdId='')
    # 获取公共成交数据（公共）GET /api/v5/sprd/public-trades
    # result = sprdAPI.public_trades(sprdId='')
    # 倒计时全部撤单 POST /api/v5/sprd/cancel-all-after
    # result = sprdAPI.sprd_cancel_all_after(timeOut='10')
    # 获取价差交易产品K线数据 GET /api/v5/market/sprd-candles
    # result = sprdAPI.get_sprd_candles(sprdId='', bar='', after='', before='', limit='')
    # 获取价差交易产品历史K线数据 GET /api/v5/market/sprd-history-candles
    # result = sprdAPI.get_sprd_history_candles(sprdId='', bar='', after='', before='', limit='')

    # 子账户API subAccount
    subAccountAPI = SubAccount.SubAccountAPI(api_key, secret_key, passphrase, False, flag)
    # 查询子账户的交易账户余额(适用于母账户) Query detailed balance info of Trading Account of a sub-account via the master account
    # result = subAccountAPI.balances(subAcct='')
    # 查询子账户转账记录(仅适用于母账户) History of sub-account transfer(applies to master accounts only)
    # result = subAccountAPI.bills()
    # 查看子账户列表(仅适用于母账户) View sub-account list(applies to master accounts only)
    # result = subAccountAPI.view_list()
    # 子账户间划转 Transfer between subAccounts
    # result = subAccountAPI.subAccount_transfer(ccy='USDT', amt='1', froms='6', to='6', fromSubAccount='1',
    #                                            toSubAccount='2', loanTrans='', omitPosRisk='')
    # 查看被托管子账户列表 entrust-subaccount-list
    # result = subAccountAPI.entrust_subaccount_list(subAcct = '')
    # 重置子账户的APIKey Reset the apikey of the sub account
    # result = subAccountAPI.modify_apikey(subAcct = '', apiKey = '', label = '', perm = '', ip = '')
    # 获取子账户资金账户余额
    # result = subAccountAPI.asset_balances(subAcct = '', ccy = '')
    # 获取用户的节点返佣信息
    # result = subAccountAPI.partner_if_rebate(apiKey = '')
    # 获取子账户最大可转余额
    # result = subAccountAPI.max_withdrawal()
    # 查询托管子账户转账记录
    # result = subAccountAPI.managed_subaccount_bills()

    # 信号交易 SignalApi
    SignalAPI = Signal.SignalApi(api_key, secret_key, passphrase, False, flag)
    # POST / 创建信号 /api/v5/tradingBot/signal/create-signal
    result = SignalAPI.create_signal(signalChanName='',signalChanDesc='')
    # GET / 查询所有信号 /api/v5/tradingBot/signal/signals
    result = SignalAPI.signals(signalSourceType='', signalChanId='',after='', before='',
                limit='', )
    # POST / 创建信号策略 /api/v5/tradingBot/signal/order-algo
    result = SignSignalAPIalAPI.order_algo(includeAll='', signalChanId='',instIds='', lever='',
                investAmt='',subOrdType='',ratio='',entrySettingParam='',exitSettingParam='',)
    # POST / 停止信号策略 POST /api/v5/tradingBot/signal/stop-order-algo
    result = SignSignalAPIalAPI.signal_stop_order_algo( algoId='', )
    # 调整保证金 POST /api/v5/tradingBot/signal/margin-balance
    result = SignSignalAPIalAPI.signal_margin_balance(algoId='',type='',amt='',allowReinvest='', )
    # 修改止盈止损 POST /api/v5/tradingBot/signal/amendTPSL
    result = SignSignalAPIalAPI.amendTPSL(algoId='',exitSettingParam='', )
    # 设置币对 POST /api/v5/tradingBot/signal/set-instruments
    result = SignSignalAPIalAPI.signal_set_instruments(algoId='',instIds='', includeAll='')
    # 获取信号策略详情 GET /api/v5/tradingBot/signal/orders-algo-details
    result = SignSignalAPIalAPI.orders_algo_details( algoId='',algoOrdType='',)
    # 获取活跃信号策略 GET /api/v5/tradingBot/signal/orders-algo-pending
    result = SignSignalAPIalAPI.orders_algo_pending(algoId='',algoOrdType='',after='',before='',limit='',)
    # 获取历史信号策略 GET /api/v5/tradingBot/signal/orders-algo-history
    result = SignSignalAPIalAPI.orders_algo_history(algoId='',algoOrdType='',after='',before='',limit='', )
    # 获取信号策略持仓 GET /api/v5/tradingBot/signal/positions
    result = SignSignalAPIalAPI.signal_positions(algoId='',algoOrdType='', )
    # 查看历史持仓信息 GET /api/v5/tradingBot/signal/positions-history
    result = SignSignalAPIalAPI.signal_positions_history(algoId='',instId='',after='',before='',limit='', )
    # 市价仓位全平 POST /api/v5/tradingBot/signal/close-position
    result = SignSignalAPIalAPI.signal_close_position( algoId='',instId='',)
    # 下单 POST /api/v5/tradingBot/signal/sub-order
    result = SignSignalAPIalAPI.sub_order(algoId='',instId='',side='',ordType='',sz='',px='',reduceOnly='')
    # 撤单  POST /api/v5/tradingBot/signal/cancel-sub-order
    result = SignSignalAPIalAPI.cancel_sub_order(algoId='',instId='',signalOrdId='',)
    # 获取信号策略子订单信息 GET /api/v5/tradingBot/signal/sub-orders
    result = SignSignalAPIalAPI.sub_orders(algoId='',algoOrdType='',signalOrdId='',state='',after='',before='',limit='',
                   begin='',end='',type='',clOrdId='')
    # 获取信号策略历史事件 GET /api/v5/tradingBot/signal/event-history
    result = SignSignalAPIalAPI.event_history(algoId='',after='',before='',limit='',)























    # BrokerAPI
    BrokerAPI = Broker.BrokerAPI(api_key, secret_key, passphrase, False, flag)
    # 获取独立经纪商账户信息 GET Obtain independent broker account information
    # result = BrokerAPI.broker_info()
    # 创建子账户 Create sub account
    # result = BrokerAPI.create_subaccount(subAcct = 'qwerty', label = '',clientIP='',mainAcct='')
    # 删除子账户 Delete sub account
    # result = BrokerAPI.delete_subaccount(subAcct = 'qwerty')
    # 获取子账户列表 Get sub account list
    # result = BrokerAPI.subaccount_info(page = '', subAcct = '', limit = '')
    # 设置子账户的账户等级 Set account level of sub account
    # result = BrokerAPI.set_subaccount_level(subAcct = 'qwerty', acctLv = '1')
    # 设置子账户的交易手续费费率 Set transaction fee rate of sub account
    # result = BrokerAPI.set_subaccount_fee_rate(subAcct = 'qwerty', instType = 'SPOT', mgnType = '', chgType = 'absolute', chgTaker = '0.1bp', chgMaker = '', effDate = '')
    # 创建子账户充值地址 Create sub account recharge address
    # result = BrokerAPI.subaccount_deposit_address(subAcct = 'qwerty', ccy = 'BTC', chain = '', addrType = '', to = '')
    # 获取子账户获取充值记录 Get sub account recharge record
    # result = BrokerAPI.subaccount_deposit_history(subAcct = 'qwerty', ccy = 'BTC', txId = '', state = '', after = '', before = '', limit = '')
    # 获取子账户提币记录
    # result = BrokerAPI.nd_subaccount_withdrawal_history(subAcct = 'qwerty', ccy = 'BTC', wdId = '', clientId = '', txId = '', type = '', state = '', after = '', before = '', limit = '')
    # 获取子账户返佣记录 Get rebate record of sub account
    # result = BrokerAPI.rebate_daily(subAcct = 'qwerty', begin = '', end = '', page = '', limit = '')
    # 创建子账户的APIKEY Apikey for creating sub accounts
    # result = BrokerAPI.nd_create_apikey(subAcct = 'qwerty', label = '', passphrase = '', ip = '', perm = '')
    # 查询子账户的APIKEY
    # result = BrokerAPI.nd_select_apikey(subAcct = 'qwerty', apiKey = '')
    # 重置子账户的APIKEY
    # result = BrokerAPI.nd_modify_apikey(subAcct = 'qwerty', apiKey = '', label = '', perm = '', ip = '')
    # 删除子账户的APIKEY
    # result = BrokerAPI.nd_delete_apikey(subAcct = 'qwerty', apiKey = '')
    # 生成返佣明细下载链接
    # result = BrokerAPI.rebate_per_orders(begin = '', end = '')
    # 获取返佣明细下载链接
    # result = BrokerAPI.rebate_per_orders(type = '', begin = '', end = '')
    # 重置子账户充值地址
    # result = BrokerAPI.modify_subaccount_deposit_address(subAcct = 'qwert', ccy = 'BTC', chain = '', addr = '1', to = '6')
    # 设置模拟盘ND子账户资产
    # result = BrokerAPI.set_subaccount_assets(subAcct='',ccy='')
    # 子账户IP上报 POST /api/v5/broker/nd/report-subaccount-ip
    # result = BrokerAPI.report_subaccount_ip(subAcct='',clientIP='')
    # 获取用户的 Broker 返佣信息 GET /api/v5/broker/nd/if-rebate
    # result = BrokerAPI.if_rebate(subAcct='',clientIP='')




    # FDBrokerAPI
    FDBrokerAPI = FDBroker.FDBrokerAPI(api_key, secret_key, passphrase, False, flag)
    # 生成返佣明细下载链接
    # result = FDBrokerAPI.fd_rebate_per_orders(begin = '', end = '', brokerType = '')
    # 获取返佣明细下载链接
    # result = FDBrokerAPI.fd_get_rebate_per_orders(type = '', begin = '', end = '', brokerType = '')
    # 获取返佣明细下载链接
    # result = FDBrokerAPI.fd_if_rebate(apiKey = '', brokerType = '')

    # 大宗交易(Rfq)API
    RfqAPI = Rfq.RfqAPI(api_key, secret_key, passphrase, False, flag)
    # 获取报价方信息
    # result = RfqAPI.counterparties()
    # 询价
    # result = RfqAPI.create_rfq(counterparties = ["TESTQ4","TESTQ2"], anonymous = False, clRfqId = '20220531test001', tag = '555', allowPartialExecution ='',
    #     legs = [{"instId":"BTC-USDT","sz":"1","side":"buy","tgtCcy":"base_ccy"},{"instId":"ETH-USDT","sz":"0.1","side":"buy","tgtCcy":"base_ccy"}])
    # 取消询价单
    # result = RfqAPI.cancel_rfq(rfqId = '3GIFPJ8', clRfqId = '')
    # 批量取消询价单
    # result = RfqAPI.cancel_batch_rfqs(rfqIds = '', clRfqIds = '')
    # 取消所有询价单
    # result = RfqAPI.cancel_all_rfqs()
    # 执行报价
    # result = RfqAPI.execute_quote(rfqId = '', quoteId = '')
    # 获取可报价产品
    # result = RfqAPI.get_maker_instrument_settings()
    # 设置可报价产品
    # result = RfqAPI.maker_instrument_settings(instType = 'SPOT', data = [{"instFamily":"","instId":"","maxBlockSz":"","makerPxBand":""}])
    # 重设MMP状态
    # result = RfqAPI.mmp_reset()
    # 设置 MMP
    # result = RfqAPI.mmp_config(timeInterval='',frozenInterval='',countLimit='')
    # 查看 MMP 配置
    # result = RfqAPI.mmp_configs(timeInterval='', frozenInterval='', countLimit='',mmpFrozen='',mmpFrozenUntil='',)
    # 报价
    # result = RfqAPI.create_quote(rfqId = '', clQuoteId = '', tag = '123', quoteSide = 'buy', anonymous = 'True', expiresIn = '', legs = [{"px":"39450.0","sz":"200000","instId":"BTC-USDT-SWAP","side":"buy"}])
    # 取消报价单
    # result = RfqAPI.cancel_quote(quoteId = '', clQuoteId = '', rfqId = '')
    # 批量取消报价单
    # result = RfqAPI.cancel_batch_quotes(quoteIds = '', clQuoteIds = '')
    # 取消所有报价单
    # result = RfqAPI.cancel_all_quotes()
    # 获取询价单信息
    # result = RfqAPI.get_rfqs(rfqId = '', clRfqId = '', state = '', beginId = '', endId = '', limit = '')
    # 获取报价单信息
    # result = RfqAPI.get_quotes(rfqId = '', clRfqId = '', quoteId = '', clQuoteId = '', state = '', beginId = '', endId = '', limit = '')
    # 获取大宗交易信息
    # result = RfqAPI.get_rfq_trades(rfqId = '', clRfqId = '', quoteId = '', blockTdId = '', clQuoteId = '', state = '', beginId = '', endId = '', beginTs ='', endTs = '', limit = '')
    # 获取大宗交易公共成交数据
    # result = RfqAPI.get_public_trades(beginId = '', endId = '', limit = '')
    # 倒计时全部撤单 POST /api/v5/rfq/cancel-all-after
    # result = RfqAPI.tag()



    # 网格交易
    TradingBot = TradingBot.TradingBotAPI(api_key, secret_key, passphrase, False, flag)
    # 网格策略下单
    # result = TradingBot.grid_order_algo(instId = 'BTC-USDT', algoOrdType = 'grid', maxPx = '100000', minPx = '10000', gridNum = '2', runType = '', tpTriggerPx = '', slTriggerPx = '', algoClOrdId='', profitSharingRatio = '', tag = '', 
    #     triggerParams = [{"triggerAction":"start", "triggerStrategy":"rsi", "timeframe":"30M","thold":"10","triggerCond":"cross","timePeriod":"14"}])
    # 修改网格策略订单
    # result = TradingBot.grid_amend_order_algo(algoId = '451791361361317888', instId = '', slTriggerPx = '', tpTriggerPx = '')
    # 网格策略停止
    # result = TradingBot.grid_stop_order_algo(algoId = '455784823937040384', instId = 'BTC-USDT', algoOrdType = 'grid', stopType = '1')
    # 获取未完成网格策略委托单列表
    # result = TradingBot.grid_orders_algo_pending(algoOrdType = 'grid', algoId = '', instId = '', instType = '', after = '', before = '', limit = '')
    # 获取历史网格策略委托单列表
    # result = TradingBot.grid_orders_algo_history(algoOrdType = 'grid', algoId = '', instId = '', instType = '', after = '', before = '', limit = '')
    # 获取网格策略委托订单详情
    # result = TradingBot.grid_orders_algo_details(algoOrdType = 'grid', algoId = '451805034968518656')
    # 获取网格策略委托子订单信息
    # result = TradingBot.grid_sub_orders(algoId = '451791361361317888', algoOrdType = 'grid', type = 'filled', groupId = '', after = '', before = '', limit = '')
    # 获取网格策略委托持仓
    # result = TradingBot.grid_positions(algoOrdType = '', algoId = '')
    # 现货网格提取利润
    # result = TradingBot.grid_withdraw_income(algoId = '455784823937040384')
    # 调整保证金计算
    # result = TradingBot.grid_compute_margin_balance(algoId = '455784823937040384', type = 'add', amt = '')
    # 调整保证金
    # result = TradingBot.grid_margin_balance(algoId = '455784823937040384', type = 'add', amt = '10', percent = '')
    # 网格策略智能回测（公共）
    # result = TradingBot.grid_ai_param(algoOrdType = 'grid', instId = 'BTC-USDT', direction = '', duration = '')
    # 加仓 POST /api/v5/tradingBot/grid/adjust-investment
    # result = TradingBot.grid_adjust_investment(algoId = '', amt = '')
    # 最大网格数量（公共）GET /api/v5/tradingBot/grid/grid-quantity
    # result = TradingBot.grid_quantity(instId = 'BTC-USDT', runType = '1', algoOrdType = '', maxPx = '', minPx = '', lever = '')


    # 金融产品 Finance API
    Finance = Finance.FinanceAPI(api_key, secret_key, passphrase, False, flag)
    # 查看项目 View items
    # result = Finance.staking_defi_offers(productId = '', protocolType = 'defi', ccy = '')
    # 申购项目 Subscription items
    # result = Finance.staking_defi_purchase(productId = '1456', investData = [{"ccy":"USDT","amt":"1"}], term = '30', tag='')
    # 赎回项目 Redemption items
    # result = Finance.staking_defi_redeem(ordId = '123', protocolType = 'defi', allowEarlyRedeem = '')
    # 撤销项目申购/赎回 Cancellation of project subscription / redemption
    # result = Finance.staking_defi_cancel(ordId = '', protocolType = 'defi')
    # 查看活跃订单 View active orders
    # result = Finance.staking_defi_orders_active(productId = '', protocolType = 'defi', ccy = '', state = '')
    # 查看历史订单 View historical orders
    # result = Finance.staking_defi_orders_history(productId = '', protocolType = '', ccy = '', after = '', before = '', limit = '')

    # ETH质押
    # 申购/api/v5/finance/staking-defi/eth/purchase
    # result = Finance.staking_defi_eth_purcase()
    # 赎回 POST /api/v5/finance/staking-defi/eth/redeem
    # result = Finance.staking_defi_eth_redeem()
    # GET / 获取余额 GET /api/v5/finance/staking-defi/eth/balance
    # result = Finance.staking_defi_eth_balance()
    # 获取申购赎回记录 GET /api/v5/finance/staking-defi/eth/purchase-redeem-history
    # result = Finance.staking_defi_eth_p_r_history()
    # 获取历史收益率(公共) GET /api/v5/finance/staking-defi/eth/apy-history
    # result = Finance.staking_defi_eth_apy_history()
    # 获取产品信息
    # result = Finance.staking_defi_eth_product_info()

    # 活期简单赚币
    # 余币宝申购/赎回  PiggyBank Purchase/Redemption
    # result = fundingAPI.purchase_redempt('BTC', '1', 'purchase')
    # 获取余币宝余额 PIGGY BALABCE
    # result = fundingAPI.get_piggy_balance()
    # 设置余币宝借贷利率 POST SET LENDING RATE
    result = fundingAPI.set_lending_rate(ccy = 'USDT',rate='')
    # 获取余币宝出借明细 GET LENDING HISTORY
    # result = fundingAPI.get_lending_rate(ccy = '')
    # 获取市场借贷信息（公共）GET /api/v5/finance/savings/lending-rate-summary
    # result = Finance.savings_lending_rate_summary()
    # 获取市场借贷历史（公共） GET /api/v5/finance/savings/lending-rate-history
    # result = Finance.savings_lending_rate_his()

    # 定期简单赚币
    # 获取借币信息 GET /api/v5/finance/fixed-loan/lending-offers
    # result = Finance.fixed_loan_lending_offers()
    # 获取历史收益率 GET /api/v5/finance/fixed-loan/lending-apy-history
    # result = Finance.fixed_loan_lending_apy_history()
    # 获取借贷量 GET /api/v5/finance/fixed-loan/pending-lending-volume
    # result = Finance.fixed_loan_pending_lending_vol()
    # 定期简单赚币申购 POST /api/v5/finance/fixed-loan/lending-order
    # result = Finance.fixed_loan_lending_order(ccy = 'BTC', amt = '1', rate ='0.01', term = '30', autoRenewal = '')
    # 定期简单赚币修改订单 POST /api/v5/finance/fixed-loan/amend-lending-order
    # result = Finance.fixed_loan_amend_lending_order(ordId = '', changeAmt = '', rate ='', autoRenewal = '')
    # 获取定期简单赚币订单信息 GET /api/v5/finance/fixed-loan/lending-orders-list
    # result = Finance.fixed_loan_lending_orders_list(ordId = '', ccy ='', state ='', after = '', before = '', limit = '')
    # 获取定期简单赚币子订单信息
    # result = Finance.fixed_loan_lending_sub_orders(ordId = '', state ='', after = '', before = '', limit = '')

    # 跟单
    Copytrading = Copytrading.CopytradingAPI(api_key, secret_key, passphrase, False, flag)
    # 交易员获取当前带单
    # result = Copytrading.current_subpositions(instId='', after='', before='', limit='')
    # 交易员获取历史带单
    # result = Copytrading.subpositions_history(instId='', after='', before='', limit='')
    #  带单或跟单仓位止盈止损
    # result = Copytrading.copytrading_algo_order(subPosId='123456789', tpTriggerPx='1', slTriggerPx='', tpTriggerPxType='', slTriggerPxType=''
    #                                             tag='')
    # 交易员平仓
    # result = Copytrading.copytrading_close_subposition(subPosId='123456789',tag='')
    # 交易员获取带单合约
    # result = Copytrading.copytrading_instruments()
    # 交易员修改带单合约
    # result = Copytrading.copytrading_set_instruments(instId='BTC-USDT-SWAP')
    # 交易员历史分润明细
    # result = Copytrading.profit_sharing_details(after='', before='', limit='')
    # 交易员历史分润汇总
    # result = Copytrading.total_profit_sharing()
    # 交易员待分润明细
    # result = Copytrading.unrealized_profit_sharing_details()
    # 首次跟单设置
    # result = Copytrading.first_copy_settings(instType='',uniqueCode='',copyMgnMode='',copyInstIdType='',instId='',copyMode='',
    #                                          copyTotalAmt='',copyAmt='',copyRatio='',tpRatio='',slRatio='',slTotalAmt='',
    #                                          subPosCloseType='')
    # 修改跟单设置
    # result = Copytrading.amend_copy_settings(instType='', uniqueCode='', copyMgnMode='', copyInstIdType='', instId='',
    #                                          copyMode='',
    #                                          copyTotalAmt='', copyAmt='', copyRatio='', tpRatio='', slRatio='',
    #                                          slTotalAmt='',
    #                                          subPosCloseType='')
    # 停止跟单
    # result = Copytrading.stop_copy_trading(instType='',uniqueCode='',subPosCloseType='')
    # 获取跟单设置
    # result = Copytrading.copy_settings(instType='',uniqueCode='')
    # 批量获取杠杆倍数
    # result = Copytrading.batch_leverage_info(mgnMode='',uniqueCode='',instId='')
    # 批量设置杠杆倍数
    # result = Copytrading.batch_set_leverage(mgnMode='', lever='', instId='')
    # 获取我的交易员
    # result = Copytrading.current_lead_traders(instType='')
    # GET / 获取我的交易员历史
    # result = Copytrading.lead_traders_history(after='',before='',limit='',instType='',)
    # GET / 获取交易员排名
    # result = Copytrading.public_lead_traders(instType='',sortType='',state='',minLeadDays='',minAssets='',maxAssets='',
    #                                          minAum='',maxAum='',dataVer='',page='',limit='')
    # GET / 获取交易员收益周表现
    # result = Copytrading.public_weekly_pnl(instType='',uniqueCode='')
    # GET / 获取交易员收益日表现
    # result = Copytrading.public_pnl(instType='', uniqueCode='',lastDays='')
    # GET / 获取交易员带单情况
    # result = Copytrading.public_stats(instType='', uniqueCode='',lastDays='')
    # GET / 获取交易员币种偏好
    # result = Copytrading.public_preference_currency(instType='', uniqueCode='')
    # GET / 获取交易员当前带单
    # result = Copytrading.public_current_subpositions(after='', before='', limit='', instType='', uniqueCode='')
    # GET / 获取交易员历史带单
    # result = Copytrading.public_subpositions_history(after='', before='', limit='', instType='', uniqueCode='')
    # 带单申请 POST /api/v5/copytrading/apply-lead-trading
    # result = Copytrading.apply_lead_trading()
    # 停止带单 /api/v5/copytrading/stop-lead-trading
    # result = Copytrading.stop_lead_trading()
    # 修改分润比例 /api/v5/copytrading/amend-profit-sharing-ratio
    # result = Copytrading.amend_profit_sharing_ratio()
    # 获取交易员排名（私有）GET /api/v5/copytrading/lead-traders
    # result = Copytrading.lead_traders()
    # 获取交易员收益周表现（私有）GET /api/v5/copytrading/weekly-pnl
    # result = Copytrading.weekly_pnl()
    # 获取交易员收益日表现（私有）/api/v5/copytrading/pnl
    # result = Copytrading.pnl()
    # 获取交易员带单情况（私有）/api/v5/copytrading/stats
    # result = Copytrading.stats()
    # 获取交易员币种偏好（私有）/api/v5/copytrading/preference-currency
    # result = Copytrading.preference_currency()
    # 获取交易员当前带单（私有）/api/v5/copytrading/performance-current-subpositions
    # result = Copytrading.performance_current_subpositions(after='', before='', limit='', instType='', uniqueCode='')
    # 获取交易员历史带单（私有）/api/v5/copytrading/performance-subpositions-history
    # result = Copytrading.performance_subpositions_history(after='', before='', limit='', instType='', uniqueCode='')
    # 获取跟单人信息（私有）/api/v5/copytrading/copy-traders
    # result = Copytrading.copy_traders(uniqueCode='')
    # 获取跟单人信息/api/v5/copytrading/public-copy-traders
    # result = Copytrading.public_copy_traders()
    # 查看账户配置信息/api/v5/copytrading/config
    # result = Copytrading.config()
    # 交易员待分润汇总 /api/v5/copytrading/total-unrealized-profit-sharing
    # result = Copytrading.total_unrealized_profit_sharing()

    # 定投
    Recurring = Recurring.RecurringAPI(api_key, secret_key, passphrase, False, flag)
    # 定投策略委托下单
    # result = Recurring.recurring_order_algo(stgyName = 'test', recurringList = [{"ccy":"BTC","ratio":"1"}], period = 'daily', recurringDay = '1', recurringTime = '2', 
    #     timeZone = '8', amt = '2', investmentCcy = 'USDT', tdMode = 'cash', algoClOrdId = 'testclordid', tag = 'testtag')
    # 修改定投策略订单
    # result = Recurring.recurring_amend_order_algo(algoId = '561293358812102656', stgyName = 'test2')
    # 定投策略停止
    # result = Recurring.recurring_stop_order_algo([{"algoId":"561293358812102656"}])
    # 获取未完成定投策略委托单列表
    # result = Recurring.recurring_orders_algo_pending(algoId = '', after = '', before = '', limit = '')
    # 获取历史定投策略委托单列表
    # result = Recurring.recurring_orders_algo_history(algoId = '', after = '', before = '', limit = '')
    # 获取定投策略委托订单详情
    # result = Recurring.recurring_orders_algo_details(algoId = '561293358812102656')
    # 获取定投策略子订单信息
    # result = Recurring.recurring_sub_orders(algoId = '561293358812102656', ordId = '', after = '', before = '', limit = '')


    # 系统状态API(仅适用于实盘) system status
    Status = Status.StatusAPI(api_key, secret_key, passphrase, False, flag)
    # 查看系统的升级状态
    # result = Status.status()
    # 公告 GET /api/v5/support/announcements
    # result = Status.get_announcements(annType = '', page = '')
    # 公告类型 GET /api/v5/support/announcement-types
    # result = Status.get_announcements_types()
    print(json.dumps(result))
