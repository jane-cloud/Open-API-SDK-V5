package com.okex.open.api.service.earn;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;

public interface EarnAPIService {

    //查看项目 Get offers
    JSONObject getOffers(String productId,String protocolType,String ccy);

    //申购项目 Purchase
    JSONObject purchase(Purchase purchase);

    //赎回项目 Redeem
    JSONObject redeem(Redeem redeem);

    //撤销项目申购/赎回 Cancel purchases/redemptions
    JSONObject cancel(Cancel cancel);

    //查看活跃订单  Get active orders
    JSONObject getActiveOrders(String productId,String protocolType,String ccy,String state);

    //查看历史订单 Get order history
    JSONObject getHistoryOrders(String productId,String protocolType,String ccy,String after,String before,String limit);
}
