from .client import Client
from .consts import *


class StatusAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def status(self, state=''):
        params = {'state': state}
        return self._request_with_params(GET, STATUS, params)
