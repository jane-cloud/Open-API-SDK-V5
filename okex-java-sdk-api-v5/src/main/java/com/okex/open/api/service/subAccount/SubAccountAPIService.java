package com.okex.open.api.service.subAccount;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.subAccount.param.CreateSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.DelSunAccountApikey;
import com.okex.open.api.bean.subAccount.param.ReSetSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.SubAccountTransfer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SubAccountAPIService {

    //母账户查询子账户的交易账户详细资产余额（适用于母账户） Query detailed balance info of Trading Account of a sub-account via the master account (applies to master accounts only)
    JSONObject getSubAccountBalances(String subAcct);

    //子账户转账记录（仅适用于母账户） View sub-account list(applies to master accounts only)
    JSONObject getSubAccountBills(String ccy, String type, String subAcct, String after, String before, String limit);

    //删除子账户的APIkey（仅适用于母账户） Delete the APIkey of sub-accounts (applies to master accounts only)
    JSONObject delSubAccountAPIKey(DelSunAccountApikey delSunAccountApikey);

    //重置子账户的APIkey（仅适用于母账户） Reset the APIkey of a sub-account(applies to master accounts only)
    JSONObject reSetSubAccountAPIKey(ReSetSubAccountApikey reSetSubAccountApikey);

    //创建子账户的APIkey（仅适用于母账户）Create an APIkey for a sub-account(applies to master accounts only)
    JSONObject createSubAccountAPIKey(CreateSubAccountApikey createSubAccountApikey);

    //查看子账户列表（仅适用于母账户） View sub-account list(applies to master accounts only)
    JSONObject getSubAccountList(String enable, String subAcct, String after, String before, String limit);

    //母账户控制子账户与子账户之间划转（仅适用于母账户） Master accounts manage the transfers between sub-accounts(applies to master accounts only)
    JSONObject subAccountTransfer(SubAccountTransfer subAccountTransfer);


}
