package com.okex.open.api.service.convert.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.convert.param.EstimateQuote;
import com.okex.open.api.bean.convert.param.Trade;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.convert.ConvertAPIService;

public class ConvertAPIServiceImpl implements ConvertAPIService {

    private APIClient client;
    private ConvertAPI api;

    public ConvertAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(ConvertAPI.class);
    }

    //获取闪兑币种列表 Get convert currencies
    @Override
    public JSONObject getCurrencies() {
        return this.client.executeSync(this.api.getCurrencies());
    }

    //获取闪兑币对信息 Get convert currency pair
    @Override
    public JSONObject getCurrencyPair(String fromCcy,String toCcy) {
        return this.client.executeSync(this.api.getCurrencyPair(fromCcy,toCcy));
    }

    //闪兑预估询价 Estimate quote
    @Override
    public JSONObject estimateQuote(EstimateQuote estimateQuote) {
        return this.client.executeSync(this.api.estimateQuote(JSONObject.parseObject(JSON.toJSONString(estimateQuote))));
    }

    //闪兑交易 Convert trade
    @Override
    public JSONObject trade(Trade trade) {
        return this.client.executeSync(this.api.trade(JSONObject.parseObject(JSON.toJSONString(trade))));
    }

    //获取闪兑交易历史 Get convert history
    @Override
    public JSONObject getHistory() {
        return this.client.executeSync(this.api.getHistory());
    }
}
