package com.github.fabriciolfj.engineruleservice.exceptions;

import com.github.fabriciolfj.engineruleservice.exceptions.enums.Errors;

public class BusinessRateNotFoundException extends RuntimeException {

    public BusinessRateNotFoundException() {
        super(Errors.ERROR_01.getMessage());
    }
}
