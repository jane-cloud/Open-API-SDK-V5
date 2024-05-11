package com.okex.open.api.service.blockTrading;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.blockTrading.param.*;
import retrofit2.http.Query;

import java.util.List;

public interface BlockTradingAPIService {

    //获取报价方信息 Get Counterparties
    JSONObject getCounterparties();

    //询价 Create RFQ
    JSONObject createRfq(CreateRfq createRfq);

    //取消询价单 Cancel RFQ
    JSONObject cancelRfq(CancelRfq cancleRfq);

    //批量取消询价单 Cancel multiple RFQs
    JSONObject cancelBatchRfqs(CancelBatchRfqs cancelBatchRfqs);

    //取消所有询价单 Cancel all RFQs
    JSONObject cancelAllRfqs();

    //执行报价 Execute Quote
    JSONObject executeQuote(ExecuteQuote executeQuote);

    //设置可报价产品 Set Quote products
    JSONObject setQuoteProducts(List<SetQuoteProducts> setQuoteProducts);

    //重设MMP状态 Reset MMP status
    JSONObject resetMMPStatus();

    //报价 Create Quote
    JSONObject createQuote(CreateQuote createQuote);

    //取消报价单 Cancel Quote
    JSONObject cancelQuote(CancelQuote cancelQuote);

    //批量取消报价单 Cancel multiple Quotes
    JSONObject cancelBatchQuotes(CancelBatchQuotes cancelBatchQuotes);

    //取消所有报价单 Cancel all Quotes
    JSONObject cancelAllQuotes();

    //获取询价单信息 Get rfqs
    JSONObject getRfqs(String rfqId, String clRfqId, String state, String beginId, String endId, String limit);

    //获取报价单信息 Get quotes
    JSONObject getQuotes(String rfqId, String clRfqId, String quoteId,String clQuoteId,String state, String beginId, String endId, String limit);

    //获取大宗交易信息 Get trades
    JSONObject getTrades(String rfqId, String clRfqId, String quoteId,String clQuoteId,String state, String beginId, String endId, String limit, String beginTs, String endTs);

    //获取大宗交易公共成交数据 Get public trades
    JSONObject getPublicTrades(String beginId, String endId, String limit);

    JSONObject getMakerInstrumentSettings();

    JSONObject cancelAllAfter(CancelBatchQuotes cancelAllAfter);
}
