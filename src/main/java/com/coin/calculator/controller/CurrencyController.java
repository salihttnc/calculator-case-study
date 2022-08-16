package com.coin.calculator.controller;

import com.coin.calculator.dto.CurrencyDTO;
import com.coin.calculator.entity.Currency;
import com.coin.calculator.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
@Slf4j
public class CurrencyController {

    private final CurrencyService currencyService;


    @GetMapping()
    public ResponseEntity<List<Currency>> getAllCurrencies() {

        log.info("[CurrencyController - getAllCurrencies] get all currency");
        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }

    @PostMapping()
    public ResponseEntity<CurrencyDTO> saveCurrency(@RequestBody @Valid CurrencyDTO currency) {

        log.info("[CurrencyController - saveCurrency]Saving currency {}", currency);
        return ResponseEntity.ok(currencyService.saveCurrency(currency));
    }
}
