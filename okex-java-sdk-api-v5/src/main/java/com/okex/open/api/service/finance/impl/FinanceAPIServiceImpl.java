package com.okex.open.api.service.finance.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
}
