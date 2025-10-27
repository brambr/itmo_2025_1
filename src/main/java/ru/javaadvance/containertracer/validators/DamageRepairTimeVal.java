package ru.javaadvance.containertracer.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.javaadvance.containertracer.validators.imp.DamageRepairTimeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DamageRepairTimeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface DamageRepairTimeVal {
    String message() default "Repair time for damage can not be in the future.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
