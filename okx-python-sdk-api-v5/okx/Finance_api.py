from .client import Client
from .consts import *


class FinanceAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # View items
    def staking_defi_offers(self, productId = '', protocolType = '', ccy = ''):
        params = {'productId': productId, 'protocolType': protocolType, 'ccy': ccy}
        return self._request_with_params(GET, STAKING_DEFI_OFFERS, params)

    # Subscription items
    def staking_defi_purchase(self, productId = '', investData = [], term= ''):
        params = {'productId': productId, 'investData': investData, 'term': term}
        return self._request_with_params(POST, STAKING_DEFI_PURCHASE, params)

    # Redemption items
    def staking_defi_redeem(self, ordId = '', protocolType = '', allowEarlyRedeem= ''):
        params = {'ordId': ordId, 'protocolType': protocolType, 'allowEarlyRedeem': allowEarlyRedeem}
        return self._request_with_params(POST, STAKING_DEFI_REDEEM, params)

    # Cancellation of project subscription / redemption
    def staking_defi_cancel(self, ordId = '', protocolType = ''):
        params = {'ordId': ordId, 'protocolType': protocolType}
        return self._request_with_params(POST, STAKING_DEFI_CANCEL, params)

    # View active orders
    def staking_defi_orders_active(self, productId = '', protocolType = '', ccy = '', state = ''):
        params = {'productId': productId, 'protocolType': protocolType, 'ccy': ccy, 'state':state}
        return self._request_with_params(GET, STAKING_DEFI_ORDERS_ACTIVE, params)

    # View active orders
    def staking_defi_orders_history(self, productId = '', protocolType = '', ccy = '', after = '', before = '', limit = ''):
        params = {'productId': productId, 'protocolType': protocolType, 'ccy': ccy, 'after':after, 'before':before, 'limit':limit}
        return self._request_with_params(GET, STAKING_DEFI_ORDERS_HISTORY, params)