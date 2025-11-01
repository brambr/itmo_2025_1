package ru.javaadvance.containertracer.validators.imp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.javaadvance.containertracer.validators.DamageLocationValidator;


public class DamageLocationValidatorImp implements ConstraintValidator <DamageLocationValidator, Integer>{

    @Override
    public void initialize(DamageLocationValidator damageLocationValidator) {
        ConstraintValidator.super.initialize(damageLocationValidator);
    }

    @Override
    public boolean isValid(Integer location, ConstraintValidatorContext cxt) {
      if(isDamageLocationOk(location)){
          return true;
      }
      else{
          return false;
      }
    }
    private boolean isDamageLocationOk(Integer location){

        if (location == null || String.valueOf(location).length() != 2) {
            return  false;
        }
        if(!Character.isDigit(String.valueOf(location).charAt(0))||!Character.isDigit(String.valueOf(location).charAt(1))){
            return false;
        }
        return true;
    }
}
