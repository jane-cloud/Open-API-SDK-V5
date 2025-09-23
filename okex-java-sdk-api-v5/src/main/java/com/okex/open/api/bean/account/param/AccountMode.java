package com.okex.open.api.bean.account.param;

public class AccountMode {
    public String getAcctLv() {
        return acctLv;
    }

    public void setAcctLv(String acctLv) {
        this.acctLv = acctLv;
    }

    private String acctLv;

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    private String feeType;
    @Override
    public String toString() {
        return "AccountMode{" +
                "acctLv='" + acctLv + '\'' +

                '}';
    }
}
