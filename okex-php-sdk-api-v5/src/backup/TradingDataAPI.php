<?php

namespace okv3;

class TradingDataAPI extends Utils {

    # future api
    const INFO_PREFIX_URL = '/api/information/v3';

    // 公共-多空持仓人数比
    public function getLongShortRatio($currency, $start='', $end='', $granularity='')
    {
        $params = ['currency' => $currency];

        if ($start) $params['start'] = $start;
        if ($end) $params['end'] = $end;
        if ($granularity) $params['granularity'] = $granularity;

        return $this->request(self::INFO_PREFIX_URL."/$currency".'/long_short_ratio', $params, 'GET');
    }

    // 公共-持仓总量及交易量
    public function getVolume($currency, $start='', $end='', $granularity='')
    {
        $params = ['currency' => $currency];

        if ($start) $params['start'] = $start;
        if ($end) $params['end'] = $end;
        if ($granularity) $params['granularity'] = $granularity;

        return $this->request(self::INFO_PREFIX_URL."/$currency".'/volume', $params, 'GET');
    }

    public function getTaker($currency, $start='', $end='', $granularity='')
    {
        $params = ['currency' => $currency];

        if ($start) $params['start'] = $start;
        if ($end) $params['end'] = $end;
        if ($granularity) $params['granularity'] = $granularity;

        return $this->request(self::INFO_PREFIX_URL."/$currency".'/taker', $params, 'GET');
    }

    public function getSentiment($currency, $start='', $end='', $granularity='')
    {
        $params = ['currency' => $currency];

        if ($start) $params['start'] = $start;
        if ($end) $params['end'] = $end;
        if ($granularity) $params['granularity'] = $granularity;

        return $this->request(self::INFO_PREFIX_URL."/$currency".'/sentiment', $params, 'GET');
    }

    public function getMargin($currency, $start='', $end='', $granularity='')
    {
        $params = ['currency' => $currency];

        if ($start) $params['start'] = $start;
        if ($end) $params['end'] = $end;
        if ($granularity) $params['granularity'] = $granularity;

        return $this->request(self::INFO_PREFIX_URL."/$currency".'/margin', $params, 'GET');
    }

}
