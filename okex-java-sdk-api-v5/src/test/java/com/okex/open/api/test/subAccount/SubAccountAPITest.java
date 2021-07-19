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
     * 创建子账户的APIkey Create an APIkey for a sub-account
     * POST /api/v5/users/subaccount/apikey
     */
    @Test
    public void testCreateSubAccountApikey(){
        CreateSubAccountApikey createSubAccountApikey = new CreateSubAccountApikey();

        createSubAccountApikey.setPwd("");
        createSubAccountApikey.setSubAcct("");
        createSubAccountApikey.setLabel("create1234");
        createSubAccountApikey.setPassphrase("");
        createSubAccountApikey.setPerm("read_only");
        createSubAccountApikey.setIp(null);

        JSONObject result = this.subAccountAPIService.createSubAccountAPIKey(createSubAccountApikey);
        toResultString(LOG, "result", result);
    }

    /**
     * 重置子账户的APIkey Reset the APIkey of a sub-account
     * POST /api/v5/users/subaccount/modify-apikey
     */
    @Test
    public void testReSetSubAccountApikey(){
        ReSetSubAccountApikey reSetSubAccountApikey = new ReSetSubAccountApikey();

        reSetSubAccountApikey.setPwd("");
        reSetSubAccountApikey.setSubAcct("");
        reSetSubAccountApikey.setLabel("11111");
        reSetSubAccountApikey.setApiKey("");
        reSetSubAccountApikey.setPerm("read_only");
        reSetSubAccountApikey.setIp(null);

        JSONObject result = this.subAccountAPIService.reSetSubAccountAPIKey(reSetSubAccountApikey);
        toResultString(LOG, "result", result);

    }

    /**
     * 删除子账户的APIkey Delete the APIkey of sub-accounts
     * POST /api/v5/users/subaccount/delete-apikey
     */
    @Test
    public void testDelSubAccountApikey(){
        DelSunAccountApikey delSunAccountApikey = new DelSunAccountApikey();

        delSunAccountApikey.setPwd("");
        delSunAccountApikey.setSubAcct("");
        delSunAccountApikey.setApiKey("");
        JSONObject result = this.subAccountAPIService.delSubAccountAPIKey(delSunAccountApikey);
        toResultString(LOG, "result", result);

    }

    /**
     * 获取子账户资产余额 Get Sub-account Balance
     * GET /api/v5/account/subaccount/balances
     */
    @Test
    public void testGetSubAccountBalances(){
        JSONObject result = this.subAccountAPIService.getSubAccountBalances("ctt042501");
        toResultString(LOG, "result", result);
    }

    /**
     * 查询子账户转账记录 History of sub-account transfer
     * GET /api/v5/asset/subaccount/bills
     */
    @Test
    public void testGetSubAccountBills(){
        JSONObject result = this.subAccountAPIService.getSubAccountBills("OKB","0","ctt042501",null,null,null);
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

        JSONObject result = this.subAccountAPIService.subAccountTransfer(subAccountTransfer);
        toResultString(LOG,"result",result);
    }





}
