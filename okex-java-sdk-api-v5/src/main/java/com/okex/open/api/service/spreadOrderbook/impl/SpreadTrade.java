package com.okex.open.api.service.spreadOrderbook.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.spread.SpreadOrder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface SpreadTrade {

    @POST("/api/v5/sprd/order")
    Call<JSONObject>    placeSprdOrder(@Body JSONObject parseObject);

    @POST("/api/v5/sprd/cancel-order")
    Call<JSONObject>    cancelSprdOrder(@Body JSONObject parseObject);

    @POST("/api/v5/sprd/mass-cancel")
    Call<JSONObject>   massCancelSprdOrder(@Body JSONObject parseObject);

    @GET("/api/v5/account/order")
    Call<JSONObject>   getSprdOrder(@Query("ordId") String ordId,@Query("clOrdId") String clOrdId);

    @GET("/api/v5/sprd/orders-pending")
    Call<JSONObject>    getOrdersPending(@Query("sprdId")String sprdId,@Query("ordType") String ordType,@Query("state") String state,@Query("beginId") String beginId,@Query("endId") String endId,@Query("limit") String limit);
    @GET("/api/v5/sprd/orders-history")
    Call<JSONObject>  getOrdersHistory(@Query("sprdId")String sprdId,@Query("ordType") String ordType,@Query("state") String state,@Query("beginId") String beginId,@Query("endId") String endId,@Query("begin") String begin,@Query("end") String end,@Query("limit") String limit);

    @GET("/api/v5/sprd/trades")
    Call<JSONObject>   getTrades(@Query("sprdId")String sprdId,@Query("tradeId") String tradeId,@Query("ordId") String ordId,@Query("beginId") String beginId,@Query("endId") String endId,@Query("begin") String begin,@Query("end") String end,@Query("limit") String limit);

    @GET("/api/v5/sprd/spreads")
    Call<JSONObject>    getPublicSpreads(@Query("baseCcy")String baseCcy,@Query("instId") String instId,@Query("sprdId")  String sprdId,@Query("state")  String state);

    @GET("/api/v5/sprd/books")
    Call<JSONObject>   getPublicBooks(@Query("sprdId")String sprdId,@Query("sz") String sz);

    @GET("/api/v5/sprd/ticker")
    Call<JSONObject>   getPublicTicker(@Query("sprdId")String sprdId);

    @GET("/api/v5/sprd/public-trades")
    Call<JSONObject>   getPublicTrades(@Query("sprdId")String sprdId);


    @POST("/api/v5/sprd/amend-order")
    Call<JSONObject> amendOrder(@Body SpreadOrder amendOrder);

    @GET("/api/v5/sprd/orders-history-archive")
    Call<JSONObject>  getOrdersHistoryArchive(@Query("sprdId")String sprdId, @Query("ordType")String ordType,@Query("state") String state, @Query("beginId")String beginId,@Query("endId") String endId, @Query("begin")String begin, @Query("end")String end, @Query("limit")String limit, @Query("instType")String instType,@Query("instFamily") String instFamily);

    @GET("/api/v5/market/sprd-history-candles")
    Call<JSONObject> getSprdHistoryCandles(@Query("sprdId")String sprdId,@Query("after")String after, @Query("before")String before,@Query("bar") String bar,@Query("limit") String limit);

    @GET("/api/v5/market/sprd-candles")
    Call<JSONObject> getSprdCandles(@Query("sprdId")String sprdId,@Query("after")String after, @Query("before")String before,@Query("bar") String bar,@Query("limit") String limit);

    @GET("/api/v5/market/sprd-ticker")
    Call<JSONObject> getSprdTicker(@Query("sprdId")String sprdId);

    @POST("/api/v5/sprd/cancel-all-after")
    Call<JSONObject> cancelAllAfter(@Body SpreadOrder cancelAllAfter);
}
