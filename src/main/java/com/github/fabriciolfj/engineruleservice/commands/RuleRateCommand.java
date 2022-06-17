package com.github.fabriciolfj.engineruleservice.commands;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RuleRateCommand(LocalDate birthday, BigDecimal value, Integer score) { }
