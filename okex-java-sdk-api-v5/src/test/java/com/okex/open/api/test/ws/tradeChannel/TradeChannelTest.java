package com.okex.open.api.test.ws.tradeChannel;


import com.okex.open.api.test.ws.tradeChannel.config.WebSocketClient;
import com.okex.open.api.test.ws.tradeChannel.config.WebSocketConfig;
import org.apache.commons.compress.utils.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TradeChannelTest {

    private static final WebSocketClient webSocketClient = new WebSocketClient();

    @Before
    public void connect() {
        WebSocketConfig.loginConnect(webSocketClient);
    }

    @After
    public void close() {
        System.out.println(Instant.now().toString() + "Trade channel close connect!");
        WebSocketClient.closeConnection();
    }

    /**
     * 下单
     * Place Order
     */
    @Test
    public void wsPlaceOrder() {

        ArrayList<Map> placeOrder= new ArrayList<>();
        Map order =new HashMap();


        order.put("instId","LTC-USDT-SWAP");
        order.put("tdMode","cross");
//        order.put("ccy","USDT");
        order.put("clOrdId","OK2104230918290804");
//        order.put("tag","111");

        order.put("side","sell");
        order.put("posSide","short");
        order.put("ordType","market");
//        order.put("px","2");
        order.put("sz","1");
//        order.put("reduceOnly",false);

        placeOrder.add(order);

        //订阅
        WebSocketClient.wsPlaceOrder(placeOrder,"test123");
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 批量下单
     * Place Multiple Orders
     */
    @Test
    public void wsPlaceMultipleOrders() {

        ArrayList<Map> placeMultipleOrders= new ArrayList<>();
        Map order1 =new HashMap();

        order1.put("instId","BTC-USDT");
        order1.put("tdMode","isolated");
//        order1.put("ccy","USDT");
//        order1.put("clOrdId","testSpot123");
//        order1.put("tag","111");

        order1.put("side","sell");
//        order1.put("posSide","net");
        order1.put("ordType","limit");
        order1.put("px","20000");
        order1.put("sz","1");
        order1.put("reduceOnly",false);

        Map order2 =new HashMap();
        order2.put("instId","BTC-USDT");
        order2.put("tdMode","isolated");
//        order2.put("ccy","USDT");
//        order2.put("clOrdId","testSpot123");
//        order2.put("tag","111");
        order2.put("side","sell");
//        order2.put("posSide","net");
        order2.put("ordType","limit");
        order2.put("px","20000");
        order2.put("sz","1");
        order2.put("reduceOnly",false);

        placeMultipleOrders.add(order1);
        placeMultipleOrders.add(order2);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //订阅同时设置id
        WebSocketClient.wsPlaceMultipleOrders(placeMultipleOrders,"testPlaceMultipleOrders");
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 撤单
     * Cancel Order
     */
    @Test
    public void wsCancelOrder() {

        ArrayList<Map> cancelOrder= new ArrayList<>();
        Map order =new HashMap();

        order.put("instId","BTC-USDT");
        order.put("ordId","258542316990898178");
//        order.put("clOrdId","test123");


        cancelOrder.add(order);

        //订阅
        WebSocketClient.wsCancelOrder(cancelOrder,"testwscancelorder2020");
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * 批量撤单
     * Cancel Multiple Orders
     */
    @Test
    public void wsCancelMultipleOrders() {

        ArrayList<Map> cancelOrder= new ArrayList<>();
        Map order1 =new HashMap();

        order1.put("instId","BTC-USDT");
        order1.put("ordId","258542316990898178");
//        order1.put("clOrdId","test123");

        Map order2 =new HashMap();

        order2.put("instId","BTC-USDT-201225");
        order2.put("ordId","2517748155771904");
//        order2.put("clOrdId","test456");


        cancelOrder.add(order1);
        cancelOrder.add(order2);

        //订阅
        WebSocketClient.wsCancelMultipleOrders(cancelOrder,"testwsCancelMultipleOrders2020");
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 改单
     * Amend Order
     */
    @Test
    public void wsAmendOrder() {

        ArrayList<Map> cancelOrder= new ArrayList<>();
        Map order =new HashMap();

        order.put("instId","BTC-USDT");
//        order.put("cxlOnFail",false);
        order.put("ordId","258542316990898178");
//        order.put("clOrdId","test123");
//        order.put("reqId","123456");
        order.put("newPx","23498");
        order.put("newSz","3.6");


        cancelOrder.add(order);

        //订阅
        WebSocketClient.wsAmendOrder(cancelOrder,"testwsAmendOrder2020");
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 批量改单
     * Amend Multiple Orders
     */
    @Test
    public void wsAmendMultipleOrders() {

        ArrayList<Map> cancelOrder= new ArrayList<>();
        Map order1 =new HashMap();

        order1.put("instId","BTC-USDT");
//        order1.put("cxlOnFail",false);
        order1.put("ordId","258542316990898178");
//        order1.put("clOrdId","test123");
//        order1.put("reqId","123456");
        order1.put("newPx","23498");
        order1.put("newSz","3.6");

        Map order2 =new HashMap();

        order2.put("instId","BTC-USDT");
//        order2.put("cxlOnFail",false);
        order2.put("ordId","258542316990898178");
//        order2.put("clOrdId","test123");
//        order2.put("reqId","123456");
        order2.put("newPx","23498");
        order2.put("newSz","3.6");

        cancelOrder.add(order1);
        cancelOrder.add(order2);

        //订阅
        WebSocketClient.wsAmendMultipleOrders(cancelOrder,"testwsAmendMultipleOrders2020");
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
