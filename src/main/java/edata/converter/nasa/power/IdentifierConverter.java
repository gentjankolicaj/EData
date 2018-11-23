package edata.converter.nasa.power;

import edata.common.command.nasa.power.IdentifierCommand;
import edata.common.domain.nasa.power.Identifier;
import edata.common.dto.nasa.power.IdentifierDTO;
import edata.converter.core.MyNasaPowerConverter;
import org.springframework.stereotype.Component;

@Component
public class IdentifierConverter implements MyNasaPowerConverter<Identifier, IdentifierDTO, IdentifierCommand> {

    public IdentifierConverter() {
    }

    @Override
    public IdentifierDTO sourceToDto(Identifier source) {
       if(source==null){
           return null;
       }else {
           IdentifierDTO identifierDTO=new IdentifierDTO();
           identifierDTO.setIdentifier(source.getIdentifier());
           return  identifierDTO;
       }
    }

    @Override
    public IdentifierCommand sourceToCommand(Identifier source) {
        if(source==null){
            return null;
        }else{
            IdentifierCommand identifierCommand=new IdentifierCommand();
            identifierCommand.setIdentifier(source.getIdentifier());
           return identifierCommand;
        }
    }

    @Override
    public Identifier dtoToSource(IdentifierDTO dto) {
        if(dto==null){
            return null;
        }else{
            Identifier identifier=new Identifier();
            identifier.setIdentifier(dto.getIdentifier());
            return identifier;
        }
    }

    @Override
    public Identifier commandToSource(IdentifierCommand command) {
        if(command==null){
            return null;
        }else{
            Identifier identifier=new Identifier();
            identifier.setIdentifier(command.getIdentifier());
            return identifier;
        }
    }
}
