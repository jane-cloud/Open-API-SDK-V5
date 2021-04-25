package com.okex.open.api.test.funding;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.funding.param.FundsTransfer;
import com.okex.open.api.bean.funding.param.PiggyBankPurchaseRedemption;
import com.okex.open.api.bean.funding.param.Withdrawal;
import com.okex.open.api.service.funding.FundingAPIService;
import com.okex.open.api.service.funding.impl.FundingAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FundingAPITests extends FundingAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(FundingAPITests.class);

    private FundingAPIService fundingAPIService;


    @Before
    public void before() {
        config = config();
        fundingAPIService = new FundingAPIServiceImpl(config);
    }


    /**
     * 获取充值地址信息 Get Deposit Address
     * GET /api/v5/asset/deposit-address
     */
    @Test
    public void getDepositAddress() {
        JSONObject result = fundingAPIService.getDepositAddress("BTC");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取资金账户余额信息 Get Balance
     * GET /api/v5/asset/balances
     */
    @Test
    public void getBalance() {
        JSONObject result = fundingAPIService.getBalance("USDT");
        toResultString(LOG, "result", result);
    }

    /**
     * 资金划转 Funds Transfer
     * POST /api/v5/asset/transfer
     */
    @Test
    public void fundsTransfer() {
        FundsTransfer fundsTransfer = new FundsTransfer();
        fundsTransfer.setCcy("EOS");
        fundsTransfer.setAmt("2");
        fundsTransfer.setType("0");
        fundsTransfer.setFrom("9");
        fundsTransfer.setTo("3");
//        fundsTransfer.setSubAcct("");
        fundsTransfer.setInstId("EOS-USD");
        fundsTransfer.setToInstId("EOS-USD");
        JSONObject result = fundingAPIService.fundsTransfer(fundsTransfer);
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
        withdrawal.setAmt("100");
        withdrawal.setDest("3");
        withdrawal.setToAddr("46674851");
        withdrawal.setPwd("888888");
        withdrawal.setFee("1");
        JSONObject result = fundingAPIService.Withdrawal(withdrawal);
        toResultString(LOG, "result", result);
    }


    /**
     * 充值记录 Get Deposit History
     * GET /api/v5/asset/deposit-history
     */
    @Test
    public void getDepositHistory() {
        JSONObject result = fundingAPIService.getDepositHistory("BTC", "", "", "", "");
        toResultString(LOG, "result", result);
    }


    /**
     * 提币记录 Get Withdrawal History
     * GET /api/v5/asset/withdrawal-history
     */
    @Test
    public void getWithdrawalHistory() {
        JSONObject result = fundingAPIService.getWithdrawalHistory("BTC", "", "", "", "");
        toResultString(LOG, "result", result);
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
     * 余币宝申购/赎回 PiggyBank Purchase/Redemption
     * POST /api/v5/asset/purchase_redempt
     */
    @Test
    public void piggyBankPurchaseRedemption() {
        PiggyBankPurchaseRedemption piggyBankPurchaseRedemption = new PiggyBankPurchaseRedemption();
        piggyBankPurchaseRedemption.setCcy("USDT");
        piggyBankPurchaseRedemption.setAmt("1");
        piggyBankPurchaseRedemption.setSide("purchase");
        JSONObject result = fundingAPIService.piggyBankPurchaseRedemption(piggyBankPurchaseRedemption);
        toResultString(LOG, "result", result);
    }


    /**
     * 资金流水查询 Asset Bills Details
     * GET /api/v5/asset/bills
     */
    @Test
    public void assetBillsDetails() {
        JSONObject result = fundingAPIService.assetBillsDetails("BTC",null,null,null,null);
        toResultString(LOG, "result", result);
    }




}




