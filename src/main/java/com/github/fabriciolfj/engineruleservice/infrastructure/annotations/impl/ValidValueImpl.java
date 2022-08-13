package com.github.fabriciolfj.engineruleservice.infrastructure.annotations.impl;

import com.github.fabriciolfj.engineruleservice.infrastructure.annotations.ValidValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.Objects;

public class ValidValueImpl implements ConstraintValidator<ValidValue, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (Objects.isNull(value) || new BigDecimal(value).compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
