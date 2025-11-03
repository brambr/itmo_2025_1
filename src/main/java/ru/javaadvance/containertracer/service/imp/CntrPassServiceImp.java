package ru.javaadvance.containertracer.service.imp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javaadvance.containertracer.repository.CntrPassRepository;
import ru.javaadvance.containertracer.repository.entity.Cntr;
import ru.javaadvance.containertracer.repository.entity.CntrPass;
import ru.javaadvance.containertracer.repository.entity.Location;
import ru.javaadvance.containertracer.service.CntrPassService;
import ru.javaadvance.containertracer.service.CntrService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CntrPassServiceImp implements CntrPassService {
    private final CntrPassRepository cntrPassRepository;
    private final CntrService cntrService;
   private final double EARTH_RADIUS = 6371;

    @Override
    @Transactional(readOnly = true)
    public List<CntrPass> findAll() {
        Optional<List<CntrPass>> cntrPassList = Optional.of(cntrPassRepository.findAll());
        return cntrPassList.get();
    }

    @Override
    @Transactional(readOnly = true)
    public CntrPass findById(Long id) {
        Optional<CntrPass> cntrPass = cntrPassRepository.findById(id);
        return cntrPass.orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public CntrPass findByCntrNumber(Long id) {
        Optional<CntrPass> cntrPass = Optional.ofNullable(cntrPassRepository.findByCntrId(id));
        return cntrPass.orElse(null);
    }


    @Transactional(readOnly = true)
    @Override
    public CntrPass findByCntrNumber(String number) {
        Optional<Cntr> cntr = Optional.ofNullable(cntrService.findByNumber(number));
        if (cntr.isPresent()){
            Optional<CntrPass> cntrPass = Optional.ofNullable(cntrPassRepository.findByCntrId(cntr.get().getId()));
            return cntrPass.orElse(null);
        }
        return null;
    }


    @Override
    @Transactional
    public CntrPass create(CntrPass cntrPass) {
        cntrPassRepository.save(cntrPass);
        return cntrPassRepository.save(cntrPass);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if (cntrPassRepository.existsById(id)) {
            cntrPassRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(String.valueOf(id));
        }
    }

    @Transactional
    @Override
    public void update(CntrPass cntrPass) {
        try {
            if (cntrPassRepository.existsById(cntrPass.getId())) {
                CntrPass cntrPassFromDb = cntrPassRepository.findById(cntrPass.getId()).get();
                Double newDistance =  getDistance(cntrPass.getLocation(),cntrPassFromDb.getLocation());
                cntrPass.setDistance( cntrPass.getDistance() + newDistance);
                cntrPassFromDb = (cntrPass);

                cntrPassRepository.save(cntrPassFromDb);
            } else {
                throw new EntityNotFoundException(String.valueOf(cntrPass.getId()));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private  Double getDistance(Location location1, Location location2){
        if (location1!=null && location2!=null){
                double lat1Rad = Math.toRadians(location1.getLatitude());
                double lon1Rad = Math.toRadians(location1.getLongitude());
                double lat2Rad = Math.toRadians(location2.getLatitude());
                double lon2Rad = Math.toRadians(location2.getLongitude());
                double dLat = lat2Rad - lat1Rad;
                double dLon = lon2Rad - lon1Rad;

                double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                                Math.sin(dLon / 2) * Math.sin(dLon / 2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                return EARTH_RADIUS * c;
        }
        else {
            return 0.0;
        }
    }
}