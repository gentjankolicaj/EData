package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.PressureUnitCommand;
import io.gentjankolicaj.data.load.common.dto.PressureUnitDTO;

import java.util.List;

public interface PressureUnitService {

    List<PressureUnitDTO> getAllDTO();
    List<PressureUnitCommand> getAllCommand();

    PressureUnitDTO saveDTO(PressureUnitDTO pressureUnitDTO);
    PressureUnitCommand saveCommand(PressureUnitCommand pressureUnitCommand);

    PressureUnitDTO updateDTO(PressureUnitDTO pressureUnitDTO);
    PressureUnitCommand updateCommand(PressureUnitCommand pressureUnitCommand);

    PressureUnitDTO getByIdDTO(String id);
    PressureUnitCommand  getByIdCommand(String id);

    void deleteDTO(PressureUnitDTO pressureUnitDTO);
    void deleteCommand(PressureUnitCommand pressureUnitCommand);

    List<PressureUnitDTO> getByUnitNameDTO(String unitName);
    List<PressureUnitCommand> getByUnitNameCommand(String unitName);
}
