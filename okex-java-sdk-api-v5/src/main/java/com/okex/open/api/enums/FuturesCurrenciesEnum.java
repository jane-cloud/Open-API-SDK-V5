package com.okex.open.api.enums;

public enum FuturesCurrenciesEnum {

    BTC(0), LTC(1), ETH(2), ETC(4), XRP(15), EOS(20), BCH(301), BSV(302);
    private int symbol;

    FuturesCurrenciesEnum(int symbol) {
        this.symbol = symbol;
    }

    public int getSymbol() {
        return symbol;
    }
}
