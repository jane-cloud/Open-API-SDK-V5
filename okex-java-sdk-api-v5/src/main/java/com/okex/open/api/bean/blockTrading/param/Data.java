package com.okex.open.api.bean.blockTrading.param;

public class Data {

    private String instId;
    private String instFamily;
    private String maxBlockSz;
    private String makerPxBand;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getInstFamily() {
        return instFamily;
    }

    public void setInstFamily(String instFamily) {
        this.instFamily = instFamily;
    }

    public String getMaxBlockSz() {
        return maxBlockSz;
    }

    public void setMaxBlockSz(String maxBlockSz) {
        this.maxBlockSz = maxBlockSz;
    }

    public String getMakerPxBand() {
        return makerPxBand;
    }

    public void setMakerPxBand(String makerPxBand) {
        this.makerPxBand = makerPxBand;
    }
}
