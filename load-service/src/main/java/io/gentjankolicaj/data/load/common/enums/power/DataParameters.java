package io.gentjankolicaj.data.load.common.enums.power;

public enum DataParameters {

    T2M("T2M"), T10M("T10M"), PS("PS");


    private String value;

    private DataParameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
