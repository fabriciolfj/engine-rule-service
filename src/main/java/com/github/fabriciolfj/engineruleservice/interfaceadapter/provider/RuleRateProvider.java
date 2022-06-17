package com.github.fabriciolfj.engineruleservice.interfaceadapter.provider;

import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.mapper.RuleRateMapper;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.repository.rulerate.RulesRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RuleRateProvider {

    private final RulesRateRepository repository;

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
