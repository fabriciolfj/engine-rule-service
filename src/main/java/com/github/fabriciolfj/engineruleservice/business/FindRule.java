package com.github.fabriciolfj.engineruleservice.business;

import com.github.fabriciolfj.engineruleservice.entities.RuleRate;

import java.util.Optional;

public interface FindRule {

    Optional<RuleRate> findRule(final RuleRate ruleRate);
}
