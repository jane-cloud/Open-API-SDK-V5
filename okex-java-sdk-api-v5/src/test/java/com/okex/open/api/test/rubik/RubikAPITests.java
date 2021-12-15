package com.okex.open.api.test.rubik;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.rubik.RubikAPIService;
import com.okex.open.api.service.rubik.impl.RubikAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubikAPITests extends RubikAPIBaseTests{

    private static final Logger LOG = LoggerFactory.getLogger(RubikAPITests.class);

    private RubikAPIService rubikAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.rubikAPIService = new RubikAPIServiceImpl(this.config);
    }


    /**
     * 获取交易大数据数据支持币种 Get support coin
     * GET /api/v5/rubik/stat/trading-data/support-coin
     */
    @Test
    public void getSupportCoin(){
        JSONObject result = this.rubikAPIService.getSupportCoin();
        toResultString(LOG, "result", result);
    }

    /**
     * 获取币币或衍生品主动买入/卖出情况 Get taker volume
     * GET /api/v5/rubik/stat/taker-volume
     */
    @Test
    public void getTakerVolume(){
        JSONObject result = this.rubikAPIService.getTakerVolume("BTC","SPOT",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取杠杆多空比 Get Margin lending ratio
     * GET /api/v5/rubik/stat/taker-volume
     */
    @Test
    public void getLoanRatio(){
        JSONObject result = this.rubikAPIService.getLoanRatio("BTC",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取多空持仓人数比 Get Long/Short ratio
     * GET /api/v5/rubik/stat/taker-volume
     */
    @Test
    public void getLongShortAccountRatio(){
        JSONObject result = this.rubikAPIService.getLongShortAccountRatio("BTC",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取持仓总量及交易量 Get contracts open interest and volume
     * GET /api/v5/rubik/stat/taker-volume
     */
    @Test
    public void getOpenInterestVolume(){
        JSONObject result = this.rubikAPIService.getOpenInterestVolume("BTC",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取期权合约持仓总量及交易量 Get Options open interest and volume
     * GET /api/v5/rubik/stat/option/open-interest-volume
     */
    @Test
    public void getOptionOpenInterestVolume(){
        JSONObject result = this.rubikAPIService.getOptionOpenInterestVolume("BTC",null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取期权持仓量及交易量 Get Put/Call ratio
     * GET /api/v5/rubik/stat/option/open-interest-volume-ratio
     */
    @Test
    public void getOpenInterestVolumeRatio(){
        JSONObject result = this.rubikAPIService.getOpenInterestVolumeRatio("BTC",null);
        toResultString(LOG, "result", result);
    }

    /**
     * 看涨看跌持仓总量及交易总量（按到期日分） Get open interest and volume (expiry)
     * GET /api/v5/rubik/stat/option/open-interest-volume-expiry
     */
    @Test
    public void getOpenInterestVolumeExpiry(){
        JSONObject result = this.rubikAPIService.getOpenInterestVolumeExpiry("BTC",null);
        toResultString(LOG, "result", result);
    }

    /**
     * 看涨看跌持仓总量及交易总量（按执行价格分） Get open interest and volume (strike)
     * GET /api/v5/rubik/stat/option/open-interest-volume-strike
     */
    @Test
    public void getOpenInterestVolumeStrike(){
        JSONObject result = this.rubikAPIService.getOpenInterestVolumeStrike("BTC","20211231",null);
        toResultString(LOG, "result", result);
    }

    /**
     * 看跌/看涨期权合约 主动买入/卖出量 Get Taker flow
     * GET /api/v5/rubik/stat/option/taker-block-volume
     */
    @Test
    public void getTakerBlockVolume(){
        JSONObject result = this.rubikAPIService.getTakerBlockVolume("BTC",null);
        toResultString(LOG, "result", result);
    }

}
