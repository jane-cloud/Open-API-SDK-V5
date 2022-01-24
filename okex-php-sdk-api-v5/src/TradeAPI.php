<?php


namespace okv5;


class TradeAPI extends Utils
{
    public function order($instId,$tdMode,$ccy='',$clOrdId='',$tag='',$side,$posSide='',$ordType,$sz,$px='',$reduceOnly='',$tgtCcy='')
    {
        $params = [
            'instId' => $instId,
            'tdMode' => $tdMode,
            'ccy' => $ccy,
            'clOrdId' => $clOrdId,
            'tag' => $tag,
            'side' => $side,
            'posSide' => $posSide,
            'ordType' => $ordType,
            'sz' => $sz,
            'px' => $px,
            'reduceOnly' => $reduceOnly,
            'tgtCcy' => $tgtCcy,
        ];

        return $this->request('/api/v5/trade/order', $params, 'POST');
    }

    public function batchOrders($data)
    {
        foreach ($data as $k => $v){
            $params[] = [
                'instId' => $data[$k][0],
                'tdMode' => $data[$k][1],
                'ccy' => $data[$k][2],
                'clOrdId' => $data[$k][3],
                'tag' => $data[$k][4],
                'side' => $data[$k][5],
                'posSide' => $data[$k][6],
                'ordType' => $data[$k][7],
                'sz' => $data[$k][8],
                'px' => $data[$k][9],
                'reduceOnly' => $data[$k][10],
            ];
        }

        return $this->request('/api/v5/trade/batch-orders', $params, 'POST');
    }

    public function cancelOrder($instId,$ordId,$clOrdId)
    {
        $params = [
            'instId' => $instId,
            'ordId' => $ordId,
            'clOrdId' => $clOrdId,
        ];

        return $this->request('/api/v5/trade/cancel-order', $params, 'POST');
    }
    public function cancelBatchOrder($data)
    {
        foreach ($data as $k => $v){
            $params[] = [
                'instId' => $data[$k][0],
                'ordId' => $data[$k][1],
                'clOrdId' => $data[$k][2],
            ];
        }


        return $this->request('/api/v5/trade/cancel-batch-orders', $params, 'POST');
    }

    public function amendOrder($instId,$cxlOnFail='',$ordId='',$clOrdId='',$reqId='',$newSz='',$newPx='')
    {
        $params = [
            'instId' => $instId,
            'cxlOnFail' => $cxlOnFail,
            'ordId' => $ordId,
            'clOrdId' => $clOrdId,
            'reqId' => $reqId,
            'newSz' => $newSz,
            'newPx' => $newPx
        ];

        return $this->request('/api/v5/trade/amend-order', $params, 'POST');
    }
    public function amendBatchOrder($data)
    {
        foreach ($data as $k => $v){
            $params[] = [
                'instId' => $data[$k][0],
                'cxlOnFail' => $data[$k][1],
                'ordId' => $data[$k][2],
                'clOrdId' => $data[$k][3],
                'reqId' => $data[$k][4],
                'newSz' => $data[$k][5],
                'newPx' => $data[$k][6],
            ];
        }

        return $this->request('/api/v5/trade/amend-batch-orders', $params, 'POST');
    }

    public function closePosition($instId,$posSide='',$mgnMode,$ccy='',$autoCxl='')
    {
        $params = [
            'instId' => $instId,
            'posSide' => $posSide,
            'mgnMode' => $mgnMode,
            'ccy' => $ccy,
            'autoCxl' => $autoCxl,
        ];

        return $this->request('/api/v5/trade/close-position', $params, 'POST');
    }

    public function getOrder($instId,$ordId='',$clOrdId='')
    {
        $params = [
            'instId' => $instId,
            'ordId' => $ordId,
            'clOrdId' => $clOrdId,
        ];

        return $this->request('/api/v5/trade/order', $params, 'GET');
    }

