package ru.javaadvance.containertracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.javaadvance.containertracer.repository.entity.LegalEntity;

public interface LegalEntityRepository extends JpaRepository<LegalEntity,Long> {

    LegalEntity findByInn(@Param("inn") Integer inn);
    LegalEntity findByOgrn(@Param("ogrn") Integer ogrn);
}
