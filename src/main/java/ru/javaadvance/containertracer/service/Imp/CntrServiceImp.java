package ru.javaadvance.containertracer.service.Imp;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.repository.CntrRepository;
import ru.javaadvance.containertracer.service.CntrNumberValidator;
import ru.javaadvance.containertracer.service.CntrService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CntrServiceImp implements CntrService {
    private final CntrRepository cntrRepository;
    private final CntrNumberValidator cntrNumberValidator;

    @Override
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
        if (cntrNumberValidator.isValid(cntr.getNumber())) {
            cntr.setNumber(cntr.getNumber().toUpperCase());
            return cntrRepository.save(cntr);
        } else {
            throw new IllegalStateException("Номер контейнера не соответствует стандарту");
        }


    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Cntr> optionalCntr = cntrRepository.findById(id);
        if (optionalCntr.isEmpty()) {
            throw new IllegalStateException("Контейнер с таким ID отсутсвует");
        }
        cntrRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Long id, String cntrNumber) {

        Optional<Cntr> optionalCntr = cntrRepository.findById(id);
        if (optionalCntr.isEmpty()) {
            throw new IllegalStateException("Контейнер с таким ID отсутсвует");
        }
        Cntr cntr = optionalCntr.get();
        if (cntrNumber != null && cntrNumber.equals(cntr.getNumber())) {
            Optional<Cntr> cntrFindindByNumeber = Optional.ofNullable(cntrRepository.findByNumber(cntrNumber));
            if (cntrFindindByNumeber.isPresent()) {
                throw new IllegalStateException("Контейнер с таким номером уже существует");
            }

        } else {
            cntr.setNumber(cntrNumber);
        }
        cntrRepository.save(cntr);
    }


}
