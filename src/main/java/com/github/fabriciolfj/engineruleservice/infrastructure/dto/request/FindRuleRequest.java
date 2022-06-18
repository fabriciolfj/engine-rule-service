package com.github.fabriciolfj.engineruleservice.infrastructure.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fabriciolfj.engineruleservice.exceptions.annotations.ValidateFormatDate;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FindRuleRequest {
        @JsonProperty(namespace = "birthday")
        @ValidateFormatDate(message = "{findrule.date}")
        private String birthday;
        @NotNull(message = "{findrule.value}")
        private BigDecimal value;
        @NotNull(message = "{findrule.score}")
        private Integer score;
}
