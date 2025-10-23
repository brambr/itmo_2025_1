package ru.javaadvance.containertracer.service;

import ru.javaadvance.containertracer.repository.entity.LegalEntity;

import java.util.List;

public interface LegalEntityService {
    List<LegalEntity> findAll();

    LegalEntity findById(Long id);

    LegalEntity create(LegalEntity legalEntity);

    void delete(Long id);

    void update(LegalEntity  legalEntity);
}