    public function getOrderPending($instType='',$uly='',$instId='',$ordType='',$state='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
            'ordType' => $ordType,
            'state' => $state,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/trade/orders-pending', $params, 'GET');
    }

    public function getOrdersHistory($instType='',$uly='',$instId='',$ordType='',$state='',$category='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
            'ordType' => $ordType,
            'state' => $state,
            'category' => $category,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/trade/orders-history', $params, 'GET');
    }

    public function getOrdersHistoryArchive($instType='',$uly='',$instId='',$ordType='',$state='',$category='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
            'ordType' => $ordType,
            'state' => $state,
            'category' => $category,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/trade/orders-history-archive', $params, 'GET');
    }

    public function getFills($instType='',$uly='',$instId='',$ordId='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
            'ordId' => $ordId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/trade/fills', $params, 'GET');
    }

    public function getFillsHistory($instType='',$uly='',$instId='',$ordId='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instId' => $instId,
            'ordId' => $ordId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/trade/fills-history', $params, 'GET');
    }

    public function orderAlgo($instId,$tdMode,$ccy='',$side,$posSide='',$ordType,$sz,$reduceOnly='',$triggerPx='',$orderPx='',$tpTriggerPx='',$tpTriggerPxType='',$tpOrdPx='',$slTriggerPx='',$slTriggerPxType='',$slOrdPx='',$pxVar='',$pxSpread='',$szLimit='',$pxLimit='',$timeInterval='',$tag='',$tgtCcy='',$callbackRatio='',$callbackSpread='',$activePx='',$triggerPxType='')
    {
        $params = [
            'instId' => $instId,
            'tdMode' => $tdMode,
            'ccy' => $ccy,
            'side' => $side,
            'posSide' => $posSide,
            'ordType' => $ordType,
            'sz' => $sz,
            'triggerPx' => $triggerPx,
            'orderPx' => $orderPx,
            'tpTriggerPx' => $tpTriggerPx,
            'tpTriggerPxType' => $tpTriggerPxType,
            'tpOrdPx' => $tpOrdPx,
            'slTriggerPx' => $slTriggerPx,
            'slOrdPx' => $slOrdPx,
            'pxVar' => $pxVar,
            'pxSpread' => $pxSpread,
            'szLimit' => $szLimit,
            'pxLimit' => $pxLimit,
            'timeInterval' => $timeInterval,
            'reduceOnly' => $reduceOnly,
            'slTriggerPxType' => $slTriggerPxType,
            'tag' => $tag,
            'tgtCcy' => $tgtCcy,
            'callbackRatio' => $callbackRatio,
            'callbackSpread' => $callbackSpread,
            'activePx' => $activePx,
            'triggerPxType' => $triggerPxType,
        ];

        return $this->request('/api/v5/trade/order-algo', $params, 'POST');
    }

    public function cancelAlgos($data)
    {
        foreach ($data as $k => $v){
            $params[] = [
                'algoId' => $data[$k][0],
                'instId' => $data[$k][1],
            ];
        }


        return $this->request('/api/v5/trade/cancel-algos', $params, 'POST');
    }

    public function getAlgoPending($algoId='',$instType='',$instId='',$ordType,$after='',$before='',$limit='')
    {
        $params = [
            'algoId' => $algoId,
            'instType' => $instType,
            'instId' => $instId,
            'ordType' => $ordType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/trade/orders-algo-pending', $params, 'GET');
    }

    public function getAlgoHistory($state='',$algoId='',$instType='',$instId='',$ordType,$after='',$before='',$limit='')
    {
        $params = [
            'state' => $state,
            'algoId' => $algoId,
            'instType' => $instType,
            'instId' => $instId,
            'ordType' => $ordType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/trade/orders-algo-history', $params, 'GET');
    }

    public function cancelAdvanceAlgos($algoId,$instId)
    {
        $params = [
            'algoId' => $algoId,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/trade/cancel-advance-algos', $params, 'GET');
    }
}
