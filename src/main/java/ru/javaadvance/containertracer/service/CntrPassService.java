package ru.javaadvance.containertracer.service;

import ru.javaadvance.containertracer.repository.entity.CntrPass;


import java.util.List;

public interface CntrPassService {
    List<CntrPass> findAll();

    CntrPass findById(Long id);

    CntrPass create(CntrPass cntrPass);

    void delete(Long id);

    void update(CntrPass map);
}
