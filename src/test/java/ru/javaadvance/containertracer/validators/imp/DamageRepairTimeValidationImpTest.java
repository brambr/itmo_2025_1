package ru.javaadvance.containertracer.validators.imp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
@DisplayName("Проверка времени создания повреждеия")
public class DamageRepairTimeValidationImpTest {

        private final DamageRepairTimeValidatorImp damageRepairTimeValidatorImp = new DamageRepairTimeValidatorImp();

        @Test
        @DisplayName("Проверка времени создания повреждеия-позитивный")
        public void testIsDamageRepairTimeCheckOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method isDamageLocationOkMethod = DamageLocationValidatorImp.class.getDeclaredMethod("isDamageLocationOk", Integer.class);
            isDamageLocationOkMethod.setAccessible(true);
            LocalDate damageRepairTime = LocalDate.of(2020, 1, 1);
            boolean result = (boolean) isDamageLocationOkMethod.invoke(damageRepairTimeValidatorImp, damageRepairTime);
            assertTrue(result);
        }
}
