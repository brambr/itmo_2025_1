package ru.javaadvance.containertracer.controler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.controler.dto.CntrPassDto;
import ru.javaadvance.containertracer.repository.entity.Cntr;
import ru.javaadvance.containertracer.repository.entity.CntrPass;
import ru.javaadvance.containertracer.service.CntrPassService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/cntrPasses")
@Validated
public class CntrPassController {
    private final CntrPassService cntrPassService;
    private final ModelMapper mapper;


    @GetMapping
    public List<CntrPassDto> getCntrPassDto() {
        return cntrPassService.findAll().stream().map( cntrPass-> mapper.map(cntrPass, CntrPassDto.class)).toList();
    }
    @GetMapping("/{id}")
    public CntrPassDto getCntrPassDtoById(@PathVariable Long id) {
        CntrPass cntrPass = cntrPassService.findById(id);
        System.out.println(cntrPass);
        CntrPassDto cntrPassDto = mapper.map(cntrPass, CntrPassDto.class);
        return cntrPassDto;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CntrPass create( @RequestBody CntrPassDto cntrPassDto) {
        return cntrPassService.create(mapper.map(cntrPassDto, CntrPass.class));
    }



}
