package ru.javaadvance.containertracer.service.imp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javaadvance.containertracer.repository.LegalEntityRepository;
import ru.javaadvance.containertracer.repository.entity.LegalEntity;
import ru.javaadvance.containertracer.service.LegalEntityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LegalEntityServiceImp implements LegalEntityService {
    private final LegalEntityRepository legalEntityRepository;

    @Transactional(readOnly = true)
    @Override
    public List<LegalEntity> findAll() {
        return legalEntityRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public LegalEntity findById(Long id) {
        return legalEntityRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public LegalEntity create(LegalEntity legalEntity) {
        return legalEntityRepository.save(legalEntity);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        if (legalEntityRepository.existsById(id)) {
            legalEntityRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(String.valueOf(id));
        };
    }
    @Transactional
    @Override
    public void update(LegalEntity legalEntity) {
        legalEntityRepository.save(legalEntity);
    }
}
