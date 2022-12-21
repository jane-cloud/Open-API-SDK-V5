package com.okex.open.api.bean.broker.param;

public class SetSubAccountFeeRate {
    private String subAcct;
    private String instType;
    private String chgType;
    private String chgTaker;
    private String chgMaker;
    private String effDate;

    public String getMgnType() {
        return mgnType;
    }

    public void setMgnType(String mgnType) {
        this.mgnType = mgnType;
    }

    private String mgnType;
    public String getSubAcct() {
        return subAcct;
    }

    public void setSubAcct(String subAcct) {
        this.subAcct = subAcct;
    }

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getChgType() {
        return chgType;
    }

    public void setChgType(String chgType) {
        this.chgType = chgType;
    }

    public String getChgTaker() {
        return chgTaker;
    }

    public void setChgTaker(String chgTaker) {
        this.chgTaker = chgTaker;
    }

    public String getChgMaker() {
        return chgMaker;
    }

    public void setChgMaker(String chgMaker) {
        this.chgMaker = chgMaker;
    }

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }
}
