package com.coin.calculator.repository;

import com.coin.calculator.entity.ExchangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeHistoryRepository extends JpaRepository<ExchangeHistory, Long> {

}
