<?php


namespace okv5;


class FundingApi extends Utils
{
//
    public function getDepositAddress($ccy)
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/asset/deposit-address',$params, 'GET');
    }

    //
    public function getBalance($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];
        return $this->request('/api/v5/asset/balances',$params, 'GET');
    }

    //
    public function transfer($ccy,$amt,$type='',$from,$to,$subAcct='',$instId='',$toInstId='',$loanTrans='')
    {
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'type' => $type,
            'from' => $from,
            'to' => $to,
            'subAcct' => $subAcct,
            'instId' => $instId,
            'toInstId' => $toInstId,
            'loanTrans' => $loanTrans,
        ];

        return $this->request('/api/v5/asset/transfer',$params, 'POST');
    }

    public function transferState($transId,$type='')
    {
        $params = [
            'transId' => $transId,
            'type' => $type,
        ];

        return $this->request('/api/v5/asset/transfer-state',$params, 'GET');
    }

    public function withdrawal($ccy,$chain='',$amt,$dest,$toAddr,$pwd,$fee)
    {
        $params = [
            'ccy' => $ccy,
            'chain' => $chain,
            'amt' => $amt,
            'dest' => $dest,
            'toAddr' => $toAddr,
            'pwd' => $pwd,
            'fee' => $fee,
        ];

        return $this->request('/api/v5/asset/withdrawal',$params, 'POST');
    }

    public function getDepositHistory($ccy='',$state='',$after='',$before='',$limit='',$txId='')
    {
        $params = [
            'ccy' => $ccy,
            'state' => $state,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
            'txId' => $txId,
        ];

        return $this->request('/api/v5/asset/deposit-history',$params, 'GET');
    }

    public function getWithdrawalHistory($ccy='',$state='',$after='',$before='',$limit='',$txId='')
    {
        $params = [
            'ccy' => $ccy,
            'state' => $state,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
            'txId' => $txId,
        ];

        return $this->request('/api/v5/asset/withdrawal-history',$params, 'GET');
    }

    public function getCurrencies()
    {
        return $this->request('/api/v5/asset/currencies','', 'GET');
    }

    public function PurchaseRedempt($ccy,$amt,$side,$rate='')
    {
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'side' => $side,
            'rate' => $rate,
        ];

        return $this->request('/api/v5/asset/purchase_redempt',$params, 'POST');
    }

    public function getBills($ccy='',$type='',$after='',$before='',$limit='')
    {
        $params = [
            'ccy' => $ccy,
            'type' => $type,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/asset/bills',$params, 'GET');
    }

    public function getPiggyBalance($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/asset/saving-balance',$params, 'GET');
    }

    public function depositLightning($ccy,$amt,$to='')
    {
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'to' => $to,
        ];

        return $this->request('/api/v5/asset/deposit-lightning',$params, 'GET');
    }

    public function withdrawalLightning($ccy,$invoice,$pwd)
    {
        $params = [
            'ccy' => $ccy,
            'invoice' => $invoice,
            'pwd' => $pwd,
        ];

        return $this->request('/api/v5/asset/withdrawal-lightning',$params, 'POST');
    }

    public function assetValuation($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/asset/asset-valuation',$params, 'GET');
    }

    public function setLendingRate($ccy,$rate)
    {
        $params = [
            'ccy' => $ccy,
            'rate' => $rate,
        ];

        return $this->request('/api/v5/asset/set-lending-rate',$params, 'POST');
    }

    public function lendingHistory($ccy='',$after='',$before='',$limit='')
    {
        $params = [
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/asset/lending-history',$params, 'GET');
    }

    public function lendingRateSummary($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/asset/lending-rate-summary',$params, 'GET');
    }

    public function lendingRateHistory($ccy='',$after='',$before='',$limit='')
    {
        $params = [
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/asset/lending-rate-history',$params, 'GET');
    }
}
