package com.okex.open.api.bean.subAccount.param;

public class ReSetSubAccountApikey {

    private String pwd;
    private String subAcct;
    private String label;
    private String apiKey;
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

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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
        return "ReSetSubAccountApikey{" +
                "pwd='" + pwd + '\'' +
                ", subAcct='" + subAcct + '\'' +
                ", label='" + label + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", perm='" + perm + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
