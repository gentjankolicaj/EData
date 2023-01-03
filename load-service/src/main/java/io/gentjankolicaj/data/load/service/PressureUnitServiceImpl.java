package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.PressureUnitCommand;
import io.gentjankolicaj.data.load.common.domain.PressureUnit;
import io.gentjankolicaj.data.load.common.dto.PressureUnitDTO;
import io.gentjankolicaj.data.load.converter.PressureUnitConverter;
import io.gentjankolicaj.data.load.exception.resource.NullIdException;
import io.gentjankolicaj.data.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.data.load.exception.resource.PressureUnitNotFoundException;
import io.gentjankolicaj.data.load.repository.PressureUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PressureUnitServiceImpl implements PressureUnitService {

    private final PressureUnitRepository pressureUnitRepository;
    private final PressureUnitConverter pressureUnitConverter;

    @Autowired
    public PressureUnitServiceImpl(PressureUnitRepository pressureUnitRepository, PressureUnitConverter pressureUnitConverter) {
        this.pressureUnitRepository = pressureUnitRepository;
        this.pressureUnitConverter = pressureUnitConverter;
    }

    @Override
    public List<PressureUnitDTO> getAllDTO() {
        List<PressureUnitDTO> list = new ArrayList<>();
        Iterable<PressureUnit> iterable = pressureUnitRepository.findAll();
        for (PressureUnit temp : iterable) {
            list.add(pressureUnitConverter.sourceToDto(temp));
        }
        return list;
    }

    @Override
    public List<PressureUnitCommand> getAllCommand() {
        List<PressureUnitCommand> list = new ArrayList<>();
        Iterable<PressureUnit> iterable = pressureUnitRepository.findAll();
        for (PressureUnit temp : iterable) {
            list.add(pressureUnitConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public PressureUnitDTO saveDTO(PressureUnitDTO pressureUnitDTO) {
        if (pressureUnitDTO == null) {
            throw new NullReferenceException("PressureUnit not saved.Reference passed is null !!!");
        } else {
            PressureUnit savedPressureUnit = pressureUnitRepository.save(pressureUnitConverter.dtoToSource(pressureUnitDTO));
            return pressureUnitConverter.sourceToDto(savedPressureUnit);
        }
    }

    @Override
    public PressureUnitCommand saveCommand(PressureUnitCommand pressureUnitCommand) {
        if (pressureUnitCommand == null) {
            throw new NullReferenceException("PressureUnit not saved.Reference passed is null !!!");
        } else {
            PressureUnit savedPressureUnit = pressureUnitRepository.save(pressureUnitConverter.commandToSource(pressureUnitCommand));
            return pressureUnitConverter.sourceToCommand(savedPressureUnit);
        }
    }

    @Override
    public PressureUnitDTO updateDTO(PressureUnitDTO pressureUnitDTO) {
        if (pressureUnitDTO == null) {
            throw new NullReferenceException("PressureUnit not updated.Reference passed is null !!!");
        } else {
            PressureUnit newPressureUnit = pressureUnitConverter.dtoToSource(pressureUnitDTO);
            Optional<PressureUnit> optional = pressureUnitRepository.findById(newPressureUnit.getUnitCode());
            if (!optional.isPresent()) {
                PressureUnit savedPressureUnit = pressureUnitRepository.save(newPressureUnit);
                return pressureUnitConverter.sourceToDto(savedPressureUnit);
            } else {
                PressureUnit actual = optional.get();
                actual.setUnitName(newPressureUnit.getUnitName());
                actual.setUnitDescription(newPressureUnit.getUnitDescription());
                return pressureUnitConverter.sourceToDto(actual);
            }

        }
    }

    @Override
    public PressureUnitCommand updateCommand(PressureUnitCommand pressureUnitCommand) {
        if (pressureUnitCommand == null) {
            throw new NullReferenceException("PressureUnit not updated.Reference passed is null !!!");
        } else {
            PressureUnit newPressureUnit = pressureUnitConverter.commandToSource(pressureUnitCommand);
            Optional<PressureUnit> optional = pressureUnitRepository.findById(newPressureUnit.getUnitCode());
            if (!optional.isPresent()) {
                PressureUnit savedPressureUnit = pressureUnitRepository.save(newPressureUnit);
                return pressureUnitConverter.sourceToCommand(savedPressureUnit);
            } else {
                PressureUnit actual = optional.get();
                actual.setUnitName(newPressureUnit.getUnitName());
                actual.setUnitDescription(newPressureUnit.getUnitDescription());
                return pressureUnitConverter.sourceToCommand(actual);
            }

        }
    }

    @Override
    public PressureUnitDTO getByIdDTO(String id) {
        if (id == null) {
            throw new NullIdException("PressureUnit id is null.");
        } else {
            Optional<PressureUnit> optional = pressureUnitRepository.findById(id);
            if (!optional.isPresent()) {
                throw new PressureUnitNotFoundException("PressureUnit with id " + id + " not found.");
            } else {
                return pressureUnitConverter.sourceToDto(optional.get());
            }
        }

    }

    @Override
    public PressureUnitCommand getByIdCommand(String id) {
        if (id == null) {
            throw new NullIdException("PressureUnit id is null.");
        } else {
            Optional<PressureUnit> optional = pressureUnitRepository.findById(id);
            if (!optional.isPresent()) {
                throw new PressureUnitNotFoundException("PressureUnit with id " + id + " not found.");
            } else {
                return pressureUnitConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(PressureUnitDTO pressureUnitDTO) {
        if (pressureUnitDTO == null) {
            throw new NullReferenceException("PressureUnit not deleted.Reference passed is null !!!");
        } else {
            PressureUnit pressureUnit = pressureUnitConverter.dtoToSource(pressureUnitDTO);
            pressureUnitRepository.delete(pressureUnit);
        }

    }

    @Override
    public void deleteCommand(PressureUnitCommand pressureUnitCommand) {
        if (pressureUnitCommand == null) {
            throw new NullReferenceException("PressureUnit not deleted.Reference passed is null !!!");
        } else {
            PressureUnit pressureUnit = pressureUnitConverter.commandToSource(pressureUnitCommand);
            pressureUnitRepository.delete(pressureUnit);
        }
    }

    @Override
    public List<PressureUnitDTO> getByUnitNameDTO(String unitName) {
        if (unitName == null) {
            throw new NullReferenceException("PressureUnits not found.Reference passed is null !!!");
        } else {
            List<PressureUnit> tempList = pressureUnitRepository.findPressureUnitByUnitNameLike(unitName);
            return pressureUnitConverter.sourceToDto(tempList);
        }
    }

    @Override
    public List<PressureUnitCommand> getByUnitNameCommand(String unitName) {
        if (unitName == null) {
            throw new NullReferenceException("PressureUnits not found.Reference passed is null !!!");
        } else {
            List<PressureUnit> tempList = pressureUnitRepository.findPressureUnitByUnitNameLike(unitName);
            return pressureUnitConverter.sourceToCommand(tempList);
        }
    }
}
