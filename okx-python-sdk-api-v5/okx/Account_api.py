from .client import Client
from .consts import *


class AccountAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Positions
    def get_position_risk(self, instType=''):
        params = {}
        if instType:
            params['instType'] = instType
        return self._request_with_params(GET, POSITION_RISK, params)

    # Get Balance
    def get_account(self, ccy=''):
        params = {}
        if ccy:
            params['ccy'] = ccy
        return self._request_with_params(GET, ACCOUNT_INFO, params)

    # Get Positions
    def get_positions(self, instType='', instId=''):
        params = {'instType': instType, 'instId': instId}
        return self._request_with_params(GET, POSITION_INFO, params)

    # Get Bills Details (recent 7 days)
    def get_bills_detail(self, instType='', ccy='', mgnMode='', ctType='', type='', subType='', after='', before='',
                         limit=''):
        params = {'instType': instType, 'ccy': ccy, 'mgnMode': mgnMode, 'ctType': ctType, 'type': type,
                  'subType': subType, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, BILLS_DETAIL, params)

    # Get Bills Details (recent 3 months)
    def get_bills_details(self, instType='', ccy='', mgnMode='', ctType='', type='', subType='', after='', before='',
                          limit=''):
        params = {'instType': instType, 'ccy': ccy, 'mgnMode': mgnMode, 'ctType': ctType, 'type': type,
                  'subType': subType, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, BILLS_ARCHIVE, params)

    # Get Account Configuration
    def get_account_config(self):
        return self._request_without_params(GET, ACCOUNT_CONFIG)

    # Get Account Configuration
    def get_position_mode(self, posMode):
        params = {'posMode': posMode}
        return self._request_with_params(POST, POSITION_MODE, params)

    # Get Account Configuration
    def set_leverage(self, lever, mgnMode, instId='', ccy='', posSide=''):
        params = {'lever': lever, 'mgnMode': mgnMode, 'instId': instId, 'ccy': ccy, 'posSide': posSide}
        return self._request_with_params(POST, SET_LEVERAGE, params)

    # Get Maximum Tradable Size For Instrument
    def get_maximum_trade_size(self, instId, tdMode, ccy='', px='', leverage='',unSpotOffset=''):
        params = {'instId': instId, 'tdMode': tdMode, 'ccy': ccy, 'px': px, 'leverage':leverage,'unSpotOffset':unSpotOffset}
        return self._request_with_params(GET, MAX_TRADE_SIZE, params)

    # Get Maximum Available Tradable Amount
    def get_max_avail_size(self, instId, tdMode, ccy='', reduceOnly='', unSpotOffset=''):
        params = {'instId': instId, 'tdMode': tdMode, 'ccy': ccy, 'reduceOnly': reduceOnly,'unSpotOffset':unSpotOffset}
        return self._request_with_params(GET, MAX_AVAIL_SIZE, params)

    # Increase / Decrease margin
    def Adjustment_margin(self, instId, posSide, type, amt,loanTrans=''):
        params = {'instId': instId, 'posSide': posSide, 'type': type, 'amt': amt,'loanTrans':loanTrans}
        return self._request_with_params(POST, ADJUSTMENT_MARGIN, params)

    # Get Leverage
    def get_leverage(self, instId, mgnMode):
        params = {'instId': instId, 'mgnMode': mgnMode}
        return self._request_with_params(GET, GET_LEVERAGE, params)

    # Get the maximum loan of isolated MARGIN
    def get_max_load(self, instId, mgnMode, mgnCcy):
        params = {'instId': instId, 'mgnMode': mgnMode, 'mgnCcy': mgnCcy}
        return self._request_with_params(GET, MAX_LOAN, params)

    # Get Fee Rates
    def get_fee_rates(self, instType, instId='', uly='', category=''):
        params = {'instType': instType, 'instId': instId, 'uly': uly, 'category': category}
        return self._request_with_params(GET, FEE_RATES, params)

    # Get interest-accrued
    def get_interest_accrued(self, instId='', ccy='', mgnMode='', after='', before='', limit='', type=''):
        params = {'instId': instId, 'ccy': ccy, 'mgnMode': mgnMode, 'after': after, 'before': before, 'limit': limit, 'type':type}
        return self._request_with_params(GET, INTEREST_ACCRUED, params)

    # Get interest-accrued
    def get_interest_rate(self, ccy=''):
        params = {'ccy': ccy}
        return self._request_with_params(GET, INTEREST_RATE, params)

    # Set Greeks (PA/BS)
    def set_greeks(self, greeksType):
        params = {'greeksType': greeksType}
        return self._request_with_params(POST, SET_GREEKS, params)

    # Set Isolated Mode
    def set_isolated_mode(self, isoMode,type):
        params = {'isoMode': isoMode, 'type':type}
        return self._request_with_params(POST, ISOLATED_MODE, params)

    # Get Maximum Withdrawals
    def get_max_withdrawal(self, ccy=''):
        params = {'ccy': ccy}
        return self._request_with_params(GET, MAX_WITHDRAWAL, params)

    # Get account risk state
    def get_account_risk(self):
        return self._request_without_params(GET, ACCOUNT_RISK)

    # Get borrow repay
    def borrow_repay(self, ccy='', side='', amt=''):
        params = {'ccy': ccy, 'side': side, 'amt': amt}
        return self._request_with_params(POST, BORROW_REPAY, params)

    # Get borrow repay history
    def get_borrow_repay_history(self, ccy='', after='', before='', limit=''):
        params = {'ccy': ccy, 'after': after, 'before': before, 'limit':limit}
        return self._request_with_params(GET, BORROW_REPAY_HISTORY, params)

    # Get Obtain borrowing rate and limit
    def get_interest_limits(self, type='',ccy=''):
        params = {'type': type, 'ccy': ccy}
        return self._request_with_params(GET, INTEREST_LIMITS, params)

    # Get Simulated Margin
    def get_simulated_margin(self, instType	='',inclRealPos='',instId='',pos=''):
        params = {'instType': instType, 'inclRealPos': inclRealPos,'instId': instId,'pos': pos,}
        return self._request_with_params(GET, SIMULATED_MARGIN, params)

    # Get  Greeks
    def get_greeks(self, ccy=''):
        params = {'ccy': ccy,}
        return self._request_with_params(GET, GREEKS, params)

    def get_positions_history(self, instType='', instId = '', mgnMode = '', type = '', after = '', before = '', limit = '', posId = ''):
        params = {'instType': instType, 'instId':instId, 'mgnMode':mgnMode, 'type':type, 'after':after, 'before':before, 'limit':limit, 'posId':posId}
        return self._request_with_params(GET, POSITIONS_HISTORY, params)

    def position_tiers(self, instType='',uly=''):
        params = {'instType': instType, 'uly': uly}
        return self._request_with_params(GET, POSITION_TIRES, params)