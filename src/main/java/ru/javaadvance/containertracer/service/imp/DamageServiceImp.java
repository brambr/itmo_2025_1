package ru.javaadvance.containertracer.service.imp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javaadvance.containertracer.repository.DamageRepository;
import ru.javaadvance.containertracer.repository.entity.Damage;
import ru.javaadvance.containertracer.service.DamageService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DamageServiceImp implements DamageService {
    private final DamageRepository damageRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Damage> findAll() {

        return damageRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Damage findById(Long id) {

        return damageRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Damage create(Damage damage) {
        LocalDate localDate = LocalDate.now();
        damage.setAddDate(localDate);
        return damageRepository.save(damage);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        if (damageRepository.existsById(id)) {
            damageRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(String.valueOf(id));
        }

    }
    @Transactional
    @Override
    public void update(Damage damage) {
        if (damageRepository.existsById(damage.getId())) {
            damageRepository.save(damage);
        } else {
            throw new EntityNotFoundException(String.valueOf( damage.getId()));
        }
    }
}
