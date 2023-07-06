package com.okex.open.api.bean.trade.param;

public class CancelOrder {
    private String instId;
    private String ordId;
    private String clOrdId;

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    private String timeOut;
    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getInstFamily() {
        return instFamily;
    }

    public void setInstFamily(String instFamily) {
        this.instFamily = instFamily;
    }

    private String instType;
    private String  instFamily;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getClOrdId() {
        return clOrdId;
    }

    public void setClOrdId(String clOrdId) {
        this.clOrdId = clOrdId;
    }

    @Override
    public String toString() {
        return "CancelOrder{" +
                "instId='" + instId + '\'' +
                ", ordId='" + ordId + '\'' +
                ", clOrdId='" + clOrdId + '\'' +
                ", instType='" + instType + '\'' +
                ", instFamily='" + instFamily + '\'' +
                ", timeOut='" + timeOut + '\'' +
                '}';
    }
}
