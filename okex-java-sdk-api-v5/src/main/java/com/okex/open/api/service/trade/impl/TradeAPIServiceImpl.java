package com.okex.open.api.service.trade.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.trade.param.*;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.trade.TradeAPIService;

import java.util.List;

public class TradeAPIServiceImpl implements TradeAPIService {
    private final APIClient client;
    private final TradeAPI tradeAPI;

    public TradeAPIServiceImpl(final APIConfiguration config) {
        this.client = new APIClient(config);
        this.tradeAPI = this.client.createService(TradeAPI.class);
    }


    //下单 Place Order
    @Override
    public JSONObject placeOrder(PlaceOrder placeOrder) {
        return this.client.executeSync(this.tradeAPI.placeOrder(JSONObject.parseObject(JSON.toJSONString(placeOrder))));
    }

    //批量下单 Place Multiple Orders
    @Override
    public JSONObject placeMultipleOrders(List<PlaceOrder> placeOrders) {
        return this.client.executeSync(this.tradeAPI.placeMultipleOrders(placeOrders));
    }

    //撤单 Cancel Order
    @Override
    public JSONObject cancelOrder(CancelOrder cancelOrder) {
        return this.client.executeSync(this.tradeAPI.cancelOrder(cancelOrder));
    }

    //批量撤单 Cancel Multiple Orders
    @Override
    public JSONObject cancelMultipleOrders(List<CancelOrder> cancelOrders) {
        return this.client.executeSync(this.tradeAPI.cancelMultipleOrders(cancelOrders));
    }

    //修改订单 Amend Order
    @Override
    public JSONObject amendOrder(AmendOrder amendOrder) {
        return this.client.executeSync(this.tradeAPI.amendOrder(amendOrder));
    }

    //批量修改订单 Amend Multiple Orders
    @Override
    public JSONObject amendMultipleOrders(List<AmendOrder> amendOrders) {
        return this.client.executeSync(this.tradeAPI.amendMultipleOrders(amendOrders));
    }

    //市价仓位全平 Close Positions
    @Override
    public JSONObject closePositions(ClosePositions closePositions) {
        return this.client.executeSync(this.tradeAPI.closePositions(closePositions));
    }

    //获取订单信息 Get Order Details
    @Override
    public JSONObject getOrderDetails(String instId, String ordId, String clOrdId) {
        return this.client.executeSync(this.tradeAPI.getOrderDetails(instId, ordId, clOrdId));
    }

    //获取未成交订单列表 Get Order List
    @Override
    public JSONObject getOrderList(String instType,String uly,String instId,String ordType,String state,String after,String before,String limit) {
        return this.client.executeSync(this.tradeAPI.getOrderList(instType, uly, instId, ordType, state, after, before, limit));
    }

    //获取历史订单记录（近七天） Get Order History (last 7 days）
    @Override
    public JSONObject getOrderHistory7days(String instType, String uly, String instId, String ordType, String state, String after, String before, String limit) {
        return this.client.executeSync(this.tradeAPI.getOrderHistory7days(instType, uly, instId, ordType, state, after, before, limit));
    }

    ////获取历史订单记录（近三个月） Get Order History (last 3 months)
    @Override
    public JSONObject getOrderHistory3months(String instType, String uly, String instId, String ordType, String state, String after, String before, String limit) {
        return this.client.executeSync(this.tradeAPI.getOrderHistory3months(instType, uly, instId, ordType, state, after, before, limit));
    }

    //获取成交明细 Get Transaction Details
    @Override
    public JSONObject getTransactionDetails(String instType, String uly, String instId, String ordId, String after, String before, String limit) {
        return this.client.executeSync(this.tradeAPI.getTransactionDetails(instType, uly, instId, ordId, after, before, limit));
    }

    //委托策略下单 Place Algo Order
    @Override
    public JSONObject placeAlgoOrder(PlaceAlgoOrder placeAlgoOrder) {
        return this.client.executeSync(this.tradeAPI.placeAlgoOrder(JSONObject.parseObject(JSON.toJSONString(placeAlgoOrder))));
    }

    //撤销策略委托订单 Cancel Algo Order
    @Override
    public JSONObject cancelAlgoOrder(List<CancelAlgoOrder> cancelAlgoOrder) {
        return this.client.executeSync(this.tradeAPI.cancelAlgoOrders(cancelAlgoOrder));
    }

    //获取未完成策略委托单列表 Get Algo Order List
    @Override
    public JSONObject getAlgoOrderList(String algoId, String instType, String instId, String ordType, String after, String before, String limit) {
        return this.client.executeSync(this.tradeAPI.getAlgoOrderList(algoId, instType, instId, ordType, after, before, limit));
    }

    //获取历史策略委托单列表 Get Algo Order History
    @Override
    public JSONObject getAlgoOrderHistory(String state, String algoId, String instType, String instId, String ordType, String after, String before, String limit) {
        return this.client.executeSync(this.tradeAPI.getAlgoOrderHistory(state, algoId, instType, instId, ordType, after, before, limit));
    }
}
