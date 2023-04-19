package com.okex.open.api.test.recurring;


import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.recurringTrading.Recurring;
import com.okex.open.api.bean.recurringTrading.RecurringAlgoOrder;
import com.okex.open.api.service.recurring.RecurringAPIService;
import com.okex.open.api.service.recurring.impl.RecurringAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RecurringAPITest extends RecurringAPIBaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(RecurringAPITest.class);

    private RecurringAPIService recurringAPIService;

    @Before
    public void before() {
        config = config();
        recurringAPIService = new RecurringAPIServiceImpl(config);
    }
    /**
     * 定投策略委托下单
     * POST /api/v5/tradingBot/recurring/order-algo
     */
    @Test
    public void placeOrderAlgo(){

        RecurringAlgoOrder recurringOrder =new RecurringAlgoOrder();
        recurringOrder.setStgyName("cesi123154");
        Recurring recurring = new Recurring();
        recurring.setCcy("OKB");
        recurring.setRatio("1");
        List<Recurring> list = new ArrayList<Recurring>();
        list.add(recurring);
        recurringOrder.setRecurringList(list);
        recurringOrder.setPeriod("daily");
        recurringOrder.setRecurringDay("1");
        recurringOrder.setRecurringTime("2");
        recurringOrder.setAlgoClOrdId("");
        recurringOrder.setTag("");
        recurringOrder.setTimeZone("8");
        recurringOrder.setAmt("100");
        recurringOrder.setTdMode("cash");
        recurringOrder.setInvestmentCcy("USDT");
        JSONObject result = recurringAPIService.placeOrderAlgo(recurringOrder);

        toResultString(LOG, "result", result);
    }
    /**
     * 修改定投策略订单
     * POST /api/v5/tradingBot/recurring/amend-order-algo
     */
    @Test
    public void amendOrderAlgo(){


        Recurring recurring = new Recurring();
        recurring.setAlgoId("568856532780318720");
        recurring.setStgyName("test123");
        JSONObject result = recurringAPIService.amendOrderAlgo(recurring);

        toResultString(LOG, "result", result);
    }
    /**
     * 定投策略停止
     * POST /api/v5/tradingBot/recurring/stop-order-algo
     */
    @Test
    public void stopOrderAlgo(){

        List<Recurring> list = new ArrayList<>();
        Recurring recurring = new Recurring();
        recurring.setAlgoId("568856532780318720");
        list.add(recurring);
       /* Recurring recurring2 = new Recurring();
        recurring2.setAlgoId("");
        list.add(recurring2);*/
        JSONObject result = recurringAPIService.stopOrderAlgo(list);

        toResultString(LOG, "result", result);
    }
    /**
     * 获取未完成定投策略委托单列表
     * GET /api/v5/tradingBot/recurring/orders-algo-pending
     */
    @Test
    public void getOrderAlgoPending(){

        JSONObject result = recurringAPIService.getOrderAlgoPending("","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取历史定投策略委托单列表
     * GET /api/v5/tradingBot/recurring/orders-algo-history
     */
    @Test
    public void getOrderAlgoHistory(){

        JSONObject result = recurringAPIService.getOrderAlgoHistory("","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 获取定投策略委托订单详情
     * GET /api/v5/tradingBot/recurring/orders-algo-details
     */
    @Test
    public void getOrderAlgoDetails(){

        JSONObject result = recurringAPIService.getOrderAlgoDetails("568856532780318720");

        toResultString(LOG, "result", result);
    }

    /**
     * 获取定投策略子订单信息
     * GET /api/v5/tradingBot/recurring/sub-orders
     */
    @Test
    public void getSubOrders(){

        JSONObject result = recurringAPIService.getSubOrders("568856532780318720","","","","");

        toResultString(LOG, "result", result);
    }
}
