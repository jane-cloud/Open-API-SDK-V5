package com.okex.open.api.bean.funding.param;

public class Withdrawal {
    private String ccy;
    private String chain;
    private String amt;
    private String dest;
    private String toAddr;
    private String invoice;
    private String wdId;

    public String getWdId() {
        return wdId;
    }

    public void setWdId(String wdId) {
        this.wdId = wdId;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "ccy='" + ccy + '\'' +
                ", chain='" + chain + '\'' +
                ", amt='" + amt + '\'' +
                ", dest='" + dest + '\'' +
                ", toAddr='" + toAddr + '\'' +
                ", fee='" + fee + '\'' +
                ", wdId='" + wdId + '\'' +
                '}';
    }

    private String fee;

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getToAddr() {
        return toAddr;
    }

    public void setToAddr(String toAddr) {
        this.toAddr = toAddr;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
}
