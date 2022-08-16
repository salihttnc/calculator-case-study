package com.coin.calculator.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "exchange_history")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeHistory extends BaseEntity {
    private String spendType;
    private String receiveType;
    private double amount;
    private double lastTradePrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeHistory that = (ExchangeHistory) o;
        return Double.compare(that.amount, amount) == 0 && Double.compare(that.lastTradePrice, lastTradePrice) == 0 && spendType.equals(that.spendType) && receiveType.equals(that.receiveType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spendType, receiveType, amount, lastTradePrice);
    }
}
