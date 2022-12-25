from .client import Client
from .consts import *


class CopytradingAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # GET /api/v5/copytrading/current-subpositions
    def current_subpositions(self, instId=''):
        params = {'instId': instId}
        return self._request_with_params(GET, CURRENT_SUBPOSITIONS, params)

    # GET /api/v5/copytrading/subpositions-history
    def subpositions_history(self, instId='', after='', before='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, SUBPOSITIONS_HISTORY, params)

    # POST /api/v5/copytrading/algo-order
    def copytrading_algo_order(self, subPosId='', tpTriggerPx='', slTriggerPx='', tpTriggerPxType='', slTriggerPxType=''):
        params = {'subPosId': subPosId, 'tpTriggerPx': tpTriggerPx, 'slTriggerPx': slTriggerPx, 'tpTriggerPxType': tpTriggerPxType, 'slTriggerPxType': slTriggerPxType}
        return self._request_with_params(POST, COPYTRADING_ALGO_ORDER, params)

    # POST /api/v5/copytrading/close-subposition
    def copytrading_close_subposition(self, subPosId=''):
        params = {'subPosId': subPosId}
        return self._request_with_params(POST, COPYTRADING_ALGO_ORDER, params)

    # GET /api/v5/copytrading/instruments
    def copytrading_instruments(self):
        params = {}
        return self._request_with_params(GET, COPYTRADING_INSTRUMENTS, params)

    # POST /api/v5/copytrading/set-instruments
    def copytrading_set_instruments(self, instId=''):
        params = {'instId': instId}
        return self._request_with_params(POST, COPYTRADING_SET_INSTRUMENTS, params)

    # GET /api/v5/copytrading/profit-sharing-details
    def profit_sharing_details(self, after='', before='', limit=''):
        params = {'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, PROFIT_SHARING_DETAILS, params)

    # GET /api/v5/copytrading/total-profit-sharing
    def total_profit_sharing(self):
        params = {}
        return self._request_with_params(GET, TOTAL_PROFIT_SHARING, params)

    # GET /api/v5/copytrading/unrealized-profit-sharing-details
    def unrealized_profit_sharing_details(self):
        params = {}
        return self._request_with_params(GET, UNREALIZED_PROFIT_SHARING_DETAILS, params)