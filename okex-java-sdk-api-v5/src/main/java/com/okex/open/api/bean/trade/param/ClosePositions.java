package com.okex.open.api.bean.trade.param;

public class ClosePositions {
    private String instId;
    private String posSide;
    private String mgnMode;
    private String ccy;

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

    public String getMgnMode() {
        return mgnMode;
    }

    public void setMgnMode(String mgnMode) {
        this.mgnMode = mgnMode;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @Override
    public String toString() {
        return "ClosePositions{" +
                "instId='" + instId + '\'' +
                ", posSide='" + posSide + '\'' +
                ", mgnMode='" + mgnMode + '\'' +
                ", ccy='" + ccy + '\'' +
                '}';
    }
}
