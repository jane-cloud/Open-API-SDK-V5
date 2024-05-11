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
                                  @Query("instFamily")String instFamily,
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
                                          @Query("instFamily")String instFamily,
                                          @Query("state")String state,
                                          @Query("category")String category,
                                          @Query("after")String after,
                                          @Query("before")String before,
                                          @Query("limit")String limit,
                                          @Query("begin")String begin,
                                          @Query("end")String end);

    //获取历史订单记录（近三个月） Get Order History (last 3 months)
    @GET("/api/v5/trade/orders-history-archive")
    Call<JSONObject> getOrderHistory3months(@Query("instType") String instType,
                                            @Query("uly")String uly,
                                            @Query("instId")String instId,
                                            @Query("ordType")String ordType,
                                            @Query("instFamily")String instFamily,
                                            @Query("state")String state,
                                            @Query("category")String category,
                                            @Query("after")String after,
                                            @Query("before")String before,
                                            @Query("limit")String limit,
                                            @Query("begin")String begin,
                                            @Query("end")String end);

    //获取成交明细（近三天） Get Transaction Details(last 3 days）
    @GET("/api/v5/trade/fills")
    Call<JSONObject> getTransactionDetails(@Query("instType") String instType,
                                           @Query("uly")String uly,
                                           @Query("instId")String instId,
                                           @Query("ordId")String ordId,
                                           @Query("instFamily")String instFamily,
                                           @Query("after")String after,
                                           @Query("before")String before,
                                           @Query("begin")String begin,
                                           @Query("end")String end,
                                           @Query("limit")String limit,
                                           @Query("subType")String subType);

    //获取成交明细（近三个月） Get Transaction Details(last 3 months）
    @GET("/api/v5/trade/fills-history")
    Call<JSONObject> getTransactionDetailsForThreeMonths(@Query("instType") String instType,
                                           @Query("uly")String uly,
                                           @Query("instId")String instId,
                                           @Query("ordId")String ordId,
                                           @Query("instFamily")String instFamily,
                                           @Query("after")String after,
                                           @Query("before")String before,
                                           @Query("begin")String begin,
                                           @Query("end")String end,
                                           @Query("limit")String limit, @Query("subType")String subType);


    //委托策略下单 Place Algo Order
    @POST("/api/v5/trade/order-algo")
    Call<JSONObject> placeAlgoOrder(@Body JSONObject jsonObject);

    //撤销策略委托订单 Cancel Algo Order
    @POST("/api/v5/trade/cancel-algos")
    Call<JSONObject> cancelAlgoOrders(@Body List<CancelAlgoOrder> cancelAlgoOrder);

    //撤销高级策略委托订单 Cancel Advance Algo Order
    @POST("/api/v5/trade/cancel-advance-algos")
    Call<JSONObject> cancelAdvanceAlgoOrders(@Body List<CancelAlgoOrder> cancelAlgoOrder);

    //获取未完成策略委托单列表 Get Algo Order List
    @GET("/api/v5/trade/orders-algo-pending")
    Call<JSONObject> getAlgoOrderList(@Query("algoId") String algoId,
                                      @Query("instType") String instType,
                                      @Query("instId") String instId,
                                      @Query("ordType") String ordType,
                                      @Query("algoClOrdId") String algoClOrdId,
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
                                         @Query("clOrdId") String clOrdId,
                                         @Query("after") String after,
                                         @Query("before") String before,
                                         @Query("limit") String limit);

    //获取一键兑换主流币币种列表  Get easy convert currency list
    @GET("/api/v5/trade/easy-convert-currency-list")
    Call<JSONObject> getEasyConvertCurrencyList();

    //一键兑换主流币交易  Place easy convert
    @POST("/api/v5/trade/easy-convert")
    Call<JSONObject> placeEasyConvert(@Body EasyConvert easyConvert);

    //获取一键兑换主流币历史记录  Get easy convert history
    @GET("/api/v5/trade/easy-convert-history")
    Call<JSONObject> getEasyConvertHistory(@Query("after") String after,
                                           @Query("before") String before,
                                           @Query("limit") String limit);

    //获取一键还债币种列表 Get one-click repay currency list
    @GET("/api/v5/trade/one-click-repay-currency-list")
    Call<JSONObject> getOneClickRepayCurrencyList(@Query("debtType") String debtType);

    //一键还债交易 Trade one-click repay
    @POST("/api/v5/trade/one-click-repay")
    Call<JSONObject> oneClickRepay(@Body OneClickRepay oneClickRepay );

    //获取一键还债历史记录 Get one-click repay history
    @GET("/api/v5/trade/one-click-repay-history")
    Call<JSONObject> getOneClickRepayHistory(@Query("after") String after,
                                                     @Query("before") String before,
                                                     @Query("limit") String limit   );

    @GET("/api/v5/trade/order-algo")
    Call<JSONObject>  getAlgoOrderDetails(@Query("algoId")String algoId, @Query("algoClOrdId")String algoClOrdId);

    @POST("/api/v5/trade/amend-algos")
    Call<JSONObject> amendAlgos(@Body AmendAlgos amendAlgos);


    @POST("/api/v5/trade/mass-cancel")
    Call<JSONObject> massCancelOrder(@Body CancelOrder cancelOrder);


    @POST("/api/v5/trade/cancel-all-after")
    Call<JSONObject>  cancelAllOrder(@Body CancelOrder cancelOrder);

    @GET("/api/v5/tradingBot/signal/orders-algo-details")
    Call<JSONObject>   getOrdersAlgoDetails(@Query("algoOrdType")String algoOrdType, @Query("algoId")String algoId);

    @GET("/api/v5/tradingBot/grid/positions")
    Call<JSONObject> getSignalPositions(@Query("algoOrdType")String algoOrdType, @Query("algoId")String algoId);

    @GET("/api/v5/tradingBot/signal/sub-orders")
    Call<JSONObject>  getSignalSubOrders(@Query("algoId")String algoId, @Query("algoOrdType")String algoOrdType,@Query("type") String type, @Query("clOrdId")String clOrdId,@Query("after") String after,@Query("before") String before,@Query("begin") String begin,@Query("end") String end,@Query("limit") String limit);

    @GET("/api/v5/tradingBot/signal/event-history")
    Call<JSONObject> getSignalEventHistory(@Query("algoId")String algoId, @Query("after")String after,@Query("before") String before,@Query("limit") String limit);

    @POST("/api/v5/trade/fills-archive")
    Call<JSONObject> applyFillsArchive(@Body Fills fills);

    @GET("/api/v5/trade/fills-archive")
    Call<JSONObject> getFillsArchive(@Query("year")String year, @Query("quarter")String quarter);

    @GET("/api/v5/trade/account-rate-limit")
    Call<JSONObject> getAccountRateLimit(@Query("fillRatio")String fillRatio,@Query("mainFillRatio") String mainFillRatio,@Query("accRateLimit") String accRateLimit,@Query("nextAccRateLimit") String nextAccRateLimit,@Query("ts") String ts);
}
