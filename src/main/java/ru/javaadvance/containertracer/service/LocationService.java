package ru.javaadvance.containertracer.service;

import ru.javaadvance.containertracer.repository.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();

    Location findById(Long id);

    Location create(Location location);

    void delete(Long id);

    void update(Location  location);
}
