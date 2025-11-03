package ru.javaadvance.containertracer.service.imp;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javaadvance.containertracer.repository.LocationRepository;
import ru.javaadvance.containertracer.repository.entity.Location;
import ru.javaadvance.containertracer.service.LocationService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LocationServiceImp implements LocationService {
    private final LocationRepository locationRepository;

    @Transactional( readOnly = true)
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Transactional( readOnly = true)
    @Override
    public Location findById(Long id) {
        if(locationRepository.findById(id).isPresent()){
            return locationRepository.findById(id).orElse(null);
        }
       else {
         throw new EntityNotFoundException("Location not found");
       }
    }

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete(Long id) {
        if(locationRepository.findById(id).isPresent()){
            locationRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException(String.valueOf(id));
        }

    }

    @Override
    public void update(Location location) {
        if(locationRepository.findById(location.getId()).isPresent()){
            locationRepository.save(location);
        }
        else{
            throw new EntityNotFoundException(String.valueOf(location.getId()));
        }
    }
}
