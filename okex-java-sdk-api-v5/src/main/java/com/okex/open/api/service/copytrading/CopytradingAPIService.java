package com.okex.open.api.service.copytrading;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.SetLeverage;
import com.okex.open.api.bean.copytrading.param.*;

public interface CopytradingAPIService {

    //交易员获取当前带单 Get existing leading positions
    JSONObject currentSubpositions(String instId,String after,String before,String limit,String instType,String subPosType,String uniqueCode);

    //交易员获取历史带单 Get leading position history
    JSONObject subpositionsHistory(String instId,String after,String before,String limit,String instType,String subPosType);

    //交易员止盈止损 Place leading stop order
    JSONObject algoOrder(AlgoOrder algoOrder);

    //交易员平仓 Close leading position
    JSONObject closeSubposition(CloseSubposition closeSubposition);

    //交易员获取带单合约 Get leading instruments
    JSONObject getInstruments(String instType);

    //交易员修改带单合约 Amend leading instruments
    JSONObject setInstruments(SetInstruments setInstruments);

    //交易员历史分润明细 Get profit sharing details
    JSONObject getProfitSharingDetails(String after,String before,String limit,String instType);

    //交易员历史分润汇总 Get total profit sharing
    JSONObject getTotalProfitSharing(String instType);

    //交易员待分润明细 Get unrealized profit sharing details
    JSONObject getUnrealizedProfitSharingDetails(String instType);

// 交易员止盈止损
    JSONObject setAlgoOrder(CloseSubposition algoOrder);

    //首次跟单设置
    JSONObject setFirstCopySettings(CopySetting firstCopySetting);

    JSONObject amendCopySettings(CopySetting amendCopySettings);

    JSONObject stopCopyTrading(CopySetting stopCopyTrading);

    JSONObject getCopySettings(String instType, String uniqueCode);

    JSONObject getBatchLeverageInf(String mgnMode, String uniqueCode, String instId);

    JSONObject setBatchSetLeverage(SetLeverage setLeverage);

    JSONObject getCurrentLeadTraders(String instType);

    JSONObject getLeadTradersHistory(String instType, String after, String before, String limit);

    JSONObject getPublicConfig(String instType);

    JSONObject getPublicLeadTraders(String instType, String sortType, String state, String minLeadDays, String minAssets, String maxAssets, String minAum, String maxAum, String dataVer, String page, String limit);

    JSONObject getPublicWeeklyPnl(String instType, String uniqueCode);

    JSONObject getPublicPnl(String instType, String uniqueCode, String lastDays);

    JSONObject getPublicStats(String instType, String uniqueCode, String lastDays);

    JSONObject getPublicPreferenceCurrency(String instType, String uniqueCode);

    JSONObject getPublicCurrentSubpositions(String instType, String uniqueCode, String after, String before, String limit);

    JSONObject getPublicSubpositionsHistory(String instType, String uniqueCode, String after, String before, String limit);

    JSONObject applyLeadTrading(LeadTrading applyLeadTrading);

    JSONObject stopLeadTrading(LeadTrading stopLeadTrading);

    JSONObject amendProfitSharingRatio(LeadTrading amendProfitSharingRatio);

    JSONObject getPrivateLeadTraders(String instType, String sortType, String state, String minLeadDays, String minAssets, String maxAssets, String minAum, String maxAum, String dataVer, String page, String limit);

    JSONObject getWeeklyPnl(String instType, String uniqueCode);

    JSONObject getPnl(String  instType, String uniqueCode,String lastDays);

    JSONObject getStats( String instType, String uniqueCode, String lastDays);

    JSONObject getPreferenceCurrency(String instType, String uniqueCode);

    JSONObject getCurrentSubpositions(String instType, String uniqueCode, String after, String before, String limit);

    JSONObject getSubpositionsHistory(String instType, String uniqueCode, String after, String before, String limit);

    JSONObject getCopyTraders(String instType, String uniqueCode, String limit);

    JSONObject getPublicCopyTraders(String instType, String uniqueCode, String limit);

    JSONObject getAccountConfig();

    JSONObject getTotalUnrealizedProfitSharing(String instType);
}
