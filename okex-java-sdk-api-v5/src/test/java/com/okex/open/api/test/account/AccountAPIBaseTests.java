package com.okex.open.api.test.account;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

/**
 * Account api basetests
 *
 * @author hucj
 * @version 1.0.0
 * @date 2018/7/04 18:23
 */
public class AccountAPIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        config.setEndpoint("https://www.okx.com/");
        // apiKey，api注册成功后页面上有

        config.setApiKey("");
        config.setSecretKey("");
        config.setPassphrase("");



        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);

        return config;
    }


}
