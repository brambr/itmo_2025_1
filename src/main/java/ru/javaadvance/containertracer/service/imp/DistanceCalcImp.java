package ru.javaadvance.containertracer.service.imp;

import org.springframework.stereotype.Service;
import ru.javaadvance.containertracer.repository.entity.Location;
import ru.javaadvance.containertracer.service.DistanceCalc;

@Service
public class DistanceCalcImp implements DistanceCalc {
    private final double EARTH_RADIUS = 6371;
   @Override
    public Double getDistance(Location location1, Location location2) {
       if (location1==null && location2==null) {
           return 0.0;
       }
        return calcDistance(location1.getLatitude(),location1.getLongitude(), location2.getLatitude(),location2.getLongitude());
    }
    private  Double calcDistance(Double latitude1, Double longtitude1,Double latitude2, Double longtitude2){

            double lat1Rad = Math.toRadians(latitude1);
            double lon1Rad = Math.toRadians(longtitude1);
            double lat2Rad = Math.toRadians(latitude2);
            double lon2Rad = Math.toRadians(longtitude2);
            double dLat = lat2Rad - lat1Rad;
            double dLon = lon2Rad - lon1Rad;

            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                            Math.sin(dLon / 2) * Math.sin(dLon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            return EARTH_RADIUS * c;
    }
}
