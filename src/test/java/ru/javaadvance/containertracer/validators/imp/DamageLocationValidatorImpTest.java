package ru.javaadvance.containertracer.validators.imp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка месторасположения повреждения на контейнере")
public class DamageLocationValidatorImpTest {
    private final DamageLocationValidatorImp damageLocationValidatorImp = new DamageLocationValidatorImp();

    @Test
    @DisplayName("Проверка месторасположения повреждения на контейнере-позитивный ")
    public void testIsDamageLocationOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isDamageLocationOkMethod = DamageLocationValidatorImp.class.getDeclaredMethod("isDamageLocationOk", Integer.class);
        isDamageLocationOkMethod.setAccessible(true);
        boolean result = (boolean) isDamageLocationOkMethod.invoke(damageLocationValidatorImp, 11);
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка месторасположения повреждения на контейнере-негативный ")
    public void testIsDamageLocationNotOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isDamageLocationOkMethod = DamageLocationValidatorImp.class.getDeclaredMethod("isDamageLocationOk", Integer.class);
        isDamageLocationOkMethod.setAccessible(true);
        boolean result = (boolean) isDamageLocationOkMethod.invoke(damageLocationValidatorImp, 1);
        assertFalse(result);
    }
}
