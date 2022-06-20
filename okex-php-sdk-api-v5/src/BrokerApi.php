<?php


namespace okv5;


class BrokerApi extends Utils
{
    public function info(){
        $params = [
        ];

        return $this->request('/api/v5/broker/nd/info', $params, 'GET');
    }

    public function createSubaccount($subAcct,$label='',$acctLv){
        $params = [
            'subAcct' => $subAcct,
            'label' => $label,
            'acctLv' => $acctLv,
        ];

        return $this->request('/api/v5/broker/nd/create-subaccount', $params, 'POST');
    }

    public function deleteSubaccount($subAcct){
        $params = [
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

    public function setSubaccountFeeRate($subAcct='',$instType='',$chgType,$chgTaker='',$chgMaker='',$effDate=''){
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

    public function modifySubaccountDepositAddress($subAcct,$ccy,$chain='',$addr,$to){
        $params = [
            'subAcct' => $subAcct,
            'ccy' => $ccy,
            'chain' => $chain,
            'addr' => $addr,
            'to' => $to,
        ];

        return $this->request('/api/v5/asset/broker/nd/modify-subaccount-deposit-address', $params, 'POST');
    }

    public function getSubaccountDepositAddress($subAcct,$ccy){
        $params = [
            'subAcct' => $subAcct,
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/asset/broker/nd/subaccount-deposit-address', $params, 'GET');
    }

    public function subaccountDepositHistory($subAcct='',$ccy='',$txId='',$state='',$after='',$before='',$limit=''){
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

    public function rebatePerOrders($type='',$begin='',$end=''){
        $params = [
            'type' => $type,
            'begin' => $begin,
            'end' => $end,
        ];

        return $this->request('/api/v5/broker/nd/rebate-per-orders', $params, 'GET');
    }

    public function PostrebatePerOrders($begin,$end){
        $params = [
            'begin' => $begin,
            'end' => $end,
        ];

        return $this->request('/api/v5/broker/nd/rebate-per-orders', $params, 'POST');
    }

    public function apikey($subAcct,$label,$passphrase,$ip='',$perm=''){
        $params = [
            'subAcct' => $subAcct,
            'label' => $label,
            'passphrase' => $passphrase,
            'ip' => $ip,
            'perm' => $perm,
        ];

        return $this->request('/api/v5/broker/nd/subaccount/apikey', $params, 'POST');
    }

    public function getApikey($subAcct,$apiKey=''){
        $params = [
            'subAcct' => $subAcct,
            'apiKey' => $apiKey,
        ];

        return $this->request('/api/v5/broker/nd/subaccount/apikey', $params, 'GET');
    }

    public function modifyApikey($subAcct,$apiKey,$label,$perm,$ip=''){
        $params = [
            'subAcct' => $subAcct,
            'apiKey' => $apiKey,
            'label' => $label,
            'perm' => $perm,
            'ip' => $ip,
        ];

        return $this->request('/api/v5/broker/nd/subaccount/modify-apikey', $params, 'POST');
    }

    public function deleteApikey($subAcct,$apiKey){
        $params = [
            'subAcct' => $subAcct,
            'apiKey' => $apiKey,
        ];

        return $this->request('/api/v5/broker/nd/subaccount/delete-apikey', $params, 'POST');
    }

}
