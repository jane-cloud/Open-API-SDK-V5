<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/7/30
 * Time: 12:38 PM
 */

namespace okv5;


class AccountApi extends Utils
{
    //
    public function getBalance($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];
        return $this->request('/api/v5/account/balance', $params, 'GET');
    }

    //
    public function getPositions($instType='',$instId='',$posId='')
    {
        $params = [
            'instType' => $instType,
            'instId' => $instId,
            'posId' => $posId,
        ];

        return $this->request('/api/v5/account/positions', $params, 'GET');
    }

    public function getAccountPositionRisk($instType='')
    {
        $params = [
            'instType' => $instType,
        ];

        return $this->request('/api/v5/account/account-position-risk', $params, 'GET');
    }

    public function getBills($instType='',$ccy='',$mgnMode='',$ctType='',$type='',$subType='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'ccy' => $ccy,
            'mgnMode' => $mgnMode,
            'ctType' => $ctType,
            'type' => $type,
            'subType' => $subType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/bills', $params, 'GET');
    }

    public function getBillsArchive($instType='',$ccy='',$mgnMode='',$ctType='',$type='',$subType='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'ccy' => $ccy,
            'mgnMode' => $mgnMode,
            'ctType' => $ctType,
            'type' => $type,
            'subType' => $subType,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/bills-archive', $params, 'GET');
    }

    public function getConfig()
    {
        return $this->request('/api/v5/account/config', '', 'GET');
    }

    public function setPositionMode($posMode)
    {
        $params = [
            'posMode' => $posMode,
        ];
        return $this->request('/api/v5/account/set-position-mode', $params, 'POST');
    }

    public function setLeverage($instId='',$ccy='',$lever,$mgnMode,$posSide='')
    {
        $params = [
            'instId' => $instId,
            'ccy' => $ccy,
            'lever' => $lever,
            'mgnMode' => $mgnMode,
            'posSide' => $posSide,
        ];

        return $this->request('/api/v5/account/set-leverage', $params, 'POST');
    }

    public function getMaxSize($instId,$tdMode,$ccy='',$px='',$leverage='')
    {
        $params = [
            'instId' => $instId,
            'tdMode' => $tdMode,
            'ccy' => $ccy,
            'px' => $px,
            'leverage' => $leverage,
        ];

        return $this->request('/api/v5/account/max-size', $params, 'GET');
    }

    public function getMaxAvailSize($instId,$ccy='',$tdMode,$reduceOnly='',$px='')
    {
        $params = [
            'instId' => $instId,
            'ccy' => $ccy,
            'tdMode' => $tdMode,
            'reduceOnly' => $reduceOnly,
            'px' => $px,
        ];

        return $this->request('/api/v5/account/max-avail-size', $params, 'GET');
    }

    public function marginBalance($instId,$posSide,$type,$amt,$loanTrans='',$ccy='',$auto='')
    {
        $params = [
            'instId' => $instId,
            'posSide' => $posSide,
            'type' => $type,
            'amt' => $amt,
            'loanTrans' => $loanTrans,
            'ccy' => $ccy,
            'auto' => $auto,
        ];

        return $this->request('/api/v5/account/position/margin-balance', $params, 'POST');
    }

    public function getLeverage($instId,$mgnMode)
    {
        $params = [
            'instId' => $instId,
            'mgnMode' => $mgnMode,
        ];

        return $this->request('/api/v5/account/leverage-info', $params, 'GET');
    }

    public function getMaxLoan($instId,$mgnMode,$mgnCcy='')
    {
        $params = [
            'instId' => $instId,
            'mgnMode' => $mgnMode,
            'mgnCcy' => $mgnCcy,
        ];

        return $this->request('/api/v5/account/max-loan', $params, 'GET');
    }

    public function getTradeFee($instType,$instId='',$uly='',$category='')
    {
        $params = [
            'instType' => $instType,
            'instId' => $instId,
            'uly' => $uly,
            'category' => $category,
        ];

        return $this->request('/api/v5/account/trade-fee', $params, 'GET');
    }

    public function getInterestRate($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/account/interest-rate', $params, 'GET');
    }

    public function getInterestAccrued($type='',$instId='',$ccy='',$mgnMode='',$after='',$before='',$limit='')
    {
        $params = [
            'type' => $type,
            'instId' => $instId,
            'ccy' => $ccy,
            'mgnMode' => $mgnMode,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/interest-accrued', $params, 'GET');
    }

    public function setGreeks($greeksType)
    {
        $params = [
            'greeksType' => $greeksType,
        ];

        return $this->request('/api/v5/account/set-greeks', $params, 'POST');
    }

    public function getMaxWithdrawal($ccy='')
    {
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/account/max-withdrawal', $params, 'GET');
    }

    public function riskState()
    {
        $params = [
        ];

        return $this->request('/api/v5/account/risk-state', $params, 'GET');
    }

    public function borrowRepay($ccy,$side,$amt)
    {
        $params = [
            'ccy' => $ccy,
            'side' => $side,
            'amt' => $amt,
        ];

        return $this->request('/api/v5/account/borrow-repay', $params, 'POST');
    }

    public function borrowRepayHistory($ccy='',$after='',$before='',$limit='')
    {
        $params = [
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/borrow-repay-history', $params, 'GET');
    }

    public function interestLimits($type='',$ccy='')
    {
        $params = [
            'type' => $type,
            'ccy' => $ccy,

        ];

        return $this->request('/api/v5/account/interest-limits', $params, 'GET');
    }

    public function simulatedMargin($instType='',$inclRealPos='',$simPos='')
    {
        $params = [
            'instType' => $instType,
            'inclRealPos' => $inclRealPos,
            'simPos' => $simPos,


        ];

        return $this->request('/api/v5/account/simulated_margin', $params, 'POST');
    }

    public function setIsolatedMode($type,$isoMode)
    {
        $params = [
            'type' => $type,
            'isoMode' => $isoMode,

        ];

        return $this->request('/api/v5/account/set-isolated-mode', $params, 'POST');
    }

    public function greeks($ccy='')
    {
        $params = [
            'ccy' => $ccy,

        ];

        return $this->request('/api/v5/account/greeks', $params, 'GET');
    }

    public function getPositionsHistory($instType='',$instId='',$mgnMode='',$type='',$posId='',$after='',$before='',$limit='')
    {
        $params = [
            'instType' => $instType,
            'instId' => $instId,
            'mgnMode' => $mgnMode,
            'type' => $type,
            'posId' => $posId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/positions-history', $params, 'GET');
    }

    public function getAdjustLeverageInfo($instType='',$mgnMode='',$lever='',$instId='',$ccy='',$posSide='')
    {
        $params = [
            'instType' => $instType,
            'mgnMode' => $mgnMode,
            'lever' => $lever,
            'instId' => $instId,
            'ccy' => $ccy,
            'posSide' => $posSide,
            
        ];

        return $this->request('/api/v5/account/adjust-leverage-info', $params, 'GET');
    }

    public function quickMarginBorrowRepay($instId='',$ccy='',$side='',$amt='')
    {
        $params = [
            'instId' => $instId,
            'ccy' => $ccy,
            'side' => $side,
            'amt' => $amt,
            
        ];

        return $this->request('/api/v5/account/quick-margin-borrow-repay', $params, 'POST');
    }

    public function quickMarginBorrowRepayHistory($instId='',$ccy='',$side='',$after='',$before='',$begin='',$end='',$limit='')
    {
        $params = [
            'instId' => $instId,
            'ccy' => $ccy,
            'side' => $side,
            'after' => $after,
            'before' => $before,
            'begin' => $begin,
            'end' => $end,
            'limit' => $limit,
            
        ];

        return $this->request('/api/v5/account/quick-margin-borrow-repay-history', $params, 'GET');
    }

    public function vipInterestAccrued($ccy='',$ordId='',$after='',$before='',$limit='')
    {
        $params = [
            'ccy' => $ccy,
            'ordId' => $ordId,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
            
        ];

        return $this->request('/api/v5/account/vip-interest-accrued', $params, 'GET');
    }

    public function vipInterestDeducted($ordId='',$ccy='',$after='',$before='',$limit='')
    {
        $params = [
            
            'ordId' => $ordId,
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
            
        ];

        return $this->request('/api/v5/account/vip-interest-deducted', $params, 'GET');
    }

    public function vipLoanOrderList($ordId='',$state='',$ccy='',$after='',$before='',$limit='')
    {
        $params = [
            'ordId' => $ordId,
            'state' => $state,
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
            
        ];

        return $this->request('/api/v5/account/vip-loan-order-list', $params, 'GET');
    }

    public function vipLoanOrderDetail($ordId='',$ccy='',$after='',$before='',$limit='')
    {
        $params = [
            'ordId' => $ordId,
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
            
        ];

        return $this->request('/api/v5/account/vip-loan-order-detail', $params, 'GET');
    }

    public function positionBuilder($acctLv='',$inclRealPosAndEq='',$lever='',$simPos='',$simAsset='',$greeksType='')
    {
        $params = [
            'acctLv' => $acctLv,
            'inclRealPosAndEq' => $inclRealPosAndEq,
            'lever' => $lever,
            'simPos' => $simPos,
            'simAsset' => $simAsset,
            'greeksType' => $greeksType,
            
        ];

        return $this->request('/api/v5/account/position-builder', $params, 'POST');
    }

    public function positionTiers($instType='',$uly='',$instFamily='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instFamily' => $instFamily,
            
        ];

        return $this->request('/api/v5/account/position-tiers', $params, 'GET');
    }

    public function setRiskOffsetType($instType='')
    {
        $params = [
            'type' => $type,
            
        ];

        return $this->request('/api/v5/account/set-riskOffset-type', $params, 'POST');
    }

    public function activateOption()
    {
        $params = [
            
            
        ];

        return $this->request('/api/v5/account/activate-option', $params, 'POST');
    }

    public function setAutoLoan($autoLoan='')
    {
        $params = [
            'autoLoan' => $autoLoan,
            
        ];

        return $this->request('/api/v5/account/set-auto-loan', $params, 'POST');
    }

    public function setAccountLevel($acctLv='')
    {
        $params = [
            'acctLv' => $acctLv,
            
        ];

        return $this->request('/api/v5/account/set-account-level', $params, 'POST');
    }

    public function mmpReset($instType='',$instFamily='')
    {
        $params = [
            'instType' => $instType,
            'instFamily' => $instFamily,
            
        ];

        return $this->request('/api/v5/account/mmp-reset', $params, 'POST');
    }

    public function mmpConfig($instFamily='',$timeInterval='',$frozenInterval='',$qtyLimit='')
    {
        $params = [
            'instFamily' => $instFamily,
            'timeInterval' => $timeInterval,
            'frozenInterval' => $frozenInterval,
            'qtyLimit' => $qtyLimit,
            
        ];

        return $this->request('/api/v5/account/mmp-config', $params, 'POST');
    }

    public function getMmpConfig($instFamily='')
    {
        $params = [
            'instFamily' => $instFamily,
            
        ];

        return $this->request('/api/v5/account/mmp-config', $params, 'GET');
    }

    public function instruments($instType,$uly='',$instFamily='',$instId='')
    {
        $params = [
            'instType' => $instType,
            'uly' => $uly,
            'instFamily' => $instFamily,
            'instId' => $instId,
            
        ];

        return $this->request('/api/v5/account/instruments', $params, 'GET');
    }

    public function billsHistoryArchive($year,$quarter)
    {
        $params = [
            'year' => $year,
            'quarter' => $quarter,
            
        ];

        return $this->request('/api/v5/account/bills-history-archive', $params, 'POST');
    }

    public function getBillsHistoryArchive($year,$quarter)
    {
        $params = [
            'year' => $year,
            'quarter' => $quarter,
            
        ];

        return $this->request('/api/v5/account/bills-history-archive', $params, 'GET');
    }

    public function borrowingLimit()
    {
        $params = [
            
        ];

        return $this->request('/api/v5/account/fixed-loan/borrowing-limit', $params, 'GET');
    }

    public function borrowingQuote($type,$ccy='',$amt='',$maxRate='',$term='',$ordId='')
    {
        $params = [
            'type' => $type,
            'ccy' => $ccy,
            'amt' => $amt,
            'maxRate' => $maxRate,
            'term' => $term,
            'ordId' => $ordId,
        ];

        return $this->request('/api/v5/account/fixed-loan/borrowing-quote', $params, 'GET');
    }

    public function borrowingOrder($ccy,$amt,$maxRate,$term,$reborrow='',$reborrowRate='')
    {
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'maxRate' => $maxRate,
            'term' => $term,
            'reborrow' => $reborrow,
            'reborrowRate' => $reborrowRate,
        ];

        return $this->request('/api/v5/account/fixed-loan/borrowing-order', $params, 'POST');
    }

    public function amendBorrowingOrder($ordId,$reborrow='',$reborrowRate='')
    {
        $params = [
            'ordId' => $ordId,
            'reborrow' => $reborrow,
            'reborrowRate' => $reborrowRate,
        ];

        return $this->request('/api/v5/account/fixed-loan/amend-borrowing-order', $params, 'POST');
    }

    public function manualReborrow($ordId,$maxRate)
    {
        $params = [
            'ordId' => $ordId,
            'maxRate' => $maxRate,
        ];

        return $this->request('/api/v5/account/fixed-loan/manual-reborrow', $params, 'POST');
    }

    public function repayBorrowingOrder($ordId)
    {
        $params = [
            'ordId' => $ordId,
        ];

        return $this->request('/api/v5/account/fixed-loan/repay-borrowing-order', $params, 'POST');
    }

    public function convertToMarketLoan($ordId)
    {
        $params = [
            'ordId' => $ordId,
        ];

        return $this->request('/api/v5/account/fixed-loan/convert-to-market-loan', $params, 'POST');
    }

    public function reduceLiabilities($ordId,$pendingRepay)
    {
        $params = [
            'ordId' => $ordId,
            'pendingRepay' => $pendingRepay,
        ];

        return $this->request('/api/v5/account/fixed-loan/reduce-liabilities', $params, 'POST');
    }

    public function borrowingOrdersList($ordId='',$ccy='',$state='',$term='',$after='',$before='',$limit='')
    {
        $params = [
            'ordId' => $ordId,
            'ccy' => $ccy,
            'state' => $state,
            'term' => $term,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/fixed-loan/borrowing-orders-list', $params, 'GET');
    }

    public function spotManualBorrowRepay($ccy,$side,$amt)
    {
        $params = [
            'ccy' => $ccy,
            'side' => $side,
            'amt' => $amt,
        ];

        return $this->request('/api/v5/account/spot-manual-borrow-repay', $params, 'POST');
    }

    public function setAutoRepay($autoRepay)
    {
        $params = [
            'autoRepay' => $autoRepay,
        ];

        return $this->request('/api/v5/account/set-auto-repay', $params, 'POST');
    }

    public function spotBorrowRepayHistory($ccy='',$type='',$after='',$before='',$limit='')
    {
        $params = [
            'ccy' => $ccy,
            'type' => $type,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/account/spot-borrow-repay-history', $params, 'GET');
    }

    public function setRiskOffsetAmt($ccy,$clSpotInUseAmt)
    {
        $params = [
            'ccy' => $ccy,
            'clSpotInUseAmt' => $clSpotInUseAmt,
        ];

        return $this->request('/api/v5/account/set-riskOffset-amt', $params, 'POST');
    }

    public function accountLevelSwitchPreset($acctLv,$lever='',$riskOffsetType='')
    {
        $params = [
            'acctLv' => $acctLv,
            'lever' => $lever,
            'riskOffsetType' => $riskOffsetType,
        ];

        return $this->request('/api/v5/account/account-level-switch-preset', $params, 'POST');
    }

    public function setAccountSwitchPrecheck($acctLv)
    {
        $params = [
            'acctLv' => $acctLv,
        ];

        return $this->request('/api/v5/account/set-account-switch-precheck', $params, 'GET');
    }

    public function setCollateralAssets($type,$collateralEnabled,$ccyList='')
    {
        $params = [
            'type' => $type,
            'collateralEnabled' => $collateralEnabled,
            'ccyList' => $ccyList,
        ];

        return $this->request('/api/v5/account/set-collateral-assets', $params, 'POST');
    }

    public function getCollateralAssets($ccy='',$collateralEnabled='')
    {
        $params = [
            'ccy' => $ccy,
            'collateralEnabled' => $collateralEnabled,
        ];

        return $this->request('/api/v5/account/collateral-assets', $params, 'GET');
    }
}
