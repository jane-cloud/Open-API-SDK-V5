package com.okex.open.api.service.earn.impl;


import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EarnAPI {

    //查看项目 Get offers
    @GET("/api/v5/finance/staking-defi/offers")
    Call<JSONObject> getOffers(@Query("productId") String productId, @Query("protocolType") String protocolType, @Query("ccy") String ccy);

    //申购项目 Purchase
    @POST("/api/v5/finance/staking-defi/purchase")
    Call<JSONObject> purchase(@Body JSONObject jsonObject);

    //赎回项目 Redeem
    @POST("/api/v5/finance/staking-defi/redeem")
    Call<JSONObject> redeem(@Body JSONObject jsonObject);

    //撤销项目申购/赎回 Cancel purchases/redemptions
    @POST("/api/v5/finance/staking-defi/cancel")
    Call<JSONObject> cancel(@Body JSONObject jsonObject);

    //查看活跃订单  Get active orders
    @GET("/api/v5/finance/staking-defi/orders-active")
    Call<JSONObject> getActiveOrders(@Query("productId") String productId,
                               @Query("protocolType") String protocolType,
                               @Query("ccy") String ccy,
                               @Query("state") String state);


    //查看历史订单 Get order history
    @GET("/api/v5/finance/staking-defi/orders-history")
    Call<JSONObject> getHistoryOrders(@Query("productId") String productId,
                                      @Query("protocolType") String protocolType,
                                      @Query("ccy") String ccy,
                                      @Query("after") String after,
                                      @Query("before") String before,
                                      @Query("limit") String limit);


}
