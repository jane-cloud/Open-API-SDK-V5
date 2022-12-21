package com.okex.open.api.bean.funding.param;

public class Withdrawal {
    private String ccy;
    private String chain;
    private String amt;
    private String dest;
    private String toAddr;
    private String clientId;
    private String wdId;

    private String areaCode;

    @Override
    public String toString() {
        return "Withdrawal{" +
                "ccy='" + ccy + '\'' +
                ", chain='" + chain + '\'' +
                ", amt='" + amt + '\'' +
                ", dest='" + dest + '\'' +
                ", toAddr='" + toAddr + '\'' +
                ", clientId='" + clientId + '\'' +
                ", wdId='" + wdId + '\'' +
                ", invoice='" + invoice + '\'' +
                ", memo='" + memo + '\'' +
                ", fee='" + fee + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getWdId() {
        return wdId;
    }

    public void setWdId(String wdId) {
        this.wdId = wdId;
    }

    private String invoice;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    private String memo;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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
