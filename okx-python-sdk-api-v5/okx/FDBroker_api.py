from .client import Client
from .consts import *


class FDBrokerAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def fd_rebate_per_orders(self, begin = '', end = '', brokerType = ''):
        params = {'begin': begin, 'end': end, 'brokerType':brokerType}
        return self._request_with_params(POST, FD_REBATE_PER_ORDERS, params)

    def fd_get_rebate_per_orders(self, type = '', begin = '', end = '', brokerType = ''):
        params = {'type': type, 'begin': begin, 'end': end, 'brokerType':brokerType}
        return self._request_with_params(GET, FD_GET_REBATE_PER_ORDERS, params)