package com.okex.open.api.service.finance;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.earn.param.Cancel;
import com.okex.open.api.bean.earn.param.Purchase;
import com.okex.open.api.bean.earn.param.Redeem;
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
}
