package com.okex.open.api.service.copytrading.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CopytradingAPI {

    //交易员获取当前带单 Get existing leading positions
    @GET("/api/v5/copytrading/current-subpositions")
    Call<JSONObject> currentSubpositions(@Query("instId") String instId,
                                         @Query("after") String after,
                                         @Query("before") String before,
                                         @Query("limit") String limit,
                                         @Query("instType") String instType);

    //交易员获取历史带单 Get leading position history
    @GET("/api/v5/copytrading/subpositions-history")
    Call<JSONObject> subpositionsHistory(@Query("instId") String instId,
                                         @Query("after") String after,
                                         @Query("before") String before,
                                         @Query("limit") String limit,
                                         @Query("instType") String instType
    );

    //交易员止盈止损 Place leading stop order
    @POST("/api/v5/copytrading/algo-order")
    Call<JSONObject> algoOrder(@Body JSONObject jsonObject);

    //交易员平仓 Close leading position
    @POST("/api/v5/copytrading/close-subposition")
    Call<JSONObject> closeSubposition(@Body JSONObject jsonObject);

    //交易员获取带单合约 Get leading instruments
    @GET("/api/v5/copytrading/instruments")
    Call<JSONObject> getInstruments(@Query("instType") String instType);

    //交易员修改带单合约 Amend leading instruments
    @POST("/api/v5/copytrading/set-instruments")
    Call<JSONObject> setInstruments(@Body JSONObject jsonObject);

    //交易员历史分润明细 Get profit sharing details
    @GET("/api/v5/copytrading/profit-sharing-details")
    Call<JSONObject> getProfitSharingDetails(@Query("after") String after,
                                             @Query("before") String before,
                                             @Query("limit") String limit,
                                             @Query("instType") String instType);

    //交易员历史分润汇总 Get total profit sharing
    @GET("/api/v5/copytrading/total-profit-sharing")
    Call<JSONObject> getTotalProfitSharing( @Query("instType") String instType);

    //交易员待分润明细 Get unrealized profit sharing details
    @GET("/api/v5/copytrading/unrealized-profit-sharing-details")
    Call<JSONObject> getUnrealizedProfitSharingDetails( @Query("instType") String instType);

    //交易员止盈止损
    @POST("/api/v5/copytrading/algo-order")
    Call<JSONObject> setAlgoOrder(@Body JSONObject parseObject);
}
