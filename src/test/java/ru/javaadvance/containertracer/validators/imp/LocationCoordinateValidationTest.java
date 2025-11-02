package ru.javaadvance.containertracer.validators.imp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка формата координаты")
public class LocationCoordinateValidationTest {

    private final LocationCoordinateValidationImp locationCoordinateValidationImp = new LocationCoordinateValidationImp();
    @Test
    @DisplayName("Проверка времени создания повреждеия-позитивный")
    public void testIsLocationCoordinateOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isLocationCoordinateOkMethod = LocationCoordinateValidationImp.class.getDeclaredMethod("isLocationCoordinateOk", Double.class);
        isLocationCoordinateOkMethod.setAccessible(true);
        boolean result = (boolean) isLocationCoordinateOkMethod.invoke(locationCoordinateValidationImp, 123456789.123456);
        assertTrue(result);
    }
    @Test
    @DisplayName("Проверка времени создания повреждеия-негативный")
    public void testIsLocationCoordinateNotOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isLocationCoordinateOkMethod = LocationCoordinateValidationImp.class.getDeclaredMethod("isLocationCoordinateOk", Double.class);
        isLocationCoordinateOkMethod.setAccessible(true);
        boolean result = (boolean) isLocationCoordinateOkMethod.invoke(locationCoordinateValidationImp, 1234567890.123456);
        assertFalse(result);
    }

}
