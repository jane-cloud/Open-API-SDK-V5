package com.okex.open.api.service.blockTrading.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.blockTrading.param.*;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.blockTrading.BlockTradingAPIService;

import java.util.List;

public class BlockTradingAPIServiceImpl implements BlockTradingAPIService {
    private APIClient client;
    private BlockTradingAPI api;

    public BlockTradingAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(BlockTradingAPI.class);
    }


    //获取报价方信息 Get Counterparties
    @Override
    public JSONObject getCounterparties() {
        return this.client.executeSync(this.api.getCounterparties());
    }

    //询价 Create RFQ
    @Override
    public JSONObject createRfq(CreateRfq createRfq) {
        return this.client.executeSync(this.api.createRfq(createRfq));
    }

    //取消询价单 Cancel RFQ
    @Override
    public JSONObject cancelRfq(CancelRfq cancleRfq) {
        return this.client.executeSync(this.api.cancelRfq(cancleRfq));
    }

    //批量取消询价单 Cancel multiple RFQs
    @Override
    public JSONObject cancelBatchRfqs(CancelBatchRfqs cancelBatchRfqs) {
        return this.client.executeSync(this.api.cancelBatchRfqs(cancelBatchRfqs));
    }

    //取消所有询价单 Cancel all RFQs
    @Override
    public JSONObject cancelAllRfqs() {
        return this.client.executeSync(this.api.cancelAllRfqs());
    }

    //执行报价 Execute Quote
    @Override
    public JSONObject executeQuote(ExecuteQuote executeQuote) {
        return this.client.executeSync(this.api.executeQuote(executeQuote));
    }

    //设置可报价产品 Set Quote products
    @Override
    public JSONObject setQuoteProducts(List<SetQuoteProducts> setQuoteProducts) {
        return this.client.executeSync(this.api.setQuoteProducts(setQuoteProducts));
    }

    //重设MMP状态 Reset MMP status
    @Override
    public JSONObject resetMMPStatus() {
        return this.client.executeSync(this.api.resetMMPStatus());
    }

    //报价 Create Quote
    @Override
    public JSONObject createQuote(CreateQuote createQuote) {
        return this.client.executeSync(this.api.createQuote(createQuote));
    }

    //取消报价单 Cancel Quote
    @Override
    public JSONObject cancelQuote(CancelQuote cancelQuote) {
        return this.client.executeSync(this.api.cancelQuote(cancelQuote));
    }

    //批量取消报价单 Cancel multiple Quotes
    @Override
    public JSONObject cancelBatchQuotes(CancelBatchQuotes cancelBatchQuotes) {
        return this.client.executeSync(this.api.cancelBatchQuotes(cancelBatchQuotes));
    }

    //取消所有报价单 Cancel all Quotes
    @Override
    public JSONObject cancelAllQuotes() {
        return this.client.executeSync(this.api.cancelAllQuotes());
    }

    //获取询价单信息 Get rfqs
    @Override
    public JSONObject getRfqs(String rfqId, String clRfqId, String state, String beginId, String endId, String limit) {
        return this.client.executeSync(this.api.getRfqs(rfqId, clRfqId, state, beginId, endId, limit));
    }

    //获取报价单信息 Get quotes
    @Override
    public JSONObject getQuotes(String rfqId, String clRfqId, String quoteId, String clQuoteId, String state, String beginId, String endId, String limit) {
        return this.client.executeSync(this.api.getQuotes(rfqId, clRfqId, quoteId, clQuoteId, state, beginId, endId, limit));
    }

    //获取大宗交易信息 Get trades
    @Override
    public JSONObject getTrades(String rfqId, String clRfqId, String quoteId, String clQuoteId, String state, String beginId, String endId, String limit) {
        return this.client.executeSync(this.api.getTrades(rfqId, clRfqId, quoteId, clQuoteId, state, beginId, endId, limit));
    }

    //获取大宗交易公共成交数据 Get public trades
    @Override
    public JSONObject getPublicTrades(String beginId, String endId, String limit) {
        return this.client.executeSync(this.api.getPublicTrades(beginId, endId, limit));
    }


}
