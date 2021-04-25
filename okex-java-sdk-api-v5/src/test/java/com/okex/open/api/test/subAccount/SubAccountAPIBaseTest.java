package com.okex.open.api.test.subAccount;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

public class SubAccountAPIBaseTest extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();


        config.setEndpoint("https://www.okex.com/");


        config.setApiKey("");
        config.setSecretKey("");
        config.setPassphrase("");

        config.setPrint(true);
        /* config.setI18n(I18nEnum.SIMPLIFIED_CHINESE);*/
        config.setI18n(I18nEnum.ENGLISH);
        return config;
    }

}
