package com.okex.open.api.test.convert;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.convert.param.EstimateQuote;
import com.okex.open.api.bean.convert.param.Trade;
import com.okex.open.api.service.convert.ConvertAPIService;
import com.okex.open.api.service.convert.impl.ConvertAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertAPITests extends ConvertAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(ConvertAPITests.class);

    private ConvertAPIService convertAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.convertAPIService = new ConvertAPIServiceImpl(this.config);
    }

    //获取闪兑币种列表 Get convert currencies
    @Test
    public void getCurrencies(){
        JSONObject result = convertAPIService.getCurrencies();
        toResultString(LOG, "result", result);
    }

    //获取闪兑币对信息 Get convert currency pair
    @Test
    public void getCurrencyPair(){
        JSONObject result = convertAPIService.getCurrencyPair("USDT","BTC");
        toResultString(LOG, "result", result);
    }

    //闪兑预估询价 Estimate quote
    @Test
    public void estimateQuote(){
        EstimateQuote estimateQuote = new EstimateQuote();
        estimateQuote.setBaseCcy("DOT");
        estimateQuote.setQuoteCcy("USDT");
        estimateQuote.setRfqSz("0.11");
        estimateQuote.setRfqSzCcy("DOT");
        estimateQuote.setSide("sell");
        estimateQuote.setClQReqId("");

        JSONObject result = convertAPIService.estimateQuote(estimateQuote);
        toResultString(LOG, "result", result);
    }

    //闪兑交易 Convert trade
    @Test
    public void trade(){
        Trade trade = new Trade();
        trade.setQuoteId("quoter2DOT-USDT16480917532410199");
        trade.setBaseCcy("DOT");
        trade.setQuoteCcy("USDT");
        trade.setSide("sell");
        trade.setSz("0.11");
        trade.setSzCcy("DOT");
        trade.setClTReqId("test0324006");

        JSONObject result = convertAPIService.trade(trade);
        toResultString(LOG, "result", result);
    }

    //获取闪兑交易历史 Get convert history
    @Test
    public void getHistory(){
        JSONObject result = convertAPIService.getHistory();
        toResultString(LOG, "result", result);
    }
}
