package com.okex.open.api.bean.trade.param;

import java.util.List;

public class OneClickRepay {
    private List<String> debtCcy;
    private String repayCcy;

    public List<String> getRepayCcyList() {
        return repayCcyList;
    }

    public void setRepayCcyList(List<String> repayCcyList) {
        this.repayCcyList = repayCcyList;
    }

    public String getDebtCcy_v2() {
        return debtCcy_v2;
    }

    public void setDebtCcy_v2(String debtCcy_v2) {
        this.debtCcy_v2 = debtCcy_v2;
    }

    private List<String> repayCcyList;
    private String debtCcy_v2;

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
