package com.github.fabriciolfj.engineruleservice.business.usecase;

import com.github.fabriciolfj.engineruleservice.business.FindRule;
import com.github.fabriciolfj.engineruleservice.business.SaveRuleRate;
import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.exceptions.BusinessRateExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record CreateRuleRate(SaveRuleRate saveRuleRate, FindRule findRule) {

    public void execute(final RuleRate ruleRate) {
        log.info("Save rule rate {}", ruleRate);
        var rule = findRule.findRule(ruleRate);

        if (rule.isPresent()) {
            throw new BusinessRateExistsException();
        }

        saveRuleRate.save(ruleRate);
    }
}
