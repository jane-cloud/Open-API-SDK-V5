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

    public function createSignal($signalChanName,$signalChanDesc='')
    {
        $params = [
            'signalChanName' => $signalChanName,
            'signalChanDesc' => $signalChanDesc,
        ];

        return $this->request('/api/v5/tradingBot/signal/create-signal', $params, 'POST');
    }

    public function getSignals($signalSourceType,$signalChanId='',$after='',$before='',$limit='')
    {
        $params = [
            'signalSourceType' => $signalSourceType,
            'signalChanId' => $signalChanId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/signal/signals', $params, 'GET');
    }

    public function signalOrderAlgo($signalChanId,$includeAll='',$instIds='',$lever,$investAmt,$subOrdType,$ratio='',$entrySettingParam='',$exitSettingParam='')
    {
        $params = [
            'signalChanId' => $signalChanId,
            'includeAll' => $includeAll,
            'instIds' => $instIds,
            'lever' => $lever,
            'investAmt' => $investAmt,
            'subOrdType' => $subOrdType,
            'ratio' => $ratio,
            'entrySettingParam' => $entrySettingParam,
            'exitSettingParam' => $exitSettingParam,
        ];

        return $this->request('/api/v5/tradingBot/signal/order-algo', $params, 'POST');
    }

    public function signalStopOrderAlgo($algoId)
    {
        $params = [
            'algoId' => $algoId,
        ];

        return $this->request('/api/v5/tradingBot/signal/stop-order-algo', $params, 'POST');
    }

    public function signalMarginBalance($algoId,$type,$amt,$allowReinvest='')
    {
        $params = [
            'algoId' => $algoId,
            'type' => $type,
            'amt' => $amt,
            'allowReinvest' => $allowReinvest,
        ];

        return $this->request('/api/v5/tradingBot/signal/margin-balance', $params, 'POST');
    }

    public function amendTPSL($algoId,$exitSettingParam)
    {
        $params = [
            'algoId' => $algoId,
            'exitSettingParam' => $exitSettingParam,
        ];

        return $this->request('/api/v5/tradingBot/signal/amendTPSL', $params, 'POST');
    }

    public function setInstruments($algoId,$instIds,$includeAll)
    {
        $params = [
            'algoId' => $algoId,
            'instIds' => $instIds,
            'includeAll' => $includeAll,
        ];

        return $this->request('/api/v5/tradingBot/signal/set-instruments', $params, 'POST');
    }

    public function signalOrdersAlgoDetails($algoOrdType,$algoId)
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
        ];

        return $this->request('/api/v5/tradingBot/signal/orders-algo-details', $params, 'GET');
    }

    public function signalOrdersAlgoPending($algoOrdType,$algoId='',$after='',$before='',$limit='')
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/signal/orders-algo-pending', $params, 'GET');
    }

    public function signalOrdersAlgoHistory($algoOrdType,$algoId='',$after='',$before='',$limit='')
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/signal/orders-algo-history', $params, 'GET');
    }

    public function signalPositions($algoOrdType,$algoId)
    {
        $params = [
            'algoOrdType' => $algoOrdType,
            'algoId' => $algoId,
        ];

        return $this->request('/api/v5/tradingBot/signal/positions', $params, 'GET');
    }

    public function signalPositionsHistory($algoId,$instId='',$after='',$before='',$limit='')
    {
        $params = [
            'algoId' => $algoId,
            'instId' => $instId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/signal/positions-history', $params, 'GET');
    }

    public function signalClosePositions($algoId,$instId)
    {
        $params = [
            'algoId' => $algoId,
            'instId' => $instId,
        ];

        return $this->request('/api/v5/tradingBot/signal/close-position', $params, 'POST');
    }

    public function signalSubOrder($instId,$algoId,$side,$ordType,$sz,$px='',$reduceOnly='')
    {
        $params = [
            'instId' => $instId,
            'algoId' => $algoId,
            'side' => $side,
            'ordType' => $ordType,
            'sz' => $sz,
            'px' => $px,
            'reduceOnly' => $reduceOnly,
        ];

        return $this->request('/api/v5/tradingBot/signal/sub-order', $params, 'POST');
    }

    public function signalCancelSubOrder($algoId,$instId,$signalOrdId)
    {
        $params = [
            'algoId' => $algoId,
            'instId' => $instId,
            'signalOrdId' => $signalOrdId,
        ];

        return $this->request('/api/v5/tradingBot/signal/cancel-sub-order', $params, 'POST');
    }

    public function getSignalSubOrders($algoId,$algoOrdType,$state='',$signalOrdId='',$after='',$before='',$begin='',$end='',$limit='',$type='',$clOrdId='')
    {
        $params = [
            'algoId' => $algoId,
            'algoOrdType' => $algoOrdType,
            'state' => $state,
            'signalOrdId' => $signalOrdId,
            'after' => $after,
            'before' => $before,
            'begin' => $begin,
            'end' => $end,
            'limit' => $limit,
            'type' => $type,
            'clOrdId' => $clOrdId,
        ];

        return $this->request('/api/v5/tradingBot/signal/sub-orders', $params, 'GET');
    }

    public function eventHistory($algoId,$after='',$before='',$limit='')
    {
        $params = [
            'algoId' => $algoId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/tradingBot/signal/event-history', $params, 'GET');
    }


}
