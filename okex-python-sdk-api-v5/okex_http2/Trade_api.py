from .client import Client
from .consts import *


class TradeAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Place Order
    async def place_order(self, instId, tdMode, side, ordType, sz, ccy='', clOrdId='', tag='', posSide='', px='',
                          reduceOnly='', tgtCcy=''):
        params = {'instId': instId, 'tdMode': tdMode, 'side': side, 'ordType': ordType, 'sz': sz, 'ccy': ccy,
                  'clOrdId': clOrdId, 'tag': tag, 'posSide': posSide, 'px': px, 'reduceOnly': reduceOnly,
                  'tgtCcy': tgtCcy}
        return await self._request_with_params(POST, PLACR_ORDER, params)

    # Place Multiple Orders
    async def place_multiple_orders(self, orders_data):
        return await self._request_with_params(POST, BATCH_ORDERS, orders_data)

    # Cancel Order
    async def cancel_order(self, instId, ordId='', clOrdId=''):
        params = {'instId': instId, 'ordId': ordId, 'clOrdId': clOrdId}
        return await self._request_with_params(POST, CANAEL_ORDER, params)

    # Cancel Multiple Orders
    async def cancel_multiple_orders(self, orders_data):
        return await self._request_with_params(POST, CANAEL_BATCH_ORDERS, orders_data)

    # Amend Order
    async def amend_order(self, instId, cxlOnFail='', ordId='', clOrdId='', reqId='', newSz='', newPx=''):
        params = {'instId': instId, 'cxlOnFailc': cxlOnFail, 'ordId': ordId, 'clOrdId': clOrdId, 'reqId': reqId,
                  'newSz': newSz,
                  'newPx': newPx}
        return await self._request_with_params(POST, AMEND_ORDER, params)

    # Amend Multiple Orders
    async def amend_multiple_orders(self, orders_data):
        return await self._request_with_params(POST, AMEND_BATCH_ORDER, orders_data)

    # Close Positions
    async def close_positions(self, instId, mgnMode, posSide='', ccy=''):
        params = {'instId': instId, 'mgnMode': mgnMode, 'posSide': posSide, 'ccy': ccy}
        return await self._request_with_params(POST, CLOSE_POSITION, params)

    # Get Order Details
    async def get_orders(self, instId, ordId='', clOrdId=''):
        params = {'instId': instId, 'ordId': ordId, 'clOrdId': clOrdId}
        return await self._request_with_params(GET, ORDER_INFO, params)

    # Get Order List
    async def get_order_list(self, instType='', uly='', instId='', ordType='', state='', after='', before='', limit=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId, 'ordType': ordType, 'state': state,
                  'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, ORDERS_PENDING, params)

    # Get Order History (last 7 days）
    async def get_orders_history(self, instType, uly='', instId='', ordType='', state='', after='', before='',
                                 limit=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId, 'ordType': ordType, 'state': state,
                  'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, ORDERS_HISTORY, params)

    # Get Order History (last 3 months)
    async def orders_history_archive(self, instType, uly='', instId='', ordType='', state='', after='', before='',
                                     limit=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId, 'ordType': ordType, 'state': state,
                  'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, ORDERS_HISTORY_ARCHIVE, params)

    # Get Transaction Details
    async def get_fills(self, instType='', uly='', instId='', ordId='', after='', before='', limit=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId, 'ordId': ordId, 'after': after, 'before': before,
                  'limit': limit}
        return await self._request_with_params(GET, ORDER_FILLS, params)

    # Place Algo Order
    async def place_algo_order(self, instId, tdMode, side, ordType, sz, ccy='', posSide='', reduceOnly='',
                               tpTriggerPx='',
                               tpOrdPx='', slTriggerPx='', slOrdPx='', triggerPx='', orderPx='', tgtCcy='', pxVar='',
                               pxSpread='',
                               szLimit='', pxLimit='', timeInterval='', tpTriggerPxType='', slTriggerPxType=''):
        params = {'instId': instId, 'tdMode': tdMode, 'side': side, 'ordType': ordType, 'sz': sz, 'ccy': ccy,
                  'posSide': posSide, 'reduceOnly': reduceOnly, 'tpTriggerPx': tpTriggerPx, 'tpOrdPx': tpOrdPx,
                  'slTriggerPx': slTriggerPx, 'slOrdPx': slOrdPx, 'triggerPx': triggerPx, 'orderPx': orderPx,
                  'tgtCcy': tgtCcy, 'pxVar': pxVar, 'szLimit': szLimit, 'pxLimit': pxLimit,
                  'timeInterval': timeInterval,
                  'pxSpread': pxSpread, 'tpTriggerPxType': tpTriggerPxType, 'slTriggerPxType': slTriggerPxType}
        return await self._request_with_params(POST, PLACE_ALGO_ORDER, params)

    # Cancel Algo Order
    async def cancel_algo_order(self, params):
        return await self._request_with_params(POST, CANCEL_ALGOS, params)

    # Cancel Advance Algos
    async def cancel_advance_algos(self, params):
        return await self._request_with_params(POST, Cancel_Advance_Algos, params)

    # Get Algo Order List
    async def order_algos_list(self, ordType, algoId='', instType='', instId='', after='', before='', limit=''):
        params = {'ordType': ordType, 'algoId': algoId, 'instType': instType, 'instId': instId, 'after': after,
                  'before': before, 'limit': limit}
        return await self._request_with_params(GET, ORDERS_ALGO_OENDING, params)

    # Get Algo Order History
    async def order_algos_history(self, ordType, state='', algoId='', instType='', instId='', after='', before='',
                                  limit=''):
        params = {'ordType': ordType, 'state': state, 'algoId': algoId, 'instType': instType, 'instId': instId,
                  'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, ORDERS_ALGO_HISTORY, params)

    # Get Transaction Details History
    async def get_fills_history(self, instType, uly='', instId='', ordId='', after='', before='', limit=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId, 'ordId': ordId, 'after': after, 'before': before,
                  'limit': limit}
        return await self._request_with_params(GET, ORDERS_FILLS_HISTORY, params)
