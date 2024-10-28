package com.okex.open.api.service.announcements.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

 interface AnnouncementsAPI {
    @GET("/api/v5/support/announcements")
    Call<JSONObject> getAnnouncements(@Query("annType") String annType,@Query("page") String page);

     @GET("/api/v5/support/announcement-types")
     Call<JSONObject> getAnnouncementsType();
 }
