package com.github.fabriciolfj.engineruleservice.business.usecase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateRuleLoan {

    @Value("${loan}")
    private BigDecimal percentage;

    public BigDecimal execute(final BigDecimal value) {
        return value.multiply(percentage);
    }
}
