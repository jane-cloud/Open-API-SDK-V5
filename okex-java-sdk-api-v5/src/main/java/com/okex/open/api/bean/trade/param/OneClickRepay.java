package com.okex.open.api.bean.trade.param;

import java.util.List;

public class OneClickRepay {
    private List<String> debtCcy;
    private String repayCcy;

    public List<String> getDebtCcy() {
        return debtCcy;
    }

    public void setDebtCcy(List<String> debtCcy) {
        this.debtCcy = debtCcy;
    }

    public String getRepayCcy() {
        return repayCcy;
    }

    public void setRepayCcy(String repayCcy) {
        this.repayCcy = repayCcy;
    }
}
