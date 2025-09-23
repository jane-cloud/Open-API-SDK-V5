package com.okex.open.api.service.publicData;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface PublicDataAPIService {

    //获取交易产品基础信息 Get Instruments
    JSONObject getInstruments(String instType,String uly,String instFamily, String instId);

    //获取交割和行权记录 Get Delivery/Exercise History
    JSONObject getDeliveryExerciseHistory(String instType,String uly,String instFamily,String after,String before,String limit);

    //获取持仓总量 Get Open Interest
    JSONObject getOpenInterest(String instType,String uly,String instFamily	,String instId);

    //获取永续合约当前资金费率 Get Funding Rate
    JSONObject getFundingRate(String instId);

    //获取永续合约历史资金费率 Get Funding Rate History
    JSONObject getFundingRateHistory(String instId,String after,String before,String limit);

    //获取限价 Get Limit Price
    JSONObject getLimitPrice(String instId);

    //获取期权定价 Get Option Market Data
    JSONObject getOptionMarketData(String uly,String instFamily,String expTime);

    //获取预估交割/行权价格 Get Estimated Delivery/Excercise Price
    JSONObject getEstimatedDeliveryExcercisePrice(String instId);

    //获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota
    JSONObject getDiscountRateAndInterestFreeQuota(String ccy,String discountLv);

    //获取系统时间 Get System Time
    JSONObject getSystemTime();

    //获取平台公共爆仓单信息 Get Liquidation Orders
    JSONObject getLiquidationOrders(String instType,String mgnMode,String instId,String ccy,String uly,String instFamily,String alias,String state,String before,String after,String limit);

    //获取标记价格 Get Mark Price
    JSONObject getMarkPrice(String instType,String uly,String instFamily,String instId);

    //获取合约衍生品仓位档位  Get Position Tiers
    JSONObject getTier(String instType, String uly, String instFamily, String instId, String tdMode, String tier);

    //获取杠杆利率和借币限额  Get Interest Rate and Loan Quota
    JSONObject getInterestRateLoanQuota();

    //获取衍生品标的指数   Get Underlying
    JSONObject getUnderlying(String instType);

    //获取尊享借币杠杆利率和借币限额  Get Interest Rate and Loan Quota for VIP loans
    JSONObject getVipInterestRateLoanQuota();

    //获取风险准备金余额  Get insurance fund
    JSONObject getInsuranceFund(String instType,String type,String uly,String instFamily,String ccy,String before,String after,String limit);

    //张币转换 Unit convert
    JSONObject getConvertContractCoin(String type, String instId, String sz, String px, String unit,String opType);

    //获取期权公共成交数据  Get option trades
    JSONObject getOptionTrades(String instId, String instFamily, String optType);
    //获取期权价格梯度
    JSONObject getInstrumentTickBands(String instType, String instFamily);

    JSONObject getEconomicCalendar(String region, String importance, String before, String after, String limit);

    JSONObject getPremiumHistory(String instId, String after, String before, String ts);

    JSONObject getSettlementHistory(String instFamily, String after, String before, String limit);

    JSONObject getEstimatedSettlementInfo(String instId);

    JSONObject getMarketDataHistory(String module, String instType, String instIdList, String instFamilyList, String dateAggrType, String begin, String end);
}
