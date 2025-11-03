package ru.javaadvance.containertracer.service;

import ru.javaadvance.containertracer.repository.entity.Location;

public interface DistanceCalc {

    Double getDistance(Location location1, Location location2);
}
