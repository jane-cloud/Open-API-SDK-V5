package com.okex.open.api.bean.subAccount.param;

public class SetTransferOut {
    private String subAcct;
    private String apiKey;
    private String label;
    private String perm;
    private String ip;

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


    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
