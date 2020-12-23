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
     * 查看账户余额 Get Balance
     * GET /api/v5/account/balance
     */
    @Test
    public void getBalance(){
        JSONObject result = this.accountAPIService.getBalance("BTC,ETH");
        toResultString(LOG, "result", result);
    }


    /**
     * 查看持仓信息 Get Positions
     * GET /api/v5/account/positions
     */
    @Test
    public void getPositions(){
        JSONObject result = this.accountAPIService.getPositions("FUTURES","BTC-USDT-210326");
        toResultString(LOG, "result", result);
    }


    /**
     * 账单流水查询（近七天） Get Bills Details (last 7 days)
     * GET /api/v5/account/bills
     */
    @Test
    public void getBillsDetails7Days(){
        JSONObject result = this.accountAPIService.getBillsDetails7Days("FUTURES","","","","","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 账单流水查询（近三个月） Get Bills Details (last 3 months)
     * GET /api/v5/account/bills-archive
     */
    @Test
    public void getBillsDetails3Months(){
        JSONObject result = this.accountAPIService.getBillsDetails3Months("FUTURES","","","","","","","","");
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
     * GET /api/v5/account/config
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
        setLeverage.setInstId("BTC-USDT");
        setLeverage.setLever("3.33");
        setLeverage.setMgnMode("cross");
        JSONObject result = this.accountAPIService.setLeverage(setLeverage);
        toResultString(LOG, "result", result);
    }


    /**
     * 获取最大可交易数量 Get Maximum Tradable Size For Instrument
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
        JSONObject result = this.accountAPIService.getMaximumAvailableTradableAmount("BTC-USDT-210326","cross","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 调整保证金  Increase/Decrease margin
     * POST /api/v5/account/position/margin-balance
     */
    @Test
    public void increaseDecreaseMargin(){
        IncreaseDecreaseMargin increaseDecreaseMargin = new IncreaseDecreaseMargin();

        increaseDecreaseMargin.setInstId("BTC-USDT-SWAP");
        increaseDecreaseMargin.setPosSide("short");
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

        JSONObject result = this.accountAPIService.getLeverage("BTC-USDT-210326","cross");
        toResultString(LOG, "result", result);
    }




    /**
     * 获取币币逐仓杠杆最大可借  Get the maximum loan of isolated MARGIN
     * GET /api/v5/account/max-loan
     */
    @Test
    public void getTheMaximumLoanOfIsolatedMARGIN(){

        JSONObject result = this.accountAPIService.getTheMaximumLoanOfIsolatedMARGIN("BTC-USDT");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取当前账户交易手续费费率  Get Fee Rates
     * GET /api/v5/account/trade-fee
     */
    @Test
    public void getFeeRates(){

        JSONObject result = this.accountAPIService.getFeeRates("SPOT","BTC-USDT","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取计息记录  Get interest-accrued
     * GET /api/v5/account/interest-accrued
     */
    @Test
    public void getInterestAccrued(){

        JSONObject result = this.accountAPIService.getInterestAccrued("","","","","","");
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
        JSONObject result = this.accountAPIService.getMaximumWithdrawals("");
        toResultString(LOG, "result", result);
    }

}
