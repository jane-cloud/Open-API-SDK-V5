package com.okex.open.api.service.subAccount;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.subAccount.param.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SubAccountAPIService {

    //查看子账户列表 View sub-account list
    JSONObject getSubAccountList(String enable, String subAcct, String after, String before, String limit);

    //获取子账户资产余额 Get Sub-account Balance
    JSONObject getSubAccountBalances(String subAcct);

    //查询子账户转账记录 History of sub-account transfer
    JSONObject getSubAccountBills(String ccy, String type, String subAcct, String after, String before, String limit);

    //子账户间资金划转 Master accounts manage the transfers between sub-accounts
    JSONObject subAccountTransfer(SubAccountTransfer subAccountTransfer);

    //设置子账户主动转出权限 Set Permission Of Transfer Out
    JSONObject setTransferOut(SetTransferOut setTransferOut);

    //查看被托管的子账户列表 Entrust Subaccount List
    JSONObject getEntrustSubList(String subAcct);

    //获取子账户资金账户余额
    JSONObject getSubaccountBalances(String subAcct, String ccy);

    //重置子账户的APIKey Reset the APIKey of a sub-account
    JSONObject modifySubApikey(SetTransferOut setTransferOut);

    //获取用户的节点返佣信息 Get the user's affiliate rebate information
    JSONObject ifRebate(String apiKey);

}
