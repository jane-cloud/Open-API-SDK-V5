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

    public function profitSharingDetails($instType='',$after='',$before='',$limit=''){
        $params = [
            'instType' => $instType,
            'instId' => $instId,
            'before' => $before,
            'limit' => $limit,

        ];

        return $this->request('/api/v5/copytrading/profit-sharing-details', $params, 'GET');
    }

    public function totalProfitSharing($instType=''){
        $params = [
            'instType' => $instType,

        ];

        return $this->request('/api/v5/copytrading/total-profit-sharing', $params, 'GET');
    }

    public function unrealizedProfitSharingDetails($instType=''){
        $params = [
            'instType' => $instType,

        ];

        return $this->request('/api/v5/copytrading/unrealized-profit-sharing-details', $params, 'GET');
    }

    public function totalUnrealizedProfitSharing($instType=''){
        $params = [
            'instType' => $instType,

        ];

        return $this->request('/api/v5/copytrading/total-unrealized-profit-sharing', $params, 'GET');
    }

    public function applyLeadTrading($instType='',$instId){
        $params = [
            'instType' => $instType,
            'instId' => $instId,

        ];

        return $this->request('/api/v5/copytrading/apply-lead-trading', $params, 'POST');
    }

    public function stopLeadTrading($instType=''){
        $params = [
            'instType' => $instType,

        ];

        return $this->request('/api/v5/copytrading/stop-lead-trading', $params, 'POST');
    }

    public function amendProfitSharingRatio($instType='',$profitSharingRatio){
        $params = [
            'instType' => $instType,
            'profitSharingRatio' => $profitSharingRatio,

        ];

        return $this->request('/api/v5/copytrading/amend-profit-sharing-ratio', $params, 'POST');
    }

    public function config(){
        $params = [

        ];

        return $this->request('/api/v5/copytrading/config', $params, 'GET');
    }

    public function firstCopySettings($instType='',$uniqueCode='',$copyMgnMode='',$copyInstIdType='',$instId='',$copyMode='',$copyTotalAmt='',$copyAmt='',$copyRatio='',$tpRatio='',$slRatio='',$slTotalAmt='',$subPosCloseType=''){
        $params = [
            'instType' => $instType,
            'uniqueCode' => $uniqueCode,
            'copyMgnMode' => $copyMgnMode,
            'copyInstIdType' => $copyInstIdType,
            'instId' => $instId,
            'copyMode' => $copyMode,
            'copyTotalAmt' => $copyTotalAmt,
            'copyAmt' => $copyAmt,
            'copyRatio' => $copyRatio,
            'tpRatio' => $tpRatio,
            'slRatio' => $slRatio,
            'slTotalAmt' => $slTotalAmt,
            'subPosCloseType' => $subPosCloseType,

        ];

        return $this->request('/api/v5/copytrading/first-copy-settings', $params, 'POST');
    }

    public function amendCopySettings($instType='',$uniqueCode='',$copyMgnMode='',$copyInstIdType='',$instId='',$copyMode='',$copyTotalAmt='',$copyAmt='',$copyRatio='',$tpRatio='',$slRatio='',$slTotalAmt='',$subPosCloseType=''){
        $params = [
            'instType' => $instType,
            'uniqueCode' => $uniqueCode,
            'copyMgnMode' => $copyMgnMode,
            'copyInstIdType' => $copyInstIdType,
            'instId' => $instId,
            'copyMode' => $copyMode,
            'copyTotalAmt' => $copyTotalAmt,
            'copyAmt' => $copyAmt,
            'copyRatio' => $copyRatio,
            'tpRatio' => $tpRatio,
            'slRatio' => $slRatio,
            'slTotalAmt' => $slTotalAmt,
            'subPosCloseType' => $subPosCloseType,

        ];

        return $this->request('/api/v5/copytrading/amend-copy-settings', $params, 'POST');
    }

    public function stopCopyTrading($instType='',$uniqueCode,$subPosCloseType=''){
        $params = [
            'instType' => $instType,
            'uniqueCode' => $uniqueCode,
            'subPosCloseType' => $subPosCloseType,

        ];

        return $this->request('/api/v5/copytrading/stop-copy-trading', $params, 'POST');
    }

    public function copySettings($instType='',$uniqueCode){
        $params = [
            'instType' => $instType,
            'uniqueCode' => $uniqueCode,

        ];

        return $this->request('/api/v5/copytrading/copy-settings', $params, 'GET');
    }

    public function batchLeverageInfo($mgnMode='',$uniqueCode,$instId=''){
        $params = [
            'mgnMode' => $mgnMode,
            'uniqueCode' => $uniqueCode,
            'instId' => $instId,

        ];

        return $this->request('/api/v5/copytrading/batch-leverage-info', $params, 'GET');
    }
    

    
}
