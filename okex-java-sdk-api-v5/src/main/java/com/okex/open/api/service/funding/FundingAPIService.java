package com.okex.open.api.service.funding;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.funding.param.*;
import retrofit2.http.Query;

public interface FundingAPIService {

    //获取币种列表 Get Currencies
    JSONObject getCurrencies();

    //获取资金账户余额
    JSONObject getBalance(String ccy);

    //资金划转  Funds Transfer
    JSONObject fundsTransfer(FundsTransfer fundsTransfer);

    //资金流水查询 Asset Bills Details
    JSONObject assetBillsDetails(String ccy,String type,String clientId,String after,String before,String limit);

    //获取充值地址信息 Get Deposit Address
    JSONObject getDepositAddress(String ccy);

    //获取充值记录 Get Deposit History
    JSONObject getDepositHistory(String ccy,String txId,String fromWdId,String type,String state,String after,String before,String limit,String depId);

    //提币 Withdrawal
    JSONObject Withdrawal(Withdrawal withdrawal);

    //获取提币记录 Get Withdrawal History
    JSONObject getWithdrawalHistory(String ccy,String clientId,String txId,String type,String state,String after,String before,String limit,String wdId);

    //获取充值/提现的详细状态 Get deposit withdraw status
    JSONObject getDepositWithdrawalStatus(String wdId, String txId, String ccy, String to,String chain);


    //余币宝申购/赎回 PiggyBank Purchase/Redemption
    JSONObject piggyBankPurchaseRedemption(PiggyBankPurchaseRedemption piggyBankPurchaseRedemption);

    //获取余币宝余额
    JSONObject piggyBalance(String ccy);

    //闪电网络充币 Deposit Lightning
    JSONObject depositLightning(String ccy, String amt, String to);

    //闪电网络提币 Withdrawal Lightning
    JSONObject withdrawalLightning(Withdrawal withdrawal);

    //获取资金划转状态 Transfer State
    JSONObject transferState(String transId,String clientId, String type);

    //获取账户资产估值 Get account asset valuation
    JSONObject assetValuation(String ccy);

    //设置余币宝借贷利率 Set lending rate
    JSONObject SetLendingRate(SetLendingRate setLendingRate);

    //获取余币宝出借明细  Get lending history
    JSONObject lendingHistory(String ccy, String after, String before,String limit);

    //获取市场借贷信息（公共） Get public borrow info (public)
    JSONObject lendingRateSummary(String ccy);

    //获取市场借贷历史（公共）  Get public borrow history (public)
    JSONObject lendingRateHistory(String ccy, String after, String before,String limit);

    //小额资产兑换
    JSONObject convertDustAssets(ConvertDustAssets convertDustAssets);

    //撤销提币
    JSONObject cancelWithdrawal(Withdrawal cancelWithdrawal);

    JSONObject getNonTradableAssets(String ccy);

    //获取交易所列表
    JSONObject getExchangeList();
}
