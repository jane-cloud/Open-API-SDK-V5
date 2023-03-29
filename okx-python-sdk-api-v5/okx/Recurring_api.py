from .client import Client
from .consts import *


class RecurringAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # POST /api/v5/tradingBot/recurring/order-algo
    def recurring_order_algo(self, stgyName = '', recurringList = [], period = '', recurringDay = '', recurringTime = '', timeZone = '', amt = '', investmentCcy = '', tdMode = '', algoClOrdId = '', tag = ''):
        params = {'stgyName': stgyName, 'recurringList': recurringList, 'period': period, 'recurringDay':recurringDay, 'recurringTime': recurringTime,
        'timeZone': timeZone,'amt': amt,'investmentCcy': investmentCcy,'tdMode': tdMode,'algoClOrdId': algoClOrdId,'tag': tag}
        return self._request_with_params(POST, RECURRING_ORDER_ALGO, params)

    # POST /api/v5/tradingBot/recurring/amend-order-algo
    def recurring_amend_order_algo(self, algoId = '', stgyName = ''):
        params = {'algoId': algoId, 'stgyName': stgyName}
        return self._request_with_params(POST, RECURRING_AMEND_ORDER_ALGO, params)

    # POST /api/v5/tradingBot/recurring/stop-order-algo
    def recurring_stop_order_algo(self, orders_data):
        return self._request_with_params(POST, RECURRING_STOP_ORDER_ALGO, orders_data)

    # GET /api/v5/tradingBot/recurring/orders-algo-pending
    def recurring_orders_algo_pending(self, algoId = '', after = '', before = '', limit = ''):
        params = {'algoId': algoId, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, RECURRING_ORDER_ALGO_PENDING, params)

    # GET /api/v5/tradingBot/recurring/orders-algo-history
    def recurring_orders_algo_history(self, algoId = '', after = '', before = '', limit = ''):
        params = {'algoId': algoId, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, RECURRING_ORDER_ALGO_HISTORY, params)

    # GET /api/v5/tradingBot/recurring/orders-algo-details
    def recurring_orders_algo_details(self, algoId = ''):
        params = {'algoId': algoId}
        return self._request_with_params(GET, RECURRING_ORDER_ALGO_DETAILS, params)

    # GET /api/v5/tradingBot/recurring/sub-orders
    def recurring_sub_orders(self, algoId = '', ordId = '', after = '', before = '', limit = ''):
        params = {'algoId': algoId, 'ordId': ordId, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, RECURRING_SUB_ORDERS, params)
