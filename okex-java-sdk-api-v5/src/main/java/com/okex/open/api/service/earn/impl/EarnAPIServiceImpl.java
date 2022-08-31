package com.okex.open.api.service.earn.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.earn.EarnAPIService;

public class EarnAPIServiceImpl implements EarnAPIService {

    private APIClient client;
    private EarnAPI api;

    public EarnAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(EarnAPI.class);
    }

    //查看项目 Get offers
    @Override
    public JSONObject getOffers(String productId, String protocolType, String ccy) {
        return this.client.executeSync(this.api.getOffers(productId, protocolType, ccy));
    }

    //申购项目 Purchase
    @Override
    public JSONObject purchase(Purchase purchase) {
        return this.client.executeSync(this.api.purchase(JSONObject.parseObject(JSON.toJSONString(purchase))));
    }

    //赎回项目 Redeem
    @Override
    public JSONObject redeem(Redeem redeem) {
        return this.client.executeSync(this.api.redeem(JSONObject.parseObject(JSON.toJSONString(redeem))));
    }

    //撤销项目申购/赎回 Cancel purchases/redemptions
    @Override
    public JSONObject cancel(Cancel cancel) {
        return this.client.executeSync(this.api.cancel(JSONObject.parseObject(JSON.toJSONString(cancel))));
    }

    //查看活跃订单  Get active orders
    @Override
    public JSONObject getActiveOrders(String productId, String protocolType, String ccy, String state) {
        return this.client.executeSync(this.api.getActiveOrders(productId, protocolType, ccy, state));
    }

    //查看历史订单 Get order history
    @Override
    public JSONObject getHistoryOrders(String productId, String protocolType, String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.getHistoryOrders(productId, protocolType, ccy, after, before, limit));
    }
}
