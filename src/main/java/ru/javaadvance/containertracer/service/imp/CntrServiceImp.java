package ru.javaadvance.containertracer.service.imp;

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
    public void update(Cntr cntr) {
        try {
                if (cntrRepository.existsById(cntr.getId())) {
                    Cntr cntrFromDb = cntrRepository.findById(cntr.getId()).get();
                    cntrFromDb= (cntr);
                    cntrFromDb.setNumber(cntrFromDb.getNumber().toUpperCase());
                    cntrRepository.save(cntrFromDb);
                 } else {
                throw new IllegalStateException("Контейнер с таким ID отсутсвует");
                  }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
