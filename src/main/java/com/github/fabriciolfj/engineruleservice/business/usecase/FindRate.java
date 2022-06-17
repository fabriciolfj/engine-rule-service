package com.github.fabriciolfj.engineruleservice.business.usecase;

import com.github.fabriciolfj.engineruleservice.business.FindRules;
import com.github.fabriciolfj.engineruleservice.commands.RuleRateCommand;
import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.exceptions.BusinessRateNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record FindRate(
        @Qualifier("validationRateScore")
        ValidationRate validation, FindRules findRules) {

    public RuleRate execute(final RuleRateCommand command) {
        log.info("Find rate to command: {}", command);

        var rules = findRules.find(command.birthday());

        if (rules.isEmpty()) {
            throw new BusinessRateNotFoundException();
        }

        return validation.execute(rules, command);
    }
}
