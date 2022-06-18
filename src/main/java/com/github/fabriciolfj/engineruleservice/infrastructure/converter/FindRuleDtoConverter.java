package com.github.fabriciolfj.engineruleservice.infrastructure.converter;

import com.github.fabriciolfj.engineruleservice.commands.RuleRateCommand;
import com.github.fabriciolfj.engineruleservice.infrastructure.dto.request.FindRuleRequest;

import java.time.LocalDate;

public class FindRuleDtoConverter {

    private FindRuleDtoConverter() { }

    public static RuleRateCommand toCommand(final FindRuleRequest request) {
        return new RuleRateCommand(LocalDate.parse(request.getBirthday()), request.getValue(), request.getScore());
    }
}
