package com.github.fabriciolfj.engineruleservice.exceptions;

import com.github.fabriciolfj.engineruleservice.exceptions.enums.Errors;

public class BusinessRateExistsException extends RuntimeException {

    public BusinessRateExistsException() {
        super(Errors.ERROR_02.getMessage());
    }
}
