package ru.javaadvance.containertracer.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.service.Imp.CntrServiceImp;
import ru.javaadvance.containertracer.utils.MapperDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/cntrs")
public class CntrController {
    private final CntrServiceImp cntrService;
    private final MapperDto mapperDto;

    @GetMapping
    public List<CntrDto> getCntr() {
        return cntrService.findAll().stream().map(mapperDto::cntrToCntrDto).collect(Collectors.toList());
    }

    @PostMapping
    public Cntr create(@RequestBody CntrDto cntrDto) {
        return cntrService.create(mapperDto.cntrDtoToCntr(cntrDto));
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) {
        cntrService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable Long id, String number) {
        cntrService.update(id, number);
    }

}
