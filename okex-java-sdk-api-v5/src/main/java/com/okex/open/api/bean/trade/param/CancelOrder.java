package com.okex.open.api.bean.trade.param;

public class CancelOrder {
    private String instId;
    private String ordId;
    private String clOrdId;

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
                '}';
    }
}
