package com.okex.open.api.test.funding;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.funding.param.*;
import com.okex.open.api.service.funding.FundingAPIService;
import com.okex.open.api.service.funding.impl.FundingAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class FundingAPITests extends FundingAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(FundingAPITests.class);

    private FundingAPIService fundingAPIService;


    @Before
    public void before() {
        config = config();
        fundingAPIService = new FundingAPIServiceImpl(config);
    }


    /**
     * 获取币种列表 Get Currencies
     * GET /api/v5/asset/currencies
     */
    @Test
    public void getCurrencies() {
        JSONObject result = fundingAPIService.getCurrencies();
        toResultString(LOG, "result", result);
    }

    /**
     * 获取资金账户余额 Get Balance
     * GET /api/v5/asset/balances
     */
    @Test
    public void getBalance() {
        JSONObject result = fundingAPIService.getBalance("USDT");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取账户资产估值 Get account asset valuation
     * GET /api/v5/asset/asset-valuation
     */
    @Test
    public void assetValuation(){
        JSONObject result = fundingAPIService.assetValuation(null);
        toResultString(LOG,"result",result);
    }


    /**
     * 资金划转 Funds Transfer
     * POST /api/v5/asset/transfer
     */
    @Test
    public void fundsTransfer() {
        FundsTransfer fundsTransfer = new FundsTransfer();
        fundsTransfer.setCcy("USDT");
        fundsTransfer.setAmt("1");
//        fundsTransfer.setType("0");
        fundsTransfer.setFrom("18");
        fundsTransfer.setTo("6");
//        fundsTransfer.setSubAcct("");
        fundsTransfer.setClientId("");
        fundsTransfer.setLoanTrans(false);
        fundsTransfer.setOmitPosRisk("false");
        JSONObject result = fundingAPIService.fundsTransfer(fundsTransfer);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取资金划转状态
     * GET /api/v5/asset/transfer-state
     */
    @Test
    public void transferState() {
        JSONObject result = fundingAPIService.transferState("1234",null,"0");
        toResultString(LOG, "result", result);
    }

    /**
     * 资金流水查询 Asset Bills Details
     * GET /api/v5/asset/bills
     */
    @Test
    public void assetBillsDetails() {
        JSONObject result = fundingAPIService.assetBillsDetails("BTC",null,null,null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取充值地址信息 Get Deposit Address
     * GET /api/v5/asset/deposit-address
     */
    @Test
    public void getDepositAddress() {
        JSONObject result = fundingAPIService.getDepositAddress("EOS");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取充值记录 Get Deposit History
     * GET /api/v5/asset/deposit-history
     */
    @Test
    public void getDepositHistory() {
        JSONObject result = fundingAPIService.getDepositHistory("BTC", "","", "","", "", "","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 提币 withdrawal
     * POST /api/v5/asset/withdrawal
     */
    @Test
    public void Withdrawal() {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setCcy("USDT");
        withdrawal.setChain("");
        withdrawal.setAmt("100");
        withdrawal.setDest("3");
        withdrawal.setToAddr("46674851");
        withdrawal.setFee("1");
        withdrawal.setClientId(null);
        withdrawal.setAreaCode(null);
        JSONObject result = fundingAPIService.Withdrawal(withdrawal);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取提币记录 Get Withdrawal History
     * GET /api/v5/asset/withdrawal-history
     */
    @Test
    public void getWithdrawalHistory() {
        JSONObject result = fundingAPIService.getWithdrawalHistory("USDT", "","","", "", "", "","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取充值/提现的详细状态 Get deposit withdraw status
     * GET /api/v5/asset/deposit-withdraw-status
     */
    @Test
    public void getDepositWithdrawalStatus() {
        JSONObject result = fundingAPIService.getDepositWithdrawalStatus("64407152", null,null,null, null);
        toResultString(LOG, "result", result);
    }

    /**
     * 余币宝申购/赎回 PiggyBank Purchase/Redemption
     * rate 仅适用于申购,申购时必填
     * POST /api/v5/asset/purchase_redempt
     */
    @Test
    public void piggyBankPurchaseRedemption() {
        PiggyBankPurchaseRedemption piggyBankPurchaseRedemption = new PiggyBankPurchaseRedemption();
        piggyBankPurchaseRedemption.setCcy("USDT");
        piggyBankPurchaseRedemption.setAmt("1");
        piggyBankPurchaseRedemption.setSide("purchase");
        piggyBankPurchaseRedemption.setRate("0.02");
        JSONObject result = fundingAPIService.piggyBankPurchaseRedemption(piggyBankPurchaseRedemption);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取余币宝余额 Get PiggyBank Balance
     * GET /api/v5/asset/piggy-balance
     */
    @Test
    public void getPiggyBalance(){
        JSONObject result = fundingAPIService.piggyBalance("USDT");
        toResultString(LOG,"result",result);
    }

    /**
     * 闪电网络充币  Lightning deposits
     * GET /api/v5/asset/deposit-lightning
     */
    @Test
    public void depositLightning() {
        JSONObject result = fundingAPIService.depositLightning("BTC","1","6");
        toResultString(LOG, "result", result);
    }

    /**
     * 闪电网络提币  Lightning withdrawals
     * POST /api/v5/asset/withdrawal-lightning
     */
    @Test
    public void withdrawalLightning() {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setCcy("");
        withdrawal.setInvoice("");
        JSONObject result = fundingAPIService.withdrawalLightning(withdrawal);
        toResultString(LOG, "result", result);
    }

    /**
     * 设置余币宝借贷利率  Set lending rate
     * POST /api/v5/asset/set-lending-rate
     */
    @Test
    public void SetLendingRate() {
        SetLendingRate setLendingRate = new SetLendingRate();
        setLendingRate.setCcy("BTC");
        setLendingRate.setRate("0.03");
        JSONObject result = fundingAPIService.SetLendingRate(setLendingRate);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取余币宝出借明细  Get lending history
     * GET /api/v5/asset/lending-history
     */
    @Test
    public void lendingHistory() {
        JSONObject result = fundingAPIService.lendingHistory(null,null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取市场借贷信息（公共） Get public borrow info (public)
     * GET /api/v5/asset/lending-history
     */
    @Test
    public void lendingRateSummary() {
        JSONObject result = fundingAPIService.lendingRateSummary(null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取市场借贷历史（公共）  Get public borrow history (public)
     * GET /api/v5/asset/lending-history
     */
    @Test
    public void lendingRateHistory() {
        JSONObject result = fundingAPIService.lendingRateHistory(null,null,null,null);
        toResultString(LOG, "result", result);
    }


    /**
     * 小额资产兑换 convert-dust-assets
     * POST /api/v5/asset/convert-dust-assets
     */
    @Test
    public void convertDustAssets() {
        ConvertDustAssets convertDustAssets = new ConvertDustAssets();
        ArrayList<String> list = new  ArrayList<String>();
        list.add("OKB");
        convertDustAssets.setCcy(list);
        JSONObject result = fundingAPIService.convertDustAssets(convertDustAssets);
        toResultString(LOG, "result", result);
    }

    /**
     * 撤销提币 cancel-withdrawal
     * POST /api/v5/asset/cancel-withdrawal
     */
    @Test
    public void cancelWithdrawal() {
        Withdrawal cancelWithdrawal = new Withdrawal();
        cancelWithdrawal.setWdId("");
        JSONObject result = fundingAPIService.cancelWithdrawal(cancelWithdrawal);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取不可交易资产 Get non-tradable-assets
     * GET /api/v5/asset/non-tradable-assets
     */
    @Test
    public void getNonTradableAssets(){
        JSONObject result = fundingAPIService.getNonTradableAssets("USDT");
        toResultString(LOG,"result",result);
    }

    /**
     * 获取交易所列表 Get exchange-list
     * GET /api/v5/asset/exchange-list
     */
    @Test
    public void getExchangeList(){
        JSONObject result = fundingAPIService.getExchangeList();
        toResultString(LOG,"result",result);
    }

}




