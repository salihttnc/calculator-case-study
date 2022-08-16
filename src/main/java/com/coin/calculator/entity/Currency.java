package com.coin.calculator.entity;

import com.coin.calculator.entity.enums.CurrencyType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Currency extends BaseEntity {

    private String name;

    private CurrencyType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return name.equals(currency.name) && type == currency.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
