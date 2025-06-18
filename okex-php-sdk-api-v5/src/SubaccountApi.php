<?php


namespace okv5;


class SubaccountApi extends Utils
{
    public function balances($subAcct){
        $params = [
            'subAcct' => $subAcct,
        ];

        return $this->request('/api/v5/account/subaccount/balances', $params, 'GET');
    }

    public function bills($ccy='',$type='',$subAcct='',$after='',$before='',$limit=''){
        $params = [
            'ccy' => $ccy,
            'type' => $type,
            'subAcct' => $subAcct,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/asset/subaccount/bills', $params, 'GET');
    }

    

    public function modifyApikey($pwd,$subAcct,$label,$apiKey,$perm,$ip=''){
        $params = [
            'pwd' => $pwd,
            'subAcct' => $subAcct,
            'label' => $label,
            'apiKey' => $apiKey,
            'perm' => $perm,
            'ip' => $ip,
        ];

        return $this->request('/api/v5/users/subaccount/modify-apikey', $params, 'POST');
    }

   

   
    public function subaccountList($enable='',$subAcct='',$after='',$before='',$limit=''){
        $params = [
            'enable' => $enable,
            'subAcct' => $subAcct,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/users/subaccount/list', $params, 'GET');
    }

    public function transfer($ccy,$amt,$from,$to,$fromSubAccount,$toSubAccount,$loanTrans=''){
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'form' => $from,
            'to' => $to,
            'fromSubAccount' => $fromSubAccount,
            'toSubAccount' => $toSubAccount,
            'loanTrans' => $loanTrans,
        ];

        return $this->request('/api/v5/asset/subaccount/transfer', $params, 'POST');
    }

    public function setTransferOut($subAcct,$canTransOut=''){
        $params = [
            'subAcct' => $subAcct,
            'canTransOut' => $canTransOut,
        ];

        return $this->request('/api/v5/users/subaccount/set-transfer-out', $params, 'POST');
    }

    public function entrustSubaccountList($subAcct=''){
        $params = [
            'subAcct' => $subAcct,
        ];

        return $this->request('/api/v5/users/entrust-subaccount-list', $params, 'GET');
    }

    public function assetBalances($subAcct,$ccy=''){
        $params = [
            'subAcct' => $subAcct,
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/asset/subaccount/balances', $params, 'GET');
    }

    public function maxWithdrawal($subAcct,$ccy=''){
        $params = [
            'subAcct' => $subAcct,
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/account/subaccount/max-withdrawal', $params, 'GET');
    }

    public function managedSubaccountBills($ccy='',$type='',$subAcct='',$subUid='',$after='',$before='',$limit=''){
        $params = [
            'ccy' => $ccy,
            'type' => $type,
            'subAcct' => $subAcct,
            'subUid' => $subUid,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/asset/subaccount/managed-subaccount-bills', $params, 'GET');
    }

    public function createSubaccount($subAcct,$type,$label,$pwd=''){
        $params = [
            'subAcct' => $subAcct,
            'type' => $type,
            'label' => $label,
            'pwd' => $pwd,
        ];

        return $this->request('/api/v5/users/subaccount/create-subaccount', $params, 'POST');
    }

    public function apikey($subAcct,$label,$passphrase,$perm='',$ip=''){
        $params = [
            'subAcct' => $subAcct,
            'label' => $label,
            'passphrase' => $passphrase,
            'perm' => $perm,
            'ip' => $ip,
        ];

        return $this->request('/api/v5/users/subaccount/apikey', $params, 'POST');
    }

    public function getApikey($subAcct,$apiKey=''){
        $params = [
            'subAcct' => $subAcct,
            'apiKey' => $apiKey,
        ];

        return $this->request('/api/v5/users/subaccount/apikey', $params, 'GET');
    }

    public function deleteApikey($subAcct,$apiKey){
        $params = [
            'subAcct' => $subAcct,
            'apiKey' => $apiKey,
        ];

        return $this->request('/api/v5/users/subaccount/delete-apikey', $params, 'POST');
    }

}
