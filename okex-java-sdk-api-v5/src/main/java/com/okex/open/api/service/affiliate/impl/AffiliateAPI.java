package com.okex.open.api.service.affiliate.impl;


import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AffiliateAPI {



    @GET("/api/v5/affiliate/invitee/detail")
    Call<JSONObject> getInviteeDetail(@Query("uid")String uid);

    @GET("/api/v5/users/partner/if-rebate")
    Call<JSONObject> getPartner(@Query("apiKey")String apiKey);
}
