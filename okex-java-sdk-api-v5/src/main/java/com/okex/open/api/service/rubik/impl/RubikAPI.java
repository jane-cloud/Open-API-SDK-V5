package com.okex.open.api.service.rubik.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RubikAPI {

    //获取交易大数据数据支持币种 Get support coin
    @GET("/api/v5/rubik/stat/trading-data/support-coin")
    Call<JSONObject> getSupportCoin();

    //获取币币或衍生品主动买入/卖出情况 Get taker volume
    @GET("/api/v5/rubik/stat/taker-volume")
    Call<JSONObject> getTakerVolume(@Query("ccy") String ccy,
                                    @Query("instType")String instType,
                                    @Query("begin")String begin,
                                    @Query("end")String end,
                                    @Query("period")String period);

    //获取杠杆多空比 Get Margin lending ratio
    @GET("/api/v5/rubik/stat/margin/loan-ratio")
    Call<JSONObject> getLoanRatio(@Query("ccy") String ccy,
                                  @Query("begin")String begin,
                                  @Query("end")String end,
                                  @Query("period")String period);

    //获取多空持仓人数比 Get Long/Short ratio
    @GET("/api/v5/rubik/stat/contracts/long-short-account-ratio")
    Call<JSONObject> getLongShortAccountRatio(@Query("ccy") String ccy,
                                  @Query("begin")String begin,
                                  @Query("end")String end,
                                  @Query("period")String period);

    //获取持仓总量及交易量 Get contracts open interest and volume
    @GET("/api/v5/rubik/stat/contracts/open-interest-volume")
    Call<JSONObject> getOpenInterestVolume(@Query("ccy") String ccy,
                                              @Query("begin")String begin,
                                              @Query("end")String end,
                                              @Query("period")String period);

    //获取期权合约持仓总量及交易量 Get Options open interest and volume
    @GET("/api/v5/rubik/stat/option/open-interest-volume")
    Call<JSONObject> getOptionOpenInterestVolume(@Query("ccy") String ccy,
                                                 @Query("period")String period);

    //看涨/看跌期权合约 持仓总量比/交易总量比 Get Put/Call ratio
    @GET("/api/v5/rubik/stat/option/open-interest-volume-ratio")
    Call<JSONObject> getOpenInterestVolumeRatio(@Query("ccy") String ccy,
                                                 @Query("period")String period);

    //看涨看跌持仓总量及交易总量（按到期日分） Get open interest and volume (expiry)
    @GET("/api/v5/rubik/stat/option/open-interest-volume-expiry")
    Call<JSONObject> getOpenInterestVolumeExpiry(@Query("ccy") String ccy,
                                                @Query("period")String period);

    //看涨看跌持仓总量及交易总量（按执行价格分） Get open interest and volume (strike)
    @GET("/api/v5/rubik/stat/option/open-interest-volume-strike")
    Call<JSONObject> getOpenInterestVolumeStrike(@Query("ccy") String ccy,
                                                 @Query("expTime") String expTime,
                                                 @Query("period")String period);

    //看跌/看涨期权合约 主动买入/卖出量 Get Taker flow
    @GET("/api/v5/rubik/stat/option/taker-block-volume")
    Call<JSONObject> getTakerBlockVolume(@Query("ccy") String ccy,
                                         @Query("period")String period);


    @GET("/api/v5/rubik/stat/contracts/open-interest-history")
    Call<JSONObject> getOpenInterestHistory(@Query("instId") String instId,@Query("period")  String period,@Query("end")  String end, @Query("begin") String begin,@Query("limit")  String limit);

    @GET("/api/v5/rubik/stat/taker-volume-contract")
    Call<JSONObject>  getTakerVolumeContract(@Query("instId") String instId,@Query("period")  String period,@Query("unit")  String unit,@Query("end")  String end, @Query("begin") String begin,@Query("limit")  String limit);

    @GET("/api/v5/rubik/stat/contracts/long-short-account-ratio-contract-top-trader")
    Call<JSONObject> getTopLongShortRatio(@Query("instId") String instId,@Query("period")  String period,@Query("end")  String end, @Query("begin") String begin,@Query("limit")  String limit);

    @GET("/api/v5/rubik/stat/contracts/long-short-position-ratio-contract-top-trader")
    Call<JSONObject> getTopLongShortPosRatio(@Query("instId") String instId,@Query("period")  String period,@Query("end")  String end, @Query("begin") String begin,@Query("limit")  String limit);

    @GET("/api/v5/rubik/stat/contracts/long-short-account-ratio-contract")
    Call<JSONObject> getLongShortRatio(@Query("instId") String instId,@Query("period")  String period,@Query("end")  String end, @Query("begin") String begin,@Query("limit")  String limit);

}
