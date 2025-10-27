package ru.javaadvance.containertracer.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.javaadvance.containertracer.repository.entity.Cntr;

import java.util.List;

public interface CntrService {
    List<Cntr> findAll();

    Cntr findById(Long id);

    Cntr findByNumber(String number);

    Cntr create(Cntr cntr);

    void delete(Long id);

    void update(Cntr cntr);
}

