<?php
/**
 * OKEX V3 PHP REST 币币API
 *
 * @version 0.1
 * @api  https://www.okex.com/docs/zh/#futures-README
 * @authour luochao@iponycar.com
 */

namespace okv3;

class MarginApi extends Utils {

    # margin
    const MARGIN_ACCOUNT_INFO = '/api/margin/v3/accounts';
    const MARGIN_COIN_ACCOUNT_INFO = '/api/margin/v3/accounts/';
    const MARGIN_LEDGER_RECORD = '/api/margin/v3/accounts/';
    const MARGIN_CONF = '/api/margin/v3/accounts/availability';
    const MARGIN_SPECIAL_CONF = '/api/margin/v3/accounts/';
    const MARGIN_BORROWED_RECORD = '/api/margin/v3/accounts/borrowed';
    const MARGIN_SPECIAL_BORROWED_RECORD = '/api/margin/v3/accounts/';
    const MARGIN_BORROW = '/api/margin/v3/accounts/borrow/';
    const MARGIN_RETURN = '/api/margin/v3/accounts/repayment';
    const MARGIN_ORDER = '/api/margin/v3/orders';
    const MARGIN_CANCEL_ORDER = '/api/margin/v3/cancel_orders/';
    const MARGIN_ORDERS_LIST = '/api/margin/v3/orders';
    const MARGIN_ORDER_INFO = '/api/margin/v3/orders/';
    const MARGIN_FILLS = '/api/margin/v3/fills';

    const MARGIN_LEVERAGE = '/api/margin/v3/accounts/';
//    const MARGIN_SET_LEVERAGE = '/api/margin/v3/accounts/';
    const MARGIN_MARK_PRICE = '/api/margin/v3/instruments/';



    // 币币账户信息
    public function getAccountInfo()
    {
        return $this->request(self::MARGIN_ACCOUNT_INFO, [], 'GET');
    }

    // 单一币种账户信息
    public function getCoinAccountInfo($symbol)
    {
        return $this->request(self::MARGIN_COIN_ACCOUNT_INFO.$symbol, [], 'GET');
    }

    // 账单流水查询
    public function getLedgerRecord($symbol, $after='', $before='', $limit='', $type='')
    {
        $params = [];

        if ($after) $params['after'] = $after;
        if ($before) $params['before'] = $after;
        if ($limit) $params['limit'] = $limit;
        if ($type) $params['type'] = $type;

        return  $this->request(self::MARGIN_LEDGER_RECORD.$symbol.'/ledger', $params, 'GET');
    }

    // 杠杆配置信息
    public function getMarginConf()
    {
        $params = [];

        return  $this->request(self::MARGIN_CONF, $params, 'GET');
    }

    // 杠杆配置信息
    public function getMarginSpecialConf($symbol)
    {
        $params = [];
        return  $this->request(self::MARGIN_SPECIAL_CONF.$symbol.'/availability', $params, 'GET');
    }

    // 获取借币记录
    public function getBorrowedRecord()
    {
        $params = [];
        return  $this->request(self::MARGIN_BORROWED_RECORD, $params, 'GET');
    }

    // 某账户借币记录
    public function getSpecialBorrowedRecord($symbol, $state='')
    {
        $params = [];

        if ($state) $params['state'] = $state;
        return  $this->request(self::MARGIN_SPECIAL_BORROWED_RECORD.$symbol.'/borrowed', $params, 'GET');
    }

    // 借币
    public function borrowCoin($instrument_id, $currency, $amount)
    {
        $params = [
            'instrument_id' => $instrument_id,
            'currency' => $currency,
            'amount' => $amount,
        ];

        return $this->request(self::MARGIN_BORROW, $params, 'POST');
    }

    // 还币
    public function returnCoin($instrument_id, $currency, $amount, $borrow_id='')
    {
        $params = [
            'instrument_id' => $instrument_id,
            'currency' => $currency,
            'amount' => $amount,
        ];

        if ($borrow_id) $params['borrow_id'] = $borrow_id;

        return $this->request(self::MARGIN_RETURN, $params, 'POST');
    }


    // 下单
    public function takeOrder($instrument_id, $side, $size, $margin_trading='', $price='', $notional='', $client_oid='', $type='', $order_type='')
    {
        $params = [
            'instrument_id' => $instrument_id,
            'side' => $side,
            'size' => $size,
            'margin_trading' => $margin_trading
        ];

        if ($price) $params['price'] = $price;
        if ($notional) $params['notional'] = $notional;
        if ($client_oid) $params['limit'] = $client_oid;
        if ($type) $params['type'] = $type;
        if ($order_type) $params['order_type'] = $order_type;

        return $this->request(self::MARGIN_ORDER, $params, 'POST');
    }

    //撤销指定订单
    public function revokeOrder($instrument_id, $order_id='', $client_oid='')
    {
        $params = [
            'instrument_id' => $instrument_id,
        ];

       return $this->request(self::MARGIN_CANCEL_ORDER.$order_id, $params, 'POST');
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

        return $this->request(self::MARGIN_ORDERS_LIST, $params, 'GET', true);
    }

    // 获取订单信息
    public function getOrderInfo($instrument_id, $oid)
    {
        $params = ['instrument_id' => $instrument_id];

        return $this->request(self::MARGIN_ORDER_INFO.$oid, $params, 'GET');
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

        return $this->request(self::MARGIN_FILLS, $params, 'GET', true);
    }

    //
    public function getLeverage($instrument_id)
    {
        return  $this->request(self::MARGIN_LEVERAGE.$instrument_id.'/leverage', '', 'GET');
    }

    //
    public function setLeverage($instrument_id,$leverage)
    {
        $params = [
            'leverage' => $leverage,
        ];

        return $this->request(self::MARGIN_LEVERAGE.$instrument_id.'/leverage', $params, 'POST');
    }

    //
    public function getMarkPrice($instrument_id)
    {
        $params = [
            'instrument_id' => $instrument_id,
        ];

        return $this->request(self::MARGIN_MARK_PRICE.$instrument_id.'/mark_price', $params, 'GET', true);
    }


}
