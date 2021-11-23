package com.okex.open.api.bean.account.param;

public class AccountBorrowRepay {
    private String ccy;
    private String side;
    private String amt;

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
                '}';
    }
}
