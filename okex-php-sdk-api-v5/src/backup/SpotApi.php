<?php
/**
 * OKEX V3 PHP REST 币币API
 *
 * @version 0.1
 * @api  https://www.okex.com/docs/zh/#futures-README
 * @authour luochao@iponycar.com
 */

namespace okv3;

class SpotApi extends Utils {

    # spot
    const SPOT_ACCOUNT_INFO = '/api/spot/v3/accounts';
    const SPOT_COIN_ACCOUNT_INFO = '/api/spot/v3/accounts/';
    const SPOT_LEDGER_RECORD = '/api/spot/v3/accounts/';
    const SPOT_ORDER = '/api/spot/v3/orders';
    const SPOT_CANCEL_ORDER = '/api/spot/v3/cancel_orders/';
    const SPOT_ORDERS_LIST = '/api/spot/v3/orders';
    const SPOT_ORDER_INFO = '/api/spot/v3/orders/';
    const SPOT_FILLS = '/api/spot/v3/fills';
    const SPOT_COIN_INFO = '/api/spot/v3/instruments';
    const SPOT_DEPTH = '/api/spot/v3/instruments/';
    const SPOT_TICKER = '/api/spot/v3/instruments/ticker';
    const SPOT_SPECIFIC_TICKER = '/api/spot/v3/instruments/';
    const SPOT_DEAL = '/api/spot/v3/instruments/';
    const SPOT_KLINE = '/api/spot/v3/instruments/';
    const SPOT_HISTORY_KLINE = '/api/spot/v3/instruments/';


    // spot order_algo
    const SPOT_ORDER_ALGO = '/api/spot/v3/order_algo/';
    const SPOT_CANCEL_BATCH_ALGOS = '/api/spot/v3/cancel_batch_algos/';
    const SPOT_ALGO_LIST = '/api/spot/v3/algo';


    const SPOT_TRADE_FEE = '/api/spot/v3/trade_fee/';

    // 币币账户信息
    public function getAccountInfo()
    {
        return $this->request(self::SPOT_ACCOUNT_INFO, [], 'GET');
    }

    // 单一币种账户信息
    public function getCoinAccountInfo($symbol)
    {
        return $this->request(self::SPOT_COIN_ACCOUNT_INFO.$symbol, [], 'GET');
    }

    // 账单流水查询
    public function getLedgerRecord($symbol, $after='', $before='', $limit='', $type='')
    {
        $params = [];

        if ($after) $params['after'] = $after;
        if ($before) $params['before'] = $after;
        if ($limit) $params['limit'] = $limit;
        if ($type) $params['type'] = $type;

        return  $this->request(self::SPOT_LEDGER_RECORD.$symbol.'/ledger', $params, 'GET');
    }

    // 下单
    public function takeOrder($instrument_id, $side, $size, $price='', $notional='', $client_oid='', $type='', $order_type='')
    {
        $params = [
            'instrument_id' => $instrument_id,
            'side' => $side,
            'size' => $size
        ];

        if ($price) $params['price'] = $price;
        if ($notional) $params['notional'] = $notional;
        if ($client_oid) $params['client_oid'] = $client_oid;
        if ($type) $params['type'] = $type;
        if ($order_type) $params['order_type'] = $order_type;

        return $this->request(self::SPOT_ORDER, $params, 'POST');
    }

    //撤销指定订单
    public function revokeOrder($instrument_id, $order_id='', $client_oid='')
    {
        $params = [
            'instrument_id' => $instrument_id,
        ];

       return $this->request(self::SPOT_CANCEL_ORDER.$order_id, $params, 'POST');
    }

