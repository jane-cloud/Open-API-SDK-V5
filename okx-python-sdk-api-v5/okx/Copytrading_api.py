from .client import Client
from .consts import *


class CopytradingAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # GET /api/v5/copytrading/current-subpositions
    def current_subpositions(self, instId='',after='', before='', limit='',uniqueCode='',subPosType=''):
        params = {'instId': instId, 'after': after, 'before': before, 'limit': limit,'uniqueCode': uniqueCode,'subPosType': subPosType, }
        return self._request_with_params(GET, CURRENT_SUBPOSITIONS, params)

    # GET /api/v5/copytrading/subpositions-history
    def subpositions_history(self, instId='', after='', before='', limit='',subPosType=''):
        params = {'instId': instId, 'after': after, 'before': before, 'limit': limit,'subPosType':subPosType}
        return self._request_with_params(GET, SUBPOSITIONS_HISTORY, params)

    # POST /api/v5/copytrading/algo-order
    def copytrading_algo_order(self, subPosId='', tpTriggerPx='', slTriggerPx='', tpTriggerPxType='',
                               slTriggerPxType='', tag='',subPosType='',tpOrdPx='',slOrdPx=''):
        params = {'subPosId': subPosId, 'tpTriggerPx': tpTriggerPx,'tpOrdPx': tpOrdPx,'slOrdPx': slOrdPx,
                  'slTriggerPx': slTriggerPx, 'tpTriggerPxType': tpTriggerPxType,
                  'slTriggerPxType': slTriggerPxType,'tag':tag,'subPosType':subPosType}
        return self._request_with_params(POST, COPYTRADING_ALGO_ORDER, params)

    # POST /api/v5/copytrading/close-subposition
    def copytrading_close_subposition(self, subPosId='',tag='',subPosType='',ordType='',px=''):
        params = {'subPosId': subPosId,'tag':tag,"subPosType":subPosType,"ordType":ordType,'px':px}
        return self._request_with_params(POST, COPYTRADING_CLOSE_POS, params)

    # GET /api/v5/copytrading/instruments
    def copytrading_instruments(self):
        params = {}
        return self._request_with_params(GET, COPYTRADING_INSTRUMENTS, params)

    # POST /api/v5/copytrading/set-instruments
    def copytrading_set_instruments(self, instId=''):
        params = {'instId': instId}
        return self._request_with_params(POST, COPYTRADING_SET_INSTRUMENTS, params)

    # GET /api/v5/copytrading/profit-sharing-details
    def profit_sharing_details(self, after='', before='', limit=''):
        params = {'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, PROFIT_SHARING_DETAILS, params)

    # GET /api/v5/copytrading/total-profit-sharing
    def total_profit_sharing(self):
        params = {}
        return self._request_with_params(GET, TOTAL_PROFIT_SHARING, params)

    # GET /api/v5/copytrading/unrealized-profit-sharing-details
    def unrealized_profit_sharing_details(self):
        params = {}
        return self._request_with_params(GET, UNREALIZED_PROFIT_SHARING_DETAILS, params)

    # POST / api / v5 / copytrading / first - copy - settings
    def first_copy_settings(self,instType='',uniqueCode='',copyMgnMode='',copyInstIdType='',instId='',copyMode='',
                                             copyTotalAmt='',copyAmt='',copyRatio='',tpRatio='',slRatio='',slTotalAmt='',
                                             subPosCloseType=''):
        params = {'instType':instType,'uniqueCode':uniqueCode,'copyMgnMode':copyMgnMode,'copyInstIdType':copyInstIdType,'instId':instId,'copyMode':copyMode,
                  'copyTotalAmt':copyTotalAmt,'copyAmt':copyAmt,'copyRatio':copyRatio,'tpRatio':tpRatio,'slRatio':slRatio,
                  'slTotalAmt':slTotalAmt,'subPosCloseType':subPosCloseType,}
        return self._request_with_params(POST, FIRST_COPY_SETTINGS, params)

    # POST /api/v5/copytrading/amend-copy-settings
    def amend_copy_settings(self,instType='',uniqueCode='',copyMgnMode='',copyInstIdType='',instId='',copyMode='',
                                             copyTotalAmt='',copyAmt='',copyRatio='',tpRatio='',slRatio='',slTotalAmt='',
                                             subPosCloseType=''):
        params = {'instType':instType,'uniqueCode':uniqueCode,'copyMgnMode':copyMgnMode,'copyInstIdType':copyInstIdType,'instId':instId,'copyMode':copyMode,
                  'copyTotalAmt':copyTotalAmt,'copyAmt':copyAmt,'copyRatio':copyRatio,'tpRatio':tpRatio,'slRatio':slRatio,
                  'slTotalAmt':slTotalAmt,'subPosCloseType':subPosCloseType,}
        return self._request_with_params(POST, AMEND_COPY_SETTINGS, params)

    # POST /api/v5/copytrading/stop-copy-trading
    def stop_copy_trading(self,instType='',uniqueCode='',subPosCloseType=''):
        params = {'instType':instType,'uniqueCode':uniqueCode,'subPosCloseType':subPosCloseType,}
        return self._request_with_params(POST, STOP_COPY_SETTINGS, params)

    # GET /api/v5/copytrading/copy-trading
    def copy_settings(self,instType='',uniqueCode=''):
        params = {'instType':instType,'uniqueCode':uniqueCode,}
        return self._request_with_params(GET, COPY_SETTINGS, params)

    # GET /api/v5/copytrading/batch-leverage-info
    def batch_leverage_inf(self,mgnMode='',uniqueCode='',instId=''):
        params = {'mgnMode':mgnMode,'uniqueCode':uniqueCode,'instId':instId,}
        return self._request_with_params(GET, BATCH_LEVERAGE_INF, params)

    # POST /api/v5/copytrading/batch-set-leverage
    def batch_set_leverage(self,mgnMode='',lever='',instId=''):
        params = {'mgnMode':mgnMode,'lever':lever,'instId':instId,}
        return self._request_with_params(POST, BATCH_SET_LEVERAGE, params)

    # GET  /api/v5/copytrading/current-lead-traders
    def current_lead_traders(self,instType='',):
        params = {'instType':instType,}
        return self._request_with_params(GET, CURRENT_LEAD_TRADERS, params)

    # GET  /api/v5/copytrading/lead-traders-history
    def lead_traders_history(self, instType='',after='',before='',limit='', ):
        params = {'instType': instType,'after': after,'before': before,'limit': limit, }
        return self._request_with_params(GET, LEAD_TRADERS_HISTORY, params)

    # GET /api/v5/copytrading/public-lead-traders
    def public_lead_traders(instType='',sortType='',state='',minLeadDays='',minAssets='',maxAssets='',
                                             minAum='',maxAum='',dataVer='',page='',limit=''):
        params = {'instType': sortType, 'sortType': sortType, 'state': state, 'minLeadDays': minLeadDays,
                  'minAssets': minAssets, 'maxAssets': maxAssets, 'minAum': minAum, 'maxAum': maxAum,
                  'dataVer': dataVer, 'page': page, 'limit': limit,
                  }
        return self._request_with_params(GET, PUBLIC_LEAD_TRADERS, params)

    # GET /api/v5/copytrading/public-weekly-pnl
    def public_weekly_pnl(self, instType='', uniqueCode=''):
        params = {'instType': instType, 'uniqueCode': uniqueCode, }
        return self._request_with_params(GET, PUBLIC_WEEKLY_PNL, params)

    # GET /api/v5/copytrading/public-pnl
    def public_pnl(self, instType='', uniqueCode='',lastDays=''):
        params = {'instType': instType, 'uniqueCode': uniqueCode, 'lastDays': lastDays}
        return self._request_with_params(GET, PUBLIC_PNL, params)

    # GET /api/v5/copytrading/public-stats
    def public_stats(self, instType='', uniqueCode='', lastDays=''):
        params = {'instType': instType, 'uniqueCode': uniqueCode, 'lastDays': lastDays}
        return self._request_with_params(GET, PUBLIC_STATS, params)

    # GET /api/v5/copytrading/public-preference-currency
    def public_preference_currency(self, instType='', uniqueCode=''):
        params = {'instType': instType, 'uniqueCode': uniqueCode, }
        return self._request_with_params(GET, PUBLIC_PRE_CURR, params)


    # GET /api/v5/copytrading/public-current-subpositions
    def public_current_subpositions(self, after='', before='', limit='', instType='', uniqueCode=''):
        params = {'instType': instType,'after': after,'before': before,'limit': limit, 'uniqueCode':uniqueCode}
        return self._request_with_params(GET, PUBLIC_CURR_SUBPOS, params)

    # GET /api/v5/copytrading/public-subpositions-history
    def public_subpositions_history(self, after='', before='', limit='', instType='', uniqueCode=''):
        params = {'instType': instType, 'after': after, 'before': before, 'limit': limit, 'uniqueCode': uniqueCode}
        return self._request_with_params(GET, PUBLIC_SUBPOS_HIS, params)

    def apply_lead_trading(self, instType='',instId='', ):
        params = {'instType': instType, 'instId': instId,}
        return self._request_with_params(POST, APP_LEA_TRAD, params)

    def stop_lead_trading(self, instType='',):
        params = {'instType': instType,}
        return self._request_with_params(POST, STOP_LEA_TRAD, params)


    def amend_profit_sharing_ratio(self, instType='',profitSharingRatio=''):
        params = {'instType': instType,'profitSharingRatio': profitSharingRatio}
        return self._request_with_params(POST, AMEDN_PRO_SHAR_RATIO, params)


    def lead_traders(self, instType='',sortType='',state='',minLeadDays='',minAssets='',maxAssets='',
                     minAum='',maxAum='',dataVer='',page='',limit='',):
        params = {'instType': instType,'sortType': sortType,'state': state,'minLeadDays': minLeadDays,
                  'minAssets': minAssets,'maxAssets': maxAssets,'minAum': minAum,'maxAum': maxAum,
                  'dataVer': dataVer,'page': page,'limit': limit,}
        return self._request_with_params(GET, LEAD_TRADERS, params)


    def weekly_pnl(self, instType='',uniqueCode=''):
        params = {'instType': instType,'uniqueCode': uniqueCode,}
        return self._request_with_params(GET, WEEKLY_PNL, params)


    def pnl(self, instType='',uniqueCode='',lastDays = ''):
        params = {'instType': instType,'uniqueCode': uniqueCode,'lastDays': lastDays,}
        return self._request_with_params(GET, PNL, params)


    def stats(self, instType='',uniqueCode='',lastDays = ''):
        params = {'instType': instType,'uniqueCode': uniqueCode,'lastDays': lastDays,}
        return self._request_with_params(GET, STATS, params)


    def preference_currency(self, instType='',uniqueCode=''):
        params = {'instType': instType,'uniqueCode': uniqueCode,}
        return self._request_with_params(GET, PRE_CURR, params)


    def performance_current_subpositions(self, instType='',uniqueCode='', after='', before='', limit='', ):
        params = {'instType': instType,'uniqueCode': uniqueCode,'after': after,'before': before,'limit': limit, }
        return self._request_with_params(GET, PRE_CURR_SUNPOSITION, params)


    def performance_subpositions_history(self, instType='',uniqueCode='', after='', before='', limit='', ):
        params = {'instType': instType,'uniqueCode': uniqueCode,'after': after,'before': before,'limit': limit, }
        return self._request_with_params(GET, PRE_SUNPOSITION_HISTORY, params)


    def copy_traders(self, instType='',uniqueCode='', limit='', ):
        params = {'instType': instType,'uniqueCode': uniqueCode,'limit': limit, }
        return self._request_with_params(GET, COPY_TRADERS, params)


    def public_copy_traders(self, instType='',uniqueCode='', limit='', ):
        params = {'instType': instType,'uniqueCode': uniqueCode,'limit': limit, }
        return self._request_with_params(GET, PUB_COPY_TRADERS, params)


    def config(self, ):
        params = {}
        return self._request_with_params(GET, CONFIG, params)


    def total_unrealized_profit_sharing(self, instType = ''):
        params = {'instType':instType}
        return self._request_with_params(GET, TOTAL_UNREA_PRO_SHAR, params)


