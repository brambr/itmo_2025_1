package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue ;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


import lombok.Data;


@Entity
@Table(name = "location")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;

}
