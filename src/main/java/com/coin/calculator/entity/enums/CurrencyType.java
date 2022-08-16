package com.coin.calculator.entity.enums;

import com.coin.calculator.exceptions.CurrencyNotFoundException;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;

public enum CurrencyType implements Serializable {
    CRYPTO("CRYPTO"),
    DIGITAL("DIGITAL");

    private final String name;

    CurrencyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonCreator
    public static CurrencyType fromString(String currencyType) {
        for (CurrencyType b : CurrencyType.values()) {
            if (b.name.equalsIgnoreCase(currencyType)) {
                return b;
            }
        }
        throw new CurrencyNotFoundException("No constant with currencyType " + currencyType + " found");
    }

}
