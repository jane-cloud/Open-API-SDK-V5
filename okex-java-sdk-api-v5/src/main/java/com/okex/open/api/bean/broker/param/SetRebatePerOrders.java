package com.okex.open.api.bean.broker.param;

public class SetRebatePerOrders {
    private String begin;
    private String end;

    private String brokerType;

    @Override
    public String toString() {
        return "SetRebatePerOrders{" +
                "begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", brokerType='" + brokerType + '\'' +
                '}';
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType;
    }
}
