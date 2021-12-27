from .client import Client
from .consts import *


class PublicAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Instruments
    async def get_instruments(self, instType, uly='', instId=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId}
        return await self._request_with_params(GET, INSTRUMENT_INFO, params)

    # Get Delivery/Exercise History
    async def get_deliver_history(self, instType, uly, after='', before='', limit=''):
        params = {'instType': instType, 'uly': uly, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, DELIVERY_EXERCISE, params)

    # Get Open Interest
    async def get_open_interest(self, instType, uly='', instId=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId}
        return await self._request_with_params(GET, OPEN_INTEREST, params)

    # Get Funding Rate
    async def get_funding_rate(self, instId):
        params = {'instId': instId}
        return await self._request_with_params(GET, FUNDING_RATE, params)

    # Get Funding Rate History
    async def funding_rate_history(self, instId, after='', before='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, FUNDING_RATE_HISTORY, params)

    # Get Limit Price
    async def get_price_limit(self, instId):
        params = {'instId': instId}
        return await self._request_with_params(GET, PRICE_LIMIT, params)

    # Get Option Market Data
    async def get_opt_summary(self, uly, expTime=''):
        params = {'uly': uly, 'expTime': expTime}
        return await self._request_with_params(GET, OPT_SUMMARY, params)

    # Get Estimated Delivery/Excercise Price
    async def get_estimated_price(self, instId):
        params = {'instId': instId}
        return await self._request_with_params(GET, ESTIMATED_PRICE, params)

    # Get Discount Rate And Interest-Free Quota
    async def discount_interest_free_quota(self, ccy=''):
        params = {'ccy': ccy}
        return await self._request_with_params(GET, DICCOUNT_INTETEST_INFO, params)

    # Get System Time
    async def get_system_time(self):
        return await self._request_without_params(GET, SYSTEM_TIME)

    # Get Liquidation Orders
    async def get_liquidation_orders(self, instType, mgnMode='', instId='', ccy='', uly='', alias='', state='',
                                     before='',
                                     after='', limit=''):
        params = {'instType': instType, 'mgnMode': mgnMode, 'instId': instId, 'ccy': ccy, 'uly': uly,
                  'alias': alias, 'state': state, 'before': before, 'after': after, 'limit': limit}
        return await self._request_with_params(GET, LIQUIDATION_ORDERS, params)

    # Get Mark Price
    async def get_mark_price(self, instType, uly='', instId=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId}
        return await self._request_with_params(GET, MARK_PRICE, params)

    # Get Tier
    async def get_tier(self, instType, tdMode, uly='', instId='', ccy='', tier=''):
        params = {'instType': instType, 'tdMode': tdMode, 'uly': uly, 'instId': instId, 'ccy': ccy, 'tier': tier}
        return await self._request_with_params(GET, TIER, params)
