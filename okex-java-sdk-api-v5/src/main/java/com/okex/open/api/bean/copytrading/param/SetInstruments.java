package com.okex.open.api.bean.copytrading.param;

public class SetInstruments {
    private String instId;

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    private String instType;
    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }
}
