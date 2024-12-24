package com.okex.open.api.test.ETHPledge;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.service.ETHPledge.ETHPledgeAPIService;
import com.okex.open.api.service.ETHPledge.impl.ETHPledgeAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ETHPledgeAPITests extends  ETHPledgeAPIBaseTests {
    private static final Logger LOG = LoggerFactory.getLogger(ETHPledgeAPITests.class);

    private ETHPledgeAPIService ETHPledgeAPI;



    @Before
    public void before() {
        this.config = this.config();
        this.ETHPledgeAPI = new ETHPledgeAPIServiceImpl(this.config);
    }
    /**
     * 申购 Purchase
     * POST /api/v5/finance/staking-defi/eth/purchase
     */
    @Test
    public void ethPurchase(){
        Purchase purchase = new Purchase();
        purchase.setAmt("");

        JSONObject result = this.ETHPledgeAPI.ethPurchase(purchase);
        toResultString(LOG, "result", result);
    }

    /**
     * 赎回 redeem
     * POST /api/v5/finance/staking-defi/eth/redeem
     */
    @Test
    public void ethRedeem(){
        Redeem redeem = new Redeem();
        redeem.setAmt("");
        JSONObject result = this.ETHPledgeAPI.ethRedeem(redeem);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取余额 balance
     * GET /api/v5/finance/staking-defi/eth/balance
     */
    @Test
    public void getBalance(){

        JSONObject result = this.ETHPledgeAPI.getBalance("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取申购赎回记录 purchase-redeem-history
     * GET /api/v5/finance/staking-defi/eth/purchase-redeem-history
     */
    @Test
    public void getPurchaseRedeemHistory(){

        JSONObject result = this.ETHPledgeAPI.getPurchaseRedeemHistory("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取历史收益率(公共) apy-history
     * GET /api/v5/finance/staking-defi/eth/apy-history
     */
    @Test
    public void getApyHistory(){

        JSONObject result = this.ETHPledgeAPI.getApyHistory("");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取产品信息 product-info
     * GET /api/v5/finance/staking-defi/eth/product-info
     */
    @Test
    public void getProductInfo(){

        JSONObject result = this.ETHPledgeAPI.getProductInfo();
        toResultString(LOG, "result", result);
    }
}
