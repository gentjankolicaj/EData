package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.TemperatureUnitCommand;
import io.gentjankolicaj.data.load.common.domain.TemperatureUnit;
import io.gentjankolicaj.data.load.common.dto.TemperatureUnitDTO;
import io.gentjankolicaj.data.load.converter.TemperatureUnitConverter;
import io.gentjankolicaj.data.load.exception.resource.NullIdException;
import io.gentjankolicaj.data.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.data.load.exception.resource.TemperatureUnitNotFoundException;
import io.gentjankolicaj.data.load.repository.TemperatureUnitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureUnitServiceImpl implements TemperatureUnitService {

    private final TemperatureUnitRepository temperatureUnitRepository;
    private final TemperatureUnitConverter temperatureUnitConverter;

    public TemperatureUnitServiceImpl(TemperatureUnitRepository temperatureUnitRepository, TemperatureUnitConverter temperatureUnitConverter) {
        this.temperatureUnitRepository = temperatureUnitRepository;
        this.temperatureUnitConverter = temperatureUnitConverter;
    }

    @Override
    public List<TemperatureUnitDTO> getAllDTO() {
        List<TemperatureUnitDTO> list=new ArrayList<>();
        Iterable<TemperatureUnit> iterable=temperatureUnitRepository.findAll();
        for(TemperatureUnit temp:iterable){
            list.add(temperatureUnitConverter.sourceToDto(temp));
        }
        return list;
    }

    @Override
    public List<TemperatureUnitCommand> getAllCommand() {
        List<TemperatureUnitCommand> list=new ArrayList<>();
        Iterable<TemperatureUnit> iterable=temperatureUnitRepository.findAll();
        for(TemperatureUnit temp:iterable){
            list.add(temperatureUnitConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public TemperatureUnitDTO saveDTO(TemperatureUnitDTO temperatureUnitDTO) {
        if(temperatureUnitDTO==null){
            throw new NullReferenceException("TemperatureUnit not saved.Reference passed is null !!!");
        }else{
            TemperatureUnit savedTemperatureUnit=temperatureUnitRepository.save(temperatureUnitConverter.dtoToSource(temperatureUnitDTO));
            return temperatureUnitConverter.sourceToDto(savedTemperatureUnit);
        }
    }

    @Override
    public TemperatureUnitCommand saveCommand(TemperatureUnitCommand temperatureUnitCommand) {
        if(temperatureUnitCommand==null){
            throw new NullReferenceException("TemperatureUnit not saved.Reference passed is null !!!");
        }else{
            TemperatureUnit savedTemperatureUnit=temperatureUnitRepository.save(temperatureUnitConverter.commandToSource(temperatureUnitCommand));
            return temperatureUnitConverter.sourceToCommand(savedTemperatureUnit);
        }
    }

    @Override
    public TemperatureUnitDTO updateDTO(TemperatureUnitDTO temperatureUnitDTO) {
        if(temperatureUnitDTO==null){
            throw new NullReferenceException("TemperatureUnit not updated.Reference passed is null !!!");
        }else{
            TemperatureUnit newTemperatureUnit=temperatureUnitConverter.dtoToSource(temperatureUnitDTO);
            Optional<TemperatureUnit> optional=temperatureUnitRepository.findById(newTemperatureUnit.getUnitCode());
            if(!optional.isPresent()){
                TemperatureUnit savedTemperatureUnit=temperatureUnitRepository.save(newTemperatureUnit);
                return temperatureUnitConverter.sourceToDto(savedTemperatureUnit);
            }else{
                TemperatureUnit actual=optional.get();
                actual.setUnitDescription(newTemperatureUnit.getUnitDescription());
                actual.setUnitName(newTemperatureUnit.getUnitName());
                return temperatureUnitConverter.sourceToDto(actual);
            }
        }
    }

    @Override
    public TemperatureUnitCommand updateCommand(TemperatureUnitCommand temperatureUnitCommand) {
        if(temperatureUnitCommand==null){
            throw new NullReferenceException("TemperatureUnit not updated.Reference passed is null !!!");
        }else{
            TemperatureUnit newTemperatureUnit=temperatureUnitConverter.commandToSource(temperatureUnitCommand);
            Optional<TemperatureUnit> optional=temperatureUnitRepository.findById(newTemperatureUnit.getUnitCode());
            if(!optional.isPresent()){
                TemperatureUnit savedTemperatureUnit=temperatureUnitRepository.save(newTemperatureUnit);
                return temperatureUnitConverter.sourceToCommand(savedTemperatureUnit);
            }else{
                TemperatureUnit actual=optional.get();
                actual.setUnitDescription(newTemperatureUnit.getUnitDescription());
                actual.setUnitName(newTemperatureUnit.getUnitName());
                return temperatureUnitConverter.sourceToCommand(actual);
            }
        }
    }

    @Override
    public TemperatureUnitDTO getByIdDTO(String id) {
        if(id==null){
            throw new NullIdException("TemperatureUnit id is null.");
        }else{
            Optional<TemperatureUnit> optional=temperatureUnitRepository.findById(id);
            if(!optional.isPresent()){
                throw new TemperatureUnitNotFoundException("TemperatureUnit with id "+id+" not found.");
            }else{
                return temperatureUnitConverter.sourceToDto(optional.get());
            }
        }
    }

    @Override
    public TemperatureUnitCommand getByIdCommand(String id) {
        if(id==null){
            throw new NullIdException("TemperatureUnit id is null.");
        }else{
            Optional<TemperatureUnit> optional=temperatureUnitRepository.findById(id);
            if(!optional.isPresent()){
                throw new TemperatureUnitNotFoundException("TemperatureUnit with id "+id+" not found.");
            }else{
                return temperatureUnitConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(TemperatureUnitDTO temperatureUnitDTO) {
        if(temperatureUnitDTO==null){
            throw new NullReferenceException("TemperatureUnit not deleted.Reference passed is null !!!");
        }else{
            TemperatureUnit temperatureUnit=temperatureUnitConverter.dtoToSource(temperatureUnitDTO);
            temperatureUnitRepository.delete(temperatureUnit);
        }

    }

    @Override
    public void deleteCommand(TemperatureUnitCommand temperatureUnitCommand) {
        if(temperatureUnitCommand==null){
            throw new NullReferenceException("TemperatureUnit not deleted.Reference passed is null !!!");
        }else{
            TemperatureUnit temperatureUnit=temperatureUnitConverter.commandToSource(temperatureUnitCommand);
            temperatureUnitRepository.delete(temperatureUnit);
        }
    }

    @Override
    public List<TemperatureUnitDTO> getByUnitNameDTO(String unitName) {
        return null;
    }

    @Override
    public List<TemperatureUnitCommand> getByUnitNameCommand(String unitName) {
        return null;
    }
}
