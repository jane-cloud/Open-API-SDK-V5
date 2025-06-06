package com.okex.open.api.service.broker.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BrokerAPI {

    //Broker账户信息
    @GET("/api/v5/broker/dma/info")
    Call<JSONObject> getInfo();

    //创建子账户  Create sub-account
    @POST("/api/v5/broker/dma/create-subaccount")
    Call<JSONObject> createSubAccount(@Body JSONObject jsonObject);

    //删除子账户  Delete sub-account
    @POST("/api/v5/broker/dma/delete-subaccount")
    Call<JSONObject> deleteSubAccount(@Body JSONObject jsonObject);

    //查询子账户列表  Get sub-account list
    @GET("/api/v5/broker/dma/subaccount-info")
    Call<JSONObject> getSubAccountInfo(@Query("subAcct") String subAcct,
                                       @Query("page") String page,
                                       @Query("limit") String limit);

    //创建子账户的APIKey Create an APIKey for a sub-account
    @POST("/api/v5/broker/dma/subaccount/apikey")
    Call<JSONObject> createSubAccountApikey(@Body JSONObject jsonObject);

    //查询子账户的APIkey Query the APIKey of a sub-account
    @GET("/api/v5/broker/dma/subaccount/apikey")
    Call<JSONObject> getApikeyInfo(@Query("subAcct") String subAcct,
                                   @Query("apiKey") String apiKey);

    //重置子账户的APIKey Reset the APIKey of a sub-account
    @POST("/api/v5/broker/dma/subaccount/modify-apikey")
    Call<JSONObject> modifySubAccountApikey(@Body JSONObject jsonObject);

    //删除子账户的APIKey Delete the APIKey of sub-accounts
    @POST("/api/v5/broker/dma/subaccount/delete-apikey")
    Call<JSONObject> deleteSubAccountApikey(@Body JSONObject jsonObject);

    //设置子账户的账户等级  Set the account level of the sub-account
    @POST("/api/v5/broker/dma/set-subaccount-level")
    Call<JSONObject> setSubAccountLevel(@Body JSONObject jsonObject);

    //设置子账户的交易手续费费率  Set trading fee rate for sub-account
     @POST("/api/v5/broker/dma/set-subaccount-fee-rate")
     Call<JSONObject> setSubAccountFeeRate(@Body JSONObject jsonObject);

    //创建子账户充值地址  Create deposit address for sub-account
     @POST("/api/v5/asset/broker/dma/subaccount-deposit-address")
     Call<JSONObject> subAccountDepositAddress(@Body JSONObject jsonObject);

    //查看充值地址  Get sub-account deposit address
     @GET("/api/v5/asset/broker/dma/subaccount-deposit-address")
     Call<JSONObject> getSubAccountDepositAddress(@Query("subAcct") String subAcct,
                                                  @Query("ccy") String ccy);

    //获取子账户充值记录  Get sub-account deposit history
     @GET("/api/v5/asset/broker/dma/subaccount-deposit-history")
     Call<JSONObject> getSubAccountDepositHistory(@Query("subAcct") String subAcct,
                                                  @Query("ccy") String ccy,
                                                  @Query("txId") String txId,
                                                  @Query("type") String type,
                                                  @Query("state") String state,
                                                  @Query("after") String after,
                                                  @Query("before") String before,
                                                  @Query("limit") String limit);

    //子账户返佣记录  Query daily rebate records
     @GET("/api/v5/broker/dma/rebate-daily")
     Call<JSONObject> getRebateDaily(@Query("subAcct") String subAcct,
                                     @Query("begin") String begin,
                                     @Query("end") String end,
                                     @Query("page") String page,
                                     @Query("limit") String limit,
                                     @Query("beginTime") String beginTime,
                                     @Query("endTime") String endTime);

     //获取返佣明细下载链接 Get download link
     @GET("/api/v5/broker/dma/rebate-per-orders")
     Call<JSONObject> rebatePerOrders(@Query("type") String type,
                                     @Query("begin") String begin,
                                     @Query("end") String end,
                                      @Query("brokerType") String brokerType);

     //生成返佣明细下载链接 Create rebate details download link
     @POST("/api/v5/broker/dma/rebate-per-orders")
     Call<JSONObject> setRebatePerOrders(@Body JSONObject jsonObject);


    //获取返佣明细下载链接 Get download link
    @GET("/api/v5/broker/fd/rebate-per-orders")
    Call<JSONObject> rebatePerOrdersfd(@Query("type") String type,
                                     @Query("begin") String begin,
                                     @Query("end") String end);

    //生成返佣明细下载链接 Create rebate details download link
    @POST("/api/v5/broker/fd/rebate-per-orders")
    Call<JSONObject> setRebatePerOrdersfd(@Body JSONObject jsonObject);

    //获取用户的 Broker 返佣信息 Get the user's broker rebate information
    @GET("/api/v5/broker/fd/if-rebate")
    Call<JSONObject> ifRebate(@Query("apiKey") String apiKey,
                              @Query("brokerType") String brokerType);

    //重置子账户充值地址    modify-subaccount-deposit-address
    @POST("/api/v5/asset/broker/dma/modify-subaccount-deposit-address")
    Call<JSONObject> modifySubaccountDepositAddress(@Body JSONObject parseObject);

    @GET("/api/v5/asset/broker/dma/subaccount-withdrawal-history")
    Call<JSONObject> getSubaccountWithdrawalHistory(@Query("subAcct") String subAcct,@Query("ccy")  String ccy,@Query("wdId")  String wdId, @Query("clientId") String clientId, @Query("txId") String txId, @Query("type") String type, @Query("state") String state, @Query("after") String after, @Query("before") String before, @Query("limit") String limit);


    @GET("/api/v5/broker/dma/subaccount-info")
    Call<JSONObject> getSubaccountInfo(@Query("subAcct") String subAcct, @Query("uid") String uid, @Query("page") String page, @Query("limit") String limit);

    @POST("/api/v5/broker/dma/set-subaccount-assets")
    Call<JSONObject> setSubaccountAssets(@Body JSONObject parseObject);


    @POST("/api/v5/broker/dma/report-subaccount-ip")
    Call<JSONObject> reportSubaccIp(@Body JSONObject parseObject);

    @GET("/api/v5/broker/dma/if-rebate")
    Call<JSONObject>  getIfRebate(@Query("apiKey") String apiKey,@Query("subAcct")  String subAcct,@Query("uid")  String uid);

    @POST("/api/v5/broker/dma/activate-credit")
    Call<JSONObject> activateCredit(@Body JSONObject parseObject);

    @GET("/api/v5/broker/dma/credits")
    Call<JSONObject> getCredits(@Query("state")String state,@Query("limit") String limit);
    @GET("/api/v5/broker/dma/subaccount-trade-fee")
    Call<JSONObject> getSubaccountTradeFee(@Query("subAcct")String subAcct, @Query("uid")String uid, @Query("page")String page, @Query("limit")String limit);
}
