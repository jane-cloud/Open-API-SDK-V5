package com.okex.open.api.service.spreadOrderbook.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.spread.SpreadOrder;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.spreadOrderbook.SpreadTradeService;

public class SpreadTradeServiceImpl implements SpreadTradeService {

    private APIClient client;
    private SpreadTrade api;

    public SpreadTradeServiceImpl(final APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(SpreadTrade.class);
    }


    @Override
    public JSONObject placeSprdOrder(SpreadOrder placeOrder) {
        return this.client.executeSync(this.api.placeSprdOrder(JSONObject.parseObject(JSON.toJSONString(placeOrder))));
    }

    @Override
    public JSONObject cancelSprdOrder(SpreadOrder cancelSprdOrder) {
        return this.client.executeSync(this.api.cancelSprdOrder(JSONObject.parseObject(JSON.toJSONString(cancelSprdOrder))));
    }

    @Override
    public JSONObject massCancelSprdOrder(SpreadOrder massCancel) {
        return this.client.executeSync(this.api.massCancelSprdOrder(JSONObject.parseObject(JSON.toJSONString(massCancel))));

    }

    @Override
    public JSONObject getSprdOrder(String ordId, String clOrdId) {
        return this.client.executeSync(this.api.getSprdOrder(ordId,clOrdId));
    }

    @Override
    public JSONObject getOrdersPending(String sprdId, String ordType, String state, String beginId, String endId, String limit) {
        return this.client.executeSync(this.api.getOrdersPending(sprdId, ordType, state, beginId, endId, limit));
    }

    @Override
    public JSONObject getOrdersHistory(String sprdId, String ordType, String state, String beginId, String endId, String begin, String end, String limit) {
        return this.client.executeSync(this.api.getOrdersHistory(sprdId, ordType, state, beginId, endId, begin,end,limit));
    }

    @Override
    public JSONObject getTrades(String sprdId, String tradeId, String ordId, String beginId, String endId, String begin, String end, String limit) {
        return this.client.executeSync(this.api.getTrades(sprdId, tradeId, ordId, beginId, endId, begin,end,limit));
    }

    @Override
    public JSONObject getPublicSpreads(String baseCcy, String instId, String sprdId, String state) {
        return this.client.executeSync(this.api.getPublicSpreads(baseCcy, instId, sprdId, state));
    }

    @Override
    public JSONObject getPublicBooks(String sprdId, String sz) {
        return this.client.executeSync(this.api.getPublicBooks(sprdId, sz));
    }

    @Override
    public JSONObject getPublicTicker(String sprdId) {
        return this.client.executeSync(this.api.getPublicTicker(sprdId));
    }

    @Override
    public JSONObject getPublicTrades(String sprdId) {
         return this.client.executeSync(this.api.getPublicTrades(sprdId));
    }

    @Override
    public JSONObject amendOrder(SpreadOrder amendOrder) {
        return this.client.executeSync(this.api.amendOrder(amendOrder));
    }
}
