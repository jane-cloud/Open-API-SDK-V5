from .client import Client
from .consts import *


class AccountAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Positions
    async def get_position_risk(self, instType=''):
        params = {}
        if instType:
            params['instType'] = instType
        return await self._request_with_params(GET, POSITION_RISK, params)

    # Get Balance
    async def get_account(self, ccy=''):
        params = {}
        if ccy:
            params['ccy'] = ccy
        return await self._request_with_params(GET, ACCOUNT_INFO, params)

    # Get Positions
    async def get_positions(self, instType='', instId=''):
        params = {'instType': instType, 'instId': instId}
        return await self._request_with_params(GET, POSITION_INFO, params)

    # Get Bills Details (recent 7 days)
    async def get_bills_detail(self, instType='', ccy='', mgnMode='', ctType='', type='', subType='', after='',
                               before='',
                               limit=''):
        params = {'instType': instType, 'ccy': ccy, 'mgnMode': mgnMode, 'ctType': ctType, 'type': type,
                  'subType': subType, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, BILLS_DETAIL, params)

    # Get Bills Details (recent 3 months)
    async def get_bills_details(self, instType='', ccy='', mgnMode='', ctType='', type='', subType='', after='',
                                before='',
                                limit=''):
        params = {'instType': instType, 'ccy': ccy, 'mgnMode': mgnMode, 'ctType': ctType, 'type': type,
                  'subType': subType, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, BILLS_ARCHIVE, params)

    # Get Account Configuration
    async def get_account_config(self):
        return await self._request_without_params(GET, ACCOUNT_CONFIG)

    # Get Account Configuration
    async def get_position_mode(self, posMode):
        params = {'posMode': posMode}
        return await self._request_with_params(POST, POSITION_MODE, params)

    # Get Account Configuration
    async def set_leverage(self, lever, mgnMode, instId='', ccy='', posSide=''):
        params = {'lever': lever, 'mgnMode': mgnMode, 'instId': instId, 'ccy': ccy, 'posSide': posSide}
        return await self._request_with_params(POST, SET_LEVERAGE, params)

    # Get Maximum Tradable Size For Instrument
    async def get_maximum_trade_size(self, instId, tdMode, ccy='', px=''):
        params = {'instId': instId, 'tdMode': tdMode, 'ccy': ccy, 'px': px}
        return await self._request_with_params(GET, MAX_TRADE_SIZE, params)

    # Get Maximum Available Tradable Amount
    async def get_max_avail_size(self, instId, tdMode, ccy='', reduceOnly=''):
        params = {'instId': instId, 'tdMode': tdMode, 'ccy': ccy, 'reduceOnly': reduceOnly}
        return await self._request_with_params(GET, MAX_AVAIL_SIZE, params)

    # Increase / Decrease margin
    async def Adjustment_margin(self, instId, posSide, type, amt, loanTrans=''):
        params = {'instId': instId, 'posSide': posSide, 'type': type, 'amt': amt, 'loanTrans': loanTrans}
        return await self._request_with_params(POST, ADJUSTMENT_MARGIN, params)

    # Get Leverage
    async def get_leverage(self, instId, mgnMode):
        params = {'instId': instId, 'mgnMode': mgnMode}
        return await self._request_with_params(GET, GET_LEVERAGE, params)

    # Get the maximum loan of isolated MARGIN
    async def get_max_load(self, instId, mgnMode, mgnCcy):
        params = {'instId': instId, 'mgnMode': mgnMode, 'mgnCcy': mgnCcy}
        return await self._request_with_params(GET, MAX_LOAN, params)

    # Get Fee Rates
    async def get_fee_rates(self, instType, instId='', uly='', category=''):
        params = {'instType': instType, 'instId': instId, 'uly': uly, 'category': category}
        return await self._request_with_params(GET, FEE_RATES, params)

    # Get interest-accrued
    async def get_interest_accrued(self, instId='', ccy='', mgnMode='', after='', before='', limit=''):
        params = {'instId': instId, 'ccy': ccy, 'mgnMode': mgnMode, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, INTEREST_ACCRUED, params)

    # Get interest-accrued
    async def get_interest_rate(self, ccy=''):
        params = {'ccy': ccy}
        return await self._request_with_params(GET, INTEREST_RATE, params)

    # Set Greeks (PA/BS)
    async def set_greeks(self, greeksType):
        params = {'greeksType': greeksType}
        return await self._request_with_params(POST, SET_GREEKS, params)

    # Set Isolated Mode
    async def set_isolated_mode(self, isoMode, type):
        params = {'isoMode': isoMode, 'type': type}
        return await self._request_with_params(POST, ISOLATED_MODE, params)

    # Get Maximum Withdrawals
    async def get_max_withdrawal(self, ccy=''):
        params = {'ccy': ccy}
        return await self._request_with_params(GET, MAX_WITHDRAWAL, params)

    # Get borrow repay
    async def borrow_repay(self, ccy='', side='', amt=''):
        params = {'ccy': ccy, 'side': side, 'amt': amt}
        return await self._request_with_params(POST, BORROW_REPAY, params)

    # Get borrow repay history
    async def get_borrow_repay_history(self, ccy='', after='', before='', limit=''):
        params = {'ccy': ccy, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, BORROW_REPAY_HISTORY, params)

    # Get Obtain borrowing rate and limit
    async def get_interest_limits(self, type='', ccy=''):
        params = {'type': type, 'ccy': ccy}
        return await self._request_with_params(GET, INTEREST_LIMITS, params)

    # Get Simulated Margin
    async def get_simulated_margin(self, instType='', inclRealPos='', instId='', pos=''):
        params = {'instType': instType, 'inclRealPos': inclRealPos, 'instId': instId, 'pos': pos, }
        return await self._request_with_params(GET, SIMULATED_MARGIN, params)
