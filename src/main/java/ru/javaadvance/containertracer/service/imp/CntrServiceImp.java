package ru.javaadvance.containertracer.service.imp;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.repository.CntrRepository;
import ru.javaadvance.containertracer.service.CntrNumberValidator;
import ru.javaadvance.containertracer.service.CntrService;
import ru.javaadvance.containertracer.validators.Validator;

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
        try {
            Validator.validateCntr(cntr);
            System.out.println("Container number is valid!");
            cntr.setNumber(cntr.getNumber().toUpperCase());
            return cntrRepository.save(cntr);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.out.println("Container number is not valid: " + ex.getMessage());
        }
        return null;
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
            Validator.validateCntr(cntrIn);
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
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
