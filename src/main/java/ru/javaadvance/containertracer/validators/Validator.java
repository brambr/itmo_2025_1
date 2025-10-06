package ru.javaadvance.containertracer.validators;

import ru.javaadvance.containertracer.repository.Cntr;

import java.lang.reflect.Field;

public class Validator {

        public static void validateCntr(Cntr cntr) throws IllegalAccessException {
            Field[] fields = cntr.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(CntrNumberValidation.class)) {
                    validateCntrNumber(cntr, field);

                }
            }
        }

        private static void validateCntrNumber(Cntr cntr, Field field) throws IllegalAccessException {
            field.setAccessible(true);
            String cntrNumber = (String) field.get(cntr);
            if (cntrNumber == null || cntrNumber.length() != 11) {
                CntrNumberValidation annotation = field.getAnnotation(CntrNumberValidation.class);
                String message = annotation.message()+"- number has more than 11 symbols";
                throw new IllegalArgumentException(message);

            }
            String ownerCode = cntrNumber.substring(0, 4);
            for (char c : ownerCode.toCharArray()) {
                if (!Character.isLetter(c)) {
                    CntrNumberValidation annotation = field.getAnnotation(CntrNumberValidation.class);
                    String message = annotation.message()+"-first four symbols of number are not letters";
                    throw new IllegalArgumentException(message);
                }
            }
            String digitValue = cntrNumber.substring(4, 11);
            for (char c : digitValue.toCharArray()) {
                if (!Character.isDigit(c)) {
                    CntrNumberValidation annotation = field.getAnnotation(CntrNumberValidation.class);
                    String message = annotation.message()+" - last 7 symbols of number are not digits";
                    throw new IllegalArgumentException(message);
                }
            }

        }


    }

