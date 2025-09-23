package com.okex.open.api.bean.account.param;

public class AutoEarn {
    private String earnType;
    private String ccy;
    private String action;

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getEarnType() {
        return earnType;
    }

    public void setEarnType(String earnType) {
        this.earnType = earnType;
    }

    private String apr;
}
