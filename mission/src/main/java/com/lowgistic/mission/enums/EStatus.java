package com.lowgistic.mission.enums;

public enum EStatus {
    DRAFT("DRAFT"),
    SUBMITTED("SUBMITTED"),
    VALIDATED("VALIDATED");

    private final String value;

    EStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EStatus fromValue(String value) {
        for (EStatus status : EStatus.values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status type: " + value);
    }
}
