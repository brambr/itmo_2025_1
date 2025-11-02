package ru.javaadvance.containertracer.controler.dto;

import lombok.Getter;
import lombok.Setter;
import ru.javaadvance.containertracer.validators.LocationCoordinateValidation;

@Getter
@Setter
public class LocationDto {
    private Long id;
    private String address;
    @LocationCoordinateValidation
    private Double latitude;
    @LocationCoordinateValidation
    private Double longitude;
}
