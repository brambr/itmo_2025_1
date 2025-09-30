package ru.javaadvance.containertracer.service.Imp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.javaadvance.containertracer.service.CntrNumberValidator;

@DisplayName("Тест класса -CntrNumberValidatorImp где: ")
public class TestCntrNumberValidatorImp {

    @DisplayName("-тест  метода isValid на Null")
    @Test
    public void testIsValidIfNumberNull() {
        String number = null;
        CntrNumberValidator validator = new CntrNumberValidatorImp();
        Assertions.assertFalse(validator.isValid(number));
    }

    @DisplayName("-тест  метода isValid если префикс не того формата")
    @Test
    public void testIsValidIfOwnerPrefixWrong() {
        String number = "CNT12345678";
        CntrNumberValidator validator = new CntrNumberValidatorImp();
        Assertions.assertFalse(validator.isValid(number));
    }

    @DisplayName("-тест  метода isValid если постфикс не того формата")
    @Test
    public void testIsValidIfOwnerPostfixWrong() {
        String number = "CNTR*345678";
        CntrNumberValidator validator = new CntrNumberValidatorImp();
        Assertions.assertFalse(validator.isValid(number));
    }

    @DisplayName("тест  метода isValid если  формат номера коректный")
    @Test
    public void testIsValidIfNumberOk() {
        String number = "CNTR123456";
        CntrNumberValidator validator = new CntrNumberValidatorImp();
        Assertions.assertFalse(validator.isValid(number));
    }
}
