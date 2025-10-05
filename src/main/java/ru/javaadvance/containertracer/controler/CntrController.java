package ru.javaadvance.containertracer.controler;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.controler.dto.CntrNumberDto;
import ru.javaadvance.containertracer.mappers.CntrMapper;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.service.imp.CntrServiceImp;
import ru.javaadvance.containertracer.utils.MapperDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/cntrs")
@Validated
public class CntrController {
    private final CntrServiceImp cntrService;
    private final MapperDto mapperDto;

    @GetMapping
    public Page<Cntr> getCntr(Pageable page) {
        
        return  cntrService.findAll(page);//.stream().map(mapperDto::cntrToCntrDto).collect(Collectors.toList());
    }

    @PostMapping
    public Cntr create( @NotNull @RequestBody CntrDto cntrDto) {
        return cntrService.create(mapperDto.cntrDtoToCntr(cntrDto));
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) {
        cntrService.delete(id);
    }

    @PutMapping()
    public void update( @RequestBody CntrDto cntrDto) {
        cntrService.update(mapperDto.cntrDtoToCntr(cntrDto));
    }

}
