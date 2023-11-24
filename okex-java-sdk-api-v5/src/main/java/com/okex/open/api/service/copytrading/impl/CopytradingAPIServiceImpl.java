package com.okex.open.api.service.copytrading.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.copytrading.param.AlgoOrder;
import com.okex.open.api.bean.copytrading.param.CloseSubposition;
import com.okex.open.api.bean.copytrading.param.SetInstruments;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.copytrading.CopytradingAPIService;

public class CopytradingAPIServiceImpl implements CopytradingAPIService {

    private APIClient client;
    private CopytradingAPI api;

    public CopytradingAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(CopytradingAPI.class);
    }

    //交易员获取当前带单 Get existing leading positions
    @Override
    public JSONObject currentSubpositions(String instId,String after,String before,String limit,String instType) {
        return this.client.executeSync(this.api.currentSubpositions(instId, after, before, limit,instType));
    }

    //交易员获取历史带单 Get leading position history
    @Override
    public JSONObject subpositionsHistory(String instId, String after, String before, String limit,String instType) {
        return this.client.executeSync(this.api.subpositionsHistory(instId, after, before, limit,instType));
    }

    //交易员止盈止损 Place leading stop order
    @Override
    public JSONObject algoOrder(AlgoOrder algoOrder) {
        return this.client.executeSync(this.api.algoOrder(JSONObject.parseObject(JSON.toJSONString(algoOrder))));
    }

    //交易员平仓 Close leading position
    @Override
    public JSONObject closeSubposition(CloseSubposition closeSubposition) {
        return this.client.executeSync(this.api.closeSubposition(JSONObject.parseObject(JSON.toJSONString(closeSubposition))));
    }

    //交易员获取带单合约 Get leading instruments
    @Override
    public JSONObject getInstruments(String instType) {
        return this.client.executeSync(this.api.getInstruments(instType));
    }

    //交易员修改带单合约 Amend leading instruments
    @Override
    public JSONObject setInstruments(SetInstruments setInstruments) {
        return this.client.executeSync(this.api.setInstruments(JSONObject.parseObject(JSON.toJSONString(setInstruments))));
    }

    //交易员历史分润明细 Get profit sharing details
    @Override
    public JSONObject getProfitSharingDetails(String after, String before, String limit,String instType) {
        return this.client.executeSync(this.api.getProfitSharingDetails(after, before, limit,instType));
    }

    //交易员历史分润汇总 Get total profit sharing
    @Override
    public JSONObject getTotalProfitSharing(String instType) {
        return this.client.executeSync(this.api.getTotalProfitSharing(instType));
    }

    //交易员待分润明细 Get unrealized profit sharing details
    @Override
    public JSONObject getUnrealizedProfitSharingDetails(String instType) {
        return this.client.executeSync(this.api.getUnrealizedProfitSharingDetails(instType));
    }

    @Override
    public JSONObject setAlgoOrder(CloseSubposition algoOrder) {
        return this.client.executeSync(this.api.setAlgoOrder(JSONObject.parseObject(JSON.toJSONString(algoOrder))));
    }


}
