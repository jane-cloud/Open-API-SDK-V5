package com.okex.open.api.bean.account.param;

import java.util.ArrayList;
import java.util.List;

public class PositionBuilderGraph {
    private String inclRealPosAndEq;
    private List<SimPos> simPos;
    private List<SimAsset> simAsset;
    private String type;
    private MmrConfig mmrConfig;

    public String getInclRealPosAndEq() {
        return inclRealPosAndEq;
    }

    public void setInclRealPosAndEq(String inclRealPosAndEq) {
        this.inclRealPosAndEq = inclRealPosAndEq;
    }

    public List<SimPos> getSimPos() {
        return simPos;
    }

    public void setSimPos(List<SimPos> simPos) {
        this.simPos = simPos;
    }

    public List<SimAsset> getSimAsset() {
        return simAsset;
    }

    public void setSimAsset(List<SimAsset> simAsset) {
        this.simAsset = simAsset;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MmrConfig getMmrConfig() {
        return mmrConfig;
    }

    public void setMmrConfig(MmrConfig mmrConfig) {
        this.mmrConfig = mmrConfig;
    }
}
