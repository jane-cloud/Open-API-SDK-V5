package com.okex.open.api.service.finance.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.bean.finance.param.AmendFinance;
import com.okex.open.api.bean.finance.param.Finance;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.finance.FinanceAPIService;

public class FinanceAPIServiceImpl implements FinanceAPIService {

    private APIClient client;
    private FinanceAPI api;

    public FinanceAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(FinanceAPI.class);
    }


    @Override
    public JSONObject getFinanceBalance(String ccy) {
        return this.client.executeSync(this.api.getFinanceBalance( ccy));
    }

    @Override
    public JSONObject PurchaseRedempt(Finance finance) {
        return this.client.executeSync(this.api.PurchaseRedempt( JSONObject.parseObject(JSON.toJSONString(finance))));
    }

    @Override
    public JSONObject setLendingRate(Finance finance) {
        return this.client.executeSync(this.api.setLendingRate( JSONObject.parseObject(JSON.toJSONString(finance))));
    }

    @Override
    public JSONObject getLendingHistory(String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.getLendingHistory( ccy,after, before, limit));
    }

    @Override
    public JSONObject getLendingRateSummary(String ccy) {
        return this.client.executeSync(this.api.getLendingRateSummary( ccy));
    }

    @Override
    public JSONObject getLendingRateHistory(String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.getLendingRateHistory( ccy,after, before, limit));
    }

    @Override
    public JSONObject getLendingOffers(String ccy, String term) {
        return this.client.executeSync(this.api.getLendingOffers( ccy,term));
    }

    @Override
    public JSONObject getLendingApyHistory(String ccy, String term) {
        return this.client.executeSync(this.api.getLendingApyHistory( ccy,term));
    }

    @Override
    public JSONObject getPendingLendingVolume(String ccy, String term) {
        return this.client.executeSync(this.api.getPendingLendingVolume( ccy,term));
    }

    @Override
    public JSONObject lendingOrder(Finance finance) {
        return this.client.executeSync(this.api.lendingOrder( JSONObject.parseObject(JSON.toJSONString(finance))));
    }

    @Override
    public JSONObject amendLendingOrder(AmendFinance amendFinance) {
        return this.client.executeSync(this.api.amendLendingOrder( JSONObject.parseObject(JSON.toJSONString(amendFinance))));
    }

    @Override
    public JSONObject getLendingOrdersList(String ordId, String ccy, String state, String after, String before, String limit) {
        return this.client.executeSync(this.api.getLendingOrdersList( ordId,  ccy, state, after, before, limit));
    }

    @Override
    public JSONObject getLendingSubOrders(String ordId, String state, String after, String before, String limit) {
        return this.client.executeSync(this.api.getLendingSubOrders( ordId, state, after, before, limit));
    }

    @Override
    public JSONObject getBorrowCurrencies() {
        return this.client.executeSync(this.api.getBorrowCurrencies());

    }

    @Override
    public JSONObject getCollateralAssets(String ccy) {
        return this.client.executeSync(this.api.getCollateralAssets(ccy));
    }

    @Override
    public JSONObject getMaxLoan(Finance finance) {
        return this.client.executeSync(this.api.getMaxLoan( JSONObject.parseObject(JSON.toJSONString(finance))));

    }

    @Override
    public JSONObject getMaxCollateralRedeemAmount(String borrowCcy) {
        return this.client.executeSync(this.api.getMaxCollateralRedeemAmount(borrowCcy));

    }

    @Override
    public JSONObject adjustCollateral(Finance finance) {
        return this.client.executeSync(this.api.adjustCollateral( JSONObject.parseObject(JSON.toJSONString(finance))));

    }

    @Override
    public JSONObject getLoanInfo() {
        return this.client.executeSync(this.api.getLoanInfo());

    }

    @Override
    public JSONObject getLoanHistory(String type, String after, String before, String limit) {
        return this.client.executeSync(this.api.getLoanHistory(type,after,before,limit));
    }

    @Override
    public JSONObject getInterestAccrued(String type, String after, String before, String limit) {
        return this.client.executeSync(this.api.getInterestAccrued(type,after,before,limit));
    }

    @Override
    public JSONObject solPurchase(Purchase purchase) {
        return this.client.executeSync(this.api.solPurchase( JSONObject.parseObject(JSON.toJSONString(purchase))));

    }

    @Override
    public JSONObject solRedeem(Redeem redeem) {
        return this.client.executeSync(this.api.solRedeem( JSONObject.parseObject(JSON.toJSONString(redeem))));

    }

    @Override
    public JSONObject getBalance(String ccy, String amt, String latestInterestAccrual, String totalInterestAccrual) {
        return this.client.executeSync(this.api.getBalance(ccy,amt,latestInterestAccrual,totalInterestAccrual));
    }

    @Override
    public JSONObject getPurchaseRedeemHistory(String type, String status, String after, String before, String limit) {
        return this.client.executeSync(this.api.getPurchaseRedeemHistory(type,  status,  after,  before,  limit));

    }

    @Override
    public JSONObject getApyHistory(String days) {
        return this.client.executeSync(this.api.getApyHistory(days));

    }
}
