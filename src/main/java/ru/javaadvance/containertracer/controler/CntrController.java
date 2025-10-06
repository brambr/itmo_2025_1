package ru.javaadvance.containertracer.controler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.service.imp.CntrServiceImp;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/cntrs")
@Validated
public class CntrController {
    private final CntrServiceImp cntrService;
    private final ModelMapper mapper;


    @GetMapping
    public List<CntrDto> getCntrDto() {
       return cntrService.findAll().stream().map( cntr-> mapper.map(cntr, CntrDto.class)).toList();
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
