package com.okex.open.api.service.blockTrading.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.blockTrading.param.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface BlockTradingAPI {

    //获取报价方信息 Get Counterparties
    @GET("/api/v5/rfq/counterparties")
    Call<JSONObject> getCounterparties();

    //询价 Create RFQ
    @POST("/api/v5/rfq/create-rfq")
    Call<JSONObject> createRfq(@Body CreateRfq createRfq);

    //取消询价单 Cancel RFQ
    @POST("/api/v5/rfq/cancel-rfq")
    Call<JSONObject> cancelRfq(@Body CancelRfq cancleRfq);

    //批量取消询价单 Cancel multiple RFQs
    @POST("/api/v5/rfq/cancel-batch-rfqs")
    Call<JSONObject> cancelBatchRfqs(@Body CancelBatchRfqs cancelBatchRfqs);

    //取消所有询价单 Cancel all RFQs
    @POST("/api/v5/rfq/cancel-all-rfqs")
    Call<JSONObject> cancelAllRfqs();

    //执行报价 Execute Quote
    @POST("/api/v5/rfq/execute-quote")
    Call<JSONObject> executeQuote(@Body ExecuteQuote executeQuote);

    //设置可报价产品 Set Quote products
    @POST("/api/v5/rfq/maker-instrument-settings")
    Call<JSONObject> setQuoteProducts(@Body List<SetQuoteProducts> setQuoteProducts);

    //重设MMP状态 Reset MMP status
    @POST("/api/v5/rfq/mmp-reset")
    Call<JSONObject> resetMMPStatus();

    //报价 Create Quote
    @POST("/api/v5/rfq/create-quote")
    Call<JSONObject> createQuote(@Body CreateQuote createQuote);

    //取消报价单 Cancel Quote
    @POST("/api/v5/rfq/cancel-quote")
    Call<JSONObject> cancelQuote(@Body CancelQuote cancelQuote);

    //批量取消报价单 Cancel multiple Quotes
    @POST("/api/v5/rfq/cancel-batch-quotes")
    Call<JSONObject> cancelBatchQuotes(@Body CancelBatchQuotes cancelBatchQuotes);

    //取消所有报价单 Cancel all Quotes
    @POST("/api/v5/rfq/cancel-all-quotes")
    Call<JSONObject> cancelAllQuotes();

    //获取询价单信息 Get rfqs
    @GET("/api/v5/rfq/rfqs")
    Call<JSONObject> getRfqs(@Query("rfqId") String rfqId,
                          @Query("clRfqId") String clRfqId,
                          @Query("state") String state,
                          @Query("beginId") String beginId,
                          @Query("endId") String endId,
                          @Query("limit") String limit);

    //获取报价单信息 Get quotes
    @GET("/api/v5/rfq/quotes")
    Call<JSONObject> getQuotes(@Query("rfqId") String rfqId,
                             @Query("clRfqId") String clRfqId,
                             @Query("quoteId") String quoteId,
                             @Query("clQuoteId") String clQuoteId,
                             @Query("state") String state,
                             @Query("beginId") String beginId,
                             @Query("endId") String endId,
                             @Query("limit") String limit);

    //获取大宗交易信息 Get trades
    @GET("api/v5/rfq/trades")
    Call<JSONObject> getTrades(@Query("rfqId") String rfqId,
                               @Query("clRfqId") String clRfqId,
                               @Query("quoteId") String quoteId,
                               @Query("clQuoteId") String clQuoteId,
                               @Query("state") String state,
                               @Query("beginId") String beginId,
                               @Query("endId") String endId,
                               @Query("limit") String limit,
                               @Query("beginTs") String beginTs,
                               @Query("endTs") String endTs);

    //获取大宗交易公共成交数据 Get public trades
    @GET("/api/v5/rfq/public-trades")
    Call<JSONObject> getPublicTrades(@Query("beginId") String beginId,
                                     @Query("endId") String endId,
                                     @Query("limit") String limit);

    @GET("/api/v5/rfq/maker-instrument-settings")
    Call<JSONObject> getMakerInstrumentSettings();
}
