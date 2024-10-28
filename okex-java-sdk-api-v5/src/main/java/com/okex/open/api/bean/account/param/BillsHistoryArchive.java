package com.okex.open.api.bean.account.param;

public class BillsHistoryArchive {
    private String year;

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String quarter;
}
