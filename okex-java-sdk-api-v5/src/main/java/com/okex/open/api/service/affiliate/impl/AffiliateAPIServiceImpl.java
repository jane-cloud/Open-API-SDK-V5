package com.okex.open.api.service.affiliate.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.affiliate.AffiliateAPIService;
import com.okex.open.api.service.earn.EarnAPIService;

public class AffiliateAPIServiceImpl implements AffiliateAPIService {

    private APIClient client;
    private AffiliateAPI api;

    public AffiliateAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(AffiliateAPI.class);
    }



    @Override
    public JSONObject getInviteeDetail(String uid) {
        return this.client.executeSync(this.api.getInviteeDetail(uid));
    }

    @Override
    public JSONObject getPartner(String apiKey) {
        return this.client.executeSync(this.api.getPartner(apiKey));
    }
}
