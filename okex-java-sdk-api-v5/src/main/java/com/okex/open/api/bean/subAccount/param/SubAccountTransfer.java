package com.okex.open.api.bean.subAccount.param;

public class SubAccountTransfer {
    private String ccy;
    private String amt;
    private String form;
    private String to;
    private String fromSubAccount;
    private String toSubAccount;

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFromSubAccount() {
        return fromSubAccount;
    }

    public void setFromSubAccount(String fromSubAccount) {
        this.fromSubAccount = fromSubAccount;
    }

    public String getToSubAccount() {
        return toSubAccount;
    }

    public void setToSubAccount(String toSubAccount) {
        this.toSubAccount = toSubAccount;
    }

    @Override
    public String toString() {
        return "SubAccountTransfer{" +
                "ccy='" + ccy + '\'' +
                ", amt='" + amt + '\'' +
                ", form='" + form + '\'' +
                ", to='" + to + '\'' +
                ", fromSubAccount='" + fromSubAccount + '\'' +
                ", toSubAccount='" + toSubAccount + '\'' +
                '}';
    }
}
