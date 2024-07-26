package com.okex.open.api.bean.account.param;

public class SetRiskOffsetAmt {
    private String ccy;

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getClSpotInUseAmt() {
        return clSpotInUseAmt;
    }

    public void setClSpotInUseAmt(String clSpotInUseAmt) {
        this.clSpotInUseAmt = clSpotInUseAmt;
    }

    private String clSpotInUseAmt;




    @Override
    public String toString() {
        return "SetRiskOffsetAmt{" +
                "ccy='" + ccy + '\'' +
                "clSpotInUseAmt='" + clSpotInUseAmt + '\'' +

                '}';
    }
}
