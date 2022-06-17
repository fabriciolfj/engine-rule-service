package com.github.fabriciolfj.engineruleservice.interfaceadapter.repository.rulerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RulesRateRepository extends JpaRepository<RuleRateData, Long> {

    @Query("Select r From RuleRateData r where r.dateMinimum >= ?1 and r.scoreMaximum <= ?1")
    List<RuleRateData> findAll(final LocalDate date);
}
