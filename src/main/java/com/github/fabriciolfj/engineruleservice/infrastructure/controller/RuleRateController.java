package com.github.fabriciolfj.engineruleservice.infrastructure.controller;

import com.github.fabriciolfj.engineruleservice.business.usecase.CreateRuleRate;
import com.github.fabriciolfj.engineruleservice.infrastructure.converter.RuleRateDtoConverter;
import com.github.fabriciolfj.engineruleservice.infrastructure.dto.request.RuleRateRequest;
import com.github.fabriciolfj.engineruleservice.infrastructure.dto.response.RuleRateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/rulerates")
@RestController
@RequiredArgsConstructor
public class RuleRateController {

    private final CreateRuleRate createRuleRate;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody final RuleRateRequest request) {
        var domain = RuleRateDtoConverter.toDomain(request);
        createRuleRate.execute(domain);
    }

}
