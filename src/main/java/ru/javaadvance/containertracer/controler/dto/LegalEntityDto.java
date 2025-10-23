package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LegalEntityDto {
    private Long id;
    private String name;
    private Integer inn;
    private Integer ogrn;
    private Integer kpp;
}

