package com.okex.open.api.bean.account.param;

public class Mmp {
    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getInstFamily() {
        return instFamily;
    }

    public void setInstFamily(String instFamily) {
        this.instFamily = instFamily;
    }

    private String instType;
    private String instFamily;

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getFrozenInterval() {
        return frozenInterval;
    }

    public void setFrozenInterval(String frozenInterval) {
        this.frozenInterval = frozenInterval;
    }

    public String getQtyLimit() {
        return qtyLimit;
    }

    public void setQtyLimit(String qtyLimit) {
        this.qtyLimit = qtyLimit;
    }

    private String timeInterval;
    private String frozenInterval;
    private String qtyLimit;

}
