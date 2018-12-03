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

    List<PowerTemperatureDTO> retrieveDTO(Long userId,String identifier, String dataParameters,
                                         String startDate, String endDate,
                                         String userCommunity, String tempAverage,
                                         String outputFormat, String lat, String lon, String bbox);
    List<PowerTemperatureCommand> retrieveCommand(Long userId,String identifier, String dataParameters,
                                                 String startDate, String endDate,
                                                 String userCommunity, String tempAverage,
                                                 String outputFormat, String lat, String lon, String bbox);


}
