package io.gentjankolicaj.data.load.common.enums.power;

public enum  TempAverage {

    DAILY("DAILY"), INTERANNUAL("INTERANNUAL"), CLIMATOLOGY("CLIMATOLOGY");


    private String  value;

    private TempAverage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
