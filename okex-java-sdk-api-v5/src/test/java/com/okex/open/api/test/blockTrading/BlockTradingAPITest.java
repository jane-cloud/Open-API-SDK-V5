package com.okex.open.api.test.blockTrading;


import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.blockTrading.param.*;
import com.okex.open.api.service.blockTrading.BlockTradingAPIService;
import com.okex.open.api.service.blockTrading.impl.BlockTradingAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BlockTradingAPITest extends BlockTradingAPIBaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BlockTradingAPITest.class);

    private BlockTradingAPIService blockTradingAPIService;

    @Before
    public void before() {
        config = config();
        blockTradingAPIService = new BlockTradingAPIServiceImpl(config);
    }

    /**
     * 获取报价方信息 Get Counterparties
     * GET /api/v5/rfq/counterparties
     */
    @Test
    public void getBalance(){
        JSONObject result = this.blockTradingAPIService.getCounterparties();
        toResultString(LOG, "result", result);
    }

    /**
     * 询价 Create RFQ
     * POST /api/v5/rfq/create-rfq
     */
    @Test
    public void createRfq(){

        List<String> counterpartiesList = new ArrayList<String>();
        counterpartiesList.add("TESTP1");
        counterpartiesList.add("TESTD1");

        Legs legs = new Legs();
        legs.setInstId("BTC-USDT");
        legs.setSide("buy");
        legs.setSz("0.1");
        legs.setTgtCcy("base_ccy");

        Legs legs1 = new Legs();
        legs1.setInstId("ETH-USDT");
        legs1.setSide("buy");
        legs1.setSz("0.4");
        legs1.setTgtCcy("base_ccy");

        List<Legs> legsList = new ArrayList<Legs>();
        legsList.add(legs);
        legsList.add(legs1);

        CreateRfq createRfq = new CreateRfq();
        createRfq.setAnonymous(true);
        createRfq.setClRfqId("20220607test004");
        createRfq.setLegs(legsList);
        createRfq.setCounterparties(counterpartiesList);

        JSONObject result = this.blockTradingAPIService.createRfq(createRfq);
        toResultString(LOG, "result", result);
    }

    /**
     * 取消询价单 Cancel RFQ
     * POST /api/v5/rfq/cancel-rfq
     */
    @Test
    public void cancelRfq(){
        CancelRfq cancelRfq = new CancelRfq();
        cancelRfq.setRfqId("3G18C1G");
//        cancelRfq.setClRfqId("20220601test001");

        JSONObject result = this.blockTradingAPIService.cancelRfq(cancelRfq);
        toResultString(LOG, "result", result);

    }

    /**
     * 批量取消询价单 Cancel multiple RFQs
     * POST /api/v5/rfq/cancel-batch-rfqs
     */
    @Test
    public void cancelBatchRfqs(){
        CancelBatchRfqs cancelBatchRfqs = new CancelBatchRfqs();

        List<String> rfqIdsList = new ArrayList<String>();
        rfqIdsList.add("3G18C20");
        rfqIdsList.add("3G18C28");


        List<String> clRfqIdsList = new ArrayList<String>();
        clRfqIdsList.add(null);
        clRfqIdsList.add(null);


        cancelBatchRfqs.setRfqIds(rfqIdsList);
        cancelBatchRfqs.setClRfqIds(clRfqIdsList);

        JSONObject result = this.blockTradingAPIService.cancelBatchRfqs(cancelBatchRfqs);
        toResultString(LOG, "result", result);

    }

    /**
     * 取消所有询价单 Cancel all RFQs
     * POST /api/v5/rfq/cancel-all-rfqs
     */
    @Test
    public void cancelAllRfqs(){
        JSONObject result = this.blockTradingAPIService.cancelAllRfqs();
        toResultString(LOG, "result", result);
    }

    /**
     * 执行报价 Execute Quote
     * POST /api/v5/rfq/execute-quote
     */
    @Test
    public void executeQuote(){
        ExecuteQuote executeQuote = new ExecuteQuote();
        executeQuote.setRfqId("3G18D0O");
        executeQuote.setQuoteId("");

        JSONObject result = this.blockTradingAPIService.executeQuote(executeQuote);
        toResultString(LOG, "result", result);
    }

    /**
     * 设置可报价产品 Set Quote products
     * POST /api/v5/rfq/maker-instrument-settings
     */
    @Test
    public void setQuoteProducts(){
        List<SetQuoteProducts> list = new ArrayList<>();

        SetQuoteProducts setQuoteProducts = new SetQuoteProducts();
        setQuoteProducts.setInstType("SWAP");
        List<Data> dataList = new ArrayList<>();

        Data data = new Data();
        data.setInstId("BTC-USDT-SWAP");
        Data data1 = new Data();
        data1.setInstId("BTC-USD-SWAP");

        dataList.add(data);
        dataList.add(data1);

        setQuoteProducts.setData(dataList);
        list.add(setQuoteProducts);


        SetQuoteProducts setQuoteProducts1 = new SetQuoteProducts();
        setQuoteProducts1.setInstType("FUTURES");
        List<Data> dataList1 = new ArrayList<>();

        Data data2 = new Data();
        data2.setInstId("BTC-USDT-220930");
        Data data3 = new Data();
        data3.setInstId("BTC-USD-221230");

        dataList1.add(data2);
        dataList1.add(data3);

        setQuoteProducts1.setData(dataList1);
        list.add(setQuoteProducts1);


        JSONObject result = this.blockTradingAPIService.setQuoteProducts(list);
        toResultString(LOG, "result", result);
    }

    /**
     * 报价 Create Quote
     * POST /api/v5/rfq/create-quote
     */
    @Test
    public void createQuote(){
        List<Legs> legsList = new ArrayList<Legs>();
        Legs legs = new Legs();
        legs.setInstId("BTC-USDT");
        legs.setSz("0.1");
        legs.setPx("29700");
        legs.setSide("buy");
        legs.setTgtCcy("base_ccy");

        legsList.add(legs);


        CreateQuote createQuote = new CreateQuote();
        createQuote.setRfqId("3G18D2G");
        createQuote.setClQuoteId("20220602testquote001");
        createQuote.setQuoteSide("buy");
        createQuote.setLegs(legsList);
        createQuote.setExpiresIn("");
        createQuote.setAnonymous(false);

        JSONObject result = this.blockTradingAPIService.createQuote(createQuote);
        toResultString(LOG, "result", result);
    }

    /**
     * 取消报价单 Cancel Quote
     * POST /api/v5/rfq/cancel-quote
     */
    @Test
    public void cancelQuote(){
        CancelQuote cancelQuote = new CancelQuote();
        cancelQuote.setClQuoteId("");
        cancelQuote.setQuoteId("");

        JSONObject result = this.blockTradingAPIService.cancelQuote(cancelQuote);
        toResultString(LOG, "result", result);
    }

    /**
     * 批量取消报价单 Cancel multiple Quotes
     * POST /api/v5/rfq/cancel-batch-quotes
     */
    @Test
    public void cancelBatchQuotes(){
        CancelBatchQuotes cancelBatchQuotes = new CancelBatchQuotes();
        List<String> quoteIdsList = new ArrayList<String>();
        List<String> clQuoteIdsList = new ArrayList<String>();

        quoteIdsList.add("");
        quoteIdsList.add("");

        clQuoteIdsList.add("");
        clQuoteIdsList.add("");

        cancelBatchQuotes.setQuoteIds(quoteIdsList);
        cancelBatchQuotes.setClQuoteIds(clQuoteIdsList);

        JSONObject result = this.blockTradingAPIService.cancelBatchQuotes(cancelBatchQuotes);
        toResultString(LOG, "result", result);
    }

    /**
     * 取消所有报价单 Cancel all Quotes
     * POST /api/v5/rfq/cancel-all-quotes
     */
    @Test
    public void cancelAllQuotes(){
        JSONObject result = this.blockTradingAPIService.cancelAllQuotes();
        toResultString(LOG, "result", result);
    }

    /**
     * 获取询价单信息 Get rfqs
     * GET /api/v5/rfq/rfqs
     */
    @Test
    public void getRfqs(){
        JSONObject result = this.blockTradingAPIService.getRfqs("","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取报价单信息 Get quotes
     * GET /api/v5/rfq/quotes
     */
    @Test
    public void getQuotes(){
        JSONObject result = this.blockTradingAPIService.getQuotes("","","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取大宗交易信息 Get trades
     * GET /api/v5/rfq/trades
     */
    @Test
    public void getTrades(){
        JSONObject result = this.blockTradingAPIService.getTrades("","","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取大宗交易公共成交数据 Get public trades
     * GET /api/v5/rfq/public-trades
     */
    @Test
    public void getPublicTrades(){
        JSONObject result = this.blockTradingAPIService.getPublicTrades("","","");
        toResultString(LOG, "result", result);
    }





}
