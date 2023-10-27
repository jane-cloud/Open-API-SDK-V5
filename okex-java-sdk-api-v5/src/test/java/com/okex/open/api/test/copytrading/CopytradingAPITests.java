package com.okex.open.api.test.copytrading;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.copytrading.param.AlgoOrder;
import com.okex.open.api.bean.copytrading.param.CloseSubposition;
import com.okex.open.api.bean.copytrading.param.SetInstruments;
import com.okex.open.api.service.convert.ConvertAPIService;
import com.okex.open.api.service.convert.impl.ConvertAPIServiceImpl;
import com.okex.open.api.service.copytrading.CopytradingAPIService;
import com.okex.open.api.service.copytrading.impl.CopytradingAPIServiceImpl;
import com.okex.open.api.test.convert.ConvertAPITests;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopytradingAPITests extends CopytradingAPIBaseTests{

    private static final Logger LOG = LoggerFactory.getLogger(CopytradingAPITests.class);

    private CopytradingAPIService copytradingAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.copytradingAPIService = new CopytradingAPIServiceImpl(this.config);
    }

    /**
     * 交易员获取当前带单 Get existing leading positions
     * GET /api/v5/copytrading/current-subpositions
     */
    @Test
    public void currentSubpositions() {
        JSONObject result = copytradingAPIService.currentSubpositions("BTC-USDT-SWAP",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员获取历史带单 Get leading position history
     * /api/v5/copytrading/subpositions-history
     */
    @Test
    public void subpositionsHistory() {
        JSONObject result = copytradingAPIService.subpositionsHistory("BTC-USDT-SWAP",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员获取历史带单 Get leading position history
     * /api/v5/copytrading/subpositions-history
     */
    @Test
    public void AlgoOrder() {
        AlgoOrder algoOrder = new AlgoOrder();
        algoOrder.setSubPosId("1234");
        algoOrder.setSlTriggerPx("12");
        algoOrder.setSlTriggerPxType("last");
        algoOrder.setTpTriggerPx("13");
        algoOrder.setTpTriggerPxType("last");

        JSONObject result = copytradingAPIService.algoOrder(algoOrder);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员平仓 Close leading position
     * POST /api/v5/copytrading/close-subposition
     */
    @Test
    public void closeSubposition() {
        CloseSubposition closeSubposition = new CloseSubposition();
        closeSubposition.setSubPosId("1234");
        closeSubposition.setTag("");

        JSONObject result = copytradingAPIService.closeSubposition(closeSubposition);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员获取带单合约 Get leading instruments
     * GET /api/v5/copytrading/instruments
     */
    @Test
    public void getInstruments() {
        JSONObject result = copytradingAPIService.getInstruments();
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员修改带单合约 Amend leading instruments
     * POST /api/v5/copytrading/set-instruments
     */
    @Test
    public void setInstruments() {
        SetInstruments setInstruments = new SetInstruments();
        setInstruments.setInstId("BTC-USDT-SWAP");

        JSONObject result = copytradingAPIService.setInstruments(setInstruments);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员历史分润明细 Get profit sharing details
     * GET /api/v5/copytrading/profit-sharing-details
     */
    @Test
    public void getProfitSharingDetails() {
        JSONObject result = copytradingAPIService.getProfitSharingDetails("","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员历史分润汇总 Get total profit sharing
     * GET /api/v5/copytrading/total-profit-sharing
     */
    @Test
    public void getTotalProfitSharing() {
        JSONObject result = copytradingAPIService.getTotalProfitSharing();
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员待分润明细 Get unrealized profit sharing details
     * GET /api/v5/copytrading/unrealized-profit-sharing-details
     */
    @Test
    public void getUnrealizedProfitSharingDetails() {
        JSONObject result = copytradingAPIService.getUnrealizedProfitSharingDetails();
        toResultString(LOG, "result", result);
    }
    /**
     * 交易员止盈止损 Close algo-order
     * POST /api/v5/copytrading/algo-order
     */
    @Test
    public void setAlgoOrder() {
        CloseSubposition algoOrder = new CloseSubposition();
        algoOrder.setSubPosId("1234");
        algoOrder.setTpTriggerPx("");
        algoOrder.setSlTriggerPx("");
        algoOrder.setTpTriggerPxType("");
        algoOrder.setSlTriggerPxType("");
        algoOrder.setTag("");

        JSONObject result = copytradingAPIService.setAlgoOrder(algoOrder);
        toResultString(LOG, "result", result);
    }

}
