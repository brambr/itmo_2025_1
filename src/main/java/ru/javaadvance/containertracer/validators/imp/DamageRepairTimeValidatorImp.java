package ru.javaadvance.containertracer.validators.imp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.javaadvance.containertracer.validators.DamageRepairTimeValidator;

import java.time.LocalDate;

public class DamageRepairTimeValidatorImp implements ConstraintValidator<DamageRepairTimeValidator, LocalDate> {

    @Override
    public void initialize(DamageRepairTimeValidator damageRepairTimeValidator) {
        ConstraintValidator.super.initialize(damageRepairTimeValidator);
    }

    @Override
    public boolean isValid(LocalDate repairDate, ConstraintValidatorContext cxt) {
        if (isDamageRepairTimeCheckOk(repairDate)) {
            return true;
        }
        else {
            return false;
        }

    }

    private boolean isDamageRepairTimeCheckOk(LocalDate damageRepairTime) {
        if (damageRepairTime == null || damageRepairTime.isAfter(LocalDate.now())) {
            return false;
        }
        return true;

    }
}