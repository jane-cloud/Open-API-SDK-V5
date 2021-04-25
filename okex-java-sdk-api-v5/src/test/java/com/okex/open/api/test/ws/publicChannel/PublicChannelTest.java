package com.okex.open.api.test.ws.publicChannel;

import com.okex.open.api.test.ws.publicChannel.config.WebSocketClient;
import com.okex.open.api.test.ws.publicChannel.config.WebSocketConfig;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PublicChannelTest {

    private static final WebSocketClient webSocketClient = new WebSocketClient();

    private static Logger logger = Logger.getLogger(PublicChannelTest.class);
    @Before
    public void connect() {
        //与服务器建立连接
        WebSocketConfig.publicConnect(webSocketClient);
    }

    @After
    public void close() {
        System.out.println(Instant.now().toString() + "Public channels close connect!");
        WebSocketClient.closeConnection();
    }


    /**
     * 公共-产品频道
     * Instruments Channel
     */
    @Test
    public void instrumentsChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","instruments");
        map.put("instType","SPOT");

        channelList.add(map);
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
     * 行情频道
     * Tickers Channel
     */
    @Test
    public void tickersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();


        Map spotTickerMap = new HashMap();
        spotTickerMap.put("channel","tickers");
        spotTickerMap.put("instId","FIL-USD-SWAP");


        channelList.add(spotTickerMap);


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
     * 持仓总量频道
     * Open interest Channel
     */
    @Test
    public void openInterestChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","open-interest");
        map.put("instId","BTC-USDT-210924");

        channelList.add(map);
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
     * K线频道
     * Candlesticks Channel
     */
    @Test
    public void candleChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","candle5m");
        map.put("instId","BTC-USDT-210924");

        channelList.add(map);
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
     * 交易频道
     * Trades Channel
     */
    @Test
    public void tradesChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","trades");
        map.put("instId","BTC-USDT-210625");

        Map map1 =new HashMap();
        map1.put("channel","trades");
        map1.put("instId","BTC-USD-210625");

        channelList.add(map);
        channelList.add(map1);
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
     * 预估交割/行权价格频道
     * Estimated delivery/exercise Price Channel
     */
    @Test
    public void estimatedPriceChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","estimated-price");
        map.put("instType","OPTION");
        map.put("uly","BTC-USD");

        channelList.add(map);
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
     * 标记价格频道
     * Mark Price Channel
     */
    @Test
    public void markPriceChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","mark-price");
        map.put("instId","BTC-USDT-210326");

        channelList.add(map);
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
     * 标记价格K线频道
     * Mark Price Candlesticks Channel
     */
    @Test
    public void markPriceCandleChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","mark-price-candle1m");
        map.put("instId","BTC-USD-210326");

        channelList.add(map);
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
     * 限价频道
     * Price Limit Channel
     */
    @Test
    public void priceLimitChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","price-limit");
        map.put("instId","BTC-USDT-210326");

        channelList.add(map);
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
     * 公共-深度频道(5档)
     * Order Book Channel
     */
    @Test
    public void books5Channel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","books5");
        map.put("instId","BTC-USDT");

        channelList.add(map);
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
     * 公共-深度频道(400档)
     * Order Book Channel
     */
    @Test
    public void booksChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","books");
        map.put("instId","BTC-USDT");

        channelList.add(map);
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
     * 公共-深度频道(400档增量)
     * Order Book Channel
     */
    @Test
    public void booksl2tbtChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","books-l2-tbt");
        map.put("instId","BTC-USDT-210625");

        channelList.add(map);
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
     * 公共-深度频道(50档增量)
     * Order Book Channel
     */
    @Test
    public void books50l2tbtChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","books50-l2-tbt");
        map.put("instId","BTC-USDT-210625");

        channelList.add(map);
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
     * 公共-期权定价频道
     * OPTION Summary Channel
     */
    @Test
    public void optSummaryChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","opt-summary");
        map.put("uly","BTC-USD");

        channelList.add(map);
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
     * 公共-资金费率频道
     * Funding Rate Channel
     */
    @Test
    public void fundingRateChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","funding-rate");
        map.put("instId","BTC-USDT-SWAP");

        channelList.add(map);
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
     * 公共-指数K线频道
     * Index Candlesticks Channel
     */
    @Test
    public void indexCandleChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","index-candle30m");
        map.put("instId","BTC-USDT");

        channelList.add(map);
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
     * 公共-指数行情频道
     * Retrieve index tickers data
     */
    @Test
    public void indexTickersChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","index-tickers");
        map.put("instId","BTC-USDT");

        channelList.add(map);
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
     * Status 频道
     * Status Channel
     */
    @Test
    public void statusChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","status");

        channelList.add(map);
        //调用订阅方法
        WebSocketClient.subscribe(channelList);
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //取消订阅
    @Test
    public void unsubscribeChannel() {
        //添加订阅频道
        ArrayList<Map> channelList= new ArrayList<>();

        Map map =new HashMap();
        map.put("channel","index-tickers");
        map.put("instId","BTC-USDT");

        channelList.add(map);
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
