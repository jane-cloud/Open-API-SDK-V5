package com.okex.open.api.bean.account.param;

import java.math.BigDecimal;

public class Withdraw {
    private String amount;

    private String currency;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    private String destination;

    private String to_address;

    private String trade_pwd;

    private String fee;

    private String tag;



    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTrade_pwd() {
        return trade_pwd;
    }

    public void setTrade_pwd(String trade_pwd) {
        this.trade_pwd = trade_pwd;
    }



    public String getTo_address() {
        return to_address;
    }

    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
