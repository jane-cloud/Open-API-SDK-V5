<?php


namespace okv3;


class TradeAPI extends Utils
{
    public function order($instId,$tdMode,$ccy='',$clOrdId='',$tag='',$side,$posSide='',$ordType,$sz,$px='',$reduceOnly='')
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
        ];

        return $this->request('/api/v5/trade/order', $params, 'POST');
    }

    public function batchOrders($instId,$tdMode,$ccy='',$clOrdId='',$tag='',$side,$posSide='',$ordType,$sz,$px='',$reduceOnly='')
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
        ];

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

    public function closePosition($instId,$posSide='',$mgnMode,$ccy='')
    {
        $params = [
            'instId' => $instId,
            'posSide' => $posSide,
            'mgnMode' => $mgnMode,
            'ccy' => $ccy,
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

    public function getOrdersHistory($instType='',$uly='',$instId='',$ordType='',$state='',$after='',$before='',$limit='')
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

        return $this->request('/api/v5/trade/orders-history', $params, 'GET');
    }

    public function getOrdersHistoryArchive($instType='',$uly='',$instId='',$ordType='',$state='',$after='',$before='',$limit='')
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

    public function orderAlgo($instId,$tdMode,$ccy='',$side,$posSide='',$ordType,$sz,$reduceOnly='',$triggerPx='',$orderPx='')
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
        ];

        return $this->request('/api/v5/trade/order-algo', $params, 'POST');
    }

    public function cancelAlgos($algoId,$instId)
    {
        $params = [
            'algoId' => $algoId,
            'instId' => $instId,
        ];

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
}
