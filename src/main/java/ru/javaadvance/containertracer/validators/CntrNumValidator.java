package ru.javaadvance.containertracer.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CntrNumValidator implements ConstraintValidator<CntrNumberVal, String> {

    @Override
    public void initialize(CntrNumberVal cntrNumberVal) {
        ConstraintValidator.super.initialize(cntrNumberVal);
    }

    @Override
    public boolean isValid(String cntrNumber, ConstraintValidatorContext cxt) {
        if (cntrNumber == null || cntrNumber.length() != 11) {
            return false;
        }
        String ownerCode = cntrNumber.substring(0, 4);
        for (char c : ownerCode.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        String digitValue = cntrNumber.substring(4, 11);
        for (char c : digitValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
