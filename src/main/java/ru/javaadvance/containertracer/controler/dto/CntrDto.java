package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CntrDto {

    private Long id;
    private String number;
    private String iso;
    private String size;
    private String type;
    private Integer tareWeight;
    private Integer maxPayLoad;
}
