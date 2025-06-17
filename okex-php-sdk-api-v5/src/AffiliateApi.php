<?php


namespace okv5;


class AffiliateApi extends Utils
{
    public function detail($uid){
        $params = [
            'uid' => $uid,
        ];

        return $this->request('/api/v5/affiliate/invitee/detail', $params, 'GET');
    }


}
