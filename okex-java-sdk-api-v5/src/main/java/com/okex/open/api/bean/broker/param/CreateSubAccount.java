package com.okex.open.api.bean.broker.param;

public class CreateSubAccount {

    private String subAcct;
    private String label;
    private String acctLv;



    public String getSubAcct() {
        return subAcct;
    }

    public void setSubAcct(String subAcct) {
        this.subAcct = subAcct;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAcctLv() {
        return acctLv;
    }

    public void setAcctLv(String acctLv) {
        this.acctLv = acctLv;
    }
}
