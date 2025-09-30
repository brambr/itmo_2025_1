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
    @Column(name = "number")
    private String number;
    @Column(name = "iso")
    private String iso;
    @Column(name = "size")
    private String size;
    @Column(name = "type")
    private String type;
    @Column(name = "tare_weight")
    private Integer tareWeight;
    @Column(name = "max_payload")
    private Integer maxPayLoad;



    public Cntr() {

    }
}
