package com.okex.open.api.service.broker.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.broker.param.*;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.broker.BrokerAPIService;

public class BrokerAPIServiceImpl implements BrokerAPIService {

    private APIClient client;
    private BrokerAPI api;

    public BrokerAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(BrokerAPI.class);
    }

    //Broker账户信息  Get broker account information
    @Override
    public JSONObject getInfo() {
        return this.client.executeSync(this.api.getInfo());
    }

    //创建子账户  Create sub-account
    @Override
    public JSONObject createSubAccount(CreateSubAccount createSubAccount) {
        return this.client.executeSync(this.api.createSubAccount(JSONObject.parseObject(JSON.toJSONString(createSubAccount))));
    }

    //删除子账户  Delete sub-account
    @Override
    public JSONObject deleteSubAccount(DeleteSubAccount deleteSubAccount) {
        return this.client.executeSync(this.api.deleteSubAccount(JSONObject.parseObject(JSON.toJSONString(deleteSubAccount))));
    }

    //查询子账户列表  Get sub-account list
    @Override
    public JSONObject getSubAccountInfo(String subAcct, String page, String limit) {
        return this.client.executeSync(this.api.getSubAccountInfo(subAcct, page, limit));
    }

    //设置子账户的账户等级  Set the account level of the sub-account
    @Override
    public JSONObject setSubAccountLevel(SetSubAccountLevel setSubAccountLevel) {
        return this.client.executeSync(this.api.setSubAccountLevel(JSONObject.parseObject(JSON.toJSONString(setSubAccountLevel))));
    }

    //设置子账户的交易手续费费率  Set trading fee rate for sub-account
    @Override
    public JSONObject setSubAccountFeeRate(SetSubAccountFeeRate setSubAccountFeeRate) {
        return this.client.executeSync(this.api.setSubAccountFeeRate(JSONObject.parseObject(JSON.toJSONString(setSubAccountFeeRate))));
    }

    //创建子账户充值地址  Create deposit address for sub-account
    @Override
    public JSONObject subAccountDepositAddress(SubAccountDepositAddress subAccountDepositAddress) {
        return this.client.executeSync(this.api.subAccountDepositAddress(JSONObject.parseObject(JSON.toJSONString(subAccountDepositAddress))));
    }

    //查看充值地址  Get sub-account deposit address
    @Override
    public JSONObject getSubAccountDepositAddress(String subAcct, String ccy) {
        return this.client.executeSync(this.api.getSubAccountDepositAddress(subAcct,ccy));
    }

    //查询子账户获取充值记录  Get sub-account deposit history
    @Override
    public JSONObject getSubAccountDepositHistory(String subAcct, String ccy, String txId, String state, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubAccountDepositHistory(subAcct,ccy,txId,state,after,before,limit));
    }

    //子账户返佣记录  Query daily rebate records
    @Override
    public JSONObject getRebateDaily(String subAcct, String begin, String end, String page, String limit) {
        return this.client.executeSync(this.api.getRebateDaily(subAcct,begin,end,page,limit));
    }



}
