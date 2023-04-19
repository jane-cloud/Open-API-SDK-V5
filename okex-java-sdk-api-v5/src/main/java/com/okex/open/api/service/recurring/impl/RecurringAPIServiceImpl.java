package com.okex.open.api.service.recurring.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.recurringTrading.Recurring;
import com.okex.open.api.bean.recurringTrading.RecurringAlgoOrder;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.recurring.RecurringAPIService;

import java.util.List;


public class RecurringAPIServiceImpl implements RecurringAPIService {

    private APIClient client;
    private RecurringAPI api;

    public RecurringAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(RecurringAPI.class);
    }

    @Override
    public JSONObject placeOrderAlgo(RecurringAlgoOrder recurringOrder) {
        return this.client.executeSync(this.api.placeOrderAlgo(JSONObject.parseObject(JSON.toJSONString(recurringOrder))));
    }

    @Override
    public JSONObject amendOrderAlgo(Recurring recurring) {
        return this.client.executeSync(this.api.amendOrderAlgo(JSONObject.parseObject(JSON.toJSONString(recurring))));

    }

    @Override
    public JSONObject stopOrderAlgo(List<Recurring> recurring) {
        return this.client.executeSync(this.api.stopOrderAlgo(recurring));
    }

    @Override
    public JSONObject getOrderAlgoPending(String algoId, String after, String before, String limit) {
        return this.client.executeSync(this.api.getOrderAlgoPending(algoId,after,before,limit));
    }

    @Override
    public JSONObject getOrderAlgoHistory(String algoId, String after, String before, String limit) {
        return this.client.executeSync(this.api.getOrderAlgoHistory(algoId,after,before,limit));
    }

    @Override
    public JSONObject getOrderAlgoDetails( String algoId) {
        return this.client.executeSync(this.api.getOrderAlgoDetails(algoId));
    }

    @Override
    public JSONObject getSubOrders(String algoId, String ordId, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubOrders(algoId,ordId,after,before,limit));
    }
}
