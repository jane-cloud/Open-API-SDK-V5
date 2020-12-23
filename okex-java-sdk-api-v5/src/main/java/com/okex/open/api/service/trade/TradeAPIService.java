package com.okex.open.api.service.trade;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.trade.param.*;

import java.util.List;

public interface TradeAPIService {

    //下单 Place Order
    JSONObject placeOrder(PlaceOrder placeOrder);

    //批量下单 Place Multiple Orders
    JSONObject placeMultipleOrders(List<PlaceOrder> placeOrders);

    //撤单 Cancel Order
    JSONObject cancelOrder(CancelOrder cancelOrder);

    //批量撤单 Cancel Multiple Orders
    JSONObject cancelMultipleOrders(List<CancelOrder> cancelOrders);

    //修改订单 Amend Order
    JSONObject amendOrder(AmendOrder amendOrder);

    //批量修改订单 Amend Multiple Orders
    JSONObject amendMultipleOrders(List<AmendOrder> amendOrders);

    //市价仓位全平 Close Positions
    JSONObject closePositions(ClosePositions closePositions);

    //获取订单信息 Get Order Details
    JSONObject getOrderDetails(String instId,String ordId,String clOrdId);

    //获取未成交订单列表 Get Order List
    JSONObject getOrderList(String instType,String uly,String instId,String ordType,String state,String after,String before,String limit);

    //获取历史订单记录（近七天） Get Order History (last 7 days）
    JSONObject getOrderHistory7days(String instType,String uly,String instId,String ordType,String state,String after,String before,String limit);

    //获取历史订单记录（近三个月） Get Order History (last 3 months)
    JSONObject getOrderHistory3months(String instType,String uly,String instId,String ordType,String state,String after,String before,String limit);

    //获取成交明细 Get Transaction Details
    JSONObject getTransactionDetails(String instType,String uly,String instId,String ordId,String after,String before,String limit);

    //委托策略下单 Place Algo Order
    JSONObject placeAlgoOrder(PlaceAlgoOrder placeAlgoOrder);

    //撤销策略委托订单 Cancel Algo Order
    JSONObject cancelAlgoOrder(List<CancelAlgoOrder> cancelAlgoOrder);

    //获取未完成策略委托单列表 Get Algo Order List
    JSONObject getAlgoOrderList(String algoId, String instType, String instId, String ordType, String after, String before, String limit);

    //获取历史策略委托单列表 Get Algo Order History
    JSONObject getAlgoOrderHistory(String state, String algoId, String instType, String instId, String ordType, String after, String before, String limit);


}
