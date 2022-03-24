package com.okex.open.api.bean.convert.param;

public class EstimateQuote {

    private String baseCcy;
    private String quoteCcy;
    private String side;
    private String rfqSz;
    private String rfqSzCcy;
    private String clQReqId;

    @Override
    public String toString() {
        return "EstimateQuote{" +
                "baseCcy='" + baseCcy + '\'' +
                ", quoteCcy='" + quoteCcy + '\'' +
                ", side='" + side + '\'' +
                ", rfqSz='" + rfqSz + '\'' +
                ", rfqSzCcy='" + rfqSzCcy + '\'' +
                ", clQReqId='" + clQReqId + '\'' +
                '}';
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

    public String getRfqSz() {
        return rfqSz;
    }

    public void setRfqSz(String rfqSz) {
        this.rfqSz = rfqSz;
    }

    public String getRfqSzCcy() {
        return rfqSzCcy;
    }

    public void setRfqSzCcy(String rfqSzCcy) {
        this.rfqSzCcy = rfqSzCcy;
    }

    public String getClQReqId() {
        return clQReqId;
    }

    public void setClQReqId(String clQReqId) {
        this.clQReqId = clQReqId;
    }
}
