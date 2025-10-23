package ru.javaadvance.containertracer.controler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.javaadvance.containertracer.controler.dto.DamageDto;
import ru.javaadvance.containertracer.controler.dto.LocationDto;
import ru.javaadvance.containertracer.repository.entity.Damage;
import ru.javaadvance.containertracer.service.DamageService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/damages")
@Validated
public class DamageController {
    private final DamageService damageService;
    private final ModelMapper mapper;


    @GetMapping
    public List<DamageDto> getDamageDto() {
        return damageService.findAll().stream().map(damage -> mapper.map(damage, DamageDto.class)).toList();
    }
    @GetMapping("/{id}")
    public  DamageDto getDamageDtoById(@PathVariable Long id) {
        return mapper.map(damageService.findById(id), DamageDto.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Damage create(@NotNull @Valid @RequestBody DamageDto damageDto) {
        return damageService.create(mapper.map(damageDto, Damage.class));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        damageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public void update(@Valid @RequestBody DamageDto damageDto) {
        damageService.update(mapper.map(damageDto, Damage.class));
    }
}
