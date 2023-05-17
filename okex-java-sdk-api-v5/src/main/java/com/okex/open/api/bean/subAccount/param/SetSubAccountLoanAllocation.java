package com.okex.open.api.bean.subAccount.param;

import java.util.List;

public class SetSubAccountLoanAllocation {
    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public List<Alloc> getAlloc() {
        return alloc;
    }

    public void setAlloc(List<Alloc> alloc) {
        this.alloc = alloc;
    }

    private String enable;
    private List<Alloc> alloc;
}
