package ru.javaadvance.containertracer.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.javaadvance.containertracer.validators.imp.CntrNumberValidatorImp;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CntrNumberValidatorImp.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CntrNumberValidator {
    String message() default "Invalid format of container number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
