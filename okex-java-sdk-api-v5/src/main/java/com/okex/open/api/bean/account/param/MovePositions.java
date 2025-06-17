package com.okex.open.api.bean.account.param;

import java.util.ArrayList;
import java.util.List;

public class MovePositions {
    private String fromAcct;
    private String toAcct;
    private List<Legs> legs;
    private String clientId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFromAcct() {
        return fromAcct;
    }

    public void setFromAcct(String fromAcct) {
        this.fromAcct = fromAcct;
    }

    public String getToAcct() {
        return toAcct;
    }

    public void setToAcct(String toAcct) {
        this.toAcct = toAcct;
    }

    public List<Legs> getLegs() {
        return legs;
    }

    public void setLegs(List<Legs> legs) {
        this.legs = legs;
    }

}
