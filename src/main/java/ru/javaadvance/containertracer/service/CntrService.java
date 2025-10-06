package ru.javaadvance.containertracer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.javaadvance.containertracer.repository.Cntr;

import java.util.List;

public interface CntrService {
    List<Cntr> findAll();
    Cntr create(Cntr cntr);
    void delete(Long id);
    void update(Cntr cntr);
}

