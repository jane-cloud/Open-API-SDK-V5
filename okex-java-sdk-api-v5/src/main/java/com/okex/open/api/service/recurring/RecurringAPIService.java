package com.okex.open.api.service.recurring;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.recurringTrading.Recurring;
import com.okex.open.api.bean.recurringTrading.RecurringAlgoOrder;

import java.util.List;

public interface RecurringAPIService {
    JSONObject placeOrderAlgo(RecurringAlgoOrder recurringOrder);

    JSONObject amendOrderAlgo(Recurring recurring);

    JSONObject stopOrderAlgo(List<Recurring> recurring);

    JSONObject getOrderAlgoPending(String algoId, String after, String before, String limit, String recurringHour, String nextInvestTime);

    JSONObject getOrderAlgoHistory(String algoId, String after, String before, String limit,String recurringHour, String nextInvestTime);

    JSONObject getOrderAlgoDetails(String algoId,String recurringHour, String nextInvestTime);

    JSONObject getSubOrders(String algoId,String ordId, String after, String before, String limit);
}
