package com.okex.open.api.bean.gridTrading.param;

public class StopOrderAlgo {
    private String algoId;
    private String instId;
    private String algoOrdType;
    private String stopType;

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

    public String getAlgoOrdType() {
        return algoOrdType;
    }

    public void setAlgoOrdType(String algoOrdType) {
        this.algoOrdType = algoOrdType;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String stopType) {
        this.stopType = stopType;
    }
}
