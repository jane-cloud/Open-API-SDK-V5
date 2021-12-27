from .client import Client
from .consts import *


class FundingAPI(Client):

    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    # Get Deposit Address
    async def get_deposit_address(self, ccy):
        params = {'ccy': ccy}
        return await self._request_with_params(GET, DEPOSIT_ADDRESS, params)

    # Get Transfer State
    async def transfer_state(self, transId, type=''):
        params = {'transId': transId, 'type': type}
        return await self._request_with_params(POST, TRANSFER_STATE, params)

    # Get Balance
    async def get_balances(self, ccy=''):
        params = {'ccy': ccy}
        return await self._request_with_params(GET, GET_BALANCES, params)

    # Get Account Configuration
    async def funds_transfer(self, ccy, amt, froms, to, type='0', subAcct='', instId='', toInstId='', loanTrans=''):
        params = {'ccy': ccy, 'amt': amt, 'from': froms, 'to': to, 'type': type, 'subAcct': subAcct, 'instId': instId,
                  'toInstId': toInstId, 'loanTrans': loanTrans}
        return await self._request_with_params(POST, FUNDS_TRANSFER, params)

    # Withdrawal
    async def coin_withdraw(self, ccy, amt, dest, toAddr, pwd, fee):
        params = {'ccy': ccy, 'amt': amt, 'dest': dest, 'toAddr': toAddr, 'pwd': pwd, 'fee': fee}
        return await self._request_with_params(POST, WITHDRAWAL_COIN, params)

    # Get Deposit History
    async def get_deposit_history(self, ccy='', state='', after='', before='', limit='', txId=''):
        params = {'ccy': ccy, 'state': state, 'after': after, 'before': before, 'limit': limit, 'txId': txId}
        return await self._request_with_params(GET, DEPOSIT_HISTORIY, params)

    # Get Withdrawal History
    async def get_withdrawal_history(self, ccy='', state='', after='', before='', limit='', txId=''):
        params = {'ccy': ccy, 'state': state, 'after': after, 'before': before, 'limit': limit, 'txId': txId}
        return await self._request_with_params(GET, WITHDRAWAL_HISTORIY, params)

    # Get Currencies
    async def get_currency(self):
        return await self._request_without_params(GET, CURRENCY_INFO)

    # PiggyBank Purchase/Redemption
    async def purchase_redempt(self, ccy, amt, side):
        params = {'ccy': ccy, 'amt': amt, 'side': side}
        return await self._request_with_params(POST, PURCHASE_REDEMPT, params)

    # Get Withdrawal History
    async def get_bills(self, ccy='', type='', after='', before='', limit=''):
        params = {'ccy': ccy, 'type': type, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, BILLS_INFO, params)

    # Get Piggy Balance
    async def get_piggy_balance(self, ccy=''):
        params = {}
        if ccy:
            params = {'ccy': ccy}
        return await self._request_with_params(GET, PIGGY_BALANCE, params)

    # Get Deposit Lightning
    async def get_deposit_lightning(self, ccy, amt, to=""):
        params = {'ccy': ccy, 'amt': amt}
        if to:
            params = {'to': to}
        return await self._request_with_params(GET, DEPOSIT_LIGHTNING, params)

    # Withdrawal Lightning
    async def withdrawal_lightning(self, ccy, invoice, pwd):
        params = {'ccy': ccy, 'invoice': invoice, 'pwd': pwd}
        return await self._request_with_params(POST, WITHDRAWAL_LIGHTNING, params)

    # POST SET LENDING RATE
    async def set_lending_rate(self, ccy, rate):
        params = {'ccy': ccy, 'rate': rate}
        return await self._request_with_params(POST, SET_LENDING_RATE, params)

    # GET LENDING HISTORY
    async def get_lending_rate(self, ccy='', before='', after='', limit='', ):
        params = {'ccy': ccy, 'after': after, 'before': before, 'limit': limit, }
        return await self._request_with_params(GET, LENDING_HISTORY, params)

    # GET LENDING RATE HISTORY
    async def get_lending_rate_history(self, ccy='', ):
        params = {'ccy': ccy, }
        return await self._request_with_params(GET, LENDING_RATE_HISTORY, params)

    # GET LENDING RATE SUMMARY
    async def get_lending_rate_summary(self, ccy='', before='', after='', limit='', ):
        params = {'ccy': ccy, 'after': after, 'before': before, 'limit': limit, }
        return await self._request_with_params(GET, LENDING_RATE_SUMMARY, params)
