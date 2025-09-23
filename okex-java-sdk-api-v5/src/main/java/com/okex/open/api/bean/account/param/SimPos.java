package com.okex.open.api.bean.account.param;

public class SimPos {
    private String instId;
    private String pos;
    private String avgPx;
    private String lever;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getAvgPx() {
        return avgPx;
    }

    public void setAvgPx(String avgPx) {
        this.avgPx = avgPx;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }
}
