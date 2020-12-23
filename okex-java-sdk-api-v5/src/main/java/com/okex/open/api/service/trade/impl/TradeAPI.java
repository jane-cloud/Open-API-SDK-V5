package com.okex.open.api.service.trade.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.trade.param.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

interface TradeAPI {

    //下单 Place Order
    @POST("/api/v5/trade/order")
    Call<JSONObject> placeOrder(@Body JSONObject jsonObject);

    //批量下单 Place Multiple Orders
    @POST("/api/v5/trade/batch-orders")
    Call<JSONObject> placeMultipleOrders(@Body List<PlaceOrder> placeOrders);

    //撤单 Cancel Order
    @POST("/api/v5/trade/cancel-order")
    Call<JSONObject> cancelOrder(@Body CancelOrder cancelOrder);

    //批量撤单 Cancel Multiple Orders
    @POST("/api/v5/trade/cancel-batch-orders")
    Call<JSONObject> cancelMultipleOrders(@Body List<CancelOrder> cancelOrders);

    //修改订单 Amend Order
    @POST("/api/v5/trade/amend-order")
    Call<JSONObject> amendOrder(@Body AmendOrder amendOrder);

    //批量修改订单 Amend Multiple Orders
    @POST("/api/v5/trade/amend-batch-orders")
    Call<JSONObject> amendMultipleOrders(@Body List<AmendOrder> amendOrders);

    //市价仓位全平 Close Positions
    @POST("/api/v5/trade/close-position")
    Call<JSONObject> closePositions(@Body ClosePositions closePositions);

    //获取订单信息 Get Order Details
    @GET("/api/v5/trade/order")
    Call<JSONObject> getOrderDetails(@Query("instId") String instId,@Query("ordId") String ordId,@Query("clOrdId") String clOrdId);

    //获取未成交订单列表 Get Order List
    @GET("/api/v5/trade/orders-pending")
    Call<JSONObject> getOrderList(@Query("instType") String instType,
                                  @Query("uly")String uly,
                                  @Query("instId")String instId,
                                  @Query("ordType")String ordType,
                                  @Query("state")String state,
                                  @Query("after")String after,
                                  @Query("before")String before,
                                  @Query("limit")String limit);

    //获取历史订单记录（近七天） Get Order History (last 7 days）
    @GET("/api/v5/trade/orders-history")
    Call<JSONObject> getOrderHistory7days(@Query("instType") String instType,
                                          @Query("uly")String uly,
                                          @Query("instId")String instId,
                                          @Query("ordType")String ordType,
                                          @Query("state")String state,
                                          @Query("after")String after,
                                          @Query("before")String before,
                                          @Query("limit")String limit);

    //获取历史订单记录（近三个月） Get Order History (last 3 months)
    @GET("/api/v5/trade/orders-history-archive")
    Call<JSONObject> getOrderHistory3months(@Query("instType") String instType,
                                            @Query("uly")String uly,
                                            @Query("instId")String instId,
                                            @Query("ordType")String ordType,
                                            @Query("state")String state,
                                            @Query("after")String after,
                                            @Query("before")String before,
                                            @Query("limit")String limit);

    //获取成交明细 Get Transaction Details
    @GET("/api/v5/trade/fills")
    Call<JSONObject> getTransactionDetails(@Query("instType") String instType,
                                           @Query("uly")String uly,
                                           @Query("instId")String instId,
                                           @Query("ordId")String ordId,
                                           @Query("after")String after,
                                           @Query("before")String before,
                                           @Query("limit")String limit);


    //委托策略下单 Place Algo Order
    @POST("/api/v5/trade/order-algo")
    Call<JSONObject> placeAlgoOrder(@Body JSONObject jsonObject);

    //撤销策略委托订单 Cancel Algo Order
    @POST("/api/v5/trade/cancel-algos")
    Call<JSONObject> cancelAlgoOrders(@Body List<CancelAlgoOrder> cancelAlgoOrder);

    //获取未完成策略委托单列表 Get Algo Order List
    @GET("/api/v5/trade/orders-algo-pending")
    Call<JSONObject> getAlgoOrderList(@Query("algoId") String algoId,
                                      @Query("instType") String instType,
                                      @Query("instId") String instId,
                                      @Query("ordType") String ordType,
                                      @Query("after") String after,
                                      @Query("before") String before,
                                      @Query("limit") String limit);

    //获取历史策略委托单列表 Get Algo Order History
    @GET("/api/v5/trade/orders-algo-history")
    Call<JSONObject> getAlgoOrderHistory(@Query("state") String state,
                                         @Query("algoId") String algoId,
                                         @Query("instType") String instType,
                                         @Query("instId") String instId,
                                         @Query("ordType") String ordType,
                                         @Query("after") String after,
                                         @Query("before") String before,
                                         @Query("limit") String limit);


}
