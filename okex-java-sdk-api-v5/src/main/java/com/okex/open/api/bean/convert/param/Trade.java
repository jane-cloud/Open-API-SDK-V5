package com.okex.open.api.bean.convert.param;

public class Trade {
    private String quoteId;
    private String baseCcy;
    private String quoteCcy;
    private String side;
    private String sz;
    private String szCcy;
    private String clTReqId;

    @Override
    public String toString() {
        return "Trade{" +
                "quoteId='" + quoteId + '\'' +
                ", baseCcy='" + baseCcy + '\'' +
                ", quoteCcy='" + quoteCcy + '\'' +
                ", side='" + side + '\'' +
                ", sz='" + sz + '\'' +
                ", szCcy='" + szCcy + '\'' +
                ", clTReqId='" + clTReqId + '\'' +
                '}';
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getBaseCcy() {
        return baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
        this.baseCcy = baseCcy;
    }

    public String getQuoteCcy() {
        return quoteCcy;
    }

    public void setQuoteCcy(String quoteCcy) {
        this.quoteCcy = quoteCcy;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getSzCcy() {
        return szCcy;
    }

    public void setSzCcy(String szCcy) {
        this.szCcy = szCcy;
    }

    public String getClTReqId() {
        return clTReqId;
    }

    public void setClTReqId(String clTReqId) {
        this.clTReqId = clTReqId;
    }
}
