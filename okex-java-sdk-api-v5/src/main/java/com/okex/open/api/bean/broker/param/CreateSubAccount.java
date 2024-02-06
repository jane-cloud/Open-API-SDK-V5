package com.okex.open.api.bean.broker.param;

public class CreateSubAccount {

    private String subAcct;
    private String label;

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    private String clientIP;

    public String getMainAcct() {
        return mainAcct;
    }

    public void setMainAcct(String mainAcct) {
        this.mainAcct = mainAcct;
    }

    private String mainAcct;


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


}
