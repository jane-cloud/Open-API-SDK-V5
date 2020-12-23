<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/7/30
 * Time: 12:38 PM
 */

namespace okv3;


class AccountApi extends Utils
{
    # spot
    const ACCOUNT_BALANCE = '/api/v5/account/balance';
    const ACCOUNT_COIN_WALLET_INFO = '/api/account/v3/wallet/';
    const ACCOUNT_TRANSFER = '/api/account/v3/transfer';
    const ACCOUNT_WITHDRAWAL = '/api/account/v3/withdrawal';
    const ACCOUNT_LEGER = '/api/account/v3/ledger/';
    const ACCOUNT_DEPOSIT_ADDRESS = '/api/account/v3/deposit/address';
    const ACCOUNT_WITHDRAWAL_HISTORY = '/api/account/v3/withdrawal/history/';
    const ACCOUNT_COIN_WITHDRAWAL_HISTORY = '/api/account/v3/withdrawal/history/';
    const ACCOUNT_DEPOSIT_HISTORY = '/api/account/v3/deposit/history/';
    const ACCOUNT_COIN_DEPOSIT_HISTORY = '/api/account/v3/deposit/history/';
    const ACCOUNT_CURRENCIES = '/api/account/v3/currencies/';
    const ACCOUNT_WITHDRAWAL_FEE = '/api/account/v3/withdrawal/fee/';

    const ACCOUNT_ASSET_VALUATION = '/api/account/v3/asset-valuation/';
    const ACCOUNT_SUB_ACCOUNT = '/api/account/v3/sub-account/';



    // 资金账户信息，多个币种
    public function getWalletInfo()
    {
        return $this->request(self::ACCOUNT_WALLET_INFO, [], 'GET');
    }

    // 单一币种账户信息
    public function getSpecialWalletInfo($coin)
    {
        return $this->request(self::ACCOUNT_COIN_WALLET_INFO."$coin", [], 'GET');
    }

    // 资金划转
    public function transfer($currency, $amount, $from, $to, $sub_account="", $instrument_id="", $to_instrument_id="")
    {
        $params = [
            'currency' => $currency,
            'amount' => $amount,
            'from' => $from,
            'to' => $to,
            'sub_account' => $sub_account,
            'instrument_id' => $instrument_id,
            'to_instrument_id' => $to_instrument_id,
        ];

        return $this->request(self::ACCOUNT_TRANSFER, $params, 'POST');
    }

    // 提币
    public function withdrawal($currency, $amount, $destination, $to_address, $trade_pwd, $fee)
    {
        $params = [
            'currency' => $currency,
            'amount' => $amount,
            'destination' => $destination,
            'to_address' => $to_address,
            'trade_pwd' => $trade_pwd,
            'fee' => $fee,
        ];

        return $this->request(self::ACCOUNT_WITHDRAWAL, $params, 'POST');
    }

    // 流水
    public function getLeger($currency='', $after='', $before='', $limit='')
    {
        $params = [];
        if ($currency) $params['currency'] = $currency;
        if ($after) $params['after'] = $after;
        if ($before) $params['before'] = $before;
        if ($limit) $params['before'] = $before;

        return $this->request(self::ACCOUNT_LEGER, $params, 'GET', true);
    }

    // 流水
    public function getDepositAddress($currency)
    {
        $params = [];
        if ($currency) $params['currency'] = $currency;

        return $this->request(self::ACCOUNT_DEPOSIT_ADDRESS, $params, 'GET', true);
    }

    // 查询所有币种的提币记录
    public function getWithdrawalHistory()
    {
        $params = [];
        return $this->request(self::ACCOUNT_WITHDRAWAL_HISTORY, $params, 'GET', true);
    }

    // 查询单个币种的提币记录
    public function getCoinWithdrawalHistory($currency)
    {
        $params = [];
        if ($currency) $params['currency'] = $currency;

        return $this->request(self::ACCOUNT_COIN_WITHDRAWAL_HISTORY, $params, 'GET', true);
    }

    // 获取所有币种充值记录
    public function getDepositHistory()
    {
        $params = [];
        return $this->request(self::ACCOUNT_DEPOSIT_HISTORY, $params, 'GET', true);
    }

    // 获取单个币种充值记录
    public function getCoinDepositHistory($currency)
    {
        $params = [];
        if ($currency) $params['currency'] = $currency;
        return $this->request(self::ACCOUNT_COIN_DEPOSIT_HISTORY.$currency, [], 'GET', true);
    }

    // 获取币种列表
    public function getCurrencies()
    {
        $params = [];
        return $this->request(self::ACCOUNT_CURRENCIES, $params, 'GET', true);
    }

    // 获取币种列表
    public function getWithdrawalFee($currency='')
    {
        $params = [];
        if ($currency) $params['currency'] = $currency;
        return $this->request(self::ACCOUNT_WITHDRAWAL_FEE, $params, 'GET', true);
    }

    //
    public function getAssetValuation($account_type='', $valuation_currency='')
    {
        $params = [];
        if ($account_type) $params['account_type'] = $account_type;
        if ($valuation_currency) $params['valuation_currency'] = $valuation_currency;
        return $this->request(self::ACCOUNT_ASSET_VALUATION, $params, 'GET', true);
    }

    //
    public function getSubAccount($sub_account)
    {
        $params = [];
        if ($sub_account) $params['sub-account'] = $sub_account;
        return $this->request(self::ACCOUNT_SUB_ACCOUNT, $params, 'GET', true);
    }


}
