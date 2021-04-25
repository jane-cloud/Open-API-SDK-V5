package com.okex.open.api.service.account.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;


public interface AccountAPI {

    //查看账户持仓风险 Get account and position risk
    @GET("/api/v5/account/account-position-risk")
    Call<JSONObject> getAccountAndPosition(@Query("instType") String instType);


    //查看账户余额 Get Balance
    @GET("/api/v5/account/balance")
    Call<JSONObject> getBalance(@Query("ccy") String ccy);


    //查看持仓信息 Get Positions
    @GET("/api/v5/account/positions")
    Call<JSONObject> getPositions(@Query("instType") String instType,@Query("instId") String instId,@Query("posId") String posId);

    //账单流水查询（近七天） Get Bills Details (last 7 days)
    @GET("/api/v5/account/bills")
    Call<JSONObject> getBillsDetails7Days(@Query("instType") String instType,
                                          @Query("ccy")String ccy,
                                          @Query("mgnMode")String mgnMode,
                                          @Query("ctType")String ctType,
                                          @Query("type")String type,
                                          @Query("subType")String subType,
                                          @Query("after")String after,
                                          @Query("before")String before,
                                          @Query("limit")String limit);

    //账单流水查询（近七天） Get Bills Details (last 3 months)
    @GET("/api/v5/account/bills-archive")
    Call<JSONObject> getBillsDetails3Months(@Query("instType") String instType,
                                          @Query("ccy")String ccy,
                                          @Query("mgnMode")String mgnMode,
                                          @Query("ctType")String ctType,
                                          @Query("type")String type,
                                          @Query("subType")String subType,
                                          @Query("after")String after,
                                          @Query("before")String before,
                                          @Query("limit")String limit);

    //查看账户配置 Get Account Configuration
    @GET("/api/v5/account/config")
    Call<JSONObject> getAccountConfiguration();

    //设置持仓模式 Set Position mode
    @POST("/api/v5/account/set-position-mode")
    Call<JSONObject> setPositionMode(@Body JSONObject jsonObject);

    //设置杠杆倍数 Set Leverage
    @POST("/api/v5/account/set-leverage")
    Call<JSONObject> setLeverage(@Body JSONObject jsonObject);

    //获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount
    @GET("/api/v5/account/max-size")
    Call<JSONObject> getMaximumTradableSizeForInstrument(@Query("instId") String instId,@Query("tdMode") String tdMode,@Query("ccy") String ccy,@Query("px") String px);

    //获取最大可用数量 Get Maximum Tradable Size For Instrument
    @GET("/api/v5/account/max-avail-size")
    Call<JSONObject> getMaximumAvailableTradableAmount(@Query("instId") String instId,@Query("tdMode") String tdMode,@Query("ccy") String ccy,@Query("reduceOnly") String reduceOnly);

    //调整保证金 Increase/Decrease margin
    @POST("/api/v5/account/position/margin-balance")
    Call<JSONObject> increaseDecreaseMargin(@Body JSONObject jsonObject);

    //获取杠杆倍数 Get Leverage
    @GET("/api/v5/account/leverage-info")
    Call<JSONObject> getLeverage(@Query("instId") String instId,@Query("mgnMode") String mgnMode);

    //获取交易产品最大可借 Get the maximum loan of instrument
    @GET("/api/v5/account/max-loan")
    Call<JSONObject> getTheMaximumLoanOfIsolatedMARGIN(@Query("instId")String instId,@Query("mgnMode")String mgnMode,@Query("mgnCcy")String mgnCcy);

    //获取当前账户交易手续费费率 Get Fee Rates
    @GET("/api/v5/account/trade-fee")
    Call<JSONObject> getFeeRates(@Query("instType")String instType,@Query("instId")String instId,@Query("uly")String uly,@Query("category")String category);

    //获取计息记录 Get interest-accrued
    @GET("/api/v5/account/interest-accrued")
    Call<JSONObject> getInterestAccrued(@Query("instId")String instId,@Query("ccy")String ccy,@Query("mgnMode")String mgnMode,@Query("after")String after,@Query("before")String before,@Query("limit")String limit);

    //获取用户当前杠杆借币利率 Get interest rate
    @GET("/api/v5/account/interest-rate")
    Call<JSONObject> getInterestRate(@Query("ccy")String ccy);

    //期权希腊字母PA/BS切换 Set the display type of Greeks
    @POST("/api/v5/account/set-greeks")
    Call<JSONObject> setTheDisplayTypeOfGreeks(@Body JSONObject jsonObject);

    //查看账户最大可转余额 Get Maximum Withdrawals
    @GET("/api/v5/account/max-withdrawal")
    Call<JSONObject> getMaximumWithdrawals(@Query("ccy") String ccy);
}
