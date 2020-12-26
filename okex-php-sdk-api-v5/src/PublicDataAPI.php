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

    public function getQuota($ccy)
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/public/discount-rate-interest-free-quota',$params, 'GET');
    }

    public function getTime($ccy)
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
}
