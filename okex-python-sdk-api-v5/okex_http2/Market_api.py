from .client import Client
from .consts import *


class MarketAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Tickers
    async def get_tickers(self, instType, uly=''):
        if uly:
            params = {'instType': instType, 'uly': uly}
        else:
            params = {'instType': instType}
        return await self._request_with_params(GET, TICKERS_INFO, params)

    # Get Ticker
    async def get_ticker(self, instId):
        params = {'instId': instId}
        return await self._request_with_params(GET, TICKER_INFO, params)

    # Get Index Tickers
    async def get_index_ticker(self, quoteCcy='', instId=''):
        params = {'quoteCcy': quoteCcy, 'instId': instId}
        return await self._request_with_params(GET, INDEX_TICKERS, params)

    # Get Order Book
    async def get_orderbook(self, instId, sz=''):
        params = {'instId': instId, 'sz': sz}
        return await self._request_with_params(GET, ORDER_BOOKS, params)

    # Get Candlesticks
    async def get_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return await self._request_with_params(GET, MARKET_CANDLES, params)

    # GGet Candlesticks History（top currencies only）
    async def get_history_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return await self._request_with_params(GET, HISTORY_CANDLES, params)

    # Get Index Candlesticks
    async def get_index_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return await self._request_with_params(GET, INDEX_CANSLES, params)

    # Get Mark Price Candlesticks
    async def get_markprice_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return await self._request_with_params(GET, MARKPRICE_CANDLES, params)

    # Get Index Candlesticks
    async def get_trades(self, instId, limit=''):
        params = {'instId': instId, 'limit': limit}
        return await self._request_with_params(GET, MARKET_TRADES, params)

    # Get Volume
    async def get_volume(self):
        return await self._request_without_params(GET, VOLUMNE)

    # Get Oracle
    async def get_oracle(self):
        return await self._request_without_params(GET, ORACLE)

    # Get Tier
    async def get_tier(self, instType='', tdMode='', uly='', instId='', ccy='', tier=''):
        params = {'instType': instType, 'tdMode': tdMode, 'uly': uly, 'instId': instId, 'ccy': ccy, 'tier': tier}
        return await self._request_with_params(GET, TIER, params)
