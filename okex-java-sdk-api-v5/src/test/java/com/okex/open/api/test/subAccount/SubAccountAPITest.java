package com.okex.open.api.test.subAccount;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.subAccount.param.CreateSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.DelSunAccountApikey;
import com.okex.open.api.bean.subAccount.param.ReSetSubAccountApikey;
import com.okex.open.api.bean.subAccount.param.SubAccountTransfer;
import com.okex.open.api.service.account.impl.AccountAPIServiceImpl;
import com.okex.open.api.service.subAccount.SubAccountAPIService;
import com.okex.open.api.service.subAccount.impl.SubAccountAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubAccountAPITest extends SubAccountAPIBaseTest{

    private static final Logger LOG = LoggerFactory.getLogger(SubAccountAPITest.class);

    private SubAccountAPIService subAccountAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.subAccountAPIService = new SubAccountAPIServiceImpl(this.config);
    }

    /**
     * 查看子账户列表 View sub-account list
     * GET /api/v5/users/subaccount/list
     */
    @Test
    public void testGetSubAccountList(){
        JSONObject result = this.subAccountAPIService.getSubAccountList("","","","","");
        toResultString(LOG,"result",result);
    }

    /**
     * 获取子账户资产余额 Get Sub-account Balance
     * GET /api/v5/account/subaccount/balances
     */
    @Test
    public void testGetSubAccountBalances(){
        JSONObject result = this.subAccountAPIService.getSubAccountBalances("");
        toResultString(LOG, "result", result);
    }

    /**
     * 查询子账户转账记录 History of sub-account transfer
     * GET /api/v5/asset/subaccount/bills
     */
    @Test
    public void testGetSubAccountBills(){
        JSONObject result = this.subAccountAPIService.getSubAccountBills("OKB","0","",null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 子账户间资金划转 Master accounts manage the transfers between sub-accounts
     * POST /api/v5/asset/subaccount/transfer
     */
    @Test
    public void testSubAccountTransfer(){
        SubAccountTransfer subAccountTransfer = new SubAccountTransfer();
        subAccountTransfer.setCcy("OKB");
        subAccountTransfer.setAmt("1");
        subAccountTransfer.setForm("6");
        subAccountTransfer.setTo("6");
        subAccountTransfer.setFromSubAccount("");
        subAccountTransfer.setToSubAccount("");
        subAccountTransfer.setLoanTrans(false);

        JSONObject result = this.subAccountAPIService.subAccountTransfer(subAccountTransfer);
        toResultString(LOG,"result",result);
    }

    /**
     * 查看被托管的子账户列表 Entrust Subaccount List
     * GET /api/v5/users/entrust-subaccount-list
     */
    @Test
    public void testGetEntrustSubList(){
        JSONObject result = this.subAccountAPIService.getEntrustSubList(null);
        toResultString(LOG, "result", result);
    }



}
