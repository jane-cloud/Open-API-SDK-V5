package com.okex.open.api.service.account.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.AccountQuickBorrowRepay;
import retrofit2.Call;
import retrofit2.http.*;


public interface AccountAPI {

    //查看账户余额 Get Balance
    @GET("/api/v5/account/balance")
    Call<JSONObject> getBalance(@Query("ccy") String ccy);

    //查看持仓信息 Get Positions
    @GET("/api/v5/account/positions")
    Call<JSONObject> getPositions(@Query("instType") String instType,@Query("instId") String instId,@Query("posId") String posId);

    //查看历史持仓信息   Get positions-history
    @GET("/api/v5/account/positions-history")
    Call<JSONObject> getPositionsHistory(@Query("instType") String instType, @Query("instId") String instId, @Query("mgnMode") String mgnMode, @Query("type") String type, @Query("after") String after, @Query("before") String before, @Query("limit") String limit,@Query("posId") String posId);

    //查看账户持仓风险 Get account and position risk
    @GET("/api/v5/account/account-position-risk")
    Call<JSONObject> getAccountAndPosition(@Query("instType") String instType);

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

    //账单流水查询（近三月） Get Bills Details (last 3 months)
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
    Call<JSONObject> getMaximumTradableSizeForInstrument(@Query("instId") String instId,@Query("tdMode") String tdMode,@Query("ccy") String ccy,@Query("px") String px,@Query("leverage") String leverage,@Query("unSpotOffset") Boolean unSpotOffset);

    //获取最大可用数量 Get Maximum Tradable Size For Instrument
    @GET("/api/v5/account/max-avail-size")
    Call<JSONObject> getMaximumAvailableTradableAmount(@Query("instId") String instId,@Query("tdMode") String tdMode,@Query("ccy") String ccy,@Query("reduceOnly") Boolean reduceOnly,@Query("px") String px,@Query("unSpotOffset") Boolean unSpotOffset,@Query("quickMgnType") String quickMgnType);

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
    Call<JSONObject> getFeeRates(@Query("instType")String instType,@Query("instId")String instId,@Query("uly")String uly,@Query("instFamily")String instFamily);

    //获取计息记录 Get interest-accrued
    @GET("/api/v5/account/interest-accrued")
    Call<JSONObject> getInterestAccrued(@Query("type")String type,@Query("instId")String instId,@Query("ccy")String ccy,@Query("mgnMode")String mgnMode,@Query("after")String after,@Query("before")String before,@Query("limit")String limit);

    //获取用户当前杠杆借币利率 Get interest rate
    @GET("/api/v5/account/interest-rate")
    Call<JSONObject> getInterestRate(@Query("ccy")String ccy);

    //期权希腊字母PA/BS切换 Set the display type of Greeks
    @POST("/api/v5/account/set-greeks")
    Call<JSONObject> setTheDisplayTypeOfGreeks(@Body JSONObject jsonObject);

    //逐仓交易设置 Isolated margin trading settings
    @POST("/api/v5/account/set-isolated-mode")
    Call<JSONObject> setIsolatedMode(@Body JSONObject jsonObject);

    //查看账户最大可转余额 Get Maximum Withdrawals
    @GET("/api/v5/account/max-withdrawal")
    Call<JSONObject> getMaximumWithdrawals(@Query("ccy") String ccy);

    //查看账户特定风险状态 Get account risk state
    @GET("/api/v5/account/risk-state")
    Call<JSONObject> getRiskState();

    //一键借币模式手动借币还币 Manual borrow and repay in Quick Margin Mode
    @POST("/api/v5/account/quick-margin-borrow-repay")
    Call<JSONObject> quickMarginBorrowRepay(@Body JSONObject jsonObject);

    //获取一键借币还币历史 Get manual borrow and repay history in Quick Margin Mode
    @GET("/api/v5/account/borrow-repay-history")
    Call<JSONObject> getMarginBorrowRepayHistory(@Query("instId") String instId,@Query("ccy")  String ccy,@Query("side")  String side,@Query("after")  String after,@Query("before")  String before,@Query("begin")  String begin,@Query("end")  String end,@Query("limit")  String limit);

    //尊享借币还币  VIP loans borrow and repay
    @POST("/api/v5/account/borrow-repay")
    Call<JSONObject> borrowRepay(@Body JSONObject parseObject);

    //获取尊享借币借还历史  Get borrow and repay history for VIP loans
    @GET("/api/v5/account/borrow-repay-history")
    Call<JSONObject> getBorrowRepayHistory(@Query("ccy") String ccy,@Query("after") String after,@Query("before") String before,@Query("limit") String limit);

    //获取尊享借币计息记录 Get VIP interest accrued data
    @GET("/api/v5/account/vip-interest-accrued")
    Call<JSONObject>  getVipInterestAccrued(@Query("ccy") String ccy,@Query("ordId")  String ordId,@Query("after")  String after,@Query("before")  String before,@Query("limit")  String limit);

    //获取尊享借币扣息记录 Get VIP interest deducted data
    @GET("/api/v5/account/vip-interest-deducted")
    Call<JSONObject>  getVipInterestDeducted(@Query("ordId") String ordId,@Query("ccy") String ccy,@Query("after") String after,@Query("before") String before,@Query("limit") String limit);

    //尊享借币订单列表 Get VIP loan order list
    @GET("/api/v5/account/vip-loan-order-list")
    Call<JSONObject>  getVipLoanOrderList(@Query("ordId") String ordId, @Query("state") String state, @Query("ccy") String ccy, @Query("after") String after, @Query("before") String before, @Query("limit") String limit);

    //尊享借币订单详情 Get VIP loan order detail
    @GET("/api/v5/account/vip-loan-order-detail")
    Call<JSONObject>  getVipLoanOrderDetail(@Query("ccy") String ccy,@Query("ordId")  String ordId,@Query("after")  String after,@Query("before")  String before,@Query("limit")  String limit);

    //获取借币利率与限额  Get borrow interest and limit
    @GET("/api/v5/account/interest-limits")
    Call<JSONObject> getInterestLimits(@Query("type") String type,@Query("ccy") String ccy);

    //组合保证金的虚拟持仓保证金计算 Position builder
    @POST("/api/v5/account/simulated_margin")
    Call<JSONObject> simulatedMargin(@Body JSONObject parseObject);

    //查看账户Greeks Get Greeks
    @GET("/api/v5/account/greeks")
    Call<JSONObject> getAccountGreeks(@Query("ccy") String ccy);

    //获取组合保证金模式全仓限制 Get PM limitation
    @GET("/api/v5/account/position-tiers")
    Call<JSONObject> getPositionTiers(@Query("instType") String instType,@Query("uly")  String uly,@Query("instFamily")  String instFamily);

    // 设置组合保证金账户风险对冲模式 Set risk offset type
    @POST("/api/v5/account/set-riskOffset-type")
    Call<JSONObject> setRiskOffsetType(@Body JSONObject parseObject);

    //开通期权交易 Activate option
    @POST("/api/v5/account/activate-option")
    Call<JSONObject> activateOption();
}
