package com.okex.open.api.bean.funding.param;

public class SetLendingRate {
    private String ccy;
    private String rate;

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "SetLendingRate{" +
                "ccy='" + ccy + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
