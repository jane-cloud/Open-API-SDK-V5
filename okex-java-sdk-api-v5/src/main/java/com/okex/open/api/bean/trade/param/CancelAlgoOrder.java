package com.okex.open.api.bean.trade.param;

public class CancelAlgoOrder {

    private String algoId;
    private String instId;

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
}
