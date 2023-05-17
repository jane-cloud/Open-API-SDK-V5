package com.okex.open.api.bean.trade.param;

public class AmendAlgos {
    private String instId;
    private String algoId;
    private String algoClOrdId;
    private String cxlOnFail;
    private String reqId;
    private String newSz;
    private String newTpTriggerPx;
    private String newTpOrdPx;
    private String newSlTriggerPx;
    private String newSlOrdPx;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getAlgoId() {
        return algoId;
    }

    public void setAlgoId(String algoId) {
        this.algoId = algoId;
    }

    public String getAlgoClOrdId() {
        return algoClOrdId;
    }

    public void setAlgoClOrdId(String algoClOrdId) {
        this.algoClOrdId = algoClOrdId;
    }

    public String getCxlOnFail() {
        return cxlOnFail;
    }

    public void setCxlOnFail(String cxlOnFail) {
        this.cxlOnFail = cxlOnFail;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getNewSz() {
        return newSz;
    }

    public void setNewSz(String newSz) {
        this.newSz = newSz;
    }

    public String getNewTpTriggerPx() {
        return newTpTriggerPx;
    }

    public void setNewTpTriggerPx(String newTpTriggerPx) {
        this.newTpTriggerPx = newTpTriggerPx;
    }

    public String getNewTpOrdPx() {
        return newTpOrdPx;
    }

    public void setNewTpOrdPx(String newTpOrdPx) {
        this.newTpOrdPx = newTpOrdPx;
    }

    public String getNewSlTriggerPx() {
        return newSlTriggerPx;
    }

    public void setNewSlTriggerPx(String newSlTriggerPx) {
        this.newSlTriggerPx = newSlTriggerPx;
    }

    public String getNewSlOrdPx() {
        return newSlOrdPx;
    }

    public void setNewSlOrdPx(String newSlOrdPx) {
        this.newSlOrdPx = newSlOrdPx;
    }

    public String getNewTpTriggerPxType() {
        return newTpTriggerPxType;
    }

    public void setNewTpTriggerPxType(String newTpTriggerPxType) {
        this.newTpTriggerPxType = newTpTriggerPxType;
    }

    public String getNewSlTriggerPxType() {
        return newSlTriggerPxType;
    }

    public void setNewSlTriggerPxType(String newSlTriggerPxType) {
        this.newSlTriggerPxType = newSlTriggerPxType;
    }

    private String newTpTriggerPxType;
    private String newSlTriggerPxType;

}
