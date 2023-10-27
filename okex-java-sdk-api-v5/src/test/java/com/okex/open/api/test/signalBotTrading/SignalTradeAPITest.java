package com.okex.open.api.test.signalBotTrading;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.trade.param.*;
import com.okex.open.api.service.trade.TradeAPIService;
import com.okex.open.api.service.trade.impl.TradeAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SignalTradeAPITest extends SignalTradeAPIBaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(SignalTradeAPITest.class);
    private TradeAPIService tradeAPIService;

    @Before
    public void before() {
        config = config();
        tradeAPIService = new TradeAPIServiceImpl(config);
    }


    /**
     * 获取信号策略详情 Get orders-algo-details
     * GET /api/v5/tradingBot/signal/orders-algo-details
     */
    @Test
    public void getOrdersAlgoDetails(){
        JSONObject result = tradeAPIService.getOrdersAlgoDetails("","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取信号策略持仓 Get positions
     * GET /api/v5/tradingBot/grid/positions
     */
    @Test
    public void getSignalPositions(){
        JSONObject result = tradeAPIService.getSignalPositions("","");
        toResultString(LOG, "result", result);
    }

    /**
     *  获取信号策略子订单信息 Get signal sub-orders
     * GET /api/v5/tradingBot/signal/sub-orders
     */
    @Test
    public void getSignalSubOrders(){
        JSONObject result = tradeAPIService.getSignalSubOrders("","","","","","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     *获取信号策略历史事件 Get event-history
     * GET /api/v5/tradingBot/signal/event-history
     */
    @Test
    public void getSignalEventHistory(){
        JSONObject result = tradeAPIService.getSignalEventHistory("","","","");
        toResultString(LOG, "result", result);
    }
}
