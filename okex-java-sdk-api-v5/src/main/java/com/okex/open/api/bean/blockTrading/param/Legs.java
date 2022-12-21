package com.okex.open.api.bean.blockTrading.param;

public class Legs {
    private String  instId;
    private String  sz;
    private String  side;
    private String  tgtCcy;
    private String  px;

    public String getPosSide() {
        return posSide;
    }

    public void setPosSide(String posSide) {
        this.posSide = posSide;
    }

    private String  posSide;

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getTgtCcy() {
        return tgtCcy;
    }

    public void setTgtCcy(String tgtCcy) {
        this.tgtCcy = tgtCcy;
    }
}
