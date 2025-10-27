package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.javaadvance.containertracer.validators.CntrNumberVal;

@NoArgsConstructor
public class CntrDto {

    private Long id;
    @CntrNumberVal(message = "Номер контейнера некоректный")
    private String number;
    private String iso;
    private String size;
    private String type;
    private Integer tareWeight;
    private Integer maxPayLoad;

    public CntrDto(String number, String iso, String size, String type, Integer tareWeight, Integer maxPayLoad) {
        this.number = number;
        this.iso = iso;
        this.size = size;
        this.type = type;
        this.tareWeight = tareWeight;
        this.maxPayLoad = maxPayLoad;
    }
}
