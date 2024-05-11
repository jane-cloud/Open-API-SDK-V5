package com.okex.open.api.test.gridTrading;


import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.gridTrading.param.*;
import com.okex.open.api.service.gridTrading.GridTradingAPIService;
import com.okex.open.api.service.gridTrading.impl.GridTradingAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GridTradingAPITests extends GridTradingAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(GridTradingAPITests.class);

    private GridTradingAPIService gridTradingAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.gridTradingAPIService = new GridTradingAPIServiceImpl(this.config);
    }


    /**
     * 网格策略委托下单 Place grid algo order
     * POST /api/v5/tradingBot/grid/order-algo
     */
    @Test
    public void orderAlgo(){
        OrderAlgo orderAlgo = new OrderAlgo();
        orderAlgo.setInstId("");
        orderAlgo.setAlgoOrdType("");
        orderAlgo.setMaxPx("");
        orderAlgo.setMinPx("");
        orderAlgo.setGridNum("");
        orderAlgo.setRunType("");
        orderAlgo.setTpTriggerPx("");
        orderAlgo.setSlTriggerPx("");
        orderAlgo.setTag("");

        //现货网格
        orderAlgo.setQuoteSz("");
        orderAlgo.setBaseSz("");

        //合约网格
        orderAlgo.setSz("");
        orderAlgo.setDirection("");
        orderAlgo.setLever("");
        orderAlgo.setBasePos("");
        orderAlgo.setTpRatio("");
        orderAlgo.setSlRatio("");

        JSONObject result = this.gridTradingAPIService.orderAlgo(orderAlgo);
        toResultString(LOG, "result", result);
    }

    /**
     * 修改网格策略订单 Amend grid algo order
     * POST /api/v5/tradingBot/grid/amend-order-algo
     */
    @Test
    public void amendOrderAlgo(){
        AmendOrderAlgo amendOrderAlgo = new AmendOrderAlgo();
        amendOrderAlgo.setAlgoId("");
        amendOrderAlgo.setInstId("");
        amendOrderAlgo.setSlTriggerPx("");
        amendOrderAlgo.setTpTriggerPx("");
        amendOrderAlgo.setTpRatio("");
        amendOrderAlgo.setSlRatio("");

        JSONObject result = this.gridTradingAPIService.amendOrderAlgo(amendOrderAlgo);
        toResultString(LOG, "result", result);

    }

    /**
     * 网格策略停止 Stop grid algo order
     * POST /api/v5/tradingBot/grid/stop-order-algo
     */
    @Test
    public void stopOrderAlgo(){
        StopOrderAlgo stopOrderAlgo = new StopOrderAlgo();
        stopOrderAlgo.setAlgoId("");
        stopOrderAlgo.setInstId("");
        stopOrderAlgo.setAlgoOrdType("");
        stopOrderAlgo.setStopType("");

        JSONObject result = this.gridTradingAPIService.stopOrderAlgo(stopOrderAlgo);
        toResultString(LOG, "result", result);

    }

    /**
     * 获取未完成网格策略委托单列表 Get grid algo order list
     * GET /api/v5/tradingBot/grid/orders-algo-pending
     */
    @Test
    public void getGridAlgoOrderList(){
        JSONObject result = this.gridTradingAPIService.getGridAlgoOrderList("","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取历史网格策略委托单列表 Get grid algo order history
     * GET /api/v5/tradingBot/grid/orders-algo-history
     */
    @Test
    public void getGridAlgoOrderHistory(){
        JSONObject result = this.gridTradingAPIService.getGridAlgoOrderHistory("","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取网格策略委托订单详情 Get grid algo order details
     * GET /api/v5/tradingBot/grid/orders-algo-details
     */
    @Test
    public void getOrdersAlgoDetails(){
        JSONObject result = this.gridTradingAPIService.getOrdersAlgoDetails("","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取网格策略委托子订单信息 Get grid algo sub orders
     * GET /api/v5/tradingBot/grid/sub-orders
     */
    @Test
    public void getSubOrders(){
        JSONObject result = this.gridTradingAPIService.getSubOrders("","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取网格策略委托持仓 Get grid algo order positions
     * GET /api/v5/tradingBot/grid/positions
     */
    @Test
    public void getPositions(){
        JSONObject result = this.gridTradingAPIService.getPositions("","");
        toResultString(LOG, "result", result);
    }

    /**
     * 现货网格提取利润 Spot grid withdraw income
     * POST /api/v5/tradingBot/grid/withdraw-income
     */
    @Test
    public void withdrawIncome(){
        WithdrawIncome withdrawIncome = new WithdrawIncome();
        withdrawIncome.setAlgoId("");
        JSONObject result = this.gridTradingAPIService.withdrawIncome(withdrawIncome);
        toResultString(LOG, "result", result);
    }
    /**
     * 网格策略智能回测（公共）grid ai-param
     * GET /api/v5/tradingBot/grid/ai-param
     */
    @Test
    public void getGridTest(){
        JSONObject result = this.gridTradingAPIService.getGridTest("","","","");

        toResultString(LOG, "result", result);
    }

    /**
     * 调整保证金 margin-balance
     * POST /api/v5/tradingBot/grid/margin-balance
     */
    @Test
    public void marginBalance(){
        WithdrawIncome withdrawIncome = new WithdrawIncome();
        withdrawIncome.setAlgoId("");
        withdrawIncome.setAmt("");
        withdrawIncome.setPercent("");
        withdrawIncome.setType("");
        JSONObject result = this.gridTradingAPIService.marginBalance(withdrawIncome);
        toResultString(LOG, "result", result);
    }
    /**
     * 调整保证金计算 compute-margin-balance
     * POST /api/v5/tradingBot/grid/compute-margin-balance
     */
    @Test
    public void computeMarginBalance(){
        WithdrawIncome withdrawIncome = new WithdrawIncome();
        withdrawIncome.setAlgoId("");
        withdrawIncome.setAmt("");
        withdrawIncome.setType("");
        JSONObject result = this.gridTradingAPIService.computeMarginBalance(withdrawIncome);
        toResultString(LOG, "result", result);
    }
    /**
     * POST / 加仓adjust-investment
     * POST /api/v5/tradingBot/grid/adjust-investment
     */
    @Test
    public void adjustInvestment(){
        Investment adjustInvestment = new Investment();
        adjustInvestment.setAlgoId("");
        adjustInvestment.setAmt("");
        JSONObject result = this.gridTradingAPIService.adjustInvestment(adjustInvestment);
        toResultString(LOG, "result", result);
    }


}
