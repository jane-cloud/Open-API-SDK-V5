package com.okex.open.api.bean.account.param;

public class To {
    private String tdMode;
    private String posSide;

    public String getTdMode() {
        return tdMode;
    }

    public void setTdMode(String tdMode) {
        this.tdMode = tdMode;
    }

    public String getPosSide() {
        return posSide;
    }

    public void setPosSide(String posSide) {
        this.posSide = posSide;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    private String ccy;
}
