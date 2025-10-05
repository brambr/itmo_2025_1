package ru.javaadvance.containertracer.service.imp;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly=true)
    public Page<Cntr> findAll(Pageable page ) {
       // Pageable page = PageRequest.of(pageNumber ,pageSize);
        return cntrRepository.findAll(page);
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
        if (cntrRepository.existsById(id)) {
            cntrRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Контейнер с таким ID=" + id + " отсутсвует");
        }
    }

    @Transactional
    @Override
    public void update(Cntr cntrIn) {

        Optional<Cntr> optionalCntr = cntrRepository.findById(cntrIn.getId());
        if (optionalCntr.isEmpty()) {
            throw new IllegalStateException("Контейнер с таким ID отсутсвует");
        }
        Cntr cntrOpt = optionalCntr.get();
        if (cntrIn.getNumber()!= null && cntrIn.getNumber().equals(cntrOpt.getNumber())) {
            Optional<Cntr> cntrFindindByNumeber = Optional.ofNullable(cntrRepository.findByNumber(cntrIn.getNumber()));
            if (cntrFindindByNumeber.isPresent()) {
                throw new IllegalStateException("Контейнер с таким номером уже существует");
            }

        } else {
            cntrOpt.setNumber(cntrIn.getNumber());
        }
        cntrRepository.save(cntrOpt);
    }


}
