package com.coin.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeHistory extends BaseEntity {
    private String spendType;
    private String receiveType;
    private double amount;
    private double lastTradePrice;
}
