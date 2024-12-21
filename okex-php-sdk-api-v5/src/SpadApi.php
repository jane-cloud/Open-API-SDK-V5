<?php


namespace okv5;


class SprdApi extends Utils
{
    public function order($sprdId,$clOrdId='',$tag='',$side,$ordType,$sz,$px){
        $params = [
            'sprdId' => $sprdId,
            'clOrdId' => $clOrdId,
            'tag' => $tag,
            'side' => $side,
            'ordType' => $ordType,
            'sz' => $sz,
            'px' => $px,
        ];

        return $this->request('/api/v5/sprd/order', $params, 'POST');
    }

    public function cancelOrder($ordId='',$clOrdId=''){
        $params = [
            'ordId' => $ordId,
            'clOrdId' => $clOrdId,
        ];

        return $this->request('/api/v5/sprd/cancel-order', $params, 'POST');
    }

    public function massCancel($sprdId=''){
        $params = [
            'sprdId' => $sprdId,
        ];

        return $this->request('/api/v5/sprd/mass-cancel', $params, 'POST');
    }

    public function amendOrder($ordId='',$clOrdId='',$reqId='',$newSz='',$newPx=''){
        $params = [
            'ordId' => $ordId,
            'clOrdId' => $clOrdId,
            'reqId' => $reqId,
            'newSz' => $newSz,
            'newPx' => $newPx,
        ];

        return $this->request('/api/v5/sprd/amend-order', $params, 'POST');
    }

    public function getOrder($ordId='',$clOrdId=''){
        $params = [
            'ordId' => $ordId,
            'clOrdId' => $clOrdId,
        ];

        return $this->request('/api/v5/sprd/order', $params, 'GET');
    }

    public function ordersPending($sprdId='',$ordType='',$state='',$beginId='',$endId='',$limit=''){
        $params = [
            'sprdId' => $sprdId,
            'ordType' => $ordType,
            'state' => $state,
            'beginId' => $beginId,
            'endId' => $endId,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/sprd/orders-pending', $params, 'GET');
    }

    public function ordersHistory($sprdId='',$ordType='',$state='',$beginId='',$endId='',$begin='',$end='',$limit=''){
        $params = [
            'sprdId' => $sprdId,
            'ordType' => $ordType,
            'state' => $state,
            'beginId' => $beginId,
            'endId' => $endId,
            'begin' => $begin,
            'end' => $end,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/sprd/orders-history', $params, 'GET');
    }

    public function ordersHistoryArchive($sprdId='',$ordType='',$state='',$instType='',$instFamily='',$beginId='',$endId='',$begin='',$end='',$limit=''){
        $params = [
            'sprdId' => $sprdId,
            'ordType' => $ordType,
            'state' => $state,
            'instType' => $instType,
            'instFamily' => $instFamily,
            'beginId' => $beginId,
            'endId' => $endId,
            'begin' => $begin,
            'end' => $end,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/sprd/orders-history-archive', $params, 'GET');
    }

    public function trades($sprdId='',$tradeId='',$ordId='',$beginId='',$endId='',$begin='',$end='',$limit=''){
        $params = [
            'sprdId' => $sprdId,
            'tradeId' => $tradeId,
            'ordId' => $ordId,
            'beginId' => $beginId,
            'endId' => $endId,
            'begin' => $begin,
            'end' => $end,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/sprd/trades', $params, 'GET');
    }

    public function spreads($baseCcy='',$instId='',$sprdId='',$state=''){
        $params = [
            'baseCcy' => $baseCcy,
            'instId' => $instId,
            'sprdId' => $sprdId,
            'state' => $state,
        ];

        return $this->request('/api/v5/sprd/spreads', $params, 'GET');
    }

    public function books($sprdId,$sz=''){
        $params = [
            'sprdId' => $sprdId,
            'sz' => $sz,
        ];

        return $this->request('/api/v5/sprd/books', $params, 'GET');
    }

    public function sprdTicker($sprdId){
        $params = [
            'sprdId' => $sprdId,
        ];

        return $this->request('/api/v5/sprd/sprd-ticker', $params, 'GET');
    }

    public function publicTrades($sprdId=''){
        $params = [
            'sprdId' => $sprdId,
        ];

        return $this->request('/api/v5/sprd/public-trades', $params, 'GET');
    }

    public function sprdCandles($sprdId,$bar='',$after='',$before='',$limit=''){
        $params = [
            'sprdId' => $sprdId,
            'bar' => $bar,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/sprd/sprd-candles', $params, 'GET');
    }

    public function sprdHistoryCandles($sprdId,$bar='',$after='',$before='',$limit=''){
        $params = [
            'sprdId' => $sprdId,
            'bar' => $bar,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/sprd/sprd-history-candles', $params, 'GET');
    }

    public function cancelAllAfter($timeOut){
        $params = [
            'timeOut' => $timeOut,
        ];

        return $this->request('/api/v5/sprd/cancel-all-after', $params, 'POST');
    }

}
