package io.gentjankolicaj.data.commons.enums.nasa.power;

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
