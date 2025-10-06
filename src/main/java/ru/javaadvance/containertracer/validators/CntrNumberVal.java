package ru.javaadvance.containertracer.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CntrNumValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CntrNumberVal {
    String message() default "Invalid format of container number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
