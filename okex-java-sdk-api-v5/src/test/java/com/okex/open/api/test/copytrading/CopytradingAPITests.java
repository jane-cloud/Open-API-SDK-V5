package com.okex.open.api.test.copytrading;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.SetLeverage;
import com.okex.open.api.bean.copytrading.param.*;
import com.okex.open.api.service.copytrading.CopytradingAPIService;
import com.okex.open.api.service.copytrading.impl.CopytradingAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopytradingAPITests extends CopytradingAPIBaseTests{

    private static final Logger LOG = LoggerFactory.getLogger(CopytradingAPITests.class);

    private CopytradingAPIService copytradingAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.copytradingAPIService = new CopytradingAPIServiceImpl(this.config);
    }

    /**
     * 交易员获取当前带单 Get existing leading positions
     * GET /api/v5/copytrading/current-subpositions
     */
    @Test
    public void currentSubpositions() {
        JSONObject result = copytradingAPIService.currentSubpositions("BTC-USDT-SWAP",null,null,null,null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员获取历史带单 Get leading position history
     * /api/v5/copytrading/subpositions-history
     */
    @Test
    public void subpositionsHistory() {
        JSONObject result = copytradingAPIService.subpositionsHistory("BTC-USDT-SWAP",null,null,null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员止盈止损 algo-order
     * /api/v5/copytrading/algo-order
     */
    @Test
    public void AlgoOrder() {
        AlgoOrder algoOrder = new AlgoOrder();
        algoOrder.setSubPosId("1234");
        algoOrder.setSlTriggerPx("12");
        algoOrder.setSlTriggerPxType("last");
        algoOrder.setTpTriggerPx("13");
        algoOrder.setTpTriggerPxType("last");
        algoOrder.setInstType("");
        algoOrder.setSlOrdPx("");
        algoOrder.setTpOrdPx("");
        JSONObject result = copytradingAPIService.algoOrder(algoOrder);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员平仓 Close leading position
     * POST /api/v5/copytrading/close-subposition
     */
    @Test
    public void closeSubposition() {
        CloseSubposition closeSubposition = new CloseSubposition();
        closeSubposition.setSubPosId("1234");
        closeSubposition.setTag("");
        closeSubposition.setInstType("");
        closeSubposition.setSubPosType("");
        closeSubposition.setOrdType("");
        closeSubposition.setPx("");

        JSONObject result = copytradingAPIService.closeSubposition(closeSubposition);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员获取带单合约 Get leading instruments
     * GET /api/v5/copytrading/instruments
     */
    @Test
    public void getInstruments() {
        JSONObject result = copytradingAPIService.getInstruments("");
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员修改带单合约 Amend leading instruments
     * POST /api/v5/copytrading/set-instruments
     */
    @Test
    public void setInstruments() {
        SetInstruments setInstruments = new SetInstruments();
        setInstruments.setInstId("BTC-USDT-SWAP");
        setInstruments.setInstType("");
        JSONObject result = copytradingAPIService.setInstruments(setInstruments);
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员历史分润明细 Get profit sharing details
     * GET /api/v5/copytrading/profit-sharing-details
     */
    @Test
    public void getProfitSharingDetails() {
        JSONObject result = copytradingAPIService.getProfitSharingDetails("","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员历史分润汇总 Get total profit sharing
     * GET /api/v5/copytrading/total-profit-sharing
     */
    @Test
    public void getTotalProfitSharing() {
        JSONObject result = copytradingAPIService.getTotalProfitSharing("");
        toResultString(LOG, "result", result);
    }

    /**
     * 交易员待分润明细 Get unrealized profit sharing details
     * GET /api/v5/copytrading/unrealized-profit-sharing-details
     */
    @Test
    public void getUnrealizedProfitSharingDetails() {
        JSONObject result = copytradingAPIService.getUnrealizedProfitSharingDetails("");
        toResultString(LOG, "result", result);
    }
    /**
     * 交易员止盈止损 Close algo-order
     * POST /api/v5/copytrading/algo-order
     */
    @Test
    public void setAlgoOrder() {
        CloseSubposition algoOrder = new CloseSubposition();
        algoOrder.setSubPosId("1234");
        algoOrder.setTpTriggerPx("");
        algoOrder.setSlTriggerPx("");
        algoOrder.setTpTriggerPxType("");
        algoOrder.setSlTriggerPxType("");
        algoOrder.setTag("");
        algoOrder.setSubPosType("");

        JSONObject result = copytradingAPIService.setAlgoOrder(algoOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 首次跟单设置 first-copy-settings
     * POST /api/v5/copytrading/first-copy-settings
     */
    @Test
    public void setFirstCopySettings() {
        CopySetting firstCopySetting = new CopySetting();
        firstCopySetting.setInstType("");
        firstCopySetting.setCopyAmt("");
        firstCopySetting.setCopyMode("");
        firstCopySetting.setCopyRatio("");
        firstCopySetting.setCopyMgnMode("");
        firstCopySetting.setCopyInstIdType("");
        firstCopySetting.setCopyTotalAmt("");
        firstCopySetting.setSubPosCloseType("");
        firstCopySetting.setUniqueCode("");
        firstCopySetting.setTpRatio("");
        firstCopySetting.setSlRatio("");
        firstCopySetting.setSlTotalAmt("");
        firstCopySetting.setInstId("");

        JSONObject result = copytradingAPIService.setFirstCopySettings(firstCopySetting);
        toResultString(LOG, "result", result);
    }
    /**
     * 修改跟单设置 amend-copy-settings
     * POST /api/v5/copytrading/amend-copy-settings
     */
    @Test
    public void amendCopySettings() {
        CopySetting amendCopySettings = new CopySetting();
        amendCopySettings.setInstType("");
        amendCopySettings.setCopyAmt("");
        amendCopySettings.setCopyMode("");
        amendCopySettings.setCopyRatio("");
        amendCopySettings.setCopyMgnMode("");
        amendCopySettings.setCopyInstIdType("");
        amendCopySettings.setCopyTotalAmt("");
        amendCopySettings.setSubPosCloseType("");
        amendCopySettings.setUniqueCode("");
        amendCopySettings.setTpRatio("");
        amendCopySettings.setSlRatio("");
        amendCopySettings.setSlTotalAmt("");
        amendCopySettings.setInstId("");

        JSONObject result = copytradingAPIService.amendCopySettings(amendCopySettings);
        toResultString(LOG, "result", result);
    }

    /**
     * 停止跟单 stop-copy-trading
     * POST /api/v5/copytrading/stop-copy-trading
     */
    @Test
    public void stopCopyTrading() {
        CopySetting stopCopyTrading = new CopySetting();
        stopCopyTrading.setInstType("");
        stopCopyTrading.setSubPosCloseType("");
        stopCopyTrading.setUniqueCode("");

        JSONObject result = copytradingAPIService.stopCopyTrading(stopCopyTrading);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取跟单设置 copy-settings
     * GET /api/v5/copytrading/copy-settings
     */
    @Test
    public void getCopySettings() {

        JSONObject result = copytradingAPIService.getCopySettings(null,"");
        toResultString(LOG, "result", result);
    }
    /**
     * 批量获取杠杆倍数 batch-leverage-inf
     * GET /api/v5/copytrading/batch-leverage-inf
     */
    @Test
    public void getBatchLeverageInf() {

        JSONObject result = copytradingAPIService.getBatchLeverageInf("","",null);
        toResultString(LOG, "result", result);
    }
    /**
     * 批量设置杠杆倍数 batch-set-leverage
     * POST /api/v5/copytrading/batch-set-leverage
     */
    @Test
    public void setBatchSetLeverage() {

        SetLeverage setLeverage=new SetLeverage();
        setLeverage.setInstId("BTC-USDT-SWAP");
        setLeverage.setLever("13.3");
        setLeverage.setMgnMode("cross");
        JSONObject result = copytradingAPIService.setBatchSetLeverage(setLeverage);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取我的交易员 current-lead-traders
     * GET /api/v5/copytrading/current-lead-traders
     */
    @Test
    public void getCurrentLeadTraders() {

        JSONObject result = copytradingAPIService.getCurrentLeadTraders("");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取我的交易员历史lead-traders-history
     * GET /api/v5/copytrading/lead-traders-history
     */
    @Test
    public void getLeadTradersHistory() {

        JSONObject result = copytradingAPIService.getLeadTradersHistory("","","","");
        toResultString(LOG, "result", result);
    }
    /**
     *  获取跟单配置信息public-config
     * GET /api/v5/copytrading/public-config
     */
    @Test
    public void getPublicConfig() {

        JSONObject result = copytradingAPIService.getPublicConfig("");
        toResultString(LOG, "result", result);
    }
    /**
     *  获取交易员排名public-lead-traders
     * GET /api/v5/copytrading/public-lead-traders
     */
    @Test
    public void getPublicLeadTraders() {

        JSONObject result = copytradingAPIService.getPublicLeadTraders("","","","","","","","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     *  获取交易员收益周表现public-weekly-pnl
     * GET /api/v5/copytrading/public-weekly-pnl
     */
    @Test
    public void getPublicWeeklyPnl() {

        JSONObject result = copytradingAPIService.getPublicWeeklyPnl("","");
        toResultString(LOG, "result", result);
    }
    /**
     *  获取交易员收益日表现public-pnl
     * GET /api/v5/copytrading/public-pnl
     */
    @Test
    public void getPublicPnl() {

        JSONObject result = copytradingAPIService.getPublicPnl("","","");
        toResultString(LOG, "result", result);
    }

    /**
     *   获取交易员带单情况public-stats
     * GET /api/v5/copytrading/public-stats
     */
    @Test
    public void getPublicStats() {

        JSONObject result = copytradingAPIService.getPublicStats("","","");
        toResultString(LOG, "result", result);
    }

    /**
     *   获取交易员币种偏好public-preference-currency
     * GET /api/v5/copytrading/public-preference-currency
     */
    @Test
    public void getPublicPreferenceCurrency() {

        JSONObject result = copytradingAPIService.getPublicPreferenceCurrency("","");
        toResultString(LOG, "result", result);
    }
    /**
     *   获取交易员当前带单 public-current-subpositions
     * GET /api/v5/copytrading/public-current-subpositions
     */
    @Test
    public void getPublicCurrentSubpositions() {

        JSONObject result = copytradingAPIService.getPublicCurrentSubpositions("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     *    获取交易员历史带单 public-subpositions-history
     * GET /api/v5/copytrading/public-subpositions-history
     */
    @Test
    public void getPublicSubpositionsHistory() {

        JSONObject result = copytradingAPIService.getPublicSubpositionsHistory("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 带单申请 apply-lead-trading
     * POST /api/v5/copytrading/apply-lead-trading
     */
    @Test
    public void applyLeadTrading() {

        LeadTrading applyLeadTrading=new LeadTrading();
        applyLeadTrading.setInstId("");
        applyLeadTrading.setInstType("");
        JSONObject result = copytradingAPIService.applyLeadTrading(applyLeadTrading);
        toResultString(LOG, "result", result);
    }
    /**
     * 停止带单 stop-lead-trading
     * POST /api/v5/copytrading/stop-lead-trading
     */
    @Test
    public void stopLeadTrading() {

        LeadTrading stopLeadTrading=new LeadTrading();
        stopLeadTrading.setInstType("");
        JSONObject result = copytradingAPIService.stopLeadTrading(stopLeadTrading);
        toResultString(LOG, "result", result);
    }
    /**
     *  修改分润比例 amend-profit-sharing-ratio
     * POST /api/v5/copytrading/amend-profit-sharing-ratio
     */
    @Test
    public void amendProfitSharingRatio() {

        LeadTrading amendProfitSharingRatio=new LeadTrading();
        amendProfitSharingRatio.setInstType("");
        amendProfitSharingRatio.setProfitSharingRatio("");
        JSONObject result = copytradingAPIService.amendProfitSharingRatio(amendProfitSharingRatio);
        toResultString(LOG, "result", result);
    }
    /**
     *  获取交易员排名（私有）lead-traders
     * GET /api/v5/copytrading/lead-traders
     */
    @Test
    public void getPrivateLeadTraders() {

        JSONObject result = copytradingAPIService.getPrivateLeadTraders("","","","","","","","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     *  获取交易员收益周表现（私有）weekly-pnl
     * GET /api/v5/copytrading/weekly-pnl
     */
    @Test
    public void getWeeklyPnl() {

        JSONObject result = copytradingAPIService.getWeeklyPnl("","");
        toResultString(LOG, "result", result);
    }
    /**
     *  获取交易员收益日表现（私有）pnl
     * GET /api/v5/copytrading/pnl
     */
    @Test
    public void getPnl() {

        JSONObject result = copytradingAPIService.getPnl("","","");
        toResultString(LOG, "result", result);
    }
    /**
     *   获取交易员带单情况（私有）stats
     * GET /api/v5/copytrading/stats
     */
    @Test
    public void getStats() {

        JSONObject result = copytradingAPIService.getStats("","","");
        toResultString(LOG, "result", result);
    }

    /**
     *   获取交易员币种偏好（私有）preference-currency
     * GET /api/v5/copytrading/preference-currency
     */
    @Test
    public void getPreferenceCurrency() {

        JSONObject result = copytradingAPIService.getPreferenceCurrency("","");
        toResultString(LOG, "result", result);
    }
    /**
     *   获取交易员当前带单 （私有）current-subpositions
     * GET /api/v5/copytrading/current-subpositions
     */
    @Test
    public void getCurrentSubpositions() {

        JSONObject result = copytradingAPIService.getCurrentSubpositions("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     *    获取交易员历史带单（私有） subpositions-history
     * GET /api/v5/copytrading/subpositions-history
     */
    @Test
    public void getSubpositionsHistory() {

        JSONObject result = copytradingAPIService.getSubpositionsHistory("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     *    获取跟单人信息（私有） copy-traders
     * GET /api/v5/copytrading/copy-traders
     */
    @Test
    public void getCopyTraders() {

        JSONObject result = copytradingAPIService.getCopyTraders("","","");
        toResultString(LOG, "result", result);
    }
    /**
     *    获取跟单人信息 public-copy-traders
     * GET /api/v5/copytrading/public-copy-traders
     */
    @Test
    public void getPublicCopyTraders() {

        JSONObject result = copytradingAPIService.getPublicCopyTraders("","","");
        toResultString(LOG, "result", result);
    }

    /**
     *    查看账户配置信息 config
     * GET /api/v5/copytrading/config
     */
    @Test
    public void getAccountConfig() {

        JSONObject result = copytradingAPIService.getAccountConfig();
        toResultString(LOG, "result", result);
    }
    /**
     *    交易员待分润汇总 total-unrealized-profit-sharing
     * GET /api/v5/copytrading/total-unrealized-profit-sharing
     */
    @Test
    public void getTotalUnrealizedProfitSharing() {

        JSONObject result = copytradingAPIService.getTotalUnrealizedProfitSharing("");
        toResultString(LOG, "result", result);
    }
}
