package ru.javaadvance.containertracer.controler;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
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
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.controler.dto.CntrPassDto;
import ru.javaadvance.containertracer.repository.entity.Cntr;
import ru.javaadvance.containertracer.repository.entity.CntrPass;
import ru.javaadvance.containertracer.service.CntrPassService;

import java.util.List;
@Tag(name="Паспорт контейнера", description="Контролер для CRUD операций с паспортами контейнеров")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/cntrPasses")
@Validated
public class CntrPassController {
    private final CntrPassService cntrPassService;
    private final ModelMapper mapper;

    @Operation(summary= "Список паспортов контейнеров",description = "Вывод паспортов контейнеров со всеми вхождениями")
    @GetMapping
    public List<CntrPassDto> getCntrPassDto() {
        return cntrPassService.findAll().stream().map( cntrPass-> mapper.map(cntrPass, CntrPassDto.class)).toList();
    }
    @Operation(summary= "Паспорт контейнера",description = "Вывод по ID паспорта контейнера со всеми вхождениями")
    @GetMapping("/{id}")
    public CntrPassDto getCntrPassDtoById(@PathVariable Long id) {
        CntrPass cntrPass = cntrPassService.findById(id);
        System.out.println(cntrPass);
        CntrPassDto cntrPassDto = mapper.map(cntrPass, CntrPassDto.class);
        return cntrPassDto;
    }
    @Operation(summary= "Создание паспорта контейнера",description = "Создание паспорта контейнера со всеми вхождениями")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CntrPass create( @RequestBody CntrPassDto cntrPassDto) {
        return cntrPassService.create(mapper.map(cntrPassDto, CntrPass.class));
    }
    @Hidden
    @Operation(summary= "Удаление паспорта контейнера",description = "Удаление паспорта контейнера со всеми вхождениями")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cntrPassService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @Operation(summary= "Обновление паспорта контейнера",description = "Обновление по ID данных  паспорта контейнера со всеми вхождениями")
    @PutMapping()
    public void update(@Valid @RequestBody CntrPassDto cntrPassDto) {

        cntrPassService.update(mapper.map(cntrPassDto, CntrPass.class));
    }




}
