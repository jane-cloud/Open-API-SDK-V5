package com.okex.open.api.bean.broker.param;

public class DeleteSubAccount {
    private String pwd;
    private String subAcct;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSubAcct() {
        return subAcct;
    }

    public void setSubAcct(String subAcct) {
        this.subAcct = subAcct;
    }
}
