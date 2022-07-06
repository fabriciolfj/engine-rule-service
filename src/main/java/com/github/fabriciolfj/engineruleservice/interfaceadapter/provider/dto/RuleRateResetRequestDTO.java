package com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fabriciolfj.engineruleservice.exceptions.annotations.ValidateFormatDate;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record RuleRateResetRequestDTO(
        @JsonProperty("birthday")
        @ValidateFormatDate(message = "{findrule.date}")
        String birthday,
        @NotNull(message = "{findrule.value}")
        BigDecimal value,
        @NotNull(message = "{findrule.score}")
        Integer score,
        @NotNull(message = "{findrule.account}")
        String account
) {
}
