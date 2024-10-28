package com.okex.open.api.test.trade;

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

public class TradeAPITest extends TradeAPIBaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(TradeAPITest.class);
    private TradeAPIService tradeAPIService;

    @Before
    public void before() {
        config = config();
        tradeAPIService = new TradeAPIServiceImpl(config);
    }


    /**
     * 下单 Place Order
     * POST /api/v5/trade/order
     */
    @Test
    public void placeOrder(){

        PlaceOrder placeOrder =new PlaceOrder();
        placeOrder.setInstId("DOT-USDT-SWAP");
        placeOrder.setTdMode("cross");
//        placeOrder.setCcy("USDT");
        placeOrder.setClOrdId("0423a3a06···");
//        placeOrder.setTag("");
        placeOrder.setSide("sell");
        placeOrder.setPosSide("short");
        placeOrder.setOrdType("market");
        placeOrder.setSz("1");
        placeOrder.setQuickMgnType("");

//        placeOrder.setPx("60000");
//        placeOrder.setReduceOnly(false);
//        placeOrder.setTgtCcy("");
//        placeOrder.setBanAmend(false);
        //止盈止损参数

        ArrayList<AttachAlgoOrds> list = new ArrayList<>();
        AttachAlgoOrds attachAlgoOrds = new AttachAlgoOrds();
        attachAlgoOrds.setAttachAlgoClOrdId("");
        attachAlgoOrds.setTpTriggerPxType("");
        attachAlgoOrds.setTpOrdPx("");
        attachAlgoOrds.setTpTriggerPx("");
        attachAlgoOrds.setSlTriggerPxType("");
        attachAlgoOrds.setSlOrdPx("");
        attachAlgoOrds.setSlTriggerPx("");
        attachAlgoOrds.setSz("");
        attachAlgoOrds.setAmendPxOnTriggerType("");
        attachAlgoOrds.setTpOrdKind("");
        list.add(attachAlgoOrds);
        placeOrder.setAttachAlgoOrds(list);
        //自成交保护
        /*placeOrder.setStpId("");
        placeOrder.setStpMode("");*/
        //仅适用于期权
        /*placeOrder.setPxUsd("");
        placeOrder.setPxVol("");*/


        JSONObject result = tradeAPIService.placeOrder(placeOrder);

        toResultString(LOG, "result", result);
    }


    /**
     * 批量下单 Place Multiple Orders
     * POST /api/v5/trade/batch-orders
     */
    @Test
    public void placeMultipleOrders(){

        List<PlaceOrder> placeOrders =new ArrayList<>();

        PlaceOrder placeOrder1 =new PlaceOrder();
        placeOrder1.setInstId("TRX-USDT");
        placeOrder1.setTdMode("isolated");
        placeOrder1.setCcy("");
        placeOrder1.setClOrdId("123testspot07");
        placeOrder1.setTag("");
        placeOrder1.setSide("sell");
        placeOrder1.setPosSide("");
        placeOrder1.setOrdType("limit");
        placeOrder1.setSz("10");
        placeOrder1.setPx("0.09");
        placeOrder1.setReduceOnly(null);
        placeOrder1.setQuickMgnType("");
//        placeOrder1.setTgtCcy("");
//        placeOrder1.setBanAmend(false);
        //止盈止损参数
        /*ArrayList<AttachAlgoOrds> list = new ArrayList<>();
        AttachAlgoOrds attachAlgoOrds = new AttachAlgoOrds();
        attachAlgoOrds.setAttachAlgoClOrdId("");
        attachAlgoOrds.setTpTriggerPxType("");
        attachAlgoOrds.setTpOrdPx("");
        attachAlgoOrds.setTpTriggerPx("");
        attachAlgoOrds.setSlTriggerPxType("");
        attachAlgoOrds.setSlOrdPx("");
        attachAlgoOrds.setSlTriggerPx("");
        attachAlgoOrds.setSz("");
        attachAlgoOrds.setAmendPxOnTriggerType("");
        attachAlgoOrds.setTpOrdKind("");
        list.add(attachAlgoOrds);
        placeOrder1.setAttachAlgoOrds(list);*/
//自成交保护
        /*placeOrder1.setStpId("");
        placeOrder1.setStpMode("");*/
        //仅适用于期权
        /*placeOrder1.setPxUsd("");
        placeOrder1.setPxVol("");*/

        PlaceOrder placeOrder2=new PlaceOrder();
        placeOrder2.setInstId("BTC-USDT-211231");
        placeOrder2.setTdMode("cross");
        placeOrder2.setCcy("");
        placeOrder2.setClOrdId("testfutures07");
        placeOrder2.setTag("");
        placeOrder2.setSide("buy");
        placeOrder2.setPosSide("long");
        placeOrder2.setOrdType("limit");
        placeOrder2.setSz("2");
        placeOrder2.setPx("24633");
        placeOrder2.setReduceOnly(null);
        placeOrder2.setQuickMgnType("");
//        placeOrder2.setTgtCcy("");
//        placeOrder2.setBanAmend(false);
        //止盈止损参数
        /*ArrayList<AttachAlgoOrds> list2 = new ArrayList<>();
        AttachAlgoOrds2 attachAlgoOrds2 = new AttachAlgoOrds();
        attachAlgoOrds2.setAttachAlgoClOrdId("");
        attachAlgoOrds2.setTpTriggerPxType("");
        attachAlgoOrds2.setTpOrdPx("");
        attachAlgoOrds2.setTpTriggerPx("");
        attachAlgoOrds2.setSlTriggerPxType("");
        attachAlgoOrds2.setSlOrdPx("");
        attachAlgoOrds2.setSlTriggerPx("");
        attachAlgoOrds2.setSz("");
        attachAlgoOrds2.setAmendPxOnTriggerType("");
        attachAlgoOrds.setTpOrdKind("");
        list2.add(attachAlgoOrds2);
        placeOrder2.setAttachAlgoOrds(list2);*/
//自成交保护
        /*placeOrder2.setStpId("");
        placeOrder2.setStpMode("");*/

        //仅适用于期权
        /*placeOrder2.setPxUsd("");
        placeOrder2.setPxVol("");*/

        placeOrders.add(placeOrder1);
        placeOrders.add(placeOrder2);

        JSONObject result = tradeAPIService.placeMultipleOrders(placeOrders);

        toResultString(LOG, "result", result);
    }



    /**
     * 撤单 Cancel Order
     * POST /api/v5/trade/cancel-order
     */
    @Test
    public void cancelOrder(){
        CancelOrder cancelOrder = new CancelOrder();
        cancelOrder.setInstId("BTC-USDT-211231");
        cancelOrder.setOrdId("261896498091274242");
        cancelOrder.setClOrdId("");
        JSONObject result = tradeAPIService.cancelOrder(cancelOrder);

        toResultString(LOG, "result", result);
    }


    /**
     * 批量撤单 Cancel Multiple Orders
     * POST /api/v5/trade/cancel-batch-orders
     */
    @Test
    public void cancelMultipleOrders(){
        List<CancelOrder> cancelOrders =new ArrayList<>();

        CancelOrder cancelOrder1 = new CancelOrder();
        cancelOrder1.setInstId("TRX-USDT");
        cancelOrder1.setClOrdId("");
        cancelOrder1.setOrdId("261904614430224384");

        CancelOrder cancelOrder2 = new CancelOrder();
        cancelOrder2.setInstId("BTC-USDT-211231");
        cancelOrder2.setClOrdId("");
        cancelOrder2.setOrdId("261904614430224386");

        cancelOrders.add(cancelOrder1);
        cancelOrders.add(cancelOrder2);

        JSONObject result = tradeAPIService.cancelMultipleOrders(cancelOrders);

        toResultString(LOG, "result", result);
    }


    /**
     * 修改订单 Amend Order
     * POST /api/v5/trade/amend-order
     */
    @Test
    public void amendOrder(){

        AmendOrder amendOrder = new AmendOrder();
        amendOrder.setInstId("BTC-USD-211231");
        amendOrder.setCxlOnFail(true);
        amendOrder.setOrdId("294884456087826432");
//        amendOrder.setClOrdId("");
        amendOrder.setReqId("");
        amendOrder.setNewSz("12.5");
        amendOrder.setNewPx("52000");
        amendOrder.setNewTpTriggerPx("");
        amendOrder.setNewTpOrdPx("");
        amendOrder.setNewSlTriggerPx("");
        amendOrder.setNewSlOrdPx("");
        amendOrder.setNewTpTriggerPxType("");
        amendOrder.setNewSlTriggerPxType("");
        amendOrder.setNewPxUsd("");
        amendOrder.setNewPxVol("");
        ArrayList<AttachAlgoOrds> list = new ArrayList<>();
        AttachAlgoOrds attachAlgoOrds = new AttachAlgoOrds();
        attachAlgoOrds.setAttachAlgoClOrdId("");
        attachAlgoOrds.setTpTriggerPxType("");
        attachAlgoOrds.setTpOrdPx("");
        attachAlgoOrds.setTpTriggerPx("");
        attachAlgoOrds.setSlTriggerPxType("");
        attachAlgoOrds.setSlOrdPx("");
        attachAlgoOrds.setSlTriggerPx("");
        attachAlgoOrds.setSz("");
        attachAlgoOrds.setNewTpOrdKind("");
        attachAlgoOrds.setAmendPxOnTriggerType("");
        list.add(attachAlgoOrds);
        amendOrder.setAttachAlgoOrds(list);
        JSONObject result = tradeAPIService.amendOrder(amendOrder);

        toResultString(LOG, "result", result);
    }



    /**
     * 批量修改订单 Amend Multiple Orders
     * POST /api/v5/trade/amend-batch-orders
     */
    @Test
    public void amendMultipleOrders(){

        List<AmendOrder> amendOrders =new ArrayList<>();

        AmendOrder amendOrder1 = new AmendOrder();
        amendOrder1.setInstId("TRX-USDT");
        amendOrder1.setCxlOnFail(false);
        amendOrder1.setOrdId("261905735181807620");
        amendOrder1.setClOrdId("");
        amendOrder1.setReqId("");
        amendOrder1.setNewSz("15");
        amendOrder1.setNewPx("0.0272");
        amendOrder1.setNewTpTriggerPx("");
        amendOrder1.setNewTpOrdPx("");
        amendOrder1.setNewSlTriggerPx("");
        amendOrder1.setNewSlOrdPx("");
        amendOrder1.setNewTpTriggerPxType("");
        amendOrder1.setNewSlTriggerPxType("");
        amendOrder1.setNewPxUsd("");
        amendOrder1.setNewPxVol("");

        ArrayList<AttachAlgoOrds> list = new ArrayList<>();
        AttachAlgoOrds attachAlgoOrds = new AttachAlgoOrds();
        attachAlgoOrds.setAttachAlgoClOrdId("");
        attachAlgoOrds.setTpTriggerPxType("");
        attachAlgoOrds.setTpOrdPx("");
        attachAlgoOrds.setTpTriggerPx("");
        attachAlgoOrds.setSlTriggerPxType("");
        attachAlgoOrds.setSlOrdPx("");
        attachAlgoOrds.setSlTriggerPx("");
        attachAlgoOrds.setSz("");
        attachAlgoOrds.setAmendPxOnTriggerType("");
        attachAlgoOrds.setNewTpOrdKind("");
        list.add(attachAlgoOrds);
        amendOrder1.setAttachAlgoOrds(list);

        AmendOrder amendOrder2 = new AmendOrder();
        amendOrder2.setInstId("BTC-USDT-211231");
        amendOrder2.setCxlOnFail(false);
        amendOrder2.setOrdId("261905735181807623");
        amendOrder2.setClOrdId("");
        amendOrder2.setReqId("");
        amendOrder2.setNewSz("20");
        amendOrder2.setNewPx("");
        amendOrder2.setNewTpTriggerPx("");
        amendOrder2.setNewTpOrdPx("");
        amendOrder2.setNewSlTriggerPx("");
        amendOrder2.setNewSlOrdPx("");
        amendOrder2.setNewTpTriggerPxType("");
        amendOrder2.setNewSlTriggerPxType("");
        amendOrder2.setNewPxUsd("");
        amendOrder2.setNewPxVol("");
        ArrayList<AttachAlgoOrds> list2 = new ArrayList<>();
        AttachAlgoOrds attachAlgoOrds2 = new AttachAlgoOrds();
        attachAlgoOrds2.setAttachAlgoClOrdId("");
        attachAlgoOrds2.setTpTriggerPxType("");
        attachAlgoOrds2.setTpOrdPx("");
        attachAlgoOrds2.setTpTriggerPx("");
        attachAlgoOrds2.setSlTriggerPxType("");
        attachAlgoOrds2.setSlOrdPx("");
        attachAlgoOrds2.setSlTriggerPx("");
        attachAlgoOrds2.setSz("");
        attachAlgoOrds2.setAmendPxOnTriggerType("");
        attachAlgoOrds.setNewTpOrdKind("");
        list2.add(attachAlgoOrds2);
        amendOrder2.setAttachAlgoOrds(list2);

        amendOrders.add(amendOrder1);
        amendOrders.add(amendOrder2);

        JSONObject result = tradeAPIService.amendMultipleOrders(amendOrders);

        toResultString(LOG, "result", result);
    }


    /**
     * 市价仓位全平 Close Positions
     * POST /api/v5/trade/close-position
     */
    @Test
    public void closePositions(){

        ClosePositions closePositions =  new ClosePositions();
        closePositions.setInstId("BTC-USD-SWAP");
        closePositions.setPosSide("long");
        closePositions.setMgnMode("cross");
        closePositions.setCcy("");
        closePositions.setClOrdId("");
        closePositions.setTag("");
        closePositions.setAutoCxl("false");
        JSONObject result = tradeAPIService.closePositions(closePositions);

        toResultString(LOG, "result", result);

    }


    /**
     * 获取订单信息 Get Order Details
     * GET /api/v5/trade/order
     */
    @Test
    public void getOrderDetails(){
        JSONObject result = tradeAPIService.getOrderDetails("EOS-USDT",null,"0420aaa");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取未成交订单列表 Get Order List
     * GET /api/v5/trade/orders-pending
     */
    @Test
    public void getOrderList(){
        JSONObject result = tradeAPIService.getOrderList("FUTURES","","EOS-USDT-211231","","","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取历史订单记录（近七天） Get Order History (last 7 days）
     * GET /api/v5/trade/orders-history
     */
    @Test
    public void getOrderHistory7days(){
        JSONObject result = tradeAPIService.getOrderHistory7days("FUTURES","","","","","","","","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取历史订单记录（近三个月） Get Order History (last 3 months)
     * GET /api/v5/trade/orders-history-archive
     */
    @Test
    public void getOrderHistory3months(){
        JSONObject result = tradeAPIService.getOrderHistory3months("SWAP","","BTC-USDT-SWAP","","","","","","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取成交明细（近三天） Get Transaction Details(last 3 days）
     * GET /api/v5/trade/fills
     */
    @Test
    public void getTransactionDetails(){

        JSONObject result = tradeAPIService.getTransactionDetails("SPOT",null,null,null,null,null,null,null,null,null,null);
        toResultString(LOG, "result", result);

    }

    /**
     * 获取成交明细（近三个月） Get Transaction Details(last 3 months）
     * GET /api/v5/trade/fills-history
     */
    @Test
    public void getTransactionDetailsForThreeMonths(){

        JSONObject result = tradeAPIService.getTransactionDetailsForThreeMonths("SPOT",null,null,null,null,null,null,null,null,null,null);
        toResultString(LOG, "result", result);

    }

    /**
     * 委托策略下单 Place Algo  Order
     * POST /api/v5/trade/order-algo
     */
    @Test
    public void placeAlgoOrder(){
        PlaceAlgoOrder placeAlgoOrder = new PlaceAlgoOrder();
        placeAlgoOrder.setInstId("DOT-USDT-SWAP");
        placeAlgoOrder.setTdMode("isolated");
//        placeAlgoOrder.setCcy("");
        placeAlgoOrder.setSide("buy");
//        placeAlgoOrder.setPosSide("long");
        placeAlgoOrder.setOrdType("conditional");
        placeAlgoOrder.setAlgoClOrdId("");
        placeAlgoOrder.setSz("1");
        //placeAlgoOrder.setCloseFraction("");
        placeAlgoOrder.setReduceOnly(false);
//        placeAlgoOrder.setTgtCcy("");
        //placeAlgoOrder.setTag("");
        placeAlgoOrder.setQuickMgnType("");
//        止盈止损 Stop Order
        placeAlgoOrder.setTpTriggerPx("45000");
        placeAlgoOrder.setTpOrdPx("44000");
        placeAlgoOrder.setSlTriggerPx("60000");
        placeAlgoOrder.setSlOrdPx("65000");
        placeAlgoOrder.setSlTriggerPxType("");
        placeAlgoOrder.setTpTriggerPxType("");

//        计划委托 Trigger Order
        /*placeAlgoOrder.setTriggerPx("1.1");
        placeAlgoOrder.setOrderPx("0.7");
        placeAlgoOrder.setTriggerPxType("last");
        AttachAlgoOrds attachAlgoOrds = new AttachAlgoOrds();
        attachAlgoOrds.setAttachAlgoClOrdId("");
        attachAlgoOrds.setSlOrdPx("");
        attachAlgoOrds.setTpOrdPx("");
        attachAlgoOrds.setSlTriggerPx("");
        attachAlgoOrds.setTpTriggerPx("");
        attachAlgoOrds.setSlTriggerPxType("");
        attachAlgoOrds.setTpTriggerPxType("");

        List<AttachAlgoOrds> list = new ArrayList<AttachAlgoOrds>();
        list.add(attachAlgoOrds);
        placeAlgoOrder.setAttachAlgoOrdsList(list);*/
        //移动止盈止损
//        placeAlgoOrder.setCallbackRatio("0.1");
//        placeAlgoOrder.setCallbackSpread("1");
//        placeAlgoOrder.setActivePx("32");

        //冰山委托
        /*placeAlgoOrder.setPxVar("");
        placeAlgoOrder.setPxSpread("");
        placeAlgoOrder.setSzLimit("");
        placeAlgoOrder.setPxLimit("");*/

        //时间加权
        /*placeAlgoOrder.setPxVar("");
        placeAlgoOrder.setPxSpread("");
        placeAlgoOrder.setSzLimit("");
        placeAlgoOrder.setPxLimit("");
        placeAlgoOrder.setTimeInterval("");*/

        //placeAlgoOrder.setCxlOnClosePos("");


        JSONObject result = tradeAPIService.placeAlgoOrder(placeAlgoOrder);
        toResultString(LOG, "result", result);

    }

    /**
     * 撤销策略委托订单 Cancel Algo Order
     * POST /api/v5/trade/cancel-algos
     */
    @Test
    public void cancelAlgoOrder(){

        List<CancelAlgoOrder> list = new ArrayList<CancelAlgoOrder>();
        CancelAlgoOrder cancelAlgoOrder = new CancelAlgoOrder();

        cancelAlgoOrder.setAlgoId("300338778946826240");
        cancelAlgoOrder.setInstId("BTC-USDT");
        list.add(cancelAlgoOrder);

        JSONObject result = tradeAPIService.cancelAlgoOrder(list);
        toResultString(LOG, "result", result);
    }

    /**
     * 撤销高级策略委托订单 Cancel Advance Algo Order
     * POST /api/v5/trade/cancel-advance-algos
     */
    @Test
    public void cancelAdvanceAlgoOrders(){

        List<CancelAlgoOrder> list = new ArrayList<CancelAlgoOrder>();
        CancelAlgoOrder cancelAlgoOrder = new CancelAlgoOrder();

        cancelAlgoOrder.setAlgoId("300338778946826240");
        cancelAlgoOrder.setInstId("BTC-USDT");
        list.add(cancelAlgoOrder);

        JSONObject result = tradeAPIService.cancelAdvanceAlgoOrders(list);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取未完成策略委托单列表 Get Algo Order List
     * GET /api/v5/trade/orders-algo-pending
     */
    @Test
    public void getAlgoOrderList(){
        JSONObject result = tradeAPIService.getAlgoOrderList("300592229014450176",null,null,"trigger","",null,null,"10");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取历史策略委托单列表 Get Algo Order History
     * GET /api/v5/trade/orders-algo-history
     */
    @Test
    public void getAlgoOrderHistory(){
        JSONObject result = tradeAPIService.getAlgoOrderHistory("effective",null,null,null,"trigger","",null,null,"10");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取一键兑换主流币币种列表  Get easy convert currency list
     * GET /api/v5/trade/easy-convert-currency-list
     */
    @Test
    public void getEasyConvertCurrencyList(){
        JSONObject result = tradeAPIService.getEasyConvertCurrencyList("");
        toResultString(LOG, "result", result);
    }

    /**
     * 一键兑换主流币交易  Place easy convert
     * POST /api/v5/trade/easy-convert
     */
    @Test
    public void placeEasyConvert(){
        EasyConvert easyConvert = new EasyConvert();
        List<String> fromCcy = new ArrayList();
        fromCcy.add("LUNA");
        fromCcy.add("NEO");
        easyConvert.setFromCcy(fromCcy);
        easyConvert.setToCcy("USDT");
        easyConvert.setSource("");
        JSONObject result = tradeAPIService.placeEasyConvert(easyConvert);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取一键兑换主流币历史记录  Get easy convert history
     * GET /api/v5/trade/easy-convert-history
     */
    @Test
    public void getEasyConvertHistory(){
        JSONObject result = tradeAPIService.getEasyConvertHistory("","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取一键还债币种列表 Get one-click repay currency list
     * GET /api/v5/trade/one-click-repay-currency-list
     */
    @Test
    public void getOneClickRepayCurrencyList(){
        JSONObject result = tradeAPIService.getOneClickRepayCurrencyList("cross");
        toResultString(LOG, "result", result);
    }

    /**
     * 一键还债交易 Trade one-click repay
     * POST /api/v5/trade/one-click-repay
     */
    @Test
    public void oneClickRepay(){
        OneClickRepay oneClickRepay = new OneClickRepay();
        List<String> debtCcy = new ArrayList();
        debtCcy.add("USDT");

        oneClickRepay.setDebtCcy(debtCcy);
        oneClickRepay.setRepayCcy("XRP");

        JSONObject result = tradeAPIService.oneClickRepay(oneClickRepay);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取一键还债历史记录  Get one-click repay history
     * GET /api/v5/trade/one-click-repay-history
     */
    @Test
    public void getOneClickRepayHistory(){
        JSONObject result = tradeAPIService.getOneClickRepayHistory(null,null,null);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取策略委托单信息 Get Algo Order Details
     * GET /api/v5/trade/order-algo
     */
    @Test
    public void getAlgoOrderDetails(){
        JSONObject result = tradeAPIService.getAlgoOrderDetails("","");
        toResultString(LOG, "result", result);
    }

    /**
     * 修改策略委托订单 Amend Algo Order
     * POST /api/v5/trade/amend-algos
     */
    @Test
    public void amendAlgos(){

        AmendAlgos amendAlgos = new AmendAlgos();
        amendAlgos.setInstId("");
        amendAlgos.setAlgoId("");
        amendAlgos.setAlgoClOrdId("");
        amendAlgos.setCxlOnFail("");
        amendAlgos.setReqId("");
        amendAlgos.setNewSz("");
        amendAlgos.setNewTpTriggerPx("");
        amendAlgos.setNewTpOrdPx("");
        amendAlgos.setNewSlTriggerPx("");
        amendAlgos.setNewSlOrdPx("");
        amendAlgos.setNewTpTriggerPxType("");
        amendAlgos.setNewSlTriggerPxType("");
        amendAlgos.setNewTriggerPx("");
        amendAlgos.setNewOrdPx("");
        amendAlgos.setNewTriggerPxType("");
        ArrayList<AttachAlgoOrds> list = new ArrayList<>();
        AttachAlgoOrds attachAlgoOrds = new AttachAlgoOrds();
        attachAlgoOrds.setNewTpTriggerPx("");
        attachAlgoOrds.setNewTpTriggerPxType("");
        attachAlgoOrds.setNewTpOrdPx("");
        attachAlgoOrds.setNewSlTriggerPx("");
        attachAlgoOrds.setNewSlTriggerPxType("");
        attachAlgoOrds.setNewSlOrdPx("");
        list.add(attachAlgoOrds);
        amendAlgos.setAttachAlgoOrds(list);

        JSONObject result = tradeAPIService.amendAlgos(amendAlgos);
        toResultString(LOG, "result", result);
    }
    /**
     * 撤销 MMP 订单 mass-cancel Order
     * POST /api/v5/trade/mass-cancel
     */
    @Test
    public void massCancelOrder(){
        CancelOrder cancelOrder = new CancelOrder();
        cancelOrder.setInstType("");
        cancelOrder.setInstFamily("");
        cancelOrder.setLockInterval("");

        JSONObject result = tradeAPIService.massCancelOrder(cancelOrder);

        toResultString(LOG, "result", result);
    }

    /**
     * 倒计时全部撤单 cancel-all-after
     * POST /api/v5/trade/cancel-all-after
     */
    @Test
    public void cancelAllOrder(){
        CancelOrder cancelOrder = new CancelOrder();
        cancelOrder.setTimeOut("");
        cancelOrder.setTag("");
        JSONObject result = tradeAPIService.cancelAllOrder(cancelOrder);

        toResultString(LOG, "result", result);
    }
    /**
     * 申请成交明细（近两年） fills-archive
     * POST /api/v5/trade/fills-archive
     */
    @Test
    public void applyFillsArchive(){
        Fills fills = new Fills();
        fills.setQuarter("");
        fills.setYear("");

        JSONObject result = tradeAPIService.applyFillsArchive(fills);

        toResultString(LOG, "result", result);
    }
    /**
     *  获取成交明细（近两年） fills-archive
     * GET /api/v5/trade/fills-archive
     */
    @Test
    public void getFillsArchive(){

        JSONObject result = tradeAPIService.getFillsArchive("","");

        toResultString(LOG, "result", result);
    }
    /**
     *   获取账户限速 account-rate-limit
     * GET /api/v5/trade/account-rate-limit
     */
    @Test
    public void getAccountRateLimit(){

        JSONObject result = tradeAPIService.getAccountRateLimit("","","","","");

        toResultString(LOG, "result", result);
    }
    /**
     * 订单预检查 order-precheck
     * POST /api/v5/trade/order-precheck
     */
    @Test
    public void orderPrecheck(){
        PlaceOrder placeOrder =new PlaceOrder();
        placeOrder.setInstId("DOT-USDT-SWAP");
        placeOrder.setTdMode("cross");
        placeOrder.setSide("sell");
        placeOrder.setPosSide("short");
        placeOrder.setOrdType("market");
        placeOrder.setSz("1");
        placeOrder.setPx("60000");
//        placeOrder.setReduceOnly(false);
//        placeOrder.setTgtCcy("");
        //止盈止损参数

        ArrayList<AttachAlgoOrds> list = new ArrayList<>();
        AttachAlgoOrds attachAlgoOrds = new AttachAlgoOrds();
        attachAlgoOrds.setAttachAlgoClOrdId("");
        attachAlgoOrds.setTpTriggerPxType("");
        attachAlgoOrds.setTpOrdPx("");
        attachAlgoOrds.setTpTriggerPx("");
        attachAlgoOrds.setSlTriggerPxType("");
        attachAlgoOrds.setSlOrdPx("");
        attachAlgoOrds.setSlTriggerPx("");
        attachAlgoOrds.setSz("");
        attachAlgoOrds.setTpOrdKind("");
        list.add(attachAlgoOrds);
        placeOrder.setAttachAlgoOrds(list);


        JSONObject result = tradeAPIService.orderPrecheck(placeOrder);

        toResultString(LOG, "result", result);
    }
}
