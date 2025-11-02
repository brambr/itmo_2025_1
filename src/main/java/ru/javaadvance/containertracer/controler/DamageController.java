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

import ru.javaadvance.containertracer.controler.dto.DamageDto;
import ru.javaadvance.containertracer.controler.dto.LocationDto;
import ru.javaadvance.containertracer.repository.entity.Damage;
import ru.javaadvance.containertracer.service.DamageService;

import java.util.List;
@Tag(name="Несохранности", description= "Контролер для CRUD операций с повреждениями контейнера")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/damages")
@Validated
public class DamageController {
    private final DamageService damageService;
    private final ModelMapper mapper;

    @Operation(summary= "Список несохранностей",description = "Получение списка всех повреждений")
    @GetMapping
    public List<DamageDto> getDamageDto() {
        return damageService.findAll().stream().map(damage -> mapper.map(damage, DamageDto.class)).toList();
    }
    @Operation(summary= "Несохранность по ID ",description = "Получение списка всех повреждений по ID")
    @GetMapping("/{id}")
    public  DamageDto getDamageDtoById(@PathVariable Long id) {
        return mapper.map(damageService.findById(id), DamageDto.class);
    }
    @Operation(summary= "Добавление несохранности",description = "Регистрация нового повреждения ")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Damage create(@NotNull @Valid @RequestBody DamageDto damageDto) {
        return damageService.create(mapper.map(damageDto, Damage.class));
    }

    @DeleteMapping(path = "{id}")
    @Operation(summary= "Удаление несохранности",description = "Удаление повреждения по ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        damageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @Operation(summary= "Обновление  несохранности",description = "Обновление данных повреждения по ID")
    @PutMapping()
    public void update(@Valid @RequestBody DamageDto damageDto) {
        damageService.update(mapper.map(damageDto, Damage.class));
    }
}
