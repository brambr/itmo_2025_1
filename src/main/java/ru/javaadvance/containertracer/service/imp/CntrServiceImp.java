package ru.javaadvance.containertracer.service.imp;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaadvance.containertracer.repository.entity.Cntr;
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
        Optional<List<Cntr>> cntrList = Optional.of(cntrRepository.findAll());
        return cntrList.get();
    }

    @Override
    @Transactional
    public Cntr findById(Long id){
        Optional<Cntr> cntr = cntrRepository.findById(id);
        return cntr.orElse(null);
    }

    @Transactional
    public Cntr findByNumber(String number){
        Optional<Cntr> cntr= Optional.ofNullable(cntrRepository.findByNumber(number));
        return cntr.orElse(null) ;
    }

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
            throw new EntityNotFoundException(String.valueOf(id));
        }
    }

    @Transactional
    @Override
    public void update(Cntr cntr) {
        try {
                if (cntrRepository.existsById(cntr.getId())) {
                    Cntr cntrFromDb = cntrRepository.findById(cntr.getId()).get();
                    cntrFromDb= (cntr);
                    cntrFromDb.setNumber(cntrFromDb.getNumber().toUpperCase());
                    cntrRepository.save(cntrFromDb);
                 } else {
                    throw new EntityNotFoundException(String.valueOf(cntr.getId()));
                  }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
