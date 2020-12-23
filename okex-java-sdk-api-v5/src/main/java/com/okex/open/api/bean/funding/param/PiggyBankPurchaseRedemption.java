package com.okex.open.api.bean.funding.param;

public class PiggyBankPurchaseRedemption {
    private String ccy;
    private String amt;
    private String side;

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

    @Override
    public String toString() {
        return "PiggyBankPurchaseRedemption{" +
                "ccy='" + ccy + '\'' +
                ", amt='" + amt + '\'' +
                ", side='" + side + '\'' +
                '}';
    }
}
