package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "damages")
@Data
public class Damage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code;
    private String description;
    private Integer location;
    @Column(name = "size_in_cm")
    private Integer sizeInCm;

}
