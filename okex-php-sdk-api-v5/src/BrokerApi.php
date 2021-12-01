<?php


namespace okv5;


class BrokerApi extends Utils
{
    public function info(){
        $params = [
        ];

        return $this->request('/api/v5/broker/nd/info', $params, 'GET');
    }

    public function createSubaccount($pwd,$subAcct,$label='',$acctLv){
        $params = [
            'pwd' => $pwd,
            'subAcct' => $subAcct,
            'label' => $label,
            'acctLv' => $acctLv,
        ];

        return $this->request('/api/v5/broker/nd/create-subaccount', $params, 'POST');
    }

    public function deleteSubaccount($pwd,$subAcct){
        $params = [
            'pwd' => $pwd,
            'subAcct' => $subAcct,
        ];

        return $this->request('/api/v5/broker/nd/delete-subaccount', $params, 'POST');
    }

    public function subaccountInfo($subAcct='',$page='',$limit=''){
        $params = [
            'subAcct' => $subAcct,
            'page' => $page,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/broker/nd/subaccount-info', $params, 'GET');
    }

    public function setSubaccountLevel($subAcct,$acctLv){
        $params = [
            'subAcct' => $subAcct,
            '$acctLv' => $acctLv,
        ];

        return $this->request('/api/v5/broker/nd/set-subaccount-level', $params, 'GET');
    }

    public function setSubaccountFeeRate($subAcct='',$instType='',$chgType='',$chgTaker='',$chgMaker='',$effDate=''){
        $params = [
            'subAcct' => $subAcct,
            'instType' => $instType,
            'chgType' => $chgType,
            'chgTaker' => $chgTaker,
            'chgMaker' => $chgMaker,
            'effDate' => $effDate,
        ];

        return $this->request('/api/v5/broker/nd/set-subaccount-fee-rate', $params, 'POST');
    }

    public function subaccountDepositAddress($subAcct,$ccy,$chain='',$addrType='',$to=''){
        $params = [
            'subAcct' => $subAcct,
            'ccy' => $ccy,
            'chain' => $chain,
            'addrType' => $addrType,
            'to' => $to,
        ];

        return $this->request('/api/v5/asset/broker/nd/subaccount-deposit-address', $params, 'POST');
    }

    public function getSubaccountDepositAddress($subAcct,$ccy){
        $params = [
            'subAcct' => $subAcct,
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/asset/broker/nd/subaccount-deposit-address', $params, 'GET');
    }

    public function subaccountDepositHistory($subAcct,$ccy='',$txId='',$state='',$after='',$before='',$limit=''){
        $params = [
            'subAcct' => $subAcct,
            'ccy' => $ccy,
            'txId' => $txId,
            'state' => $state,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/asset/broker/nd/subaccount-deposit-history', $params, 'GET');
    }

    public function rebateDaily($subAcct='',$begin='',$end='',$page='',$limit=''){
        $params = [
            'subAcct' => $subAcct,
            'begin' => $begin,
            'end' => $end,
            'page' => $page,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/broker/nd/rebate-daily', $params, 'GET');
    }

}
