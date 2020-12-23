package com.okex.open.api.bean.other;

import java.math.BigDecimal;

public interface OrderBookItem<T> {
    String getPrice();

    T getSize();
}
