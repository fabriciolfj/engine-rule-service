package com.github.fabriciolfj.engineruleservice.infrastructure.converter;

import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.infrastructure.dto.request.RuleRateRequest;

public class RuleRateDtoConverter {

    private RuleRateDtoConverter() {
        throw new IllegalArgumentException();
    }

    public static final RuleRate toDomain(final RuleRateRequest request) {
        return RuleRate.builder()
                .valueMinimum(request.valueMinimum())
                .valueMaximum(request.valueMaximum())
                .rate(request.rate())
                .scoreMinimum(request.scoreMinimum())
                .scoreMaximum(request.scoreMaximum())
                .dateMinimum(request.dateMinimum())
                .dateMaximum(request.dateMaximum())
                .withdraw(request.withdraw())
                .build();
    }
}
