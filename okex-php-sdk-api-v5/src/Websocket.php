<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/5/10
 * Time: 8:22 PM
 */

namespace okv3;

//require '../vendor/autoload.php';

use Workerman\Lib\Timer;
use Workerman\Worker;
use Workerman\Connection\AsyncTcpConnection;
use okv3\ChecksumTest;

/*
*订阅数据函数
$callback type: function 回调函数，当获得数据时会调用
*/

error_reporting(E_ERROR | E_WARNING | E_PARSE);

class Websocket extends Utils{

    // 上一次接收信息的时间，单个频道时用
    public $oldTime=[];
    // depth 200档的全量数据，包括合并的
    public $partial=null;

    public $checksumTest;

    public $tradeVolumn=[];

    public function __construct($configs)
    {
        parent::__construct($configs);
        $this->checksumTest=new ChecksumTest();
    }


    function subscribe($callback, $sub_str="swap/ticker:BTC-USD-SWAP") {
        $GLOBALS['sub_str'] = $sub_str;
        $GLOBALS['callback'] = $callback;
        $worker = new Worker();

        // 线上
//        $url = "ws://real.okex.com:8443/ws/v3";

        $url = "ws://ws.okex.com:8443/ws/v5/public?brokerId=9999";

        $worker->onWorkerStart = function($worker) use ($url){
            // ssl需要访问443端口
            $con = new AsyncTcpConnection($url);

            $ntime = $this->getTimestamp();
            print_r($ntime." $url\n");

            // 设置以ssl加密方式访问，使之成为wss
            $con->transport = 'ssl';

            // 定时器
            Timer::add(20, function() use ($con)
            {
                $con->send("ping");
//
                $ntime = $this->getTimestamp();
                print_r($ntime." ping\n");
            });

            $con->onConnect = function($con){

                print_r("hello");

                // 登陆
                $timestamp = self::get_millisecond();
                $timestamp = time();
//                $timestamp = 1563541080.121;
                $sign = self::wsSignature($timestamp,"GET","/users/self/verify","",self::$apiSecret);

//                $args =self::$apiKey, self::$passphrase, $timestamp, $sign};
                $args = "{".self::$apiKey.",".self::$passphrase.",".$timestamp.",".$sign."}";

                $args = [
                    "apiKey"=>self::$apiKey,
                    "passphrase"=>self::$passphrase,
                    "timestamp"=>$timestamp,
                    "sign"=>$sign
                ];

                $args = json_encode($args);

                $data = json_encode([
                    'op' => "login",
                    'args' => [$args]
                ]);

                $data = '{"op":"login","args":[{'.substr($data,24,-4).'}]}';
                $data = stripslashes($data);


                $ntime = $this->getTimestamp();
                print_r($ntime." $data\n");
//                    print_r($ntime." $i $data\n");
//                $con->send($data);
//                $con->send($data);

            };

            $con->onMessage = function($con, $data) {

                // 解压数据
//                $data = gzinflate($data);

                // 如果是深度200档，则校验
                if(strpos($data,"checksum1"))
                {
                    if ($this->partial==null)
                    {
                        $this->partial=$data;
                    }else{
                        $update = $data;

                        // 深度合并
                        $data = $this->checksumTest->depthMerge($this->partial,$update);

                        // 深度校验结果
                        $result = $this->checksumTest->checksum($data);

                        if ($result){
                            print_r("---------------------------------------------------------------\n");
                            print_r(self::getTimestamp()." checksum success\n");
                        } else {
                            die(self::getTimestamp()." checksum fail\n");
                        }

                        // 打印增量数据
                        call_user_func_array($GLOBALS['callback'], array($update));

                        // 更新全局的全量数据
                        $this->partial = $data;
                    }
//                    print_r("深度\n") ;
                }

                call_user_func_array($GLOBALS['callback'], array($data));

                $data = json_decode($data, true);

                if (isset($data["success"])){
                    // 订阅频道
                    $data = json_encode([
                        'op' => "subscribe",
//                        'args' => $GLOBALS['sub_str']
                        'args' => [
                            $GLOBALS['sub_str']
                        ]
                    ]);

//                    $data = json_encode($GLOBALS['sub_str']);
                    $data = stripslashes($data);
//                    $data = substr($data,1,strlen());
                    $data = '{"op":"subscribe","args":[{'.substr($data,28,-4).'}]}';


                    var_dump($data);
                    $ntime = $this->getTimestamp();
                    print_r($ntime . " $data\n");

                    $con->send($data);
//                    $con->send($data);
                }
            };

            $con->onClose = function ($con) {

                $ntime = $this->getTimestamp();

                print_r($ntime." reconnecting\n");

                $con->reConnect(0);
            };

            $con->connect();
        };

        Worker::runAll();
    }

}

//subscribe(function ($data){print_r(json_encode($data,JSON_PRETTY_PRINT));}, "swap/ticker:BTC-USD-SWAP");
