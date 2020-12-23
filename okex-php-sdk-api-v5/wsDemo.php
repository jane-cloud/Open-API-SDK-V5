<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/5/10
 * Time: 8:22 PM
 */

//namespace okv3;

require './vendor/autoload.php';
require './Config.php';

use okv3\Config;
use okv3\PrivateChannels;
use okv3\PublicChannels;
use okv3\TradeChannels;
use okv3\Websocket;

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
//$obj->subscribe($callbackTime,'{"channel":"instruments","instType":"FUTURES"}');
//$obj->subscribe($callbackTime,'{"channel":"tickers","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"open-interest","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"trades","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"estimated-price","instType":"FUTURES","uly":"BTC-USD"}');
//$obj->subscribe($callbackTime,'{"channel":"mark-price","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"mark-price-candle1D","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"price-limit","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"books5","instId":"BTC-USDT"}');
//$obj->subscribe($callbackTime,'{"channel":"books","instId":"BTC-USDT"}');
//$obj->subscribe($callbackTime,'{"channel":"opt-summary","uly":"BTC-USD"}');
//$obj->subscribe($callbackTime,'{"channel":"funding-rate","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"index-candle1D","instId":"BTC-USD"}');
//$obj->subscribe($callbackTime,'{"channel":"index-tickers","instId":"BTC-USD"}');

/**
 * 私有频道 Private Channel
 */
$obj = new PrivateChannels(Config::$config);
//$obj->subscribe($callbackTime,'{"channel":"account","ccy":"BTC"}');
//$obj->subscribe($callbackTime,'{"channel":"positions","instType":"SWAP","uly":"BTC-USD","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"orders","instType":"SWAP","uly":"BTC-USD","instId":"BTC-USD-SWAP"}');
//$obj->subscribe($callbackTime,'{"channel":"orders-algo","instType":"SWAP","uly":"BTC-USD","instId":"BTC-USD-SWAP"}');

/**
 * 交易 Trade
 */
$obj = new TradeChannels(Config::$config);

//$obj->subscribe($callbackTime,'{"id": "1512", "op": "order", "args": [{"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19777", "sz": "1"}]}');
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "order", "args": [{"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19777", "sz": "1"},{"side": "buy", "instId": "BTC-USDT", "tdMode": "isolated", "ordType": "limit", "px": "19778", "sz": "1"}]}');
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "cancel-order", "args": [{"instId": "BTC-USDT", "ordId": "260420821332664322"}]}');
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "cancel-order", "args": [{"instId": "BTC-USDT", "ordId": "260420821332664322"},{"instId": "BTC-USDT", "ordId": "260420821332664323"}]}');
//$obj->subscribe($callbackTime,'{"id": "1512", "op": "amend-order", "args": [{"instId": "BTC-USDT", "ordId": "260420821332664322","newSz":"2"}]}');
$obj->subscribe($callbackTime,'{"id": "1512", "op": "amend-order", "args": [{"instId": "BTC-USDT", "ordId": "260420821332664322","newSz":"2"},{"instId": "BTC-USDT", "ordId": "260420821332664323","newSz":"2"}]}');


