package edata.service.nasa;


import edata.common.command.nasa.power.PowerPressureCommand;
import edata.common.domain.nasa.power.PowerPressure;
import edata.common.dto.nasa.power.PowerPressureDTO;
import edata.converter.nasa.power.PowerPressureConverter;
import edata.exception.resource.NullIdException;
import edata.exception.resource.NullReferenceException;
import edata.exception.resource.PowerPressureNotFoundException;
import edata.repository.nasa.power.PowerPressureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PowerPressureServiceImpl implements PowerPressureService {

    //todo: implementing not implemented methods from datalayer

    private final PowerPressureRepository powerPressureRepository;
    private final PowerPressureConverter powerPressureConverter;

    public PowerPressureServiceImpl(PowerPressureRepository powerPressureRepository, PowerPressureConverter powerPressureConverter) {
        this.powerPressureRepository = powerPressureRepository;
        this.powerPressureConverter = powerPressureConverter;
    }

    @Override
    public List<PowerPressureDTO> getAllDTO() {
        List<PowerPressureDTO> list=new ArrayList<>();
        Iterable<PowerPressure> iterable=powerPressureRepository.findAll();
        for(PowerPressure temp:iterable){
            list.add(powerPressureConverter.sourceToDto(temp));
        }
        return list;
    }

    @Override
    public List<PowerPressureCommand> getAllCommand() {
        List<PowerPressureCommand> list=new ArrayList<>();
        Iterable<PowerPressure> iterable=powerPressureRepository.findAll();
        for(PowerPressure temp:iterable){
            list.add(powerPressureConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public PowerPressureDTO saveDTO(PowerPressureDTO powerPressureDTO) {
        if(powerPressureDTO==null){
            throw new NullReferenceException("PowerPressure not saved.Reference passed is null !!!");
        }else{
            PowerPressure savedPowerPressure=powerPressureRepository.save(powerPressureConverter.dtoToSource(powerPressureDTO));
            return powerPressureConverter.sourceToDto(savedPowerPressure);
        }
    }

    @Override
    public PowerPressureCommand saveCommand(PowerPressureCommand powerPressureCommand){
        if(powerPressureCommand==null){
            throw new NullReferenceException("PowerPressure not saved.Reference passed is null !!!");
        }else{
            PowerPressure savedPowerPressure=powerPressureRepository.save(powerPressureConverter.commandToSource(powerPressureCommand));
            return powerPressureConverter.sourceToCommand(savedPowerPressure);
        }
    }

    @Override
    public PowerPressureDTO updateDTO(PowerPressureDTO powerPressureDTO) {
        if(powerPressureDTO==null){
            throw new NullReferenceException("PowerPressure not updated.Reference passed is null !!!");
        }else{
            PowerPressure newPowerPressure=powerPressureConverter.dtoToSource(powerPressureDTO);
            Optional<PowerPressure> optional=powerPressureRepository.findById(newPowerPressure.getId());
            if(!optional.isPresent()){
                PowerPressure savedPowerPressure=powerPressureRepository.save(newPowerPressure);
                return powerPressureConverter.sourceToDto(savedPowerPressure);
              }else{
                PowerPressure actual=optional.get();
                actual.setUser(newPowerPressure.getUser());
                actual.setValue(newPowerPressure.getValue());
                actual.setPressureUnit(newPowerPressure.getPressureUnit());
                actual.setStartDate(newPowerPressure.getStartDate());
                actual.setEndDate(newPowerPressure.getEndDate());
                actual.setUrl(newPowerPressure.getUrl());
                actual.setIdentifier(newPowerPressure.getIdentifier());
                actual.setRawDataFormat(newPowerPressure.getRawDataFormat());
                return powerPressureConverter.sourceToDto(actual);
            }
        }
    }

    @Override
    public PowerPressureCommand updateCommand(PowerPressureCommand powerPressureCommand) {
        if(powerPressureCommand==null){
            throw new NullReferenceException("PowerPressure not updated.Reference passed is null !!!");
        }else{
            PowerPressure newPowerPressure=powerPressureConverter.commandToSource(powerPressureCommand);
            Optional<PowerPressure> optional=powerPressureRepository.findById(newPowerPressure.getId());
            if(!optional.isPresent()){
                PowerPressure savedPowerPressure=powerPressureRepository.save(newPowerPressure);
                return powerPressureConverter.sourceToCommand(savedPowerPressure);
            }else{
                PowerPressure actual=optional.get();
                actual.setUser(newPowerPressure.getUser());
                actual.setValue(newPowerPressure.getValue());
                actual.setPressureUnit(newPowerPressure.getPressureUnit());
                actual.setStartDate(newPowerPressure.getStartDate());
                actual.setEndDate(newPowerPressure.getEndDate());
                actual.setUrl(newPowerPressure.getUrl());
                actual.setIdentifier(newPowerPressure.getIdentifier());
                actual.setRawDataFormat(newPowerPressure.getRawDataFormat());
                return powerPressureConverter.sourceToCommand(actual);
            }
        }
    }

    @Override
    public PowerPressureDTO getByIdDTO(Long id) {
        if(id==null){
            throw new NullIdException("PowerPressure id is null.");
        }else{
            Optional<PowerPressure> optional=powerPressureRepository.findById(id);
            if(!optional.isPresent()){
                throw new PowerPressureNotFoundException("PowerPressure with id "+id+" not found.");
            }else{
                return powerPressureConverter.sourceToDto(optional.get());
            }
        }
    }

    @Override
    public PowerPressureCommand getByIdCommand(Long id) {
        if(id==null){
            throw new NullIdException("PowerPressure id is null.");
        }else{
            Optional<PowerPressure> optional=powerPressureRepository.findById(id);
            if(!optional.isPresent()){
                throw new PowerPressureNotFoundException("PowerPressure with id "+id+" not found.");
            }else{
                return powerPressureConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(PowerPressureDTO powerPressureDTO) {
        if(powerPressureDTO==null){
            throw new NullReferenceException("PowerPressure not deleted.Reference passed is null !!!");
        }else{
            PowerPressure powerPressure=powerPressureConverter.dtoToSource(powerPressureDTO);
            powerPressureRepository.delete(powerPressure);
        }
    }

    @Override
    public void deleteCommand(PowerPressureCommand powerPressureCommand) {
        if(powerPressureCommand==null){
            throw new NullReferenceException("PowerPressure not deleted.Reference passed is null !!!");
        }else{
            PowerPressure powerPressure=powerPressureConverter.commandToSource(powerPressureCommand);
            powerPressureRepository.delete(powerPressure);
        }
    }


}
