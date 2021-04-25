package com.okex.open.api.service.funding;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.funding.param.*;

public interface FundingAPIService {

    //获取充值地址信息 Get Deposit Address
    JSONObject getDepositAddress(String ccy);

    //获取资金账户余额信息
    JSONObject getBalance(String ccy);

    //资金划转  Funds Transfer
    JSONObject fundsTransfer(FundsTransfer fundsTransfer);

    //提币 Withdrawal
    JSONObject Withdrawal(Withdrawal withdrawal);

    //充值记录 Get Deposit History
    JSONObject getDepositHistory(String ccy,String state,String after,String before,String limit);

    //提币记录 Get Withdrawal History
    JSONObject getWithdrawalHistory(String ccy,String state,String after,String before,String limit);

    //获取币种列表 Get Currencies
    JSONObject getCurrencies();

    //余币宝申购/赎回 PiggyBank Purchase/Redemption
    JSONObject piggyBankPurchaseRedemption(PiggyBankPurchaseRedemption piggyBankPurchaseRedemption);

    //资金流水查询 Asset Bills Details
    JSONObject assetBillsDetails(String ccy,String type,String after,String before,String limit);
}
