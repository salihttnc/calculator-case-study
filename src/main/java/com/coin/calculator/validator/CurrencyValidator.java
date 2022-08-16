package com.coin.calculator.validator;

import com.coin.calculator.entity.Currency;
import com.coin.calculator.exceptions.CurrencyNotFoundException;
import com.coin.calculator.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
@Configuration
public class CurrencyValidator implements ConstraintValidator<CurrencyValidation, String> {


    private String attribute;
    private final CurrencyRepository currencyRepository;

    @Override
    public void initialize(final CurrencyValidation constraintAnnotation) {
        attribute = constraintAnnotation.value()[0];

    }

    public boolean isValid(String currencyType, ConstraintValidatorContext cxt) {
        Currency currency = currencyRepository.findAll().stream().filter(x -> x.getName().equals(currencyType) && attribute.equals(x.getType().getName())).findFirst().orElseThrow(() -> new CurrencyNotFoundException("Currency not found"));
        return currency != null;
    }
}