package com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.mapper;

import com.github.fabriciolfj.engineruleservice.commands.RuleRateCommand;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.dto.RuleRateResetRequestDTO;

import java.time.LocalDate;

public class RuleRateResetMapper {

    private RuleRateResetMapper() {

    }

    public static RuleRateCommand toCommand(final RuleRateResetRequestDTO request) {
        return new RuleRateCommand(LocalDate.parse(request.birthday()), request.value(), request.score());
    }
}
