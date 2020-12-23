package com.okex.open.api.bean.trade.param;

public class AmendOrder {
    private String instId;
    private Boolean cxlOnFail;
    private String ordId;
    private String clOrdId;
    private String reqId;
    private String newSz;
    private String newPx;

    public java.lang.String getInstId() {
        return instId;
    }

    public void setInstId(java.lang.String instId) {
        this.instId = instId;
    }

    public Boolean getCxlOnFail() {
        return cxlOnFail;
    }

    public void setCxlOnFail(Boolean cxlOnFail) {
        this.cxlOnFail = cxlOnFail;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public java.lang.String getClOrdId() {
        return clOrdId;
    }

    public void setClOrdId(java.lang.String clOrdId) {
        this.clOrdId = clOrdId;
    }

    public java.lang.String getReqId() {
        return reqId;
    }

    public void setReqId(java.lang.String reqId) {
        this.reqId = reqId;
    }

    public java.lang.String getNewSz() {
        return newSz;
    }

    public void setNewSz(java.lang.String newSz) {
        this.newSz = newSz;
    }

    public java.lang.String getNewPx() {
        return newPx;
    }

    public void setNewPx(java.lang.String newPx) {
        this.newPx = newPx;
    }

    @Override
    public String toString() {
        return "AmendOrder{" +
                "instId='" + instId + '\'' +
                ", cxlOnFail=" + cxlOnFail +
                ", ordId='" + ordId + '\'' +
                ", clOrdId='" + clOrdId + '\'' +
                ", reqId='" + reqId + '\'' +
                ", newSz='" + newSz + '\'' +
                ", newPx='" + newPx + '\'' +
                '}';
    }
}
