package com.okex.open.api.bean.earn.param;

import java.util.List;

public class Purchase {
    private String productId;

    public List<InvestData> getInvestData() {
        return investData;
    }

    public void setInvestData(List<InvestData> investData) {
        this.investData = investData;
    }

    private List<InvestData> investData;
    private String term;
    private String tag;

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    private String amt;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }



    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
