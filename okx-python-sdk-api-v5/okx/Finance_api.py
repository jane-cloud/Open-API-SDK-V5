from .client import Client
from .consts import *


class FinanceAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # View items
    def staking_defi_offers(self, productId = '', protocolType = '', ccy = ''):
        params = {'productId': productId, 'protocolType': protocolType, 'ccy': ccy}
        return self._request_with_params(GET, STAKING_DEFI_OFFERS, params)

    # Subscription items
    def staking_defi_purchase(self, productId = '', investData = [], term= '',tag=''):
        params = {'productId': productId, 'investData': investData, 'term': term,'tag':tag}
        return self._request_with_params(POST, STAKING_DEFI_PURCHASE, params)

    # Redemption items
    def staking_defi_redeem(self, ordId = '', protocolType = '', allowEarlyRedeem= ''):
        params = {'ordId': ordId, 'protocolType': protocolType, 'allowEarlyRedeem': allowEarlyRedeem}
        return self._request_with_params(POST, STAKING_DEFI_REDEEM, params)

    # Cancellation of project subscription / redemption
    def staking_defi_cancel(self, ordId = '', protocolType = ''):
        params = {'ordId': ordId, 'protocolType': protocolType}
        return self._request_with_params(POST, STAKING_DEFI_CANCEL, params)

    # View active orders
    def staking_defi_orders_active(self, productId = '', protocolType = '', ccy = '', state = ''):
        params = {'productId': productId, 'protocolType': protocolType, 'ccy': ccy, 'state':state}
        return self._request_with_params(GET, STAKING_DEFI_ORDERS_ACTIVE, params)

    # View active orders
    def staking_defi_orders_history(self, productId = '', protocolType = '', ccy = '', after = '', before = '', limit = ''):
        params = {'productId': productId, 'protocolType': protocolType, 'ccy': ccy, 'after':after, 'before':before, 'limit':limit}
        return self._request_with_params(GET, STAKING_DEFI_ORDERS_HISTORY, params)


    def staking_defi_eth_purcase(self, amt = ''):
        params = {}
        return self._request_with_params(POST, STAKING_DEFI_ETH_PURCASE, params)


    def staking_defi_eth_redeem(self, amt = ''):
        params = {}
        return self._request_with_params(POST, STAKING_DEFI_ETH_REDEEM, params)


    def staking_defi_eth_balance(self, ):
        params = {}
        return self._request_with_params(GET, STAKING_DEFI_ETH_BALANCE, params)


    def staking_defi_eth_p_r_history(self,type='',status='',after='',before='',limit='', ):
        params = {'type': type,'status': status,'after': after,'before': before,'limit': limit,}
        return self._request_with_params(GET, STAKING_DEFI_ETH_P_R_HISTORY, params)

    def staking_defi_eth_apy_history(self,days='',):
        params = {'days': days,}
        return self._request_with_params(GET, STAKING_DEFI_ETH_APY_HISTORY, params)

    def staking_defi_eth_product_info(self):
        params = {}
        return self._request_with_params(GET, STAKING_DEFI_ETH_PRODUCT_INFO, params)

    # POST /api/v5/finance/staking-defi/sol/purchase
    def staking_defi_sol_purcase(self, amt = ''):
        params = {}
        return self._request_with_params(POST, STAKING_DEFI_SOL_PURCASE, params)

    # POST /api/v5/finance/staking-defi/sol/redeem
    def staking_defi_sol_redeem(self, amt = ''):
        params = {}
        return self._request_with_params(POST, STAKING_DEFI_SOL_REDEEM, params)

    # GET /api/v5/finance/staking-defi/sol/balance
    def staking_defi_sol_balance(self, ):
        params = {}
        return self._request_with_params(GET, STAKING_DEFI_SOL_BALANCE, params) 

    # GET /api/v5/finance/staking-defi/sol/purchase-redeem-history
    def staking_defi_sol_p_r_history(self,type='',status='',after='',before='',limit='', ):
        params = {'type': type,'status': status,'after': after,'before': before,'limit': limit,}
        return self._request_with_params(GET, STAKING_DEFI_SOL_P_R_HISTORY, params)

    # GET /api/v5/finance/staking-defi/sol/apy-history
    def staking_defi_sol_apy_history(self,days='',):
        params = {'days': days,}
        return self._request_with_params(GET, STAKING_DEFI_SOL_APY_HISTORY, params)

    # GET /api/v5/finance/staking-defi/sol/product-info
    def staking_defi_sol_product_info(self):
        params = {}
        return self._request_with_params(GET,STAKING_DEFI_SOL_PRODUCT_INFO,params)



    def savings_lending_rate_summary(self,ccy='',):
        params = {'ccy': ccy,}
        return self._request_with_params(GET, SAVINGS_LENDING_RATE_SUM, params)


    def savings_lending_rate_his(self,ccy='',after='',before='',limit='',):
        params = {'ccy': ccy,'after': after,'before': before,'limit': limit,}
        return self._request_with_params(GET, SAVINGS_LENDING_RATE_HIS, params)


    def fixed_loan_lending_offers(self, ccy='', term='',  ):
        params = {'ccy': ccy, 'term': term, }
        return self._request_with_params(GET, FIXED_LOAN_LENDING_OFFERS, params)


    def fixed_loan_lending_apy_history(self, ccy='', term='',  ):
        params = {'ccy': ccy, 'term': term, }
        return self._request_with_params(GET, FIXED_LOAN_LENDING_APY_HIS, params)


    def fixed_loan_pending_lending_vol(self, ccy='', term='',  ):
        params = {'ccy': ccy, 'term': term, }
        return self._request_with_params(GET, FIXED_LOAN_PENDING_LENDING_VOL, params)

    # POST /api/v5/finance/fixed-loan/lending-order
    def fixed_loan_lending_order(self, ccy = '', amt = '', rate = '', term = '', autoRenewal = ''):
        params = {'ccy':ccy,'amt':amt,'rate':rate,'term':term,'autoRenewal':autoRenewal}
        return self._request_with_params(POST, FIXED_LOAN_LENDING_ORDER, params)

    # POST /api/v5/finance/fixed-loan/amend-lending-order
    def fixed_loan_amend_lending_order(self, ordId = '', changeAmt = '', rate = '', autoRenewal = ''):
        params = {'ordId':ordId,'changeAmt':changeAmt,'rate':rate,'autoRenewal':autoRenewal}
        return self._request_with_params(POST, FIXED_LOAN_AMEND_LENDING_ORDER, params)

    # GET /api/v5/finance/fixed-loan/lending-orders-list
    def fixed_loan_lending_orders_list(self, ordId='', ccy='', state='', after='', before='', limit=''):
        params = {'ordId': ordId, 'ccy': ccy, 'state':state, 'after':after, 'before':before, 'limit':limit}
        return self._request_with_params(GET, FIXED_LOAN_LENDING_ORDERS_LIST, params)

    # GET /api/v5/finance/fixed-loan/lending-sub-orders
    def fixed_loan_lending_sub_orders(self, ordId='', state='', after='', before='', limit=''):
        params = {'ordId': ordId, 'state':state, 'after':after, 'before':before, 'limit':limit}
        return self._request_with_params(GET, FIXED_LOAN_LENDING_SUB_ORDERS, params)

    # GET /api/v5/finance/flexible-loan/borrow-currencies
    def flexible_loan_borrow_currencies(self):
        params = {}
        return self._request_with_params(GET, FLEXIBLE_LOAN_BORROW_CURRENCIES, params)

    # GET /api/v5/finance/flexible-loan/collateral-assets
    def flexible_loan_collateral_assets(self, ccy = ''):
        params = {'ccy':ccy}
        return self._request_with_params(GET, FLEXIBLE_LOAN_COLLATERAL_ASSETS, params)

    # POST /api/v5/finance/flexible-loan/max-loan
    def flexible_loan_max_loan(self, borrowCcy = '', supCollateral = []):
        params = {'borrowCcy':borrowCcy,'supCollateral':supCollateral}
        return self._request_with_params(POST, FLEXIBLE_LOAN_MAX_LOAN, params)

    # GET /api/v5/finance/flexible-loan/max-collateral-redeem-amount
    def flexible_loan_max_c_r_a(self, borrowCcy = ''):
        params = {'borrowCcy':borrowCcy}
        return self._request_with_params(GET, FLEXIBLE_LOAN_MAX_C_R_A, params)

    # POST /api/v5/finance/flexible-loan/adjust-collateral
    def flexible_loan_adj_coll(self, type = '', collateralCcy = '', collateralAmt = ''):
        params = {'type':type,'collateralCcy':collateralCcy,'collateralAmt':collateralAmt}
        return self._request_with_params(POST, FLEXIBLE_LOAN_ADJ_COLL, params)

    # GET /api/v5/finance/flexible-loan/loan-info
    def flexible_loan_loan_info(self):
        params = {}
        return self._request_with_params(GET, FLEXIBLE_LOAN_LOAN_INFO, params)

    # GET /api/v5/finance/flexible-loan/loan-history
    def flexible_loan_loan_history(self, type = '', after = '', before = '', limit = ''):
        params = {'type':type, 'after':after,'before':before,'limit':limit}
        return self._request_with_params(GET, FLEXIBLE_LOAN_LOAN_HISTORY, params)

    # GET /api/v5/finance/flexible-loan/interest-accrued
    def flexible_loan_interest_accrued(self, ccy = '', after = '', before = '', limit = ''):
        params = {'ccy':ccy, 'after':after,'before':before,'limit':limit}
        return self._request_with_params(GET, FLEXIBLE_LOAN_INT_ACC, params)












