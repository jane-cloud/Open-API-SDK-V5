package com.okex.open.api.bean.market.result;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class BinanceCandlestick {

    private Long openTime;

    private BigDecimal open;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal close;

    private BigDecimal volume;

    private Long closeTime;

    private BigDecimal quoteAssetVolume;

    private Integer numTrades;

    private BigDecimal takerBuyBaseAssetVolume;

    private BigDecimal takerBuyQuoteAssetVolume;

    private BigDecimal ignore;

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public BigDecimal getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public void setQuoteAssetVolume(BigDecimal quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public Integer getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(Integer numTrades) {
        this.numTrades = numTrades;
    }

    public BigDecimal getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(BigDecimal takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public BigDecimal getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(BigDecimal takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public BigDecimal getIgnore() {
        return ignore;
    }

    public void setIgnore(BigDecimal ignore) {
        this.ignore = ignore;
    }


}
