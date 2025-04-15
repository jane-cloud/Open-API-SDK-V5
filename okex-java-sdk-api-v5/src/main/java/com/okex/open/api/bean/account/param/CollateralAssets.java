package com.okex.open.api.bean.account.param;

import java.util.ArrayList;
import java.util.List;

public class CollateralAssets {
    private String type;
    private String collateralEnabled;

    public List<String> getCcyList() {
        return ccyList;
    }

    public void setCcyList(List<String> ccyList) {
        this.ccyList = ccyList;
    }

    public String getCollateralEnabled() {
        return collateralEnabled;
    }

    public void setCollateralEnabled(String collateralEnabled) {
        this.collateralEnabled = collateralEnabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private List<String> ccyList;

}
