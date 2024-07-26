package com.okex.open.api.bean.account.param;

public class BorrowingOrder {
    private String ordId;
    private String reborrow;

    public String getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(String maxRate) {
        this.maxRate = maxRate;
    }

    private String maxRate;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getReborrow() {
        return reborrow;
    }

    public void setReborrow(String reborrow) {
        this.reborrow = reborrow;
    }

    public String getRenewMaxRate() {
        return renewMaxRate;
    }

    public void setRenewMaxRate(String renewMaxRate) {
        this.renewMaxRate = renewMaxRate;
    }

    private String renewMaxRate;


    @Override
    public String toString() {
        return "BorrowingOrder{" +
                "ordId='" + ordId + '\'' +
                "renewMaxRate='" + renewMaxRate + '\'' +
                "reborrow='" + reborrow + '\'' +

                '}';
    }
}
