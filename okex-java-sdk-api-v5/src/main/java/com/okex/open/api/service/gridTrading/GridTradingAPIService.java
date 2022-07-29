package com.okex.open.api.service.gridTrading;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.gridTrading.param.AmendOrderAlgo;
import com.okex.open.api.bean.gridTrading.param.OrderAlgo;
import com.okex.open.api.bean.gridTrading.param.StopOrderAlgo;
import com.okex.open.api.bean.gridTrading.param.WithdrawIncome;
import retrofit2.http.Query;

public interface GridTradingAPIService {

    //网格策略委托下单 Place grid algo order
    JSONObject orderAlgo(OrderAlgo orderAlgo);

    //修改网格策略订单 Amend grid algo order
    JSONObject amendOrderAlgo(AmendOrderAlgo amendOrderAlgo);

    //网格策略停止 Stop grid algo order
    JSONObject stopOrderAlgo(StopOrderAlgo stopOrderAlgo);

    //获取未完成网格策略委托单列表 Get grid algo order list
    JSONObject getGridAlgoOrderList(String algoOrdType, String algoId, String instId, String instType, String after, String before, String limit);

    //获取历史网格策略委托单列表 Get grid algo order history
    JSONObject getGridAlgoOrderHistory(String algoOrdType, String algoId, String instId, String instType, String after, String before, String limit);

    //获取网格策略委托订单详情 Get grid algo order details
    JSONObject getOrdersAlgoDetails(String algoOrdType, String algoId);

    //获取网格策略委托子订单信息 Get grid algo sub orders
    JSONObject getSubOrders(String algoOrdType,String algoId,String type,String groupId,String after,String before,String limit);

    //获取网格策略委托持仓 Get grid algo order positions
    JSONObject getPositions(String algoOrdType, String algoId);

    //现货网格提取利润 Spot grid withdraw income
    JSONObject withdrawIncome(WithdrawIncome withdrawIncome);

    //网格策略智能回测（公共）grid/ai-param
    JSONObject getGridTest(String algoOrdType, String instId, String direction, String duration);

    //调整保证金
    JSONObject marginBalance(WithdrawIncome withdrawIncome);
    //调整保证金计算
    JSONObject computeMarginBalance(WithdrawIncome withdrawIncome);
}
