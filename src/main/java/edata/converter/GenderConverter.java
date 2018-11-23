package edata.converter;

import edata.common.command.GenderCommand;
import edata.common.domain.Gender;
import edata.common.dto.GenderDTO;
import edata.converter.core.MyConverter;
import org.springframework.stereotype.Component;

@Component
public class GenderConverter implements MyConverter<Gender, GenderDTO, GenderCommand> {

    public GenderConverter() {
    }

    @Override
    public GenderDTO sourceToDto(Gender source) {
        if(source==null){
            return null;
        }else{
            if(source.getValue().equals(Gender.F)){
                return GenderDTO.F;
            }else if(source.getValue().equals(Gender.M)){
                return GenderDTO.M;
            }else{
                return  GenderDTO.O;
            }
        }
    }

    @Override
    public GenderCommand sourceToCommand(Gender source) {
        if(source==null){
            return null;
        }else{
            if(source.getValue().equals(Gender.F)){
                return GenderCommand.F;
            }else if(source.getValue().equals(Gender.M)){
                return GenderCommand.M;
            }else{
                return GenderCommand.O;
            }
        }
    }

    @Override
    public Gender dtoToSource(GenderDTO dto) {
        if(dto==null){
            return null;
        }else{
            if(dto.getValue().equals(GenderDTO.F)){
                return Gender.F;
            }else if(dto.getValue().equals(GenderDTO.M)){
                return Gender.M;
            }else{
                return Gender.O;
            }
        }
    }

    @Override
    public Gender commandToSource(GenderCommand command) {
        if(command==null){
            return null;
        }else{
            if(command.getValue().equals(GenderCommand.F)){
                return Gender.F;
            }else if(command.getValue().equals(GenderCommand.M)){
                return Gender.M;
            }else{
                return Gender.O;
            }
        }
    }

}
