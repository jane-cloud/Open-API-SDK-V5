package com.okex.open.api.test.account;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.*;
import com.okex.open.api.service.account.AccountAPIService;
import com.okex.open.api.service.account.impl.AccountAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountAPITests extends  AccountAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(AccountAPITests.class);

    private AccountAPIService accountAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.accountAPIService = new AccountAPIServiceImpl(this.config);
    }

    /**
     * 查看账户持仓风险 Get account and position risk
     * GET /api/v5/account/account-position-risk
     */
    @Test
    public void getAccountAndPosition(){
        JSONObject result = this.accountAPIService.getAccountAndPosition("SWAP");
        toResultString(LOG, "result", result);
    }


    /**
     * 查看账户余额 Get Balance
     * GET /api/v5/account/balance
     */
    @Test
    public void getBalance(){
        JSONObject result = this.accountAPIService.getBalance("USDT");
        toResultString(LOG, "result", result);
    }


    /**
     * 查看持仓信息 Get Positions
     * GET /api/v5/account/positions
     */
    @Test
    public void getPositions(){
        JSONObject result = this.accountAPIService.getPositions("MARGIN",null,null);
        toResultString(LOG, "result", result);
    }


    /**
     * 账单流水查询（近七天） Get Bills Details (last 7 days)
     * GET /api/v5/account/bills
     */
    @Test
    public void getBillsDetails7Days(){
        JSONObject result = this.accountAPIService.getBillsDetails7Days("FUTERES","","","","","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 账单流水查询（近三个月） Get Bills Details (last 3 months)
     * GET /api/v5/account/bills-archive
     */
    @Test
    public void getBillsDetails3Months(){
        JSONObject result = this.accountAPIService.getBillsDetails3Months("SWAP",null,null,null,"8",null,null,null,null);
        toResultString(LOG, "result", result);
    }


    /**
     * 查看账户配置 Get Account Configuration
     * GET /api/v5/account/config
     */
    @Test
    public void getAccountConfiguration(){
        JSONObject result = this.accountAPIService.getAccountConfiguration();
        toResultString(LOG, "result", result);
    }


    /**
     * 设置持仓模式 Set Position mode
     * POST  /api/v5/account/set-position-mode
     */
    @Test
    public void setPositionMode(){
        SetPositionMode setPositionMode=new SetPositionMode();
        setPositionMode.setPosMode("long_short_mode");
        JSONObject result = this.accountAPIService.setPositionMode(setPositionMode);
        toResultString(LOG, "result", result);
    }


    /**
     * 设置杠杆倍数 Set Leverage
     * POST /api/v5/account/set-leverage
     */
    @Test
    public void setLeverage(){
        SetLeverage setLeverage=new SetLeverage();
        setLeverage.setInstId("BTC-USDT-SWAP");
//        setLeverage.setCcy("");
        setLeverage.setLever("13.3");
        setLeverage.setMgnMode("cross");
        setLeverage.setPosSide("net");

        JSONObject result = this.accountAPIService.setLeverage(setLeverage);
        toResultString(LOG, "result", result);
    }


    /**
     * 获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount
     * GET /api/v5/account/max-size
     */
    @Test
    public void getMaximumTradableSizeForInstrument(){
        JSONObject result = this.accountAPIService.getMaximumTradableSizeForInstrument("BTC-USDT","cross","BTC","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取最大可用数量  Get Maximum Available Tradable Amount
     * GET /api/v5/account/max-avail-size
     */
    @Test
    public void getMaximumAvailableTradableAmount(){
        JSONObject result = this.accountAPIService.getMaximumAvailableTradableAmount("BTC-USDT-210924","isolated","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 调整保证金  Increase/Decrease margin
     * POST /api/v5/account/position/margin-balance
     */
    @Test
    public void increaseDecreaseMargin(){
        IncreaseDecreaseMargin increaseDecreaseMargin = new IncreaseDecreaseMargin();

        increaseDecreaseMargin.setInstId("BTC-USDT-210924");
        increaseDecreaseMargin.setPosSide("long");
        increaseDecreaseMargin.setType("add");
        increaseDecreaseMargin.setAmt("100");

        JSONObject result = this.accountAPIService.increaseDecreaseMargin(increaseDecreaseMargin);
        toResultString(LOG, "result", result);
    }



    /**
     * 获取杠杆倍数  Get Leverage
     * GET /api/v5/account/leverage-info
     */
    @Test
    public void getLeverage(){
        JSONObject result = this.accountAPIService.getLeverage("BTC-USDT-210924","cross");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取交易产品最大可借  Get the maximum loan of instrument
     * GET /api/v5/account/max-loan
     */
    @Test
    public void getTheMaximumLoanOfIsolatedMARGIN(){
        JSONObject result = this.accountAPIService.getTheMaximumLoanOfIsolatedMARGIN("BTC-USDT","cross","BTC");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取当前账户交易手续费费率  Get Fee Rates
     * GET /api/v5/account/trade-fee
     */
    @Test
    public void getFeeRates(){
        JSONObject result = this.accountAPIService.getFeeRates("SWAP",null,"BTC-USDT",null);
        toResultString(LOG, "result", result);
    }


    /**
     * 获取计息记录  Get interest-accrued
     * GET /api/v5/account/interest-accrued
     */
    @Test
    public void getInterestAccrued(){
        JSONObject result = this.accountAPIService.getInterestAccrued("BTC-USDT","USDT","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取用户当前杠杆借币利率  Get interest rate
     * GET /api/v5/account/interest-rate
     */
    @Test
    public void getInterestRate(){
        JSONObject result = this.accountAPIService.getInterestRate("USDT");
        toResultString(LOG, "result", result);
    }



    /**
     * 期权希腊字母PA/BS切换  Set Greeks (PA/BS)
     * POST /api/v5/account/set-greeks
     */
    @Test
    public void setTheDisplayTypeOfGreeks(){
        SetTheDisplayTypeOfGreeks setTheDisplayTypeOfGreeks = new SetTheDisplayTypeOfGreeks();
        setTheDisplayTypeOfGreeks.setGreeksType("PA");
        JSONObject result = this.accountAPIService.setTheDisplayTypeOfGreeks(setTheDisplayTypeOfGreeks);
        toResultString(LOG, "result", result);
    }


    /**
     * 查看账户最大可转余额  Get Maximum Withdrawals
     * GET /api/v5/account/max-withdrawal
     */
    @Test
    public void getMaximumWithdrawals(){
        JSONObject result = this.accountAPIService.getMaximumWithdrawals("USDT");
        toResultString(LOG, "result", result);
    }

}
