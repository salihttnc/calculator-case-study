package com.coin.calculator.service;

import com.coin.calculator.dto.ExchangeDTO;
import com.coin.calculator.dto.ExchangeHistoryDTO;
import com.coin.calculator.dto.response.CurrencyResponse;
import com.coin.calculator.dto.response.ExchangeResponse;
import com.coin.calculator.exceptions.CurrencyCalculateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculateService {

    @Value("${feign.path.exchange}")
    private String exchangePath;

    private final ExchangeHistoryService exchangeHistoryService;

    public ExchangeResponse calculateCurrency(ExchangeDTO exchangeDTO) {

        log.info("[CalculateService - calculateCurrency] exchange process starting... {}", exchangeDTO);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyResponse> response = restTemplate.getForEntity(exchangePath + "/exchange/tickers/" + exchangeDTO.getReceiveType() + "-" + exchangeDTO.getSpendType(), CurrencyResponse.class);
        CurrencyResponse currencyResponse = response.getBody();
        if (response.getStatusCode().is2xxSuccessful() && currencyResponse != null) {
            exchangeHistoryService.save(new ExchangeHistoryDTO(exchangeDTO.getSpendType(), exchangeDTO.getReceiveType(), exchangeDTO.getAmount(), currencyResponse.getLast_trade_price()));
            return new ExchangeResponse(currencyResponse.getLast_trade_price() / exchangeDTO.getAmount(), exchangeDTO.getReceiveType(), exchangeDTO.getAmount(), new Date());
        }
        throw new CurrencyCalculateException("Error while calculating currency");

    }
}
