package com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.dto;

import java.math.BigDecimal;

public record RuleRateResetResponseDTO(BigDecimal rate, Integer withdraw, String account) {
}
