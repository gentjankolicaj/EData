package io.gentjankolicaj.data.load.common.enums;

public enum InformationScope {

    ABOUT("ABOUT"),CONTACT("CONTACT"),HOME("HOME"),LOGIN("LOGIN");

    private String value;

    InformationScope(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
