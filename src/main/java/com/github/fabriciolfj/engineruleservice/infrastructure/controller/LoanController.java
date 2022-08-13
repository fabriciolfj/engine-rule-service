package com.github.fabriciolfj.engineruleservice.infrastructure.controller;

import com.github.fabriciolfj.engineruleservice.business.usecase.CreateRuleLoan;
import com.github.fabriciolfj.engineruleservice.infrastructure.annotations.ValidValue;
import com.github.fabriciolfj.engineruleservice.infrastructure.dto.response.LoanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@Validated
@RestController
@RequestMapping("/api/v1/loan")
@RequiredArgsConstructor
public class LoanController {

    private final CreateRuleLoan createRuleLoan;

    @GetMapping("/{value}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LoanResponse findLoan(@ValidValue @PathVariable("value") final String value) {
        var result = createRuleLoan.execute(new BigDecimal(value));
        return LoanResponse.builder().value(result).build();
    }

}
