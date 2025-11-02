package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue ;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.javaadvance.containertracer.validators.LocationCoordinateValidation;


@Entity
@Table(name = "locations")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @LocationCoordinateValidation
    private Double latitude;
    @LocationCoordinateValidation
    private Double longitude;

}
