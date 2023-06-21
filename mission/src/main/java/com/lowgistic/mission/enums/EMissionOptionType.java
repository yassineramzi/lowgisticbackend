package com.lowgistic.mission.enums;

public enum EMissionOptionType {
    WAREHOUSE("WAREHOUSE"),
    FREIGHT("FREIGHT");

    private final String value;

    EMissionOptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EMissionOptionType fromValue(String value) {
        for (EMissionOptionType optionType : EMissionOptionType.values()) {
            if (optionType.value.equals(value)) {
                return optionType;
            }
        }
        throw new IllegalArgumentException("Invalid mission option type: " + value);
    }
}
