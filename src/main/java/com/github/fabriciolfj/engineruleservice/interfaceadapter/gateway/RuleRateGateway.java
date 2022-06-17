package com.github.fabriciolfj.engineruleservice.interfaceadapter.gateway;

import com.github.fabriciolfj.engineruleservice.business.FindRules;
import com.github.fabriciolfj.engineruleservice.business.SaveRuleRate;
import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.RuleRateProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public record RuleRateGateway(RuleRateProvider provider) implements FindRules, SaveRuleRate {

    @Override
    public List<RuleRate> find(final LocalDate birthday) {
        log.info("Find rules: {}", birthday);
        return provider.findAll(birthday);
    }

    @Override
    public void save(final RuleRate ruleRate) {
        provider.save(ruleRate);
    }
}
