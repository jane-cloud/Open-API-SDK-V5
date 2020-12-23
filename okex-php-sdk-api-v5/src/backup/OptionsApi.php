<?php
/**
 * OKEX V3 PHP REST 合约API
 *
 * @version 0.1
 * @api  https://www.okex.com/docs/zh/#futures-README
 * @authour luochao@iponycar.com
 */


namespace okv3;

class OptionsApi extends Utils {

    # future api
    const OPTION_SPECIFIC_POSITION = '/api/option/v3/';
    const OPTION_SPECIFIC_ACCOUNT = '/api/option/v3/accounts/';
    const OPTION_ORDER = '/api/option/v3/order';
    const OPTION_ORDERS = '/api/option/v3/orders';
    const OPTION_REVOKE_ORDER = '/api/option/v3/cancel_order/';
    const OPTION_REVOKE_ORDERS = '/api/option/v3/cancel_batch_orders/';
    const OPTION_AMEND_ORDER = '/api/option/v3/amend_order/';

    const OPTION_ORDERS_LIST = '/api/option/v3/orders';
    const OPTION_ORDER_INFO = '/api/option/v3/orders/';
    const OPTION_FILLS = '/api/option/v3/fills/';
    const OPTION_LEDGER = '/api/option/v3/accounts/';
    const OPTION_RATE_FEE = '/api/option/v3/trade_fee';
    const OPTION_INSTRUMENTS = '/api/option/v3/instruments/';
    const OPTION_INSTRUMENTS_SUMMARY = '/api/option/v3/instruments/';
    const OPTION_DEPTH = '/api/option/v3/instruments/';
    const OPTION_TICKER = '/api/option/v3/instruments/ticker';
    const OPTION_SPECIFIC_TICKER = '/api/option/v3/instruments/';
    const OPTION_TRADES = '/api/option/v3/instruments/';
    const OPTION_KLINE = '/api/option/v3/instruments/';
    const OPTION_INDEX = '/api/option/v3/underlying';
    const OPTION_RATE = '/api/option/v3/rate';
    const OPTION_ESTIMAT_PRICE = '/api/option/v3/instruments/';
    const OPTION_HOLDS = '/api/option/v3/instruments/';
    const OPTION_LIMIT = '/api/option/v3/instruments/';
    const OPTION_LIQUIDATION = '/api/option/v3/instruments/';
    const OPTION_MARK = '/api/option/v3/instruments/';
    const HOLD_AMOUNT = '/api/option/v3/accounts/';
    const CURRENCY_LIST = '/api/option/v3/instruments/currencies/';

    // futures order_algo
    const FUTURE_ORDER_ALGO = '/api/futures/v3/order_algo';
    const FUTURE_CANCEL_ALGOS = '/api/futures/v3/cancel_algos';
    const FUTURE_ALGO_LIST = '/api/futures/v3/order_algo';

    // futures
    const FUTURE_MARGIN_MODE = '/api/futures/v3/accounts/margin_mode';
    const FUTURE_CLOSE_POSITION = '/api/futures/v3/close_position';
    const FUTURE_CANCEL_ALL = '/api/futures/v3/cancel_all';

    // 单个标的指数持仓信息
    public function getSpecificPosition($underlying, $instrument_id="")
    {
        return $this->request(self::OPTION_SPECIFIC_POSITION.$underlying.'/position', [], 'GET');
    }

    // 单个标的物账户信息
    public function getSpecificAccounts($underlying)
    {
        return $this->request(self::OPTION_SPECIFIC_ACCOUNT.$underlying, [], 'GET');
    }

    // 下单
    public function takeOrder($client_oid='', $instrument_id, $side, $price, $size, $match_price='', $order_type='')
    {
        $params = [
            'instrument_id'=> $instrument_id,
            'side' => $side,
            'price' => $price,
            'size' => $size,
        ];

        if ($client_oid) $params['client_oid'] = $client_oid;
        if ($order_type) $params['order_type'] = $order_type;
        if ($match_price) $params['match_price'] = $match_price;

        return $this->request(self::OPTION_ORDER, $params, 'POST');
    }

