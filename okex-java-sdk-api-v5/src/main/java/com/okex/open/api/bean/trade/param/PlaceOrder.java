package com.okex.open.api.bean.trade.param;

public class PlaceOrder {
    private String instId;
    private String tdMode;
    private String ccy;
    private String clOrdId;
    private String tag;
    private String side;
    private String posSide;
    private String ordType;
    private String sz;
    private String px;

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    private Boolean reduceOnly;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getTdMode() {
        return tdMode;
    }

    public void setTdMode(String tdMode) {
        this.tdMode = tdMode;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getClOrdId() {
        return clOrdId;
    }

    public void setClOrdId(String clOrdId) {
        this.clOrdId = clOrdId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getPosSide() {
        return posSide;
    }

    public void setPosSide(String posSide) {
        this.posSide = posSide;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }


    @Override
    public String toString() {
        return "PlaceOrder{" +
                "instId='" + instId + '\'' +
                ", tdMode='" + tdMode + '\'' +
                ", ccy='" + ccy + '\'' +
                ", clOrdId='" + clOrdId + '\'' +
                ", tag='" + tag + '\'' +
                ", side='" + side + '\'' +
                ", posSide='" + posSide + '\'' +
                ", ordType='" + ordType + '\'' +
                ", sz='" + sz + '\'' +
                ", px='" + px + '\'' +
                ", reduceOnly='" + reduceOnly + '\'' +
                '}';
    }
}
