package com.coin.calculator.dto;

import com.coin.calculator.entity.ExchangeHistory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeHistoryDTO {
    private String spendType;
    private String receiveType;
    private double amount;
    private double lastTradePrice;

    public static ExchangeHistory toEntity(ExchangeHistoryDTO exchangeHistoryDTO) {
        return new ExchangeHistory(exchangeHistoryDTO.getSpendType(), exchangeHistoryDTO.getReceiveType(), exchangeHistoryDTO.getAmount(), exchangeHistoryDTO.getLastTradePrice());
    }

}
