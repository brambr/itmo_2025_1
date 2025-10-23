package ru.javaadvance.containertracer.controler;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.javaadvance.containertracer.controler.dto.LegalEntityDto;
import ru.javaadvance.containertracer.controler.dto.LocationDto;
import ru.javaadvance.containertracer.repository.entity.LegalEntity;
import ru.javaadvance.containertracer.service.LegalEntityService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/legalEntities")
@Validated
public class LegalEntityController {
    private final ModelMapper mapper;
    private final LegalEntityService legalEntityService;

    @GetMapping
    public List<LegalEntityDto> getLegalEntityDto() {
        return legalEntityService.findAll().stream().map(legalEntity -> mapper.map(legalEntity, LegalEntityDto.class)).toList();
    }
    @GetMapping("/{id}")
    public  LegalEntityDto getLegalEntityDtoById(@PathVariable Long id) {
        return mapper.map(legalEntityService.findById(id), LegalEntityDto.class);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LegalEntity create(@NotNull @Valid @RequestBody LegalEntityDto legalEntityDto) {
        return legalEntityService.create(mapper.map(legalEntityDto, LegalEntity.class));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        legalEntityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public void update(@NotNull @Valid @RequestBody LegalEntityDto legalEntityDto) {
        legalEntityService.update(mapper.map(legalEntityDto, LegalEntity.class));
    }
}
