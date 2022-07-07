package com.github.fabriciolfj.engineruleservice.interfaceadapter.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fabriciolfj.engineruleservice.business.usecase.FindRate;
import com.github.fabriciolfj.engineruleservice.entities.RuleRate;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.dto.RuleRateResetRequestDTO;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.dto.RuleRateResetResponseDTO;
import com.github.fabriciolfj.engineruleservice.interfaceadapter.provider.mapper.RuleRateResetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
@Component
@Slf4j
public class ResetRuleRateListener {

    private final ObjectMapper objectMapper;
    private final FindRate findRate;

    @Bean
    public Function<String, String> resetWithdraw() {
        return msg -> {
            log.info("Message received: {}", msg);
            var value = toDto(msg);

            var rule = findRate.execute(RuleRateResetMapper.toCommand(value));
            log.info("Rule reset to: {}", rule);

            return toMsg(rule, value);
        };
    }

    private String toMsg(final RuleRate rule, final RuleRateResetRequestDTO dto) {
        try {
            var response = new RuleRateResetResponseDTO(rule.rate(), rule.withdraw(), dto.account());
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            log.error("Fail convert objecto to json, detail {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private RuleRateResetRequestDTO toDto(final String msg) {
        try {
            return objectMapper.readValue(msg, RuleRateResetRequestDTO.class);
        } catch (Exception e) {
            log.error("Fail convert msg to dto, detail {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
