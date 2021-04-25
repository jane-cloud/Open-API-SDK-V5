package com.okex.open.api.service.publicData;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import retrofit2.http.Query;

public interface PublicDataAPIService {

    //获取交易产品基础信息 Get Instruments
    JSONObject getInstruments(String instType,String uly);

    //获取交割和行权记录 Get Delivery/Exercise History
    JSONObject getDeliveryExerciseHistory(String instType,String uly,String after,String before,String limit);

    //获取持仓总量 Get Open Interest
    JSONObject getOpenInterest(String instType,String uly,String instId);

    //获取永续合约当前资金费率 Get Funding Rate
    JSONObject getFundingRate(String instId);

    //获取永续合约历史资金费率 Get Funding Rate History
    JSONObject getFundingRateHistory(String instId,String after,String before,String limit);

    //获取限价 Get Limit Price
    JSONObject getLimitPrice(String instId);

    //获取期权定价 Get Option Market Data
    JSONObject getOptionMarketData(String uly,String expTime);

    //获取预估交割/行权价格 Get Estimated Delivery/Excercise Price
    JSONObject getEstimatedDeliveryExcercisePrice(String instId);

    //获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota
    JSONObject getDiscountRateAndInterestFreeQuota(String ccy);

    //获取系统时间 Get System Time
    JSONObject getSystemTime();

    //获取平台公共爆仓单信息 Get Liquidation Orders
    JSONObject getLiquidationOrders(String instType,String mgnMode,String instId,String ccy,String uly,String alias,String state,String before,String after,String limit);

    //获取标记价格 Get Mark Price
    JSONObject getMarkPrice(String instType,String uly,String instId);

    //获取合约衍生品仓位档位
    JSONObject getTier(String instType, String uly, String instId, String tdMode, String ccy, String tier);
}
