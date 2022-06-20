package com.okex.open.api.service.subAccount.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.subAccount.param.*;
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

    //设置子账户主动转出权限 Set Permission Of Transfer Out
    @POST("/api/v5/users/subaccount/set-transfer-out")
    Call<JSONObject> setTransferOut(@Body SetTransferOut setTransferOut);

    //查看被托管的子账户列表 Entrust Subaccount List
    @GET("/api/v5/users/entrust-subaccount-list")
    Call<JSONObject> getEntrustSubList(@Query("subAcct") String subAcct);
}
