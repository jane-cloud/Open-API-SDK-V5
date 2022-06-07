package com.okex.open.api.bean.blockTrading.param;

import java.util.List;

public class CreateQuote {
    private String rfqId;
    private String clQuoteId;
    private String quoteSide;
    private List<Legs> legs;

    public String getRfqId() {
        return rfqId;
    }

    public void setRfqId(String rfqId) {
        this.rfqId = rfqId;
    }

    public String getClQuoteId() {
        return clQuoteId;
    }

    public void setClQuoteId(String clQuoteId) {
        this.clQuoteId = clQuoteId;
    }

    public String getQuoteSide() {
        return quoteSide;
    }

    public void setQuoteSide(String quoteSide) {
        this.quoteSide = quoteSide;
    }

    public List<Legs> getLegs() {
        return legs;
    }

    public void setLegs(List<Legs> legs) {
        this.legs = legs;
    }
}
