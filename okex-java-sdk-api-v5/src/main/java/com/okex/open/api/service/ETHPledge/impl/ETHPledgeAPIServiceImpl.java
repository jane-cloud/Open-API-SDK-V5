package com.okex.open.api.service.ETHPledge.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.ETHPledge.ETHPledgeAPIService;
import com.okex.open.api.service.earn.EarnAPIService;

public class ETHPledgeAPIServiceImpl implements ETHPledgeAPIService {

    private APIClient client;
    private ETHPledgeAPI api;

    public ETHPledgeAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(ETHPledgeAPI.class);
    }



    //申购 Purchase
    @Override
    public JSONObject ethPurchase(Purchase purchase) {
        return this.client.executeSync(this.api.ethPurchase(JSONObject.parseObject(JSON.toJSONString(purchase))));
    }
//赎回
    @Override
    public JSONObject ethRedeem(Redeem redeem) {
        return this.client.executeSync(this.api.ethRedeem(JSONObject.parseObject(JSON.toJSONString(redeem))));
    }
//获取余额
    @Override
    public JSONObject getBalance(String ccy, String amt, String latestInterestAccrual, String totalInterestAccrual, String ts) {
        return this.client.executeSync(this.api.getBalance( ccy,  amt,  latestInterestAccrual,  totalInterestAccrual,  ts));
    }
//获取申购赎回记录
    @Override
    public JSONObject getPurchaseRedeemHistory(String type, String status, String after, String before, String limit) {
        return this.client.executeSync(this.api.getPurchaseRedeemHistory( type,  status,  after,  before,  limit));
    }

    @Override
    public JSONObject getApyHistory(String days) {
        return this.client.executeSync(this.api.getApyHistory( days));
    }

    @Override
    public JSONObject getProductInfo() {
        return this.client.executeSync(this.api.getProductInfo());
    }

}
