package io.gentjankolicaj.data.load.common.dto;

public enum GenderDTO {

    M("M"), F("F"), O("O");

    private String value;

    private GenderDTO(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
