from .client import Client
from .consts import *


class TradingDataAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def get_support_coin(self):
        return self._request_without_params(GET, SUPPORT_COIN)

    # GET /api/v5/rubik/stat/contracts/open-interest-history    
    def get_open_interest_history(self, instId = '', period = '', end = '', begin = '', limit = ''):
        params = {'instId': instId, 'period': period, 'end': end, 'begin': begin, 'limit': limit}
        return self._request_with_params(GET, GET_OPEN_INTEREST_HISTORY, params)

    def get_taker_volume(self, ccy, instType, begin='', end='', period=''):
        params = {'ccy': ccy, 'instType': instType, 'begin': begin, 'end': end, 'period': period}
        return self._request_with_params(GET, TAKER_VOLUME, params)

    # GET /api/v5/rubik/stat/taker-volume-contract
    def get_taker_volume_contract(self, instId, period = '', unit='', end='', begin='', limit = ''):
        params = {'instId': instId, 'period': period, 'unit': unit, 'end': end, 'begin': begin,'limit':limit}
        return self._request_with_params(GET, GET_TAKER_VOLUME_CONTRACT, params)

    def get_margin_lending_ratio(self, ccy, begin='', end='', period=''):
        params = {'ccy': ccy, 'begin': begin, 'end': end, 'period': period}
        return self._request_with_params(GET, MARGIN_LENDING_RATIO, params)

    # GET /api/v5/rubik/stat/contracts/long-short-account-ratio-contract-top-trader
    def get_long_short_account_ratio_contract_top_trader(self, instId = '', period = '', end = '', begin = '', limit = ''):
        params = {'instId': instId, 'period': period, 'end': end, 'begin': begin,'limit':limit}
        return self._request_with_params(GET, GET_LONG_SHORT_ACCOUNT_RADIO_CONTRACT_TOP_TRADER, params)

    # GET /api/v5/rubik/stat/contracts/long-short-position-ratio-contract-top-trader
    def get_long_short_position_ratio_contract_top_trader(self, instId = '', period = '', end = '', begin = '', limit = ''):
        params = {'instId': instId, 'period': period, 'end': end, 'begin': begin,'limit':limit}
        return self._request_with_params(GET, GET_LONG_SHORT_POSTION_RADIO_CONTRACT_TOP_TRADER, params)

    # GET /api/v5/rubik/stat/contracts/long-short-account-ratio-contract
    def get_long_short_account_ratio_contract(self, instId = '', period = '', end = '', begin = '', limit = ''):
        params = {'instId': instId, 'period': period, 'end': end, 'begin': begin,'limit':limit}
        return self._request_with_params(GET, GET_LONG_SHORT_ACCOUNT_RADIO_CONTRACT, params)

    def get_long_short_ratio(self, ccy, begin='', end='', period=''):
        params = {'ccy': ccy, 'begin': begin, 'end': end, 'period': period}
        return self._request_with_params(GET, LONG_SHORT_RATIO, params)

    def get_contracts_interest_volume(self, ccy, begin='', end='', period=''):
        params = {'ccy': ccy, 'begin': begin, 'end': end, 'period': period}
        return self._request_with_params(GET, CONTRACTS_INTEREST_VOLUME, params)

    def get_options_interest_volume(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return self._request_with_params(GET, OPTIONS_INTEREST_VOLUME, params)

    def get_put_call_ratio(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return self._request_with_params(GET, PUT_CALL_RATIO, params)

    def get_interest_volume_expiry(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return self._request_with_params(GET, OPEN_INTEREST_VOLUME_EXPIRY, params)

    def get_interest_volume_strike(self, ccy, expTime, period=''):
        params = {'ccy': ccy, 'expTime': expTime, 'period': period}
        return self._request_with_params(GET, INTEREST_VOLUME_STRIKE, params)

    def get_taker_flow(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return self._request_with_params(GET, TAKER_FLOW, params)





