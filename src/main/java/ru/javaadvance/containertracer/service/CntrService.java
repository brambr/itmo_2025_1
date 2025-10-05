package ru.javaadvance.containertracer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.javaadvance.containertracer.repository.Cntr;

import java.util.List;

public interface CntrService {
    Page<Cntr> findAll(Pageable page);

    Cntr create(Cntr cntr);

    void delete(Long id);

    void update(Cntr cntrIn);
}

