package com.github.fabriciolfj.engineruleservice.business.usecase.validation;

import com.github.fabriciolfj.engineruleservice.business.usecase.ValidationRate;
import com.github.fabriciolfj.engineruleservice.commands.RuleRateCommand;
import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.exceptions.BusinessRateNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Qualifier("validationRvalidationRateScoreateScore")
public class ValidationRateScore implements ValidationRate {

    @Override
    public RuleRate execute(final List<RuleRate> rules, final RuleRateCommand command) {
        log.info("Validation score to command: {}", command);
        return rules.stream()
                .filter(r -> r.isScoreValid(command.score()))
                .findAny()
                .orElseThrow(() -> new BusinessRateNotFoundException());
    }
}
