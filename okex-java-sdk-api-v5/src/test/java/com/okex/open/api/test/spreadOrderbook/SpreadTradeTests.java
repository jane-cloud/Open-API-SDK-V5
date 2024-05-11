package com.okex.open.api.test.spreadOrderbook;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.spread.SpreadOrder;
import com.okex.open.api.service.spreadOrderbook.SpreadTradeService;
import com.okex.open.api.service.spreadOrderbook.impl.SpreadTradeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpreadTradeTests extends SpreadTradeBaseTests {
    private static final Logger LOG = LoggerFactory.getLogger(SpreadTradeTests.class);

    private SpreadTradeService spreadTradeService;

    @Before
    public void before() {
        config = config();
        spreadTradeService = new SpreadTradeServiceImpl(config);
    }

    /**
     * 下单  Order
     * POST /api/v5/sprd/order
     */
    @Test
    public void placeSprdOrder(){

        SpreadOrder placeOrder =new SpreadOrder();
        placeOrder.setSprdId("BTC-USDT_BTC-USDT-SWAP");
        placeOrder.setClOrdId("0423a3a06···");
        placeOrder.setTag("");
        placeOrder.setSide("sell");
        placeOrder.setOrdType("market");
        placeOrder.setSz("1");
        placeOrder.setPx("");


        JSONObject result = spreadTradeService.placeSprdOrder(placeOrder);

        toResultString(LOG, "result", result);
    }
    /**
     * 撤单  cancel-order
     * POST /api/v5/sprd/cancel-order
     */
    @Test
    public void cancelSprdOrder(){

        SpreadOrder cancelSprdOrder =new SpreadOrder();
        cancelSprdOrder.setOrdId("");
        cancelSprdOrder.setClOrdId("");


        JSONObject result = spreadTradeService.cancelSprdOrder(cancelSprdOrder);

        toResultString(LOG, "result", result);
    }

    /**
     * 全部撤单  mass-cancel
     * POST /api/v5/sprd/mass-cancel
     */
    @Test
    public void massCancelSprdOrder(){

        SpreadOrder massCancel =new SpreadOrder();
        massCancel.setSprdId("");

        JSONObject result = spreadTradeService.massCancelSprdOrder(massCancel);

        toResultString(LOG, "result", result);
    }

    /**
     * 获取订单信息
     * GET /api/v5/sprd/order
     */
    @Test
    public void getSprdOrder(){

        JSONObject result = spreadTradeService.getSprdOrder("","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取未成交订单列表 orders-pending
     * GET /api/v5/sprd/orders-pending
     */
    @Test
    public void getOrdersPending(){

        JSONObject result = spreadTradeService.getOrdersPending("","","","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取历史订单记录（近七天) orders-history
     * GET /api/v5/sprd/orders-history
     */
    @Test
    public void getOrdersHistory(){

        JSONObject result = spreadTradeService.getOrdersHistory("","","","","","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取历史成交数据（近七天）trades
     * GET /api/v5/sprd/trades
     */
    @Test
    public void getTrades(){

        JSONObject result = spreadTradeService.getTrades("","","","","","","","");

        toResultString(LOG, "result", result);
    }

    /**
     * 获取Spreads（公共）spreads
     * GET /api/v5/sprd/spreads
     */
    @Test
    public void getPublicSpreads(){

        JSONObject result = spreadTradeService.getPublicSpreads("","","","");

        toResultString(LOG, "result", result);
    }

    /**
     * 获取Spread产品深度（公共）books
     * GET /api/v5/sprd/books
     */
    @Test
    public void getPublicBooks(){

        JSONObject result = spreadTradeService.getPublicBooks("","");

        toResultString(LOG, "result", result);
    }

    /**
     * 获取单个Spread产品行情信息（公共）books
     * GET /api/v5/sprd/ticker
     */
    @Test
    public void getPublicTicker(){

        JSONObject result = spreadTradeService.getPublicTicker("");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取单个Spread产品行情信息（公共）public-trades
     * GET /api/v5/sprd/public-trades
     */
    @Test
    public void getPublicTrades(){

        JSONObject result = spreadTradeService.getPublicTrades("");

        toResultString(LOG, "result", result);
    }

    /**
     * 修改订单  amend-order
     * POST /api/v5/sprd/amend-order
     */
    @Test
    public void amendOrder(){

        SpreadOrder amendOrder =new SpreadOrder();
        amendOrder.setReqId("");
        amendOrder.setOrdId("");
        amendOrder.setClOrdId("");
        amendOrder.setNewPx("");
        amendOrder.setNewSz("");
        JSONObject result = spreadTradeService.amendOrder(amendOrder);

        toResultString(LOG, "result", result);
    }
    /**
     * 获取历史订单记录（近三月)orders-history-archive
     * GET /api/v5/sprd/orders-history-archive
     */
    @Test
    public void getOrdersHistoryArchive(){

        JSONObject result = spreadTradeService.getOrdersHistoryArchive("","","","","","","","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取价差交易产品历史K线数据sprd-history-candles
     * GET /api/v5/market/sprd-history-candles
     */
    @Test
    public void getSprdHistoryCandles(){

        JSONObject result = spreadTradeService.getSprdHistoryCandles("","","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取价差交易产品K线数据sprd-candles
     * GET /api/v5/market/sprd-candles
     */
    @Test
    public void getSprdCandles(){

        JSONObject result = spreadTradeService.getSprdCandles("","","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取单个Spread产品行情信息（公共）sprd-ticker
     * GET /api/v5/market/sprd-ticker
     */
    @Test
    public void getSprdTicker(){

        JSONObject result = spreadTradeService.getSprdTicker("");

        toResultString(LOG, "result", result);
    }

}
