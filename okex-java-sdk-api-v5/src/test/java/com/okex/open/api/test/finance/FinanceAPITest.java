package com.okex.open.api.test.finance;


import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.finance.param.Finance;
import com.okex.open.api.bean.trade.param.ClosePositions;
import com.okex.open.api.service.finance.FinanceAPIService;
import com.okex.open.api.service.finance.impl.FinanceAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinanceAPITest extends FinanceAPIBaseTests {
    private static final Logger LOG = LoggerFactory.getLogger(FinanceAPITest.class);

    private FinanceAPIService financeAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.financeAPIService = new FinanceAPIServiceImpl(this.config);
    }
    /**
     * 获取余币宝余额 Get finance balance
     * GET /api/v5/finance/savings/balance
     */
    @Test
    public void getFinanceBalance(){
        JSONObject result = financeAPIService.getFinanceBalance("USDT");
        toResultString(LOG, "result", result);

    }
    /**
     * 余币宝申购/赎回 purchase-redempt
     * POST /api/v5/finance/savings/purchase-redempt
     */
    @Test
    public void PurchaseRedempt(){

        Finance finance =  new Finance();
        finance.setCcy("");
        finance.setAmt("");
        finance.setSide("");
        finance.setRate("");
        JSONObject result = financeAPIService.PurchaseRedempt(finance);

        toResultString(LOG, "result", result);

    }
    /**
     * 设置余币宝借贷利率 set-lending-rate
     * POST /api/v5/finance/savings/set-lending-rate
     */
    @Test
    public void setLendingRate(){

        Finance finance =  new Finance();
        finance.setCcy("");
        finance.setRate("");
        JSONObject result = financeAPIService.setLendingRate(finance);

        toResultString(LOG, "result", result);

    }
    /**
     * 获取余币宝出借明细 Get lending-history
     * GET /api/v5/finance/savings/lending-history
     */
    @Test
    public void getLendingHistory(){
        JSONObject result = financeAPIService.getLendingHistory("","","","");
        toResultString(LOG, "result", result);

    }
    /**
     * 获取市场借贷信息（公共） Get lending-rate-summary
     * GET /api/v5/finance/savings/lending-rate-summary
     */
    @Test
    public void getLendingRateSummary(){
        JSONObject result = financeAPIService.getLendingRateSummary("");
        toResultString(LOG, "result", result);

    }
    /**
     * 获取市场借贷历史（公共） Get lending-rate-history
     * GET /api/v5/finance/savings/lending-rate-history
     */
    @Test
    public void getLendingRateHistory(){
        JSONObject result = financeAPIService.getLendingRateHistory("","","","");
        toResultString(LOG, "result", result);

    }
}
