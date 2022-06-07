package com.okex.open.api.bean.blockTrading.param;

public class CancelQuote {
    private String quoteId;
    private String clQuoteId;

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
