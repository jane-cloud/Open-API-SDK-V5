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

    //母账户查询子账户的交易账户详细资产余额（适用于母账户） Query detailed balance info of Trading Account of a sub-account via the master account (applies to master accounts only)
    @GET("/api/v5/account/subaccount/balances")
    Call<JSONObject> getSubAccountBalances(@Query("subAcct") String subAcct);

    //子账户转账记录（仅适用于母账户） View sub-account list(applies to master accounts only)
    @GET("/api/v5/asset/subaccount/bills")
    Call<JSONObject> getSubAccountBills(@Query("ccy") String ccy,
                                           @Query("type") String type,
                                           @Query("subAcct") String subAcct,
                                           @Query("after") String after,
                                           @Query("before") String before,
                                           @Query("limit") String limit);

    //删除子账户的APIkey（仅适用于母账户） Delete the APIkey of sub-accounts (applies to master accounts only)
    @POST("/api/v5/users/subaccount/delete-apikey")
    Call<JSONObject> delSubAccountAPIKey(@Body DelSunAccountApikey delSunAccountApikey);

    //重置子账户的APIkey（仅适用于母账户） Reset the APIkey of a sub-account(applies to master accounts only)
    @POST("/api/v5/users/subaccount/modify-apikey")
    Call<JSONObject> reSetSubAccountAPIKey(@Body ReSetSubAccountApikey reSetSubAccountApikey);

    //创建子账户的APIkey（仅适用于母账户）Create an APIkey for a sub-account(applies to master accounts only)
    @POST("/api/v5/users/subaccount/apikey")
    Call<JSONObject> createSubAccountAPIKey(@Body CreateSubAccountApikey createSubAccountApikey);

    //查看子账户列表（仅适用于母账户） View sub-account list(applies to master accounts only)
    @GET("/api/v5/users/subaccount/list")
    Call<JSONObject> getSubAccountList(@Query("enable") String enable,
                                       @Query("subAcct") String subAcct,
                                       @Query("after") String after,
                                       @Query("before") String before,
                                       @Query("limit") String limit);

    //母账户控制子账户与子账户之间划转（仅适用于母账户） Master accounts manage the transfers between sub-accounts(applies to master accounts only)
    @POST("/api/v5/asset/subaccount/transfer")
    Call<JSONObject> subAccountTransfer(@Body SubAccountTransfer subAccountTransfer);








}
