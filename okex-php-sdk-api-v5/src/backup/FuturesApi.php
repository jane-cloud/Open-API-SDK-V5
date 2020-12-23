<?php
/**
 * OKEX V3 PHP REST 合约API
 *
 * @version 0.1
 * @api  https://www.okex.com/docs/zh/#futures-README
 * @authour luochao@iponycar.com
 */


namespace okv3;

class FuturesApi extends Utils {

    # future api
    const FUTURE_POSITION = '/api/futures/v3/position';
    const FUTURE_SPECIFIC_POSITION = '/api/futures/v3/';
    const FUTURE_ACCOUNTS = '/api/futures/v3/accounts';
    const FUTURE_COIN_ACCOUNT = '/api/futures/v3/accounts/';
    const FUTURE_GET_LEVERAGE = '/api/futures/v3/accounts/';
    const FUTURE_SET_LEVERAGE = '/api/futures/v3/accounts/';
    const FUTURE_LEDGER = '/api/futures/v3/accounts/';
    const FUTURE_DELETE_POSITION = '/api/futures/v3/close_all_orders';
    const FUTURE_ORDER = '/api/futures/v3/order';
    const FUTURE_ORDERS = '/api/futures/v3/orders';
    const FUTURE_REVOKE_ORDER = '/api/futures/v3/cancel_order/';
    const FUTURE_REVOKE_ORDERS = '/api/futures/v3/cancel_batch_orders/';
    const FUTURE_ORDERS_LIST = '/api/futures/v3/orders';
    const FUTURE_ORDER_INFO = '/api/futures/v3/orders/';
    const FUTURE_FILLS = '/api/futures/v3/fills';
    const FUTURE_PRODUCTS_INFO = '/api/futures/v3/instruments';
    const FUTURE_DEPTH = '/api/futures/v3/instruments/';
    const FUTURE_TICKER = '/api/futures/v3/instruments/ticker';
    const FUTURE_SPECIFIC_TICKER = '/api/futures/v3/instruments/';
    const FUTURE_TRADES = '/api/futures/v3/instruments/';
    const FUTURE_KLINE = '/api/futures/v3/instruments/';
    const FUTURE_HISTORY_KLINE = '/api/futures/v3/instruments/';
    const FUTURE_INDEX = '/api/futures/v3/instruments/';
    const FUTURE_RATE = '/api/futures/v3/rate';
    const FUTURE_ESTIMAT_PRICE = '/api/futures/v3/instruments/';
    const FUTURE_HOLDS = '/api/futures/v3/instruments/';
    const FUTURE_LIMIT = '/api/futures/v3/instruments/';
    const FUTURE_LIQUIDATION = '/api/futures/v3/instruments/';
    const FUTURE_MARK = '/api/futures/v3/instruments/';
    const HOLD_AMOUNT = '/api/futures/v3/accounts/';
    const CURRENCY_LIST = '/api/futures/v3/instruments/currencies/';

    // futures order_algo
    const FUTURE_ORDER_ALGO = '/api/futures/v3/order_algo';
    const FUTURE_CANCEL_ALGOS = '/api/futures/v3/cancel_algos';
    const FUTURE_ALGO_LIST = '/api/futures/v3/order_algo';

    // futures
    const FUTURE_MARGIN_MODE = '/api/futures/v3/accounts/margin_mode';
    const FUTURE_CLOSE_POSITION = '/api/futures/v3/close_position';
    const FUTURE_CANCEL_ALL = '/api/futures/v3/cancel_all';

    const FUTURE_TRADE_FEE = '/api/futures/v3/trade_fee';



    // 获取合约账户所有的持仓信息
    public function getPosition()
    {
        return $this->request(self::FUTURE_POSITION, [], 'GET');
    }

    // 单个合约持仓信息
    public function getSpecificPosition($instrument_id)
    {
        return $this->request(self::FUTURE_SPECIFIC_POSITION.$instrument_id.'/position', [], 'GET');
    }

    // 获取所有币种的合约账户信息
    public function getAccounts()
    {
        return $this->request(self::FUTURE_ACCOUNTS, [], 'GET');
    }

    // 单个币种合约账户信息
    public function getCoinAccounts($symbol)
    {
        return $this->request(self::FUTURE_COIN_ACCOUNT.$symbol, [], 'GET');
    }

    // 获取合约账户币种杠杆倍数
    public function getLeverage($symbol)
    {
        return $this->request(self::FUTURE_GET_LEVERAGE.$symbol.'/leverage', [], 'GET');
    }

    // 设定合约币种杠杆倍数
    public function setLeverage($symbol, $leverage, $instrument_id='', $direction='')
    {
        $params = [
            'instrument_id' =>  $instrument_id,
            'direction' => $direction,
            'leverage' => $leverage
        ];

        if ($symbol)
            return $this->request(self::FUTURE_SET_LEVERAGE.$symbol.'/leverage', $params, 'POST');
        else
            return $this->request(self::FUTURE_SET_LEVERAGE.'leverage', $params, 'POST');
    }

