package com.okex.open.api.service.finance.impl;


import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FinanceAPI {

    //获取余币宝余额
    @GET("/api/v5/finance/savings/balance")
    Call<JSONObject> getFinanceBalance(@Query("ccy") String ccy);

   //余币宝申购/赎回
    @POST("/api/v5/finance/savings/purchase-redempt")
    Call<JSONObject> PurchaseRedempt(@Body JSONObject jsonObject);
    //设置余币宝借贷利率
    @POST("/api/v5/finance/savings/set-lending-rate")
    Call<JSONObject> setLendingRate(@Body JSONObject parseObject);
    //获取余币宝出借明细
    @GET("/api/v5/finance/savings/lending-history")
    Call<JSONObject> getLendingHistory(@Query("ccy")String ccy, @Query("after")String after, @Query("before")String before, @Query("limit")String limit);
    @GET("/api/v5/finance/savings/lending-rate-summary")
    Call<JSONObject>  getLendingRateSummary(@Query("ccy")String ccy);
    @GET("/api/v5/finance/savings/lending-rate-history")
    Call<JSONObject>  getLendingRateHistory(@Query("ccy")String ccy, @Query("after")String after, @Query("before")String before, @Query("limit")String limit);

    @GET("/api/v5/finance/fixed-loan/lending-offers")
    Call<JSONObject>  getLendingOffers(@Query("ccy")String ccy, @Query("term")String term);

    @GET("/api/v5/finance/fixed-loan/lending-apy-history")
    Call<JSONObject> getLendingApyHistory(@Query("ccy")String ccy, @Query("term")String term);

    @GET("/api/v5/finance/fixed-loan/pending-lending-volume")
    Call<JSONObject> getPendingLendingVolume(@Query("ccy")String ccy, @Query("term")String term);

    @POST("/api/v5/finance/fixed-loan/lending-order")
    Call<JSONObject> lendingOrder(@Body JSONObject parseObject);

 @POST("/api/v5/finance/fixed-loan/amend-lending-order")
 Call<JSONObject> amendLendingOrder(@Body JSONObject parseObject);

 @GET("/api/v5/finance/fixed-loan/lending-orders-list")
 Call<JSONObject> getLendingOrdersList(@Query("ordId")String ordId,@Query("ccy") String ccy,@Query("state") String state, @Query("after")String after,@Query("before") String before,@Query("limit") String limit);

 @GET("/api/v5/finance/fixed-loan/lending-sub-orders")
 Call<JSONObject> getLendingSubOrders(@Query("ordId")String ordId,@Query("state") String state, @Query("after")String after,@Query("before") String before,@Query("limit") String limit);

}
