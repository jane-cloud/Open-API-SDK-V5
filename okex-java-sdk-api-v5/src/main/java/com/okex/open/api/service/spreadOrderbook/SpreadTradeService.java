package com.okex.open.api.service.spreadOrderbook;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.*;
import com.okex.open.api.bean.spread.SpreadOrder;


public interface SpreadTradeService {


    JSONObject placeSprdOrder(SpreadOrder placeOrder);

    JSONObject cancelSprdOrder(SpreadOrder cancelSprdOrder);

    JSONObject massCancelSprdOrder(SpreadOrder massCancel);

    JSONObject getSprdOrder(String ordId, String clOrdId);

    JSONObject getOrdersPending(String sprdId, String ordType, String state, String beginId, String endId, String limit);

    JSONObject getOrdersHistory(String sprdId, String ordType, String state, String beginId, String endId,String begin ,String end,String limit);

    JSONObject getTrades(String sprdId, String tradeId, String ordId, String beginId, String endId,String begin ,String end,String limit);

    JSONObject getPublicSpreads(String baseCcy, String instId, String sprdId, String state);

    JSONObject getPublicBooks(String sprdId, String sz);

    JSONObject getPublicTicker(String sprdId);

    JSONObject getPublicTrades(String sprdId);

    JSONObject amendOrder(SpreadOrder amendOrder);

    JSONObject getOrdersHistoryArchive(String sprdId, String ordType, String state, String instType, String endId,String begin ,String end,String limit, String beginId, String instFamily);

    JSONObject getSprdHistoryCandles(String sprdId, String after, String before, String bar, String limit);

    JSONObject getSprdCandles(String sprdId, String after, String before, String bar, String limit);

    JSONObject getSprdTicker(String sprdId);

    JSONObject cancelAllAfter(SpreadOrder cancelAllAfter);
}