    // 账单流水查询 默认第一页 100条
    public function getLedger($symbol)
    {
        return $this->request(self::FUTURE_LEDGER.$symbol.'/ledger', [], 'GET');
    }

    // 下单
    public function takeOrder($client_oid='', $instrument_id, $otype, $price, $size, $match_price='', $leverage, $order_type='')
    {
        $params = [
            'instrument_id'=> $instrument_id,
            'type' => $otype,
            'price' => $price,
            'size' => $size,
            'leverage' => $leverage,
        ];

        if ($client_oid) $params['client_oid'] = $client_oid;
        if ($order_type) $params['order_type'] = $order_type;
        if ($match_price) $params['match_price'] = $match_price;

        return $this->request(self::FUTURE_ORDER, $params, 'POST');
    }

    // 批量下单
    public function takeOrders($instrument_id, $orders_data, $leverage)
    {
        $params = [
            'instrument_id' => $instrument_id,
            'orders_data' => $orders_data,
            'leverage' => $leverage
        ];

        return $this->request(self::FUTURE_ORDERS, $params, 'POST');
    }

    // 撤销指定订单
    public function revokeOrder($instrument_id, $order_id)
    {
        return $this->request(self::FUTURE_REVOKE_ORDER.$instrument_id.'/'.$order_id, [], 'POST');
    }

    // 批量撤销订单
    public function revokeOrders($instrument_id, $order_ids)
    {
        $params = ['order_ids' => $order_ids];

        return $this->request(self::FUTURE_REVOKE_ORDERS.$instrument_id, $params, 'POST');
    }

    // 获取订单列表
    public function getOrderList($state, $instrument_id, $afters='', $before='', $limit='')
    {
        $params = ['state' => $state];

        if ($afters) $params['after'] = $afters;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::FUTURE_ORDERS_LIST."/$instrument_id", $params, 'GET');
    }

    // 获取订单信息
    public function getOrderInfo($order_id, $instrument_id)
    {
        return $this->request(self::FUTURE_ORDER_INFO.$instrument_id.'/'.$order_id, [], 'GET');
    }

    // 获取成交明细
    public function getFills($order_id, $instrument_id, $afters='', $before='', $limit='')
    {
        $params = [
            'order_id' => $order_id,
            'after' => $afters,
            'before' => $before,
            'limit' => $limit,
            'instrument_id' => $instrument_id
        ];

        return $this->request(self::FUTURE_FILLS, $params, 'GET');
    }

    // 获取合约信息
    public function getProducts()
    {
        return $this->request(self::FUTURE_PRODUCTS_INFO, [], 'GET');
    }

    // 获取深度
    public function getDepth($instrument_id, $size)
    {
        $params = ['size' => $size];

        return $this->request(self::FUTURE_DEPTH.$instrument_id.'/book', $params, 'GET');
    }

    // 获取全部ticker信息
    public function getTicker()
    {
        return $this->request(self::FUTURE_TICKER, [], 'GET');
    }

    // 获取某个ticker信息
    public function getSpecificTicker($instrument_id)
    {
        return $this->request(self::FUTURE_SPECIFIC_TICKER.$instrument_id.'/ticker', [], 'GET');
    }

    // 获取成交数据
    public function getTrades($instrument_id, $afters=0, $before=0, $limit=0)
    {
        $params = ['instrument_id' => $instrument_id];
        if ($afters) $params['after'] = $afters;
        if ($before) $params['before'] = $before;
        if ($limit) $params['limit'] = $limit;

        return $this->request(self::FUTURE_TRADES.$instrument_id.'/trades', $params, 'GET', True);
    }

    // 获取K线数据
    public function getKline($instrument_id, $granularity, $start='', $end='')
    {
        $params = [
            'granularity' => $granularity,
            'start' => $start,
            'end' => $end
        ];

        return $this->request(self::FUTURE_KLINE.$instrument_id.'/candles', $params, 'GET');
    }

    // 公共-获取历史K线数据
    public function getHistoryKline($instrument_id, $granularity, $start='', $end='')
    {
        $params = [
            'granularity' => $granularity,
            'start' => $start,
            'end' => $end
        ];

        return $this->request(self::FUTURE_HISTORY_KLINE.$instrument_id.'/history/candles', $params, 'GET');
    }

    // 获取指数信息
    public function getIndex($instrument_id)
    {
        return $this->request(self::FUTURE_INDEX.$instrument_id.'/index', [], 'GET');
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

    //
    public function getTradeFee()
    {
        return $this->request(self::FUTURE_TRADE_FEE, '', 'GET', true);
    }
}
