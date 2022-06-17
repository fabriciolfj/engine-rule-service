package com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.mapper;

import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.repository.rulerate.RuleRateData;

public class RuleRateMapper {

    private RuleRateMapper() {
        throw new IllegalArgumentException();
    }

    public static RuleRate toDomain(final RuleRateData data) {
        return RuleRate.builder()
                .dateMaximum(data.getDateMaximum())
                .dateMinimum(data.getDateMinimum())
                .rate(data.getRate())
                .scoreMaximum(data.getScoreMaximum())
                .scoreMinimum(data.getScoreMinimum())
                .valueMaximum(data.getValueMaximum())
                .valueMinimum(data.getValueMinimum())
                .build();
    }

    public static RuleRateData toData(final RuleRate domain) {
        return RuleRateData
                .builder()
                .dateMaximum(domain.dateMaximum())
                .dateMinimum(domain.dateMinimum())
                .rate(domain.rate())
                .scoreMaximum(domain.scoreMaximum())
                .scoreMinimum(domain.scoreMinimum())
                .valueMaximum(domain.valueMaximum())
                .valueMinimum(domain.valueMinimum())
                .build();
    }
}
