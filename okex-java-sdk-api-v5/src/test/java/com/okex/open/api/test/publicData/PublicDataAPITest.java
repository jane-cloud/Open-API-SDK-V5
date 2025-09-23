package com.okex.open.api.test.publicData;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.publicData.PublicDataAPIService;
import com.okex.open.api.service.publicData.impl.PublicDataAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class PublicDataAPITest extends PublicDataAPIBaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(PublicDataAPITest.class);

    private PublicDataAPIService publicDataAPIService;

    @Before
    public void before() {
        config = config();
        publicDataAPIService = new PublicDataAPIServiceImpl(config);
    }


    /**
     * 获取交易产品基础信息 Get Instruments
     * GET /api/v5/public/instruments
     */
    @Test
    public void getInstruments(){
        JSONObject result = publicDataAPIService.getInstruments("SPOT",null,"","BTC-USDT");
        toResultString(LOG, "result", result);

    }


    /**
     * 获取交割和行权记录 Get Delivery/Exercise History
     * GET /api/v5/public/delivery-exercise-history
     */
    @Test
    public void getDeliveryExerciseHistory(){
        JSONObject result = publicDataAPIService.getDeliveryExerciseHistory("OPTION","BTC-USD","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取持仓总量 Get Open Interest
     * GET /api/v5/public/open-interest
     */
    @Test
    public void getOpenInterest(){
        JSONObject result = publicDataAPIService.getOpenInterest("FUTURES","LTC-USDT","","LTC-USDT-210416");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取永续合约当前资金费率 Get Funding Rate
     * GET /api/v5/public/funding-rate
     */
    @Test
    public void getFundingRate(){
        JSONObject result = publicDataAPIService.getFundingRate("BTC-USDT-SWAP");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取永续合约历史资金费率 Get Funding Rate History
     * GET /api/v5/public/funding-rate-history
     */
    @Test
    public void getFundingRateHistory(){
        JSONObject result = publicDataAPIService.getFundingRateHistory("ETH-USD-SWAP","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取限价 Get Limit Price
     * GET /api/v5/public/price-limit
     */
    @Test
    public void getLimitPrice(){
        JSONObject result = publicDataAPIService.getLimitPrice("BTC-USD-210326");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取期权定价 Get Option Market Data
     * GET /api/v5/public/opt-summary
     */
    @Test
    public void getOptionMarketData(){
        JSONObject result = publicDataAPIService.getOptionMarketData("BTC-USD","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取预估交割/行权价格 Get Estimated Delivery/Excercise Price
     * GET /api/v5/public/estimated-price
     */
    @Test
    public void getEstimatedDeliveryExcercisePrice(){
        JSONObject result = publicDataAPIService.getEstimatedDeliveryExcercisePrice("BTC-USD-210326");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota
     * GET /api/v5/public/discount-rate-interest-free-quota
     */
    @Test
    public void getDiscountRateAndInterestFreeQuota(){
        JSONObject result = publicDataAPIService.getDiscountRateAndInterestFreeQuota(null,"");
        toResultString(LOG, "result", result);
    }


    /**
     * 获取系统时间 Get System Time
     * GET /api/v5/public/time
     */
    @Test
    public void getSystemTime(){
        JSONObject result = publicDataAPIService.getSystemTime();
        toResultString(LOG, "result", result);
    }



    /**
     * 获取平台公共爆仓单信息 Get Liquidation Orders
     * GET /api/v5/public/liquidation-orders
     */
    @Test
    public void getLiquidationOrders(){
        JSONObject result = publicDataAPIService.getLiquidationOrders("FUTURES","",null,null,null,"BTC-USDT","quarter","filled",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取标记价格 Get Mark Price
     * GET /api/v5/public/mark-price
     */
    @Test
    public void getMarkPrice(){
        JSONObject result = publicDataAPIService.getMarkPrice("FUTURES","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取合约衍生品仓位档位   Get Position Tiers
     * GET /api/v5/public/tier
     */
    @Test
    public void getTier(){
        JSONObject result = publicDataAPIService.getTier("FUTURES","BTC-USDT","",null,"isolated",null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取杠杆利率和借币限额  Get Interest Rate and Loan Quota
     * GET /api/v5/public/interest-rate-loan-quota
     */
    @Test
    public void getInterestRateLoanQuota(){
        JSONObject result = publicDataAPIService.getInterestRateLoanQuota();
        toResultString(LOG, "result", result);
    }


    /**
     * 获取衍生品标的指数  Get Underlying
     * GET /api/v5/public/underlying
     */
    @Test
    public void getUnderlying(){
        JSONObject result = publicDataAPIService.getUnderlying("SWAP");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取尊享借币杠杆利率和借币限额  Get Interest Rate and Loan Quota for VIP loans
     * GET /api/v5/public/vip-interest-rate-loan-quota
     */
    @Test
    public void getVipInterestRateLoanQuota(){
        JSONObject result = publicDataAPIService.getVipInterestRateLoanQuota();
        toResultString(LOG, "result", result);
    }

    /**
     * 获取风险准备金余额  Get insurance fund
     * GET /api/v5/public/insurance-fund
     */
    @Test
    public void getInsuranceFund(){
        JSONObject result = publicDataAPIService.getInsuranceFund("","","","","","","","");
        toResultString(LOG, "result", result);
    }


    /**
     * 张币转换  Unit convert
     * GET /api/v5/public/convert-contract-coin
     */
    @Test
    public void getConvertContractCoin(){
        JSONObject result = publicDataAPIService.getConvertContractCoin("","","","","",null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取期权公共成交数据  Get option trades
     * GET /api/v5/public/option-trades
     */
    @Test
    public void getOptionTrades(){
        JSONObject result = publicDataAPIService.getOptionTrades("BTC-USD-230303-17000-C",null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取期权价格梯度 Get instrument-tick-bands
     * GET  /api/v5/public/instrument-tick-bands
     */
    @Test
    public void getInstrumentTickBands(){
        JSONObject result = publicDataAPIService.getInstrumentTickBands("",null);
        toResultString(LOG, "result", result);

    }
    /**
     * 获取经济日历数据 Get economic-calendar
     *  该接口需验证后使用。仅支持实盘服务。
     * GET /api/v5/public/economic-calendar
     */
    @Test
    public void getEconomicCalendar(){
        JSONObject result = publicDataAPIService.getEconomicCalendar("","","","","");
        toResultString(LOG, "result", result);

    }
    /**
     * 获取溢价历史数据 Get premium-history
     *
     * GET /api/v5/public/premium-history
     */
    @Test
    public void getPremiumHistory(){
        JSONObject result = publicDataAPIService.getPremiumHistory("","","","");
        toResultString(LOG, "result", result);

    }

    /**
     * 获取交割结算记录Get settlement-history
     *
     * GET /api/v5/public/settlement-history
     */
    @Test
    public void getSettlementHistory(){
        JSONObject result = publicDataAPIService.getSettlementHistory("","","","");
        toResultString(LOG, "result", result);

    }

    /**
     * 获取交割预估结算价格Get estimated-settlement-info
     *
     * GET /api/v5/public/estimated-settlement-info
     */
    @Test
    public void getEstimatedSettlementInfo(){
        JSONObject result = publicDataAPIService.getEstimatedSettlementInfo("");
        toResultString(LOG, "result", result);

    }
    /**
     * 获取历史市场数据Get market-data-history
     *
     * GET /api/v5/public/market-data-history
     */
    @Test
    public void getMarketDataHistory(){

        JSONObject result = publicDataAPIService.getMarketDataHistory("1","SPOT","BTC-USDT,ETH-USDT","","daily","1756604295000","1756777095000");
        toResultString(LOG, "result", result);

    }
}
