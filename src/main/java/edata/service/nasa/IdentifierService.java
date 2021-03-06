package edata.service.nasa;

import edata.common.command.nasa.power.IdentifierCommand;
import edata.common.dto.nasa.power.IdentifierDTO;

import java.util.List;

public interface IdentifierService {

    List<IdentifierDTO> getAllDTO();
    List<IdentifierCommand> getAllCommand();

    IdentifierDTO saveDTO(IdentifierDTO identifierDTO);
    IdentifierCommand saveCommand(IdentifierCommand identifierCommand);

    IdentifierDTO updateDTO(IdentifierDTO identifierDTO);
    IdentifierCommand updateCommand(IdentifierCommand identifierCommand);

    IdentifierDTO getByIdDTO(String id);
    IdentifierCommand getByIdCommand(String id);

    void deleteDTO(IdentifierDTO identifierDTO);
    void deleteCommand(IdentifierCommand identifierCommand);



}
