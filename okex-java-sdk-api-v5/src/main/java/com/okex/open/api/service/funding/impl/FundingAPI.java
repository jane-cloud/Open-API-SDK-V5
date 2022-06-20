package com.okex.open.api.service.funding.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;


interface FundingAPI {

    //获取币种列表 Get Currencies
    @GET("/api/v5/asset/currencies")
    Call<JSONObject> getCurrencies();

    //获取资金账户余额
    @GET("/api/v5/asset/balances")
    Call<JSONObject> getBalance(@Query("ccy") String ccy);

    //资金划转  Funds Transfer
    @POST("/api/v5/asset/transfer")
    Call<JSONObject> fundsTransfer(@Body JSONObject jsonObject);

    //资金流水查询 Asset Bills Details
    @GET("/api/v5/asset/bills")
    Call<JSONObject> assetBillsDetails(@Query("ccy")String ccy,@Query("type")String type,@Query("clientId")String clientId,@Query("after")String after,@Query("before")String before,@Query("limit")String limit);

    //获取充值地址信息 Get Deposit Address
    @GET("/api/v5/asset/deposit-address")
    Call<JSONObject> getDepositAddress(@Query("ccy") String ccy);

    //获取充值记录 Get Deposit History
    @GET("/api/v5/asset/deposit-history")
    Call<JSONObject> getDepositHistory(@Query("ccy") String ccy,@Query("txId") String txId,@Query("state")String state,@Query("after")String after,@Query("before")String before,@Query("limit")String limit,@Query("depId")String depId);

    //提币 Withdrawal
    @POST("/api/v5/asset/withdrawal")
    Call<JSONObject> Withdrawal(@Body JSONObject jsonObject);

    //获取提币记录 Get Withdrawal History
    @GET("/api/v5/asset/withdrawal-history")
    Call<JSONObject> getWithdrawalHistory(@Query("ccy") String ccy,@Query("clientId") String clientId,@Query("txId") String txId,@Query("state")String state,@Query("after")String after,@Query("before")String before,@Query("limit")String limit,@Query("wdId")String wdId);

    //余币宝申购/赎回 PiggyBank Purchase/Redemption
    @POST("/api/v5/asset/purchase_redempt")
    Call<JSONObject> piggyBankPurchaseRedemption(@Body JSONObject jsonObject);

    //获取余币宝余额
    @GET("/api/v5/asset/saving-balance")
    Call<JSONObject> piggyBalance(@Query("ccy") String ccy);

    //闪电网络充币 Deposit Lightning
    @GET("/api/v5/asset/deposit-lightning")
    Call<JSONObject> depositLightning(@Query("ccy")String ccy, @Query("amt")String amt, @Query("to")String to);

    //闪电网络提币 Withdrawal Lightning
    @POST("/api/v5/asset/withdrawal-lightning")
    Call<JSONObject>  withdrawalLightning(@Body JSONObject jsonObject);

    //获取资金划转状态 Transfer State
    @GET("/api/v5/asset/transfer-state")
    Call<JSONObject> transferState(@Query("transId")String transId, @Query("clientId")String clientId ,@Query("type")String type);

    //获取账户资产估值 Get account asset valuation
    @GET("/api/v5/asset/asset-valuation")
    Call<JSONObject> assetValuation(@Query("ccy") String ccy);

    //设置余币宝借贷利率 Set lending rate
    @POST("/api/v5/asset/set-lending-rate")
    Call<JSONObject>  SetLendingRate(@Body JSONObject jsonObject);

    //获取余币宝出借明细  Get lending history
    @GET("/api/v5/asset/lending-history")
    Call<JSONObject> lendingHistory(@Query("ccy") String ccy,@Query("after") String after,@Query("before") String before,@Query("limit") String limit);

    //获取市场借贷信息（公共） Get public borrow info (public)
    @GET("/api/v5/asset/lending-rate-summary")
    Call<JSONObject> lendingRateSummary(@Query("ccy") String ccy);

    //获取市场借贷历史（公共）  Get public borrow history (public)
    @GET("/api/v5/asset/lending-rate-history")
    Call<JSONObject> lendingRateHistory(@Query("ccy") String ccy,@Query("after") String after,@Query("before") String before,@Query("limit") String limit);

    @POST("/api/v5/asset/convert-dust-assets")
    Call<JSONObject> ConvertDustAssets(@Body JSONObject parseObject);

    @POST("/api/v5/asset/cancel-withdrawal")
    Call<JSONObject> cancelWithdrawal(@Body JSONObject parseObject);
}