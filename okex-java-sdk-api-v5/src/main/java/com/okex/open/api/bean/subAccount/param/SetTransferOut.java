package com.okex.open.api.bean.subAccount.param;

public class SetTransferOut {
    private String subAcct;

    public Boolean getCanTransOut() {
        return canTransOut;
    }

    public void setCanTransOut(Boolean canTransOut) {
        this.canTransOut = canTransOut;
    }

    private Boolean canTransOut;

    public String getSubAcct() {
        return subAcct;
    }

    public void setSubAcct(String subAcct) {
        this.subAcct = subAcct;
    }


}
