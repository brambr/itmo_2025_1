package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
}
