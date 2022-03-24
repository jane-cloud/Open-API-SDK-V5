package com.okex.open.api.test.convert;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

public class ConvertAPIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        config.setEndpoint("https://www.okx.com/");
        // apiKey，api注册成功后页面上有


        //V5  实盘
        config.setApiKey("");
        config.setSecretKey("");
        config.setPassphrase("");



        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);

        return config;
    }
}
