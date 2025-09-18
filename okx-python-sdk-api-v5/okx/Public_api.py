from .client import Client
from .consts import *


class PublicAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Instruments
    def get_instruments(self, instType = 'FUTURES', uly = 'BTC-USDT', instFamily = '', instId = ''):
        params = {'instType': instType, 'uly': uly, 'instId': instId, 'instFamily':instFamily}
        return self._request_with_params(GET, INSTRUMENT_INFO, params)

    # Get Delivery/Exercise History
    def get_deliver_history(self, instType, uly, after='', before='', limit=''):
        params = {'instType': instType, 'uly': uly, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, DELIVERY_EXERCISE, params)

    # Get Open Interest
    def get_open_interest(self, instType, uly='', instId='',instFamily=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId,'instFamily':instFamily}
        return self._request_with_params(GET, OPEN_INTEREST, params)

    # Get Funding Rate
    def get_funding_rate(self, instId):
        params = {'instId': instId}
        return self._request_with_params(GET, FUNDING_RATE, params)

    # Get Funding Rate History
    def funding_rate_history(self, instId, after='', before='', limit=''):
        params = {'instId': instId, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, FUNDING_RATE_HISTORY, params)

    # Get Limit Price
    def get_price_limit(self, instId):
        params = {'instId': instId}
        return self._request_with_params(GET, PRICE_LIMIT, params)

    # Get Option Market Data
    def get_opt_summary(self, uly, expTime=''):
        params = {'uly': uly, 'expTime': expTime}
        return self._request_with_params(GET, OPT_SUMMARY, params)

    # Get Estimated Delivery/Excercise Price
    def get_estimated_price(self, instId):
        params = {'instId': instId}
        return self._request_with_params(GET, ESTIMATED_PRICE, params)

    # Get Discount Rate And Interest-Free Quota
    def discount_interest_free_quota(self, ccy=''):
        params = {'ccy': ccy}
        return self._request_with_params(GET, DICCOUNT_INTETEST_INFO, params)

    # Get System Time
    def get_system_time(self):
        return self._request_without_params(GET, SYSTEM_TIME)

    # Get Liquidation Orders
    def get_liquidation_orders(self, instType, mgnMode='', instId='', ccy='', uly='', alias='', state='', before='',
                               after='', limit='',instFamily = ''):
        params = {'instType': instType, 'mgnMode': mgnMode, 'instId': instId, 'ccy': ccy, 'uly': uly,
                  'alias': alias, 'state': state, 'before': before, 'after': after, 'limit': limit,'instFamily':instFamily}
        return self._request_with_params(GET, LIQUIDATION_ORDERS, params)

    # Get Mark Price
    def get_mark_price(self, instType, uly='', instId='',instFamily=''):
        params = {'instType': instType, 'uly': uly, 'instId': instId,'instFamily':instFamily}
        return self._request_with_params(GET, MARK_PRICE, params)

    # Get Tier
    def get_tier(self, instType, tdMode, uly='', instId='', ccy='', tier='',instFamily=''):
        params = {'instType': instType, 'tdMode': tdMode, 'uly': uly, 'instId': instId, 'ccy': ccy, 'tier': tier,'instFamily':instFamily}
        return self._request_with_params(GET, TIER, params)

    # Get Interest Rate and Loan Quota
    def get_interest_loan(self):
        return self._request_without_params(GET, INTEREST_LOAN)

    # Get underlying

    def get_underlying(self, instType):
        params = {'instType': instType}
        return self._request_with_params(GET, UNDERLYING, params)

    # GET Obtain the privileged currency borrowing leverage rate and currency borrowing limit
    def get_vip_interest_rate_loan_quota(self):
        params = {}
        return self._request_with_params(GET, VIP_INTEREST_RATE_LOAN_QUOTA, params)

    def get_insurance_fund(self,instType = '', type = '', uly = '', ccy = '', before = '', after = '', limit = '',instFamily=''):
        params = {'instType':instType, 'type':type, 'uly':uly, 'ccy':ccy, 'before':before, 'after':after, 'limit':limit,'instFamily':instFamily}
        return self._request_with_params(GET, INSURANCE_FUND, params)

    def convert_contract_coin(self, type = '', instId = '', sz = '', px = '', unit = '', opType=''):
        params = {'type':type, 'instId':instId, 'sz':sz, 'px':px, 'unit':unit, 'opType':opType}
        return self._request_with_params(GET, CONVERT_CONTRACT_COIN, params)

    # GET /api/v5/public/instrument-tick-bands
    def instrument_tick_bands(self, instType = '', instFamily = ''):
        params = {'instType':instType, 'instFamily':instFamily}
        return self._request_with_params(GET, INSTRUMENT_TICK_BANDS, params)

    # GET /api/v5/public/option-trades
    def option_trades(self, instId = '', instFamily = '', optType = ''):
        params = {'instId':instId, 'instFamily':instFamily, 'optType':optType}
        return self._request_with_params(GET, OPTION_TRADES, params)

    # GET /api/v5/public/estimated-settlement-info
    def estimated_settlement_info(self, instId = ''):
        params = {'instId':instId}
        return self._request_with_params(GET, ESTIMATED_SETTLEMENT_INFO, params)

    # GET /api/v5/public/settlement-history
    def settlement_history(self, instFamily = '', after = '', before = '', limit= ''):
        params = {'instFamily':instFamily,'after':after,'before':before,'limit':limit}
        return self._request_with_params(GET, SETTLEMENT_HISTORY, params)

    # GET /api/v5/public/market-data-history
    def get_market_data_history(self, module = '', instType = '', instIdList = '', instFamilyList = '', dateAggrType = '', begin = '', end = ''):
        params = {'module':module,'instType':instType,'instIdList':instIdList,'instFamilyList':instFamilyList,'dateAggrType':dateAggrType,'begin':begin,'end':end}
        return self._request_with_params(GET, GET_MARKET_DATA_HISTORY, params)
