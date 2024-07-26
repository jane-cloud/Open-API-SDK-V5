package com.okex.open.api.bean.finance.param;

public class AmendFinance {

    private String rate;
    private String autoRenewal;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(String autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getChangeAmt() {
        return changeAmt;
    }

    public void setChangeAmt(String changeAmt) {
        this.changeAmt = changeAmt;
    }

    private String ordId;
    private String changeAmt;
}
