package com.okex.open.api.service.subAccount.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.subAccount.param.CreateSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.DelSunAccountApikey;
import com.okex.open.api.bean.subAccount.param.ReSetSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.SubAccountTransfer;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.subAccount.SubAccountAPIService;

public class SubAccountAPIServiceImpl implements SubAccountAPIService {

    private APIClient client;
    private SubAccountAPI api;


    public SubAccountAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(SubAccountAPI.class);
    }

    //母账户查询子账户的交易账户详细资产余额（适用于母账户） Query detailed balance info of Trading Account of a sub-account via the master account (applies to master accounts only)
    @Override
    public JSONObject getSubAccountBalances(String subAcct) {
        return this.client.executeSync(this.api.getSubAccountBalances(subAcct));
    }

    //子账户转账记录（仅适用于母账户） View sub-account list(applies to master accounts only)
    @Override
    public JSONObject getSubAccountBills(String ccy, String type, String subAcct, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubAccountBills(ccy, type, subAcct, after, before, limit));
    }

    //删除子账户的APIkey（仅适用于母账户） Delete the APIkey of sub-accounts (applies to master accounts only)
    @Override
    public JSONObject delSubAccountAPIKey(DelSunAccountApikey delSunAccountApikey) {
        return this.client.executeSync(this.api.delSubAccountAPIKey(delSunAccountApikey));
    }

    //重置子账户的APIkey（仅适用于母账户） Reset the APIkey of a sub-account(applies to master accounts only)
    @Override
    public JSONObject reSetSubAccountAPIKey(ReSetSubAccountApikey reSetSubAccountApikey) {
        return this.client.executeSync(this.api.reSetSubAccountAPIKey(reSetSubAccountApikey));
    }

    //创建子账户的APIkey（仅适用于母账户）Create an APIkey for a sub-account(applies to master accounts only)
    @Override
    public JSONObject createSubAccountAPIKey(CreateSubAccountApikey createSubAccountApikey) {
        return this.client.executeSync(this.api.createSubAccountAPIKey(createSubAccountApikey));
    }

    //查看子账户列表（仅适用于母账户） View sub-account list(applies to master accounts only)
    @Override
    public JSONObject getSubAccountList(String enable, String subAcct, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubAccountList(enable, subAcct, after, before, limit));
    }

    //母账户控制子账户与子账户之间划转（仅适用于母账户） Master accounts manage the transfers between sub-accounts(applies to master accounts only)
    @Override
    public JSONObject subAccountTransfer(SubAccountTransfer subAccountTransfer) {
        return this.client.executeSync(this.api.subAccountTransfer(subAccountTransfer));
    }
}
