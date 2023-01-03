package io.gentjankolicaj.data.load.converter;

import io.gentjankolicaj.data.load.common.command.PressureUnitCommand;
import io.gentjankolicaj.data.load.common.domain.PressureUnit;
import io.gentjankolicaj.data.load.common.dto.PressureUnitDTO;
import io.gentjankolicaj.data.load.converter.core.MyConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PressureUnitConverter implements MyConverter<PressureUnit, PressureUnitDTO, PressureUnitCommand> {

    public PressureUnitConverter() {
    }

    @Override
    public PressureUnitDTO sourceToDto(PressureUnit source) {
        if(source==null){
            return null;
        }else{
            PressureUnitDTO pressureUnitDTO=new PressureUnitDTO();
            pressureUnitDTO.setUnitName(source.getUnitName()    );
            pressureUnitDTO.setUnitCode(source.getUnitCode());
            pressureUnitDTO.setUnitDescription(source.getUnitDescription());
            return pressureUnitDTO;
        }
    }

    @Override
    public PressureUnitCommand sourceToCommand(PressureUnit source) {
        if(source==null){
            return null;
        }else{
            PressureUnitCommand pressureUnitCommand=new PressureUnitCommand();
            pressureUnitCommand.setUnitName(source.getUnitName());
            pressureUnitCommand.setUnitCode(source.getUnitCode());
            pressureUnitCommand.setUnitDescription(source.getUnitDescription());
            return pressureUnitCommand;

        }
    }

    @Override
    public PressureUnit dtoToSource(PressureUnitDTO dto) {
        if(dto==null){
            return null;
        }else{
            PressureUnit pressureUnit=new PressureUnit();
            pressureUnit.setUnitName(dto.getUnitName());
            pressureUnit.setUnitCode(dto.getUnitCode());
            pressureUnit.setUnitDescription(dto.getUnitDescription());
            return pressureUnit;
        }
    }

    @Override
    public PressureUnit commandToSource(PressureUnitCommand command) {
        if (command==null){
            return null;
        }else{
            PressureUnit pressureUnit=new PressureUnit();
            pressureUnit.setUnitName(command.getUnitName());
            pressureUnit.setUnitCode(command.getUnitCode());
            pressureUnit.setUnitDescription(command.getUnitDescription());
            return pressureUnit;
        }
    }

    @Override
    public List<PressureUnitDTO> sourceToDto(List<PressureUnit> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<PressureUnitDTO> tempList=new ArrayList<>(source.size());
            for(PressureUnit temp:source){
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PressureUnitCommand> sourceToCommand(List<PressureUnit> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<PressureUnitCommand> tempList=new ArrayList<>(source.size());
            for(PressureUnit temp:source){
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }
}
