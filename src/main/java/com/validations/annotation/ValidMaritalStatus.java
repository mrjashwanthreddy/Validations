package com.validations.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.TYPE}) // This applies to the CLASS, not a field
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaritalStatusValidator.class) // Links to the logic below
public @interface ValidMaritalStatus {
    String message() default "If married, partner name is required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
