package com.okex.open.api.bean.account.param;

public class SetPositionMode {

    @Override
    public String toString() {
        return "SetPositionMode{" +
                "posMode='" + posMode + '\'' +
                '}';
    }

    public String getPosMode() {
        return posMode;
    }

    public void setPosMode(String posMode) {
        this.posMode = posMode;
    }

    private String posMode;


}
