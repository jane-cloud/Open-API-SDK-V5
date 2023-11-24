package com.okex.open.api.service.convert.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ConvertAPI {

    //获取闪兑币种列表 Get convert currencies
    @GET("/api/v5/asset/convert/currencies")
    Call<JSONObject> getCurrencies();

    //获取闪兑币对信息 Get convert currency pair
    @GET("/api/v5/asset/convert/currency-pair")
    Call<JSONObject> getCurrencyPair(@Query("fromCcy") String fromCcy,
                                     @Query("toCcy") String toCcy);

    //闪兑预估询价 Estimate quote
    @POST("/api/v5/asset/convert/estimate-quote")
    Call<JSONObject> estimateQuote(@Body JSONObject jsonObject);

    //闪兑交易 Convert trade
    @POST("/api/v5/asset/convert/trade")
    Call<JSONObject> trade(@Body JSONObject jsonObject);

    //获取闪兑交易历史 Get convert history
    @GET("/api/v5/asset/convert/history")
    Call<JSONObject> getHistory(@Query("clTReqId") String clTReqId,
                                @Query("after") String after,
                                @Query("before") String before,
                                @Query("limit") String limit,
                                @Query("tag") String tag);

}
