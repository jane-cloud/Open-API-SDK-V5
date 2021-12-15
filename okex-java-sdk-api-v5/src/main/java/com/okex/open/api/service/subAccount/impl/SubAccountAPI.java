package com.okex.open.api.service.subAccount.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.subAccount.param.CreateSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.DelSunAccountApikey;
import com.okex.open.api.bean.subAccount.param.ReSetSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.SubAccountTransfer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SubAccountAPI {

    //查看子账户列表 View sub-account list
    @GET("/api/v5/users/subaccount/list")
    Call<JSONObject> getSubAccountList(@Query("enable") String enable,
                                       @Query("subAcct") String subAcct,
                                       @Query("after") String after,
                                       @Query("before") String before,
                                       @Query("limit") String limit);

    //创建子账户的APIkey Create an APIkey for a sub-account
    @POST("/api/v5/users/subaccount/apikey")
    Call<JSONObject> createSubAccountAPIKey(@Body CreateSubAccountApikey createSubAccountApikey);

    //查询子账户的APIKey  Query the APIKey of a sub-account
    @GET("/api/v5/users/subaccount/apikey")
    Call<JSONObject> getSubAccountApikeyList(@Query("subAcct") String subAcct, @Query("apiKey") String apiKey);

    //重置子账户的APIkey Reset the APIkey of a sub-account
    @POST("/api/v5/users/subaccount/modify-apikey")
    Call<JSONObject> reSetSubAccountAPIKey(@Body ReSetSubAccountApikey reSetSubAccountApikey);

    //删除子账户的APIkey Delete the APIkey of sub-accounts
    @POST("/api/v5/users/subaccount/delete-apikey")
    Call<JSONObject> delSubAccountAPIKey(@Body DelSunAccountApikey delSunAccountApikey);



    //获取子账户资产余额 Get Sub-account Balance
    @GET("/api/v5/account/subaccount/balances")
    Call<JSONObject> getSubAccountBalances(@Query("subAcct") String subAcct);

    //查询子账户转账记录 History of sub-account transfer
    @GET("/api/v5/asset/subaccount/bills")
    Call<JSONObject> getSubAccountBills(@Query("ccy") String ccy,
                                           @Query("type") String type,
                                           @Query("subAcct") String subAcct,
                                           @Query("after") String after,
                                           @Query("before") String before,
                                           @Query("limit") String limit);

    //子账户间资金划转 Master accounts manage the transfers between sub-accounts
    @POST("/api/v5/asset/subaccount/transfer")
    Call<JSONObject> subAccountTransfer(@Body SubAccountTransfer subAccountTransfer);








}
