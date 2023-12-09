package com.danit.springrest.enums;
import com.fasterxml.jackson.annotation.JsonValue;


public enum Currency {
    USD("USD"),
    EUR("EUR"),
    UAH("UAH"),
    CHF("CHF"),
    GBP("GBP");
    private final String value;
    Currency(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}