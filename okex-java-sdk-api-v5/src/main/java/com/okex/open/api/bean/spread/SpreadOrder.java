package com.okex.open.api.bean.spread;

public class SpreadOrder {
    private String sprdId;
    private String clOrdId;
    private String tag;
    private String side;
    private String ordType;

    private String sz;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    private String ordId;

    public String getSprdId() {
        return sprdId;
    }

    public void setSprdId(String sprdId) {
        this.sprdId = sprdId;
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

    private String px;


    @Override
    public String toString() {
        return "SpreadOrder{" +
                "sprdId='" + sprdId + '\'' +
                ", clOrdId='" + clOrdId + '\'' +
                ", tag='" + tag + '\'' +
                ", side='" + side + '\'' +
                ", ordType='" + ordType + '\'' +
                ", sz='" + sz + '\'' +
                ", px='" + px + '\'' +

                '}';
    }





}
