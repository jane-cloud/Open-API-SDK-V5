<?php

namespace okv5;

class Utils
{
    static $apiKey = '';
    static $apiSecret = '';
    static $passphrase = '';
    static $paper = 0;

    static $textToSign = '';

    const FUTURE_API_URL = 'https://www.okx.com';

    public function __construct($configs)
    {
        // 设置参数
        self::setParams($configs);
    }

    public  static  function request($requestPath, $params, $method, $cursor = false)
    {
        print_r($params);
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
//        echo $url;
//        echo "请求头";
        print_r($headers);

        if($method == "POST") {
            curl_setopt($ch, CURLOPT_POST, true);
            curl_setopt($ch, CURLOPT_POSTFIELDS, $body);
        }

        // 设置超时时间
//        curl_setopt($ch, CURLOPT_TIMEOUT_MS,60);

        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER , FALSE);
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

      $body = json_decode($body,true);
$body['okx_Msg']='';
if (isset( $body ['code']) && $body ['code']!="0"){ 
   

    if (isset( $body['data']['0']['sCode']) ){ 
        $body['okx_Msg']=self::okx_getcodeS($body['data']['0']['sCode']);
    }else{
        $body['okx_Msg']=self::okx_getcodeS($body ['code']);
    }
   
}
$body = json_encode($body);
        return $body;
    }
    /**
     * 错误码对应表
     * @param string $str 原数据
     */
    public static function okx_getcodeS($code){
        $Msg_ = [['code'=>'1','Msg'=>'操作全部失败'],['code'=>'2','Msg'=>'批量操作部分成功'],['code'=>'50000','Msg'=>'body不能为空'],['code'=>'50001','Msg'=>'服务暂时不可用，请稍后重试'],['code'=>'50002','Msg'=>'非法的json数据'],['code'=>'50004','Msg'=>'接口请求超时（不代表请求成功或者失败，请检查请求结果）'],['code'=>'50005','Msg'=>'接口已下线或无法使用'],['code'=>'50006','Msg'=>'无效的Content_Type，请使用&quot;application/json&quot;格式'],['code'=>'50007','Msg'=>'用户被冻结'],['code'=>'50008','Msg'=>'用户不存在'],['code'=>'50009','Msg'=>'用户处于爆仓冻结'],['code'=>'50010','Msg'=>'用户ID为空'],['code'=>'50011','Msg'=>'用户请求频率过快，超过该接口允许的限额'],['code'=>'50012','Msg'=>'用户状态无效'],['code'=>'50013','Msg'=>'当前系统繁忙，请稍后重试'],['code'=>'50014','Msg'=>'必填参数{0}不能为空'],['code'=>'50015','Msg'=>'参数{0}和{1}不能同时为空'],['code'=>'50016','Msg'=>'参数{0}和{1}不匹配'],['code'=>'50017','Msg'=>'当前仓位处于ADL冻结中，无法进行相关操作'],['code'=>'50018','Msg'=>'{0}币种处于ADL冻结中，无法进行相关操作'],['code'=>'50019','Msg'=>'当前账户处于ADL冻结中，无法进行相关操作'],['code'=>'50020','Msg'=>'当前仓位处于强平冻结中，无法进行相关操作'],['code'=>'50021','Msg'=>'{0}币种处于强平冻结中，无法进行相关操作'],['code'=>'50022','Msg'=>'当前账户处于强平冻结中，无法进行相关操作'],['code'=>'50023','Msg'=>'资金费冻结，无法进行相关操作'],['code'=>'50024','Msg'=>'参数{0}和{1}不能同时存在'],['code'=>'50025','Msg'=>'参数{0}传值个数超过最大限制{1}'],['code'=>'50026','Msg'=>'系统错误，请稍后重试'],['code'=>'50027','Msg'=>'当前账户已被限制交易'],['code'=>'50028','Msg'=>'账户异常无法下单'],['code'=>'50029','Msg'=>'你的账户已经触发风控体系，禁止该标的{0}交易，请联系客服进行处理'],['code'=>'50030','Msg'=>'用户没有使用此API接口的权限'],['code'=>'50032','Msg'=>'您的账户已设置禁止该币种交易，请确认后重试'],['code'=>'50033','Msg'=>'您的账户已设置禁止该业务线交易，请确认后重试'],['code'=>'50034','Msg'=>'您当前不在白名单列表，请联系客服'],['code'=>'50035','Msg'=>'该接口要求APIKey必须绑定IP'],['code'=>'50036','Msg'=>'无效的expTime'],['code'=>'50037','Msg'=>'订单已过期'],['code'=>'50038','Msg'=>'该功能模拟盘暂不支持'],['code'=>'50039','Msg'=>'时间戳分页时，不支持使用before参数'],['code'=>'50100','Msg'=>'Api 已被冻结，请联系客服处理'],['code'=>'50101','Msg'=>'APIKey 与当前环境不匹配'],['code'=>'50102','Msg'=>'请求时间戳过期'],['code'=>'50103','Msg'=>'请求头&quot;OK_ACCESS_KEY&quot;不能为空'],['code'=>'50104','Msg'=>'请求头&quot;OK_ACCESS_PASSPHRASE&quot;不能为空'],['code'=>'50105','Msg'=>'请求头&quot;OK_ACCESS_PASSPHRASE&quot;错误'],['code'=>'50106','Msg'=>'请求头&quot;OK_ACCESS_SIGN&quot;不能为空'],['code'=>'50107','Msg'=>'请求头&quot;OK_ACCESS_TIMESTAMP&quot;不能为空'],['code'=>'50108','Msg'=>'券商ID不存在'],['code'=>'50109','Msg'=>'券商域名不存在'],['code'=>'50110','Msg'=>'您的IP{0}不在APIKey绑定IP名单中 (您可以将您的IP加入到APIKey绑定白名单中)'],['code'=>'50111','Msg'=>'无效的OK_ACCESS_KEY'],['code'=>'50112','Msg'=>'无效的OK_ACCESS_TIMESTAMP'],['code'=>'50113','Msg'=>'无效的签名'],['code'=>'50114','Msg'=>'无效的授权'],['code'=>'50115','Msg'=>'无效的请求类型'],['code'=>'51000','Msg'=>'{0}参数错误'],['code'=>'51001','Msg'=>'交易产品ID不存在'],['code'=>'51002','Msg'=>'交易产品ID不匹配指数'],['code'=>'51003','Msg'=>'ordId或clOrdId至少填一个'],['code'=>'51004','Msg'=>'委托数量超过用户当前档位，请调低杠杆'],['code'=>'51005','Msg'=>'委托数量大于单笔上限'],['code'=>'51006','Msg'=>'委托价格不在限价范围内（最高买入价：{0}，最低卖出价：{1}）'],['code'=>'51007','Msg'=>'委托失败，委托数量不可小于 1 张（用户下单数量不足 1 张时）'],['code'=>'51008','Msg'=>'委托失败，账户 {0} 可用余额不足'],['code'=>'51008','Msg'=>'委托失败，账户 {0} 可用保证金不足'],['code'=>'51008','Msg'=>'委托失败，账户 {0} 可用余额不足，且未开启自动借币'],['code'=>'51008','Msg'=>'委托失败，账户 {0} 可用保证金不足，且未开启自动借币'],['code'=>'51008','Msg'=>'委托失败，因为 {0} 剩余的档位限额不足，导致可借不足（需借：{1}， 剩余额度{2}，限额 {3}，已用额度{4}）'],['code'=>'51008','Msg'=>'委托失败，因为 {0} 剩余的母账户限额不足，导致可借不足（需借 {1}，剩余额度 {2}，限额 {3}，已用额度 {4}）'],['code'=>'51008','Msg'=>'委托失败，因为 {0} 剩余的币对限额不足，导致可借不足'],['code'=>'51008','Msg'=>'委托失败，因为 {0} 剩余的借贷池限额不足，导致可借不足'],['code'=>'51008','Msg'=>'委托失败，账户资产不足，美金层面有效保证金小于 IMR'],['code'=>'51008','Msg'=>'委托失败，账户资产不足，且 Delta 校验不通过'],['code'=>'51008','Msg'=>'委托失败，账户余额不足'],['code'=>'51009','Msg'=>'下单功能被平台冻结'],['code'=>'51010','Msg'=>'当前账户模式不支持此操作'],['code'=>'51011','Msg'=>'ordId重复'],['code'=>'51012','Msg'=>'币种不存在'],['code'=>'51014','Msg'=>'指数不存在'],['code'=>'51015','Msg'=>'instId和instType不匹配'],['code'=>'51016','Msg'=>'clOrdId重复'],['code'=>'51017','Msg'=>'杠杆委托交易借币超出限额'],['code'=>'51018','Msg'=>'期权交易账户不能有净空头持仓'],['code'=>'51019','Msg'=>'期权全仓不能有净多头持仓'],['code'=>'51020','Msg'=>'委托数量必须超过单笔下限'],['code'=>'51021','Msg'=>'合约待上线'],['code'=>'51022','Msg'=>'合约暂停中'],['code'=>'51023','Msg'=>'仓位不存在'],['code'=>'51024','Msg'=>'交易账户冻结'],['code'=>'51025','Msg'=>'委托笔数超限'],['code'=>'51026','Msg'=>'交易产品类型不匹配指数（instType和uly不匹配）'],['code'=>'51027','Msg'=>'合约已到期'],['code'=>'51028','Msg'=>'合约交割中'],['code'=>'51029','Msg'=>'合约结算中'],['code'=>'51030','Msg'=>'资金费结算中'],['code'=>'51031','Msg'=>'委托价格不在平仓限价范围内'],['code'=>'51032','Msg'=>'市价全平中'],['code'=>'51033','Msg'=>'币对单笔交易已达限额'],['code'=>'51041','Msg'=>'PM账户仅支持买卖模式'],['code'=>'51044','Msg'=>'当前订单类型{0}， {1}不支持设置止盈和止损'],['code'=>'51046','Msg'=>'止盈触发价格应该大于委托价格'],['code'=>'51047','Msg'=>'止损触发价格应该小于委托价格'],['code'=>'51048','Msg'=>'止盈触发价格应该小于委托价格'],['code'=>'51049','Msg'=>'止损触发价格应该大于委托价格'],['code'=>'51050','Msg'=>'止盈触发价格应该大于卖一价'],['code'=>'51051','Msg'=>'止损触发价格应该小于卖一价'],['code'=>'51052','Msg'=>'止盈触发价格应该小于买一价'],['code'=>'51053','Msg'=>'止损触发价格应该大于买一价'],['code'=>'51054','Msg'=>'获取信息超时，请稍候重试'],['code'=>'51055','Msg'=>'组合保证金模式暂不支持合约网格'],['code'=>'51056','Msg'=>'当前策略不支持该操作'],['code'=>'51057','Msg'=>'简单交易模式下不可用合约网格'],['code'=>'51058','Msg'=>'该策略无仓位'],['code'=>'51059','Msg'=>'策略当前状态不支持此操作'],['code'=>'51101','Msg'=>'超出单笔最大挂单张数'],['code'=>'51102','Msg'=>'超出合约最大挂单数量'],['code'=>'51103','Msg'=>'超出标的最大挂单数量'],['code'=>'51104','Msg'=>'超出标的最大挂单张数'],['code'=>'51105','Msg'=>'超出合约最大可开张数'],['code'=>'51106','Msg'=>'超出标的最大可开张数'],['code'=>'51107','Msg'=>'超出标的最大持仓张数'],['code'=>'51108','Msg'=>'持仓量超过市价全平最大限制'],['code'=>'51109','Msg'=>'订单深度中无买一卖一价'],['code'=>'51110','Msg'=>'集合竞价开始后方可下限价单'],['code'=>'51111','Msg'=>'批量下单时，超过最大单数{0}'],['code'=>'51112','Msg'=>'平仓张数大于该仓位的可平张数'],['code'=>'51113','Msg'=>'市价全平操作过于频繁'],['code'=>'51115','Msg'=>'市价全平前请先撤销所有平仓单'],['code'=>'51116','Msg'=>'委托价格或触发价格超过{0}美元'],['code'=>'51117','Msg'=>'平仓单挂单单数超过限制'],['code'=>'51120','Msg'=>'下单数量不足{0}张'],['code'=>'51121','Msg'=>'下单张数应为一手张数的倍数'],['code'=>'51122','Msg'=>'委托价格小于最小值{0}'],['code'=>'51124','Msg'=>'价格发现期间您只可下限价单'],['code'=>'51125','Msg'=>'当前杠杆存在非只减仓挂单，请撤销所有非只减仓挂单后进行只减仓挂单'],['code'=>'51126','Msg'=>'当前杠杆存在只减仓挂单，请撤销所有只减仓挂单后进行非只减仓挂单'],['code'=>'51127','Msg'=>'仓位可用余额为0'],['code'=>'51128','Msg'=>'跨币种账户无法进行全仓杠杆交易'],['code'=>'51129','Msg'=>'持仓及买入订单价值已达到持仓限额，不允许继续买入'],['code'=>'51130','Msg'=>'逐仓杠杆保证金币种错误'],['code'=>'51131','Msg'=>'仓位可用余额不足'],['code'=>'51132','Msg'=>'仓位正资产小于最小交易单位'],['code'=>'51133','Msg'=>'跨币种全仓币币不支持只减仓功能'],['code'=>'51134','Msg'=>'平仓失败，请检查持仓和挂单'],['code'=>'51135','Msg'=>'您的平仓价格已触发限价，最高买入价格为{0}'],['code'=>'51136','Msg'=>'您的平仓价格已触发限价，最低卖出价格为{0}'],['code'=>'51137','Msg'=>'您的开仓价格已触发限价，最高买入价格为{0}'],['code'=>'51138','Msg'=>'您的开仓价格已触发限价，最低卖出价格为{0}'],['code'=>'51139','Msg'=>'交易账户下币币不支持只减仓功能'],['code'=>'51143','Msg'=>'您的询价失败，请稍后重试'],['code'=>'51145','Msg'=>'逐仓自主划转保证金模式不支持提前挂单'],['code'=>'51147','Msg'=>'交易账户资产总价值需要大于5万美元来交易期权'],['code'=>'51148','Msg'=>'只减仓委托仅允许减少仓位数量，确保你的仓位不会增加'],['code'=>'51149','Msg'=>'下单超时，请稍候重试'],['code'=>'51150','Msg'=>'交易数量或价格的精度超过限制'],['code'=>'51201','Msg'=>'市价委托单笔价值不能超过 1,000,000 USDT'],['code'=>'51202','Msg'=>'市价单下单数量超出最大值'],['code'=>'51203','Msg'=>'普通委托数量超出最大限制{0}'],['code'=>'51204','Msg'=>'限价委托单价格不能为空'],['code'=>'51205','Msg'=>'不支持只减仓操作'],['code'=>'51206','Msg'=>'请先撤销当前下单产品{0}的只减仓挂单，避免反向开仓'],['code'=>'51250','Msg'=>'策略委托价格不在正确范围内'],['code'=>'51251','Msg'=>'策略委托类型错误'],['code'=>'51252','Msg'=>'策略委托数量不在正确范围内'],['code'=>'51253','Msg'=>'冰山委托单笔均值超限'],['code'=>'51254','Msg'=>'冰山委托单笔均值错误'],['code'=>'51255','Msg'=>'冰山委托单笔委托超限'],['code'=>'51256','Msg'=>'冰山委托深度错误'],['code'=>'51257','Msg'=>'跟踪委托回调服务错误，回调幅度限制为{0}&lt;x&lt;={1}%'],['code'=>'51258','Msg'=>'跟踪委托失败，卖单激活价格需大于最新成交价格'],['code'=>'51259','Msg'=>'跟踪委托失败，买单激活价格需小于最新成交价格'],['code'=>'51260','Msg'=>'每个用户最多可同时持有{0}笔未成交的跟踪委托'],['code'=>'51261','Msg'=>'每个用户最多可同时持有{0}笔未成交的止盈止损'],['code'=>'51262','Msg'=>'每个用户最多可同时持有{0}笔未成交的冰山委托'],['code'=>'51263','Msg'=>'每个用户最多可同时持有{0}笔未成交的时间加权单'],['code'=>'51264','Msg'=>'时间加权单笔均值超限'],['code'=>'51265','Msg'=>'时间加权单笔上限错误'],['code'=>'51267','Msg'=>'时间加权扫单比例出错'],['code'=>'51268','Msg'=>'时间加权扫单范围出错'],['code'=>'51269','Msg'=>'时间加权委托间隔错误，应为{0}&lt;=x&lt;={1}'],['code'=>'51270','Msg'=>'时间加权委托深度限制为 0&lt;x&lt;=1%'],['code'=>'51271','Msg'=>'时间加权委托失败，扫单比例应该为 0&lt;x&lt;=100%'],['code'=>'51272','Msg'=>'时间加权委托失败，扫单范围应该为 0&lt;x&lt;=1%'],['code'=>'51273','Msg'=>'时间加权委托总量应为大于 0'],['code'=>'51274','Msg'=>'时间加权委托总数量需大于单笔上限'],['code'=>'51275','Msg'=>'止盈止损市价单笔委托数量不能超过最大限制'],['code'=>'51276','Msg'=>'止盈止损市价单不能指定价格'],['code'=>'51277','Msg'=>'止盈触发价格不能大于最新成交价'],['code'=>'51278','Msg'=>'止损触发价格不能小于最新成交价'],['code'=>'51279','Msg'=>'止盈触发价格不能小于最新成交价'],['code'=>'51280','Msg'=>'止损触发价格不能大于最新成交价'],['code'=>'51281','Msg'=>'计划委托不支持使用tgtCcy参数'],['code'=>'51282','Msg'=>'吃单价优于盘口的比例范围'],['code'=>'51283','Msg'=>'时间间隔的范围{0}s~{1}s'],['code'=>'51284','Msg'=>'单笔数量的范围{0}~{1}'],['code'=>'51285','Msg'=>'委托总量的范围{0}~{1}'],['code'=>'51286','Msg'=>'下单金额需大于等于{0}'],['code'=>'51287','Msg'=>'策略不支持此合约'],['code'=>'51288','Msg'=>'策略正在停止中，请勿重复点击'],['code'=>'51289','Msg'=>'策略配置不存在，请稍后再试'],['code'=>'51290','Msg'=>'策略引擎正在升级，请稍后重试'],['code'=>'51291','Msg'=>'策略不存在或已停止'],['code'=>'51292','Msg'=>'策略类型不存在'],['code'=>'51293','Msg'=>'策略不存在'],['code'=>'51294','Msg'=>'该策略暂不能创建，请稍后再试'],['code'=>'51295','Msg'=>'PM账户不支持ordType为{0}的策略委托单'],['code'=>'51298','Msg'=>'交割、永续合约的买卖模式下，不支持计划委托'],['code'=>'51299','Msg'=>'策略委托失败，用户最多可持有{0}笔该类型委托'],['code'=>'51300','Msg'=>'止盈触发价格不能大于标记价格'],['code'=>'51302','Msg'=>'止损触发价格不能小于标记价格'],['code'=>'51303','Msg'=>'止盈触发价格不能小于标记价格'],['code'=>'51304','Msg'=>'止损触发价格不能大于标记价格'],['code'=>'51305','Msg'=>'止盈触发价格不能大于指数价格'],['code'=>'51306','Msg'=>'止损触发价格不能小于指数价格'],['code'=>'51307','Msg'=>'止盈触发价格不能小于指数价格'],['code'=>'51308','Msg'=>'止损触发价格不能大于指数价格'],['code'=>'51309','Msg'=>'集合竞价期间不能创建策略'],['code'=>'51310','Msg'=>'逐仓自主划转保证金模式不支持ordType为iceberg、twap的策略委托单'],['code'=>'51311','Msg'=>'移动止盈止损委托失败，回调幅度限制为{0}&lt;x&lt;={1}'],['code'=>'51312','Msg'=>'移动止盈止损委托失败，委托数量范围{0}&lt;x&lt;={1}'],['code'=>'51313','Msg'=>'逐仓自主划转模式不支持策略部分'],['code'=>'51317','Msg'=>'币币杠杆不支持计划委托'],['code'=>'51340','Msg'=>'投入保证金需大于{0}{1}'],['code'=>'51341','Msg'=>'当前策略状态下暂不支持平仓'],['code'=>'51342','Msg'=>'已有平仓单，请稍后重试'],['code'=>'51343','Msg'=>'止盈价格需小于区间最低价格'],['code'=>'51344','Msg'=>'止损价格需大于区间最高价格'],['code'=>'51345','Msg'=>'策略类型不是网格策略'],['code'=>'51346','Msg'=>'最高价格不能低于最低价格'],['code'=>'51347','Msg'=>'暂无可提取利润'],['code'=>'51348','Msg'=>'止损价格需小于区间最低价格'],['code'=>'51349','Msg'=>'止盈价格需大于区间最高价格'],['code'=>'51350','Msg'=>'暂无可推荐参数'],['code'=>'51351','Msg'=>'单格收益必须大于0'],['code'=>'51370','Msg'=>'杠杆倍数范围{0}~{1}'],['code'=>'51037','Msg'=>'当前账户风险状态，仅支持降低账户风险方向的IOC订单'],['code'=>'51038','Msg'=>'当前风险模块下已经存在降低账户风险方向的IOC类型订单'],['code'=>'51039','Msg'=>'PM账户下交割和永续的全仓不能调整杠杆倍数'],['code'=>'51040','Msg'=>'期权逐仓的买方不能调整保证金'],['code'=>'51400','Msg'=>'撤单失败，订单不存在'],['code'=>'51401','Msg'=>'撤单失败，订单已撤销'],['code'=>'51402','Msg'=>'撤单失败，订单已完成'],['code'=>'51403','Msg'=>'撤单失败，该委托类型无法进行撤单操作'],['code'=>'51404','Msg'=>'价格发现第二阶段您不可撤单'],['code'=>'51405','Msg'=>'撤单失败，您当前没有未成交的订单'],['code'=>'51406','Msg'=>'撤单数量超过最大允许单数{0}'],['code'=>'51407','Msg'=>'ordIds 和 clOrdIds 不能同时为空'],['code'=>'51408','Msg'=>'币对 id 或币对名称与订单信息不匹配'],['code'=>'51409','Msg'=>'币对 id 或币对名称不能同时为空'],['code'=>'51410','Msg'=>'撤单失败，订单已处于撤销中'],['code'=>'51411','Msg'=>'用户没有执行mass cancel的权限'],['code'=>'51412','Msg'=>'委托已触发，暂不支持撤单'],['code'=>'51415','Msg'=>'下单失败，现货交易仅支持设置最新价为触发价格，请更改触发价格并重试'],['code'=>'51500','Msg'=>'价格和数量不能同时为空'],['code'=>'51501','Msg'=>'修改订单超过最大允许单数{0}'],['code'=>'51502','Msg'=>'修改订单失败，用户保证金不足'],['code'=>'51503','Msg'=>'修改订单失败，订单不存在'],['code'=>'51506','Msg'=>'订单类型不支持改单'],['code'=>'51508','Msg'=>'集合竞价第一阶段和第二阶段不允许改单'],['code'=>'51509','Msg'=>'修改订单失败，订单已撤销'],['code'=>'51510','Msg'=>'修改订单失败，订单已完成'],['code'=>'51511','Msg'=>'操作失败，订单价格不满足Post Only条件'],['code'=>'51512','Msg'=>'批量修改订单失败。同一批量改单请求中不允许包含相同订单。'],['code'=>'51513','Msg'=>'对于正在处理的同一订单，改单请求次数不得超过3次'],['code'=>'51600','Msg'=>'查询订单的状态不存在'],['code'=>'51601','Msg'=>'订单状态和订单id不能同时存在'],['code'=>'51602','Msg'=>'订单状态或订单id必须存在一个'],['code'=>'51603','Msg'=>'查询订单不存在'],['code'=>'51607','Msg'=>'文件正在生成中'],['code'=>'52000','Msg'=>'没有最新行情信息'],['code'=>'51720','Msg'=>'赎回失败'],['code'=>'51721','Msg'=>'取消赎回失败'],['code'=>'51722','Msg'=>'赎回已到账'],['code'=>'51723','Msg'=>'不支持提前赎回'],['code'=>'51724','Msg'=>'当前状态不支持赎回'],['code'=>'51725','Msg'=>'当前状态不支持取消'],['code'=>'51726','Msg'=>'该项目不支持撤销申购/赎回'],['code'=>'51727','Msg'=>'申购数量低于最小值'],['code'=>'51728','Msg'=>'申购数量超过最大值'],['code'=>'51729','Msg'=>'该项目尚未到期'],['code'=>'51730','Msg'=>'该项目已售罄'],['code'=>'52900','Msg'=>'无效请求'],['code'=>'52901','Msg'=>'无效基准货币'],['code'=>'52902','Msg'=>'无效标价货币'],['code'=>'52903','Msg'=>'无效的报价数量'],['code'=>'52904','Msg'=>'无效的报价方向'],['code'=>'52905','Msg'=>'无效的报价'],['code'=>'52907','Msg'=>'订单找不到'],['code'=>'52908','Msg'=>'无效的订单ID'],['code'=>'52909','Msg'=>'客户自定义ID重复使用'],['code'=>'52910','Msg'=>'服务端暂时不可用，请稍后重试'],['code'=>'52911','Msg'=>'询价服务不可用，请稍后重试'],['code'=>'52912','Msg'=>'服务端超时'],['code'=>'52913','Msg'=>'拒绝交易'],['code'=>'52915','Msg'=>'询价量太大，流动性不足导致无法报价，请稍后重试'],['code'=>'52916','Msg'=>'资金账户余额不足'],['code'=>'52917','Msg'=>'询价数量不能低于下限'],['code'=>'52918','Msg'=>'询价数量不能超过上限'],['code'=>'52919','Msg'=>'闪兑交易参数{param}与报价不一致'],['code'=>'52920','Msg'=>'闪兑交易数量不能超过报价数量'],['code'=>'52921','Msg'=>'报价已交易，请重新询价'],['code'=>'52922','Msg'=>'报价已过期，请重新询价'],['code'=>'52923','Msg'=>'服务异常，请稍后重试'],['code'=>'54000','Msg'=>'暂不支持币币杠杆业务'],['code'=>'54001','Msg'=>'只有跨币种全仓账户才能设置自动借币'],['code'=>'55000','Msg'=>'交割后30分钟内不能转出'],['code'=>'58002','Msg'=>'请先开通余币宝服务'],['code'=>'58003','Msg'=>'余币宝不支持该币种'],['code'=>'58004','Msg'=>'账户冻结'],['code'=>'58005','Msg'=>'申购/赎回额度不可超过{0}'],['code'=>'58006','Msg'=>'币种{0}不支持当前操作'],['code'=>'58007','Msg'=>'资金接口服务异常，请稍后再试。'],['code'=>'58008','Msg'=>'您没有该币种资产'],['code'=>'58009','Msg'=>'币对不存在'],['code'=>'58010','Msg'=>'该链{0}暂不支持'],['code'=>'58011','Msg'=>'抱歉，由于当地法律法规，欧易无法为{region}未认证用户提供服务，请先认证身分以继续使用欧易'],['code'=>'58012','Msg'=>'抱歉，由于当地法律法规，欧易无法为{region}未认证用户提供服务，所以您无法向该用户转账'],['code'=>'58100','Msg'=>'行权或结算中，暂无法转入或转出'],['code'=>'58101','Msg'=>'划转冻结'],['code'=>'58102','Msg'=>'划转过于频繁，请降低划转频率'],['code'=>'58104','Msg'=>'您在法币区的交易异常，现已被限制划转功能，请您联系在线客服以解除限制'],['code'=>'58105','Msg'=>'您在法币区的交易异常，现已被限制划转功能，请您在网页或APP进行法币划<br>转操作以完成身份验证'],['code'=>'58107','Msg'=>'请先开通交割合约账户'],['code'=>'58108','Msg'=>'请先开通期权合约账户'],['code'=>'58109','Msg'=>'请先开通永续合约账户'],['code'=>'58110','Msg'=>'当前交易产品触发市场风控，平台已暂停相关用户的资金转出功能，请耐心等待'],['code'=>'58111','Msg'=>'永续合约正在收取资金费，暂时无法做资金划转，请稍后重试'],['code'=>'58112','Msg'=>'资金划转失败，请稍后重试'],['code'=>'58114','Msg'=>'转账金额必须大于零（划转接口，金额输入不正确）'],['code'=>'58115','Msg'=>'子账户不存在'],['code'=>'58116','Msg'=>'转出数量大于最大可转数量'],['code'=>'58117','Msg'=>'账户资产异常，请先处理负资产后再划转'],['code'=>'58119','Msg'=>'{0} 子账户没有转出权限，请先设置'],['code'=>'58120','Msg'=>'划转服务暂不可用，请稍后重试'],['code'=>'58121','Msg'=>'此次划转将导致您的仓位风险水平较高，进而可能引起爆仓。您需要重新调整划转金额，确保仓位处于安全水平后，再进行划转操作。'],['code'=>'58122','Msg'=>'您的一部分现货正用于仓位间的 Delta 对冲，若划转数量超过可用金额，可能会影响现有的现货对冲结构，进而导致维持保证金率增加，请留意您的风险水平。'],['code'=>'58123','Msg'=>'from和to不可相同'],['code'=>'58124','Msg'=>'资金划转中，划转id：{trId}，请通过接口(GET /api/v5/asset/transfer-state)获取最新状态'],['code'=>'58200','Msg'=>'该币种暂不支持从{0}提现至{1}，敬请谅解'],['code'=>'58201','Msg'=>'今日提现金额累计超过每日限额'],['code'=>'58202','Msg'=>'NEO最小提现数量为1，且提现数量必须为整数'],['code'=>'58203','Msg'=>'请先添加提现地址'],['code'=>'58204','Msg'=>'提现冻结'],['code'=>'58205','Msg'=>'提现金额大于单笔提现最大金额（单笔提现最大金额提现接口，提现金额输入有误）'],['code'=>'58206','Msg'=>'提现金额小于最小提现金额（最小提现金额提现接口，提现金额输入有误）'],['code'=>'58207','Msg'=>'提币地址不在免认证白名单内'],['code'=>'58208','Msg'=>'提现失败，邮箱未绑定'],['code'=>'58209','Msg'=>'子账户不能充值或提现'],['code'=>'58210','Msg'=>'提现手续费大于最大值（提现接口，提现手续费输入有误）'],['code'=>'58211','Msg'=>'提现手续费小于最小值（提现接口，手续费输入有误）'],['code'=>'58212','Msg'=>'提现手续费应填写为提币数量的{0}%'],['code'=>'58213','Msg'=>'提现前请先设置交易密码'],['code'=>'58214','Msg'=>'{chainName}维护中，暂停提币'],['code'=>'58215','Msg'=>'提币申请ID不存在'],['code'=>'58216','Msg'=>'不允许执行该操作'],['code'=>'58217','Msg'=>'您当前的提现地址存在风险，暂时不能提现，详情请联系客服'],['code'=>'58218','Msg'=>'您保存的提现账户已过期'],['code'=>'58220','Msg'=>'提币请求已撤销'],['code'=>'58221','Msg'=>'提币地址需要标签'],['code'=>'58222','Msg'=>'提币地址不合法'],['code'=>'58224','Msg'=>'该类型币种暂不支持链上提币到 OKX 地址，请通过内部转账进行提币'],['code'=>'58225','Msg'=>'抱歉，由于当地法律法规，欧易无法为{region}未认证用户提供服务，所以您无法向该用户转账'],['code'=>'58300','Msg'=>'创建充值地址超过上限'],['code'=>'58301','Msg'=>'充值地址不存在'],['code'=>'58302','Msg'=>'充值地址需要标签'],['code'=>'58303','Msg'=>'该链{0}充值已关闭'],['code'=>'58304','Msg'=>'创建invoice失败'],['code'=>'58350','Msg'=>'您的余额不足'],['code'=>'58351','Msg'=>'invoice已经过期'],['code'=>'58352','Msg'=>'invoice无效'],['code'=>'58353','Msg'=>'充币数量需要在限额范围内'],['code'=>'58354','Msg'=>'单日达到生成invoice10000个的上限'],['code'=>'58355','Msg'=>'用户没有使用此API接口的权限'],['code'=>'58356','Msg'=>'同节点账户不支持闪电网络充币或提币'],['code'=>'58357','Msg'=>'币种{0}不允许创建充值地址'],['code'=>'58358','Msg'=>'fromCcy与toCcy不可相同'],['code'=>'58370','Msg'=>'小额兑换功能每日使用次数超限'],['code'=>'58371','Msg'=>'小额资产超过最大限制'],['code'=>'58372','Msg'=>'小额资产不足'],['code'=>'59000','Msg'=>'挂单或持仓存在，无法设置'],['code'=>'59001','Msg'=>'当前存在借币，暂不可切换'],['code'=>'59004','Msg'=>'只支持同一业务线下交易产品ID'],['code'=>'59005','Msg'=>'逐仓自主划转保证金模式，初次划入仓位的资产价值需大于10000USDT'],['code'=>'59100','Msg'=>'当前存在持仓，请撤销所有挂单后进行杠杆倍数修改'],['code'=>'59101','Msg'=>'当前业务存在逐仓挂单，请撤销所有挂单后进行杠杆倍数修改'],['code'=>'59102','Msg'=>'杠杆倍数超过最大杠杆倍数，请重新调整杠杆倍数'],['code'=>'59103','Msg'=>'杠杆倍数过低，账户中没有足够的可用保证金可以追加，请重新调整杠杆倍数'],['code'=>'59104','Msg'=>'杠杆倍数过高，借币仓位已超过该杠杆倍数的最大仓位，请重新调整杠杆倍数'],['code'=>'59105','Msg'=>'杠杆倍数设置不能小于{0}，请重新调整杠杆倍数'],['code'=>'59106','Msg'=>'您下单后仓位总张数所处档位的最高可用杠杆为{0}，请重新调整'],['code'=>'59107','Msg'=>'当前业务存在全仓挂单，请撤销所有挂单后进行杠杆倍数修改'],['code'=>'59108','Msg'=>'杠杆倍数过低，账户中保证金不足，请重新调整杠杆倍数'],['code'=>'59109','Msg'=>'调整后，账户权益小于所需保证金，请重新调整杠杆倍数'],['code'=>'59110','Msg'=>'该{0}对应的产品业务线不支持使用tgtCcy参数'],['code'=>'59111','Msg'=>'PM账户下衍生品全仓不支持杠杆查询'],['code'=>'59112','Msg'=>'当前存在逐仓/全仓挂单，请撤销所有逐仓挂单后进行杠杆倍数修改'],['code'=>'59200','Msg'=>'账户余额不足'],['code'=>'59201','Msg'=>'账户余额是负数'],['code'=>'59300','Msg'=>'追加保证金失败，指定仓位不存在'],['code'=>'59301','Msg'=>'调整保证金超过当前最大可调整数量'],['code'=>'59302','Msg'=>'当前仓位存在平仓挂单，请撤销平仓挂单后进行保证金修改'],['code'=>'59303','Msg'=>'可用保证金不足，请尝试增加保证金或减少借币数量'],['code'=>'59304','Msg'=>'借币币种权益不足，请至少留有一天的利息'],['code'=>'59305','Msg'=>'您当前没有进行尊享借币，无法设置尊享借币优先'],['code'=>'59306','Msg'=>'借币数量超过总额度，不可继续借币'],['code'=>'59307','Msg'=>'当前用户不满足尊享借币条件'],['code'=>'59308','Msg'=>'市场化借币额度不足，VIP还币失败'],['code'=>'59309','Msg'=>'还币数量超出已借数量，还币失败'],['code'=>'59310','Msg'=>'当前账户不支持尊享借币'],['code'=>'59311','Msg'=>'存在尊享借币，无法设置'],['code'=>'59312','Msg'=>'{币种}不支持尊享借币'],['code'=>'59401','Msg'=>'持仓价值达到持仓限制'],['code'=>'59402','Msg'=>'查询条件中的instId的交易产品当前不是可交易状态，请填写单个instid逐个查询状态详情'],['code'=>'59500','Msg'=>'仅母账户有操作权限'],['code'=>'59501','Msg'=>'每个账户最多可创建 50个APIKey'],['code'=>'59502','Msg'=>'备注名不可以与当前已创建的APIKey备注名重复'],['code'=>'59503','Msg'=>'每个 APIKey 最多可以绑定20个IP地址'],['code'=>'59504','Msg'=>'子账户不支持提币功能'],['code'=>'59505','Msg'=>'passphrase 格式不正确，支持6-32位字母和数字组合<br>（区分大小写，不支持空格符号）'],['code'=>'59506','Msg'=>'APIKey 不存在'],['code'=>'59507','Msg'=>'转出账户和转入账户必须是同一个母账户下的2个不同的子账户'],['code'=>'59508','Msg'=>'{0}该子账户被冻结'],['code'=>'59509','Msg'=>'用户没有重置做市商保护状态的权限'],['code'=>'59510','Msg'=>'子账户不存在'],['code'=>'59512','Msg'=>'不支持为独立经纪商子账号设置主动转出权限，所有独立经纪商子账户默认有主动转出权限'],['code'=>'59601','Msg'=>'子账户名称已存在'],['code'=>'59602','Msg'=>'创建的APIkey数量超过上限'],['code'=>'59603','Msg'=>'创建子账户超过上限时'],['code'=>'59604','Msg'=>'仅母账APIkey有操作此接口的权限'],['code'=>'59605','Msg'=>'子账户的APIkey不存在'],['code'=>'59606','Msg'=>'删除失败，请将子账户中的余额划转到母账户'],['code'=>'59608','Msg'=>'仅Broker账户有操作此接口的权限'],['code'=>'59609','Msg'=>'经纪商已经存在'],['code'=>'59610','Msg'=>'经纪商不存在'],['code'=>'59611','Msg'=>'经纪商状态是未审核'],['code'=>'59612','Msg'=>'时间参数格式转换失败'],['code'=>'59613','Msg'=>'当前未与子账户建立托管关系'],['code'=>'59614','Msg'=>'托管子账户不支持此操作'],['code'=>'59615','Msg'=>'起始日期和结束日期的时间间隔不能超过180天。'],['code'=>'59616','Msg'=>'起始日期不能大于结束日期'],['code'=>'59617','Msg'=>'子账户创建成功，账户等级设置失败'],['code'=>'59618','Msg'=>'创建子账户失败'],['code'=>'70000','Msg'=>'询价单不存在'],['code'=>'70001','Msg'=>'报价单不存在'],['code'=>'70002','Msg'=>'大宗交易不存在'],['code'=>'70003','Msg'=>'公共的大宗交易不存在'],['code'=>'70004','Msg'=>'无效的产品ID {0}'],['code'=>'70005','Msg'=>'组合交易的数量不能超过最大值'],['code'=>'70006','Msg'=>'不满足最小资产要求'],['code'=>'70007','Msg'=>'该产品类型 {0} 的标的指数 {0} 不存在'],['code'=>'70008','Msg'=>'MMP状态下操作失败。冻结时间为 {0} 秒'],['code'=>'70009','Msg'=>'Data数组必须至少含有一个有效元素'],['code'=>'70011','Msg'=>'产品类型 {0} 存在重复设置'],['code'=>'70012','Msg'=>'同一个instType{1}下的instFamily/instId{0} 存在重复设置'],['code'=>'70100','Msg'=>'组合交易中的产品ID重复'],['code'=>'70101','Msg'=>'clRfqId重复'],['code'=>'70102','Msg'=>'未指定对手方'],['code'=>'70103','Msg'=>'无效的对手方'],['code'=>'70105','Msg'=>'总价值应该大于最小值{0}'],['code'=>'70106','Msg'=>'下单数量小于最小交易数量'],['code'=>'70107','Msg'=>'对手方的数量不能超过最大值'],['code'=>'70109','Msg'=>'所选产品无有效对手方'],['code'=>'70200','Msg'=>'不能取消处于{0}状态的询价单'],['code'=>'70203','Msg'=>'取消失败，由于询价单数量超过限制数量{0}'],['code'=>'70207','Msg'=>'取消失败，由于您没有询价挂单'],['code'=>'70208','Msg'=>'取消失败，由于服务暂时不可用，请稍后重试'],['code'=>'70301','Msg'=>'clQuoteId重复'],['code'=>'70303','Msg'=>'不能对处于{0}状态的询价单报价'],['code'=>'70304','Msg'=>'价格应该是下单价格精度的整数倍'],['code'=>'70305','Msg'=>'买入价格不能高于报价'],['code'=>'70306','Msg'=>'报价的组合交易没有匹配{0}的组合交易'],['code'=>'70307','Msg'=>'数量应该是下单数量精度的整数倍'],['code'=>'70308','Msg'=>'不允许对自己的询价单报价'],['code'=>'70309','Msg'=>'不允许对相同询价单进行同一方向的报价'],['code'=>'70310','Msg'=>'instId {0} 报价不可以超过你预设的价格限制'],['code'=>'70400','Msg'=>'不能取消处于{0}状态的报价单'],['code'=>'70408','Msg'=>'取消失败，由于报价单数量超过限制数量{0}'],['code'=>'70409','Msg'=>'取消失败，由于您没有报价挂单'],['code'=>'70501','Msg'=>'询价单{0}没有被{1}报价'],['code'=>'70502','Msg'=>'组合交易没有匹配{0}的组合交易'],['code'=>'70503','Msg'=>'执行的组合交易没有匹配{0}的组合交易'],['code'=>'70504','Msg'=>'执行失败，因为询价单的状态是{0}'],['code'=>'70505','Msg'=>'执行失败，因为报价单的状态是{0}'],['code'=>'70511','Msg'=>'正在执行报价'],['code'=>'56000','Msg'=>'大宗交易不存在'],['code'=>'56001','Msg'=>'多腿的数量不能超过 {0}'],['code'=>'56002','Msg'=>'执行和验证的多腿数量不匹配'],['code'=>'56003','Msg'=>'重复的clBlockTdId'],['code'=>'56004','Msg'=>'不允许自成交'],['code'=>'56005','Msg'=>'执行和验证的clBlockTdId 不匹配'],['code'=>'56006','Msg'=>'执行和验证的角色不能相同'],['code'=>'56007','Msg'=>'执行和验证的第{0}条腿不匹配'],['code'=>'56008','Msg'=>'重复的产品名称']];
        foreach($Msg_ as $key)
        {
            if($code==$key['code']){
                return $key['Msg'];
            }
        }
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

    public static function signature($timestamp, $method, $requestPath, $body, $secretKey)
    {
        $message = (string) $timestamp . strtoupper($method) . $requestPath . (string) $body;
        self::$textToSign = $message;
        return base64_encode(hash_hmac('sha256', $message, $secretKey, true));
    }

    public static function wsSignature($timestamp, $method, $requestPath, $body, $secretKey)
    {
        $message = (string) $timestamp . strtoupper($method) . $requestPath . (string) $body;
        echo  $message;
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
