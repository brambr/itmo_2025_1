package ru.javaadvance.containertracer.controler;

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
public class CntrController {
    private final CntrServiceImp cntrService;
    private final ModelMapper mapper;


    @GetMapping
    public List<CntrDto> getCntrDto() {
       return cntrService.findAll().stream().map( cntr-> mapper.map(cntr, CntrDto.class)).toList();
    }
    @GetMapping("/{id}")
    public CntrDto getCntrDtoById(@PathVariable Long id) {
        return mapper.map(cntrService.findById(id), CntrDto.class);
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cntr create(@NotNull @Valid @RequestBody CntrDto cntrDto) {
       return cntrService.create(mapper.map(cntrDto, Cntr.class));
    }

    @DeleteMapping(path = "{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cntrService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public void update(@Valid @RequestBody CntrDto cntrDto) {
        cntrService.update(mapper.map(cntrDto, Cntr.class));
    }

}
