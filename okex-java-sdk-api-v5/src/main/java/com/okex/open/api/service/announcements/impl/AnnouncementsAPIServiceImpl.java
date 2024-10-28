package com.okex.open.api.service.announcements.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;

public class AnnouncementsAPIServiceImpl implements AnnouncementsAPIService {

    private APIClient client;
    private AnnouncementsAPI api;

    public AnnouncementsAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(AnnouncementsAPI.class);
    }


    @Override
    public JSONObject getAnnouncements(String annType, String page) {

            return this.client.executeSync(this.api.getAnnouncements(annType, page));

    }

    @Override
    public JSONObject getAnnouncementsType() {
        return this.client.executeSync(this.api.getAnnouncementsType());
    }
}
