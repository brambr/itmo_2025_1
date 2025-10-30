package ru.javaadvance.containertracer.controler;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="Оператор контейнера",description = "Контролер для CRUD операций с юридическим лицом которое распоряжается контейнером в текущий момент времени")
public class LegalEntityController {
    private final ModelMapper mapper;
    private final LegalEntityService legalEntityService;
    @Operation(summary= "Список операторов",description = "Получение списка всех операторов")
    @GetMapping
    public List<LegalEntityDto> getLegalEntityDto() {
        return legalEntityService.findAll().stream().map(legalEntity -> mapper.map(legalEntity, LegalEntityDto.class)).toList();
    }
    @Operation(summary= "Получение оператора",description = "Получение оператора по ID")
    @GetMapping("/{id}")
    public  LegalEntityDto getLegalEntityDtoById(@PathVariable Long id) {
        return mapper.map(legalEntityService.findById(id), LegalEntityDto.class);
    }

    @Operation(summary= "Создание оператора",description = "Создание нового оператора")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LegalEntity create(@NotNull @Valid @RequestBody LegalEntityDto legalEntityDto) {
        return legalEntityService.create(mapper.map(legalEntityDto, LegalEntity.class));
    }
    @Hidden
    @DeleteMapping(path = "{id}")
    @Operation(summary= "Удаление оператора",description = "Удалеие оператора по ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        legalEntityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    @Operation(summary= "Обновление оператора",description = "Обновление данных оператора по  ID")
    public void update(@NotNull @Valid @RequestBody LegalEntityDto legalEntityDto) {
        legalEntityService.update(mapper.map(legalEntityDto, LegalEntity.class));
    }
}
