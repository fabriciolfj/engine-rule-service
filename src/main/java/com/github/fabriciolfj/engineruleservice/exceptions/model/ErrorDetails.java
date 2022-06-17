package com.github.fabriciolfj.engineruleservice.exceptions.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private String field;
    private String message;
}
