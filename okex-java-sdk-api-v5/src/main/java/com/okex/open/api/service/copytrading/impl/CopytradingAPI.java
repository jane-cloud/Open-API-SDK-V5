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
                                         @Query("instType") String instType,
                                         @Query("subPosType") String subPosType,
                                         @Query("uniqueCode") String uniqueCode
    );

    //交易员获取历史带单 Get leading position history
    @GET("/api/v5/copytrading/subpositions-history")
    Call<JSONObject> subpositionsHistory(@Query("instId") String instId,
                                         @Query("after") String after,
                                         @Query("before") String before,
                                         @Query("limit") String limit,
                                         @Query("instType") String instType,
                                         @Query("subPosType") String subPosType
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

    Call<JSONObject> setAlgoOrder(@Body JSONObject parseObject);

    // 首次跟单设置
    @POST("/api/v5/copytrading/first-copy-settings")
    Call<JSONObject> setFirstCopySettings(@Body JSONObject parseObject);


    @POST("/api/v5/copytrading/amend-copy-settings")
    Call<JSONObject> amendCopySettings(@Body JSONObject parseObject);

    @POST("/api/v5/copytrading/stop-copy-trading")
    Call<JSONObject> stopCopyTrading(@Body JSONObject parseObject);

    @GET("/api/v5/copytrading/copy-settings")
    Call<JSONObject> getCopySettings(@Query("instType") String instType,@Query("uniqueCode") String uniqueCode);

    @GET("/api/v5/copytrading/batch-leverage-info")
    Call<JSONObject> getBatchLeverageInf(@Query("mgnMode")String mgnMode,@Query("uniqueCode") String uniqueCode,@Query("instId") String instId);

    @POST("/api/v5/copytrading/batch-set-leverage")
    Call<JSONObject> setBatchSetLeverage(@Body JSONObject parseObject);

    @GET("/api/v5/copytrading/current-lead-traders")
    Call<JSONObject> getCurrentLeadTraders(@Query("instType")String instType);

    @GET("/api/v5/copytrading/lead-traders-history")
    Call<JSONObject> getLeadTradersHistory(@Query("instType")String instType,@Query("after") String after,@Query("before") String before,@Query("limit") String limit);

    @GET("/api/v5/copytrading/public-config")
    Call<JSONObject> getPublicConfig(@Query("instType")String instType);

    @GET("/api/v5/copytrading/public-lead-traders")
    Call<JSONObject> getPublicLeadTraders(@Query("instType")String instType,@Query("sortType") String sortType,@Query("state") String state,@Query("minLeadDays") String minLeadDays,@Query("minAssets") String minAssets,@Query("maxAssets") String maxAssets,@Query("minAum") String minAum,@Query("maxAum") String maxAum,@Query("dataVer") String dataVer,@Query("page") String page,@Query("limit") String limit);

    @GET("/api/v5/copytrading/public-weekly-pnl")
    Call<JSONObject> getPublicWeeklyPnl(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode);

    @GET("/api/v5/copytrading/public-pnl")
    Call<JSONObject>  getPublicPnl(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode,@Query("lastDays") String lastDays);

    @GET("/api/v5/copytrading/public-stats")
    Call<JSONObject> getPublicStats(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode,@Query("lastDays") String lastDays);

    @GET("/api/v5/copytrading/public-preference-currency")
    Call<JSONObject>  getPublicPreferenceCurrency(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode);

    @GET("/api/v5/copytrading/public-current-subpositions")
    Call<JSONObject> getPublicCurrentSubpositions(@Query("instType")String instType,@Query("uniqueCode") String uniqueCode,@Query("after") String after,@Query("before") String before, @Query("limit")String limit);

    @GET("/api/v5/copytrading/public-subpositions-history")
    Call<JSONObject> getPublicSubpositionsHistory(@Query("instType")String instType,@Query("uniqueCode") String uniqueCode,@Query("after") String after,@Query("before") String before, @Query("limit")String limit);

    @POST("/api/v5/copytrading/apply-lead-trading")
    Call<JSONObject> applyLeadTrading(@Body JSONObject parseObject);

    @POST("/api/v5/copytrading/stop-lead-trading")
    Call<JSONObject> stopLeadTrading(@Body JSONObject parseObject);

    @POST("/api/v5/copytrading/amend-profit-sharing-ratio")
    Call<JSONObject>  amendProfitSharingRatio(@Body JSONObject parseObject);

    @GET("/api/v5/copytrading/lead-traders")
    Call<JSONObject> getPrivateLeadTraders(@Query("instType")String instType,@Query("sortType") String sortType,@Query("state") String state,@Query("minLeadDays") String minLeadDays,@Query("minAssets") String minAssets,@Query("maxAssets") String maxAssets,@Query("minAum") String minAum,@Query("maxAum") String maxAum,@Query("dataVer") String dataVer,@Query("page") String page,@Query("limit") String limit);

    @GET("/api/v5/copytrading/weekly-pnl")
    Call<JSONObject>  getWeeklyPnl(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode);

    @GET("/api/v5/copytrading/pnl")
    Call<JSONObject>  getPnl(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode,@Query("lastDays") String lastDays);
    @GET("/api/v5/copytrading/stats")
    Call<JSONObject> getStats(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode,@Query("lastDays") String lastDays);
    @GET("/api/v5/copytrading/preference-currency")
    Call<JSONObject>  getPreferenceCurrency(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode);

    @GET("/api/v5/copytrading/current-subpositions")
    Call<JSONObject> getCurrentSubpositions(@Query("instType")String instType,@Query("uniqueCode") String uniqueCode,@Query("after") String after,@Query("before") String before, @Query("limit")String limit);

    @GET("/api/v5/copytrading/subpositions-history")
    Call<JSONObject> getSubpositionsHistory(@Query("instType")String instType,@Query("uniqueCode") String uniqueCode,@Query("after") String after,@Query("before") String before, @Query("limit")String limit);

    @GET("/api/v5/copytrading/public-copy-traders")
    Call<JSONObject> getCopyTraders(@Query("instType")String instType,@Query("uniqueCode") String uniqueCode, @Query("limit")String limit);

    @GET("/api/v5/copytrading/copy-traders")
    Call<JSONObject> getPublicCopyTraders(@Query("instType")String instType, @Query("uniqueCode")String uniqueCode,@Query("limit") String limit);

    @GET("/api/v5/copytrading/config")
    Call<JSONObject> getAccountConfig();

    @GET("/api/v5/copytrading/total-unrealized-profit-sharing")
    Call<JSONObject> getTotalUnrealizedProfitSharing(@Query("instType")String instType);
}
