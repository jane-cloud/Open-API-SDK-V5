package com.okex.open.api.service.copytrading.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.SetLeverage;
import com.okex.open.api.bean.copytrading.param.*;
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
    public JSONObject currentSubpositions(String instId,String after,String before,String limit,String instType,String subPosType,String uniqueCode) {
        return this.client.executeSync(this.api.currentSubpositions(instId, after, before, limit,instType,subPosType,uniqueCode));
    }

    //交易员获取历史带单 Get leading position history
    @Override
    public JSONObject subpositionsHistory(String instId, String after, String before, String limit,String instType,String subPosType) {
        return this.client.executeSync(this.api.subpositionsHistory(instId, after, before, limit,instType,subPosType));
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

    @Override
    public JSONObject setFirstCopySettings(CopySetting firstCopySetting) {
        return this.client.executeSync(this.api.setFirstCopySettings(JSONObject.parseObject(JSON.toJSONString(firstCopySetting))));
    }

    @Override
    public JSONObject amendCopySettings(CopySetting amendCopySettings) {
        return this.client.executeSync(this.api.amendCopySettings(JSONObject.parseObject(JSON.toJSONString(amendCopySettings))));
    }

    @Override
    public JSONObject stopCopyTrading(CopySetting stopCopyTrading) {
        return this.client.executeSync(this.api.stopCopyTrading(JSONObject.parseObject(JSON.toJSONString(stopCopyTrading))));
    }

    @Override
    public JSONObject getCopySettings(String instType, String uniqueCode) {
        return this.client.executeSync(this.api.getCopySettings(instType,uniqueCode));
    }

    @Override
    public JSONObject getBatchLeverageInf(String mgnMode, String uniqueCode, String instId) {
        return this.client.executeSync(this.api.getBatchLeverageInf(mgnMode,uniqueCode,instId));
    }

    @Override
    public JSONObject setBatchSetLeverage(SetLeverage setLeverage) {
        return this.client.executeSync(this.api.setBatchSetLeverage(JSONObject.parseObject(JSON.toJSONString(setLeverage))));
    }

    @Override
    public JSONObject getCurrentLeadTraders(String instType) {
        return this.client.executeSync(this.api.getCurrentLeadTraders(instType));
    }

    @Override
    public JSONObject getLeadTradersHistory(String instType, String after, String before, String limit) {
        return this.client.executeSync(this.api.getLeadTradersHistory( instType, after, before, limit));
    }

    @Override
    public JSONObject getPublicConfig(String instType) {
        return this.client.executeSync(this.api.getPublicConfig(instType));
    }

    @Override
    public JSONObject getPublicLeadTraders(String instType, String sortType, String state, String minLeadDays, String minAssets, String maxAssets, String minAum, String maxAum, String dataVer, String page, String limit) {
        return this.client.executeSync(this.api.getPublicLeadTraders( instType,  sortType,  state,  minLeadDays,  minAssets,  maxAssets,  minAum,  maxAum,  dataVer,  page,  limit));
    }

    @Override
    public JSONObject getPublicWeeklyPnl(String instType, String uniqueCode) {
        return this.client.executeSync(this.api.getPublicWeeklyPnl(instType,uniqueCode));
    }

    @Override
    public JSONObject getPublicPnl(String instType, String uniqueCode, String lastDays) {
        return this.client.executeSync(this.api.getPublicPnl(instType,uniqueCode,lastDays));
    }

    @Override
    public JSONObject getPublicStats(String instType, String uniqueCode, String lastDays) {
        return this.client.executeSync(this.api.getPublicStats(instType,uniqueCode,lastDays));
    }

    @Override
    public JSONObject getPublicPreferenceCurrency(String instType, String uniqueCode) {
        return this.client.executeSync(this.api.getPublicPreferenceCurrency(instType,uniqueCode));
    }

    @Override
    public JSONObject getPublicCurrentSubpositions(String instType, String uniqueCode, String after, String before, String limit) {
        return this.client.executeSync(this.api.getPublicCurrentSubpositions(instType,uniqueCode,after,before,limit));
    }

    @Override
    public JSONObject getPublicSubpositionsHistory(String instType, String uniqueCode, String after, String before, String limit) {
        return this.client.executeSync(this.api.getPublicSubpositionsHistory(instType,uniqueCode,after,before,limit));
    }

    @Override
    public JSONObject applyLeadTrading(LeadTrading applyLeadTrading) {
        return this.client.executeSync(this.api.applyLeadTrading(JSONObject.parseObject(JSON.toJSONString(applyLeadTrading))));
    }

    @Override
    public JSONObject stopLeadTrading(LeadTrading stopLeadTrading) {
        return this.client.executeSync(this.api.stopLeadTrading(JSONObject.parseObject(JSON.toJSONString(stopLeadTrading))));
    }

    @Override
    public JSONObject amendProfitSharingRatio(LeadTrading amendProfitSharingRatio) {
        return this.client.executeSync(this.api.amendProfitSharingRatio(JSONObject.parseObject(JSON.toJSONString(amendProfitSharingRatio))));
    }

    @Override
    public JSONObject getPrivateLeadTraders(String instType, String sortType, String state, String minLeadDays, String minAssets, String maxAssets, String minAum, String maxAum, String dataVer, String page, String limit) {
        return this.client.executeSync(this.api.getPrivateLeadTraders( instType,  sortType,  state,  minLeadDays,  minAssets,  maxAssets,  minAum,  maxAum,  dataVer,  page,  limit));
    }

    @Override
    public JSONObject getWeeklyPnl(String instType, String uniqueCode) {
        return this.client.executeSync(this.api.getWeeklyPnl(instType,uniqueCode));
    }

    @Override
    public JSONObject getPnl(String instType, String uniqueCode, String lastDays) {
        return this.client.executeSync(this.api.getPnl(instType,uniqueCode,lastDays));
    }

    @Override
    public JSONObject getStats(String instType, String uniqueCode, String lastDays) {
        return this.client.executeSync(this.api.getStats(instType,uniqueCode,lastDays));
    }

    @Override
    public JSONObject getPreferenceCurrency(String instType, String uniqueCode) {
        return this.client.executeSync(this.api.getPreferenceCurrency(instType,uniqueCode));
    }

    @Override
    public JSONObject getCurrentSubpositions(String instType, String uniqueCode, String after, String before, String limit) {
        return this.client.executeSync(this.api.getCurrentSubpositions(instType,uniqueCode,after,before,limit));
    }

    @Override
    public JSONObject getSubpositionsHistory(String instType, String uniqueCode, String after, String before, String limit) {
        return this.client.executeSync(this.api.getSubpositionsHistory(instType,uniqueCode,after,before,limit));
    }

    @Override
    public JSONObject getCopyTraders(String instType, String uniqueCode, String limit) {
        return this.client.executeSync(this.api.getCopyTraders(instType,uniqueCode,limit));
    }

    @Override
    public JSONObject getPublicCopyTraders(String instType, String uniqueCode, String limit) {
        return this.client.executeSync(this.api.getPublicCopyTraders(instType,uniqueCode,limit));
    }

    @Override
    public JSONObject getAccountConfig() {
        return this.client.executeSync(this.api.getAccountConfig());
    }

    @Override
    public JSONObject getTotalUnrealizedProfitSharing(String instType) {
        return this.client.executeSync(this.api.getTotalUnrealizedProfitSharing(instType));
    }


}
