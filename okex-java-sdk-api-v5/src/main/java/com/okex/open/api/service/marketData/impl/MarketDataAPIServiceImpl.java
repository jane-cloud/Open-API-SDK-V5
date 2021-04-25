package com.okex.open.api.service.marketData.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.market.result.BinanceCandlestick;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.BinanceInternal;
import com.okex.open.api.service.marketData.MarketDataAPIService;

import java.util.List;

public class MarketDataAPIServiceImpl implements MarketDataAPIService {
    private final APIClient client;
    private final MarketDataAPI marketDataAPI;

    public MarketDataAPIServiceImpl(final APIConfiguration config) {
        this.client = new APIClient(config);
        this.marketDataAPI = this.client.createService(MarketDataAPI.class);
    }

    //获取所有产品行情信息 Get Tickers
    @Override
    public JSONObject getTickers(String instType, String uly) {
        return this.client.executeSync(this.marketDataAPI.getTickers(instType,uly));
    }

    //获取单个产品行情信息 Get Ticker
    @Override
    public JSONObject getTicker(String instId) {
        return this.client.executeSync(this.marketDataAPI.getTicker(instId));
    }

    //获取指数行情数据 Get Index Tickers
    @Override
    public JSONObject getIndexTickers(String quoteCcy, String instId) {
        return this.client.executeSync(this.marketDataAPI.getIndexTickers(quoteCcy,instId));
    }

    //获取产品深度 Get Order Book
    @Override
    public JSONObject getOrderBook(String instId, String sz) {
        return this.client.executeSync(this.marketDataAPI.getOrderBook(instId,sz));
    }

    //获取所有交易产品K线数据 Get Candlesticks
    @Override
    public JSONObject getCandlesticks(String instId, String after, String before, String bar, String limit) {
        return this.client.executeSync(this.marketDataAPI.getCandlesticks(instId,after,before,bar,limit));
    }

    //获取交易产品历史K线数据（仅主流币） Get Candlesticks History（top currencies only）
    @Override
    public JSONObject getCandlesticksHistory(String instId, String after, String before, String bar, String limit) {
        return this.client.executeSync(this.marketDataAPI.getCandlesticksHistory(instId,after,before,bar,limit));
    }

    //获取指数K线数据 Get Index Candlesticks
    @Override
    public JSONObject getIndexCandlesticks(String instId, String after, String before, String bar, String limit) {
        return this.client.executeSync(this.marketDataAPI.getIndexCandlesticks(instId,after,before,bar,limit));
    }

    //获取标记价格K线数据 Get Mark Price Candlesticks
    @Override
    public JSONObject getMarkPriceCandlesticks(String instId, String after, String before, String bar, String limit) {
        return this.client.executeSync(this.marketDataAPI.getMarkPriceCandlesticks(instId, after, before, bar, limit));
    }

    //获取交易产品公共成交数据 Get Trades
    @Override
    public JSONObject getTrades(String instId, String limit) {
        return this.client.executeSync(this.marketDataAPI.getTrades(instId,limit));
    }

    //获取平台24小时总成交量 Get total volume
    @Override
    public JSONObject getTotalVolume() {
        return this.client.executeSync(this.marketDataAPI.getTotalVolume());
    }

}
