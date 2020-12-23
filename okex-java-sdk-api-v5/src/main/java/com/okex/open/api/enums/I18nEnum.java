package com.okex.open.api.enums;

public enum I18nEnum {
    ENGLISH("en_US"),
    SIMPLIFIED_CHINESE("zh_CN"),
    //zh_TW || zh_HK
    TRADITIONAL_CHINESE("zh_HK"),;

    private String i18n;

    I18nEnum(String i18n) {
        this.i18n = i18n;
    }

    public String i18n() {
        return i18n;
    }
}
