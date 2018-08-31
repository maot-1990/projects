package com.pers.util.enums;

public enum RepaymentModeEnum {

    DAILY_INTEREST_LSBQ("1","按日计息，利随本清"),
    MONTH_INTEREST_LSBQ("2","按月计息，利随本清"),
    DAILY_INTEREST_XXHB("3","按日计息，先息后本"),
    MONTH_INTEREST_XXHB("4","按月计息，先息后本"),
    MONTH_INTEREST_DEBX("5","按月计息，等额本息"),
    MONTH_INTEREST_DEBJ("6","按月计息，等额本金"),
    DAILY_INTEREST_SJSH("7","按日计息，随借随还");

    private String code;
    private String value;

    RepaymentModeEnum(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
