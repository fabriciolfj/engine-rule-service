package com.github.fabriciolfj.engineruleservice.interfaceadapter.provider;

import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.mapper.RuleRateMapper;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.repository.rulerate.RulesRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class RuleRateProvider {

    private final RulesRateRepository repository;

    @Transactional(propagation = Propagation.NEVER)
    public Optional<RuleRate> findRule(final RuleRate ruleRate) {
        log.info("Find rule: {}", ruleRate);
        return repository.findRule(
                ruleRate.dateMaximum(),
                ruleRate.dateMinimum(),
                ruleRate.valueMaximum(),
                ruleRate.valueMinimum(),
                ruleRate.rate(),
                ruleRate.scoreMinimum(),
                ruleRate.scoreMaximum(),
                ruleRate.withdraw())
                .map(RuleRateMapper::toDomain);
    }

    @Transactional(propagation = Propagation.NEVER)
    public List<RuleRate> findAll(final LocalDate date) {
        return repository
                .findAll(date)
                .stream().map(RuleRateMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(final RuleRate ruleRate) {
        repository.save(RuleRateMapper.toData(ruleRate));
    }
}
