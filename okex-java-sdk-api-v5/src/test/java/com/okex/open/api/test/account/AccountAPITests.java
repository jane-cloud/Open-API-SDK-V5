package com.okex.open.api.test.account;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.*;
import com.okex.open.api.service.account.AccountAPIService;
import com.okex.open.api.service.account.impl.AccountAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountAPITests extends  AccountAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(AccountAPITests.class);

    private AccountAPIService accountAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.accountAPIService = new AccountAPIServiceImpl(this.config);
    }


    /**
     * 查看账户余额 Get Balance
     * GET /api/v5/account/balance
     */
    @Test
    public void getBalance(){
        JSONObject result = this.accountAPIService.getBalance("USDT");
        toResultString(LOG, "result", result);
    }

    /**
     * 查看持仓信息 Get Positions
     * GET /api/v5/account/positions
     */
    @Test
    public void getPositions(){
        JSONObject result = this.accountAPIService.getPositions("SWAP",null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 查看历史持仓信息   Get positions-history
     *GET /api/v5/account/positions-history
     */
    @Test
    public void getPositionsHistory(){
        JSONObject result = this.accountAPIService.getPositionsHistory("","","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 查看账户持仓风险 Get account and position risk
     * GET /api/v5/account/account-position-risk
     */
    @Test
    public void getAccountAndPosition(){
        JSONObject result = this.accountAPIService.getAccountAndPosition("SWAP");
        toResultString(LOG, "result", result);
    }

    /**
     * 账单流水查询（近七天） Get Bills Details (last 7 days)
     * GET /api/v5/account/bills
     */
    @Test
    public void getBillsDetails7Days(){
        JSONObject result = this.accountAPIService.getBillsDetails7Days("SWAP","","","","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 账单流水查询（近三个月） Get Bills Details (last 3 months)
     * GET /api/v5/account/bills-archive
     */
    @Test
    public void getBillsDetails3Months(){
        JSONObject result = this.accountAPIService.getBillsDetails3Months("SWAP",null,null,null,"8",null,null,null,null,null);
        toResultString(LOG, "result", result);
    }

    /**
     * 查看账户配置 Get Account Configuration
     * GET /api/v5/account/config
     */
    @Test
    public void getAccountConfiguration(){
        JSONObject result = this.accountAPIService.getAccountConfiguration();
        toResultString(LOG, "result", result);
    }

    /**
     * 设置持仓模式 Set Position mode
     * POST  /api/v5/account/set-position-mode
     */
    @Test
    public void setPositionMode(){
        SetPositionMode setPositionMode=new SetPositionMode();
        setPositionMode.setPosMode("long_short_mode");
        JSONObject result = this.accountAPIService.setPositionMode(setPositionMode);
        toResultString(LOG, "result", result);
    }

    /**
     * 设置杠杆倍数 Set Leverage
     * POST /api/v5/account/set-leverage
     */
    @Test
    public void setLeverage(){
        SetLeverage setLeverage=new SetLeverage();
        setLeverage.setInstId("BTC-USDT-SWAP");
//        setLeverage.setCcy("");
        setLeverage.setLever("13.3");
        setLeverage.setMgnMode("cross");
        setLeverage.setPosSide("net");

        JSONObject result = this.accountAPIService.setLeverage(setLeverage);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount
     * GET /api/v5/account/max-size
     */
    @Test
    public void getMaximumTradableSizeForInstrument(){
        JSONObject result = this.accountAPIService.getMaximumTradableSizeForInstrument("BTC-USDT","cross","BTC","","",false);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取最大可用数量  Get Maximum Available Tradable Amount
     * GET /api/v5/account/max-avail-size
     */
    @Test
    public void getMaximumAvailableTradableAmount(){
        JSONObject result = this.accountAPIService.getMaximumAvailableTradableAmount("BTC-USDT-SWAP","isolated","",false,"",false,"");
        toResultString(LOG, "result", result);
    }

    /**
     * 调整保证金  Increase/Decrease margin
     * POST /api/v5/account/position/margin-balance
     */
    @Test
    public void increaseDecreaseMargin(){
        IncreaseDecreaseMargin increaseDecreaseMargin = new IncreaseDecreaseMargin();

        increaseDecreaseMargin.setInstId("BTC-USDT-SWAP");
        increaseDecreaseMargin.setPosSide("long");
        increaseDecreaseMargin.setType("add");
        increaseDecreaseMargin.setAmt("100");
        increaseDecreaseMargin.setLoanTrans(false);
        increaseDecreaseMargin.setCcy("");
        increaseDecreaseMargin.setAuto(false);

        JSONObject result = this.accountAPIService.increaseDecreaseMargin(increaseDecreaseMargin);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取杠杆倍数  Get Leverage
     * GET /api/v5/account/leverage-info
     */
    @Test
    public void getLeverage(){
        JSONObject result = this.accountAPIService.getLeverage("BTC-USDT-211231 ","cross","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取交易产品最大可借  Get the maximum loan of instrument
     * GET /api/v5/account/max-loan
     */
    @Test
    public void getTheMaximumLoanOfIsolatedMARGIN(){
        JSONObject result = this.accountAPIService.getTheMaximumLoanOfIsolatedMARGIN("BTC-USDT","cross","BTC");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取当前账户交易手续费费率  Get Fee Rates
     * GET /api/v5/account/trade-fee
     */
    @Test
    public void getFeeRates(){
        JSONObject result = this.accountAPIService.getFeeRates("SWAP",null,"BTC-USDT","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取计息记录  Get interest-accrued
     * GET /api/v5/account/interest-accrued
     */
    @Test
    public void getInterestAccrued(){
        JSONObject result = this.accountAPIService.getInterestAccrued("1","BTC-USDT","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取用户当前杠杆借币利率  Get interest rate
     * GET /api/v5/account/interest-rate
     */
    @Test
    public void getInterestRate(){
        JSONObject result = this.accountAPIService.getInterestRate("USDT");
        toResultString(LOG, "result", result);
    }

    /**
     * 期权希腊字母PA/BS切换  Set Greeks (PA/BS)
     * POST /api/v5/account/set-greeks
     */
    @Test
    public void setTheDisplayTypeOfGreeks(){
        SetTheDisplayTypeOfGreeks setTheDisplayTypeOfGreeks = new SetTheDisplayTypeOfGreeks();
        setTheDisplayTypeOfGreeks.setGreeksType("PA");
        JSONObject result = this.accountAPIService.setTheDisplayTypeOfGreeks(setTheDisplayTypeOfGreeks);
        toResultString(LOG, "result", result);
    }

    /**
     * 逐仓交易设置  Isolated margin trading settings
     * POST /api/v5/account/set-isolated-mode
     */
    @Test
    public void setIsolatedMode(){
        SetIsolatedMode setIsolatedMode = new SetIsolatedMode();
        setIsolatedMode.setIsoMode("automatic");
        setIsolatedMode.setType("MARGIN");
        JSONObject result = this.accountAPIService.setIsolatedMode(setIsolatedMode);
        toResultString(LOG, "result", result);
    }

    /**
     * 查看账户最大可转余额  Get Maximum Withdrawals
     * GET /api/v5/account/max-withdrawal
     */
    @Test
    public void getMaximumWithdrawals(){
        JSONObject result = this.accountAPIService.getMaximumWithdrawals("USDT");
        toResultString(LOG, "result", result);
    }

    /**
     * 查看账户特定风险状态  Get account risk state
     * GET /api/v5/account/risk-state
     */
    @Test
    public void getRiskState(){
        JSONObject result = this.accountAPIService.getRiskState();
        toResultString(LOG, "result", result);
    }

    /**
     * 一键借币模式手动借币还币 Manual borrow and repay in Quick Margin Mode
     * POST /api/v5/account/quick-margin-borrow-repay
     */
    @Test
    public void quickMarginBorrowRepay(){
        QuickMarginBorrowRepay quickMarginBorrowRepay = new QuickMarginBorrowRepay();
        quickMarginBorrowRepay.setCcy("BTC");
        quickMarginBorrowRepay.setSide("repay");
        quickMarginBorrowRepay.setAmt("0.1");
        quickMarginBorrowRepay.setInstId("");
        JSONObject result = this.accountAPIService.quickMarginBorrowRepay(quickMarginBorrowRepay);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取一键借币还币历史 Get manual borrow and repay history in Quick Margin Mode
     * GET /api/v5/account/borrow-repay-history
     */
    @Test
    public void getMarginBorrowRepayHistory(){
        JSONObject result = this.accountAPIService.getMarginBorrowRepayHistory("","","","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 尊享借币还币  VIP loans borrow and repay
     * POST /api/v5/account/borrow-repay
     */
    @Test
    public void borrowRepay(){
        AccountBorrowRepay accountBorrowRepay = new AccountBorrowRepay();
        accountBorrowRepay.setCcy("BTC");
        accountBorrowRepay.setSide("repay");
        accountBorrowRepay.setAmt("0.1");
        accountBorrowRepay.setOrdId("");
        JSONObject result = this.accountAPIService.borrowRepay(accountBorrowRepay);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取尊享借币借还历史  Get borrow and repay history for VIP loans
     * GET /api/v5/account/borrow-repay-history
     */
    @Test
    public void getBorrowRepayHistory(){
        JSONObject result = this.accountAPIService.getBorrowRepayHistory("BTC",null,null,"100");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取尊享借币计息记录 vip-interest-accrued
     * GET /api/v5/account/vip-interest-accrued
     */
    @Test
    public void getVipInterestAccrued(){
        JSONObject result = this.accountAPIService.getVipInterestAccrued("","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取尊享借币扣息记录 Get VIP interest deducted data
     * GET /api/v5/account/vip-interest-deducted
     */
    @Test
    public void getVipInterestDeducted(){
        JSONObject result = this.accountAPIService.getVipInterestDeducted("","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 尊享借币订单列表 vip-loan-order-list
     * GET /api/v5/account/vip-loan-order-list
     */
    @Test
    public void getVipLoanOrderList(){
        JSONObject result = this.accountAPIService.getVipLoanOrderList("","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 尊享借币订单详情 vip-loan-order-detail
     * GET /api/v5/account/vip-loan-order-detail
     */
    @Test
    public void getVipLoanOrderDetail(){
        JSONObject result = this.accountAPIService.getVipLoanOrderDetail("","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取借币利率与限额   Get borrow interest and limit
     * GET /api/v5/account/interest-limits
     */
    @Test
    public void getInterestLimits(){
        JSONObject result = this.accountAPIService.getInterestLimits("1","BTC");
        toResultString(LOG, "result", result);
    }

    /**
     * 组合保证金的虚拟持仓保证金计算  Position builder
     * POST /api/v5/account/simulated_margin
     */
    @Test
    public void simulatedMargin(){
        SimulatedMargin simulatedMargin = new SimulatedMargin();
        simulatedMargin.setInstType("SWAP");
        simulatedMargin.setInclRealPos(false);


        List<InstIdPos> list = new ArrayList<>();

        InstIdPos instIdPos1 = new InstIdPos();
        instIdPos1.setInstId("DOT-USDT-SWAP");
        instIdPos1.setPos("1");

        InstIdPos instIdPos2 = new InstIdPos();
        instIdPos2.setInstId("DOT-USD-SWAP");
        instIdPos2.setPos("1");

        list.add(instIdPos1);
        list.add(instIdPos2);

        simulatedMargin.setSimPos(list);

        JSONObject result = this.accountAPIService.simulatedMargin(simulatedMargin);
        toResultString(LOG, "result", result);


    }

    /**
     * 查看账户Greeks   Get account greeks
     * GET /api/v5/account/greeks
     */
    @Test
    public void getAccountGreeks(){
        JSONObject result = this.accountAPIService.getAccountGreeks("");
        toResultString(LOG, "result", result);
    }

    /**
     * 获取组合保证金模式全仓限制 position-tiers
     * GET /api/v5/account/position-tiers
     */
    @Test
    public void getPositionTiers(){
        JSONObject result = this.accountAPIService.getPositionTiers("","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 设置组合保证金账户风险对冲模式 Set risk offset type
     * POST /api/v5/account/set-riskOffset-type
     */
    @Test
    public void setRiskOffsetType(){
        IncreaseDecreaseMargin increaseDecreaseMargin = new IncreaseDecreaseMargin();
        increaseDecreaseMargin.setType("1");

        JSONObject result = this.accountAPIService.setRiskOffsetType(increaseDecreaseMargin);
        toResultString(LOG, "result", result);
    }

    /**
     * 开通期权交易 Activate option
     * POST /api/v5/account/activate-option
     */
    @Test
    public void activateOption(){
        JSONObject result = this.accountAPIService.activateOption();
        toResultString(LOG, "result", result);
    }

    /**
     * 设置自动借币 Set auto loan
     * POST /api/v5/account/set-auto-loan
     */
    @Test
    public void setAutoLoan(){
        SetAutoLoan setAutoLoan = new SetAutoLoan();
        setAutoLoan.setAutoLoan(true);

        JSONObject result = this.accountAPIService.setAutoLoan(setAutoLoan);
        toResultString(LOG, "result", result);
    }
    /**
     * 重置 MMP 状态 mmp-reset
     * POST /api/v5/account/mmp-reset
     */
    @Test
    public void mmpReset(){
        Mmp mmpReset = new Mmp();
        mmpReset.setInstType("");
        mmpReset.setInstFamily("");

        JSONObject result = this.accountAPIService.mmpReset(mmpReset);
        toResultString(LOG, "result", result);
    }

    /**
     * 获取杠杆倍数预估信息 adjust-leverage-info
     * GET /api/v5/account/adjust-leverage-info
     */
    @Test
    public void getAdjustLeverageInfo(){
        JSONObject result = this.accountAPIService.getAdjustLeverageInfo("","","","","","");
        toResultString(LOG, "result", result);
    }

    /**
     * 设置 MMP  mmp-config
     * POST /api/v5/account/mmp-config
     */
    @Test
    public void mmpConfig(){
        Mmp mmpConfig = new Mmp();

        mmpConfig.setInstFamily("");
        mmpConfig.setFrozenInterval("");
        mmpConfig.setTimeInterval("");
        mmpConfig.setQtyLimit("");
        JSONObject result = this.accountAPIService.mmpConfig(mmpConfig);
        toResultString(LOG, "result", result);
    }

    /**
     * 查看 MMP 配置 mmp-config
     * GET /api/v5/account/mmp-config
     */
    @Test
    public void getMmpConfig(){
        JSONObject result = this.accountAPIService.getMmpConfig("");
        toResultString(LOG, "result", result);
    }

    /**
     * 设置账户模式
     * POST /api/v5/account/set-account-level
     */
    @Test
    public void setAccountLevel(){
        AccountMode accountMode = new AccountMode();
        accountMode.setAcctLv("");

        JSONObject result = this.accountAPIService.setAccountLevel(accountMode);
        toResultString(LOG, "result", result);
    }
    /**
     * 仓位创建器
     * POST /api/v5/account/position-builder
     */
    @Test
    public void positionBuilder(){
        PositionBuilder positionBuilder = new PositionBuilder();
        positionBuilder.setInclRealPosAndEq("");
        positionBuilder.setSpotOffsetType("");

        List<InstIdPos> list1 = new ArrayList<>();
        InstIdPos instIdPos1 = new InstIdPos();
        instIdPos1.setInstId("DOT-USDT-SWAP");
        instIdPos1.setPos("1");
        list1.add(instIdPos1);
        positionBuilder.setSimPos(list1);

        List<InstIdPos> list2 = new ArrayList<>();
        InstIdPos instIdPos2 = new InstIdPos();
        instIdPos2.setAmt("");
        instIdPos2.setCcy("");
        list2.add(instIdPos2);
        positionBuilder.setSimAsset(list2);

        positionBuilder.setGreeksType("");

        JSONObject result = this.accountAPIService.positionBuilder(positionBuilder);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取交易产品基础信息 instruments
     * GET /api/v5/account/instruments
     */
    @Test
    public void getInstruments(){
        JSONObject result = this.accountAPIService.getInstruments("","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 获取固定借币限额 borrowing-limit
     * GET /api/v5/account/fixed-loan/borrowing-limit
     */
    @Test
    public void getBorrowingLimit(){
        JSONObject result = this.accountAPIService.getBorrowingLimit();
        toResultString(LOG, "result", result);
    }
    /**
     * 获取固定借币询价 borrowing-quote
     * GET /api/v5/account/fixed-loan/borrowing-quote
     */
    @Test
    public void getBorrowingQuote(){
        JSONObject result = this.accountAPIService.getBorrowingQuote("","","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 固定借币下单 borrowing-order
     * POST /api/v5/account/fixed-loan/borrowing-order
     */
    @Test
    public void borrowingOrder(){
        AccountBorrowRepay borrowingOrder = new AccountBorrowRepay();
        borrowingOrder.setCcy("");
        borrowingOrder.setAmt("");
        borrowingOrder.setMaxRate("");
        borrowingOrder.setTerm("");
        borrowingOrder.setReborrow("");
        borrowingOrder.setReborrowRate("");
        JSONObject result = this.accountAPIService.borrowingOrder(borrowingOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 修改固定借币订单 amend-borrowing-order
     * POST /api/v5/account/fixed-loan/amend-borrowing-order
     */
    @Test
    public void amendBorrowingOrder(){
        BorrowingOrder amendBorrowingOrder = new BorrowingOrder();
        amendBorrowingOrder.setOrdId("");
        amendBorrowingOrder.setReborrow("");
        amendBorrowingOrder.setRenewMaxRate("");
        JSONObject result = this.accountAPIService.amendBorrowingOrder(amendBorrowingOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 固定借币手动续借 manual-reborrow
     * POST /api/v5/account/fixed-loan/manual-reborrow
     */
    @Test
    public void manualReborrow(){
        BorrowingOrder manualReborrow = new BorrowingOrder();
        manualReborrow.setOrdId("");
        manualReborrow.setMaxRate("");
        JSONObject result = this.accountAPIService.manualReborrow(manualReborrow);
        toResultString(LOG, "result", result);
    }
    /**
     * 固定借币手动还币 repay-borrowing-order
     * POST  /api/v5/account/fixed-loan/repay-borrowing-order
     */
    @Test
    public void repayBorrowingOrder(){
        BorrowingOrder repayBorrowingOrder = new BorrowingOrder();
        repayBorrowingOrder.setOrdId("");
        JSONObject result = this.accountAPIService.repayBorrowingOrder(repayBorrowingOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取固定借币订单信息borrowing-orders-list
     * GET  /api/v5/account/fixed-loan/borrowing-orders-list
     */
    @Test
    public void getBorrowingOrdersList(){

        JSONObject result = this.accountAPIService.getBorrowingOrdersList("","","","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 设置现货对冲占用 set-riskOffset-amt
     * POST /api/v5/account/set-riskOffset-amt
     */
    @Test
    public void setRiskOffsetAmt(){
        SetRiskOffsetAmt setRiskOffsetAmt = new SetRiskOffsetAmt();
        setRiskOffsetAmt.setCcy("");
        setRiskOffsetAmt.setClSpotInUseAmt("");

        JSONObject result = this.accountAPIService.setRiskOffsetAmt(setRiskOffsetAmt);
        toResultString(LOG, "result", result);
    }
    /**
     * 申请账单流水（自 2021 年）bills-history-archive
     * POST /api/v5/account/bills-history-archive
     */
    @Test
    public void applyBillsHistoryArchive(){
        BillsHistoryArchive billsHistoryArchive = new BillsHistoryArchive();
        billsHistoryArchive.setQuarter("");
        billsHistoryArchive.setYear("");

        JSONObject result = this.accountAPIService.applyBillsHistoryArchive(billsHistoryArchive);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取账单流水（自 2021 年）bills-history-archive
     * GET /api/v5/account/bills-history-archive
     */
    @Test
    public void getBillsHistoryArchive(){

        JSONObject result = this.accountAPIService.getBillsHistoryArchive("","");
        toResultString(LOG, "result", result);
    }
    /**
     * 固定借币转市场借币 convert-to-market-loan
     * POST  /api/v5/account/fixed-loan/convert-to-market-loan
     */
    @Test
    public void convertToMarketLoan(){
        BorrowingOrder repayBorrowingOrder = new BorrowingOrder();
        repayBorrowingOrder.setOrdId("");
        JSONObject result = this.accountAPIService.convertToMarketLoan(repayBorrowingOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 固定借币减少负债 reduce-liabilities
     * POST  /api/v5/account/fixed-loan/reduce-liabilities
     */
    @Test
    public void reduceLiabilities(){
        BorrowingOrder repayBorrowingOrder = new BorrowingOrder();
        repayBorrowingOrder.setOrdId("");
        repayBorrowingOrder.setPendingRepay("");
        JSONObject result = this.accountAPIService.reduceLiabilities(repayBorrowingOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 手动借/还币 spot-manual-borrow-repay
     * POST /api/v5/account/spot-manual-borrow-repay
     */
    @Test
    public void spotManualBorrowRepay(){
        BorrowingOrder borrowingOrder = new BorrowingOrder();
        borrowingOrder.setCcy("");
        borrowingOrder.setSide("");
        borrowingOrder.setAmt("");
        JSONObject result = this.accountAPIService.spotManualBorrowRepay(borrowingOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 设置自动还币set-auto-repay
     * POST /api/v5/account/set-auto-repay
     */
    @Test
    public void setAutoRepay(){
        BorrowingOrder borrowingOrder = new BorrowingOrder();
        borrowingOrder.setAutoRepay("");
        JSONObject result = this.accountAPIService.setAutoRepay(borrowingOrder);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取借/还币历史 getSpotBorrowRepayHistory
     *  get
     *  /api/v5/account/spot-borrow-repay-history
     */
    @Test
    public void getSpotBorrowRepayHistory(){

        JSONObject result = this.accountAPIService.getSpotBorrowRepayHistory("","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 设置质押币种 set-collateral-assets
     * POST /api/v5/account/set-collateral-assets
     */
    @Test
    public void setCollateralAssets(){
        CollateralAssets collateralAssets = new CollateralAssets();
        ArrayList<String> list = new ArrayList<>();
        list.add("");

        collateralAssets.setCollateralEnabled("");
        collateralAssets.setType("");
        collateralAssets.setCcyList(list);

        JSONObject result = this.accountAPIService.setCollateralAssets(collateralAssets);
        toResultString(LOG, "result", result);
    }
    /**
     * 查看质押币种 get collateral-assets
     *  get
     *  /api/v5/account/collateral-assets
     */
    @Test
    public void getCollateralAssets(){

        JSONObject result = this.accountAPIService.getCollateralAssets("","");
        toResultString(LOG, "result", result);
    }
    /**
     * 移仓 move-positions
     * POST /api/v5/account/move-positions
     */
    @Test
    public void movePositions(){
        MovePositions movePositions = new MovePositions();
        movePositions.setFromAcct("test1");
        movePositions.setToAcct("test2");
        ArrayList<Legs> legs = new ArrayList<>();
        Legs leg = new Legs();

        From from = new From();
        from.setSide("buy");
        from.setSz("1");
        from.setPosId("111");
        leg.setFrom(from);

        To to = new To();
        to.setCcy("BTC");
        to.setPosSide("long");
        to.setTdMode("cross");
        leg.setTo(to);

        legs.add(leg);

        movePositions.setLegs(legs);
        movePositions.setClientId("test001");
        JSONObject result = this.accountAPIService.movePositions(movePositions);
        toResultString(LOG, "result", result);
    }
    /**
     * 获取移仓历史 move-positions-history
     *  get
     * GET /api/v5/account/move-positions-history
     */
    @Test
    public void getMovePositionsHistory(){

        JSONObject result = this.accountAPIService.getMovePositionsHistory("","","","","","");
        toResultString(LOG, "result", result);
    }
    /**
     * 设置自动赚币 set-auto-earn
     * POST /api/v5/account/set-auto-earn
     */
    @Test
    public void setAutoEarn(){
        AutoEarn autoEarn = new AutoEarn();
        autoEarn.setEarnType("");
        autoEarn.setAction("");
        autoEarn.setApr("");
        autoEarn.setCcy("");
        JSONObject result = this.accountAPIService.setAutoEarn(autoEarn);
        toResultString(LOG, "result", result);
    }
    /**
     * 仓位创建器趋势图 position-builder-graph
     * POST /api/v5/account/position-builder-graph
     */
    @Test
    public void positionBuilderGraph(){
        PositionBuilderGraph positionBuilderGraph = new PositionBuilderGraph();

        positionBuilderGraph.setType("");

        ArrayList list = new ArrayList<>();

        SimAsset simAsset = new SimAsset();
        simAsset.setAmt("");
        simAsset.setCcy("");

        list.add(simAsset);
        positionBuilderGraph.setSimAsset(list);

        ArrayList list2 = new ArrayList<>();
        SimPos simPos = new SimPos();
        simPos.setPos("");
        simPos.setAvgPx("");
        simPos.setLever("");
        simPos.setInstId("");
        list2.add(simPos);
        positionBuilderGraph.setSimPos(list2);

        MmrConfig mmrConfig = new MmrConfig();
        mmrConfig.setAcctLv("");
        mmrConfig.setLever("");
        positionBuilderGraph.setMmrConfig(mmrConfig);

        JSONObject result = this.accountAPIService.positionBuilderGraph(positionBuilderGraph);
        toResultString(LOG, "result", result);
    }

    /**
     * 设置手续费计价方式。set-fee-type
     * POST /api/v5/account/set-fee-type
     */
    @Test
    public void setFeeType(){
        AccountMode account = new AccountMode();
        account.setFeeType("");
        JSONObject result = this.accountAPIService.setFeeType(account);
        toResultString(LOG, "result", result);
    }
}
