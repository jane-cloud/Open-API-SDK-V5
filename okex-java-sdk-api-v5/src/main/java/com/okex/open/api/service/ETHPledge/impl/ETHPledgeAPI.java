package com.okex.open.api.service.ETHPledge.impl;


import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ETHPledgeAPI {


    @POST("/api/v5/finance/staking-defi/eth/purchase")
    Call<JSONObject> ethPurchase(@Body JSONObject parseObject);

    @POST("/api/v5/finance/staking-defi/eth/redeem")
    Call<JSONObject>  ethRedeem(@Body JSONObject parseObject);

    @GET("/api/v5/finance/staking-defi/eth/balance")
    Call<JSONObject> getBalance(@Query("ccy")String ccy,@Query("amt") String amt,@Query("latestInterestAccrual") String latestInterestAccrual,@Query("totalInterestAccrual") String totalInterestAccrual,@Query("ts") String ts);

    @GET("/api/v5/finance/staking-defi/eth/purchase-redeem-history")
    Call<JSONObject> getPurchaseRedeemHistory(@Query("type")String type,@Query("status") String status,@Query("after") String after,@Query("before") String before,@Query("limit") String limit);

    @GET("/api/v5/finance/staking-defi/eth/apy-history")
    Call<JSONObject> getApyHistory(@Query("days")String days);

    @GET("/api/v5/finance/staking-defi/eth/product-info")
    Call<JSONObject> getProductInfo();
}
