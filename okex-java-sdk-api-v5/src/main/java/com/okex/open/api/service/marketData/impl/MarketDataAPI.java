package com.okex.open.api.service.marketData.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.market.result.BinanceCandlestick;
import com.okex.open.api.enums.BinanceInternal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

interface MarketDataAPI {

    //获取所有产品行情信息 Get Tickers
    @GET("/api/v5/market/tickers")
    Call<JSONObject> getTickers(@Query("instType") String instType, @Query("uly") String uly);

    //获取单个产品行情信息 Get Ticker
    @GET("/api/v5/market/ticker")
    Call<JSONObject> getTicker(@Query("instId")String instId);

    //获取指数行情数据 Get Index Tickers
    @GET("/api/v5/market/index-tickers")
    Call<JSONObject> getIndexTickers(@Query("quoteCcy")String quoteCcy,@Query("instId")String instId);


    //获取产品深度 Get Order Book
    @GET("/api/v5/market/books")
    Call<JSONObject> getOrderBook(@Query("instId") String instId,@Query("sz") String sz);

    //获取所有交易产品K线数据 Get Candlesticks
    @GET("/api/v5/market/candles")
    Call<JSONObject> getCandlesticks(@Query("instId")String instId,@Query("after")String after,@Query("before")String before,@Query("bar")String bar,@Query("limit")String limit);

    //获取交易产品历史K线数据（仅主流币） Get Candlesticks History（top currencies only）
    @GET("/api/v5/market/history-candles")
    Call<JSONObject> getCandlesticksHistory(@Query("instId") String instId,@Query("after")String after,@Query("before")String before,@Query("bar")String bar,@Query("limit")String limit);

    //获取指数K线数据 Get Index Candlesticks
    @GET("/api/v5/market/index-candles")
    Call<JSONObject> getIndexCandlesticks(@Query("instId") String instId,@Query("after")String after,@Query("before")String before,@Query("bar")String bar,@Query("limit")String limit);

    //获取标记价格K线数据 Get Mark Price Candlesticks
    @GET("/api/v5/market/mark-price-candles")
    Call<JSONObject> getMarkPriceCandlesticks(@Query("instId") String instId,@Query("after")String after,@Query("before")String before,@Query("bar")String bar,@Query("limit")String limit);


    //获取交易产品公共成交数据 Get Trades
    @GET("/api/v5/market/trades")
    Call<JSONObject> getTrades(@Query("instId") String instId,@Query("limit") String limit);

    //获取平台24小时总成交量 Get total volume
    @GET("/api/v5/market/platform-24-volume")
    Call<JSONObject> getTotalVolume();



}
