from .client import Client
from .consts import *


class RfqAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    def counterparties(self):
        params = {}
        return self._request_with_params(GET, COUNTERPARTIES, params)

    def create_rfq(self, counterparties='', anonymous='', clRfqId='', allowPartialExecution = '', tag='', legs = []):
        params = {'counterparties': counterparties, 'anonymous': anonymous, 'clRfqId': clRfqId, 'tag':tag, 'legs': legs}
        return self._request_with_params(POST, CREATE_RFQ, params)

    def cancel_rfq(self, rfqId = '', clRfqId = ''):
        params = {'rfqId': rfqId, 'clRfqId': clRfqId}
        return self._request_with_params(POST, CANCEL_RFQ, params)

    def cancel_batch_rfqs(self, rfqIds='', clRfqIds=''):
        params = {'rfqIds': rfqIds, 'clRfqIds': clRfqIds}
        return self._request_with_params(POST, CANCEL_BATCH_RFQS, params)

    def cancel_all_rfqs(self):
        params = {}
        return self._request_with_params(POST, CANCEL_ALL_RSQS, params)

    def execute_quote(self, rfqId='', quoteId=''):
        params = {'rfqId': rfqId, 'quoteId': quoteId}
        return self._request_with_params(POST, EXECUTE_QUOTE, params)

    def create_quote(self, rfqId='', clQuoteId='', tag = '', quoteSide = '', legs = [], expiresIn = '',anonymous = ''):
        params = {'rfqId': rfqId, 'clQuoteId': clQuoteId, 'tag':tag, 'quoteSide': quoteSide, 'legs': legs, 'expiresIn':expiresIn, 'anonymous':anonymous}
        return self._request_with_params(POST, CREATE_QUOTE, params)

    def cancel_quote(self, quoteId  = '', clQuoteId = '', rfqId = ''):
        params = {'quoteId': quoteId, 'clQuoteId': clQuoteId, 'rfqId':rfqId}
        return self._request_with_params(POST, CANCEL_QUOTE, params)

    def cancel_batch_quotes(self, quoteIds='', clQuoteIds=''):
        params = {'quoteIds': quoteIds, 'clQuoteIds': clQuoteIds}
        return self._request_with_params(POST, CANCEL_BATCH_QUOTES, params)

    def cancel_all_quotes(self):
        params = {}
        return self._request_with_params(POST, CANCEL_ALL_QUOTES, params)

    def get_rfqs(self, rfqId = '', clRfqId = '',  state = '', beginId = '', endId = '', limit = ''):
        params = {'rfqId': rfqId, 'clRfqId': clRfqId, 'state': state, 'beginId': beginId, 'endId': endId, 'limit':limit}
        return self._request_with_params(GET, GET_RFQS, params)

    def get_quotes(self, rfqId = '', clRfqId = '', quoteId = '', clQuoteId = '', state = '', beginId = '', endId = '', limit = ''):
        params = {'rfqId': rfqId, 'clRfqId': clRfqId, 'quoteId':quoteId,'clQuoteId':clQuoteId, 'state': state, 'beginId': beginId, 'endId': endId, 'limit':limit}
        return self._request_with_params(GET, GET_QUOTES, params)

    def get_rfq_trades(self, rfqId = '', clRfqId = '', quoteId = '', blockTdId = '', clQuoteId = '', state = '', beginId = '', endId = '', limit = '', beginTs ='', endTs = ''):
        params = {'rfqId': rfqId, 'clRfqId': clRfqId, 'quoteId':quoteId,'clQuoteId':clQuoteId, 'state': state, 'beginId': beginId, 'endId': endId, 'limit':limit,'blockTdId':blockTdId,'beginTs':beginTs,'endTs':endTs}
        return self._request_with_params(GET, GET_RFQ_TRADES, params)

    def get_public_trades(self, beginId = '', endId = '', limit = ''):
        params = {'beginId': beginId, 'endId': endId, 'limit': limit}
        return self._request_with_params(GET, GET_PUBLIC_TRADES, params)


    def rfq_cancel_all_after(self, timeOut = ''):
        params = {'timeOut': timeOut}
        return self._request_with_params(POST, RFQ_CANCEL_ALL_AFTER, params)

    def maker_instrument_settings(self, instType='', data=[]):
        params = [{'instType': instType, 'data': data}]
        return self._request_with_params(POST, MARKET_INSTRUMENT_SETTINGS, params)

    def mmp_reset(self):
        params = {}
        return self._request_with_params(POST, MMP_RESET, params)

    # POST /api/v5/rfq/mmp-config
    def mmp_config(self,timeInterval='',frozenInterval='',countLimit=''):
        params = {'timeInterval':timeInterval,'frozenInterval':frozenInterval,'countLimit':countLimit,}
        return self._request_with_params(POST, MMP_CONFIG, params)

    # GET /api/v5/rfq/maker-instrument-settings
    def get_maker_instrument_settings(self):
        params = {}
        return self._request_with_params(GET, GET_MAKER_INSTRUMENT_SETTINGS, params)


    # GET /api/v5/rfq/maker-instrument-settings
    def mmp_configs(self,timeInterval='', frozenInterval='', countLimit='',mmpFrozen='',mmpFrozenUntil='',):
        params = {'timeInterval':timeInterval,'frozenInterval':frozenInterval,'countLimit':countLimit,
                  'mmpFrozen':mmpFrozen,'mmpFrozenUntil':mmpFrozenUntil,}
        return self._request_with_params(GET, MMP_CONF, params)