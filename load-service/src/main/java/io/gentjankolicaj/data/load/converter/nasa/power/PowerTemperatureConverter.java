package io.gentjankolicaj.data.load.converter.nasa.power;

import io.gentjankolicaj.data.commons.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.data.load.common.command.nasa.power.PowerTemperatureCommand;
import io.gentjankolicaj.data.load.common.dto.nasa.power.PowerTemperatureDTO;
import io.gentjankolicaj.data.load.converter.TemperatureUnitConverter;
import io.gentjankolicaj.data.load.converter.core.MyNasaPowerConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PowerTemperatureConverter implements MyNasaPowerConverter<PowerTemperature, PowerTemperatureDTO, PowerTemperatureCommand> {


    private final TemperatureUnitConverter temperatureUnitConverter;

    public PowerTemperatureConverter(TemperatureUnitConverter temperatureUnitConverter) {
        this.temperatureUnitConverter = temperatureUnitConverter;

    }

    @Override
    public PowerTemperatureDTO sourceToDto(PowerTemperature source) {
        if (source == null) {
            return null;
        } else {
            PowerTemperatureDTO powerTemperatureDTO = new PowerTemperatureDTO();
            powerTemperatureDTO.setId(source.getId());
            powerTemperatureDTO.setValue(source.getValue());
            powerTemperatureDTO.setTemperatureUnitDTO(temperatureUnitConverter.sourceToDto(source.getTemperatureUnit()));
            powerTemperatureDTO.setDate(source.getDate());
            return powerTemperatureDTO;
        }
    }

    @Override
    public PowerTemperatureCommand sourceToCommand(PowerTemperature source) {
        if (source == null) {
            return null;
        } else {
            PowerTemperatureCommand powerTemperatureCommand = new PowerTemperatureCommand();
            powerTemperatureCommand.setId(source.getId());
            powerTemperatureCommand.setValue(source.getValue());
            powerTemperatureCommand.setTemperatureUnitCommand(temperatureUnitConverter.sourceToCommand(source.getTemperatureUnit()));
            powerTemperatureCommand.setDate(source.getDate());
            return powerTemperatureCommand;

        }
    }

    @Override
    public PowerTemperature dtoToSource(PowerTemperatureDTO dto) {
        if (dto == null) {
            return null;
        } else {
            PowerTemperature powerTemperature = new PowerTemperature();
            powerTemperature.setId(dto.getId());
            powerTemperature.setValue(dto.getValue());
            powerTemperature.setTemperatureUnit(temperatureUnitConverter.dtoToSource(dto.getTemperatureUnitDTO()));
            powerTemperature.setDate(dto.getDate());
            return powerTemperature;
        }
    }

    @Override
    public PowerTemperature commandToSource(PowerTemperatureCommand command) {
        if (command == null) {
            return null;
        } else {
            PowerTemperature powerTemperature = new PowerTemperature();
            powerTemperature.setId(command.getId());
            powerTemperature.setValue(command.getValue());
            powerTemperature.setTemperatureUnit(temperatureUnitConverter.commandToSource(command.getTemperatureUnitCommand()));
            powerTemperature.setDate(command.getDate());
            return powerTemperature;
        }
    }

    @Override
    public List<PowerTemperatureDTO> sourceToDto(List<PowerTemperature> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<PowerTemperatureDTO> tempList = new ArrayList<>(source.size());
            for (PowerTemperature temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PowerTemperatureCommand> sourceToCommand(List<PowerTemperature> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<PowerTemperatureCommand> tempList = new ArrayList<>(source.size());
            for (PowerTemperature temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PowerTemperatureDTO> sourceToDto(Iterable<PowerTemperature> source) {
        if (source == null) {
            return null;
        } else {
            List<PowerTemperatureDTO> tempList = new ArrayList<>();
            for (PowerTemperature temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PowerTemperatureCommand> sourceToCommand(Iterable<PowerTemperature> source) {
        if (source == null) {
            return null;
        } else {
            List<PowerTemperatureCommand> tempList = new ArrayList<>();
            for (PowerTemperature temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }

}
