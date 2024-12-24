package com.okex.open.api.service.finance;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
import com.okex.open.api.bean.finance.param.AmendFinance;
import com.okex.open.api.bean.finance.param.Finance;

public interface FinanceAPIService {


    //获取余币宝余额
    JSONObject getFinanceBalance(String ccy);
    //余币宝申购/赎回
    JSONObject PurchaseRedempt(Finance finance);
    //设置余币宝借贷利率
    JSONObject setLendingRate(Finance finance);

    JSONObject getLendingHistory(String ccy, String after, String before, String limit);

    JSONObject getLendingRateSummary(String ccy);

    JSONObject getLendingRateHistory(String ccy, String after, String before, String limit);

    JSONObject getLendingOffers(String ccy, String term);

    JSONObject getLendingApyHistory(String ccy, String term);

    JSONObject getPendingLendingVolume(String ccy, String term);

    JSONObject lendingOrder(Finance finance);

    JSONObject amendLendingOrder(AmendFinance amendFinance);

    JSONObject getLendingOrdersList(String ordId, String ccy, String state, String after, String before, String limit);

    JSONObject getLendingSubOrders(String ordId, String state, String after, String before, String limit);

    JSONObject getBorrowCurrencies();

    JSONObject getCollateralAssets(String ccy);

    JSONObject getMaxLoan(Finance finance);

    JSONObject getMaxCollateralRedeemAmount(String borrowCcy);

    JSONObject adjustCollateral(Finance finance);

    JSONObject getLoanInfo();

    JSONObject getLoanHistory(String type, String after, String before, String limit);

    JSONObject getInterestAccrued(String type, String after, String before, String limit);

    JSONObject solPurchase(Purchase purchase);

    JSONObject solRedeem(Redeem redeem);

    JSONObject getBalance(String ccy, String amt, String latestInterestAccrual, String totalInterestAccrual);

    JSONObject getPurchaseRedeemHistory(String type, String status, String after, String before, String limit);

    JSONObject getApyHistory(String days);
}
