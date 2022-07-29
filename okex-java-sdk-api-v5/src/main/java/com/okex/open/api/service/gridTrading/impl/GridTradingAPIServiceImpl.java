package com.okex.open.api.service.gridTrading.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.gridTrading.param.AmendOrderAlgo;
import com.okex.open.api.bean.gridTrading.param.OrderAlgo;
import com.okex.open.api.bean.gridTrading.param.StopOrderAlgo;
import com.okex.open.api.bean.gridTrading.param.WithdrawIncome;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.gridTrading.GridTradingAPIService;

public class GridTradingAPIServiceImpl implements GridTradingAPIService {

    private APIClient client;
    private GridTradingAPI gridAPI;

    public GridTradingAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.gridAPI = client.createService(GridTradingAPI.class);
    }

    //网格策略委托下单 Place grid algo order
    @Override
    public JSONObject orderAlgo(OrderAlgo orderAlgo) {
        return this.client.executeSync(this.gridAPI.orderAlgo(orderAlgo));
    }

    //修改网格策略订单 Amend grid algo order
    @Override
    public JSONObject amendOrderAlgo(AmendOrderAlgo amendOrderAlgo) {
        return this.client.executeSync(this.gridAPI.amendOrderAlgo(amendOrderAlgo));
    }

    //网格策略停止 Stop grid algo order
    @Override
    public JSONObject stopOrderAlgo(StopOrderAlgo stopOrderAlgo) {
        return this.client.executeSync(this.gridAPI.stopOrderAlgo(stopOrderAlgo));
    }

    //获取未完成网格策略委托单列表 Get grid algo order list
    @Override
    public JSONObject getGridAlgoOrderList(String algoOrdType, String algoId, String instId, String instType, String after, String before, String limit) {
        return this.client.executeSync(this.gridAPI.getGridAlgoOrderList(algoOrdType, algoId, instId, instType, after, before, limit));
    }

    //获取历史网格策略委托单列表 Get grid algo order history
    @Override
    public JSONObject getGridAlgoOrderHistory(String algoOrdType, String algoId, String instId, String instType, String after, String before, String limit) {
        return this.client.executeSync(this.gridAPI.getGridAlgoOrderHistory(algoOrdType, algoId, instId, instType, after, before, limit));
    }

    //获取网格策略委托订单详情 Get grid algo order details
    @Override
    public JSONObject getOrdersAlgoDetails(String algoOrdType, String algoId) {
        return this.client.executeSync(this.gridAPI.getOrdersAlgoDetails(algoOrdType, algoId));
    }

    //获取网格策略委托子订单信息 Get grid algo sub orders
    @Override
    public JSONObject getSubOrders(String algoOrdType, String algoId, String type, String groupId, String after, String before, String limit) {
        return this.client.executeSync(this.gridAPI.getSubOrders(algoOrdType, algoId, type, groupId, after, before, limit));
    }

    //获取网格策略委托持仓 Get grid algo order positions
    @Override
    public JSONObject getPositions(String algoOrdType, String algoId) {
        return this.client.executeSync(this.gridAPI.getPositions(algoOrdType, algoId));
    }

    //现货网格提取利润 Spot grid withdraw income
    @Override
    public JSONObject withdrawIncome(WithdrawIncome withdrawIncome) {
        return client.executeSync(this.gridAPI.withdrawIncome(withdrawIncome));
    }

    //网格策略智能回测（公共）
    @Override
    public JSONObject getGridTest(String algoOrdType, String instId, String direction, String duration) {
        return this.client.executeSync(this.gridAPI.getGridTest(algoOrdType, instId,direction,duration));
    }

    @Override
    public JSONObject marginBalance(WithdrawIncome withdrawIncome) {
        return this.client.executeSync(this.gridAPI.marginBalance(withdrawIncome));
    }

    @Override
    public JSONObject computeMarginBalance(WithdrawIncome withdrawIncome) {
        return this.client.executeSync(this.gridAPI.computeMarginBalance(withdrawIncome));
    }
}
