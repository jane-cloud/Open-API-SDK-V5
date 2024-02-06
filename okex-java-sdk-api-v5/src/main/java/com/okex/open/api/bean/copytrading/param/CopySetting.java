package com.okex.open.api.bean.copytrading.param;

public class CopySetting {
    private String instType;
    private String uniqueCode;
    private String copyMgnMode;
    private String copyInstIdType;
    private String instId;
    private String copyMode;
    private String copyTotalAmt;

    private String copyAmt;
    private String copyRatio;
    private String tpRatio;
    private String slRatio;

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getCopyMgnMode() {
        return copyMgnMode;
    }

    public void setCopyMgnMode(String copyMgnMode) {
        this.copyMgnMode = copyMgnMode;
    }

    public String getCopyInstIdType() {
        return copyInstIdType;
    }

    public void setCopyInstIdType(String copyInstIdType) {
        this.copyInstIdType = copyInstIdType;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getCopyMode() {
        return copyMode;
    }

    public void setCopyMode(String copyMode) {
        this.copyMode = copyMode;
    }

    public String getCopyTotalAmt() {
        return copyTotalAmt;
    }

    public void setCopyTotalAmt(String copyTotalAmt) {
        this.copyTotalAmt = copyTotalAmt;
    }

    public String getCopyAmt() {
        return copyAmt;
    }

    public void setCopyAmt(String copyAmt) {
        this.copyAmt = copyAmt;
    }

    public String getCopyRatio() {
        return copyRatio;
    }

    public void setCopyRatio(String copyRatio) {
        this.copyRatio = copyRatio;
    }

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

    public String getSlTotalAmt() {
        return slTotalAmt;
    }

    public void setSlTotalAmt(String slTotalAmt) {
        this.slTotalAmt = slTotalAmt;
    }

    public String getSubPosCloseType() {
        return subPosCloseType;
    }

    public void setSubPosCloseType(String subPosCloseType) {
        this.subPosCloseType = subPosCloseType;
    }

    private String slTotalAmt;
    private String subPosCloseType;


}
