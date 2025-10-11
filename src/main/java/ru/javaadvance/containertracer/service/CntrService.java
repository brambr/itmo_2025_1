package ru.javaadvance.containertracer.service;

import ru.javaadvance.containertracer.repository.entity.Cntr;

import java.util.List;

public interface CntrService {
    List<Cntr> findAll();

    Cntr create(Cntr cntr);

    void delete(Long id);

    void update(Cntr cntr);
}

