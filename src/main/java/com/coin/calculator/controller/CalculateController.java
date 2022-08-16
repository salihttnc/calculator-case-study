package com.coin.calculator.controller;

import com.coin.calculator.dto.ExchangeDTO;
import com.coin.calculator.dto.response.ExchangeResponse;
import com.coin.calculator.service.CalculateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculate")
@Slf4j
public class CalculateController {

    private final CalculateService calculateService;

    @PostMapping()
    public ResponseEntity<ExchangeResponse> calculateCurrency(@RequestBody @Valid ExchangeDTO exchangeDTO) {

        log.info("[CalculateController - calculateCurrency] exchange ... {}", exchangeDTO);
        return ResponseEntity.ok(calculateService.calculateCurrency(exchangeDTO));
    }

}
