package com.github.fabriciolfj.engineruleservice.interfaceadapter.repository.rulerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RulesRateRepository extends JpaRepository<RuleRateData, Long> {

    @Query("Select r From RuleRateData r where ?1 >= r.dateMinimum and ?1<= r.dateMaximum")
    List<RuleRateData> findAll(final LocalDate date);

    @Query("Select r From RuleRateData r where r.dateMaximum = ?1 " +
            "and r.dateMinimum = ?2 " +
            "and r.valueMaximum = ?3 " +
            "and r.valueMinimum = ?4 " +
            "and r.rate = ?5 " +
            "and r.scoreMinimum = ?6 " +
            "and r.scoreMaximum = ?7")
    Optional<RuleRateData> findRule(final LocalDate dateMaximum,
                                   final LocalDate dateMinimum,
                                   final BigDecimal valueMaximum,
                                   final BigDecimal valueMinimum,
                                   final BigDecimal rate,
                                   final Integer scoreMinimum,
                                   final Integer scoreMaximum,
                                   final Integer withdraw);
}
