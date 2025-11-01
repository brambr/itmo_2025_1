package ru.javaadvance.containertracer.controler.dto;


import lombok.Getter;
import lombok.Setter;
import ru.javaadvance.containertracer.validators.DamageLocationValidator;
import ru.javaadvance.containertracer.validators.DamageRepairTimeValidator;

import java.time.LocalDate;

@Getter
@Setter
public class DamageDto {
    private Long id;
    private Integer code;
    private String description;
    @DamageLocationValidator(message = "Location code has wrong format")
    private Integer location;
    private Integer sizeInCm;
    private  String repairNumber;
    @DamageRepairTimeValidator(message = "Дата ремонта находиться в будущем")
    private LocalDate repairDate;
    private LocalDate addDate;
    private Long cntr_id;

}
