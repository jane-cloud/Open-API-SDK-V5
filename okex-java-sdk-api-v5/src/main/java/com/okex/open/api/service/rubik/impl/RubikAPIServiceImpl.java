package com.okex.open.api.service.rubik.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.client.APIClient;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.account.impl.AccountAPI;
import com.okex.open.api.service.rubik.RubikAPIService;

public class RubikAPIServiceImpl implements RubikAPIService {

    private APIClient client;
    private RubikAPI api;

    public RubikAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(RubikAPI.class);
    }

    //获取交易大数据数据支持币种 Get support coin
    @Override
    public JSONObject getSupportCoin() {
        return this.client.executeSync(this.api.getSupportCoin());
    }

    //获取币币或衍生品主动买入/卖出情况 Get taker volume
    @Override
    public JSONObject getTakerVolume(String ccy,String instType,String begin,String end,String period) {
        return this.client.executeSync(this.api.getTakerVolume(ccy, instType, begin, end, period));
    }

    //获取杠杆多空比 Get Margin lending ratio
    @Override
    public JSONObject getLoanRatio(String ccy,String begin,String end,String period) {
        return this.client.executeSync(this.api.getLoanRatio(ccy, begin, end, period));
    }

    //获取多空持仓人数比 Get Long/Short ratio
    @Override
    public JSONObject getLongShortAccountRatio(String ccy, String begin, String end, String period) {
        return this.client.executeSync(this.api.getLongShortAccountRatio(ccy, begin, end, period));
    }

    //获取持仓总量及交易量 Get contracts open interest and volume
    @Override
    public JSONObject getOpenInterestVolume(String ccy, String begin, String end, String period) {
        return this.client.executeSync(this.api.getOpenInterestVolume(ccy, begin, end, period));
    }

    //获取期权合约持仓总量及交易量 Get Options open interest and volume
    @Override
    public JSONObject getOptionOpenInterestVolume(String ccy, String period) {
        return this.client.executeSync(this.api.getOptionOpenInterestVolume(ccy,period));
    }

    ////看涨/看跌期权合约 持仓总量比/交易总量比 Get Put/Call ratio
    @Override
    public JSONObject getOpenInterestVolumeRatio(String ccy, String period) {
        return this.client.executeSync(this.api.getOpenInterestVolumeRatio(ccy,period));
    }

    //看涨看跌持仓总量及交易总量（按到期日分） Get open interest and volume (expiry)
    @Override
    public JSONObject getOpenInterestVolumeExpiry(String ccy, String period) {
        return this.client.executeSync(this.api.getOpenInterestVolumeExpiry(ccy,period));
    }

    //看涨看跌持仓总量及交易总量（按执行价格分） Get open interest and volume (strike)
    @Override
    public JSONObject getOpenInterestVolumeStrike(String ccy, String expTime, String period) {
        return this.client.executeSync(this.api.getOpenInterestVolumeStrike(ccy,expTime,period));
    }

    ////看跌/看涨期权合约 主动买入/卖出量 Get Taker flow
    @Override
    public JSONObject getTakerBlockVolume(String ccy, String period) {
        return this.client.executeSync(this.api.getTakerBlockVolume(ccy,period));
    }

    @Override
    public JSONObject getOpenInterestHistory(String instId, String period, String end, String begin, String limit) {
        return this.client.executeSync(this.api.getOpenInterestHistory(instId,  period,  end,  begin,  limit));
    }

    @Override
    public JSONObject getTakerVolumeContract(String instId, String period, String unit, String end, String begin, String limit) {
        return this.client.executeSync(this.api.getTakerVolumeContract(instId,  period, unit, end,  begin,  limit));
    }

    @Override
    public JSONObject getTopLongShortRatio(String instId, String period, String end, String begin, String limit) {
        return this.client.executeSync(this.api.getTopLongShortRatio(instId,  period,  end,  begin,  limit));
    }

    @Override
    public JSONObject getTopLongShortPosRatio(String instId, String period, String end, String begin, String limit) {
        return this.client.executeSync(this.api.getTopLongShortPosRatio(instId,  period,  end,  begin,  limit));
    }

    @Override
    public JSONObject getLongShortRatio(String instId, String period, String end, String begin, String limit) {
        return this.client.executeSync(this.api.getLongShortRatio(instId,  period,  end,  begin,  limit));
    }

}
