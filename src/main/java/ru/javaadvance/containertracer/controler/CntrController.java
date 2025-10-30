package ru.javaadvance.containertracer.controler;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.controler.dto.LocationDto;
import ru.javaadvance.containertracer.repository.entity.Cntr;
import ru.javaadvance.containertracer.service.imp.CntrServiceImp;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/cntrs")
@Validated
@Tag(name="Контейнер", description="Контролер для CRUD операций с контейнерами")
public class CntrController {
    private final CntrServiceImp cntrService;
    private final ModelMapper mapper;

    @Operation(summary= "Список  контейнеров",description = "Получение списка контейнеров")
    @GetMapping
    public List<CntrDto> getCntrDto() {
        return cntrService.findAll().stream().map(cntr -> mapper.map(cntr, CntrDto.class)).toList();
    }
    @Operation(summary= "Контейнер по ID",description = "Получение данных контейнера по ID")
    @GetMapping("/{id}")
    public CntrDto getCntrDtoById(@PathVariable Long id) {
        return mapper.map(cntrService.findById(id), CntrDto.class);
    }
    @Operation(summary= "Контейнер по #",description = "Получение данных контейнера по номеру")
    @GetMapping(value = "", params = "number")
    public CntrDto getCntrDtoByNumber(@RequestParam String number) {
        return mapper.map(cntrService.findByNumber(number), CntrDto.class);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary= "Создание Контейнера",description = "Создание нового контейнра")
    public Cntr create(@NotNull @Valid @RequestBody CntrDto cntrDto) {
        return cntrService.create(mapper.map(cntrDto, Cntr.class));
    }
    @Hidden
    @DeleteMapping(path = "{id}")
    @Operation(summary= "Удаление контейнера по ID",description = "Удаление контейнера по ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cntrService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @Operation(summary= "Обновление контейнера по ID",description = "Обновлеие данных контейнера по ID")
    @PutMapping()
    public void update(@Valid @RequestBody CntrDto cntrDto) {
        cntrService.update(mapper.map(cntrDto, Cntr.class));
    }

}
