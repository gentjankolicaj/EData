package io.gentjankolicaj.data.load.service.nasa;

import io.gentjankolicaj.data.load.common.command.nasa.power.PowerPressureCommand;
import io.gentjankolicaj.data.load.common.dto.nasa.power.PowerPressureDTO;

import java.util.List;

public interface PowerPressureService {

    List<PowerPressureDTO> getAllDTO();

    List<PowerPressureCommand> getAllCommand();

    PowerPressureDTO saveDTO(PowerPressureDTO powerPressureDTO);

    PowerPressureCommand saveCommand(PowerPressureCommand powerPressureCommand);

    PowerPressureDTO updateDTO(PowerPressureDTO powerPressureDTO);

    PowerPressureCommand updateCommand(PowerPressureCommand powerPressureCommand);


    PowerPressureDTO getByIdDTO(Long id);

    PowerPressureCommand getByIdCommand(Long id);

    void deleteDTO(PowerPressureDTO powerPressureDTO);

    void deleteCommand(PowerPressureCommand powerPressureCommand);

    List<PowerPressureDTO> retrieveDTO(Long userId, String identifier, String dataParameters,
                                       String startDate, String endDate,
                                       String userCommunity, String tempAverage,
                                       String outputFormat, String lat, String lon, String bbox);

    List<PowerPressureCommand> retrieveCommand(Long userId, String identifier, String dataParameters,
                                               String startDate, String endDate,
                                               String userCommunity, String tempAverage,
                                               String outputFormat, String lat, String lon, String bbox);


}
