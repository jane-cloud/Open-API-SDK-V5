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

    //创建子账户的APIKey Create an APIKey for a sub-account
    @Override
    public JSONObject createSubAccountApikey(CreateSubAccountApikey createSubAccountApikey) {
        return this.client.executeSync(this.api.createSubAccountApikey(JSONObject.parseObject(JSON.toJSONString(createSubAccountApikey))));
    }
    //查询子账户的APIKey Query the APIKey of a sub-account
    @Override
    public JSONObject getApikeyInfo(String subAcct, String apiKey) {
        return this.client.executeSync(this.api.getApikeyInfo(subAcct,apiKey));
    }

    //重置子账户的APIKey Reset the APIKey of a sub-account
    @Override
    public JSONObject modifySubAccountApikey(ModifySubAccountApikey modifySubAccountApikey) {
        return this.client.executeSync(this.api.modifySubAccountApikey(JSONObject.parseObject(JSON.toJSONString(modifySubAccountApikey))));
    }

    //删除子账户的APIKey Delete the APIKey of sub-accounts
    @Override
    public JSONObject deleteSubAccountApikey(DeleteSubAccountApikey deleteSubAccountApikey) {
        return this.client.executeSync(this.api.deleteSubAccount(JSONObject.parseObject(JSON.toJSONString(deleteSubAccountApikey))));
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

    //获取子账户充值记录  Get sub-account deposit history
    @Override
    public JSONObject getSubAccountDepositHistory(String subAcct, String ccy, String txId,String type, String state, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubAccountDepositHistory(subAcct,ccy,txId,type,state,after,before,limit));
    }

    //子账户返佣记录  Query daily rebate records
    @Override
    public JSONObject getRebateDaily(String subAcct, String begin, String end, String page, String limit) {
        return this.client.executeSync(this.api.getRebateDaily(subAcct,begin,end,page,limit));
    }

    //获取返佣明细下载链接 Get download link
    @Override
    public JSONObject rebatePerOrders(String type, String begin, String end,String brokerType) {
        return this.client.executeSync(this.api.rebatePerOrders(type, begin, end,brokerType));
    }

    //生成返佣明细下载链接 Create rebate details download link
    @Override
    public JSONObject setRebatePerOrders(SetRebatePerOrders setRebatePerOrders) {
        return this.client.executeSync(this.api.setRebatePerOrders(JSONObject.parseObject(JSON.toJSONString(setRebatePerOrders))));
    }

    //获取返佣明细下载链接 Get download link
    @Override
    public JSONObject rebatePerOrdersfd(String type, String begin, String end) {
        return this.client.executeSync(this.api.rebatePerOrdersfd(type, begin, end));
    }

    //生成返佣明细下载链接 Create rebate details download link
    @Override
    public JSONObject setRebatePerOrdersfd(SetRebatePerOrders setRebatePerOrders) {
        return this.client.executeSync(this.api.setRebatePerOrdersfd(JSONObject.parseObject(JSON.toJSONString(setRebatePerOrders))));
    }

    //获取用户的 Broker 返佣信息 Get the user's broker rebate information
    @Override
    public JSONObject ifRebate(String apiKey, String brokerType) {
        return this.client.executeSync(this.api.ifRebate(apiKey, brokerType));
    }

    //重置子账户充值地址    modify-subaccount-deposit-address
    @Override
    public JSONObject modifySubaccountDepositAddress(SubAccountDepositAddress subAccountDepositAddress) {
        return this.client.executeSync(this.api.modifySubaccountDepositAddress(JSONObject.parseObject(JSON.toJSONString(subAccountDepositAddress))));

    }

    @Override
    public JSONObject getSubaccountWithdrawalHistory(String subAcct, String ccy, String wdId, String clientId, String txId, String type, String state, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubaccountWithdrawalHistory(subAcct, ccy, wdId,clientId,  txId,  type,  state,  after,  before,  limit));
    }

}
