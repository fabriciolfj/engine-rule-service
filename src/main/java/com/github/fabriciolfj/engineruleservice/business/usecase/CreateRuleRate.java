package com.github.fabriciolfj.engineruleservice.business.usecase;

import com.github.fabriciolfj.engineruleservice.business.SaveRuleRate;
import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record CreateRuleRate(SaveRuleRate saveRuleRate) {

    public void execute(final RuleRate ruleRate) {
        log.info("Save rule rate {}", ruleRate);
        saveRuleRate.save(ruleRate);
    }
}
