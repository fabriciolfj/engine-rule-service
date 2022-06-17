package com.github.fabriciolfj.engineruleservice.business.usecase;

import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.commands.RuleRateCommand;

import java.util.List;

public interface ValidationRate {

    RuleRate execute(final List<RuleRate> rules, final RuleRateCommand command);
}
