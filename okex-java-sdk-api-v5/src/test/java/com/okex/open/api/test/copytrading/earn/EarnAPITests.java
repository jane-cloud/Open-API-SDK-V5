package com.okex.open.api.test.copytrading.earn;


import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.InvestData;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.service.earn.EarnAPIService;
import com.okex.open.api.service.earn.impl.EarnAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class EarnAPITests extends EarnAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(EarnAPITests.class);

    private EarnAPIService earnAPIService;



    @Before
    public void before() {
        this.config = this.config();
        this.earnAPIService = new EarnAPIServiceImpl(this.config);
    }

    /**
     * 查看项目 Get offers
     * GET /api/v5/finance/staking-defi/offers
     */
    @Test
    public void getOffers(){
        JSONObject result = this.earnAPIService.getOffers(null,null,"USDT");

        toResultString(LOG, "result", result);

    }

    /**
     * 申购项目 Purchase
     * POST /api/v5/finance/staking-defi/purchase
     */
    @Test
    public void purchase(){
        Purchase purchase = new Purchase();
        List<InvestData> invest = new ArrayList<InvestData>();
        InvestData investData = new InvestData();
        investData.setCcy("USDT");
        investData.setAmt("90");

        invest.add(investData);

        purchase.setProductId("1456");
        purchase.setTag("123456");
        purchase.setInvestData(invest);
//        purchase.setTerm("90");
        JSONObject result = this.earnAPIService.purchase(purchase);
        toResultString(LOG, "result", result);
    }

    /**
     * 赎回项目 Redeem
     * POST /api/v5/finance/staking-defi/redeem
     */
    @Test
    public void redeem(){
        Redeem redeem = new Redeem();
        redeem.setAllowEarlyRedeem(null);
        redeem.setOrdId("1883808");
        redeem.setProtocolType("defi");

        JSONObject result = this.earnAPIService.redeem(redeem);
        toResultString(LOG, "result", result);

    }

    /**
     * 撤销项目申购/赎回 Cancel multiple orders
     * POST /api/v5/finance/staking-defi/cancel
     */
    @Test
    public void cancel(){
        Cancel cancel = new Cancel();
        cancel.setOrdId("1883808");
        cancel.setProtocolType("staking");

        JSONObject result = this.earnAPIService.cancel(cancel);
        toResultString(LOG, "result", result);
    }

    /**
     * 查看活跃订单  Get active orders
     * GET /api/v5/finance/staking-defi/orders-active
     */
    @Test
    public void getActiveOrders(){
        JSONObject result = this.earnAPIService.getActiveOrders("","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 查看历史订单 Get order history
     * GET /api/v5/finance/staking-defi/orders-history
     */
    @Test
    public void getHistoryOrders(){
        JSONObject result = this.earnAPIService.getHistoryOrders("","","","","","");
        toResultString(LOG, "result", result);
    }



}
