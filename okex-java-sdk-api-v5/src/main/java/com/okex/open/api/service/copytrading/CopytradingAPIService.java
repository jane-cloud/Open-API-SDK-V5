package com.okex.open.api.service.copytrading;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.copytrading.param.AlgoOrder;
import com.okex.open.api.bean.copytrading.param.CloseSubposition;
import com.okex.open.api.bean.copytrading.param.SetInstruments;
import org.checkerframework.checker.units.qual.C;
import retrofit2.http.Query;

public interface CopytradingAPIService {

    //交易员获取当前带单 Get existing leading positions
    JSONObject currentSubpositions(String instId,String after,String before,String limit);

    //交易员获取历史带单 Get leading position history
    JSONObject subpositionsHistory(String instId,String after,String before,String limit);

    //交易员止盈止损 Place leading stop order
    JSONObject algoOrder(AlgoOrder algoOrder);

    //交易员平仓 Close leading position
    JSONObject closeSubposition(CloseSubposition closeSubposition);

    //交易员获取带单合约 Get leading instruments
    JSONObject getInstruments();

    //交易员修改带单合约 Amend leading instruments
    JSONObject setInstruments(SetInstruments setInstruments);

    //交易员历史分润明细 Get profit sharing details
    JSONObject getProfitSharingDetails(String after,String before,String limit);

    //交易员历史分润汇总 Get total profit sharing
    JSONObject getTotalProfitSharing();

    //交易员待分润明细 Get unrealized profit sharing details
    JSONObject getUnrealizedProfitSharingDetails();

// 交易员止盈止损
    JSONObject setAlgoOrder(CloseSubposition algoOrder);
}
