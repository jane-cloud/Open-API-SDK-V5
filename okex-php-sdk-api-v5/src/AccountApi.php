<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/7/30
 * Time: 12:38 PM
 */

namespace okv3;


class AccountApi extends Utils
{
    //
    public function getBalance()
    {
        return $this->request('/api/v5/account/balance', [], 'GET');
    }

    //
    public function getPositions($instType='',$instId='')
    {
        $params = [
            'instType' => $instType,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/account/positions', $params, 'GET');
    }

    public function getBills($instType='',$ccy='',$mgnMode='',$ctType='',$type='',$subType='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'ccy' => $ccy,
            'mgnMode' => $mgnMode,
            'ctType' => $ctType,
            'type' => $type,
            'subType' => $subType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/bills', $params, 'GET');
    }

    public function getBillsArchive($instType='',$ccy='',$mgnMode='',$ctType='',$type='',$subType='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'ccy' => $ccy,
            'mgnMode' => $mgnMode,
            'ctType' => $ctType,
            'type' => $type,
            'subType' => $subType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/bills-archive', $params, 'GET');
    }

    public function getConfig()
    {
        return $this->request('/api/v5/account/config', '', 'GET');
    }

    public function setPositionMode($posMode)
    {
        $params = [
            'posMode' => $posMode,
        ];
        return $this->request('/api/v5/account/set-position-mode', $params, 'POST');
    }

    public function setLeverage($instId='',$ccy='',$lever,$mgnMode,$posSide='')
    {
        $params = [
            'instId' => $instId,
            'ccy' => $ccy,
            'lever' => $lever,
            'mgnMode' => $mgnMode,
            'posSide' => $posSide,
        ];

        return $this->request('/api/v5/account/set-leverage', $params, 'POST');
    }

    public function getMaxSize($instId,$tdMode,$ccy='',$px='')
    {
        $params = [
            'instId' => $instId,
            'tdMode' => $tdMode,
            'ccy' => $ccy,
            'px' => $px,
        ];

        return $this->request('/api/v5/account/max-size', $params, 'GET');
    }

    public function getMaxAvailSize($instId,$ccy='',$tdMode,$reduceOnly='')
    {
        $params = [
            'instId' => $instId,
            'ccy' => $ccy,
            'tdMode' => $tdMode,
            'reduceOnly' => $reduceOnly,
        ];

        return $this->request('/api/v5/account/max-avail-size', $params, 'GET');
    }

    public function marginBalance($instId,$posSide,$type,$amt)
    {
        $params = [
            'instId' => $instId,
            'posSide' => $posSide,
            'type' => $type,
            'amt' => $amt,
        ];

        return $this->request('/api/v5/account/position/margin-balance', $params, 'POST');
    }

    public function getLeverage($instId,$mgnMode)
    {
        $params = [
            'instId' => $instId,
            'mgnMode' => $mgnMode,
        ];

        return $this->request('/api/v5/account/leverage-info', $params, 'GET');
    }

    public function getMaxLoan($instId)
    {
        $params = [
            'instId' => $instId,
        ];

        return $this->request('/api/v5/account/max-loan', $params, 'GET');
    }

    public function getTradeFee($instType,$instId='',$uly='',$category='')
    {
        $params = [
            'instType' => $instType,
            'instId' => $instId,
            'uly' => $uly,
            'category' => $category,
        ];

        return $this->request('/api/v5/account/trade-fee', $params, 'GET');
    }

    public function getInterestAccrued($instId='',$ccy='',$mgnMode='',$after='',$before='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
        ];

        return $this->request('/api/v5/account/interest-accrued', $params, 'GET');
    }

    public function setGreeks($greeksType)
    {
        $params = [
            'greeksType' => $greeksType,
        ];

        return $this->request('/api/v5/account/set-greeks', $params, 'POST');
    }

    public function getMaxWithdrawal($ccy)
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/account/max-withdrawal', $params, 'GET');
    }
}
