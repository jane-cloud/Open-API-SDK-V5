package com.okex.open.api.bean.blockTrading.param;

public class CancelQuote {
    private String quoteId;
    private String clQuoteId;
    private String rfqId;

    public String getRfqId() {
        return rfqId;
    }

    public void setRfqId(String rfqId) {
        this.rfqId = rfqId;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getClQuoteId() {
        return clQuoteId;
    }

    public void setClQuoteId(String clQuoteId) {
        this.clQuoteId = clQuoteId;
    }
}
