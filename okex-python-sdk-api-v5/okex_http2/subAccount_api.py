from .client import Client
from .consts import *


class SubAccountAPI(Client):
    def __init__(self, api_key, api_secret_key, passphrase, use_server_time=False, flag='1'):
        Client.__init__(self, api_key, api_secret_key, passphrase, use_server_time, flag)

    async def balances(self, subAcct):
        params = {"subAcct": subAcct}
        return await self._request_with_params(GET, BALANCE, params)

    async def bills(self, ccy='', type='', subAcct='', after='', before='', limit=''):
        params = {"ccy": ccy, 'type': type, 'subAcct': subAcct, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, BILLs, params)

    async def delete(self, pwd, subAcct, apiKey):
        params = {'pwd': pwd, 'subAcct': subAcct, 'apiKey': apiKey}
        return await self._request_with_params(POST, DELETE, params)

    async def reset(self, pwd, subAcct, label, apiKey, perm, ip=''):
        params = {'pwd': pwd, 'subAcct': subAcct, 'label': label, 'apiKey': apiKey, 'perm': perm, 'ip': ip}
        return await self._request_with_params(POST, RESET, params)

    async def create(self, pwd, subAcct, label, Passphrase, perm='', ip=''):
        params = {'pwd': pwd, 'subAcct': subAcct, 'label': label, 'Passphrase': Passphrase, 'perm': perm, 'ip': ip}
        return await self._request_with_params(POST, CREATE, params)

    async def watch(self, subAcct, apiKey=''):
        params = {'subAcct': subAcct, 'apiKey': apiKey}
        return await self._request_with_params(GET, WATCH, params)

    async def view_list(self, enable='', subAcct='', after='', before='', limit=''):
        params = {'enable': enable, 'subAcct': subAcct, 'after': after, 'before': before, 'limit': limit}
        return await self._request_with_params(GET, VIEW_LIST, params)

    async def control_transfer(self, ccy, amt, froms, to, fromSubAccount, toSubAccount):
        params = {'ccy': ccy, 'amt': amt, 'from': froms, 'to': to, 'fromSubAccount': fromSubAccount,
                  'toSubAccount': toSubAccount}
        return await self._request_with_params(POST, CONTROL_TRANSFER, params)

    async def subAccount_transfer(self, ccy, amt, froms, to, fromSubAccount, toSubAccount, loanTrans=''):
        params = {'ccy': ccy, 'amt': amt, 'from': froms, 'to': to, 'fromSubAccount': fromSubAccount,
                  'toSubAccount': toSubAccount, 'loanTrans': loanTrans}
        return await self._request_with_params(POST, SUBACCOUNT_TRANSFER, params)
