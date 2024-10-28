package com.okex.open.api.service.announcements.impl;

import com.alibaba.fastjson.JSONObject;

 public interface AnnouncementsAPIService {
       JSONObject getAnnouncements(String annType, String page) ;

     JSONObject getAnnouncementsType();
 }
