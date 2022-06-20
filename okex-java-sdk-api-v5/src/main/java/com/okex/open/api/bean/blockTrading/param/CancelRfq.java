package com.okex.open.api.bean.blockTrading.param;

public class CancelRfq {
    private String rfqId;
    private String clRfqId;

    public String getRfqId() {
        return rfqId;
    }

    public void setRfqId(String rfqId) {
        this.rfqId = rfqId;
    }

    public String getClRfqId() {
        return clRfqId;
    }

    public void setClRfqId(String clRfqId) {
        this.clRfqId = clRfqId;
    }
}
