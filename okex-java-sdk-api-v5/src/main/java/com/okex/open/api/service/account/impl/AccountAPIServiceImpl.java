package com.okex.open.api.service.account.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.*;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.account.AccountAPIService;
import retrofit2.http.Query;

public class AccountAPIServiceImpl implements AccountAPIService {

    private APIClient client;
    private AccountAPI api;

    public AccountAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(AccountAPI.class);
    }


    //查看账户余额 Get Balance
    @Override
    public JSONObject getBalance(String ccy) {
        return this.client.executeSync(this.api.getBalance(ccy));
    }

    //查看持仓信息 Get Positions
    @Override
    public JSONObject getPositions(String instType, String instId,String posId) {
        return this.client.executeSync(this.api.getPositions(instType,instId,posId));
    }

    //查看账户持仓风险 Get account and position risk
    @Override
    public JSONObject getAccountAndPosition(String instType) {
        return this.client.executeSync(this.api.getAccountAndPosition(instType));
    }

    //账单流水查询（近七天） Get Bills Details (last 7 days)
    @Override
    public JSONObject getBillsDetails7Days(String instType,String ccy,String mgnMode,String ctType,String type,String subType,String after,String before,String limit) {
        return this.client.executeSync(this.api.getBillsDetails7Days(instType,ccy,mgnMode,ctType,type,subType,after,before,limit));
    }

    //账单流水查询（近七天） Get Bills Details (last 3 months)
    @Override
    public JSONObject getBillsDetails3Months(String instType, String ccy, String mgnMode, String ctType, String type, String subType, String after, String before, String limit) {
        return this.client.executeSync(this.api.getBillsDetails3Months(instType,ccy,mgnMode,ctType,type,subType,after,before,limit));
    }

    //查看账户配置 Get Account Configuration
    @Override
    public JSONObject getAccountConfiguration() {
        return this.client.executeSync(this.api.getAccountConfiguration());
    }

    //设置持仓模式 Set Position mode
    @Override
    public JSONObject setPositionMode(SetPositionMode setPositionMode) {
        return this.client.executeSync(this.api.setPositionMode(JSONObject.parseObject(JSON.toJSONString(setPositionMode))));
    }

    //设置杠杆倍数 Set Leverage
    @Override
    public JSONObject setLeverage(SetLeverage setLeverage) {
        return this.client.executeSync(this.api.setLeverage(JSONObject.parseObject(JSON.toJSONString(setLeverage))));
    }

    //获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount
    @Override
    public JSONObject getMaximumTradableSizeForInstrument(String instId, String tdMode, String ccy, String px,String leverage) {
        return this.client.executeSync(this.api.getMaximumTradableSizeForInstrument(instId,tdMode,ccy,px,leverage));
    }

    //获取最大可用数量 Get Maximum Available Tradable Amount
    @Override
    public JSONObject getMaximumAvailableTradableAmount(String instId, String tdMode, String ccy, String reduceOnly) {
        return this.client.executeSync(this.api.getMaximumAvailableTradableAmount(instId,tdMode,ccy,reduceOnly));
    }

    //调整保证金 Increase/Decrease margin
    @Override
    public JSONObject increaseDecreaseMargin(IncreaseDecreaseMargin increaseDecreaseMargin) {
        return this.client.executeSync(this.api.increaseDecreaseMargin(JSONObject.parseObject(JSON.toJSONString(increaseDecreaseMargin))));
    }

    //获取杠杆倍数 Get Leverage
    @Override
    public JSONObject getLeverage(String instId, String mgnMode) {
        return this.client.executeSync(this.api.getLeverage(instId,mgnMode));
    }

    //获取币币逐仓杠杆最大可借 Get the maximum loan of instrument
    @Override
    public JSONObject getTheMaximumLoanOfIsolatedMARGIN(String instId,String mgnMode,String mgnCcy) {
        return this.client.executeSync(this.api.getTheMaximumLoanOfIsolatedMARGIN(instId,mgnMode,mgnCcy));
    }

    //获取当前账户交易手续费费率 Get Fee Rates
    @Override
    public JSONObject getFeeRates(String instType, String instId, String uly, String category) {
        return this.client.executeSync(this.api.getFeeRates(instType,instId,uly,category));
    }


    //获取计息记录 Get interest-accrued
    @Override
    public JSONObject getInterestAccrued(String type,String instId, String ccy, String mgnMode, String after, String before, String limit) {
        return this.client.executeSync(this.api.getInterestAccrued(type,instId,ccy,mgnMode,after,before,limit));
    }

    //获取用户当前杠杆借币利率 Get interest rate
    @Override
    public JSONObject getInterestRate(String ccy) {
        return this.client.executeSync(this.api.getInterestRate(ccy));
    }

    //期权希腊字母PA/BS切换 Set the display type of Greeks
    @Override
    public JSONObject setTheDisplayTypeOfGreeks(SetTheDisplayTypeOfGreeks setTheDisplayTypeOfGreeks) {
        return this.client.executeSync(this.api.setTheDisplayTypeOfGreeks(JSONObject.parseObject(JSON.toJSONString(setTheDisplayTypeOfGreeks))));
    }

    //查看账户最大可转余额 Get Maximum Withdrawals
    @Override
    public JSONObject getMaximumWithdrawals(String ccy) {
        return this.client.executeSync(this.api.getMaximumWithdrawals(ccy));
    }

    //查看账户特定风险状态 Get account risk state
    @Override
    public JSONObject getRiskState() {
        return this.client.executeSync(this.api.getRiskState());
    }

    //尊享借币还币  borrow repay
    @Override
    public JSONObject borrowRepay(AccountBorrowRepay accountBorrowRepay) {
        return this.client.executeSync(this.api.borrowRepay(JSONObject.parseObject(JSON.toJSONString(accountBorrowRepay))));
    }

    //获取尊享借币借还历史
    @Override
    public JSONObject getBorrowRepayHistory(String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.getBorrowRepayHistory(ccy,after,before,limit));
    }

    //获取借币利率与限额
    @Override
    public JSONObject getInterestLimits(String type, String ccy) {
        return this.client.executeSync(this.api.getInterestLimits(type,ccy));
    }
}
