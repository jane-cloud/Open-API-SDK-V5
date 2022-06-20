package com.okex.open.api.service.gridTrading.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.gridTrading.param.AmendOrderAlgo;
import com.okex.open.api.bean.gridTrading.param.OrderAlgo;
import com.okex.open.api.bean.gridTrading.param.StopOrderAlgo;
import com.okex.open.api.bean.gridTrading.param.WithdrawIncome;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GridTradingAPI {

    //网格策略委托下单 Place grid algo order
    @POST("/api/v5/tradingBot/grid/order-algo")
    Call<JSONObject> orderAlgo(@Body OrderAlgo orderAlgo);

    //修改网格策略订单 Amend grid algo order
    @POST("/api/v5/tradingBot/grid/amend-order-algo")
    Call<JSONObject> amendOrderAlgo(@Body AmendOrderAlgo amendOrderAlgo);

    //网格策略停止 Stop grid algo order
    @POST("/api/v5/tradingBot/grid/stop-order-algo")
    Call<JSONObject> stopOrderAlgo(@Body StopOrderAlgo stopOrderAlgo);

    //获取未完成网格策略委托单列表 Get grid algo order list
    @GET("/api/v5/tradingBot/grid/orders-algo-pending")
    Call<JSONObject> getGridAlgoOrderList(@Query("algoOrdType") String algoOrdType,
                                          @Query("algoId") String algoId,
                                          @Query("instId") String instId,
                                          @Query("instType") String instType,
                                          @Query("after") String after,
                                          @Query("before") String before,
                                          @Query("limit") String limit);

    //获取历史网格策略委托单列表 Get grid algo order history
    @GET("/api/v5/tradingBot/grid/orders-algo-history")
    Call<JSONObject> getGridAlgoOrderHistory(@Query("algoOrdType") String algoOrdType,
                                          @Query("algoId") String algoId,
                                          @Query("instId") String instId,
                                          @Query("instType") String instType,
                                          @Query("after") String after,
                                          @Query("before") String before,
                                          @Query("limit") String limit);

    //获取网格策略委托订单详情 Get grid algo order details
    @GET("/api/v5/tradingBot/grid/orders-algo-details")
    Call<JSONObject> getOrdersAlgoDetails(@Query("algoOrdType") String algoOrdType,
                                          @Query("algoId") String algoId);

    //获取网格策略委托子订单信息 Get grid algo sub orders
    @GET("/api/v5/tradingBot/grid/sub-orders")
    Call<JSONObject> getSubOrders(@Query("algoOrdType") String algoOrdType,
                                  @Query("algoId") String algoId,
                                  @Query("type") String type,
                                  @Query("groupId") String groupId,
                                  @Query("after") String after,
                                  @Query("before") String before,
                                  @Query("limit") String limit);

    //获取网格策略委托持仓 Get grid algo order positions
    @GET("/api/v5/tradingBot/grid/positions")
    Call<JSONObject> getPositions(@Query("algoOrdType") String algoOrdType,
                                  @Query("algoId") String algoId);

    //现货网格提取利润 Spot grid withdraw income
    @POST("/api/v5/tradingBot/grid/withdraw-income")
    Call<JSONObject> withdrawIncome(@Body WithdrawIncome withdrawIncome);








}
