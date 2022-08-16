package com.coin.calculator.dto;

import com.coin.calculator.entity.Currency;
import com.coin.calculator.entity.enums.CurrencyType;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyDTO {

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotNull(message = "Currency type  can not be empty")
    private CurrencyType type;

    public static CurrencyDTO mapToDTO(Currency currency) {
        return new CurrencyDTO(currency.getName(), currency.getType());
    }
}
