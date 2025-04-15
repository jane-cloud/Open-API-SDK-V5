package com.okex.open.api.service.account.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.*;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.account.AccountAPIService;

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

    //查看历史持仓信息   Get positions-history
    @Override
    public JSONObject getPositionsHistory(String instType, String instId, String mgnMode, String type, String after, String before, String limit,String posId) {
        return this.client.executeSync(this.api.getPositionsHistory(instType, instId, mgnMode, type, after, before, limit,posId));
    }

    //查看账户持仓风险 Get account and position risk
    @Override
    public JSONObject getAccountAndPosition(String instType) {
        return this.client.executeSync(this.api.getAccountAndPosition(instType));
    }

    //账单流水查询（近七天） Get Bills Details (last 7 days)
    @Override
    public JSONObject getBillsDetails7Days(String instType,String ccy,String mgnMode,String ctType,String type,String subType,String after,String before,String limit,String instId) {
        return this.client.executeSync(this.api.getBillsDetails7Days(instType,ccy,mgnMode,ctType,type,subType,after,before,limit,instId));
    }

    //账单流水查询（近三月） Get Bills Details (last 3 months)
    @Override
    public JSONObject getBillsDetails3Months(String instType, String ccy, String mgnMode, String ctType, String type, String subType, String after, String before, String limit,String instId) {
        return this.client.executeSync(this.api.getBillsDetails3Months(instType,ccy,mgnMode,ctType,type,subType,after,before,limit,instId));
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
    public JSONObject getMaximumTradableSizeForInstrument(String instId, String tdMode, String ccy, String px,String leverage,Boolean unSpotOffset) {
        return this.client.executeSync(this.api.getMaximumTradableSizeForInstrument(instId,tdMode,ccy,px,leverage,unSpotOffset));
    }

    //获取最大可用数量 Get Maximum Available Tradable Amount
    @Override
    public JSONObject getMaximumAvailableTradableAmount(String instId, String tdMode, String ccy, Boolean reduceOnly,String px,Boolean unSpotOffset, String quickMgnType) {
        return this.client.executeSync(this.api.getMaximumAvailableTradableAmount(instId,tdMode,ccy,reduceOnly,px,unSpotOffset,quickMgnType));
    }

    //调整保证金 Increase/Decrease margin
    @Override
    public JSONObject increaseDecreaseMargin(IncreaseDecreaseMargin increaseDecreaseMargin) {
        return this.client.executeSync(this.api.increaseDecreaseMargin(JSONObject.parseObject(JSON.toJSONString(increaseDecreaseMargin))));
    }

    //获取杠杆倍数 Get Leverage
    @Override
    public JSONObject getLeverage(String instId, String mgnMode,String ccy) {
        return this.client.executeSync(this.api.getLeverage(instId,mgnMode,ccy));
    }

    //获取币币逐仓杠杆最大可借 Get the maximum loan of instrument
    @Override
    public JSONObject getTheMaximumLoanOfIsolatedMARGIN(String instId,String mgnMode,String mgnCcy) {
        return this.client.executeSync(this.api.getTheMaximumLoanOfIsolatedMARGIN(instId,mgnMode,mgnCcy));
    }

    //获取当前账户交易手续费费率 Get Fee Rates
    @Override
    public JSONObject getFeeRates(String instType, String instId, String uly,String instFamily,String ruleType) {
        return this.client.executeSync(this.api.getFeeRates(instType,instId,uly,instFamily,ruleType));
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

    //逐仓交易设置 Isolated margin trading settings
    @Override
    public JSONObject setIsolatedMode(SetIsolatedMode setIsolatedMode) {
        return this.client.executeSync(this.api.setIsolatedMode(JSONObject.parseObject(JSON.toJSONString(setIsolatedMode))));
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

    //一键借币模式手动借币还币 Manual borrow and repay in Quick Margin Mode
    @Override
    public JSONObject quickMarginBorrowRepay(QuickMarginBorrowRepay quickMarginBorrowRepay) {
        return this.client.executeSync(this.api.quickMarginBorrowRepay(JSONObject.parseObject(JSON.toJSONString(quickMarginBorrowRepay))));
    }

    //获取一键借币还币历史 Get manual borrow and repay history in Quick Margin Mode
    @Override
    public JSONObject getMarginBorrowRepayHistory(String instId, String ccy, String side, String after, String before, String begin, String end, String limit) {
        return this.client.executeSync(this.api.getMarginBorrowRepayHistory(instId,ccy,side,after,before,begin,end,limit));
    }

    //尊享借币还币  VIP loans borrow and repay
    @Override
    public JSONObject borrowRepay(AccountBorrowRepay accountBorrowRepay) {
        return this.client.executeSync(this.api.borrowRepay(JSONObject.parseObject(JSON.toJSONString(accountBorrowRepay))));
    }

    //获取尊享借币借还历史  Get borrow and repay history for VIP loans
    @Override
    public JSONObject getBorrowRepayHistory(String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.getBorrowRepayHistory(ccy,after,before,limit));
    }

    //获取尊享借币计息记录 Get VIP interest accrued data
    @Override
    public JSONObject getVipInterestAccrued(String ccy, String ordId, String after, String before, String limit) {
        return this.client.executeSync(this.api.getVipInterestAccrued(ccy,ordId,after,before,limit));
    }

    //获取尊享借币扣息记录 Get VIP interest deducted data
    @Override
    public JSONObject getVipInterestDeducted(String ordId, String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.getVipInterestDeducted(ordId, ccy, after, before, limit));
    }

    //尊享借币订单列表 Get VIP loan order list
    @Override
    public JSONObject getVipLoanOrderList(String ordId, String state, String ccy, String after, String before, String limit) {
        return this.client.executeSync(this.api.getVipLoanOrderList(ordId,state,ccy,after,before,limit));
    }

    //尊享借币订单详情 Get VIP loan order detail
    @Override
    public JSONObject getVipLoanOrderDetail(String ccy, String ordId, String after, String before, String limit) {
        return this.client.executeSync(this.api.getVipLoanOrderDetail(ccy,ordId,after,before,limit));
    }

    //获取借币利率与限额  Get borrow interest and limit
    @Override
    public JSONObject getInterestLimits(String type, String ccy) {
        return this.client.executeSync(this.api.getInterestLimits(type,ccy));
    }

    //组合保证金的虚拟持仓保证金计算 Position builder
    @Override
    public JSONObject simulatedMargin(SimulatedMargin simulatedMargin) {
        return this.client.executeSync(this.api.simulatedMargin(JSONObject.parseObject(JSON.toJSONString(simulatedMargin))));
    }

    //查看账户Greeks Get Greeks
    @Override
    public JSONObject getAccountGreeks(String ccy) {
        return this.client.executeSync(this.api.getAccountGreeks(ccy));
    }

    //获取组合保证金模式全仓限制 Get PM limitation
    @Override
    public JSONObject getPositionTiers(String instType, String uly,String instFamily) {
        return this.client.executeSync(this.api.getPositionTiers(instType,uly,instFamily));
    }

    //设置组合保证金账户风险对冲模式 Set risk offset type
    @Override
    public JSONObject setRiskOffsetType(IncreaseDecreaseMargin increaseDecreaseMargin) {
        return this.client.executeSync(this.api.setRiskOffsetType(JSONObject.parseObject(JSON.toJSONString(increaseDecreaseMargin))));
    }

    //开通期权交易 Activate option
    @Override
    public JSONObject activateOption() {
        return this.client.executeSync(this.api.activateOption());
    }

    //设置自动借币 Set auto loan
    @Override
    public JSONObject setAutoLoan(SetAutoLoan setAutoLoan) {
        return this.client.executeSync(this.api.setAutoLoan(JSONObject.parseObject(JSON.toJSONString(setAutoLoan))));
    }

    @Override
    public JSONObject mmpReset(Mmp mmpReset) {
        return this.client.executeSync(this.api.mmpReset(JSONObject.parseObject(JSON.toJSONString(mmpReset))));
    }

    @Override
    public JSONObject getAdjustLeverageInfo(String instType, String mgnMode, String lever, String instId, String ccy, String posSide) {
        return this.client.executeSync(this.api.getAdjustLeverageInfo(instType,mgnMode,lever,instId,ccy,posSide));
    }

    @Override
    public JSONObject mmpConfig(Mmp mmpConfig) {
        return this.client.executeSync(this.api.mmpConfig(JSONObject.parseObject(JSON.toJSONString(mmpConfig))));
    }

    @Override
    public JSONObject getMmpConfig(String instFamily) {
        return this.client.executeSync(this.api.getMmpConfig(instFamily));
    }

    @Override
    public JSONObject setAccountLevel(AccountMode accountMode) {
        return this.client.executeSync(this.api.setAccountLevel(JSONObject.parseObject(JSON.toJSONString(accountMode))));
    }

    @Override
    public JSONObject setMmpConfig(Mmp mmp) {
        return this.client.executeSync(this.api.setMmpConfig(JSONObject.parseObject(JSON.toJSONString(mmp))));
    }

    @Override
    public JSONObject positionBuilder(PositionBuilder positionBuilder) {
        return this.client.executeSync(this.api.positionBuilder(JSONObject.parseObject(JSON.toJSONString(positionBuilder))));
    }

    @Override
    public JSONObject getInstruments(String instType, String uly, String instFamily, String instId) {
        return this.client.executeSync(this.api.getInstruments(instType,uly,instFamily,instId));
    }

    @Override
    public JSONObject getBorrowingLimit() {
        return this.client.executeSync(this.api.getBorrowingLimit());
    }

    @Override
    public JSONObject getBorrowingQuote(String type, String ccy, String amt, String maxRate, String term, String ordId) {
        return this.client.executeSync(this.api.getBorrowingQuote(type, ccy, amt, maxRate, term, ordId));
    }

    @Override
    public JSONObject borrowingOrder(AccountBorrowRepay borrowingOrder) {
        return this.client.executeSync(this.api.borrowingOrder(JSONObject.parseObject(JSON.toJSONString(borrowingOrder))));
    }

    @Override
    public JSONObject amendBorrowingOrder(BorrowingOrder amendBorrowingOrder) {
        return this.client.executeSync(this.api.amendBorrowingOrder(JSONObject.parseObject(JSON.toJSONString(amendBorrowingOrder))));
    }

    @Override
    public JSONObject manualReborrow(BorrowingOrder manualReborrow) {
        return this.client.executeSync(this.api.manualReborrow(JSONObject.parseObject(JSON.toJSONString(manualReborrow))));
    }

    @Override
    public JSONObject repayBorrowingOrder(BorrowingOrder repayBorrowingOrder) {
        return this.client.executeSync(this.api.repayBorrowingOrder(JSONObject.parseObject(JSON.toJSONString(repayBorrowingOrder))));
    }

    @Override
    public JSONObject getBorrowingOrdersList(String ordId, String ccy, String state, String after, String before, String limit,String term) {
        return this.client.executeSync(this.api.getBorrowingOrdersList(ordId,  ccy,  state,  after,  before,  limit,term));
    }

    @Override
    public JSONObject setRiskOffsetAmt(SetRiskOffsetAmt setRiskOffsetAmt) {
        return this.client.executeSync(this.api.setRiskOffsetAmt(JSONObject.parseObject(JSON.toJSONString(setRiskOffsetAmt))));
    }

    @Override
    public JSONObject applyBillsHistoryArchive(BillsHistoryArchive billsHistoryArchive) {
        return this.client.executeSync(this.api.applyBillsHistoryArchive(JSONObject.parseObject(JSON.toJSONString(billsHistoryArchive))));

    }

    @Override
    public JSONObject getBillsHistoryArchive(String year, String quarter) {
        return this.client.executeSync(this.api.getBillsHistoryArchive(year,  quarter));

    }

    @Override
    public JSONObject convertToMarketLoan(BorrowingOrder repayBorrowingOrder) {
        return this.client.executeSync(this.api.convertToMarketLoan(JSONObject.parseObject(JSON.toJSONString(repayBorrowingOrder))));

    }

    @Override
    public JSONObject reduceLiabilities(BorrowingOrder repayBorrowingOrder) {
        return this.client.executeSync(this.api.reduceLiabilities(JSONObject.parseObject(JSON.toJSONString(repayBorrowingOrder))));
    }

    @Override
    public JSONObject spotManualBorrowRepay(BorrowingOrder borrowingOrder) {
        return this.client.executeSync(this.api.spotManualBorrowRepay(JSONObject.parseObject(JSON.toJSONString(borrowingOrder))));

    }

    @Override
    public JSONObject setAutoRepay(BorrowingOrder borrowingOrder) {
        return this.client.executeSync(this.api.setAutoRepay(JSONObject.parseObject(JSON.toJSONString(borrowingOrder))));

    }

    @Override
    public JSONObject getSpotBorrowRepayHistory(String ccy, String type, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSpotBorrowRepayHistory(ccy,type,after,before,limit));

    }

    @Override
    public JSONObject setCollateralAssets(CollateralAssets collateralAssets) {
        return this.client.executeSync(this.api.setCollateralAssets(JSONObject.parseObject(JSON.toJSONString(collateralAssets))));

    }

    @Override
    public JSONObject getCollateralAssets(String ccy, String collateralEnabled) {
        return this.client.executeSync(this.api.getCollateralAssets(ccy,collateralEnabled));

    }
}
