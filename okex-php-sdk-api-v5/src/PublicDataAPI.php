<?php


namespace okv5;


class PublicDataAPI extends Utils
{
    public function getInstruments($instType,$uly='',$instId='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/instruments',$params, 'GET');
    }

    public function getDeliveryExerciseHistory($instType,$uly,$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/public/delivery-exercise-history',$params, 'GET');
    }

    public function getOpenInterest($instType,$uly='',$instId='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/open-interest',$params, 'GET');
    }

    public function getFundingRate($instId)
    {
        $params = [
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/funding-rate',$params, 'GET');
    }

    public function getFundingRateHistory($instId,$after='',$before='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/public/funding-rate-history',$params, 'GET');
    }

    public function getPriceLimit($instId)
    {
        $params = [
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/price-limit',$params, 'GET');
    }

    public function getOptSummary($uly,$expTime='')
    {
        $params = [
            'uly' => $uly,
            'expTime' => $expTime,
        ];

        return $this->request('/api/v5/public/opt-summary',$params, 'GET');
    }

    public function getEstimatedPrice($instId)
    {
        $params = [
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/estimated-price',$params, 'GET');
    }

    public function getQuota($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/public/discount-rate-interest-free-quota',$params, 'GET');
    }

    public function getTime()
    {
        return $this->request('/api/v5/public/time','', 'GET');
    }

    public function getLiquidationOrders($instType,$mgnMode='',$instId='',$ccy='',$uly='',$alias='',$state='',$before='',$after='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'mgnMode' => $mgnMode,
            'instId' => $instId,
            'ccy' => $ccy,
            'uly' => $uly,
            'alias' => $alias,
            'state' => $state,
            'before' => $before,
            'after' => $after,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/public/liquidation-orders',$params, 'GET');
    }

    public function getMarkPrice($instType,$uly='',$instId='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/mark-price',$params, 'GET');
    }

    public function getTier($instType,$uly='',$instId='',$tdMode,$tier='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
            'tdMode' => $tdMode,
            'tier' => $tier,
        ];

        return $this->request('/api/v5/public/tier',$params, 'GET');
    }

    public function getInterestRateLoanQuota()
    {
        $params = [];

        return $this->request('/api/v5/public/interest-rate-loan-quota',$params, 'GET');
    }

    public function vipInterestRateLoanQuota()
    {
        $params = [];

        return $this->request('/api/v5/public/vip-interest-rate-loan-quota',$params, 'GET');
    }

    public function getUnderlying($instType)
    {
        $params = [
            'instType' => $instType,
        ];

        return $this->request('/api/v5/public/underlying',$params, 'GET');
    }

    public function insuranceFund($instType,$type='',$uly='',$instFamily='',$ccy='',$before='',$after='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'type' => $type,
            'uly' => $uly,
            'instFamily' => $instFamily,
            'ccy' => $ccy,
            'before' => $before,
            'after' => $after,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/public/insurance-fund',$params, 'GET');
    }

    public function convertContractCoin($type='',$instId,$sz,$px='',$unit='',$opType='')
    {
        $params = [
            'type' => $type,
            'instId' => $instId,
            'sz' => $sz,
            'px' => $px,
            'unit' => $unit,
            'opType' => $opType,
        ];

        return $this->request('/api/v5/public/convert-contract-coin',$params, 'GET');
    }

    public function instrumentTickBands($instType,$instFamily='')
    {
        $params = [
            'instType' => $instType,
            'instFamily' => $instFamily,
        ];

        return $this->request('/api/v5/public/instrument-tick-bands',$params, 'GET');
    }

    public function premiumHistory($instId,$after='',$before='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/public/premium-history',$params, 'GET');
    }

    public function indexTickers($quoteCcy='',$instId='')
    {
        $params = [
            'quoteCcy' => $quoteCcy,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/market/index-tickers',$params, 'GET');
    }

    public function indexCandles($instId,$after='',$before='',$bar='',$limit='')
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

    public function historyIndexCandles($instId,$after='',$before='',$bar='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'bar' => $bar,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/history-index-candles',$params, 'GET');
    }

    public function markPriceCandles($instId,$after='',$before='',$bar='',$limit='')
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

    public function historyMarkPriceCandles($instId,$after='',$before='',$bar='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'bar' => $bar,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/history-mark-price-candles',$params, 'GET');
    }

    public function openOracle()
    {
        $params = [
        ];

        return $this->request('/api/v5/market/open-oracle',$params, 'GET');
    }

    public function exchangeRate()
    {
        $params = [
        ];

        return $this->request('/api/v5/market/exchange-rate',$params, 'GET');
    }

    public function indexComponents($index)
    {
        $params = [
            'index' => $index,
        ];

        return $this->request('/api/v5/market/index-components',$params, 'GET');
    }

    public function economicCalendar($region='',$importance='',$before='',$after='',$limit='')
    {
        $params = [
            'region' => $region,
            'importance' => $importance,
            'before' => $before,
            'after' => $after,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/market/economic-calendar',$params, 'GET');
    }

    public function estimatedPrice($instId)
    {
        $params = [
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/estimated-price',$params, 'GET');
    }

    public function estimatedSettlementInfo($instId)
    {
        $params = [
            'instId' => $instId,
        ];

        return $this->request('/api/v5/public/estimated-settlement-info',$params, 'GET');
    }

    public function settlementHistory($instFamily,$after='',$before='',$limit='')
    {
        $params = [
            'instFamily' => $instFamily,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/public/settlement-history',$params, 'GET');
    }
}
