from .client import Client
from .consts import *


class TradingDataAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    async def get_support_coin(self):
        return await self._request_without_params(GET, SUPPORT_COIN)

    async def get_taker_volume(self, ccy, instType, begin='', end='', period=''):
        params = {'ccy': ccy, 'instType': instType, 'begin': begin, 'end': end, 'period': period}
        return await self._request_with_params(GET, TAKER_VOLUME, params)

    async def get_margin_lending_ratio(self, ccy, begin='', end='', period=''):
        params = {'ccy': ccy, 'begin': begin, 'end': end, 'period': period}
        return await self._request_with_params(GET, MARGIN_LENDING_RATIO, params)

    async def get_long_short_ratio(self, ccy, begin='', end='', period=''):
        params = {'ccy': ccy, 'begin': begin, 'end': end, 'period': period}
        return await self._request_with_params(GET, LONG_SHORT_RATIO, params)

    async def get_contracts_interest_volume(self, ccy, begin='', end='', period=''):
        params = {'ccy': ccy, 'begin': begin, 'end': end, 'period': period}
        return await self._request_with_params(GET, CONTRACTS_INTEREST_VOLUME, params)

    async def get_options_interest_volume(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return await self._request_with_params(GET, OPTIONS_INTEREST_VOLUME, params)

    async def get_put_call_ratio(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return await self._request_with_params(GET, PUT_CALL_RATIO, params)

    async def get_interest_volume_expiry(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return await self._request_with_params(GET, OPEN_INTEREST_VOLUME_EXPIRY, params)

    async def get_interest_volume_strike(self, ccy, expTime, period=''):
        params = {'ccy': ccy, 'expTime': expTime, 'period': period}
        return await self._request_with_params(GET, INTEREST_VOLUME_STRIKE, params)

    async def get_taker_flow(self, ccy, period=''):
        params = {'ccy': ccy, 'period': period}
        return await self._request_with_params(GET, TAKER_FLOW, params)
