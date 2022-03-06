from .client import Client
from .consts import *


class ConvertAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def get_currencies(self):
        params = {}
        return self._request_with_params(GET, GET_CURRENCIES, params)

    def get_currency_pair(self, fromCcy='', toCcy=''):
        params = {"fromCcy": fromCcy, 'toCcy': toCcy}
        return self._request_with_params(GET, GET_CURRENCY_PAIR, params)

    def estimate_quote(self, baseCcy = '', quoteCcy = '', side = '', rfqSz = '', rfqSzCcy = '', clQReqId = ''):
        params = {'baseCcy': baseCcy, 'quoteCcy': quoteCcy, 'side':side, 'rfqSz':rfqSz, 'rfqSzCcy':rfqSzCcy, 'clQReqId':clQReqId}
        return self._request_with_params(POST, ESTIMATE_QUOTE, params)

    def convert_trade(self, quoteId = '', baseCcy = '', quoteCcy = '', side = '', sz = '', szCcy = '', clTReqId = ''):
        params = {'quoteId': quoteId, 'baseCcy': baseCcy, 'quoteCcy':quoteCcy, 'side':side, 'sz':sz, 'szCcy':szCcy, 'clTReqId':clTReqId}
        return self._request_with_params(POST, CONVERT_TRADE, params)

    def get_convert_history(self, after = '', before = '', limit = ''):
        params = {'after': after, 'before': before, 'limit':limit}
        return self._request_with_params(GET, CONVERT_HISTORY, params)
