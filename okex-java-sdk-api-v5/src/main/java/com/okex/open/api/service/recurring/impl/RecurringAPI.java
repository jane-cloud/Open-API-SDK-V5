package com.okex.open.api.service.recurring.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.recurringTrading.Recurring;
import com.okex.open.api.bean.trade.param.PlaceOrder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface RecurringAPI {
    @POST("/api/v5/tradingBot/recurring/order-algo")
    Call<JSONObject> placeOrderAlgo(@Body JSONObject jsonObject);

    @POST("/api/v5/tradingBot/recurring/amend-order-algo")
    Call<JSONObject>  amendOrderAlgo(@Body JSONObject parseObject);

    @POST("/api/v5/tradingBot/recurring/stop-order-algo")
    Call<JSONObject>  stopOrderAlgo(@Body List<Recurring> recurring);

    @GET("/api/v5/tradingBot/recurring/orders-algo-pending")
    Call<JSONObject> getOrderAlgoPending(@Query("algoId") String algoId,@Query("after") String after,@Query("before") String before,@Query("limit") String limit,@Query("recurringHour") String recurringHour,@Query("nextInvestTime") String nextInvestTime);

    @GET("/api/v5/tradingBot/recurring/orders-algo-history")
    Call<JSONObject>  getOrderAlgoHistory(@Query("algoId") String algoId,@Query("after") String after,@Query("before") String before,@Query("limit") String limit,@Query("recurringHour") String recurringHour,@Query("nextInvestTime") String nextInvestTime);

    @GET("/api/v5/tradingBot/recurring/orders-algo-details")
    Call<JSONObject> getOrderAlgoDetails(@Query("algoId") String algoIds,@Query("recurringHour") String recurringHour,@Query("nextInvestTime") String nextInvestTime);

    @GET("/api/v5/tradingBot/recurring/sub-orders")
    Call<JSONObject> getSubOrders(@Query("algoId") String algoId,@Query("ordId") String ordId,@Query("after") String after,@Query("before") String before,@Query("limit") String limit);
}
