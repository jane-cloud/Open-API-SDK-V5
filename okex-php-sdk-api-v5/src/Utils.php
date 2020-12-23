<?php

namespace okv3;

class Utils
{
    static $apiKey = '';
    static $apiSecret = '';
    static $passphrase = '';
    static $paper = 0;

    static $textToSign = '';

    const FUTURE_API_URL = 'https://www.okex.com';
//    const FUTURE_API_URL = 'https://www.vvcoin.com';
    const SERVER_TIMESTAMP_URL = '/api/general/v3/time';

    public function __construct($configs)
    {
        // 设置参数
        self::setParams($configs);
    }

    public  static  function request($requestPath, $params, $method, $cursor = false)
    {

        if (strtoupper($method) == 'GET') {
            $requestPath .= $params ? '?'.http_build_query($params) : '';
            $params = [];
        }

        $url = self::FUTURE_API_URL.$requestPath;

        $ch= curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);

        $body = $params ? json_encode($params, JSON_UNESCAPED_SLASHES) : '';
        $timestamp = self::getTimestamp();

        $sign = self::signature($timestamp, $method, $requestPath, $body, self::$apiSecret);
        $headers = self::getHeader(self::$apiKey, self::$paper,$sign, $timestamp, self::$passphrase, self::$textToSign);


        if($method == "POST") {
            curl_setopt($ch, CURLOPT_POST, true);
            curl_setopt($ch, CURLOPT_POSTFIELDS, $body);
        }

        // 设置超时时间
//        curl_setopt($ch, CURLOPT_TIMEOUT_MS,60);

        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER , TRUE);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLINFO_HEADER_OUT,true);



        // 头信息
        curl_setopt($ch, CURLOPT_HEADER, true);
//        curl_setopt($ch, CURLOPT_NOBODY,true);


        $return = curl_exec($ch);

        $headerSize = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
        $headerTotal = strlen($return);
        $bodySize = $headerTotal - $headerSize;

        $body = substr($return, $headerSize, $bodySize);


        if(!curl_errno($ch))
        {
            $info = curl_getinfo($ch,CURLINFO_HEADER_OUT);
            if (Config::$debug)
            {

            }

            switch (true)
            {
                // 全部debug
                case Config::$debug==1;
                    echo ($info);

                    // 获得响应结果里的：头大小
                $headerSize = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
//                // 根据头大小去获取头信息内容
//                $header = substr($return, 0, $headerSize);

                    print_r(substr($return, 0, $headerSize-2));
                    print_r("TIMESTAMP: ".self::getTimestamp());
                    print_r("\n\n");

                    print_r($body);
                    print_r("\n\n");
                    break;

                // 仅 response body
                case Config::$debug==2;
                    $ntime = self::getTimestamp();
                    print_r($ntime." $body\n");
                    break;
            }
        }

//        $body = substr($sContent, $headerSize, $bodySize);


//        print_r("headerSize:".$headerSize."\n");
//        print_r("headerTotal:".$headerTotal."\n");
//        print_r("bodySize:".$bodySize."\n");

        $body = json_decode($body,true);

        return $body;
    }

    public static function getHeader($apiKey, $paper, $sign, $timestamp, $passphrase, $textToSign)
    {
        $headers = array();

        $headers[] = "Content-Type: application/json";
        $headers[] = "OK-ACCESS-KEY: $apiKey";
        $headers[] = "OK-ACCESS-SIGN: $sign";
        $headers[] = "OK-ACCESS-TIMESTAMP: $timestamp";
        $headers[] = "OK-ACCESS-PASSPHRASE: $passphrase";
        $headers[] = "OK-TEXT-TO-SIGN: $textToSign";
        if ($paper == 1){
            $headers[] = "x-simulated-trading: 1";
        }

        return $headers;
    }

    // 获取IOS格式时间戳
    public static function getTimestamp()
    {
        ini_set("date.timezone","UTC");
        return date("Y-m-d\TH:i:s"). substr((string)microtime(), 1, 4) . 'Z';
    }

    // IOS格式时间戳转毫秒级时间
    function dateToTimestamp($isoTime)
    {
        @list($usec, $sec) = explode(".", $isoTime);
        $date = strtotime($usec);
        $return_data = str_pad($date.$sec,13,"0",STR_PAD_RIGHT); //不足13位。右边补0
        return substr($return_data, 0, -1);

    }

    public static function getServerTimestamp(){
        try{
            $response = file_get_contents(self::FUTURE_API_URL.self::SERVER_TIMESTAMP_URL);
            $response = json_decode($response,true);

            return $response['iso'];
        }catch (Exception $e){
            return '';
        }
    }

    public static function signature($timestamp, $method, $requestPath, $body, $secretKey)
    {
        $message = (string) $timestamp . strtoupper($method) . $requestPath . (string) $body;

        self::$textToSign = $message;

        return base64_encode(hash_hmac('sha256', $message, $secretKey, true));
    }

    public static function wsSignature($timestamp, $method, $requestPath, $body, $secretKey)
    {
        $message = (string) $timestamp . strtoupper($method) . $requestPath . (string) $body;

        $ntime = self::getTimestamp();
        print_r($ntime." TEXT-TO-SIGN:$message\n");



        return base64_encode(hash_hmac('sha256', $message, $secretKey, true));
    }

    /*
     * microsecond 微秒     millisecond 毫秒
     *返回时间戳的毫秒数部分
     */
    public static function get_millisecond()
    {
        $time = microtime(true);
        $msec=round($time*1000);

        return $msec/1000;
    }

    // 设置密钥相关参数
    public static function setParams($configs){
        self::$apiKey=$configs["apiKey"];
        self::$apiSecret=$configs["apiSecret"];
        self::$passphrase=$configs["passphrase"];
        self::$paper=$configs["paper"];

    }
}
