package com.okex.open.api.enums;

public enum HttpHeadersEnum {

    OK_ACCESS_KEY("OK-ACCESS-KEY"),
    OK_ACCESS_SIGN("OK-ACCESS-SIGN"),
    OK_ACCESS_TIMESTAMP("OK-ACCESS-TIMESTAMP"),
    OK_ACCESS_PASSPHRASE("OK-ACCESS-PASSPHRASE"),
    x_simulated_trading("x-simulated-trading"),


    OK_BEFORE("OK-BEFORE"),
    OK_AFTER("OK-AFTER"),
    OK_LIMIT("OK-LIMIT"),
    OK_FROM("OK-FROM"),
    OK_TO("OK-TO");

    private final String header;

    HttpHeadersEnum(final String header) {
        this.header = header;
    }

    public String header() {
        return this.header;
    }
}
