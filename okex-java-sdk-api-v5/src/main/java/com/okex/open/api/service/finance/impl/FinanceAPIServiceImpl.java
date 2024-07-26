package com.okex.open.api.service.finance.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
}
