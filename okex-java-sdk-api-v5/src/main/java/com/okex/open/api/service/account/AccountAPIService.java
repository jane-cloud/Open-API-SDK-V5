package com.okex.open.api.service.account;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface AccountAPIService {

    //查看账户余额 Get Balance
    JSONObject getBalance(String ccy);

    //查看持仓信息 Get Positions
    JSONObject getPositions(String instType,String instId,String posId);

    //查看历史持仓信息   Get positions-history
    JSONObject getPositionsHistory(String instType, String instId, String mgnMode, String type, String after, String before, String limit,String posId);

    //查看账户持仓风险 Get account and position risk
    JSONObject getAccountAndPosition(String instType);

    //账单流水查询（近七天） Get Bills Details (last 7 days)
    JSONObject getBillsDetails7Days(String instType,String ccy,String mgnMode,String ctType,String type,String subType,String after,String before,String limit);

    //账单流水查询（近三月） Get Bills Details (last 3 months)
    JSONObject getBillsDetails3Months(String instType,String ccy,String mgnMode,String ctType,String type,String subType,String after,String before,String limit);

    //查看账户配置 Get Account Configuration
    JSONObject getAccountConfiguration();

    //设置持仓模式 Set Position mode
    JSONObject setPositionMode(SetPositionMode setPositionMode);

    //设置杠杆倍数 Set Leverage
    JSONObject setLeverage(SetLeverage setLeverage);

    //获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount
    JSONObject getMaximumTradableSizeForInstrument(String instId,String tdMode,String ccy,String px,String leverage,Boolean unSpotOffset);

    //获取最大可用数量 Get Maximum Tradable Size For Instrument
    JSONObject getMaximumAvailableTradableAmount(String instId,String tdMode,String ccy,Boolean reduceOnly,String px,Boolean unSpotOffset,String quickMgnType);

    //调整保证金 Increase/Decrease margin
     JSONObject increaseDecreaseMargin(IncreaseDecreaseMargin increaseDecreaseMargin);

    //获取杠杆倍数 Get Leverage
    JSONObject getLeverage(String instId,String mgnMode);

    //获取交易产品最大可借 Get the maximum loan of instrument
    JSONObject getTheMaximumLoanOfIsolatedMARGIN(String instId,String mgnMode,String mgnCcy);

    //获取当前账户交易手续费费率 Get Fee Rates
    JSONObject getFeeRates(String instType,String instId,String uly,String instFamily);

    //获取计息记录 Get interest-accrued
    JSONObject getInterestAccrued(String type,String instId,String ccy,String mgnMode,String after,String before,String limit);

    //获取用户当前杠杆借币利率 Get interest rate
    JSONObject getInterestRate(String ccy);

    //期权希腊字母PA/BS切换 Set the display type of Greeks
    JSONObject setTheDisplayTypeOfGreeks(SetTheDisplayTypeOfGreeks setTheDisplayTypeOfGreeks);

    //逐仓交易设置 Isolated margin trading settings
    JSONObject setIsolatedMode(SetIsolatedMode setIsolatedMode);

    //查看账户最大可转余额 Get Maximum Withdrawals
    JSONObject getMaximumWithdrawals(String ccy);

    //查看账户特定风险状态 Get account risk state
    JSONObject getRiskState();

    //一键借币模式手动借币还币 Manual borrow and repay in Quick Margin Mode
    JSONObject quickMarginBorrowRepay(QuickMarginBorrowRepay quickMarginBorrowRepay);

    //获取一键借币还币历史 Get manual borrow and repay history in Quick Margin Mode
    JSONObject getMarginBorrowRepayHistory(String instId, String ccy, String side, String after, String before, String begin, String end, String limit);

    //尊享借币还币  VIP loans borrow and repay
    JSONObject borrowRepay(AccountBorrowRepay accountBorrowRepay);

    //获取尊享借币借还历史  Get borrow and repay history for VIP loans
    JSONObject getBorrowRepayHistory(String ccy, String after, String before, String limit);

    //获取尊享借币计息记录 Get VIP interest accrued data
    JSONObject getVipInterestAccrued(String ccy, String ordId, String after, String before, String limit);

    //获取尊享借币扣息记录 Get VIP interest deducted data
    JSONObject getVipInterestDeducted(String ordId, String ccy, String after, String before, String limit);

    //尊享借币订单列表 Get VIP loan order list
    JSONObject getVipLoanOrderList(String ordId, String state, String ccy, String after, String before, String limit);

    //尊享借币订单详情 Get VIP loan order detail
    JSONObject getVipLoanOrderDetail(String ccy, String ordId, String after, String before, String limit);

    //获取借币利率与限额  Get borrow interest and limit
    JSONObject getInterestLimits(String type, String ccy);

    //组合保证金的虚拟持仓保证金计算 Position builder
    JSONObject simulatedMargin(SimulatedMargin simulatedMargin);

    //查看账户Greeks Get Greeks
    JSONObject getAccountGreeks(String ccy);

    //获取组合保证金模式全仓限制 Get PM limitation
    JSONObject getPositionTiers(String instType, String uly,String instFamily);

    //设置组合保证金账户风险对冲模式 Set risk offset type
    JSONObject setRiskOffsetType(IncreaseDecreaseMargin increaseDecreaseMargin);

    //开通期权交易 Activate option
    JSONObject activateOption();

    //设置自动借币 Set auto loan
    JSONObject setAutoLoan(SetAutoLoan setAutoLoan);
}
