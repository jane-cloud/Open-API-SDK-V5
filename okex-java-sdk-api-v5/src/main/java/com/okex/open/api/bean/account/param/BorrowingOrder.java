package com.okex.open.api.bean.account.param;

public class BorrowingOrder {
    private String ordId;
    private String reborrow;

    private String ccy;
    private String side;

    public String getAutoRepay() {
        return autoRepay;
    }

    public void setAutoRepay(String autoRepay) {
        this.autoRepay = autoRepay;
    }

    private String  autoRepay;
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

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    private String amt;

    public String getPendingRepay() {
        return pendingRepay;
    }

    public void setPendingRepay(String pendingRepay) {
        this.pendingRepay = pendingRepay;
    }

    private String pendingRepay;

    public String getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(String maxRate) {
        this.maxRate = maxRate;
    }

    private String maxRate;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getReborrow() {
        return reborrow;
    }

    public void setReborrow(String reborrow) {
        this.reborrow = reborrow;
    }

    public String getRenewMaxRate() {
        return renewMaxRate;
    }

    public void setRenewMaxRate(String renewMaxRate) {
        this.renewMaxRate = renewMaxRate;
    }

    private String renewMaxRate;


    @Override
    public String toString() {
        return "BorrowingOrder{" +
                "ordId='" + ordId + '\'' +
                "renewMaxRate='" + renewMaxRate + '\'' +
                "reborrow='" + reborrow + '\'' +

                '}';
    }
}
