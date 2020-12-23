<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2020/4/21
 * Time: 11:20 PM
 */

namespace okv3;

class OthersAPI extends Utils
{

    #
    const SERVER_TIME = '/api/general/v3/time';
    const CONSTITUENTS = '/api/index/v3/';
    const STATUS = '/api/system/v3/status';

    //
    public function getServerTime()
    {
        return $this->request(self::SERVER_TIME,'','GET');
    }

    //
    public function getConstituents($instrument_id)
    {
        return $this->request(self::CONSTITUENTS . $instrument_id . '/constituents',[],'GET');
    }

    //
    public function getStatus($status)
    {
        $params = [];

        if ("status") $params['status'] = $status;

        return $this->request(self::STATUS,$params,'GET');
    }
}
