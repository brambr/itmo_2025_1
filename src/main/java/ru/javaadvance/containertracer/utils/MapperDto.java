package ru.javaadvance.containertracer.utils;

import org.springframework.stereotype.Component;
import ru.javaadvance.containertracer.controler.dto.CntrDto;
import ru.javaadvance.containertracer.controler.dto.CntrNumberDto;
import ru.javaadvance.containertracer.repository.Cntr;
import ru.javaadvance.containertracer.repository.CntrNumber;

import static javax.swing.text.html.HTML.Attribute.N;

@Component
public class MapperDto {

    public CntrDto  cntrToCntrDto(Cntr cntr){
        CntrDto cntrDto = new CntrDto();
        cntrDto.setId(cntr.getId());
        cntrDto.setNumber(cntr.getNumber());
        cntrDto.setType(cntr.getType());
        cntrDto.setTareWeight(cntr.getTareWeight());
        cntrDto.setMaxPayLoad(cntr.getMaxPayLoad());
        cntrDto.setIso(cntr.getIso());
        cntrDto.setSize(cntr.getSize());
        return cntrDto;
    }

    public Cntr  cntrDtoToCntr(CntrDto cntrDto){
        Cntr cntr = new Cntr();
        cntr.setId(cntrDto.getId());
        cntr.setNumber(cntrDto.getNumber());
        cntr.setType(cntrDto.getType());
        cntr.setTareWeight(cntrDto.getTareWeight());
        cntr.setMaxPayLoad(cntrDto.getMaxPayLoad());
        cntr.setIso(cntrDto.getIso());
        cntr.setSize(cntrDto.getSize());
        return cntr;
    }
    public CntrNumber cntrNumberDtoToCntrNumber(CntrNumberDto cntrnumberDto){
        CntrNumber cntrNumber = new CntrNumber();
        cntrNumber.setCntrNumber(cntrnumberDto.getCntrNnumberDto());
        cntrNumber.setId(cntrnumberDto.getId());
        return cntrNumber;
    }
}
