package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.TemperatureUnitCommand;
import io.gentjankolicaj.data.load.common.dto.TemperatureUnitDTO;

import java.util.List;

public interface TemperatureUnitService {

    List<TemperatureUnitDTO> getAllDTO();

    List<TemperatureUnitCommand> getAllCommand();

    TemperatureUnitDTO saveDTO(TemperatureUnitDTO temperatureUnitDTO);

    TemperatureUnitCommand saveCommand(TemperatureUnitCommand temperatureUnitCommand);

    TemperatureUnitDTO updateDTO(TemperatureUnitDTO temperatureUnitDTO);

    TemperatureUnitCommand updateCommand(TemperatureUnitCommand temperatureUnitCommand);

    TemperatureUnitDTO getByIdDTO(String id);

    TemperatureUnitCommand getByIdCommand(String id);

    void deleteDTO(TemperatureUnitDTO temperatureUnitDTO);

    void deleteCommand(TemperatureUnitCommand temperatureUnitCommand);

    List<TemperatureUnitDTO> getByUnitNameDTO(String unitName);

    List<TemperatureUnitCommand> getByUnitNameCommand(String unitName);
}
