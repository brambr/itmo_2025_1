package ru.javaadvance.containertracer.service.imp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.javaadvance.containertracer.validators.imp.CntrNumberValidatorImp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка расчета дистанции по координатам")
public class DistanceCalcImpTest {
    private final DistanceCalcImp distanceCalcImp = new DistanceCalcImp();
    @Test
    @DisplayName("Проверка расчета расстояния MSK-SPb- позитивный")
    public void testIsDistanceCalcOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isDistanceCalcOkMethod = DistanceCalcImp.class.getDeclaredMethod("calcDistance", Double.class, Double.class, Double.class, Double.class);
        isDistanceCalcOkMethod.setAccessible(true);
        Double result = (Double) isDistanceCalcOkMethod .invoke(distanceCalcImp, 55.75396,37.620393,59.939095,30.315868);
        assertEquals(634.4422854832998, result);
    }
}
