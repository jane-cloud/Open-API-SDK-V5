package com.okex.open.api.bean.broker.param;

public class SetRebatePerOrders {
    private String begin;
    private String end;

    @Override
    public String toString() {
        return "SetRebatePerOrders{" +
                "begin='" + begin + '\'' +
                ", end='" + end + '\'' +
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
}
