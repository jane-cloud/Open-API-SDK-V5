package com.okex.open.api.service.affiliate;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;

public interface AffiliateAPIService {


    JSONObject getInviteeDetail(String uid);

    JSONObject getPartner(String apiKey);
}
