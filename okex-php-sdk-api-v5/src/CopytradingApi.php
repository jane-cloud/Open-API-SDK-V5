<?php


namespace okv5;


class Copytrading extends Utils
{

    public function currentSubpositions($instType='',$instId='',$uniqueCode='',$subPosType='',$after='',$before='',$limit=''){
        $params = [
            'instType' => $instType,
            'instId' => $instId,
            'uniqueCode' => $uniqueCode,
            'subPosType' => $subPosType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/copytrading/current-subpositions', $params, 'GET');
    }

    public function subpositionsHistory($instType='',$instId='',$subPosType='',$after='',$before='',$limit=''){
        $params = [
            'instType' => $instType,
            'instId' => $instId,
            'subPosType' => $subPosType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/copytrading/subpositions-history', $params, 'GET');
    }

    public function algoOrder($instType='',$subPosId='',$tpTriggerPx='',$slTriggerPx='',$tpOrdPx='',$slOrdPx='',$tpTriggerPxType='',$slTriggerPxType='',$tag='',$subPosType=''){
        $params = [
            'instType' => $instType,
            'subPosId' => $subPosId,
            'tpTriggerPx' => $tpTriggerPx,
            'subPosType' => $subPosType,
            'slTriggerPx' => $slTriggerPx,
            'tpOrdPx' => $tpOrdPx,
            'slOrdPx' => $slOrdPx,
            'tpTriggerPxType' => $tpTriggerPxType,
            'slTriggerPxType' => $slTriggerPxType,
            'tag' => $tag,
            'subPosType' => $subPosType,
        ];

        return $this->request('/api/v5/copytrading/algo-order', $params, 'POST');
    }

    public function closeSubposition($instType='',$subPosType='',$subPosId='',$tag='',$ordType='',$px=''){
        $params = [
            'instType' => $instType,
            'subPosType' => $subPosType,
            'subPosId' => $subPosId,
            'tag' => $tag,
            'ordType' => $ordType,
            'px' => $px,
        ];

        return $this->request('/api/v5/copytrading/close-subposition', $params, 'POST');
    }

    public function instruments($instType=''){
        $params = [
            'instType' => $instType,
        ];

        return $this->request('/api/v5/copytrading/instruments', $params, 'GET');
    }

    public function setInstruments($instType='',$instId=''){
        $params = [
            'instType' => $instType,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/copytrading/set-instruments', $params, 'POST');
    }

    public function setInstruments($instType='',$instId=''){
        $params = [
            'instType' => $instType,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/copytrading/set-instruments', $params, 'POST');
    }
    

    
}