    // 获取订单列表
    public function getOrdersList($instrument_id, $state, $after='', $before='', $limit='')
    {
        $params = [
            'instrument_id' => $instrument_id,
            'state' => $state,
        ];

        if ($after) $params['after'] = $after;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::SPOT_ORDERS_LIST, $params, 'GET', true);
    }

    // 获取订单信息
    public function getOrderInfo($instrument_id, $oid)
    {
        $params = ['instrument_id' => $instrument_id];

        return $this->request(self::SPOT_ORDER_INFO.$oid, $params, 'GET');
    }

    // 获取成交明细
    public function getFills($instrument_id, $order_id, $afters='', $before='', $limit='')
    {
        $params = [
            'order_id' => $order_id,
            'instrument_id' => $instrument_id,
            'after' => $afters,
            'before' => $before,
            'limit' => $limit
        ];

        return $this->request(self::SPOT_FILLS, $params, 'GET', true);
    }

    // 获取币对信息
    public function getCoinInfo()
    {
        return $this->request(self::SPOT_COIN_INFO, [], 'GET');
    }

    // 获取深度数据
    public function getDepth($instrument_id, $size='', $depth='')
    {
        $params = [];

        if($size) $params['size'] = $size;
        if($depth) $params['depth'] = $depth;

        return $this->request(self::SPOT_DEPTH .$instrument_id.'/book', $params, 'GET');
    }

    // 获取全部ticker信息
    public function getTicker()
    {
        return $this->request(self::SPOT_TICKER, [], 'GET');
    }

    // 获取某个ticker信息
    public function getSpecificTicker($instrument_id)
    {
        return $this->request(self::SPOT_SPECIFIC_TICKER.$instrument_id.'/ticker', [], 'GET');
    }

    // 获取成交数据
    public function getDeal($instrument_id, $afters='', $before='', $limit='')
    {
        $params = [
            'after'=> $afters,
            'before' => $before,
            'limit' => $limit
        ];

        return $this->request(self::SPOT_DEAL.$instrument_id.'/trades', $params, 'GET');
    }

    // 获取K线
    public function getKine($instrument_id, $granularity='',$start='', $end='')
    {
        $params = [
            'start' => $start,
            'end' => $end,
            'granularity' => $granularity
        ];

        return $this->request(self::SPOT_KLINE.$instrument_id.'/candles',  $params, 'GET');
    }

    // 公共-获取历史K线数据
    public function getHistoryKine($instrument_id, $granularity='',$start='', $end='')
    {
        $params = [
            'start' => $start,
            'end' => $end,
            'granularity' => $granularity
        ];

        return $this->request(self::SPOT_HISTORY_KLINE.$instrument_id.'/history/candles',  $params, 'GET');
    }


    // 策略下单，止盈止损
    public function takeAlgoOrderStop($instrument_id, $mode, $order_type, $size, $side, $trigger_price, $algo_price)
    {
        $params = [
            'instrument_id' => $instrument_id,
            'mode' => $mode,
            'order_type' => $order_type,
            'size' => $size,
            'side' => $side,
            'trigger_price' => $trigger_price,
            'algo_price' => $algo_price
        ];

        return $this->request(self::SPOT_ORDER_ALGO, $params, 'POST');
    }

//    // 策略下单，跟踪委托参数
//    public function takeAlgoOrderFollow($instrument_id, $mode, $order_type, $size, $side, $callback_rate, $trigger_price)
//    {
//        $params = [
//            'instrument_id' => $instrument_id,
//            'mode' => $mode,
//            'order_type' => $order_type,
//            'size' => $size,
//            'side' => $side,
//            'callback_rate' => $callback_rate,
//            'trigger_price' => $trigger_price
//        ];
//
//        return $this->request(self::SPOT_ORDER, $params, 'POST');
//    }

    //委托策略撤单
    public function revokeAlgoOrders($instrument_id, array $algo_ids, $order_type)
    {
        $params = [
            'instrument_id' => $instrument_id,
            'algo_ids' => $algo_ids,
            'order_type' => $order_type,
        ];

        return $this->request(self::SPOT_CANCEL_BATCH_ALGOS, $params, 'POST');
    }

    // 获取委托单列表
    public function getAlgoList($instrument_id, $order_type, $status='', $algo_id='', $after='', $before='', $limit='')
    {
        $params = [
            'instrument_id' => $instrument_id,
            'order_type' => $order_type,
        ];

        if ($status) $params['status'] = $after;
        if ($algo_id) $params['algo_id'] = $algo_id;
        if ($after) $params['after'] = $after;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::SPOT_ALGO_LIST, $params, 'GET', true);
    }

    //
    public function getTradeFee()
    {
        return $this->request(self::SPOT_TRADE_FEE, '', 'GET', true);
    }
}
