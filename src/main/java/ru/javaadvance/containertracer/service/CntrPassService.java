package ru.javaadvance.containertracer.service;

import org.springframework.transaction.annotation.Transactional;
import ru.javaadvance.containertracer.repository.entity.CntrPass;
import ru.javaadvance.containertracer.repository.entity.Location;


import java.util.List;

public interface CntrPassService {
    List<CntrPass> findAll();

    CntrPass findById(Long id);


    @Transactional(readOnly = true)
    CntrPass findByCntrNumber(Long id);

    CntrPass findByCntrNumber(String number);

    CntrPass create(CntrPass cntrPass);

    void delete(Long id);

    void update(CntrPass map);


}
