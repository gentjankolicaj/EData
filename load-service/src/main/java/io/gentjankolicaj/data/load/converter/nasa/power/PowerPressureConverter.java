package io.gentjankolicaj.data.load.converter.nasa.power;

import io.gentjankolicaj.data.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.load.common.command.nasa.power.PowerPressureCommand;
import io.gentjankolicaj.data.load.common.dto.nasa.power.PowerPressureDTO;
import io.gentjankolicaj.data.load.converter.PressureUnitConverter;
import io.gentjankolicaj.data.load.converter.core.MyNasaPowerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PowerPressureConverter implements MyNasaPowerConverter<PowerPressure, PowerPressureDTO, PowerPressureCommand> {

    private final PressureUnitConverter pressureUnitConverter;


    @Autowired
    public PowerPressureConverter(PressureUnitConverter pressureUnitConverter) {
        this.pressureUnitConverter = pressureUnitConverter;
    }

    @Override
    public PowerPressureDTO sourceToDto(PowerPressure source) {
        if (source == null) {
            return null;
        } else {
            PowerPressureDTO powerPressureDTO = new PowerPressureDTO();
            powerPressureDTO.setId(source.getId());
            powerPressureDTO.setValue(source.getValue());
            powerPressureDTO.setPressureUnitDTO(pressureUnitConverter.sourceToDto(source.getPressureUnit()));
            powerPressureDTO.setDate(source.getDate());
            return powerPressureDTO;
        }
    }

    @Override
    public PowerPressureCommand sourceToCommand(PowerPressure source) {
        if (source == null) {
            return null;
        } else {
            PowerPressureCommand powerPressureCommand = new PowerPressureCommand();
            powerPressureCommand.setId(source.getId());
            powerPressureCommand.setValue(source.getValue());
            powerPressureCommand.setPressureUnitCommand(pressureUnitConverter.sourceToCommand(source.getPressureUnit()));
            powerPressureCommand.setDate(source.getDate());
            return powerPressureCommand;
        }
    }

    @Override
    public PowerPressure dtoToSource(PowerPressureDTO dto) {
        if (dto == null) {
            return null;
        } else {
            PowerPressure powerPressure = new PowerPressure();
            powerPressure.setId(dto.getId());
            powerPressure.setValue(dto.getValue());
            powerPressure.setPressureUnit(pressureUnitConverter.dtoToSource(dto.getPressureUnitDTO()));
            powerPressure.setDate(dto.getDate());
            return powerPressure;
        }
    }

    @Override
    public PowerPressure commandToSource(PowerPressureCommand command) {
        if (command == null) {
            return null;
        } else {
            PowerPressure powerPressure = new PowerPressure();
            powerPressure.setId(command.getId());
            powerPressure.setValue(command.getValue());
            powerPressure.setPressureUnit(pressureUnitConverter.commandToSource(command.getPressureUnitCommand()));
            powerPressure.setDate(command.getDate());
            return powerPressure;
        }
    }

    @Override
    public List<PowerPressureDTO> sourceToDto(List<PowerPressure> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<PowerPressureDTO> tempList = new ArrayList<>(source.size());
            for (PowerPressure temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PowerPressureCommand> sourceToCommand(List<PowerPressure> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<PowerPressureCommand> tempList = new ArrayList<>(source.size());
            for (PowerPressure temp : source) {
                tempList.add(sourceToCommand(temp));
            }

            return tempList;
        }
    }

    @Override
    public List<PowerPressureDTO> sourceToDto(Iterable<PowerPressure> source) {
        if (source == null) {
            return null;
        } else {
            List<PowerPressureDTO> tempList = new ArrayList<>();
            for (PowerPressure temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PowerPressureCommand> sourceToCommand(Iterable<PowerPressure> source) {
        if (source == null) {
            return null;
        } else {
            List<PowerPressureCommand> tempList = new ArrayList<>();
            for (PowerPressure temp : source) {
                tempList.add(sourceToCommand(temp));
            }

            return tempList;
        }
    }

}
