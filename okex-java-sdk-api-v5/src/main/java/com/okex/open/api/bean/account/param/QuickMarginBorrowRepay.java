package com.okex.open.api.bean.account.param;

public class QuickMarginBorrowRepay {
    private String instId;
    private String ccy;
    private String side;
    private String amt;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "QuickMarginBorrowRepay{" +
                "instId='" + instId + '\'' +
                ", ccy='" + ccy + '\'' +
                ", side='" + side + '\'' +
                ", amt='" + amt + '\'' +
                '}';
    }
}
