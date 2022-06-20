package com.okex.open.api.bean.blockTrading.param;

import java.util.List;

public class CancelBatchRfqs {
    private List<String> rfqIds;
    private List<String> clRfqIds;

    public List<String> getRfqIds() {
        return rfqIds;
    }

    public void setRfqIds(List<String> rfqIds) {
        this.rfqIds = rfqIds;
    }

    public List<String> getClRfqIds() {
        return clRfqIds;
    }

    public void setClRfqIds(List<String> clRfqIds) {
        this.clRfqIds = clRfqIds;
    }
}
