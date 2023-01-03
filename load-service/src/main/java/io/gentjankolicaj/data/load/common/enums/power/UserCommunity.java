package io.gentjankolicaj.data.load.common.enums.power;

public enum UserCommunity {

    SSE("SSE"), SB("SB"), AG("AG");

    private String value;

    UserCommunity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
