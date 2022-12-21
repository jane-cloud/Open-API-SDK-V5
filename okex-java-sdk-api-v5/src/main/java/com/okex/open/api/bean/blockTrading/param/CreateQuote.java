package com.okex.open.api.bean.blockTrading.param;

import java.util.List;

public class CreateQuote {
    private String rfqId;
    private String clQuoteId;
    private String quoteSide;
    private List<Legs> legs;
    private Boolean anonymous;
    private String expiresIn;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;

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

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }


    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }
}
