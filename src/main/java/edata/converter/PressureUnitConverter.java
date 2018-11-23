package edata.converter;

import edata.common.command.PressureUnitCommand;
import edata.common.domain.PressureUnit;
import edata.common.dto.PressureUnitDTO;
import edata.converter.core.MyConverter;
import org.springframework.stereotype.Component;

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
}
