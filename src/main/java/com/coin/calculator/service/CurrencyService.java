package com.coin.calculator.service;

import com.coin.calculator.dto.CurrencyDTO;
import com.coin.calculator.entity.Currency;
import com.coin.calculator.exceptions.AlreadyExistException;
import com.coin.calculator.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyService {

    private final CurrencyRepository currencyRepository;


    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public CurrencyDTO saveCurrency(CurrencyDTO currencyDTO) {

        log.info("[CurrencyService - saveCurrency]Saving currency {}", currencyDTO);
        currencyRepository.findByName(currencyDTO.getName()).ifPresent(s -> {
            throw new AlreadyExistException("This currency already exist with given name");
        });
        return CurrencyDTO.mapToDTO(currencyRepository.save(new Currency(currencyDTO.getName(), currencyDTO.getType())));
    }
}
