from .client import Client
from .consts import *


class SprdAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # 下单 POST /api/v5/sprd/order
    def place(self,sprdId,side,ordType,sz,px='',clOrdId='',tag='',):
        params = {'sprdId':sprdId,'clOrdId':clOrdId,'tag':tag,'side':side,'ordType':ordType,
                  'sz':sz,'px':px,}
        return self._request_with_params(POST, SPRD_PLACE_ORDER, params)

    # 撤单 POST /api/v5/sprd/cancel-order
    def cancel_order(self,ordId='',clOrdId=''):
        params = {'ordId':ordId,'clOrdId':clOrdId}
        return self._request_with_params(POST, SPRD_CANCEL_ORDER, params)

    # 全部撤单 POST /api/v5/sprd/mass-cancel
    def mass_cancel(self,sprdId):
        params = {'sprdId':sprdId}
        return self._request_with_params(POST, SPRD_MASS_CANCELS, params)

    # 修改订单 POST /api/v5/sprd/amend-order
    def amend_cancel(self,reqId='',ordId='', clOrdId='', newSz='', newPx=''):
        params = {'reqId':reqId, 'ordId':ordId, 'clOrdId':clOrdId, 'newSz':newSz, 'newPx':newPx, }
        return self._request_with_params(POST, SPRD_AMEND_CANCELS, params)

    # 获取订单信息 GET /api/v5/sprd/order
    def order(self, ordId='', clOrdId=''):
        params = {'ordId': ordId, 'clOrdId': clOrdId}
        return self._request_with_params(GET, SPRD_ORDER, params)

    # 获取未成交订单列表 GET /api/v5/sprd/orders-pending
    def orders_pending(self,sprdId='', ordType='', state='', beginId='', endId='', limit=''):
        params = {'sprdId': sprdId, 'ordType': ordType,
                  'state': state,
                  'endId': endId,
                  'beginId': beginId,'limit': limit,
                  }
        return self._request_with_params(GET, SPRD_ORDERS_PENDING, params)

    # 获取历史订单记录（近21天) GET /api/v5/sprd/orders-history
    def orders_history(self,sprdId='',ordType='',state='',beginId='',endId='',limit='',
                       begin='',end='',):
        params = {'sprdId': sprdId, 'ordType': ordType,
                  'state': state,'begin': state,
                  'endId': endId,'end': endId,
                  'beginId': beginId, 'limit': limit,
                  }
        return self._request_with_params(GET, SPRD_ORDERS_HISTORY, params)


    # 获取历史订单记录（近3个月) GET /api/v5/sprd/orders-history-archive
    def orders_history_archive(self, sprdId='', ordType='', state='', beginId='', endId='', limit='',
                       begin='', end='', ):
        params = {'sprdId': sprdId, 'ordType': ordType,
                  'state': state, 'begin': state,
                  'endId': endId, 'end': endId,
                  'beginId': beginId, 'limit': limit,
                  }
        return self._request_with_params(GET, SPRD_ORDERS_HISTORY_ARCHIVE, params)

    # 获取历史成交数据（近七天）GET /api/v5/sprd/trades
    def trades(self,sprdId='',tradeId='',ordId='',beginId='',endId='',limit='',begin='',end='',):
        params = {'sprdId': sprdId, 'ordId': ordId,'tradeId': tradeId,'begin': state,'endId': endId,'end': endId,
                  'beginId': beginId, 'limit': limit,}
        return self._request_with_params(GET, SPRD_TRADES, params)

    # 获取Spreads（公共）GET /api/v5/sprd/spreads
    def spreads(self,baseCcy='',instId='',sprdId='',state='',):
        params = {'sprdId': sprdId, 'baseCcy': baseCcy, 'instId': instId,'state': state,}
        return self._request_with_params(GET, SPRD_SPREADS, params)

    # 获取Spread产品深度（公共）GET /api/v5/sprd/books
    def books(self,sprdId='',sz='',):
        params = {'sprdId': sprdId, 'sz': sz,}
        return self._request_with_params(GET, SPRD_BOOKS, params)

    # 获取单个Spread产品行情信息（公共） GET /api/v5/sprd/ticker
    def ticker(self,sprdId=''):
        params = {'sprdId': sprdId}
        return self._request_with_params(GET, SPRD_TICKER, params)

    # 获取公共成交数据（公共）GET /api/v5/sprd/public-trades
    def public_trades(self,sprdId=''):
        params = {'sprdId': sprdId}
        return self._request_with_params(GET, SPRD_PUBLIC_TRADES, params)

    # POST /api/v5/sprd/cancel-all-after
    def sprd_cancel_all_after(self,timeOut=''):
        params = {'timeOut':timeOut }
        return self._request_with_params(POST, SPRD_CANCEL_ALL_AFTER, params)


    # GET /api/v5/market/sprd-candles
    def get_sprd_candles(self,sprdId='', bar='', after='', before='', limit=''):
        params = {'sprdId': sprdId, 'bar': bar, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, GET_SPRD_CANDLES, params)

    # GET /api/v5/market/sprd-history-candles
    def get_sprd_history_candles(self,sprdId='', bar='', after='', before='', limit=''):
        params = {'sprdId': sprdId, 'bar': bar, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, GET_SPRD_HISTORY_CANDLES, params)


