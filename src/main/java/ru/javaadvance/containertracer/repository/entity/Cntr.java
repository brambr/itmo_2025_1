package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import ru.javaadvance.containertracer.validators.CntrNumberVal;


@Entity
@Table(name = "containers")
@Data
public class Cntr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CntrNumberVal(message = "Номер контейнера не коректный")
    private String number;
    private String iso;
    private String size;
    private String type;
    @Column(name = "tare_weight")
    private Integer tareWeight;
    @Column(name = "max_payload")
    private Integer maxPayLoad;
}
