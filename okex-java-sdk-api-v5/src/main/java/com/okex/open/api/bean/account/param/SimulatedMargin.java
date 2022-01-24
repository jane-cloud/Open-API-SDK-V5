package com.okex.open.api.bean.account.param;

import java.lang.reflect.Array;
import java.util.List;

public class SimulatedMargin {
    private String instType;
    private Boolean inclRealPos;
    private List<InstIdPos> simPos;

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public Boolean getInclRealPos() {
        return inclRealPos;
    }

    public void setInclRealPos(Boolean inclRealPos) {
        this.inclRealPos = inclRealPos;
    }

    public List<InstIdPos> getSimPos() {
        return simPos;
    }

    public void setSimPos(List<InstIdPos> simPos) {
        this.simPos = simPos;
    }
}
