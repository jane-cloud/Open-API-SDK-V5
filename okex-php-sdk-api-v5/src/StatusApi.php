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

    public function announcements($annType='',$page=''){
        $params = [
            'annType' => $annType,
            'page' => $page,
        ];

        return $this->request('/api/v5/support/announcements', $params, 'GET');
    }

    public function announcementTypes(){
        $params = [
        ];

        return $this->request('/api/v5/support/announcement-types', $params, 'GET');
    }

}
