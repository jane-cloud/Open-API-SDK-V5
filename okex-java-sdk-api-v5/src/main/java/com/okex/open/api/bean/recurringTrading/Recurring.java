package com.okex.open.api.bean.recurringTrading;

public class Recurring {
    private String ccy;
    private String algoId;

    public String getAlgoId() {
        return algoId;
    }

    public void setAlgoId(String algoId) {
        this.algoId = algoId;
    }

    public String getStgyName() {
        return stgyName;
    }

    public void setStgyName(String stgyName) {
        this.stgyName = stgyName;
    }

    private String stgyName;

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    private String ratio;
}
