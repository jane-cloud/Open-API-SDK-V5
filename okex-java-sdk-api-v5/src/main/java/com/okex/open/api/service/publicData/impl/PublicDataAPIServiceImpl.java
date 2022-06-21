package com.okex.open.api.service.publicData.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.publicData.PublicDataAPIService;

public class PublicDataAPIServiceImpl implements PublicDataAPIService {
    private APIClient client;
    private PublicDataAPI api;

    public PublicDataAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(PublicDataAPI.class);
    }

    //获取交易产品基础信息 Get Instruments
    @Override
    public JSONObject getInstruments(String instType, String uly, String instId) {
        return this.client.executeSync(this.api.getInstruments(instType, uly, instId));
    }

    //获取交割和行权记录 Get Delivery/Exercise History
    @Override
    public JSONObject getDeliveryExerciseHistory(String instType, String uly, String after, String before, String limit) {
        return this.client.executeSync(this.api.getDeliveryExerciseHistory(instType, uly, after,before,limit));
    }

    //获取持仓总量 Get Open Interest
    @Override
    public JSONObject getOpenInterest(String instType, String uly, String instId) {
        return this.client.executeSync(this.api.getOpenInterest(instType, uly, instId));
    }

    //获取永续合约当前资金费率 Get Funding Rate
    @Override
    public JSONObject getFundingRate(String instId) {
        return this.client.executeSync(this.api.getFundingRate(instId));
    }

    //获取永续合约历史资金费率 Get Funding Rate History
    @Override
    public JSONObject getFundingRateHistory(String instId, String after, String before, String limit) {
        return this.client.executeSync(this.api.getFundingRateHistory(instId,after,before,limit));
    }

    //获取限价 Get Limit Price
    @Override
    public JSONObject getLimitPrice(String instId) {
        return this.client.executeSync(this.api.getLimitPrice(instId));
    }

    //获取期权定价 Get Option Market Data
    @Override
    public JSONObject getOptionMarketData(String uly, String expTime) {
        return this.client.executeSync(this.api.getOptionMarketData(uly,expTime));
    }

    //获取预估交割/行权价格 Get Estimated Delivery/Excercise Price
    @Override
    public JSONObject getEstimatedDeliveryExcercisePrice(String instId) {
        return this.client.executeSync(this.api.getEstimatedDeliveryExcercisePrice(instId));
    }

    //获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota
    @Override
    public JSONObject getDiscountRateAndInterestFreeQuota(String ccy,String discountLv) {
        return this.client.executeSync(this.api.getDiscountRateAndInterestFreeQuota(ccy,discountLv));
    }

    //获取系统时间 Get System Time
    @Override
    public JSONObject getSystemTime() {
        return this.client.executeSync(this.api.getSystemTime());
    }

    //获取平台公共爆仓单信息 Get Liquidation Orders
    @Override
    public JSONObject getLiquidationOrders(String instType, String mgnMode, String instId, String ccy, String uly, String alias, String state, String before, String after, String limit) {
        return this.client.executeSync(this.api.getLiquidationOrders(instType,mgnMode,instId,ccy,uly,alias,state,before,after,limit));
    }

    //获取标记价格 Get Mark Price
    @Override
    public JSONObject getMarkPrice(String instType, String uly, String instId) {
        return this.client.executeSync(this.api.getMarkPrice(instType,uly,instId));
    }

    //获取合约衍生品仓位档位  Get Position Tiers
    @Override
    public JSONObject getTier(String instType, String uly, String instId, String tdMode, String tier) {
        return this.client.executeSync(this.api.getTier(instType, uly, instId, tdMode, tier));
    }

    //获取杠杆利率和借币限额  Get Interest Rate and Loan Quota
    @Override
    public JSONObject getInterestRateLoanQuota() {
        return this.client.executeSync(this.api.getInterestRateLoanQuota());
    }

    //获取衍生品标的指数  Get Underlying
    @Override
    public JSONObject getUnderlying(String instType) {
        return this.client.executeSync(this.api.getUnderlying(instType));
    }

    //获取尊享借币杠杆利率和借币限额  Get Interest Rate and Loan Quota for VIP loans
    @Override
    public JSONObject getVipInterestRateLoanQuota() {
        return this.client.executeSync(this.api.getVipInterestRateLoanQuota());
    }

    //张币转换
    @Override
    public JSONObject getConvertContractCoin(String type, String instId, String sz, String px, String unit) {
        return this.client.executeSync(this.api.getConvertContractCoin(type,  instId,  sz,  px,  unit));
    }
}
