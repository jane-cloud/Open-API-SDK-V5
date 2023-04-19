package com.okex.open.api.bean.recurringTrading;

import java.util.List;

public class RecurringAlgoOrder {
    private String stgyName;
    private List<Recurring> recurringList;
    private String period;
    private String recurringDay;
    private String recurringTime;
    private String timeZone;
    private String amt;
    private String investmentCcy;
    private String tdMode;
    private String algoClOrdId;

    public String getStgyName() {
        return stgyName;
    }

    public void setStgyName(String stgyName) {
        this.stgyName = stgyName;
    }

    public List<Recurring> getRecurringList() {
        return recurringList;
    }

    public void setRecurringList(List<Recurring> recurringList) {
        this.recurringList = recurringList;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRecurringDay() {
        return recurringDay;
    }

    public void setRecurringDay(String recurringDay) {
        this.recurringDay = recurringDay;
    }

    public String getRecurringTime() {
        return recurringTime;
    }

    public void setRecurringTime(String recurringTime) {
        this.recurringTime = recurringTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getInvestmentCcy() {
        return investmentCcy;
    }

    public void setInvestmentCcy(String investmentCcy) {
        this.investmentCcy = investmentCcy;
    }

    public String getTdMode() {
        return tdMode;
    }

    public void setTdMode(String tdMode) {
        this.tdMode = tdMode;
    }

    public String getAlgoClOrdId() {
        return algoClOrdId;
    }

    public void setAlgoClOrdId(String algoClOrdId) {
        this.algoClOrdId = algoClOrdId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;
}
