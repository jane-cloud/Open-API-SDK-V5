package com.okex.open.api.bean.funding.param;

public class RcvrInfo {

    private String walletType;

    private String exchId;
    private String rcvrFirstName;

    private String rcvrLastName;
    private String rcvrCountry;

    private String rcvrCountrySubDivision;
    private String rcvrTownName;

    public String getRcvrStreetName() {
        return rcvrStreetName;
    }

    public void setRcvrStreetName(String rcvrStreetName) {
        this.rcvrStreetName = rcvrStreetName;
    }

    public String getRcvrTownName() {
        return rcvrTownName;
    }

    public void setRcvrTownName(String rcvrTownName) {
        this.rcvrTownName = rcvrTownName;
    }

    public String getRcvrCountrySubDivision() {
        return rcvrCountrySubDivision;
    }

    public void setRcvrCountrySubDivision(String rcvrCountrySubDivision) {
        this.rcvrCountrySubDivision = rcvrCountrySubDivision;
    }

    public String getRcvrCountry() {
        return rcvrCountry;
    }

    public void setRcvrCountry(String rcvrCountry) {
        this.rcvrCountry = rcvrCountry;
    }

    public String getRcvrLastName() {
        return rcvrLastName;
    }

    public void setRcvrLastName(String rcvrLastName) {
        this.rcvrLastName = rcvrLastName;
    }

    public String getRcvrFirstName() {
        return rcvrFirstName;
    }

    public void setRcvrFirstName(String rcvrFirstName) {
        this.rcvrFirstName = rcvrFirstName;
    }

    public String getExchId() {
        return exchId;
    }

    public void setExchId(String exchId) {
        this.exchId = exchId;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    private String rcvrStreetName;

}
