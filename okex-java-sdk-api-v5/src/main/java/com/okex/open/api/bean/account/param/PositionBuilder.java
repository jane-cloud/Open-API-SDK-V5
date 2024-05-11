package com.okex.open.api.bean.account.param;

import java.util.List;

public class PositionBuilder {
    private String inclRealPosAndEq;
    private String spotOffsetType;
    private List<InstIdPos> simPos;

    private List<InstIdPos> simAsset;

    public String getInclRealPosAndEq() {
        return inclRealPosAndEq;
    }

    public void setInclRealPosAndEq(String inclRealPosAndEq) {
        this.inclRealPosAndEq = inclRealPosAndEq;
    }

    public String getSpotOffsetType() {
        return spotOffsetType;
    }

    public void setSpotOffsetType(String spotOffsetType) {
        this.spotOffsetType = spotOffsetType;
    }

    public List<InstIdPos> getSimPos() {
        return simPos;
    }

    public void setSimPos(List<InstIdPos> simPos) {
        this.simPos = simPos;
    }

    public List<InstIdPos> getSimAsset() {
        return simAsset;
    }

    public void setSimAsset(List<InstIdPos> simAsset) {
        this.simAsset = simAsset;
    }

    public String getGreeksType() {
        return greeksType;
    }

    public void setGreeksType(String greeksType) {
        this.greeksType = greeksType;
    }

    private String greeksType;
}
