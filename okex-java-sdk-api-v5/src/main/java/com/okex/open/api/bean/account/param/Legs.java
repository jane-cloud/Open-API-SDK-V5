package com.okex.open.api.bean.account.param;

import java.util.List;

public class Legs {
    private To to;
    private From from;

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }
}
