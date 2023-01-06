package io.gentjankolicaj.data.commons.domain;

public enum Gender {

    M("M"), F("F"), O("O");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
