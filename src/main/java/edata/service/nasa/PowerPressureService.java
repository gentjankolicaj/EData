package edata.service.nasa;

import edata.common.command.nasa.power.PowerPressureCommand;
import edata.common.dto.nasa.power.PowerPressureDTO;

import java.util.List;

public interface PowerPressureService {

    List<PowerPressureDTO> getAllDTO();
    List<PowerPressureCommand> getAllCommand();

    PowerPressureDTO saveDTO(PowerPressureDTO powerPressureDTO);
    PowerPressureCommand saveCommand(PowerPressureCommand powerPressureCommand);

    PowerPressureDTO updateDTO(PowerPressureDTO powerPressureDTO);
    PowerPressureCommand updateCommand(PowerPressureCommand powerPressureCommand);


   PowerPressureDTO getByIdDTO(Long id);
   PowerPressureCommand  getByIdCommand(Long id);

    void deleteDTO(PowerPressureDTO powerPressureDTO);
    void deleteCommand(PowerPressureCommand powerPressureCommand);
}
