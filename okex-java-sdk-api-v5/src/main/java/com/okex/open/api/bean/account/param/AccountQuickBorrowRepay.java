package com.okex.open.api.bean.account.param;

public class AccountQuickBorrowRepay {
    private String ccy;
    private String side;
    private String amt;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    private String instId;

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
    @Override
    public String toString() {
        return "AccountQuickBorrowRepay{" +
                "ccy='" + ccy + '\'' +
                "side='" + side + '\'' +
                "amt='" + amt + '\'' +
                "instId='" + instId + '\'' +
                '}';
    }
}
