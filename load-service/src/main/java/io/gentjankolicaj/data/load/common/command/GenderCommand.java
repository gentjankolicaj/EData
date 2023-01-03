package io.gentjankolicaj.data.load.common.command;

public enum GenderCommand {

    M("M"), F("F"), O("O");

    private String value;

    private GenderCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
