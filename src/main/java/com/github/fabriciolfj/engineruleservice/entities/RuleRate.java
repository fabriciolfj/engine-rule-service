package com.github.fabriciolfj.engineruleservice.entities;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record RuleRate(
        LocalDate dateMinimum,
        LocalDate dateMaximum,
        BigDecimal valueMinimum,
        BigDecimal valueMaximum,
        BigDecimal rate,
        Integer scoreMinimum,
        Integer scoreMaximum,
        Integer withdraw) {

    private static final Integer VALUE_COMPARATOR = 0;

    public boolean isValueValid(final BigDecimal value) {
        return valueMinimum.compareTo(value) >= VALUE_COMPARATOR && valueMaximum.compareTo(value) <= VALUE_COMPARATOR;
    }

    public boolean isScoreValid(final Integer value) {
        return value >= scoreMinimum  && value <= scoreMaximum;
    }
}
