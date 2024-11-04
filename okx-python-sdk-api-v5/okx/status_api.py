from .client import Client
from .consts import *


class StatusAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def status(self, state=''):
        params = {'state': state}
        return self._request_with_params(GET, STATUS, params)

    # GET /api/v5/support/announcements
    def get_announcements(self, annType = '', page = ''):
        params = {'annType': annType, 'page': page}
        return self._request_with_params(GET, GET_ANNOUNCEMENTS, params)

    # GET /api/v5/support/announcement-types
    def get_announcements_types(self):
        params = {}
        return self._request_with_params(GET, GET_ANNOUNCEMENTS_TYPES, params)