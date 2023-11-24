package com.okex.open.api.bean.earn.param;

public class Redeem {
    private String ordId;
    private String protocolType;
    private String allowEarlyRedeem;

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    private String amt;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getAllowEarlyRedeem() {
        return allowEarlyRedeem;
    }

    public void setAllowEarlyRedeem(String allowEarlyRedeem) {
        this.allowEarlyRedeem = allowEarlyRedeem;
    }
}
