<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/5/7
 * Time: 2:59 PM
 */

require './vendor/autoload.php';

require './Config.php';

use okv3\AccountApi;
use okv3\Config;
use okv3\FundingApi;
use okv3\FuturesApi;
use okv3\MarginApi;
use okv3\MarketDataAPI;
use okv3\OptionsApi;
use okv3\OthersAPI;
use okv3\PublicDataAPI;
use okv3\SpotApi;
use okv3\SwapApi;
use okv3\TradeAPI;
use okv3\TradingDataAPI;
use Workerman\Connection\AsyncTcpConnection;
use Workerman\Worker;

/**
 * 账户 Account
 */
$obj = new AccountApi(Config::$config);
$coin = "XMR";
// 查看账户余额 Get Balance
//$res = $obj -> getBalance();
// 查看持仓信息 Get Positions
//$res = $obj -> getPositions('MARGIN','');
// 账单流水查询（近七天） Get Bills Details (last 7 days)
//$res = $obj -> getBills('MARGIN','','','','','','','','');
// 账单流水查询（近三个月） Get Bills Details (last 3 months)
//$res = $obj -> getBillsArchive('SPOT','','','','','','','','');
// 查看账户配置 Get Account Configuration
//$res = $obj -> getConfig();
// 设置持仓模式 Set Position mode
//$res = $obj -> setPositionMode('long_short_mode');
// 设置杠杆倍数 Set Leverage
//$res = $obj -> setLeverage('BTC-USDT','','5','isolated','');
// 获取最大可交易数量 Get Maximum Tradable Size For Instrument
//$res = $obj -> getMaxSize('BTC-USD-SWAP','cross','','');
// 获取最大可用数量 Get Maximum Available Tradable Amount
//$res = $obj -> getMaxAvailSize('BTC-USD-SWAP','','cross','');
// 调整保证金 Increase/Decrease margin
//$res = $obj -> marginBalance('BTC-USD-SWAP','long','add','1');
// 获取杠杆倍数 Get Leverage
//$res = $obj -> getLeverage('BTC-USD-SWAP','isolated');
// 获取币币逐仓杠杆最大可借 Get the maximum loan of isolated MARGIN
//$res = $obj -> getMaxloan('BTC-USDT');
// 获取当前账户交易手续费费率 Get Fee Rates
//$res = $obj -> getTradeFee('SPOT','','','1');
// 获取计息记录 Get interest-accrued
//$res = $obj -> getInterestAccrued('BTC-USDT','','','');
// 期权希腊字母PA/BS切换 Set Greeks (PA/BS)
//$res = $obj -> setGreeks('BS');
// 查看账户最大可转余额 Get Maximum Withdrawals
//$res = $obj -> getMaxWithdrawal('BTC');

/**
 * 资金 Funding
 */
$instrumentId = "EOS-USDT";
$currency = "EOS";
$obj = new FundingApi(Config::$config);
// 获取充值地址信息 Get Deposit Address
//$res = $obj -> getDepositAddress('BTC');
// 获取资金账户余额信息 Get Balance
//$res = $obj -> getBalance();
// 资金划转 Funds Transfer
//$res = $obj -> transfer('USDT','1','0','6','5','','','');
// 提币 Withdrawal
//$res = $obj -> withdrawal('ETH','1','4','0xa3e2f08f9eeab50ea053bb334c0266aef57a4168','5323','1');
// 充值记录 Get Deposit History
//$res = $obj -> getDepositHistory('','','','','');
// 提币记录 Get Withdrawal History
//$res = $obj -> getWithdrawalHistory('','','','','');
// 获取币种列表 Get Currencies
//$res = $obj -> getCurrencies();
// 余币宝申购/赎回 PiggyBank Purchase/Redemption
//$res = $obj -> PurchaseRedempt('BTC','1','purchase');
// 余币宝申购/赎回 PiggyBank Purchase/Redemption
//$res = $obj -> getBills('BTC');


/**
 * 行情数据 Market Data
 */
