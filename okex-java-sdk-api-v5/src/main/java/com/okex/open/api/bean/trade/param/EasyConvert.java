package com.okex.open.api.bean.trade.param;

import java.util.List;

public class EasyConvert {
    private List<String> fromCcy;
    private String toCcy;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private String source;

    public List<String> getFromCcy() {
        return fromCcy;
    }

    public void setFromCcy(List<String> fromCcy) {
        this.fromCcy = fromCcy;
    }

    public String getToCcy() {
        return toCcy;
    }

    public void setToCcy(String toCcy) {
        this.toCcy = toCcy;
    }
}
