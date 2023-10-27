package com.okex.open.api.bean.copytrading.param;

public class CloseSubposition {
    private String subPosId;
    private String tpTriggerPx;
    private String slTriggerPx;

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

    private String tpTriggerPxType;
    private String slTriggerPxType;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;
    public String getSubPosId() {
        return subPosId;
    }

    public void setSubPosId(String subPosId) {
        this.subPosId = subPosId;
    }
}
