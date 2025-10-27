package ru.javaadvance.containertracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.javaadvance.containertracer.repository.entity.Cntr;
import ru.javaadvance.containertracer.repository.entity.CntrPass;

public interface CntrPassRepository extends JpaRepository<CntrPass, Long> {
    //CntrPass findByCntrId(@Param("cntr_id") String cntrId);

}
