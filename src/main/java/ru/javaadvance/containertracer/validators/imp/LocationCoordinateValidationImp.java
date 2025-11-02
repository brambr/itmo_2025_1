package ru.javaadvance.containertracer.validators.imp;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.javaadvance.containertracer.validators.LocationCoordinateValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class LocationCoordinateValidationImp implements ConstraintValidator<LocationCoordinateValidation, Double> {


        @Override
        public void initialize(LocationCoordinateValidation locationCoordinateValidation) {
            ConstraintValidator.super.initialize(locationCoordinateValidation);
        }

        @Override
        public boolean isValid(Double location, ConstraintValidatorContext cxt) {
            if(isLocationCoordinateOk(location)){
                return true;
            }
            else{
                return false;
            }
        }
        private boolean isLocationCoordinateOk(Double location) {
            String locationValue= String.format("%.6f", location);
            if (location == null||locationValue.length()!=16) {
            return false;
             }

            if (locationValue.indexOf(',')!=9){
                return false;
            }
            return true;
    }
}
