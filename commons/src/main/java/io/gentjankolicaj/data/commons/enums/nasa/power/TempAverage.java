package io.gentjankolicaj.data.commons.enums.nasa.power;

public enum TempAverage {

    DAILY("DAILY"), INTERANNUAL("INTERANNUAL"), CLIMATOLOGY("CLIMATOLOGY");


    private String value;

    private TempAverage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
