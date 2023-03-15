package com.okex.open.api.test.trade;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

public class TradeAPIBaseTest extends BaseTests {
    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        //传入https://www.okx.com 或 https://aws.okx.com
        //you can set the domain as https://www.okx.com or https://aws.okx.com
        config.setDomain("https://www.okx.com");


        config.setApiKey("");
        config.setSecretKey("");
        config.setPassphrase("");

        //请求模拟盘的接口需要传入1，否则传入0
        //if you want to request the endpoint in demo trading,please input 1,otherwise,please input 0
        config.setxSimulatedTrading("0");

        //请求模拟盘的接口需要传入1，否则传入0
        //if you want to request the endpoint in demo trading,please input 1,otherwise,please input 0
        config.setxSimulatedTrading("0");


        config.setPrint(true);
       /* config.setI18n(I18nEnum.SIMPLIFIED_CHINESE);*/
        config.setI18n(I18nEnum.ENGLISH);
        return config;
    }


}
