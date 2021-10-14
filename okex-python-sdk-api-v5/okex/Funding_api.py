from .client import Client
from .consts import *


class FundingAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Deposit Address
    def get_deposit_address(self, ccy):
        params = {'ccy': ccy}
        return self._request_with_params(GET, DEPOSIT_ADDRESS, params)

    # Get Balance
    def get_balances(self, ccy=''):
        params = {'ccy': ccy}
        return self._request_with_params(GET, GET_BALANCES, params)

    # Get Account Configuration
    def funds_transfer(self, ccy, amt, froms, to, type='0', subAcct='', instId='', toInstId=''):
        params = {'ccy': ccy, 'amt': amt, 'from': froms, 'to': to, 'type': type, 'subAcct': subAcct, 'instId': instId,
                  'toInstId': toInstId}
        return self._request_with_params(POST, FUNDS_TRANSFER, params)

    # Withdrawal
    def coin_withdraw(self, ccy, amt, dest, toAddr, pwd, fee,chain=''):
        params = {'ccy': ccy, 'amt': amt, 'dest': dest, 'toAddr': toAddr, 'pwd': pwd, 'fee': fee,'chain': chain}
        return self._request_with_params(POST, WITHDRAWAL_COIN, params)

    # Get Deposit History
    def get_deposit_history(self, ccy='', state='', after='', before='', limit='',txId=''):
        params = {'ccy': ccy, 'state': state, 'after': after, 'before': before, 'limit': limit,'txId':txId}
        return self._request_with_params(GET, DEPOSIT_HISTORIY, params)

    # Get Withdrawal History
    def get_withdrawal_history(self, ccy='', state='', after='', before='', limit='',txId=''):
        params = {'ccy': ccy, 'state': state, 'after': after, 'before': before, 'limit': limit,'txId':txId}
        return self._request_with_params(GET, WITHDRAWAL_HISTORIY, params)

    # Get Currencies
    def get_currency(self):
        return self._request_without_params(GET, CURRENCY_INFO)

    # PiggyBank Purchase/Redemption
    def purchase_redempt(self, ccy, amt, side):
        params = {'ccy': ccy, 'amt': amt, 'side': side}
        return self._request_with_params(POST, PURCHASE_REDEMPT, params)

    # Get Withdrawal History
    def get_bills(self, ccy='', type='', after='', before='', limit=''):
        params = {'ccy': ccy, 'type': type, 'after': after, 'before': before, 'limit': limit}
        return self._request_with_params(GET, BILLS_INFO, params)


    #Get Piggy Balance
    def get_piggy_balance(self, ccy=''):
        params = {}
        if ccy:
            params = {'ccy':ccy}
        return self._request_with_params(GET, PIGGY_BALANCE, params)


    #Get Deposit Lightning
    def get_deposit_lightning(self, ccy,amt,to=""):
        params = {'ccy':ccy,'amt':amt}
        if to:
            params = {'to':to}
        return self._request_with_params(GET, DEPOSIT_LIGHTNING, params)

    # Withdrawal Lightning
    def withdrawal_lightning(self, ccy,invoice,pwd):
        params = {'ccy':ccy, 'invoice':invoice, 'pwd':pwd}
        return self._request_with_params(POST, WITHDRAWAL_LIGHTNING, params)
