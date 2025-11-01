package ru.javaadvance.containertracer.validators.imp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@DisplayName("Проверка формата номера контейнера")
public class CntrNumberValidatorImpTest {
    private final CntrNumberValidatorImp cntrNumberValidatorImp = new CntrNumberValidatorImp();

    @Test
    @DisplayName("Проверка формата локаци повреждения")
    public void testIsDamageLocationOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isNumberLengthOkMethod = CntrNumberValidatorImp.class.getDeclaredMethod("isNumberLengthOk", String.class);
        isNumberLengthOkMethod.setAccessible(true);
        boolean result = (boolean) isNumberLengthOkMethod.invoke(cntrNumberValidatorImp, "CNTR1234567");
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка длины номера контейнера-негативный")
    public void testIsNumberlengthNotOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isNumberLengthOkMethod = CntrNumberValidatorImp.class.getDeclaredMethod("isNumberLengthOk", String.class);
        isNumberLengthOkMethod.setAccessible(true);
        boolean result = (boolean) isNumberLengthOkMethod.invoke(cntrNumberValidatorImp, "CNTR12345678");
        assertFalse(result);
    }
    @Test
    @DisplayName("Проверка префикса  номера контейнера-позитивный")
    public void testIsPrefixOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isPrefixOkMethod = CntrNumberValidatorImp.class.getDeclaredMethod("isPrefixOk", String.class);
        isPrefixOkMethod.setAccessible(true);
        boolean result = (boolean) isPrefixOkMethod.invoke(cntrNumberValidatorImp, "CNTR1234567");
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка префикса  номера контейнера-негативный")
    public void testIsPrefixNotOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isPrefixOkMethod = CntrNumberValidatorImp.class.getDeclaredMethod("isPrefixOk", String.class);
        isPrefixOkMethod.setAccessible(true);
        boolean result = (boolean) isPrefixOkMethod.invoke(cntrNumberValidatorImp, "CNT11234567");
        assertFalse(result);
    }

    @Test
    @DisplayName("Проверка суфикса номера контейнера-позитвный")
    public void testIsSuffixOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isSuffixOkMethod = CntrNumberValidatorImp.class.getDeclaredMethod("isSuffixOk", String.class);
        isSuffixOkMethod.setAccessible(true);
        boolean result = (boolean) isSuffixOkMethod.invoke(cntrNumberValidatorImp, "CNTR1234567");
        assertTrue(result);
    }
    @Test
    @DisplayName("Проверка суфикса номера контейнера-негативный")
    public void testIsSuffixТщеOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isSuffixOkMethod = CntrNumberValidatorImp.class.getDeclaredMethod("isSuffixOk", String.class);
        isSuffixOkMethod.setAccessible(true);
        boolean result = (boolean) isSuffixOkMethod.invoke(cntrNumberValidatorImp, "CNTR123456a");
        assertFalse(result);
    }

}
