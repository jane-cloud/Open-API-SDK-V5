package com.okex.open.api.bean.subAccount.param;

public class SubAccountTransfer {
    private String ccy;
    private String amt;
    private String from;
    private String to;
    private String fromSubAccount;
    private String toSubAccount;
    private Boolean loanTrans;
    private String omitPosRisk;

    @Override
    public String toString() {
        return "SubAccountTransfer{" +
                "ccy='" + ccy + '\'' +
                ", amt='" + amt + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", fromSubAccount='" + fromSubAccount + '\'' +
                ", toSubAccount='" + toSubAccount + '\'' +
                ", loanTrans=" + loanTrans +
                ", omitPosRisk='" + omitPosRisk + '\'' +
                '}';
    }

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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

    public Boolean getLoanTrans() {
        return loanTrans;
    }

    public void setLoanTrans(Boolean loanTrans) {
        this.loanTrans = loanTrans;
    }

    public String getOmitPosRisk() {
        return omitPosRisk;
    }

    public void setOmitPosRisk(String omitPosRisk) {
        this.omitPosRisk = omitPosRisk;
    }
}
