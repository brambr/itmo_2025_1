package ru.javaadvance.containertracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javaadvance.containertracer.repository.entity.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
