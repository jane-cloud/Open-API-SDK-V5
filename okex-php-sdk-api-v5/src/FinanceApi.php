<?php


namespace okv5;


class FinanceApi extends Utils
{
    public function offers($productId='',$protocolType='',$ccy=''){
        $params = [
            'productId' => $productId,
            'protocolType' => $protocolType,
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/finance/staking-defi/offers', $params, 'GET');
    }

    public function purchase($productId,$investData,$term='',$tag=''){
        $params = [
            'productId' => $productId,
            'investData' => $investData,
            'term' => $term,
            'tag' => $tag,
        ];

        return $this->request('/api/v5/finance/staking-defi/purchase', $params, 'POST');
    }

    public function redeem($ordId,$protocolType,$allowEarlyRedeem=''){
        $params = [
            'ordId' => $ordId,
            'protocolType' => $protocolType,
            'allowEarlyRedeem' => $allowEarlyRedeem,
        ];

        return $this->request('/api/v5/finance/staking-defi/redeem', $params, 'POST');
    }

    public function cancel($ordId,$protocolType){
        $params = [
            'ordId' => $ordId,
            'protocolType' => $protocolType,
        ];

        return $this->request('/api/v5/finance/staking-defi/cancel', $params, 'POST');
    }

    public function ordersActive($productId='',$protocolType='',$ccy='',$state=''){
        $params = [
            'productId' => $productId,
            'protocolType' => $protocolType,
            'ccy' => $ccy,
            'state' => $state,
        ];

        return $this->request('/api/v5/finance/staking-defi/orders-active', $params, 'GET');
    }

    public function ordersHistory($productId='',$protocolType='',$ccy='',$after='',$before='',$limit=''){
        $params = [
            'productId' => $productId,
            'protocolType' => $protocolType,
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/staking-defi/orders-history', $params, 'GET');
    }

    public function productInfo(){
        $params = [
        ];

        return $this->request('/api/v5/finance/staking-defi/eth/product-info', $params, 'GET');
    }

    public function ethPurchase($amt){
        $params = [
            'amt' => $amt
        ];

        return $this->request('/api/v5/finance/staking-defi/eth/purchase', $params, 'POST');
    }
    
    public function ethRedeem($amt){
        $params = [
            'amt' => $amt
        ];

        return $this->request('/api/v5/finance/staking-defi/eth/redeem', $params, 'POST');
    }

    public function ethBalance(){
        $params = [
        ];

        return $this->request('/api/v5/finance/staking-defi/eth/balance', $params, 'GET');
    }

    public function purchaseRedeemHistory($type,$status='',$after='',$before='',$limit=''){
        $params = [
            'type' => $type,
            'status' => $status,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/staking-defi/eth/purchase-redeem-history', $params, 'GET');
    }

    public function ethApyHistory($days){
        $params = [
            'days' => $days,
        ];

        return $this->request('/api/v5/finance/staking-defi/eth/apy-history', $params, 'GET');
    }

    public function solPurchase($amt){
        $params = [
            'amt' => $amt
        ];

        return $this->request('/api/v5/finance/staking-defi/sol/purchase', $params, 'POST');
    }

    public function solRedeem($amt){
        $params = [
            'amt' => $amt
        ];

        return $this->request('/api/v5/finance/staking-defi/sol/redeem', $params, 'POST');
    }

    public function solBalance(){
        $params = [
        ];

        return $this->request('/api/v5/finance/staking-defi/sol/balance', $params, 'GET');
    }

    public function solPurchaseRedeemHistory($type,$status='',$after='',$before='',$limit=''){
        $params = [
            'type' => $type,
            'status' => $status,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/staking-defi/sol/purchase-redeem-history', $params, 'GET');
    }

    public function solApyHistory($days){
        $params = [
            'days' => $days,
        ];

        return $this->request('/api/v5/finance/staking-defi/sol/apy-history', $params, 'GET');
    }

    public function savingsBalance($ccy=''){
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/finance/savings/balance', $params, 'GET');
    }

    public function savingsPurchaseRedempt($ccy,$amt,$side,$rate){
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'side' => $side,
            'rate' => $rate,
        ];

        return $this->request('/api/v5/finance/savings/purchase-redempt', $params, 'POST');
    }

    public function savingsSetLendingRate($ccy,$rate){
        $params = [
            'ccy' => $ccy,
            'rate' => $rate,
        ];

        return $this->request('/api/v5/finance/savings/set-lending-rate', $params, 'POST');
    }

    public function savingsLendingHistory($ccy='',$after='',$before='',$limit=''){
        $params = [
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/savings/lending-history', $params, 'GET');
    }

    public function savingsLendingRateSummary($ccy=''){
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/finance/savings/lending-rate-summary', $params, 'GET');
    }

    public function savingsLendingRateHistory($ccy='',$after='',$before='',$limit=''){
        $params = [
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/savings/lending-rate-history', $params, 'GET');
    }

    public function fixedLoanLendingOffers($ccy='',$term=''){
        $params = [
            'ccy' => $ccy,
            'term' => $term,
        ];

        return $this->request('/api/v5/finance/fixed-loan/lending-offers', $params, 'GET');
    }

    public function fixedLoanLendingApyHistory($ccy='',$term=''){
        $params = [
            'ccy' => $ccy,
            'term' => $term,
        ];

        return $this->request('/api/v5/finance/fixed-loan/lending-apy-history', $params, 'GET');
    }

    public function fixedLoanPendingLendingVolume($ccy='',$term=''){
        $params = [
            'ccy' => $ccy,
            'term' => $term,
        ];

        return $this->request('/api/v5/finance/fixed-loan/pending-lending-volume', $params, 'GET');
    }

    public function fixedLoanLendingOrder($ccy,$amt,$rate,$term,$autoRenewal=''){
        $params = [
            'ccy' => $ccy,
            'amt' => $amt,
            'rate' => $rate,
            'term' => $term,
            'autoRenewal' => $autoRenewal,
        ];

        return $this->request('/api/v5/finance/fixed-loan/lending-order', $params, 'POST');
    }

    public function fixedLoanAmendLendingOrder($ordId,$changeAmt='',$rate='',$autoRenewal=''){
        $params = [
            'ordId' => $ordId,
            'changeAmt' => $changeAmt,
            'rate' => $rate,
            'autoRenewal' => $autoRenewal,
        ];

        return $this->request('/api/v5/finance/fixed-loan/amend-lending-order', $params, 'POST');
    }

    public function fixedLoanLendingOrdersList($ordId='',$ccy='',$state='',$after='',$before='',$limit=''){
        $params = [
            'ordId' => $ordId,
            'ccy' => $ccy,
            'state' => $state,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/fixed-loan/lending-orders-list', $params, 'GET');
    }

    public function fixedLoanLendingSubOrders($ordId,$ccy='',$state='',$after='',$before='',$limit=''){
        $params = [
            'ordId' => $ordId,
            'ccy' => $ccy,
            'state' => $state,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/fixed-loan/lending-sub-orders', $params, 'GET');
    }

    public function flexibleLoanBorrowCurrencies(){
        $params = [
        ];

        return $this->request('/api/v5/finance/flexible-loan/borrow-currencies', $params, 'GET');
    }

    public function flexibleLoanCollateralAssets($ccy=''){
        $params = [
            'ccy' => $ccy,
        ];

        return $this->request('/api/v5/finance/flexible-loan/collateral-assets', $params, 'GET');
    }

    public function flexibleLoanMaxLoan($borrowCcy,$supCollateral=''){
        $params = [
            'borrowCcy' => $borrowCcy,
            'supCollateral' => $supCollateral,
        ];

        return $this->request('/api/v5/finance/flexible-loan/max-loan', $params, 'POST');
    }

    public function flexibleLoanMaxCollateralRedeemAmount($borrowCcy){
        $params = [
            'borrowCcy' => $borrowCcy,
        ];

        return $this->request('/api/v5/finance/flexible-loan/max-collateral-redeem-amount', $params, 'GET');
    }

    public function flexibleLoanAdjustCollateral($type,$collateralCcy,$collateralAmt){
        $params = [
            'type' => $type,
            'collateralCcy' => $collateralCcy,
            'collateralAmt' => $collateralAmt,
        ];

        return $this->request('/api/v5/finance/flexible-loan/adjust-collateral', $params, 'POST');
    }

    public function flexibleLoanLoanInfo(){
        $params = [
        ];

        return $this->request('/api/v5/finance/flexible-loan/loan-info', $params, 'GET');
    }

    public function flexibleLoanLoanHistory($type='',$after='',$before='',$limit=''){
        $params = [
            'type' => $type,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/flexible-loan/loan-history', $params, 'GET');
    }

    public function flexibleLoanInterestAccrued($ccy='',$after='',$before='',$limit=''){
        $params = [
            'ccy' => $ccy,
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
        ];

        return $this->request('/api/v5/finance/flexible-loan/interest-accrued', $params, 'GET');
    }

    
    

}
