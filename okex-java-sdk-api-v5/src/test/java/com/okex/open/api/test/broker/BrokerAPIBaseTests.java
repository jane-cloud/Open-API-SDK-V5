package com.okex.open.api.test.broker;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

public class BrokerAPIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        config.setEndpoint("https://www.okx.com/");
        // apiKey，api注册成功后页面上有


        //V5  实盘
//        config.setApiKey("");
//        config.setSecretKey("");
//        config.setPassphrase("");

        config.setApiKey("f35bb20a-2579-44eb-859d-0f2489b1ea18");
        config.setSecretKey("0B4213DDF60C46CB27B0CA2578B2BC35");
        config.setPassphrase("Xxzandttc0415");


        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);

        return config;
    }
}
