package com.okex.open.api.bean.trade.param;

import java.util.ArrayList;

public class AmendOrder {
    private String instId;
    private Boolean cxlOnFail;
    private String ordId;
    private String clOrdId;
    private String reqId;
    private String newSz;
    private String newPx;

    private String newTpTriggerPx;
    private String newTpOrdPx;
    private String newSlTriggerPx;
    private String newSlOrdPx;

    private String newPxUsd;

    public ArrayList<AttachAlgoOrds> getAttachAlgoOrds() {
        return attachAlgoOrds;
    }

    public void setAttachAlgoOrds(ArrayList<AttachAlgoOrds> attachAlgoOrds) {
        this.attachAlgoOrds = attachAlgoOrds;
    }

    private ArrayList<AttachAlgoOrds> attachAlgoOrds;

    public String getNewPxUsd() {
        return newPxUsd;
    }

    public void setNewPxUsd(String newPxUsd) {
        this.newPxUsd = newPxUsd;
    }

    public String getNewPxVol() {
        return newPxVol;
    }

    public void setNewPxVol(String newPxVol) {
        this.newPxVol = newPxVol;
    }

    private String newPxVol;

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
