<?php


namespace okv5;


class MarketDataAPI extends Utils
{
    public function getTickers($instType,$uly='')
    {
        $params = [
            'instType' => $instType,
        ];

        if (!empty($uly)){
            $params['uly'] = $uly;
        }

        return $this->request('/api/v5/market/tickers',$params, 'GET');
    }

    public function getTicker($instId)
    {
        $params = [
            'instId' => $instId,
        ];

        return $this->request('/api/v5/market/ticker',$params, 'GET');
    }

    public function getIndexTicker($quoteCcy='',$instId='')
    {
        $params = [
            'quoteCcy' => $quoteCcy,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/market/index-tickers',$params, 'GET');
    }

    public function getBooks($instId,$sz='')
    {
        $params = [
            'instId' => $instId,
            'sz' => $sz,
        ];

        return $this->request('/api/v5/market/books',$params, 'GET');
    }

    public function getCandles($instId,$after='',$before='',$bar='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'bar' => $bar,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/candles',$params, 'GET');
    }

    public function getHistoryCandles($instId,$after='',$before='',$bar='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'bar' => $bar,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/history-candles',$params, 'GET');
    }

    public function getIndexCandles($instId,$after='',$before='',$bar='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'bar' => $bar,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/index-candles',$params, 'GET');
    }

    public function getMarkPriceCandles($instId,$after='',$before='',$bar='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'bar' => $bar,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/mark-price-candles',$params, 'GET');
    }

    public function getPlatformVolume()
    {
        $params = [];

        return $this->request('/api/v5/market/platform-24-volume',$params, 'GET');
    }

    public function getTrades($instId,$limit='')
    {
        $params = [
            'instId' => $instId,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/trades',$params, 'GET');
    }

    public function getOracle()
    {
        $params = [];

        return $this->request('/api/v5/market/oracle',$params, 'GET');
    }

    public function exchangerate()
    {
        $params = [];

        return $this->request('/api/v5/market/exchange-rate',$params, 'GET');
    }

    public function indexComponents($index)
    {
        $params = [
            'index' => $index,
        ];

        return $this->request('/api/v5/market/index-components',$params, 'GET');
    }
}
