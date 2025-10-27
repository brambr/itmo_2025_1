package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.Setter;
import ru.javaadvance.containertracer.repository.entity.Cntr;

@Getter
@Setter

public class CntrPassDto {
    private Long id;
    private Cntr cntr;

    public CntrPassDto(Cntr cntr) {
        this.cntr = cntr;
    }
}
