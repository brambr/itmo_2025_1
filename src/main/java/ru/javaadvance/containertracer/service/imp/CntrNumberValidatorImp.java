package ru.javaadvance.containertracer.service.imp;

import org.springframework.stereotype.Service;
import ru.javaadvance.containertracer.service.CntrNumberValidator;

@Service
public class CntrNumberValidatorImp implements CntrNumberValidator {
    @Override
    public boolean isValid(String cntrNumber) {
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
