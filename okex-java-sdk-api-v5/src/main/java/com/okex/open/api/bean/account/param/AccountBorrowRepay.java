package com.okex.open.api.bean.account.param;

public class AccountBorrowRepay {
    private String ccy;
    private String side;
    private String amt;

    private String ordId;

    public String getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(String maxRate) {
        this.maxRate = maxRate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getReborrow() {
        return reborrow;
    }

    public void setReborrow(String reborrow) {
        this.reborrow = reborrow;
    }

    public String getReborrowRate() {
        return reborrowRate;
    }

    public void setReborrowRate(String reborrowRate) {
        this.reborrowRate = reborrowRate;
    }

    private String maxRate;
    private String term;
    private String reborrow;

    private String reborrowRate;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
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

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }
    @Override
    public String toString() {
        return "AccountBorrowRepay{" +
                "ccy='" + ccy + '\'' +
                "side='" + side + '\'' +
                "amt='" + amt + '\'' +
                "ordId='" + ordId + '\'' +
                '}';
    }
}
