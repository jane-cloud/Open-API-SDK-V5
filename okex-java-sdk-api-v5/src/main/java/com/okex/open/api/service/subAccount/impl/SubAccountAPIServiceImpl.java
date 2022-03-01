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

    //查看子账户列表 View sub-account list
    @Override
    public JSONObject getSubAccountList(String enable, String subAcct, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubAccountList(enable, subAcct, after, before, limit));
    }

    //创建子账户的APIkey Create an APIkey for a sub-account
    @Override
    public JSONObject createSubAccountAPIKey(CreateSubAccountApikey createSubAccountApikey) {
        return this.client.executeSync(this.api.createSubAccountAPIKey(createSubAccountApikey));
    }

    //查询子账户的APIKey  Query the APIKey of a sub-account
    @Override
    public JSONObject getSubAccountApikeyList(String subAcct, String apiKey) {
        return this.client.executeSync(this.api.getSubAccountApikeyList(subAcct, apiKey));
    }


    //重置子账户的APIkey Reset the APIkey of a sub-account
    @Override
    public JSONObject reSetSubAccountAPIKey(ReSetSubAccountApikey reSetSubAccountApikey) {
        return this.client.executeSync(this.api.reSetSubAccountAPIKey(reSetSubAccountApikey));
    }

    //删除子账户的APIkey Delete the APIkey of sub-accounts
    @Override
    public JSONObject delSubAccountAPIKey(DelSunAccountApikey delSunAccountApikey) {
        return this.client.executeSync(this.api.delSubAccountAPIKey(delSunAccountApikey));
    }

    //获取子账户资产余额 Get Sub-account Balance
    @Override
    public JSONObject getSubAccountBalances(String subAcct) {
        return this.client.executeSync(this.api.getSubAccountBalances(subAcct));
    }

    //查询子账户转账记录 History of sub-account transfer
    @Override
    public JSONObject getSubAccountBills(String ccy, String type, String subAcct, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubAccountBills(ccy, type, subAcct, after, before, limit));
    }

    //子账户间资金划转 Master accounts manage the transfers between sub-accounts
    @Override
    public JSONObject subAccountTransfer(SubAccountTransfer subAccountTransfer) {
        return this.client.executeSync(this.api.subAccountTransfer(subAccountTransfer));
    }

    //查看被托管的子账户列表 Entrust Subaccount List
    @Override
    public JSONObject getEntrustSubList(String subAcct) {
        return this.client.executeSync(this.api.getEntrustSubList(subAcct));
    }
}
