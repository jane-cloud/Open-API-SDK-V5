package com.okex.open.api.enums;


public enum AlgorithmEnum {

    HMAC_SHA256("HmacSHA256"),
    MD5("MD5"),;

    private String algorithm;

    AlgorithmEnum(String algorithm) {
        this.algorithm = algorithm;
    }

    public String algorithm() {
        return algorithm;
    }
}
