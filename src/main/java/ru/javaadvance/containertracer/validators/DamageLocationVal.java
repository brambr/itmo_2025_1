package ru.javaadvance.containertracer.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DamageLocationValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DamageLocationVal {
    String message() default "Invalid format of damage location";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
