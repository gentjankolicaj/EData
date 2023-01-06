package io.gentjankolicaj.data.load.converter;

import io.gentjankolicaj.data.commons.domain.TemperatureUnit;
import io.gentjankolicaj.data.load.common.command.TemperatureUnitCommand;
import io.gentjankolicaj.data.load.common.dto.TemperatureUnitDTO;
import io.gentjankolicaj.data.load.converter.core.MyConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemperatureUnitConverter implements MyConverter<TemperatureUnit, TemperatureUnitDTO, TemperatureUnitCommand> {

    public TemperatureUnitConverter() {
    }

    @Override
    public TemperatureUnitDTO sourceToDto(TemperatureUnit source) {
        if (source == null) {
            return null;
        } else {
            TemperatureUnitDTO temperatureUnitDTO = new TemperatureUnitDTO();
            temperatureUnitDTO.setUnitName(source.getUnitName());
            temperatureUnitDTO.setUnitCode(source.getUnitCode());
            temperatureUnitDTO.setUnitDescription(source.getUnitDescription());
            return temperatureUnitDTO;
        }
    }

    @Override
    public TemperatureUnitCommand sourceToCommand(TemperatureUnit source) {
        if (source == null) {
            return null;
        } else {
            TemperatureUnitCommand temperatureUnitCommand = new TemperatureUnitCommand();
            temperatureUnitCommand.setUnitName(source.getUnitName());
            temperatureUnitCommand.setUnitCode(source.getUnitCode());
            temperatureUnitCommand.setUnitDescription(source.getUnitDescription());
            return temperatureUnitCommand;
        }
    }

    @Override
    public TemperatureUnit dtoToSource(TemperatureUnitDTO dto) {
        if (dto == null) {
            return null;
        } else {
            TemperatureUnit temperatureUnit = new TemperatureUnit();
            temperatureUnit.setUnitName(dto.getUnitName());
            temperatureUnit.setUnitCode(dto.getUnitCode());
            temperatureUnit.setUnitDescription(dto.getUnitDescription());
            return temperatureUnit;
        }
    }

    @Override
    public TemperatureUnit commandToSource(TemperatureUnitCommand command) {
        if (command == null) {
            return null;
        } else {
            TemperatureUnit temperatureUnit = new TemperatureUnit();
            temperatureUnit.setUnitName(command.getUnitName());
            temperatureUnit.setUnitCode(command.getUnitCode());
            temperatureUnit.setUnitDescription(command.getUnitDescription());
            return temperatureUnit;

        }
    }

    @Override
    public List<TemperatureUnitDTO> sourceToDto(List<TemperatureUnit> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<TemperatureUnitDTO> tempList = new ArrayList<>(source.size());
            for (TemperatureUnit temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<TemperatureUnitCommand> sourceToCommand(List<TemperatureUnit> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<TemperatureUnitCommand> tempList = new ArrayList<>(source.size());
            for (TemperatureUnit temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }
}
