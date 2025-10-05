package ru.javaadvance.containertracer.repository;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "containers")
@Data
public class Cntr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String iso;
    private String size;
    private String type;
    @Column(name = "tare_weight")
    private Integer tareWeight;
    @Column(name = "max_payload")
    private Integer maxPayLoad;

}
