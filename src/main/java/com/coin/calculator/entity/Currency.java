package com.coin.calculator.entity;

import com.coin.calculator.entity.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency extends BaseEntity {

    private String name;

    private CurrencyType type;
}
