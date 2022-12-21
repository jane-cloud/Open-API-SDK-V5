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

        config.setEndpoint("https://www.ouyicn.blue");
        // 实盘
        String  apikey1 = "27151997-3bad-4e2e-b062-6badcd762b07";
        String secretkey1 = "DA00F02E91F3D9FD7A9FCE75F5504B64";

        //pl账户 V5模拟盘
        String apikey2 = "69bd1e73-80dc-4c91-af2f-b5e711465aab";
        String secretkey2 = "9DFCCED98C8B36E8B219016C2C86B411";

        String apikey = "e65c7c05-e701-4215-a7c0-89445178bde8";
        String secretkey = "2488B3B340E46889793A507562C6AF3B";

        config.setApiKey(apikey2);
        config.setSecretKey(secretkey2);
        config.setPassphrase("penglei1234");


        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);

        return config;
    }


}
