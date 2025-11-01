package ru.javaadvance.containertracer.validators.imp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.javaadvance.containertracer.validators.CntrNumberValidator;

public class CntrNumberValidatorImp implements ConstraintValidator<CntrNumberValidator, String> {

    @Override
    public void initialize(CntrNumberValidator cntrNumberVal) {

        ConstraintValidator.super.initialize(cntrNumberVal);
    }

    @Override
    public boolean isValid(String cntrNumber, ConstraintValidatorContext cxt) {
        if (isNumberLengthOk(cntrNumber)&isPrefixOk(cntrNumber)&isSuffixOk(cntrNumber)) {
            return true;
        }
        return false;
    }
    private boolean isNumberLengthOk(String cntrNumber) {
        if (cntrNumber == null || cntrNumber.length() != 11) {
            return false;
        }
        return true;
    }
    private boolean isPrefixOk(String cntrNumber) {
        String ownerCode = cntrNumber.substring(0, 4);
        for (char c : ownerCode.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixOk(String cntrNumber) {
        String digitValue = cntrNumber.substring(4, 11);
        for (char c : digitValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }



}
