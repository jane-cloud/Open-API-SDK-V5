package com.okex.open.api.bean.gridTrading.param;

public class OrderAlgo {
    private String instId;
    private String algoOrdType;
    private String maxPx;
    private String minPx;
    private String gridNum;
    private String runType;
    private String tpTriggerPx;
    private String slTriggerPx;
    private String tag;
    //现货网格
    private String quoteSz;
    private String baseSz;
    //合约网格
    private String sz;
    private String direction;
    private String lever;
    private String basePos;
    private String tpRatio;

    public String getTpRatio() {
        return tpRatio;
    }

    public void setTpRatio(String tpRatio) {
        this.tpRatio = tpRatio;
    }

    public String getSlRatio() {
        return slRatio;
    }

    public void setSlRatio(String slRatio) {
        this.slRatio = slRatio;
    }

    private String slRatio;
    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getAlgoOrdType() {
        return algoOrdType;
    }

    public void setAlgoOrdType(String algoOrdType) {
        this.algoOrdType = algoOrdType;
    }

    public String getMaxPx() {
        return maxPx;
    }

    public void setMaxPx(String maxPx) {
        this.maxPx = maxPx;
    }

    public String getMinPx() {
        return minPx;
    }

    public void setMinPx(String minPx) {
        this.minPx = minPx;
    }

    public String getGridNum() {
        return gridNum;
    }

    public void setGridNum(String gridNum) {
        this.gridNum = gridNum;
    }

    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType;
    }

    public String getTpTriggerPx() {
        return tpTriggerPx;
    }

    public void setTpTriggerPx(String tpTriggerPx) {
        this.tpTriggerPx = tpTriggerPx;
    }

    public String getSlTriggerPx() {
        return slTriggerPx;
    }

    public void setSlTriggerPx(String slTriggerPx) {
        this.slTriggerPx = slTriggerPx;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQuoteSz() {
        return quoteSz;
    }

    public void setQuoteSz(String quoteSz) {
        this.quoteSz = quoteSz;
    }

    public String getBaseSz() {
        return baseSz;
    }

    public void setBaseSz(String baseSz) {
        this.baseSz = baseSz;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public String getBasePos() {
        return basePos;
    }

    public void setBasePos(String basePos) {
        this.basePos = basePos;
    }
}
