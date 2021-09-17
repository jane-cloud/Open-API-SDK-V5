package com.okex.open.api.service.rubik;

import com.alibaba.fastjson.JSONObject;
import retrofit2.http.Query;

public interface RubikAPIService {

    //获取交易大数据数据支持币种 Get support coin
    JSONObject getSupportCoin();

    //获取币币或衍生品主动买入/卖出情况 Get taker volume
    JSONObject getTakerVolume(String ccy,String instType,String begin,String end,String period);

    //获取杠杆多空比 Get Margin lending ratio
    JSONObject getLoanRatio(String ccy,String begin,String end,String period);

    //获取多空持仓人数比 Get Long/Short ratio
    JSONObject getLongShortAccountRatio(String ccy,String begin,String end,String period);

    //获取持仓总量及交易量 Get contracts open interest and volume
    JSONObject getOpenInterestVolume(String ccy,String begin,String end,String period);

    //获取期权合约持仓总量及交易量 Get Options open interest and volume
    JSONObject getOptionOpenInterestVolume(String ccy,String period);

    //看涨/看跌期权合约 持仓总量比/交易总量比 Get Put/Call ratio
    JSONObject getOpenInterestVolumeRatio(String ccy,String period);

    //看涨看跌持仓总量及交易总量（按到期日分） Get open interest and volume (expiry)
    JSONObject getOpenInterestVolumeExpiry(String ccy,String period);

    //看涨看跌持仓总量及交易总量（按执行价格分） Get open interest and volume (strike)
    JSONObject getOpenInterestVolumeStrike(String ccy,String expTime,String period);

    //看跌/看涨期权合约 主动买入/卖出量 Get Taker flow
    JSONObject getTakerBlockVolume(String ccy,String period);

}
