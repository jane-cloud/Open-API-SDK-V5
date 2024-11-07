<?php


namespace okv5;


class TradingbotApi extends Utils
{
    public function orderAlgo($instId,$algoOrdType,$maxPx,$minPx,$gridNum,$runType='',$tpTriggerPx='',$slTriggerPx='',$algoClOrdId='',$tag='',$profitSharingRatio='',$triggerParams='')
    {
        $params = [
            'instId' => $instId,
            'algoOrdType' => $algoOrdType,
            'maxPx' => $maxPx,
            'minPx' => $minPx,
            'gridNum' => $gridNum,
            'runType' => $runType,
            'tpTriggerPx' => $tpTriggerPx,
            'slTriggerPx' => $slTriggerPx,
            'algoClOrdId' => $algoClOrdId,
            'tag' => $tag,
            'profitSharingRatio' => $profitSharingRatio,
            'triggerParams' => $triggerParams,
        ];

        return $this->request('/api/v5/tradingBot/grid/order-algo', $params, 'POST');
    }

    public function amendOrderAlgo($algoId,$instId,$slTriggerPx='',$tpTriggerPx='',$triggerParams='',$tpRatio='',$slRatio='')
    {
        $params = [
            'algoId' => $algoId,
            'instId' => $instId,
            'slTriggerPx' => $slTriggerPx,
            'tpTriggerPx' => $tpTriggerPx,
            'triggerParams' => $triggerParams,
            'tpRatio' => $tpRatio,
            'slRatio' => $slRatio,
        ];

        return $this->request('/api/v5/tradingBot/grid/amend-order-algo', $params, 'POST');
    }

    public function stopOrderAlgo($algoId,$instId,$algoOrdType,$stopType)
    {
        $params = [
            'algoId' => $algoId,
            'instId' => $instId,
            'algoOrdType' => $algoOrdType,
            'stopType' => $stopType,
        ];

        return $this->request('/api/v5/tradingBot/grid/amend-order-algo', $params, 'POST');
    }

    public function closePosition($algoId,$mktClose,$sz='',$px='')
    {
        $params = [
            'algoId' => $algoId,
            'mktClose' => $mktClose,
            'sz' => $sz,
            'px' => $px,
        ];

        return $this->request('/api/v5/tradingBot/grid/close-position', $params, 'POST');
    }

    public function cancelCloseOrder($algoId,$ordId)
    {
        $params = [
            'algoId' => $algoId,
            'ordId' => $ordId,
        ];

        return $this->request('/api/v5/tradingBot/grid/cancel-close-order', $params, 'POST');
    }

    public function orderInstantTrigger($algoId)
    {
        $params = [
            'algoId' => $algoId,
        ];

        return $this->request('/api/v5/tradingBot/grid/order-instant-trigger', $params, 'POST');
    }

    public function ordersAlgoPending($algoOrdType,$algoId='',$instId='',$instType='',$after='',$before='',$limit='')
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
            'instId' => $instId,
            'instType' => $instType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/grid/orders-algo-pending', $params, 'GET');
    }

    public function ordersAlgoHistory($algoOrdType,$algoId='',$instId='',$instType='',$after='',$before='',$limit='')
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
            'instId' => $instId,
            'instType' => $instType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/grid/orders-algo-history', $params, 'GET');
    }

    public function ordersAlgoDetails($algoOrdType,$algoId)
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
        ];

        return $this->request('/api/v5/tradingBot/grid/orders-algo-details', $params, 'GET');
    }

    public function subOrders($algoId,$algoOrdType,$type,$groupId='',$after='',$before='',$limit='')
    {
        $params = [
            'algoId' => $algoId,
            'algoOrdType' => $algoOrdType,
            'type' => $type,
            'groupId' => $groupId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/grid/sub-orders', $params, 'GET');
    }

    public function positions($algoOrdType,$algoId)
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
        ];

        return $this->request('/api/v5/tradingBot/grid/positions', $params, 'GET');
    }

    public function withdrawIncome($algoId)
    {
        $params = [
            'algoId' => $algoId,
        ];

        return $this->request('/api/v5/tradingBot/grid/withdraw-income', $params, 'POST');
    }

    public function computeMarginBalance($algoId,$type,$amt='')
    {
        $params = [
            'algoId' => $algoId,
            'type' => $type,
            'amt' => $amt,
        ];

        return $this->request('/api/v5/tradingBot/grid/compute-margin-balance', $params, 'POST');
    }

    public function marginBalance($algoId,$type,$amt='',$percent='')
    {
        $params = [
            'algoId' => $algoId,
            'type' => $type,
            'amt' => $amt,
            'percent' => $percent,
        ];

        return $this->request('/api/v5/tradingBot/grid/margin-balance', $params, 'POST');
    }

    public function adjustInvestment($algoId,$amt)
    {
        $params = [
            'algoId' => $algoId,
            'amt' => $amt,
        ];

        return $this->request('/api/v5/tradingBot/grid/adjust-investment', $params, 'POST');
    }

    public function aiParam($algoOrdType,$instId,$direction='',$duration='')
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'instId' => $instId,
            'direction' => $direction,
            'duration' => $duration,
        ];

        return $this->request('/api/v5/tradingBot/grid/ai-param', $params, 'GET');
    }

    public function minInvestment($instId,$algoOrdType,$gridNum,$maxPx,$minPx,$runType,$direction='',$lever='',$basePos='',$investmentType='',$triggerStrategy='',$investmentData='')
    {
        $params = [
            'instId' => $instId,
            'algoOrdType' => $algoOrdType,
            'gridNum' => $gridNum,
            'maxPx' => $maxPx,
            'minPx' => $minPx,
            'runType' => $runType,
            'direction' => $direction,
            'lever' => $lever,
            'basePos' => $basePos,
            'investmentType' => $investmentType,
            'triggerStrategy' => $triggerStrategy,
            'investmentData' => $investmentData,
        ];

        return $this->request('/api/v5/tradingBot/grid/min-investment', $params, 'POST');
    }

    public function rsiBackTesting($instId,$timeframe,$thold,$timePeriod,$triggerCond='',$duration='')
    {
        $params = [
            'instId' => $instId,
            'timeframe' => $timeframe,
            'thold' => $thold,
            'timePeriod' => $timePeriod,
            'triggerCond' => $triggerCond,
            'duration' => $duration,
        ];

        return $this->request('/api/v5/tradingBot/public/rsi-back-testing', $params, 'GET');
    }

    public function ridQuantity($instId,$runType,$algoOrdType,$maxPx,$minPx,$lever='')
    {
        $params = [
            'instId' => $instId,
            'runType' => $runType,
            'algoOrdType' => $algoOrdType,
            'maxPx' => $maxPx,
            'minPx' => $minPx,
            'lever' => $lever,
        ];

        return $this->request('/api/v5/tradingBot/grid/grid-quantity', $params, 'GET');
    }

    


}
