package com.coin.calculator.dto;

import com.coin.calculator.validator.CurrencyValidation;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeDTO {

    @Max(value = 5000, message = "Amount must be between 25 and 5000")
    @Min(value = 25, message = "Amount must be between 25 and 5000")
    @NotNull(message = "Amount cannot be empty")
    private double amount;

    @CurrencyValidation(value = {"DIGITAL"})
    @NotEmpty(message = "Currency cannot be empty")
    private String spendType;

    @CurrencyValidation(value = {"CRYPTO"})
    private String receiveType;

}
