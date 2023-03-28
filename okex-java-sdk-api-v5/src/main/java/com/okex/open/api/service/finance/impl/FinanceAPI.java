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
}
