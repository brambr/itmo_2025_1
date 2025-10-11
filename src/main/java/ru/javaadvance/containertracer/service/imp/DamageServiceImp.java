package ru.javaadvance.containertracer.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javaadvance.containertracer.repository.DamageRepository;
import ru.javaadvance.containertracer.repository.entity.Damage;
import ru.javaadvance.containertracer.service.DamageService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DamageServiceImp implements DamageService {
    private final DamageRepository damageRepository;

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
        return damageRepository.save(damage);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        if (damageRepository.existsById(id)) {
            damageRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Повреждение с таким ID=" + id + " отсутсвует");
        }

    }
    @Transactional
    @Override
    public void update(Damage damage) {
        if (damageRepository.existsById(damage.getId())) {
            damageRepository.save(damage);
        } else {
            throw new IllegalStateException("Повреждение  с таким ID=" + damage.getId()+ " отсутсвует");
        }
    }
}
