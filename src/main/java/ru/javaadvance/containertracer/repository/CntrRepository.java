package ru.javaadvance.containertracer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface  CntrRepository extends JpaRepository<Cntr, Long> {

    Cntr findByNumber(@Param ("number")String number);
}
