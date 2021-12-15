from .client import Client
from .consts import *


class BrokerAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def broker_info(self):
        params = {}
        return self._request_with_params(GET, BROKER_INFO, params)

    def create_subaccount(self, pwd='', subAcct='', label='', acctLv=''):
        params = {"pwd": pwd, 'subAcct': subAcct, 'label': label, 'acctLv': acctLv}
        return self._request_with_params(POST, CREATE_SUBACCOUNT, params)

    def delete_subaccount(self, pwd='', subAcct=''):
        params = {'pwd': pwd, 'subAcct': subAcct}
        return self._request_with_params(POST, DELETE_SUBACCOUNT, params)

    def subaccount_info(self, subAcct='', page='', limit=''):
        params = {'subAcct': subAcct, 'page': page, 'limit': limit}
        return self._request_with_params(GET, SUBACCOUNT_INFO, params)

    def set_subaccount_level(self, subAcct='', acctLv=''):
        params = {'subAcct': subAcct, 'acctLv': acctLv}
        return self._request_with_params(POST, SET_SUBACCOUNT_LEVEL, params)

    def set_subaccount_fee_rate(self, subAcct='', instType='', chgType='', chgTaker='', chgMaker='', effDate=''):
        params = {'subAcct': subAcct, 'instType': instType, 'chgType': chgType, 'chgTaker': chgTaker, 'chgMaker':chgMaker, 'effDate':effDate}
        return self._request_with_params(POST, SET_SUBACCOUNT_FEE_REAT, params)

    def subaccount_deposit_address(self, subAcct='', ccy='', chain='', addrType='', to=''):
        params = {'subAcct': subAcct, 'ccy': ccy, 'chain': chain, 'addrType': addrType, 'to': to}
        return self._request_with_params(POST, SUBACCOUNT_DEPOSIT_ADDRESS, params)

    def subaccount_deposit_history(self, subAcct = '', ccy = '', txId = '', state = '', after = '', before = '', limit = ''):
        params = {'subAcct': subAcct, 'ccy': ccy, 'txId': txId, 'state': state, 'after': after, 'before': before, 'limit':limit}
        return self._request_with_params(GET, SUBACCOUNT_DEPOSIT_HISTORY, params)

    def rebate_daily(self, subAcct = '', begin = '', end = '', page = '', limit = ''):
        params = {'subAcct': subAcct, 'begin': begin, 'end': end, 'page': page, 'limit': limit}
        return self._request_with_params(GET, REBATE_DAILY, params)