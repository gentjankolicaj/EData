package edata.converter.nasa.power;

import edata.common.command.nasa.power.PowerPressureCommand;
import edata.common.domain.nasa.power.PowerPressure;
import edata.common.dto.nasa.power.PowerPressureDTO;
import edata.converter.DataFormatConverter;
import edata.converter.PressureUnitConverter;
import edata.converter.UserConverter;
import edata.converter.core.MyNasaPowerConverter;
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
            powerPressureDTO.setStartDate(source.getStartDate());
            powerPressureDTO.setEndDate(source.getEndDate());
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
            powerPressureCommand.setStartDate(source.getStartDate());
            powerPressureCommand.setEndDate(source.getEndDate());
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
            powerPressure.setStartDate(dto.getStartDate());
            powerPressure.setEndDate(dto.getEndDate());
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
            powerPressure.setStartDate(command.getStartDate());
            powerPressure.setEndDate(command.getEndDate());
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
}
