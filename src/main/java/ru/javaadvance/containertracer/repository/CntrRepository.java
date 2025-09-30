package ru.javaadvance.containertracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface  CntrRepository extends JpaRepository<Cntr, Long> {

    @Query(value = "SELECT * FROM containers WHERE number=:number", nativeQuery = true)
    Cntr findByNumber(@Param ("number")String number);
}
