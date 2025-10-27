package ru.javaadvance.containertracer.validators.imp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.javaadvance.containertracer.validators.DamageLocationVal;


public class DamageLocationValidator implements ConstraintValidator <DamageLocationVal, Integer>{

    @Override
    public void initialize(DamageLocationVal damageLocationVal) {
        ConstraintValidator.super.initialize(damageLocationVal);
    }

    @Override
    public boolean isValid(Integer location, ConstraintValidatorContext cxt) {
        if (location == null || String.valueOf(location).length() != 2) {
            return  false;
        }
        if(!Character.isDigit(String.valueOf(location).charAt(0))||!Character.isDigit(String.valueOf(location).charAt(1))){
            return false;
        }
        return true;
    }
}
