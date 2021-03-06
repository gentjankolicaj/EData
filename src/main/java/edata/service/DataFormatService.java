package edata.service;

import edata.common.command.DataFormatCommand;
import edata.common.dto.DataFormatDTO;

import java.util.List;

public interface DataFormatService {

    List<DataFormatDTO> getAllDTO();
    List<DataFormatCommand> getAllCommand();

    DataFormatDTO saveDTO(DataFormatDTO dataFormatDTO);
    DataFormatCommand saveCommand(DataFormatCommand dataFormatCommand);

    DataFormatDTO updateDTO(DataFormatDTO dataFormatDTO);
    DataFormatCommand updateCommand(DataFormatCommand dataFormatCommand);

    DataFormatDTO getByIdDTO(String id);
    DataFormatCommand  getByIdCommand(String id);

    void deleteDTO(DataFormatDTO dataFormatDTO);
    void deleteCommand(DataFormatCommand dataFormatCommand);

}
