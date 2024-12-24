package com.okex.open.api.bean.finance.param;

import java.util.ArrayList;

public class Finance {
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    private String ccy;
    private String amt;
    private String side;
    private String rate;
    private String  borrowCcy;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCollateralCcy() {
        return collateralCcy;
    }

    public void setCollateralCcy(String collateralCcy) {
        this.collateralCcy = collateralCcy;
    }

    public String getCollateralAmt() {
        return collateralAmt;
    }

    public void setCollateralAmt(String collateralAmt) {
        this.collateralAmt = collateralAmt;
    }

    private String collateralCcy;
    private String collateralAmt;

    public ArrayList<SupCollateral> getSupCollateral() {
        return supCollateral;
    }

    public void setSupCollateral(ArrayList<SupCollateral> supCollateral) {
        this.supCollateral = supCollateral;
    }

    public String getBorrowCcy() {
        return borrowCcy;
    }

    public void setBorrowCcy(String borrowCcy) {
        this.borrowCcy = borrowCcy;
    }

    private ArrayList<SupCollateral> supCollateral;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(String autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    private String term;
    private String autoRenewal;
}
