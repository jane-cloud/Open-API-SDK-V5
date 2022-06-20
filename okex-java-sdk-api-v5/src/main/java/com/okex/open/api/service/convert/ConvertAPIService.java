package com.okex.open.api.service.convert;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.convert.param.EstimateQuote;
import com.okex.open.api.bean.convert.param.Trade;

public interface ConvertAPIService {

    //获取闪兑币种列表 Get convert currencies
    JSONObject getCurrencies();

    //获取闪兑币对信息 Get convert currency pair
    JSONObject getCurrencyPair(String fromCcy,String toCcy);

    //闪兑预估询价 Estimate quote
    JSONObject estimateQuote(EstimateQuote estimateQuote);

    //闪兑交易 Convert trade
    JSONObject trade(Trade trade);

    //获取闪兑交易历史 Get convert history
    JSONObject getHistory(String after ,String before,String limit,String tag);
}
