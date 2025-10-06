package ru.javaadvance.containertracer.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CntrNumberValidator implements ConstraintValidator <CntrNumberVal,String> {

    @Override
    public void initialize(CntrNumberVal cntrNumberVal) {
        ConstraintValidator.super.initialize(cntrNumberVal);
    }

    @Override
    public boolean isValid(String cntrNumber, ConstraintValidatorContext cxt) {
       if  (cntrNumber == null || cntrNumber.length() != 11) {
           return false;
       }
       if (cntrNumber.length() == 11) {
           return true;
       }
        return false;
    }
}
