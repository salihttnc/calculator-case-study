package com.coin.calculator.service;

import com.coin.calculator.entity.Currency;
import com.coin.calculator.entity.enums.CurrencyType;
import com.coin.calculator.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
@Slf4j
public class InitializerService implements CommandLineRunner {

    private final CurrencyRepository currencyRepository;

    @Override
    public void run(String... args) {
        if (currencyRepository.findAll().isEmpty()) {

            log.info("[InitializerService ] Initializing currencies");
            currencyRepository.saveAll(Arrays.asList(
                    new Currency("USD", CurrencyType.DIGITAL),
                    new Currency("EUR", CurrencyType.DIGITAL),
                    new Currency("BTC", CurrencyType.CRYPTO),
                    new Currency("ETH", CurrencyType.CRYPTO)));
        }
    }
}
