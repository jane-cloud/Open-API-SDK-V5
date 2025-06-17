package com.okex.open.api.test.finance;


import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.bean.finance.param.AmendFinance;
import com.okex.open.api.bean.finance.param.Finance;
import com.okex.open.api.bean.finance.param.SupCollateral;
import com.okex.open.api.bean.trade.param.ClosePositions;
import com.okex.open.api.service.finance.FinanceAPIService;
import com.okex.open.api.service.finance.impl.FinanceAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

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
//        amendFinance.setAutoRenewal("");
//        amendFinance.setRate("");
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
    //活期借币
    /**
     * GET /  可借币种列表 Get borrow-currencies
     * GET /api/v5/finance/flexible-loan/borrow-currencies
     */
    @Test
    public void getBorrowCurrencies(){
        JSONObject result = financeAPIService.getBorrowCurrencies();
        toResultString(LOG, "result", result);

    }
    /**
     * GET /  可抵押资产 Get collateral-assets
     * GET /api/v5/finance/flexible-loan/collateral-assets
     */
    @Test
    public void getCollateralAssets(){
        JSONObject result = financeAPIService.getCollateralAssets("");
        toResultString(LOG, "result", result);

    }
    /**
     * POST / 最大可借 Get max-loan
     * POST /api/v5/finance/flexible-loan/max-loan
     */
    @Test
    public void getMaxLoan(){
        Finance finance =  new Finance();
        finance.setBorrowCcy("");
        ArrayList<SupCollateral> list = new ArrayList<>();
        SupCollateral supCollateral = new SupCollateral();
        supCollateral.setAmt("");
        supCollateral.setCcy("");
        list.add(supCollateral);
        finance.setSupCollateral(list);
        JSONObject result = financeAPIService.getMaxLoan(finance);

        toResultString(LOG, "result", result);

    }
    /**
     * GET /  抵押物最大可赎回数量 max-collateral-redeem-amount
     * GET /api/v5/finance/flexible-loan/max-collateral-redeem-amount
     */
    @Test
    public void getMaxCollateralRedeemAmount(){
        JSONObject result = financeAPIService.getMaxCollateralRedeemAmount("");
        toResultString(LOG, "result", result);

    }
    /**
     * POST / 调整抵押物 adjust-collateral
     * POST /api/v5/finance/flexible-loan/adjust-collateral
     */
    @Test
    public void adjustCollateral(){
        Finance finance =  new Finance();
        finance.setType("");
        finance.setCollateralAmt("");
        finance.setCollateralCcy("");
        JSONObject result = financeAPIService.adjustCollateral(finance);

        toResultString(LOG, "result", result);

    }
    /**
     * GET /  借贷信息loan-info
     * GET /api/v5/finance/flexible-loan/loan-info
     */
    @Test
    public void getLoanInfo(){
        JSONObject result = financeAPIService.getLoanInfo();
        toResultString(LOG, "result", result);

    }

    /**
     * GET /  借贷历史loan-history
     * GET /api/v5/finance/flexible-loan/loan-history
     */
    @Test
    public void getLoanHistory(){
        JSONObject result = financeAPIService.getLoanHistory("","","","");
        toResultString(LOG, "result", result);

    }
    /**
     * GET /  计息记录interest-accrued
     * GET /api/v5/finance/flexible-loan/interest-accrued
     */
    @Test
    public void getInterestAccrued(){
        JSONObject result = financeAPIService.getInterestAccrued("","","","");
        toResultString(LOG, "result", result);

    }
    //SOL质押
    /**
     * GET / 获取产品信息
     * GET /api/v5/finance/staking-defi/sol/product-info
     */
    @Test
    public void getProductInfo(){

        JSONObject result = this.financeAPIService.getProductInfo("","");
        toResultString(LOG, "result", result);
    }
    /**
     * 申购 Purchase
     * POST /api/v5/finance/staking-defi/sol/purchase
     */
    @Test
    public void solPurchase(){
        Purchase purchase = new Purchase();
        purchase.setAmt("");

        JSONObject result = this.financeAPIService.solPurchase(purchase);
        toResultString(LOG, "result", result);
    }

    /**
     * 赎回 redeem
     * POST /api/v5/finance/staking-defi/sol/redeem
     */
    @Test
    public void solRedeem(){
        Redeem redeem = new Redeem();
        redeem.setAmt("");
        JSONObject result = this.financeAPIService.solRedeem(redeem);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取余额 balance
     * GET  /api/v5/finance/staking-defi/sol/balance
     */
    @Test
    public void getBalance(){

        JSONObject result = this.financeAPIService.getBalance("","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取申购赎回记录 purchase-redeem-history
     * GET //api/v5/finance/staking-defi/sol/purchase-redeem-history
     */
    @Test
    public void getPurchaseRedeemHistory(){

        JSONObject result = this.financeAPIService.getPurchaseRedeemHistory("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取历史收益率(公共) apy-history
     * GET/api/v5/finance/staking-defi/sol/apy-history
     */
    @Test
    public void getApyHistory(){

        JSONObject result = this.financeAPIService.getApyHistory("");
        toResultString(LOG, "result", result);
    }

}
