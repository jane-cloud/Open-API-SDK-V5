package com.okex.open.api.test.broker;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.broker.param.*;
import com.okex.open.api.service.broker.BrokerAPIService;
import com.okex.open.api.service.broker.impl.BrokerAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokerAPITests extends BrokerAPIBaseTests{

    private static final Logger LOG = LoggerFactory.getLogger(BrokerAPITests.class);

    private BrokerAPIService brokerAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.brokerAPIService = new BrokerAPIServiceImpl(this.config);
    }

    /**
     * Broker账户信息  Get broker account information
     * GET /api/v5/broker/nd/info
     */
    @Test
    public void getBalance(){
        JSONObject result = this.brokerAPIService.getInfo();
        toResultString(LOG, "result", result);
    }

    /**
     * 创建子账户  Create sub-account
     * POST /api/v5/broker/nd/create-subaccount
     */
    @Test
    public void createSubAccount(){
        CreateSubAccount createSubAccount = new CreateSubAccount();
        createSubAccount.setPwd("");
        createSubAccount.setSubAcct("");
        createSubAccount.setLabel("test");
        createSubAccount.setAcctLv("1");
        JSONObject result = this.brokerAPIService.createSubAccount(createSubAccount);
        toResultString(LOG, "result", result);
    }

    /**
     * 删除子账户  Delete sub-account
     * POST /api/v5/broker/nd/delete-subaccount
     */
    @Test
    public void deleteSubAccount(){
        DeleteSubAccount deleteSubAccount = new DeleteSubAccount();
        deleteSubAccount.setPwd("");
        deleteSubAccount.setSubAcct("");
        JSONObject result = this.brokerAPIService.deleteSubAccount(deleteSubAccount);
        toResultString(LOG, "result", result);
    }

    /**
     * 查询子账户列表   Get sub-account list
     * GET /api/v5/broker/nd/subaccount-info
     */
    @Test
    public void getSubAccountInfo(){
        JSONObject result = this.brokerAPIService.getSubAccountInfo("","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 设置子账户的账户等级  Set the account level of the sub-account
     * POST /api/v5/broker/nd/set-subaccount-level
     */
    @Test
    public void setSubAccountLevel(){
        SetSubAccountLevel setSubAccountLevel = new SetSubAccountLevel();
        setSubAccountLevel.setSubAcct("");
        setSubAccountLevel.setAcctLv("1");
        JSONObject result = this.brokerAPIService.setSubAccountLevel(setSubAccountLevel);
        toResultString(LOG, "result", result);
    }

    /**
     * 设置子账户的交易手续费费率  Set trading fee rate for sub-account
     * POST /api/v5/broker/nd/set-subaccount-fee-rate
     */
    @Test
    public void setSubAccountFeeRate(){
        SetSubAccountFeeRate setSubAccountFeeRate = new SetSubAccountFeeRate();
        setSubAccountFeeRate.setSubAcct("");
        setSubAccountFeeRate.setInstType("SWAP");
        setSubAccountFeeRate.setChgType("percentage");
        setSubAccountFeeRate.setChgTaker("1%");
        setSubAccountFeeRate.setChgMaker("1%");
        setSubAccountFeeRate.setEffDate("20211226");
        JSONObject result = this.brokerAPIService.setSubAccountFeeRate(setSubAccountFeeRate);
        toResultString(LOG, "result", result);
    }

    /**
     * 创建子账户充值地址   Create deposit address for sub-account
     * POST /api/v5/asset/broker/nd/subaccount-deposit-address
     */
    @Test
    public void subAccountDepositAddress(){
        SubAccountDepositAddress subAccountDepositAddress = new SubAccountDepositAddress();
        subAccountDepositAddress.setSubAcct("");
        subAccountDepositAddress.setCcy("BTC");
//        subAccountDepositAddress.setChain("");
//        subAccountDepositAddress.setAddrType("");
//        subAccountDepositAddress.setTo("");
        JSONObject result = this.brokerAPIService.subAccountDepositAddress(subAccountDepositAddress);
        toResultString(LOG, "result", result);
    }

    /**
     * 查看充值地址  Get sub-account deposit address
     * GET /api/v5/asset/broker/nd/subaccount-deposit-address
     */
    @Test
    public void getSubAccountDepositAddress(){
        JSONObject result = this.brokerAPIService.getSubAccountDepositAddress("","BTC");
        toResultString(LOG, "result", result);
    }

    /**
     * 查询子账户获取充值记录  Get sub-account deposit history
     * GET /api/v5/asset/broker/nd/subaccount-deposit-history
     */
    @Test
    public void getSubAccountDepositHistory(){
        JSONObject result = this.brokerAPIService.getSubAccountDepositHistory("","BTC","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 子账户返佣记录  Query daily rebate records
     * GET /api/v5/broker/nd/rebate-daily
     */
    @Test
    public void getRebateDaily(){
        JSONObject result = this.brokerAPIService.getRebateDaily(null,null,null,null,null);
        toResultString(LOG, "result", result);
    }


}
