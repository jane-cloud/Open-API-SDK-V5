from .client import Client
from .consts import *


class TradingBotAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def grid_order_algo(self, instId = '', algoOrdType = '', maxPx= '', minPx = '', gridNum ='', runType = '', tpTriggerPx = '', slTriggerPx = '', tag = '', quoteSz = '',algoClOrdId='',
                        baseSz = '', sz = '', direction = '', lever = '', basePos = '',tpRatio = '',slRatio='',profitSharingRatio='',triggerParams =[]):
        params = {'instId': instId, 'algoOrdType': algoOrdType, 'maxPx': maxPx, 'minPx': minPx, 'gridNum': gridNum, 'runType': runType, 'tpTriggerPx': tpTriggerPx, 'slTriggerPx': slTriggerPx, 'tag': tag, 'quoteSz': quoteSz, 'baseSz': baseSz, 'sz': sz, 'direction': direction, 'lever': lever, 'basePos':basePos,
                  'tpRatio': tpRatio,'slRatio': slRatio,'algoClOrdId':algoClOrdId,'profitSharingRatio':profitSharingRatio,'triggerParams':triggerParams}
        return self._request_with_params(POST, GRID_ORDER_ALGO, params)

    def grid_amend_order_algo(self, algoId = '', instId = '', slTriggerPx= '', tpTriggerPx ='',tpRatio = '',slRatio=''):
        params = {'algoId': algoId, 'instId': instId, 'slTriggerPx': slTriggerPx, 'tpTriggerPx': tpTriggerPx,'tpRatio': tpRatio,'slRatio': slRatio,}
        return self._request_with_params(POST, GRID_AMEND_ORDER_ALGO, params)

    def grid_stop_order_algo(self, algoId = '', instId = '', algoOrdType= '', stopType =''):
        params = [{'algoId': algoId, 'instId': instId, 'algoOrdType': algoOrdType, 'stopType': stopType}]
        return self._request_with_params(POST, GRID_STOP_ORDER_ALGO, params)
    
    def grid_orders_algo_pending(self, algoOrdType = '', algoId = '', instId = '', instType = '', after = '', before = '', limit = ''):
        params = {'algoOrdType': algoOrdType, 'algoId': algoId, 'instId': instId, 'instType': instType, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, GRID_ORDERS_ALGO_PENDING, params)

    def grid_orders_algo_history(self, algoOrdType = '', algoId = '', instId = '', instType = '', after = '', before = '', limit = ''):
        params = {'algoOrdType': algoOrdType, 'algoId': algoId, 'instId': instId, 'instType': instType, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, GRID_ORDERS_ALGO_HISTORY, params)

    def grid_orders_algo_details(self, algoOrdType = '', algoId = ''):
        params = {'algoOrdType': algoOrdType, 'algoId': algoId}
        return self._request_with_params(GET, GRID_ORDERS_ALGO_DETAILS, params)

    def grid_sub_orders(self, algoId = '', algoOrdType = '', type = '', groupId = '', after = '', before = '', limit = ''):
        params = {'algoId': algoId, 'algoOrdType': algoOrdType, 'type': type, 'groupId': groupId, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, GRID_SUB_ORDERS, params)

    def grid_positions(self, algoOrdType = '', algoId = ''):
        params = {'algoOrdType': algoOrdType, 'algoId': algoId}
        return self._request_with_params(GET, GRID_POSITIONS, params)

    def grid_withdraw_income(self, algoId = ''):
        params = {'algoId': algoId}
        return self._request_with_params(POST, GRID_WITHDRAW_INCOME, params)

    def grid_compute_margin_balance(self, algoId = '', type = '', amt = ''):
        params = {'algoId': algoId, 'type':type, 'amt':amt}
        return self._request_with_params(POST, GRID_COMPUTE_MARGIN_BALANCE, params)

    def grid_margin_balance(self, algoId = '', type = '', amt = '', percent = ''):
        params = {'algoId': algoId, 'type':type, 'amt':amt, 'percent':percent}
        return self._request_with_params(POST, GRID_MARGIN_BALANCE, params)

    def grid_ai_param(self, algoOrdType = '', instId = '', direction = '', duration = ''):
        params = {'algoOrdType': algoOrdType, 'instId':instId, 'direction':direction, 'duration':duration}
        return self._request_with_params(GET, GRID_AI_PARAM, params)

    # POST /api/v5/tradingBot/grid/adjust-investment
    def grid_adjust_investment(self, algoId = '', amt = ''):
        params = {'algoId': algoId, 'amt':amt}
        return self._request_with_params(POST, GRID_ADJUST_INVESTMETN, params)