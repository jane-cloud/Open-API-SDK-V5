<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/5/10
 * Time: 8:22 PM
 */

//namespace okv5;

require './vendor/autoload.php';
require './Config.php';

use okv5\Config;
use okv5\PrivateChannels;
use okv5\PublicChannels;
use okv5\TradeChannels;
use okv5\Websocket;

$obj = new PublicChannels(Config::$config);

$callbackTrade = function ($data) use ($obj) {
    $dataArr = json_decode($data, true);
    $ntime = $obj->getTimestamp();
    $otime = $obj -> oldTime;
//    print_r($dataArr);

    if (!empty($dataArr["table"])){
        $key = substr($dataArr["data"][0]["timestamp"], 0,-8);
//        print_r($key."\n");

        // 第一次，分钟线的初始化
        if (empty($obj->tradeVolumn[$key]))
        {
            print_r($ntime." tradeVolumn ".json_encode($obj->tradeVolumn));
            print_r("\n");

            $obj->tradeVolumn[$key] = $dataArr["data"][0]["qty"];
        // 分钟线成交量的累加
        }else{
            $obj->tradeVolumn[$key] += $dataArr["data"][0]["qty"];
        }



    }

    print_r($ntime." ".$data);
    print_r("\n");
};

// 回调函数
$callback = function ($data) use ($obj){

    $ntime = $obj->getTimestamp();
    $otime = $obj -> oldTime;

    print_r($ntime." ".$data);
    print_r("\n");
};

$callbackTime = function ($data) use ($obj){
    $dataArr = json_decode($data, true);

    $ntime = $obj->getTimestamp();
//    $key = $dataArr
//    print_r($dataArr["op"]);
//    die();
    if (!empty($dataArr["table"]))
        $key = $dataArr["table"];
    elseif(!empty($dataArr["op"]))
        $key = $dataArr["op"];
    else
        $key = "else";

    // 上一次时间
    if (!empty($key) && !empty($obj -> oldTime[$key]))
        $otime = $obj -> oldTime[$key];
    else
        $otime = $ntime;

    // 上次与本次推送时间差，
    $lastDiff = $obj->dateToTimestamp($ntime)-$obj->dateToTimestamp($otime);
//    print_r($ntime." ($diff) ".$data);
//    print_r("\n");

    // 本次，本地时间戳与推送数据时间戳的差
    if (!empty($dataArr["data"][0]["timestamp"])){
        $timestamp = $dataArr["data"][0]["timestamp"];
//    if (!empty($dataArr["data"][0]["last_fill_time"])){
//        $timestamp = $dataArr["data"][0]["last_fill_time"];
        @$diff = $obj->dateToTimestamp($ntime)-$obj->dateToTimestamp($timestamp);
        print_r($ntime." ($lastDiff)"." ($diff) ".$data);
        print_r("\n");
    }else{
        print_r($obj->getTimestamp()." ".$data);
        print_r("\n");
    }

//    if (!empty($key) && !empty($obj -> oldTime[$key]))
    $obj -> oldTime[$key] = $ntime;


};

/**
 * 公共频道 Public Channel
 */
$obj = new PublicChannels(Config::$config);

$instrumentId = "BTC-USDC";
$coin = "EOS";
//产品频道
//$obj->subscribe($callbackTime,'{"channel":"instruments","instType":"FUTURES"}');
//行情频道
//$obj->subscribe($callbackTime,'{"channel":"tickers","instId":"XRP-USDT-210625"}');
//持仓总理频道
//$obj->subscribe($callbackTime,'{"channel":"open-interest","instId":"BTC-USD-SWAP"}');
//k线频道
//$obj->subscribe($callbackTime,'{"channel":"candle30m","instId":"OKB-USDT"}');
//交易频道
//$obj->subscribe($callbackTime,'{"channel":"trades","instId":"LTC-USDT"}');
//预估交割/行权价格频道
//$obj->subscribe($callbackTime,'{"channel":"estimated-price","instType":"FUTURES","uly":"BTC-USD"}');
//标记价格频道
//$obj->subscribe($callbackTime,'{"channel":"mark-price","instId":"BTC-USD-SWAP"}');
//标记价格K线频道
//$obj->subscribe($callbackTime,'{"channel":"mark-price-candle1D","instId":"BTC-USD-SWAP"}');
//限价频道
//$obj->subscribe($callbackTime,'{"channel":"price-limit","instId":"BTC-USD-SWAP"}');
//深度频道
//$obj->subscribe($callbackTime,'{"channel":"books","instId":"BTC-USD-SWAP"}');
//期权定价频道
//$obj->subscribe($callbackTime,'{"channel":"opt-summary","uly":"BTC-USD"}');
//资金费率频道
//$obj->subscribe($callbackTime,'{"channel":"funding-rate","instId":"BTC-USD-SWAP"}');
//指数K线频道
//$obj->subscribe($callbackTime,'{"channel":"index-candle1m","instId":"BTC-USDT"}');
//指数行情频道
//$obj->subscribe($callbackTime,'{"channel":"index-tickers","instId":"BTC-USD"}');
//Status 频道
//$obj->subscribe($callbackTime,'{"channel":"status"}');

/**
 * 私有频道 Private Channel
 */
$obj = new PrivateChannels(Config::$config);
//账户频道
//$obj->subscribe($callbackTime,'{"channel":"account"}');
//持仓频道
//$obj->subscribe($callbackTime,'{"channel":"positions","instType":"ANY"},{"channel":"orders","instType":"ANY"}');
//账户余额和持仓频道
//$obj->subscribe($callbackTime,'{"channel":"balance_and_position"}');
//订单频道
//$obj->subscribe($callbackTime,'{"channel":"orders","instType":"ANY"}');
//策略委托订单频道
//$obj->subscribe($callbackTime,'{"channel":"orders-algo","instType":"SWAP","uly":"BTC-USDT","instId":"BTC-USDT-SWAP"}');

/**
 * 交易 Trade
 */
$obj = new TradeChannels(Config::$config);
//下单
$obj->subscribe($callbackTime,'{"id": "2095109", "op": "order", "args": [{"side": "buy", "instId": "BTC-USDT-SWAP","ccy":"", "tdMode": "isolated", "ordType": "limit", "px": "39580.5", "sz": "1","clOrdId":"","posSide":"long"}]}');
//批量下单
//$obj->subscribe($callbackTime,'{"id":  "1512", "op": "batch-orders", "args": [{"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19777", "sz": "1"},{"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19778", "sz": "1"}]}');
//撤单
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "cancel-order", "args": [{"instId": "BTC-USDT", "ordId": "260420821332664322"}]}');
//批量撤单
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "batch-cancel-orders", "args": [{"instId": "BTC-USD-SWAP", "ordId": "298142095416631303"},{"instId": "BTC-USD-SWAP", "clOrdId": "MUMU123"}]}');
//改单
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "amend-order", "args": [{"instId": "LTC-BTC", "ordId": "302766903026655232","newSz":"4","newPx":""}]}');
//批量改单
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "amend-order", "args": [{"instId": "BTC-USDT", "ordId": "260420821332664322","newSz":"2"},{"instId": "BTC-USDT", "ordId": "260420821332664323","newSz":"2"}]}');


