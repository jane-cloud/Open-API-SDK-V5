package com.okex.open.api.bean.gridTrading.param;

public class AmendOrderAlgo {
    private String algoId;
    private String instId;
    private String slTriggerPx;
    private String tpTriggerPx;

    public String getTpRatio() {
        return tpRatio;
    }

    public void setTpRatio(String tpRatio) {
        this.tpRatio = tpRatio;
    }

    public String getSlRatio() {
        return slRatio;
    }

    public void setSlRatio(String slRatio) {
        this.slRatio = slRatio;
    }

    private String tpRatio;
    private String slRatio;
    public String getAlgoId() {
        return algoId;
    }

    public void setAlgoId(String algoId) {
        this.algoId = algoId;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getSlTriggerPx() {
        return slTriggerPx;
    }

    public void setSlTriggerPx(String slTriggerPx) {
        this.slTriggerPx = slTriggerPx;
    }

    public String getTpTriggerPx() {
        return tpTriggerPx;
    }

    public void setTpTriggerPx(String tpTriggerPx) {
        this.tpTriggerPx = tpTriggerPx;
    }
}
