package com.github.fabriciolfj.engineruleservice.infrastructure.annotations;

import com.github.fabriciolfj.engineruleservice.infrastructure.annotations.impl.ValidValueImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidValueImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ValidValue {

    String message() default "Value invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
