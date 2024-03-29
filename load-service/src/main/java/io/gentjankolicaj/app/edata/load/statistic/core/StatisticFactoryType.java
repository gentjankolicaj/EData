package io.gentjankolicaj.app.edata.load.statistic.core;

public enum StatisticFactoryType {

    DESCRIPTIVE("DESCRIPTIVE"), INFERENTIAL("INFERENTIAL");
    private String value;

    private StatisticFactoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
