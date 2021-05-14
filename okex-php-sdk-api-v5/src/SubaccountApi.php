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

    public function deleteApikey($pwd,$subAcct,$apiKey){
        $params = [
            'pwd' => $pwd,
            'subAcct' => $subAcct,
            'apiKey' => $apiKey,
        ];

        return $this->request('/api/v5/users/subaccount/delete-apikey', $params, 'POST');
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

    public function apikey($pwd,$subAcct,$label,$Passphrase,$perm='',$ip=''){
        $params = [
            'pwd' => $pwd,
            'subAcct' => $subAcct,
            'label' => $label,
            'Passphrase' => $Passphrase,
            'perm' => $perm,
            'ip' => $ip,
        ];

        return $this->request('/api/v5/users/subaccount/apikey', $params, 'POST');
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

    public function transfer($ccy,$amt,$form,$to,$fromSubAccount,$toSubAccount){
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'form' => $form,
            'to' => $to,
            'fromSubAccount' => $fromSubAccount,
            'toSubAccount' => $toSubAccount,
        ];

        return $this->request('/api/v5/asset/subaccount/transfer', $params, 'POST');
    }
}
