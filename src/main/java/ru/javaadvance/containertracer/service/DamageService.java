package ru.javaadvance.containertracer.service;

import ru.javaadvance.containertracer.repository.entity.Damage;

import java.util.List;

public interface DamageService {
    List<Damage> findAll();

    Damage findById(Long id);

    Damage create(Damage damage);

    void delete(Long id);

    void update(Damage damage);

}