    // 批量下单
    public function takeOrders($underlying, $orders_data)
    {
        $params = [
            'underlying' => $underlying,
            'orders_data' => $orders_data,
        ];

        return $this->request(self::OPTION_ORDERS, $params, 'POST');
    }

    // 撤销指定订单
    public function revokeOrder($underlying, $order_id)
    {
        return $this->request(self::OPTION_REVOKE_ORDER.$underlying.'/'.$order_id, [], 'POST');
    }

    // 批量撤销订单
    public function revokeOrders($underlying, $order_ids)
    {
        $params = ['order_ids' => $order_ids];

        return $this->request(self::FUTURE_REVOKE_ORDERS.$underlying, $params, 'POST');
    }

    // 批量撤销订单
    public function amendOrder($underlying, $order_id='', $request_id='', $new_size='', $new_price='')
    {

        $params = [
            'underlying'=> $underlying,
        ];

        if ($order_id) $params['order_id'] = $order_id;
        if ($request_id) $params['request_id'] = $request_id;
        if ($new_size) $params['new_size'] = $new_size;
        if ($new_price) $params['new_price'] = $new_price;

        return $this->request(self::OPTION_AMEND_ORDER.$underlying, $params, 'POST');
    }



    // 获取订单列表
    public function getOrderList($state, $underlying, $afters='', $before='', $limit='')
    {
        $params = ['state' => $state];

        if ($afters) $params['after'] = $afters;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::OPTION_ORDERS_LIST."/$underlying", $params, 'GET');
    }

    // 获取订单信息
    public function getOrderInfo($order_id, $underlying)
    {
        return $this->request(self::OPTION_ORDER_INFO.$underlying.'/'.$order_id, [], 'GET');
    }

    // 获取成交明细
    public function getFills($order_id, $underlying, $instrument_id='', $afters='', $before='', $limit='')
    {
        $params = [
            'order_id' => $order_id,
            'after' => $afters,
            'before' => $before,
            'limit' => $limit,
            'underlying' => $underlying,
            'instrument_id' => $instrument_id
        ];

        return $this->request(self::OPTION_FILLS.$underlying, $params, 'GET');
    }

    // 获取账单流水
    public function getLedger($underlying, $afters='', $before='', $limit='')
    {
        $params = [
            'after' => $afters,
            'before' => $before,
            'limit' => $limit,
            'underlying' => $underlying,
        ];

        return $this->request(self::OPTION_LEDGER.$underlying, $params, 'GET');
    }

    // 获取手续费费率
    public function getRateFee()
    {
        return $this->request(self::OPTION_RATE_FEE, '', 'GET');
    }

    // 公共-获取期权合约
    public function getInstruments($underlying)
    {
        return $this->request(self::OPTION_INSTRUMENTS.$underlying, [], 'GET');
    }

    // 公共-获取期权合约详细定价
    public function getInstrumentsSummary($underlying, $delivery='')
    {
        $params = ['delivery' => $delivery];

        return $this->request(self::OPTION_INSTRUMENTS_SUMMARY.$underlying.'/summary', $params, 'GET');
    }

    // 公共-获取单个期权合约详细定价
    public function getSpecificInstrumentSummary($underlying, $instrument_id)
    {
//        $params = ['delivery' => $delivery];

        return $this->request(self::OPTION_INSTRUMENTS_SUMMARY.$underlying.'/summary/'.$instrument_id, [], 'GET');
    }

    // 获取深度
    public function getDepth($instrument_id, $size)
    {
        $params = ['size' => $size];

        return $this->request(self::OPTION_DEPTH.$instrument_id.'/book', $params, 'GET');
    }

    // 获取全部ticker信息
    public function getTicker()
    {
        return $this->request(self::FUTURE_TICKER, [], 'GET');
    }

    // 获取某个ticker信息
    public function getSpecificTicker($instrument_id)
    {
        return $this->request(self::OPTION_SPECIFIC_TICKER.$instrument_id.'/ticker', [], 'GET');
    }

    // 获取成交数据
    public function getTrades($instrument_id, $afters=0, $before=0, $limit=0)
    {
        $params = ['instrument_id' => $instrument_id];
        if ($afters) $params['after'] = $afters;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::OPTION_TRADES.$instrument_id.'/trades', $params, 'GET', True);
    }

    // 获取K线数据
    public function getKline($instrument_id, $granularity, $start='', $end='')
    {
        $params = [
            'granularity' => $granularity,
            'start' => $start,
            'end' => $end
        ];

        return $this->request(self::OPTION_KLINE.$instrument_id.'/candles', $params, 'GET');
    }

    // 获取指数信息
    public function getIndex()
    {
        return $this->request(self::OPTION_INDEX, [], 'GET');
    }

    // 获取法币汇率
    public function getRate()
    {
        return $this->request(self::FUTURE_RATE, [], 'GET');
    }

    // 获取预估交割价
    public function getEstimatedPrice($instrument_id)
    {
        return $this->request(self::FUTURE_ESTIMAT_PRICE.$instrument_id.'/estimated_price', [], 'GET');
    }

    // 获取平台总持仓量
    public function getHolds($instrument_id)
    {
        return $this->request(self::FUTURE_HOLDS.$instrument_id.'/open_interest', [], 'GET');
    }

    // 获取当前限价
    public function getLimit($instrument_id)
    {
        return $this->request(self::FUTURE_LIMIT.$instrument_id.'/price_limit', [], 'GET');
    }

    // 获取爆仓单
    public function getLiquidation($instrument_id, $state, $afters = 0, $before = 0, $limit = 0)
    {
        $params = ['instrument_id' => $instrument_id, 'status' => $state];

        if ($afters) $params['after'] = $afters;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::FUTURE_LIQUIDATION.$instrument_id.'/liquidation', $params, 'GET');
    }

    // 获取合约挂单冻结数量
    public function getHoldsAmount($instrument_id)
    {
        return $this->request(self::HOLD_AMOUNT.$instrument_id.'/holds', [], 'GET');
    }

    // 公共-获取合约标记价格
    public function getMarkPrice($instrument_id)
    {
        return $this->request(self::FUTURE_MARK.$instrument_id.'/mark_price', [], 'GET');
    }


    // 策略下单，止盈止损
    public function takeAlgoOrderStop($instrument_id, $type, $order_type, $size, $trigger_price, $algo_price)
    {
        $params = [
            'instrument_id' => $instrument_id,
            'type' => $type,
            'order_type' => $order_type,
            'size' => $size,
            'trigger_price' => $trigger_price,
            'algo_price' => $algo_price
        ];

        return $this->request(self::FUTURE_ORDER_ALGO, $params, 'POST');
    }

    //委托策略撤单
    public function revokeAlgoOrders($instrument_id, array $algo_ids, $order_type)
    {
        $params = [
            'instrument_id' => $instrument_id,
            'algo_ids' => $algo_ids,
            'order_type' => $order_type,
        ];

        return $this->request(self::FUTURE_CANCEL_ALGOS, $params, 'POST');
    }

    // 获取委托单列表
    public function getAlgoList($instrument_id, $order_type, $status='', $algo_id, $after='', $before='', $limit='')
    {
        $params = [
            'order_type' => $order_type,
        ];

        if ($status) $params['status'] = $after;
        if ($algo_id) $params['algo_id'] = $algo_id;
        if ($after) $params['after'] = $after;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::FUTURE_ALGO_LIST."/$instrument_id", $params, 'GET', true);
    }


    // 设置合约币种账户模式
    public function setMarginMode($underlying,$margin_mode)
    {
        $params = [
            'underlying'=> $underlying,
            'margin_mode' => $margin_mode,
        ];

        return $this->request(self::FUTURE_MARGIN_MODE, $params, 'POST');
    }

    // 市价全平
    public function closePosition($instrument_id,$direction)
    {
        $params = [
            'instrument_id'=> $instrument_id,
            'direction' => $direction,
        ];

        return $this->request(self::FUTURE_CLOSE_POSITION, $params, 'POST');
    }

    // 撤销所有平仓挂单
    public function cancelAll($instrument_id,$direction)
    {
        $params = [
            'instrument_id'=> $instrument_id,
            'direction' => $direction,
        ];

        return $this->request(self::FUTURE_CANCEL_ALL, $params, 'POST');
    }
}
