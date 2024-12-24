package com.okex.open.api.service.ETHPledge;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;

public interface ETHPledgeAPIService {


    JSONObject ethPurchase(Purchase purchase);

    JSONObject ethRedeem(Redeem redeem);

    JSONObject getBalance(String ccy, String amt, String latestInterestAccrual, String totalInterestAccrual, String ts);

    JSONObject getPurchaseRedeemHistory(String type, String status, String after, String before, String limit);

    JSONObject getApyHistory(String days);

    JSONObject getProductInfo();
}
