package com.okex.open.api.service.subAccount.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.subAccount.param.*;
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

    //设置子账户主动转出权限 Set Permission Of Transfer Out
    @Override
    public JSONObject setTransferOut(SetTransferOut setTransferOut) {
        return this.client.executeSync(this.api.setTransferOut(setTransferOut));
    }

    //查看被托管的子账户列表 Entrust Subaccount List
    @Override
    public JSONObject getEntrustSubList(String subAcct) {
        return this.client.executeSync(this.api.getEntrustSubList(subAcct));
    }

    @Override
    public JSONObject getSubaccountBalances(String subAcct, String ccy) {
        return this.client.executeSync(this.api.getSubaccountBalances(subAcct,ccy));
    }

    @Override
    public JSONObject modifySubApikey(SetTransferOut setTransferOut) {
        return this.client.executeSync(this.api.modifySubApikey(setTransferOut));
    }

    //获取用户的节点返佣信息 Get the user's affiliate rebate information
    @Override
    public JSONObject ifRebate(String apiKey) {
        return this.client.executeSync(this.api.ifRebate(apiKey));
    }

    @Override
    public JSONObject setSubAccountLoanAllocation(SetSubAccountLoanAllocation subAccountLoanAllocation) {
        return this.client.executeSync(this.api.setSubAccountLoanAllocation(subAccountLoanAllocation));
    }

    @Override
    public JSONObject getSubAccountInterestLimits(String subAcct, String ccy) {
        return this.client.executeSync(this.api.getSubAccountInterestLimits(subAcct,ccy));
    }
}
