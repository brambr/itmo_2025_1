package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cntr_pass")
@Data
public class CntrPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cntr_id")
    private Cntr cntr;
    @OneToMany(mappedBy = "cntrPassId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Damage> damage;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "legal_entity_id")
    private LegalEntity legalEntity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name="start_operation_date")
    private LocalDate startOperationDate;
    @Column(name="end_operation_date")
    private LocalDate endOperationDate;


}
