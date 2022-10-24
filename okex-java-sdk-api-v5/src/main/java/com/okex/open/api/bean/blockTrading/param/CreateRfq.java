package com.okex.open.api.bean.blockTrading.param;

import java.util.List;

public class CreateRfq {
    private List<String> counterparties;
    private Boolean anonymous;
    private String  clRfqId;

    public Boolean getAllowPartialExecution() {
        return allowPartialExecution;
    }

    public void setAllowPartialExecution(Boolean allowPartialExecution) {
        this.allowPartialExecution = allowPartialExecution;
    }

    private Boolean  allowPartialExecution;
    private List<Legs> legs;

    public List<String> getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(List<String> counterparties) {
        this.counterparties = counterparties;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public String getClRfqId() {
        return clRfqId;
    }

    public void setClRfqId(String clRfqId) {
        this.clRfqId = clRfqId;
    }

    public List<Legs> getLegs() {
        return legs;
    }

    public void setLegs(List<Legs> legs) {
        this.legs = legs;
    }
}
