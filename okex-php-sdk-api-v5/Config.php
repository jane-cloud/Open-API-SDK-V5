<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/6/17
 * Time: 3:37 PM
 */

use okv3\Config;

// 是否 debug
Config::$debug=2;

Config::$config=[

    // v5 模拟环境 个人账户 key
    // PHP SDK 社区试用API，使用时，建议改为自己的API KEY
    "apiKey"=>"",
    "apiSecret"=>"",
    "passphrase"=>"",
    //是否为模拟盘
    "paper"=>1
];
