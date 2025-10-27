package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

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


}
