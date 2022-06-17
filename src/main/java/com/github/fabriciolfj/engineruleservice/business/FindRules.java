package com.github.fabriciolfj.engineruleservice.business;

import com.github.fabriciolfj.engineruleservice.entities.RuleRate;

import java.time.LocalDate;
import java.util.List;

public interface FindRules {

    List<RuleRate> find(final LocalDate birthday);
}
