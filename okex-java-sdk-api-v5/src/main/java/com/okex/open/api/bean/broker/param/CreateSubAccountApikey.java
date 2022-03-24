package com.okex.open.api.bean.broker.param;

public class CreateSubAccountApikey {
    private String subAcct;
    private String label;
    private String passphrase;
    private String ip;
    private String perm;

    @Override
    public String toString() {
        return "CreateSubAccountApikey{" +
                "subAcct='" + subAcct + '\'' +
                ", label='" + label + '\'' +
                ", passphrase='" + passphrase + '\'' +
                ", ip='" + ip + '\'' +
                ", perm='" + perm + '\'' +
                '}';
    }

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

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }
}
