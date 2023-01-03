package io.gentjankolicaj.data.load.converter.nasa.power;

import io.gentjankolicaj.data.load.common.command.nasa.power.PowerTemperatureCommand;
import io.gentjankolicaj.data.load.common.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.data.load.common.dto.nasa.power.PowerTemperatureDTO;
import io.gentjankolicaj.data.load.converter.DataFormatConverter;
import io.gentjankolicaj.data.load.converter.TemperatureUnitConverter;
import io.gentjankolicaj.data.load.converter.UserConverter;
import io.gentjankolicaj.data.load.converter.core.MyNasaPowerConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PowerTemperatureConverter implements MyNasaPowerConverter<PowerTemperature, PowerTemperatureDTO, PowerTemperatureCommand> {

    private final UserConverter userConverter;
    private final TemperatureUnitConverter temperatureUnitConverter;
    private final IdentifierConverter identifierConverter;
    private final DataFormatConverter dataFormatConverter;

    public PowerTemperatureConverter(UserConverter userConverter, TemperatureUnitConverter temperatureUnitConverter, IdentifierConverter identifierConverter, DataFormatConverter dataFormatConverter) {
        this.userConverter = userConverter;
        this.temperatureUnitConverter = temperatureUnitConverter;
        this.identifierConverter = identifierConverter;
        this.dataFormatConverter = dataFormatConverter;
    }

    @Override
    public PowerTemperatureDTO sourceToDto(PowerTemperature source) {
        if (source == null) {
            return null;
        } else {
            PowerTemperatureDTO powerTemperatureDTO = new PowerTemperatureDTO();
            powerTemperatureDTO.setId(source.getId());
            powerTemperatureDTO.setUserDTO(userConverter.sourceToDto(source.getUser()));
            powerTemperatureDTO.setValue(source.getValue());
            powerTemperatureDTO.setTemperatureUnitDTO(temperatureUnitConverter.sourceToDto(source.getTemperatureUnit()));
            powerTemperatureDTO.setDate(source.getDate());
            powerTemperatureDTO.setUrl(source.getUrl());
            powerTemperatureDTO.setIdentifierDTO(identifierConverter.sourceToDto(source.getIdentifier()));
            powerTemperatureDTO.setRawDataFormatDTO(dataFormatConverter.sourceToDto(source.getRawDataFormat()));
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
            powerTemperatureCommand.setUserCommand(userConverter.sourceToCommand(source.getUser()));
            powerTemperatureCommand.setValue(source.getValue());
            powerTemperatureCommand.setTemperatureUnitCommand(temperatureUnitConverter.sourceToCommand(source.getTemperatureUnit()));
            powerTemperatureCommand.setDate(source.getDate());
            powerTemperatureCommand.setUrl(source.getUrl());
            powerTemperatureCommand.setIdentifierCommand(identifierConverter.sourceToCommand(source.getIdentifier()));
            powerTemperatureCommand.setRawDataFormatCommand(dataFormatConverter.sourceToCommand(source.getRawDataFormat()));
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
            powerTemperature.setUser(userConverter.dtoToSource(dto.getUserDTO()));
            powerTemperature.setValue(dto.getValue());
            powerTemperature.setTemperatureUnit(temperatureUnitConverter.dtoToSource(dto.getTemperatureUnitDTO()));
            powerTemperature.setDate(dto.getDate());
            powerTemperature.setUrl(dto.getUrl());
            powerTemperature.setIdentifier(identifierConverter.dtoToSource(dto.getIdentifierDTO()));
            powerTemperature.setRawDataFormat(dataFormatConverter.dtoToSource(dto.getRawDataFormatDTO()));
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
            powerTemperature.setUser(userConverter.commandToSource(command.getUserCommand()));
            powerTemperature.setValue(command.getValue());
            powerTemperature.setTemperatureUnit(temperatureUnitConverter.commandToSource(command.getTemperatureUnitCommand()));
            powerTemperature.setDate(command.getDate());
            powerTemperature.setUrl(command.getUrl());
            powerTemperature.setIdentifier(identifierConverter.commandToSource(command.getIdentifierCommand()));
            powerTemperature.setRawDataFormat(dataFormatConverter.commandToSource(command.getRawDataFormatCommand()));
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
