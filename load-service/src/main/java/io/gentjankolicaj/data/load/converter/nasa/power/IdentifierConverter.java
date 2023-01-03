package io.gentjankolicaj.data.load.converter.nasa.power;

import io.gentjankolicaj.data.load.common.command.nasa.power.IdentifierCommand;
import io.gentjankolicaj.data.load.common.domain.nasa.power.Identifier;
import io.gentjankolicaj.data.load.common.dto.nasa.power.IdentifierDTO;
import io.gentjankolicaj.data.load.converter.core.MyNasaPowerConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdentifierConverter implements MyNasaPowerConverter<Identifier, IdentifierDTO, IdentifierCommand> {

    public IdentifierConverter() {
    }

    @Override
    public IdentifierDTO sourceToDto(Identifier source) {
        if (source == null) {
            return null;
        } else {
            IdentifierDTO identifierDTO = new IdentifierDTO();
            identifierDTO.setIdentifier(source.getIdentifier());
            return identifierDTO;
        }
    }

    @Override
    public IdentifierCommand sourceToCommand(Identifier source) {
        if (source == null) {
            return null;
        } else {
            IdentifierCommand identifierCommand = new IdentifierCommand();
            identifierCommand.setIdentifier(source.getIdentifier());
            return identifierCommand;
        }
    }

    @Override
    public Identifier dtoToSource(IdentifierDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Identifier identifier = new Identifier();
            identifier.setIdentifier(dto.getIdentifier());
            return identifier;
        }
    }

    @Override
    public Identifier commandToSource(IdentifierCommand command) {
        if (command == null) {
            return null;
        } else {
            Identifier identifier = new Identifier();
            identifier.setIdentifier(command.getIdentifier());
            return identifier;
        }
    }

    @Override
    public List<IdentifierDTO> sourceToDto(List<Identifier> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<IdentifierDTO> tempList = new ArrayList<>(source.size());
            for (Identifier temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<IdentifierCommand> sourceToCommand(List<Identifier> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<IdentifierCommand> tempList = new ArrayList<>(source.size());
            for (Identifier temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<IdentifierDTO> sourceToDto(Iterable<Identifier> source) {
        if (source == null) {
            return null;
        } else {
            List<IdentifierDTO> tempList = new ArrayList<>();
            for (Identifier temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<IdentifierCommand> sourceToCommand(Iterable<Identifier> source) {
        if (source == null) {
            return null;
        } else {
            List<IdentifierCommand> tempList = new ArrayList<>();
            for (Identifier temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }
}
