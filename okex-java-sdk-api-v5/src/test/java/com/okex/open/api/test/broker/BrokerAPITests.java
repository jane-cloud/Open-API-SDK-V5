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
     * 获取独立经纪商账户信息  Get broker account information
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

        createSubAccount.setSubAcct("0324test01");
        createSubAccount.setLabel("0324test01");
        createSubAccount.setClientIP("");
        createSubAccount.setMainAcct("");
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
        JSONObject result = this.brokerAPIService.getSubAccountInfo(null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 创建子账户的APIKey  Create an APIKey for a sub-account
     * POST /api/v5/broker/nd/subaccount/apikey
     */
    @Test
    public void createSubAccountApikey(){
        CreateSubAccountApikey createSubAccountApikey = new CreateSubAccountApikey();
        createSubAccountApikey.setSubAcct("0324test01");
        createSubAccountApikey.setLabel("0324test001");
        createSubAccountApikey.setPassphrase("");
        createSubAccountApikey.setIp("");
        createSubAccountApikey.setPerm("read_only");

        JSONObject result = this.brokerAPIService.createSubAccountApikey(createSubAccountApikey);
        toResultString(LOG, "result", result);
    }

    /**
     * 查询子账户的APIKey  Query the APIKey of a sub-account
     * GET /api/v5/broker/nd/subaccount/apikey
     */
    @Test
    public void getApikeyInfo(){
        JSONObject result = this.brokerAPIService.getApikeyInfo("0324test01","69e8e45c-6db9-44c8-b15a-38119340b376");
        toResultString(LOG, "result", result);
    }

    /**
     * 重置子账户的APIKey  Reset the APIKey of a sub-account
     * POST /api/v5/broker/nd/subaccount/modify-apikey
     */
    @Test
    public void modifySubAccountApikey(){
        ModifySubAccountApikey modifySubAccountApikey = new ModifySubAccountApikey();
        modifySubAccountApikey.setApiKey("69e8e45c-6db9-44c8-b15a-38119340b376");
        modifySubAccountApikey.setLabel("0324test001");
        modifySubAccountApikey.setSubAcct("0324test01");
        modifySubAccountApikey.setPerm("read_only,trade");
        modifySubAccountApikey.setIp(null);

        JSONObject result = this.brokerAPIService.modifySubAccountApikey(modifySubAccountApikey);
        toResultString(LOG, "result", result);
    }

    /**
     * 删除子账户的APIKey  Delete the APIKey of sub-accounts
     * POST /api/v5/broker/nd/subaccount/delete-apikey
     */
    @Test
    public void deleteSubAccountApikey(){
        DeleteSubAccountApikey deleteSubAccountApikey = new DeleteSubAccountApikey();
        deleteSubAccountApikey.setApiKey("69e8e45c-6db9-44c8-b15a-38119340b376");
        deleteSubAccountApikey.setSubAcct("0324test01");

        JSONObject result = this.brokerAPIService.deleteSubAccountApikey(deleteSubAccountApikey);
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
        setSubAccountFeeRate.setMgnType("");
        setSubAccountFeeRate.setQuoteCcyType("");
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
     * 获取子账户充值记录  Get sub-account deposit history
     * GET /api/v5/asset/broker/nd/subaccount-deposit-history
     */
    @Test
    public void getSubAccountDepositHistory(){
        JSONObject result = this.brokerAPIService.getSubAccountDepositHistory("","BTC","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 子账户返佣记录  Query daily rebate records
     * GET /api/v5/broker/nd/rebate-daily
     */
    @Test
    public void getRebateDaily(){
        JSONObject result = this.brokerAPIService.getRebateDaily(null,null,null,null,null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取返佣明细下载链接  Get download link
     * GET /api/v5/broker/nd/rebate-per-orders
     */
    @Test
    public void rebatePerOrders(){
        JSONObject result = this.brokerAPIService.rebatePerOrders("true",null,null,"");
        toResultString(LOG, "result", result);
    }

    /**
     * 生成返佣明细下载链接 Create rebate details download link
     * POST /api/v5/broker/nd/rebate-per-orders
     */
    @Test
    public void setRebatePerOrders(){
        SetRebatePerOrders setRebatePerOrders = new SetRebatePerOrders();
        setRebatePerOrders.setBegin("20220101");
        setRebatePerOrders.setEnd("20220107");
        setRebatePerOrders.setBrokerType("");

        JSONObject result = this.brokerAPIService.setRebatePerOrders(setRebatePerOrders);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取返佣明细下载链接  Get download link
     * GET /api/v5/broker/fd/rebate-per-orders
     */
    @Test
    public void rebatePerOrdersfd(){
        JSONObject result = this.brokerAPIService.rebatePerOrdersfd("false","20220201","220302");
        toResultString(LOG, "result", result);
    }

    /**
     * 生成返佣明细下载链接 Create rebate details download link
     * POST /api/v5/broker/fd/rebate-per-orders
     */
    @Test
    public void setRebatePerOrdersfd(){
        SetRebatePerOrders setRebatePerOrders = new SetRebatePerOrders();
        setRebatePerOrders.setBegin("20220401");
        setRebatePerOrders.setEnd("20220507");

        JSONObject result = this.brokerAPIService.setRebatePerOrdersfd(setRebatePerOrders);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取用户的 Broker 返佣信息 Get the user's broker rebate information
     * GET /api/v5/broker/fd/if-rebate
     */
    @Test
    public void ifRebate(){
        JSONObject result = this.brokerAPIService.ifRebate("","");
        toResultString(LOG, "result", result);
    }

    /**
     * 重置子账户充值地址    modify-subaccount-deposit-address
     * POST /api/v5/asset/broker/nd/modify-subaccount-deposit-address
     */
    @Test
    public void modifySubaccountDepositAddress(){
        SubAccountDepositAddress subAccountDepositAddress = new SubAccountDepositAddress();
        subAccountDepositAddress.setSubAcct("");
        subAccountDepositAddress.setCcy("");
        subAccountDepositAddress.setChain("");
        subAccountDepositAddress.setAddr("");
        subAccountDepositAddress.setTo("");
        JSONObject result = this.brokerAPIService.modifySubaccountDepositAddress(subAccountDepositAddress);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取子账户提币记录  Get subaccount-withdrawal-history
     * GET /api/v5/asset/broker/nd/subaccount-withdrawal-history
     */
    @Test
    public void getSubaccountWithdrawalHistory(){
        JSONObject result = this.brokerAPIService.getSubaccountWithdrawalHistory("","","","","","","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取子账户列表  Get subaccount-info
     * GET /api/v5/broker/nd/subaccount-info
     */
    @Test
    public void getSubaccountInfo(){
        JSONObject result = this.brokerAPIService.getSubaccountInfo("","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 设置模拟盘ND子账户资产    set-subaccount-assets
     * POST /api/v5/broker/nd/set-subaccount-assets
     */
    @Test
    public void setSubaccountAssets(){
        SetSubAccountAssets setSubAccountAssets = new SetSubAccountAssets();
        setSubAccountAssets.setSubAcct("");
        setSubAccountAssets.setCcy("");
        JSONObject result = this.brokerAPIService.setSubaccountAssets(setSubAccountAssets);
        toResultString(LOG, "result", result);
    }
    /**
     * 子账户IP上报   report-subaccount-ip
     * POST /api/v5/broker/nd/report-subaccount-ip
     */
    @Test
    public void reportSubaccIp(){
        CreateSubAccount subAccount = new CreateSubAccount();

        subAccount.setSubAcct("0324test01");
        subAccount.setClientIP("");
        JSONObject result = this.brokerAPIService.reportSubaccIp(subAccount);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取用户的 Broker 返佣信息 Get if-rebate
     * GET /api/v5/broker/nd/if-rebate
     */
    @Test
    public void getIfRebate(){
        JSONObject result = this.brokerAPIService.getIfRebate("","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 激活合约体验金  activate-credit
     * POST /api/v5/broker/nd/activate-credit
     */
    @Test
    public void activateCredit(){
        ActivateCredit activateCredit = new ActivateCredit();
        activateCredit.setCreditId("");
        JSONObject result = this.brokerAPIService.activateCredit(activateCredit);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取合约体验金Get credits
     * GET /api/v5/broker/nd/credits
     */
    @Test
    public void getCredits(){
        JSONObject result = this.brokerAPIService.getCredits("","");
        toResultString(LOG, "result", result);
    }
}
