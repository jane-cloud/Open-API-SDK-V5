package com.okex.open.api.test.marketData;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.okex.open.api.bean.market.result.BinanceCandlestick;
import com.okex.open.api.enums.BinanceInternal;
import com.okex.open.api.service.marketData.MarketDataAPIService;
import com.okex.open.api.service.marketData.impl.MarketDataAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MarketDataAPITest extends MarketDataAPIBaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(MarketDataAPITest.class);
    public MarketDataAPIService marketDataAPIService;

    @Before
    public void before() {
        config = config();
        marketDataAPIService = new MarketDataAPIServiceImpl(config);
    }

    /**
     * 获取所有产品行情信息 Get Tickers
     * GET /api/v5/market/tickers
     */
    @Test
    public void getTickers() {
        JSONObject result = this.marketDataAPIService.getTickers("FUTURES","BTC-USDT");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取单个产品行情信息 Get Ticker
     * GET /api/v5/market/ticker
     */
    @Test
    public void getTicker() {
        JSONObject result = this.marketDataAPIService.getTicker("BTC-USDT-SWAP");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取指数行情 Get Index Tickers
     * GET /api/v5/market/index-tickers
     */
    @Test
    public void getIndexTickers() {
        JSONObject result = this.marketDataAPIService.getIndexTickers("USDT","XRP-USDT");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取产品深度 Get Order Book
     * GET /api/v5/market/books
     */
    @Test
    public void getOrderBook() {
        JSONObject result = this.marketDataAPIService.getOrderBook("BTC-USD-SWAP","400");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取所有交易产品K线数据 Get Candlesticks
     * GET /api/v5/market/candles
     */
    @Test
    public void getCandlesticks() {

        JSONObject result = this.marketDataAPIService.getCandlesticks("BTC-USD-SWAP","1618468839819",null,"2H","20");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取交易产品历史K线数据（仅主流币） Get Candlesticks History（top currencies only）
     * GET /api/v5/market/history-candles
     */
    @Test
    public void getCandlesticksHistory() {
        JSONObject result = this.marketDataAPIService.getCandlesticksHistory("BTC-USDT-210625", null, null, "1m", "12");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取指数K线数据 Get Index Candlesticks
     * GET /api/v5/market/index-candles
     */
    @Test
    public void getIndexCandlesticks() {
        JSONObject result = this.marketDataAPIService.getIndexCandlesticks("BTC-USDT","","","1H","5");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取标记价格K线数据 Get Mark Price Candlesticks
     * /api/v5/market/mark-price-candles
     */
    @Test
    public void getMarkPriceCandlesticks() {
        JSONObject result = this.marketDataAPIService.getMarkPriceCandlesticks("EOS-USDT",null,null,"15m","81");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }


    /**
     * 获取交易产品公共成交数据 Get Trades
     * GET /api/v5/market/trades
     */
    @Test
    public void getTrades() {
        JSONObject result = this.marketDataAPIService.getTrades("BTC-USDT-SWAP","");
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }

    /**
     * 获取平台24小时总成交量 Get total volume
     * GET /api/v5/market/platform-24-volume
     */
    @Test
    public void getTotalVolume() {
        JSONObject result = this.marketDataAPIService.getTotalVolume();
        this.toResultString(MarketDataAPITest.LOG, "result", result);
    }




}
