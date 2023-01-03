package io.gentjankolicaj.data.load.converter.nasa.power;

import io.gentjankolicaj.data.load.common.command.nasa.power.PowerPressureCommand;
import io.gentjankolicaj.data.load.common.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.load.common.dto.nasa.power.PowerPressureDTO;
import io.gentjankolicaj.data.load.converter.DataFormatConverter;
import io.gentjankolicaj.data.load.converter.PressureUnitConverter;
import io.gentjankolicaj.data.load.converter.UserConverter;
import io.gentjankolicaj.data.load.converter.core.MyNasaPowerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PowerPressureConverter implements MyNasaPowerConverter<PowerPressure, PowerPressureDTO, PowerPressureCommand> {

    private final PressureUnitConverter pressureUnitConverter;
    private final UserConverter userConverter;
    private final IdentifierConverter identifierConverter;
    private final DataFormatConverter dataFormatConverter;

    @Autowired
    public PowerPressureConverter(PressureUnitConverter pressureUnitConverter, UserConverter userConverter, IdentifierConverter identifierConverter, DataFormatConverter dataFormatConverter) {
        this.pressureUnitConverter = pressureUnitConverter;
        this.userConverter = userConverter;
        this.identifierConverter = identifierConverter;
        this.dataFormatConverter = dataFormatConverter;
    }

    @Override
    public PowerPressureDTO sourceToDto(PowerPressure source) {
        if(source==null){
            return null;
        }else{
            PowerPressureDTO powerPressureDTO=new PowerPressureDTO();
            powerPressureDTO.setId(source.getId());
            powerPressureDTO.setUserDTO(userConverter.sourceToDto(source.getUser()));
            powerPressureDTO.setValue(source.getValue());
            powerPressureDTO.setPressureUnitDTO(pressureUnitConverter.sourceToDto(source.getPressureUnit()));
            powerPressureDTO.setDate(source.getDate());
            powerPressureDTO.setUrl(source.getUrl());
            powerPressureDTO.setIdentifierDTO(identifierConverter.sourceToDto(source.getIdentifier()));
            powerPressureDTO.setRawDataFormatDTO(dataFormatConverter.sourceToDto(source.getRawDataFormat()));
            return powerPressureDTO;
        }
    }

    @Override
    public PowerPressureCommand sourceToCommand(PowerPressure source) {
        if(source==null){
            return null;
        }else{
            PowerPressureCommand powerPressureCommand=new PowerPressureCommand();
            powerPressureCommand.setId(source.getId());
            powerPressureCommand.setUserCommand(userConverter.sourceToCommand(source.getUser()));
            powerPressureCommand.setValue(source.getValue());
            powerPressureCommand.setPressureUnitCommand(pressureUnitConverter.sourceToCommand(source.getPressureUnit()));
            powerPressureCommand.setDate(source.getDate());
            powerPressureCommand.setUrl(source.getUrl());
            powerPressureCommand.setIdentifierCommand(identifierConverter.sourceToCommand(source.getIdentifier()));
            powerPressureCommand.setRawDataFormatCommand(dataFormatConverter.sourceToCommand(source.getRawDataFormat()));
            return powerPressureCommand;
        }
    }

    @Override
    public PowerPressure dtoToSource(PowerPressureDTO dto) {
        if(dto==null){
            return null;
        }else{
            PowerPressure powerPressure=new PowerPressure();
            powerPressure.setId(dto.getId());
            powerPressure.setUser(userConverter.dtoToSource(dto.getUserDTO()));
            powerPressure.setValue(dto.getValue());
            powerPressure.setPressureUnit(pressureUnitConverter.dtoToSource(dto.getPressureUnitDTO()));
            powerPressure.setDate(dto.getDate());
            powerPressure.setUrl(dto.getUrl());
            powerPressure.setIdentifier(identifierConverter.dtoToSource(dto.getIdentifierDTO()));
            powerPressure.setRawDataFormat(dataFormatConverter.dtoToSource(dto.getRawDataFormatDTO()));
            return powerPressure;
        }
    }

    @Override
    public PowerPressure commandToSource(PowerPressureCommand command) {
        if(command==null){
            return null;
        }else{
            PowerPressure powerPressure=new PowerPressure();
            powerPressure.setId(command.getId());
            powerPressure.setUser(userConverter.commandToSource(command.getUserCommand()));
            powerPressure.setValue(command.getValue());
            powerPressure.setPressureUnit(pressureUnitConverter.commandToSource(command.getPressureUnitCommand()));
            powerPressure.setDate(command.getDate());
            powerPressure.setUrl(command.getUrl());
            powerPressure.setIdentifier(identifierConverter.commandToSource(command.getIdentifierCommand()));
            powerPressure.setRawDataFormat(dataFormatConverter.commandToSource(command.getRawDataFormatCommand()));
            return powerPressure;
        }
    }

    @Override
    public List<PowerPressureDTO> sourceToDto(List<PowerPressure> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<PowerPressureDTO> tempList=new ArrayList<>(source.size());
            for(PowerPressure temp:source){
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PowerPressureCommand> sourceToCommand(List<PowerPressure> source) {
        if(source==null||source.size()==0){
            return null;
        }else{
            List<PowerPressureCommand> tempList=new ArrayList<>(source.size());
            for(PowerPressure temp:source){
                tempList.add(sourceToCommand(temp));
            }

            return tempList;
        }
    }

    @Override
    public List<PowerPressureDTO> sourceToDto(Iterable<PowerPressure> source) {
        if(source==null){
            return null;
        }else{
            List<PowerPressureDTO> tempList=new ArrayList<>();
            for(PowerPressure temp:source){
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<PowerPressureCommand> sourceToCommand(Iterable<PowerPressure> source) {
        if(source==null){
            return null;
        }else{
            List<PowerPressureCommand> tempList=new ArrayList<>();
            for(PowerPressure temp:source){
                tempList.add(sourceToCommand(temp));
            }

            return tempList;
        }
    }

}
