package com.coin.calculator.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponse {

    private String symbol;
    private double price_24h;
    private double volume_24h;
    private double last_trade_price;
}
