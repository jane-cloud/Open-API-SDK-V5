from .client import Client
from .consts import *


class MarketAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Tickers
    def get_tickers(self, instType, uly=''):
        if uly:
            params = {'instType': instType, 'uly': uly}
        else:
            params = {'instType': instType}
        return self._request_with_params(GET, TICKERS_INFO, params)

    # Get Ticker
    def get_ticker(self, instId):
        params = {'instId': instId}
        return self._request_with_params(GET, TICKER_INFO, params)

    # Get Index Tickers
    def get_index_ticker(self, quoteCcy='', instId=''):
        params = {'quoteCcy': quoteCcy, 'instId': instId}
        return self._request_with_params(GET, INDEX_TICKERS, params)

    # Get Order Book
    def get_orderbook(self, instId, sz=''):
        params = {'instId': instId, 'sz': sz}
        return self._request_with_params(GET, ORDER_BOOKS, params)

    # Get Candlesticks
    def get_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return self._request_with_params(GET, MARKET_CANDLES, params)

    # GGet Candlesticks History（top currencies only）
    def get_history_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return self._request_with_params(GET, HISTORY_CANDLES, params)

    # Get Index Candlesticks
    def get_index_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return self._request_with_params(GET, INDEX_CANSLES, params)

    # Get Mark Price Candlesticks
    def get_markprice_candlesticks(self, instId, after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return self._request_with_params(GET, MARKPRICE_CANDLES, params)

    # Get Index Candlesticks
    def get_trades(self, instId, limit=''):
        params = {'instId': instId, 'limit': limit}
        return self._request_with_params(GET, MARKET_TRADES, params)

    # Get Volume
    def get_volume(self):
        return self._request_without_params(GET, VOLUMNE)

    # Get Oracle
    def get_oracle(self):
        return self._request_without_params(GET, ORACLE)

    # Get Index Components
    def get_index_components(self, index):
        params = {'index': index}
        return self._request_with_params(GET, Components, params)

    # Get Tier
    def get_tier(self, instType='', tdMode='', uly='', instId='', ccy='', tier=''):
        params = {'instType': instType, 'tdMode': tdMode, 'uly': uly, 'instId': instId, 'ccy': ccy, 'tier': tier}
        return self._request_with_params(GET, TIER, params)

    # Get exchange rate
    def get_exchange_rate(self):
        params = {}
        return self._request_with_params(GET, BORROW_REPAY, params)

    # Get history trades
    def get_history_trades(self, instId = '', after = '', before = '', limit = ''):
        params = {'instId':instId, 'after':after, 'before':before, 'limit':limit}
        return self._request_with_params(GET, HISTORY_TRADES, params)

    # Get block history tickers
    def get_block_tickers(self, instType = '', uly = ''):
        params = {'instType':instType, 'uly':uly}
        return self._request_with_params(GET, BLOCK_TICKERS, params)

    # Get block history ticker
    def get_block_ticker(self, instId = ''):
        params = {'instId':instId}
        return self._request_with_params(GET, BLOCK_TICKER, params)

    # Get block trades
    def get_block_trades(self, instId = ''):
        params = {'instId':instId}
        return self._request_with_params(GET, BLOCK_TRADES, params)

    # Get history index candlesticks
    def get_history_index_candlesticks(self, instId ='', after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return self._request_with_params(GET, HISTORY_INDEX_CANDLES, params)

    # Get history mark price candlesticks
    def get_history_markprice_candlesticks(self, instId ='', after='', before='', bar='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'bar': bar, 'limit': limit}
        return self._request_with_params(GET, HISTORY_MARK_PRICE_CANDLES, params)