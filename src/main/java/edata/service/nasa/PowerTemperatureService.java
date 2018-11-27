package edata.service.nasa;

import edata.common.command.nasa.power.PowerTemperatureCommand;
import edata.common.dto.nasa.power.PowerTemperatureDTO;

import java.util.List;

public interface PowerTemperatureService {

    List<PowerTemperatureDTO> getAllDTO();
    List<PowerTemperatureCommand> getAllCommand();

    PowerTemperatureDTO saveDTO(PowerTemperatureDTO powerTemperatureDTO);
    PowerTemperatureCommand saveCommand(PowerTemperatureCommand powerTemperatureCommand);

    PowerTemperatureDTO updateDTO(PowerTemperatureDTO powerTemperatureDTO);
    PowerTemperatureCommand updateCommand(PowerTemperatureCommand powerTemperatureCommand);

    PowerTemperatureDTO getByIdDTO(Long id);
    PowerTemperatureCommand  getByIdCommand(Long id);

    void deleteDTO(PowerTemperatureDTO powerTemperatureDTO);
    void deleteCommand(PowerTemperatureCommand powerTemperatureCommand);
}
