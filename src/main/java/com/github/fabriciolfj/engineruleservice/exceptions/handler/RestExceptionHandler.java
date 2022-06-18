package com.github.fabriciolfj.engineruleservice.exceptions.handler;

import com.github.fabriciolfj.engineruleservice.exceptions.BusinessRateExistsException;
import com.github.fabriciolfj.engineruleservice.exceptions.BusinessRateNotFoundException;
import com.github.fabriciolfj.engineruleservice.exceptions.model.Error;
import com.github.fabriciolfj.engineruleservice.exceptions.model.ErrorDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(BusinessRateExistsException.class)
    public ResponseEntity<Error> handleBusinessRateExistsException(final BusinessRateExistsException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Error.builder().code(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()))
                        .message(e.getMessage()).build());
    }

    @ExceptionHandler(BusinessRateNotFoundException.class)
    public ResponseEntity<Error> handleBusinessRateNotFoundException(final BusinessRateNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Error.builder().code(String.valueOf(HttpStatus.NOT_FOUND.value()))
                        .message(e.getMessage()).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Error.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message("validação dos campos da requisição")
                        .details(mappingError(e))
                        .build());
    }

    private List<ErrorDetails> mappingError(final MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors()
                .stream().map(obj -> {
                    final String message = messageSource.getMessage(obj, LocaleContextHolder.getLocale());
                    final String name;

                    if (obj instanceof FieldError) {
                        name = ((FieldError) obj).getField();
                    } else {
                        name = obj.getObjectName();
                    }

                    return ErrorDetails
                            .builder()
                            .field(name)
                            .message(message)
                            .build();
                }).collect(Collectors.toList());
    }
}
