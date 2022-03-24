package com.okex.open.api.bean.broker.param;

public class DeleteSubAccountApikey {
    private String subAcct;
    private String apiKey;

    @Override
    public String toString() {
        return "DeleteSubAccountApikey{" +
                "subAcct='" + subAcct + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }

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
}
