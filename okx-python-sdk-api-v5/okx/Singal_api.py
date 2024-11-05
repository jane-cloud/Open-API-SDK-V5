from .client import Client
from .consts import *


class SignalApi(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)


    def create_signal(self,signalChanName='',signalChanDesc=''):
        params = {'signalChanName':signalChanName,'signalChanDesc':signalChanDesc}
        return self._request_with_params(POST, CREAT_SIGNAL, params)

    def signals(self, signalSourceType='', signalChanId='',after='', before='',
                limit='', ):
        params = {'signalSourceType': signalSourceType, 'signalChanId': signalChanId,'after': after,
                  'before': before,'limit': limit,}
        return self._request_with_params(GET, SIGNALS, params)

    def order_algo(self, includeAll='', signalChanId='',instIds='', lever='',
                investAmt='',subOrdType='',ratio='',entrySettingParam='',exitSettingParam='', ):
        params = {'includeAll': includeAll, 'signalChanId': signalChanId,'instIds': instIds,
                  'lever': lever,'investAmt': investAmt,'subOrdType': subOrdType,'ratio': ratio,'entrySettingParam': entrySettingParam,
                  'exitSettingParam':exitSettingParam}
        return self._request_with_params(POST, ORDER_ALGO_SIGNAL, params)

    def signal_stop_order_algo(self, algoId='', ):
        params = {'algoId': algoId, }
        return self._request_with_params(POST, SIGNAL_STOP_ORDER_ALGO, params)

    def signal_margin_balance(self, algoId='',type='',amt='',allowReinvest='', ):
        params = {'algoId': algoId, 'type': type, 'amt': amt, 'allowReinvest': allowReinvest, }
        return self._request_with_params(POST, SIGNAL_MARGIN_BALANCE, params)

    def amendTPSL(self, algoId='',exitSettingParam='', ):
        params = {'algoId': algoId, 'exitSettingParam': exitSettingParam,  }
        return self._request_with_params(POST, AMENDTPSL, params)

    def signal_set_instruments(self, algoId='',instIds='', includeAll=''):
        params = {'algoId': algoId, 'instIds': instIds,'includeAll':includeAll}
        return self._request_with_params(POST, SIGNAL_SET_INSTRUMENTS, params)

    def orders_algo_details(self, algoId='',algoOrdType='', ):
        params = {'algoId': algoId, 'algoOrdType': algoOrdType,}
        return self._request_with_params(GET, ORDERS_ALGO_DETAILS, params)

    def orders_algo_pending(self, algoId='',algoOrdType='',after='',before='',limit='', ):
        params = {'algoId': algoId, 'algoOrdType': algoOrdType,'after': after,
                  'before': before,'limit': limit,}
        return self._request_with_params(GET, ORDERS_ALGO_PENDING, params)

    def orders_algo_history(self, algoId='',algoOrdType='',after='',before='',limit='', ):
        params = {'algoId': algoId, 'algoOrdType': algoOrdType,'after': after,
                  'before': before,'limit': limit,}
        return self._request_with_params(GET, ORDERS_ALGO_HISTORY, params)

    def signal_positions(self, algoId='',algoOrdType='', ):
        params = {'algoId': algoId, 'algoOrdType': algoOrdType,}
        return self._request_with_params(GET, SIGNAL_POSITIONS, params)

    def signal_positions_history(self, algoId='',instId='',after='',before='',limit='',  ):
        params = {'algoId': algoId, 'instId': instId,'after': after,
                  'before': before,'limit': limit,}
        return self._request_with_params(GET, SIGNAL_POSITIONS_HISTORY, params)

    def signal_close_position(self, algoId='',instId='',):
        params = {'algoId': algoId, 'instId': instId,}
        return self._request_with_params(POST, SIGNAL_CLOSE_POSITION, params)

    def sub_order(self, algoId='',instId='',side='',ordType='',sz='',px='',reduceOnly=''):
        params = {'algoId': algoId, 'instId': instId,'side': side, 'ordType': ordType,'sz': sz, 'px': px,
                  'reduceOnly': reduceOnly, }
        return self._request_with_params(POST, SUB_ORDER, params)

    def cancel_sub_order(self, algoId='',instId='',signalOrdId='',):
        params = {'algoId': algoId, 'instId': instId,'signalOrdId': signalOrdId,}
        return self._request_with_params(POST, CANCEL_SUB_ORDER, params)

    def sub_orders(self, algoId='',algoOrdType='',signalOrdId='',state='',after='',before='',limit='',
                   begin='',end='',type='',clOrdId=''):
        params = {'algoId': algoId, 'algoOrdType': algoOrdType,'state': state,'after': after, 'before': before,'limit': limit,
                  'begin': begin, 'end': end,'type': type,'clOrdId': clOrdId, 'signalOrdId': signalOrdId, }
        return self._request_with_params(GET, SUB_ORDERS, params)

    def event_history(self, algoId='',after='',before='',limit='',
                  ):
        params = {'algoId': algoId, 'after': after, 'before': before,'limit': limit,
                 }
        return self._request_with_params(GET, EVENT_HISTORY, params)


