package io.gentjankolicaj.data.load.common.enums.power;

public enum Identifier {

    SinglePoint("SinglePoint"),Regional("Regional"),Global("Global");

    private String value;

    private Identifier(String value){
        this.value=value;
    }


    public String getValue() {
        return value;
    }
}
