package com.github.fabriciolfj.engineruleservice.interfaceadapter.repository.rulerate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Table(name = "rules_rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleRateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_minimum", columnDefinition = "DATE", nullable = false)
    private LocalDate dateMinimum;
    @Column(name = "date_maximum", columnDefinition = "DATE", nullable = false)
    private LocalDate dateMaximum;
    @Column(name = "value_minimum", nullable = false)
    private BigDecimal valueMinimum;
    @Column(name = "value_maximum", nullable = false)
    private BigDecimal valueMaximum;
    @Column(name = "rate", nullable = false)
    private BigDecimal rate;
    @Column(name = "score_minimum", nullable = false)
    private Integer scoreMinimum;
    @Column(name = "score_maximum", nullable = false)
    private Integer scoreMaximum;
}
