package com.github.fabriciolfj.engineruleservice.infrastructure.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record RuleRateRequest(
        @JsonProperty("date_minimum")
        @NotNull(message = "{rulerate.dataminimum}")
        @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate dateMinimum,
        @JsonProperty("date_maximum")
        @JsonFormat(pattern="yyyy-MM-dd")
        @NotNull(message = "{rulerate.datamaximum}")
        LocalDate dateMaximum,
        @JsonProperty("value_minimum")
        @NotNull(message = "{rulerate.valueminimum}")
        BigDecimal valueMinimum,
        @JsonProperty("value_maximum")
        @NotNull(message = "{rulerate.valuemaximum}")
        BigDecimal valueMaximum,
        @NotNull(message = "{rulerate.rate}")
        @JsonProperty("rate")
        BigDecimal rate,
        @JsonProperty("score_minimum")
        @NotNull(message = "{rulerate.scoreminimum}")
        Integer scoreMinimum,
        @JsonProperty("score_maximum")
        @NotNull(message = "{rulerate.scoremaximum}")
        Integer scoreMaximum,
        @NotNull(message = "{rulerate.withdraw}")
        Integer withdraw
) {
}
