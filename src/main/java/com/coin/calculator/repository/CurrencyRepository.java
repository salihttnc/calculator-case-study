package com.coin.calculator.repository;

import com.coin.calculator.entity.Currency;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Cacheable(value = "currencies", key = "#root.methodName")
    List<Currency> findAll();

    @Override
    @CacheEvict(value = "currencies", allEntries = true)
    <S extends Currency> S save(S entity);

    Optional<Currency> findByName(String name);
}

