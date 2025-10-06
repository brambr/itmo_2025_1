package ru.javaadvance.containertracer.service.imp;


import org.hibernate.InstantiationException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.repository.CntrRepository;
import ru.javaadvance.containertracer.service.CntrService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CntrServiceImp implements CntrService {
    private final CntrRepository cntrRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Cntr> findAll() {
        return cntrRepository.findAll();
    }

    @Transactional
    @Override
    public Cntr create(Cntr cntr) {
        Optional<Cntr> optionalCntr = Optional.ofNullable(cntrRepository.findByNumber(cntr.getNumber()));
        if (optionalCntr.isPresent()) {
            throw new IllegalStateException("Контейнер с таким номером уже существует");
        }
        cntr.setNumber(cntr.getNumber().toUpperCase());
        return cntrRepository.save(cntr);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if (cntrRepository.existsById(id)) {
            cntrRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Контейнер с таким ID=" + id + " отсутсвует");
        }
    }

    @Transactional
    @Override
    public void update(Cntr cntrIn) {
        try {
            Optional<Cntr> optionalCntr = cntrRepository.findById(cntrIn.getId());
            if (optionalCntr.isEmpty()) {
                throw new IllegalStateException("Контейнер с таким ID отсутсвует");
            }
            Cntr cntrOpt = optionalCntr.get();
            if (cntrIn.getNumber() != null && cntrIn.getNumber().equals(cntrOpt.getNumber())) {
                Optional<Cntr> cntrFindindByNumeber = Optional.ofNullable(cntrRepository.findByNumber(cntrIn.getNumber()));
                if (cntrFindindByNumeber.isPresent()) {
                    throw new IllegalStateException("Контейнер с таким номером уже существует");
                }
            } else {
                cntrOpt.setNumber(cntrIn.getNumber().toUpperCase());
            }
            cntrRepository.save(cntrOpt);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
