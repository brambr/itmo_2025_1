package ru.javaadvance.containertracer.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.repository.Cntr;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class CntrMapper {
    private final ModelMapper modelMapper;

    public Cntr toEntity(CntrDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Cntr.class);
    }

    public CntrDto toDto(Cntr entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CntrDto.class);
    }

}
