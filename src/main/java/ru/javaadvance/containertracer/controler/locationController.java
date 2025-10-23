package ru.javaadvance.containertracer.controler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.javaadvance.containertracer.controler.dto.LocationDto;
import ru.javaadvance.containertracer.repository.entity.Location;
import ru.javaadvance.containertracer.service.LocationService;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/locations")
@Validated
public class locationController {
    private final ModelMapper mapper;
    private final LocationService locationService;

    @GetMapping
    public List<LocationDto> getAllLocationDto() {
        return locationService.findAll().stream().map(location -> mapper.map(location, LocationDto.class)).toList();
    }
    @GetMapping("/{id}")
    public LocationDto getLocationDtoById(@PathVariable Long id) {
        return mapper.map(locationService.findById(id), LocationDto.class);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@NotNull @Valid @RequestBody LocationDto locationDto) {
        return locationService.create(mapper.map(locationDto, Location.class));
    }


    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public void update(@NotNull @Valid @RequestBody LocationDto locationDto) {
        locationService.update(mapper.map(locationDto,Location.class));
    }
}


