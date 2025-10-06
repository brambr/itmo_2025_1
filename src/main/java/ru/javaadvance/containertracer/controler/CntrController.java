package ru.javaadvance.containertracer.controler;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.mappers.CntrMapper;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.service.imp.CntrServiceImp;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/cntrs")
@Validated
public class CntrController {
    private final CntrServiceImp cntrService;
    private final CntrMapper cntrMapper;

    @GetMapping
    public Page<Cntr> getCntr(Pageable page) {
        
        return  cntrService.findAll(page);//не смог через марер прогнать page
    }

    @PostMapping
    public Cntr create( @NotNull @RequestBody CntrDto cntrDto) {
        return cntrService.create(cntrMapper.toEntity(cntrDto));
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) {
        cntrService.delete(id);
    }

    @PutMapping()
    public void update( @RequestBody CntrDto cntrDto) {
        cntrService.update(cntrMapper.toEntity(cntrDto));
    }

}
