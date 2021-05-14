<?php


namespace okv5;


class StatusApi extends Utils
{
    public function getStatus($state=''){
        $params = [
            'state' => $state,
        ];

        return $this->request('/api/v5/system/status', $params, 'GET');
    }

}