// 交割合约-Ticker
$instrumentId = "ETH-USD-200925";
$coin = "EOS";
$obj = new MarketDataAPI(Config::$config);
// 获取所有产品行情信息 Get Tickers
//$res = $obj->getTickers('FUTURES','BTC-USD');
// 获取单个产品行情信息 Get Ticker
//$res = $obj->getTicker('BTC-USD-SWAP');
// 获取指数行情 Get Index Tickers
//$res = $obj->getIndexTicker('BTC','');
// 获取产品深度 Get Order Book
//$res = $obj->getBooks('BTC-USDT','');
// 获取所有交易产品K线数据 Get Candlesticks
//$res = $obj->getCandles('BTC-USDT','','','','');
// 获取交易产品历史K线数据（仅主流币） Get Candlesticks History（top currencies only）
//$res = $obj->getHistoryCandles('BTC-USDT','','','','');
// 获取指数K线数据 Get Index Candlesticks
//$res = $obj->getIndexCandles('BTC-USD','','','','');
// 获取标记价格K线数据 Get Mark Price Candlesticks
//$res = $obj->getMarkPriceCandles('BTC-USD-SWAP','','','','');
// 获取交易产品公共成交数据 Get Trades
//$res = $obj->getTrades('BTC-USDT','');

/**
 * 获取交易产品基础信息 Get Instruments
 */
$instrumentId = "BTC-USDT-SWAP";
$currency = "EOS";
$obj = new PublicDataAPI(Config::$config);
// 获取交易产品基础信息 Get Instruments
//$res = $obj->getInstruments('SPOT','','');
// 获取交割和行权记录 Get Delivery/Exercise History
//$res = $obj->getDeliveryExerciseHistory('FUTURES','BTC-USD','','','');
// 获取持仓总量 Get Open Interest
//$res = $obj->getOpenInterest('FUTURES','BTC-USD','');
// 获取永续合约当前资金费率 Get Funding Rate
//$res = $obj->getFundingRate('BTC-USD-SWAP');
// 获取永续合约历史资金费率 Get Funding Rate History
//$res = $obj->getFundingRateHistory('BTC-USD-SWAP');
// 获取限价 Get Limit Price
//$res = $obj->getPriceLimit('BTC-USD-SWAP');
// 获取期权定价 Get Option Market Data
//$res = $obj->getOptSummary('BTC-USD','');
// 获取预估交割/行权价格 Get Estimated Delivery/Excercise Price
//$res = $obj->getEstimatedPrice('BTC-USD-201225');
// 获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota
//$res = $obj->getQuota('BTC');
// 获取系统时间 Get System Time
//$res = $obj->getTime('BTC');
// 获取平台公共爆仓单信息 Get Liquidation Orders
//$res = $obj->getLiquidationOrders('MARGIN','','','','','','','','','');
// 获取标记价格 Get Mark Price
//$res = $obj->getMarkPrice('MARGIN','','');

/**
 * 交易 Trade
 */
$obj = new TradeAPI(Config::$config);
// 下单 Place Order
//$res = $obj -> order('BTC-USDT','isolated','','','','buy','','market','100','','');
// 撤单 Cancel Order
//$res = $obj -> cancelOrder('BTC-USDT','1234','');
// 修改订单 Amend Order
//$res = $obj -> amendOrder('BTC-USDT','','','','','','');
// 市价仓位全平 Close Positions
//$res = $obj -> closePosition('BTC-USDT-SWAP','short','cross','');
// 获取订单信息 Get Order Details
//$res = $obj -> getOrder('BTC-USDT-SWAP','','');
// 获取未成交订单列表 Get Order List
//$res = $obj -> getOrderPending('SPOT','','','','','','','');
// 获取历史订单记录（近七天） Get Order History (last 7 days）
//$res = $obj -> getOrdersHistory('SPOT','','','','','','','');
// 获取历史订单记录（近三个月） Get Order History (last 3 months)
//$res = $obj -> getOrdersHistoryArchive('SPOT','','','','','','','');


// 获取成交明细 Get Transaction Details
//$res = $obj -> getFills('SPOT','','','','','','','');

// 策略委托下单 Place Algo Order
//$res = $obj -> orderAlgo('BTC-USDT','cash','','buy','','trigger','0.001','','10000','10000');
// 撤销策略委托订单 Cancel Algo Order
//$res = $obj -> cancelAlgos('258378466010210304','BTC-USDT');
// 获取未完成策略委托单列表 Get Algo Order List
//$res = $obj -> getAlgoPending('','SPOT','','trigger','','','');
// 获取历史策略委托单列表 Get Algo Order History
//$res = $obj -> getAlgoHistory('canceled','','SPOT','','trigger','','');
