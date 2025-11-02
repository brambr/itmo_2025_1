package ru.javaadvance.containertracer.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.javaadvance.containertracer.validators.imp.LocationCoordinateValidationImp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LocationCoordinateValidationImp.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LocationCoordinateValidation {
    String message() default "wrong format of coordinate.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
