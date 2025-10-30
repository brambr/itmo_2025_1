package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.javaadvance.containertracer.repository.entity.Cntr;
import ru.javaadvance.containertracer.repository.entity.Damage;
import ru.javaadvance.containertracer.repository.entity.LegalEntity;
import ru.javaadvance.containertracer.repository.entity.Location;
import ru.javaadvance.containertracer.validators.CntrNumberVal;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CntrPassDto {
    private Long id;
    private Cntr cntr;
    private List<Damage> damage;
    private LegalEntity legalEntity;
    private Location location;

    public CntrPassDto(Cntr cntr, List<Damage> damage, LegalEntity legalEntity, Location location) {
        this.cntr = cntr;
        this.damage = damage;
        this.legalEntity = legalEntity;
        this.location = location;
    }
}
