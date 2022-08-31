package com.okex.open.api.bean.blockTrading.param;

import java.util.List;

public class SetQuoteProducts {
    private String instType;
    private List<Data> data;

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
