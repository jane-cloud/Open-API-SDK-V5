package com.okex.open.api.test.announcements;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.announcements.impl.AnnouncementsAPIService;
import com.okex.open.api.service.announcements.impl.AnnouncementsAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class AnnouncementsAPITests extends AnnouncementsAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(AnnouncementsAPITests.class);

    private AnnouncementsAPIService announcementsAPIService;


    @Before
    public void before() {
        config = config();
        announcementsAPIService = new AnnouncementsAPIServiceImpl(config);
    }


    /**
     * 公告 Get announcements
     * GET /api/v5/support/announcements
     */
    @Test
    public void getAnnouncements() {
        JSONObject result = announcementsAPIService.getAnnouncements("","");
        toResultString(LOG, "result", result);
    }
    /**
     * 公告类型 Get announcement-types
     * GET /api/v5/support/announcement-types
     */
    @Test
    public void getAnnouncementsType() {
        JSONObject result = announcementsAPIService.getAnnouncementsType();
        toResultString(LOG, "result", result);
    }


}




