package com.okex.open.api.bean.subAccount.param;

public class CreateSubAccountApikey {
    private String pwd;
    private String subAcct;
    private String label;
    private String Passphrase;
    private String perm;
    private String ip;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPassphrase() {
        return Passphrase;
    }

    public void setPassphrase(String passphrase) {
        Passphrase = passphrase;
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

    @Override
    public String toString() {
        return "CreateSubAccountApikey{" +
                "pwd='" + pwd + '\'' +
                ", subAcct='" + subAcct + '\'' +
                ", label='" + label + '\'' +
                ", Passphrase='" + Passphrase + '\'' +
                ", perm='" + perm + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
