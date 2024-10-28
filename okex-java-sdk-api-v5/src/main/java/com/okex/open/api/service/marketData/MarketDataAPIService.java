package com.okex.open.api.service.marketData;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.market.result.BinanceCandlestick;
import com.okex.open.api.enums.BinanceInternal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface MarketDataAPIService {

    //获取所有产品行情信息 Get Tickers
    JSONObject getTickers(String instType,String instFamily,String uly);

    //获取单个产品行情信息 Get Ticker
    JSONObject getTicker(String instId);

    //获取指数行情数据 Get Index Tickers
    JSONObject getIndexTickers(String quoteCcy,String instId);

    //获取产品深度 Get Order Book
    JSONObject getOrderBook(String instId,String sz);

    //获取产品轻量深度 Get order lite book
    JSONObject getOrderLiteBook(@Query("instId") String instId);

    //获取所有交易产品K线数据 Get Candlesticks
    JSONObject getCandlesticks(String instId,String after,String before,String bar,String limit);

    //获取交易产品历史K线数据（仅主流币） Get Candlesticks History（top currencies only）
    JSONObject getCandlesticksHistory(String instId,String after,String before,String bar,String limit);

    //获取指数K线数据 Get Index Candlesticks
    JSONObject getIndexCandlesticks(String instId,String after,String before,String bar,String limit);

    //获取指数历史K线数据 Get index candlesticks history
    JSONObject getIndexCandlesticksHistory(String instId,String after,String before,String bar,String limit);

    //获取标记价格K线数据 Get Mark Price Candlesticks
    JSONObject getMarkPriceCandlesticks(String instId,String after,String before,String bar,String limit);

    //获取标记价格历史K线数据 Get mark price candlesticks history
    JSONObject getMarkPriceCandlesticksHistory(String instId,String after,String before,String bar,String limit);

    //获取交易产品公共成交数据 Get Trades
    JSONObject getTrades(String instId,String limit);

    //获取交易产品公共历史成交数据 Get trades history
    JSONObject getTradesHistory(String instId,String after, String before,String limit,String type);

    //获取平台24小时总成交量 Get total volume
    JSONObject getTotalVolume();

    //Oracle 上链交易数据 Get Oracle
    JSONObject getOracle();

    //获取法币汇率  Get exchange rate
    JSONObject getExchangeRate();

    //获取指数成分数据  Get index components
    JSONObject getIndexComponents(String index);

    //获取大宗交易所有产品行情信息  Get block tickers
    JSONObject getBlockTickers(@Query("instType") String instType,@Query("uly") String uly,@Query("instFamily") String instFamily);

    //获取大宗交易单个产品行情信息  Get block ticker
    JSONObject getBlockTicker(@Query("instId") String instId);

    //获取大宗交易公共成交数据  Get block trades
    JSONObject getBlockTrades(@Query("instId") String instId);

    JSONObject getInstrumentFamilyTrades(String instFamily);

    JSONObject getBooksFull(String instId, String sz);

    JSONObject getCallAuctionDetails(String instId);
}
