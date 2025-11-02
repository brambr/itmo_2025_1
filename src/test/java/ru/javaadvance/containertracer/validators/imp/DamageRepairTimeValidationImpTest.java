package ru.javaadvance.containertracer.validators.imp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка времени создания повреждеия")
public class DamageRepairTimeValidationImpTest {

    private final DamageRepairTimeValidatorImp damageRepairTimeValidatorImp = new DamageRepairTimeValidatorImp();

    @Test
    @DisplayName("Проверка времени создания повреждеия-позитивный")
    public void testIsDamageRepairTimeCheckOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isDamageRepairTimeCheckOkMethod = DamageRepairTimeValidatorImp.class.getDeclaredMethod("isDamageRepairTimeCheckOk", LocalDate.class);
        isDamageRepairTimeCheckOkMethod.setAccessible(true);
        LocalDate damageRepairTime = LocalDate.of(2020, 1, 1);
        boolean result = (boolean) isDamageRepairTimeCheckOkMethod.invoke(damageRepairTimeValidatorImp, damageRepairTime);
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка времени создания повреждеия-негативный")
    public void testIsDamageRepairTimeCheckNotOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isDamageRepairTimeCheckOkMethod = DamageRepairTimeValidatorImp.class.getDeclaredMethod("isDamageRepairTimeCheckOk", LocalDate.class);
        isDamageRepairTimeCheckOkMethod.setAccessible(true);
        LocalDate damageRepairTime = LocalDate.of(3020, 1, 1);
        boolean result = (boolean) isDamageRepairTimeCheckOkMethod.invoke(damageRepairTimeValidatorImp, damageRepairTime);
        assertFalse(result);
    }
}