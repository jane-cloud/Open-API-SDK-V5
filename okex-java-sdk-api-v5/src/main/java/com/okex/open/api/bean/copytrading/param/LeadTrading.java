package com.okex.open.api.bean.copytrading.param;

public class LeadTrading {
    private String instType;

    private String instId;

    public String getProfitSharingRatio() {
        return profitSharingRatio;
    }

    public void setProfitSharingRatio(String profitSharingRatio) {
        this.profitSharingRatio = profitSharingRatio;
    }

    private String profitSharingRatio;
    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }
}
