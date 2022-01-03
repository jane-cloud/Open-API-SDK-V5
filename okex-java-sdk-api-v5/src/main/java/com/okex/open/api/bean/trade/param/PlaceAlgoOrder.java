package com.okex.open.api.bean.trade.param;

public class PlaceAlgoOrder {
    private String instId;
    private String tdMode;
    private String ccy;
    private String side;
    private String posSide;
    private String ordType;
    private String sz;
    private Boolean reduceOnly;
    private String tgtCcy;

    //止盈止损
    private String tpTriggerPx;
    private String tpOrdPx;
    private String slTriggerPx;
    private String slOrdPx;
    private String tpTriggerPxType;
    private String slTriggerPxType;

    //计划委托
    private String triggerPx;
    private String orderPx;

    //移动止盈止损
    private String callbackRatio;
    private String callbackSpread;
    private String activePx;

    //冰山委托
    private String pxVar;
    private String pxSpread;
    private String szLimit;
    private String pxLimit;

    //时间加权（其他参数跟冰山委托一致）
    private String timeInterval;

    public String getCallbackRatio() {
        return callbackRatio;
    }

    public void setCallbackRatio(String callbackRatio) {
        this.callbackRatio = callbackRatio;
    }

    public String getCallbackSpread() {
        return callbackSpread;
    }

    public void setCallbackSpread(String callbackSpread) {
        this.callbackSpread = callbackSpread;
    }

    public String getActivePx() {
        return activePx;
    }

    public void setActivePx(String activePx) {
        this.activePx = activePx;
    }




    public String getPxVar() {
        return pxVar;
    }

    public void setPxVar(String pxVar) {
        this.pxVar = pxVar;
    }

    public String getPxSpread() {
        return pxSpread;
    }

    public void setPxSpread(String pxSpread) {
        this.pxSpread = pxSpread;
    }

    public String getSzLimit() {
        return szLimit;
    }

    public void setSzLimit(String szLimit) {
        this.szLimit = szLimit;
    }

    public String getPxLimit() {
        return pxLimit;
    }

    public void setPxLimit(String pxLimit) {
        this.pxLimit = pxLimit;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }



    public String getTgtCcy() {
        return tgtCcy;
    }

    public void setTgtCcy(String tgtCcy) {
        this.tgtCcy = tgtCcy;
    }



    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getTdMode() {
        return tdMode;
    }

    public void setTdMode(String tdMode) {
        this.tdMode = tdMode;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getPosSide() {
        return posSide;
    }

    public void setPosSide(String posSide) {
        this.posSide = posSide;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public String getTpTriggerPx() {
        return tpTriggerPx;
    }

    public void setTpTriggerPx(String tpTriggerPx) {
        this.tpTriggerPx = tpTriggerPx;
    }

    public String getTpOrdPx() {
        return tpOrdPx;
    }

    public void setTpOrdPx(String tpOrdPx) {
        this.tpOrdPx = tpOrdPx;
    }

    public String getSlTriggerPx() {
        return slTriggerPx;
    }

    public void setSlTriggerPx(String slTriggerPx) {
        this.slTriggerPx = slTriggerPx;
    }

    public String getSlOrdPx() {
        return slOrdPx;
    }

    public void setSlOrdPx(String slOrdPx) {
        this.slOrdPx = slOrdPx;
    }

    public String getTriggerPx() {
        return triggerPx;
    }

    public void setTriggerPx(String triggerPx) {
        this.triggerPx = triggerPx;
    }

    public String getOrderPx() {
        return orderPx;
    }

    public void setOrderPx(String orderPx) {
        this.orderPx = orderPx;
    }

    public String getTpTriggerPxType() {
        return tpTriggerPxType;
    }

    public void setTpTriggerPxType(String tpTriggerPxType) {
        this.tpTriggerPxType = tpTriggerPxType;
    }

    public String getSlTriggerPxType() {
        return slTriggerPxType;
    }

    public void setSlTriggerPxType(String slTriggerPxType) {
        this.slTriggerPxType = slTriggerPxType;
    }
}
