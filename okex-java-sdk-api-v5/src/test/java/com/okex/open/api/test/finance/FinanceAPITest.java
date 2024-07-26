package com.okex.open.api.test.finance;


import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.finance.param.AmendFinance;
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
    //活期简单赚币
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

    //定期简单赚币
    /**
     * GET / 获取借币信息（公共） Get lending-offers
     * GET /api/v5/finance/fixed-loan/lending-offers
     */
    @Test
    public void getLendingOffers(){
        JSONObject result = financeAPIService.getLendingOffers("","");
        toResultString(LOG, "result", result);

    }
    /**
     * GET /  获取历史收益率（公共） Get lending-apy-history
     * GET /api/v5/finance/fixed-loan/lending-apy-history
     */
    @Test
    public void getLendingApyHistory(){
        JSONObject result = financeAPIService.getLendingApyHistory("","");
        toResultString(LOG, "result", result);

    }
    /**
     * GET /  获取借贷量（公共） Get pending-lending-volume
     * GET /api/v5/finance/fixed-loan/pending-lending-volume
     */
    @Test
    public void getPendingLendingVolume(){
        JSONObject result = financeAPIService.getPendingLendingVolume("","");
        toResultString(LOG, "result", result);

    }

    /**
     * POST / 定期简单赚币申购 Get lending-order
     * POST /api/v5/finance/fixed-loan/lending-order
     */
    @Test
    public void lendingOrder(){
        Finance finance =  new Finance();
        finance.setCcy("");
        finance.setRate("");
        finance.setAmt("");
        finance.setTerm("");
        finance.setAutoRenewal("");
        JSONObject result = financeAPIService.lendingOrder(finance);

        toResultString(LOG, "result", result);

    }

    /**
     * POST / 定期简单赚币修改订单 Get amend-lending-order
     * POST /api/v5/finance/fixed-loan/amend-lending-order
     */
    @Test
    public void amendLendingOrder(){
        AmendFinance amendFinance =  new AmendFinance();
        amendFinance.setOrdId("");
        amendFinance.setAutoRenewal("");
        amendFinance.setRate("");
        amendFinance.setChangeAmt("");
        JSONObject result = financeAPIService.amendLendingOrder(amendFinance);

        toResultString(LOG, "result", result);

    }
    /**
     * GET /  获取定期简单赚币订单信息 Get lending-orders-list
     * GET /api/v5/finance/fixed-loan/lending-orders-list
     */
    @Test
    public void getLendingOrdersList(){
        JSONObject result = financeAPIService.getLendingOrdersList("","","","","","");
        toResultString(LOG, "result", result);

    }
    /**
     * GET /  获取定期简单赚币子订单信息 Get lending-sub-orders
     * GET /api/v5/finance/fixed-loan/lending-sub-orders
     */
    @Test
    public void getLendingSubOrders(){
        JSONObject result = financeAPIService.getLendingSubOrders("","","","","");
        toResultString(LOG, "result", result);

    }
}
