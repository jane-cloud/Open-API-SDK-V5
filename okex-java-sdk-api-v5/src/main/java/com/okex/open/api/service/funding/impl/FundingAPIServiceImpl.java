package com.okex.open.api.service.funding.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.funding.param.*;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.funding.FundingAPIService;

public class FundingAPIServiceImpl implements FundingAPIService {

    private APIClient client;
    private FundingAPI api;

    public FundingAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(FundingAPI.class);
    }

    //获取币种列表 Get Currencies
    @Override
    public JSONObject getCurrencies() {
        return this.client.executeSync(this.api.getCurrencies());
    }

    //获取资金账户余额 Get Balance
    @Override
    public JSONObject getBalance(String ccy) {
        return this.client.executeSync(this.api.getBalance(ccy));
    }

    //资金划转  Funds Transfer
    @Override
    public JSONObject fundsTransfer(FundsTransfer fundsTransfer) {
        return this.client.executeSync(this.api.fundsTransfer(JSONObject.parseObject(JSON.toJSONString(fundsTransfer))));
    }

    //资金流水查询 Asset Bills Details
    @Override
    public JSONObject assetBillsDetails(String ccy, String type, String clientId,String after, String before, String limit) {
        return this.client.executeSync(this.api.assetBillsDetails(ccy,type,clientId,after,before,limit));
    }

    //获取充值地址信息 Get Deposit Address
    @Override
    public JSONObject getDepositAddress(String ccy) {
        return this.client.executeSync(this.api.getDepositAddress(ccy));
    }

    //获取充值记录 Get Deposit History
    @Override
    public JSONObject getDepositHistory(String ccy, String txId,String fromWdId,String type, String state, String after, String before, String limit,String depId) {
        return this.client.executeSync(this.api.getDepositHistory(ccy,txId,fromWdId,type,state,after,before,limit,depId));
    }

    //提币 Withdrawal
    @Override
    public JSONObject Withdrawal(Withdrawal withdrawal) {
        return this.client.executeSync(this.api.Withdrawal(JSONObject.parseObject(JSON.toJSONString(withdrawal))));
    }

    //获取提币记录 Get Withdrawal History
    @Override
    public JSONObject getWithdrawalHistory(String ccy, String clientId, String txId,String type, String state, String after, String before, String limit,String wdId) {
        return this.client.executeSync(this.api.getWithdrawalHistory(ccy,clientId,txId,type,state,after,before,limit,wdId));
    }

    //获取充值/提现的详细状态 Get deposit withdraw status
    @Override
    public JSONObject getDepositWithdrawalStatus(String wdId, String txId, String ccy, String to, String chain) {
        return this.client.executeSync(this.api.getDepositWithdrawalStatus(wdId, txId, ccy, to, chain));
    }

    //余币宝申购/赎回 PiggyBank Purchase/Redemption
    @Override
    public JSONObject piggyBankPurchaseRedemption(PiggyBankPurchaseRedemption piggyBankPurchaseRedemption) {
        return this.client.executeSync(this.api.piggyBankPurchaseRedemption(JSONObject.parseObject(JSON.toJSONString(piggyBankPurchaseRedemption))));
    }

    //获取余币宝余额
    @Override
    public JSONObject piggyBalance(String ccy) {
        return this.client.executeSync(this.api.piggyBalance(ccy));
    }

    //闪电网络充币 Deposit Lightning
    @Override
    public JSONObject depositLightning(String ccy, String amt, String to) {
        return this.client.executeSync(this.api.depositLightning(ccy,amt,to));
    }

    //闪电网络提币 Withdrawal Lightning
    @Override
    public JSONObject withdrawalLightning(Withdrawal withdrawal) {
        return this.client.executeSync(this.api.withdrawalLightning(JSONObject.parseObject(JSON.toJSONString(withdrawal))));
    }

    //获取资金划转状态 Transfer State
    @Override
    public JSONObject transferState(String transId,String clientId, String type) {
        return this.client.executeSync(this.api.transferState(transId,clientId,type));
    }

    //获取账户资产估值 Get account asset valuation
    @Override
    public JSONObject assetValuation(String ccy) {
        return this.client.executeSync(this.api.assetValuation(ccy));
    }

    //设置余币宝借贷利率 Set lending rate
    @Override
    public JSONObject SetLendingRate(SetLendingRate setLendingRate) {
        return this.client.executeSync(this.api.SetLendingRate(JSONObject.parseObject(JSON.toJSONString(setLendingRate))));
    }

    //获取余币宝出借明细  Get lending history
    @Override
    public JSONObject lendingHistory(String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.lendingHistory(ccy,after,before,limit));
    }

    //获取市场借贷信息（公共） Get public borrow info (public)
    @Override
    public JSONObject lendingRateSummary(String ccy) {
        return this.client.executeSync(this.api.lendingRateSummary(ccy));
    }

    //获取市场借贷历史（公共）  Get public borrow history (public)
    @Override
    public JSONObject lendingRateHistory(String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.lendingRateHistory(ccy,after,before,limit));
    }

    //小额资产兑换
    @Override
    public JSONObject convertDustAssets(ConvertDustAssets convertDustAssets) {
        return this.client.executeSync(this.api.ConvertDustAssets(JSONObject.parseObject(JSON.toJSONString(convertDustAssets))));
    }

    //撤销提币
    @Override
    public JSONObject cancelWithdrawal(Withdrawal cancelWithdrawal) {
        return this.client.executeSync(this.api.cancelWithdrawal(JSONObject.parseObject(JSON.toJSONString(cancelWithdrawal))));

    }

    @Override
    public JSONObject getNonTradableAssets(String ccy) {
        return this.client.executeSync(this.api.getNonTradableAssets(ccy));
    }

    @Override
    public JSONObject getExchangeList() {
        return this.client.executeSync(this.api.getExchangeList());
    }

    @Override
    public JSONObject applyMonthlyStatement(MonthlyStatement monthlyStatement) {
        return this.client.executeSync(this.api.applyMonthlyStatement(JSONObject.parseObject(JSON.toJSONString(monthlyStatement))));
    }

    @Override
    public JSONObject getMonthlyStatement(String month) {
        return this.client.executeSync(this.api.getMonthlyStatement(month));
    }

    @Override
    public JSONObject getBillsHistory(String ccy, String type, String clientId, String after, String before, String limit, String pagingType) {
        return this.client.executeSync(this.api.getBillsHistory(ccy,  type,  clientId,  after,  before,  limit,  pagingType));
    }
}
