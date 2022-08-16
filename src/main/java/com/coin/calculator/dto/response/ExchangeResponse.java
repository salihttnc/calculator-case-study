package com.coin.calculator.dto.response;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeResponse {

    private double receiveAmount;
    private String receiveType;
    private double spendAmount;
    private Date requestDate;

}
