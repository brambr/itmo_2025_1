package ru.javaadvance.containertracer.controler.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.javaadvance.containertracer.repository.entity.Cntr;
import ru.javaadvance.containertracer.repository.entity.Damage;
import ru.javaadvance.containertracer.repository.entity.LegalEntity;
import ru.javaadvance.containertracer.repository.entity.Location;

import java.time.LocalDate;
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
    private LocalDate startOperationDate;
    private LocalDate endOperationDate;
    private Double distance;


    public CntrPassDto(Double distance, LocalDate endOperationDate, LocalDate startOperationDate, Location location, LegalEntity legalEntity, List<Damage> damage, Cntr cntr) {
        this.distance = distance;
        this.endOperationDate = endOperationDate;
        this.startOperationDate = startOperationDate;
        this.location = location;
        this.legalEntity = legalEntity;
        this.damage = damage;
        this.cntr = cntr;
    }
}
