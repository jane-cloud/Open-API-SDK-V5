package com.okex.open.api.bean.account.param;

public class IncreaseDecreaseMargin {
    private String instId;
    private String posSide;
    private String type;
    private String amt;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getPosSide() {
        return posSide;
    }

    public void setPosSide(String posSide) {
        this.posSide = posSide;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "IncreaseDecreaseMargin{" +
                "instId='" + instId + '\'' +
                ", posSide='" + posSide + '\'' +
                ", type='" + type + '\'' +
                ", amt='" + amt + '\'' +
                '}';
    }
}
