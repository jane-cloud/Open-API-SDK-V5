package com.okex.open.api.bean.trade.param;

public class ClosePositions {
    private String instId;
    private String posSide;
    private String mgnMode;
    private String ccy;
    private String autoCxl;
    private String clOrdId;

    public String getClOrdId() {
        return clOrdId;
    }

    public void setClOrdId(String clOrdId) {
        this.clOrdId = clOrdId;
    }

    private String tag;



    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

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



    public String getAutoCxl() {
        return autoCxl;
    }

    public void setAutoCxl(String autoCxl) {
        this.autoCxl = autoCxl;
    }
}
