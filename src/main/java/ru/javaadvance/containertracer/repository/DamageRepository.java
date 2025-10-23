package ru.javaadvance.containertracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.javaadvance.containertracer.repository.entity.Damage;

public  interface DamageRepository extends JpaRepository<Damage, Long> {
    Damage findByCode(@Param("code") Integer code);
}
