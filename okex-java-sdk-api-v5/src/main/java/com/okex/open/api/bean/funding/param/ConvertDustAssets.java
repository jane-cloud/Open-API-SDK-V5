package com.okex.open.api.bean.funding.param;

public class ConvertDustAssets {
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    private String ccy;
    @Override
    public String toString() {
        return "ConvertDustAssets{" +
                "ccy='" + ccy + '\'' +
                '}';
    }
}
