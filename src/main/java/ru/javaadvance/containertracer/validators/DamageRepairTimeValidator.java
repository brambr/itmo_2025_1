package ru.javaadvance.containertracer.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.javaadvance.containertracer.repository.entity.Damage;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class DamageRepairTimeValidator implements ConstraintValidator<DamageRepairTimeVal, LocalDate> {

    @Override
    public void initialize(DamageRepairTimeVal damageRepairTimeVal) {
        ConstraintValidator.super.initialize(damageRepairTimeVal);
    }
    @Override
    public boolean isValid(LocalDate repairDate, ConstraintValidatorContext cxt) {
        if (repairDate == null|| repairDate.isAfter(LocalDate.now())) {
            return false;
        }
        return true;
    }
}
