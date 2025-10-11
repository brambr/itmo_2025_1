package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.Setter;
import ru.javaadvance.containertracer.validators.CntrNumberVal;


@Getter
@Setter
public class CntrDto {

    private Long id;
    @CntrNumberVal(message = "Номер контейнера некоректный")
    private String number;
    private String iso;
    private String size;
    private String type;
    private Integer tareWeight;
    private Integer maxPayLoad;
}
