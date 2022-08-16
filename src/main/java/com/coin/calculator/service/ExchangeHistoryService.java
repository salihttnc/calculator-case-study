package com.coin.calculator.service;

import com.coin.calculator.dto.ExchangeHistoryDTO;
import com.coin.calculator.entity.ExchangeHistory;
import com.coin.calculator.repository.ExchangeHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeHistoryService {
    private final ExchangeHistoryRepository exchangeHistoryRepository;

    @Async
    public void save(ExchangeHistoryDTO exchangeHistoryDTO) {

        log.info("[ExchangeHistoryService - save] Saving exchange history {}", exchangeHistoryDTO);
        exchangeHistoryRepository.save(ExchangeHistoryDTO.toEntity(exchangeHistoryDTO));
    }

}
