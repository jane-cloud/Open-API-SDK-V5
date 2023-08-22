package com.okex.open.api.test.ws.privateChannel;


import com.okex.open.api.test.ws.privateChannel.config.WebSocketClient;
import com.okex.open.api.test.ws.privateChannel.config.WebSocketConfig;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrivateChannelTest {
    private static final WebSocketClient webSocketClient = new WebSocketClient();
    private static Logger logger = Logger.getLogger(PrivateChannelTest.class);

    @Before
    public void connect() {
        WebSocketConfig.loginConnect(webSocketClient);

    }


    @After
    public void close() {
        System.out.println(Instant.now().toString() + "Private channels close connect!");
        WebSocketClient.closeConnection();
    }

    /**
     * 账户频道
     * Account Channel
     */
    @Test
    public void privateAccountChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map accountMap =new HashMap();

           accountMap.put("channel","account");
           accountMap.put("ccy","BNB");


        accountMap.put("extraParams","{updateInterval:0}");

        channelList.add(accountMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 持仓频道
     * Positions Channel
     */
    @Test
    public void privatePositionsChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map positionsMap =new HashMap();

        positionsMap.put("channel","positions");
        positionsMap.put("instType","SWAP");
        positionsMap.put("instFamily","XRP-USDT");
        positionsMap.put("instId","XRP-USDT-SWAP");

        positionsMap.put("extraParams","{updateInterval:0}");

        channelList.add(positionsMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 账户余额和持仓频道
     * Balance and Position Channel
     */
    @Test
    public void privateBalanceAndPositionChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map orderMap =new HashMap();

        orderMap.put("channel","balance_and_position");

        channelList.add(orderMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 订单频道
     * Order Channel
     */
    @Test
    public void privateOrderChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map orderMap =new HashMap();

        orderMap.put("channel","orders");
        orderMap.put("instType","SWAP");
        orderMap.put("instFamily","XRP-USDT");
        orderMap.put("instId","XRP-USDT-SWAP");

        channelList.add(orderMap);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 策略委托订单频道
     * Algo Orders Channel
     */
    @Test
    public void privateAlgoOrdersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map algoOrders =new HashMap();

        algoOrders.put("channel","orders-algo");
        algoOrders.put("instType","FUTURES");
        algoOrders.put("instFamily","BTC-USDT");
        algoOrders.put("instId","BTC-USDT-210625");

        channelList.add(algoOrders);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 高级策略委托订单频道
     * Advance Algo Orders Channel
     */
    @Test
    public void privateAlgoAdvanceOrdersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map algoOrders =new HashMap();

        algoOrders.put("channel","algo-advance");
        algoOrders.put("instType","SWAP");
        algoOrders.put("instId","BTC-USDT-SWAP");
//        algoOrders.put("algoId","");

        channelList.add(algoOrders);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 爆仓风险预警推送频道
     * Position risk warning
     */
    @Test
    public void positionRiskWarningChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map liquidationWarning =new HashMap();

        liquidationWarning.put("channel","liquidation-warning");
        liquidationWarning.put("instType","SWAP");
        liquidationWarning.put("instFamily","BTC-USDT");
        liquidationWarning.put("instId","BTC-USDT-SWAP");

        channelList.add(liquidationWarning);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 账户greeks频道
     * account-greeks
     * 获取账户资产的greeks信息，首次订阅按照订阅维度推送数据，此外，当增加或者减少币种余额、持仓数量等事件触发时，推送数据以及按照订阅维度定时推送数据
     */
    @Test
    public void accountGreeks() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map accountGreeks =new HashMap();

        accountGreeks.put("channel","account-greeks");
        accountGreeks.put("ccy","USDT");

        channelList.add(accountGreeks);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 充值信息频道
     * Deposit Info Channel
     */
    @Test
    public void depositInfoChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map depositInfo =new HashMap();

        depositInfo.put("channel","deposit-info");
        depositInfo.put("ccy","BTC");

        channelList.add(depositInfo);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提币信息频道
     * Withdrawal info channel
     */
    @Test
    public void withdrawalInfoChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map withdrawalInfoChannel =new HashMap();

        withdrawalInfoChannel.put("channel","withdrawal-info");
        withdrawalInfoChannel.put("ccy","BTC");

        channelList.add(withdrawalInfoChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 询价频道
     * Rfqs channel
     */
    @Test
    public void rfqsChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map rfqsChannel =new HashMap();

        rfqsChannel.put("channel","rfqs");

        channelList.add(rfqsChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 报价频道
     * Quotes  channel
     */
    @Test
    public void quotesChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map quotesChannel =new HashMap();

        quotesChannel.put("channel","quotes");

        channelList.add(quotesChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 大宗交易频道
     * Structure block trades channel
     */
    @Test
    public void strucBlockTradesChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map strucBlockTradesChannel =new HashMap();

        strucBlockTradesChannel.put("channel","struc-block-trades");

        channelList.add(strucBlockTradesChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 现货网格策略委托订单频道
     * Spot grid algo orders channel
     */
    @Test
    public void gridOrdersSpotChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map gridOrdersSpotChannel =new HashMap();

        gridOrdersSpotChannel.put("channel","grid-orders-spot");
        gridOrdersSpotChannel.put("instType","SPOT");
        gridOrdersSpotChannel.put("instId","BTC-USDT");
        gridOrdersSpotChannel.put("algoId",null);

        channelList.add(gridOrdersSpotChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 合约网格策略委托订单频道
     * Contract grid algo orders channel
     */
    @Test
    public void gridOrdersContractChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map gridOrdersContractChannel =new HashMap();

        gridOrdersContractChannel.put("channel","grid-orders-contract");
        gridOrdersContractChannel.put("instType","SWAP");
        gridOrdersContractChannel.put("instId","BTC-USDT-SWAP");
        gridOrdersContractChannel.put("algoId",null);

        channelList.add(gridOrdersContractChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 天地网格策略委托订单频道
     * Moon grid algo orders channel
     */
    @Test
    public void gridOrdersMoonChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map gridOrdersMoonChannel =new HashMap();

        gridOrdersMoonChannel.put("channel","grid-orders-moon");
        gridOrdersMoonChannel.put("instType","SPOT");
        gridOrdersMoonChannel.put("instId","BTC-USDT");
        gridOrdersMoonChannel.put("algoId",null);

        channelList.add(gridOrdersMoonChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 合约网格持仓频道
     * Grid positions channel
     */
    @Test
    public void gridPositionsChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map gridPositionsChannel =new HashMap();

        gridPositionsChannel.put("channel","grid-positions");
        gridPositionsChannel.put("algoId","");

        channelList.add(gridPositionsChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 网格策略子订单频道
     * Grid sub orders channel
     */
    @Test
    public void gridSubOrdersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map gridSubOrdersChannel =new HashMap();

        gridSubOrdersChannel.put("channel","grid-sub-orders");
        gridSubOrdersChannel.put("algoId","");

        channelList.add(gridSubOrdersChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 定投策略委托订单频道
     * algo-recurring-buy
     */
    @Test
    public void recurringOrdersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();
        Map recurringOrdersChannel =new HashMap();

        recurringOrdersChannel.put("channel","algo-recurring-buy");
        recurringOrdersChannel.put("algoId","");
        recurringOrdersChannel.put("instType","");

        channelList.add(recurringOrdersChannel);

        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*   价差撮合订单频道
    *   sprd-orders
    *
    *
    * */
    @Test
    public void SprdOrdersChannel() {
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","sprd-orders");
        map.put("sprdId","");
        channelList.add(map);
        WebSocketClient.unsubscribe(channelList);
        //为保证收到服务端返回的消息，需要让线程延迟
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*   价差撮合成交数据頻道
     *   sprd-trades
     *
     *
     * */
    @Test
    public void SprdTradesChannel() {
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","sprd-trades");
        map.put("sprdId","");
        channelList.add(map);
        WebSocketClient.unsubscribe(channelList);
        //为保证收到服务端返回的消息，需要让线程延迟
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //取消订阅
    @Test
    public void unsubscribeChannel() {
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","balance_and_position");
        map.put("instId","BTC-USD-210924");
        channelList.add(map);
        WebSocketClient.unsubscribe(channelList);
        //为保证收到服务端返回的消息，需要让线程延迟
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
