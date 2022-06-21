package com.okex.open.api.bean.funding.param;

import java.util.ArrayList;

public class ConvertDustAssets {


    public ArrayList<String> getCcy() {
        return ccy;
    }

    public void setCcy(ArrayList<String> ccy) {
        this.ccy = ccy;
    }

    private ArrayList<String> ccy;

}
