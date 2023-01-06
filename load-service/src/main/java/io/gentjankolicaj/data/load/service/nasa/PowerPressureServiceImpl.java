package io.gentjankolicaj.data.load.service.nasa;


import io.gentjankolicaj.data.commons.domain.User;
import io.gentjankolicaj.data.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.commons.enums.nasa.power.*;
import io.gentjankolicaj.data.load.common.command.nasa.power.PowerPressureCommand;
import io.gentjankolicaj.data.load.common.dto.nasa.power.PowerPressureDTO;
import io.gentjankolicaj.data.load.converter.nasa.power.PowerPressureConverter;
import io.gentjankolicaj.data.load.exception.resource.NullIdException;
import io.gentjankolicaj.data.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.data.load.exception.resource.PowerPressureNotFoundException;
import io.gentjankolicaj.data.load.repository.nasa.power.PowerPressureRepository;
import io.gentjankolicaj.data.load.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PowerPressureServiceImpl implements PowerPressureService {

    //todo: implementing not implemented methods from datalayer

    private final PowerPressureRepository powerPressureRepository;
    private final PowerPressureConverter powerPressureConverter;

    private final UserService userService;


    @Autowired
    public PowerPressureServiceImpl(PowerPressureRepository powerPressureRepository, PowerPressureConverter powerPressureConverter, UserService userService) {
        this.powerPressureRepository = powerPressureRepository;
        this.powerPressureConverter = powerPressureConverter;
        this.userService = userService;
    }

    @Override
    public List<PowerPressureDTO> getAllDTO() {
        List<PowerPressureDTO> list = new ArrayList<>();
        Iterable<PowerPressure> iterable = powerPressureRepository.findAll();
        for (PowerPressure temp : iterable) {
            list.add(powerPressureConverter.sourceToDto(temp));
        }
        return list;
    }

    @Override
    public List<PowerPressureCommand> getAllCommand() {
        List<PowerPressureCommand> list = new ArrayList<>();
        Iterable<PowerPressure> iterable = powerPressureRepository.findAll();
        for (PowerPressure temp : iterable) {
            list.add(powerPressureConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public PowerPressureDTO saveDTO(PowerPressureDTO powerPressureDTO) {
        if (powerPressureDTO == null) {
            throw new NullReferenceException("PowerPressure not saved.Reference passed is null !!!");
        } else {
            PowerPressure savedPowerPressure = powerPressureRepository.save(powerPressureConverter.dtoToSource(powerPressureDTO));
            return powerPressureConverter.sourceToDto(savedPowerPressure);
        }
    }

    @Override
    public PowerPressureCommand saveCommand(PowerPressureCommand powerPressureCommand) {
        if (powerPressureCommand == null) {
            throw new NullReferenceException("PowerPressure not saved.Reference passed is null !!!");
        } else {
            PowerPressure savedPowerPressure = powerPressureRepository.save(powerPressureConverter.commandToSource(powerPressureCommand));
            return powerPressureConverter.sourceToCommand(savedPowerPressure);
        }
    }

    @Override
    public PowerPressureDTO updateDTO(PowerPressureDTO powerPressureDTO) {
        if (powerPressureDTO == null) {
            throw new NullReferenceException("PowerPressure not updated.Reference passed is null !!!");
        } else {
            PowerPressure newPowerPressure = powerPressureConverter.dtoToSource(powerPressureDTO);
            Optional<PowerPressure> optional = powerPressureRepository.findById(newPowerPressure.getId());
            if (!optional.isPresent()) {
                PowerPressure savedPowerPressure = powerPressureRepository.save(newPowerPressure);
                return powerPressureConverter.sourceToDto(savedPowerPressure);
            } else {
                PowerPressure actual = optional.get();
                actual.setValue(newPowerPressure.getValue());
                actual.setPressureUnit(newPowerPressure.getPressureUnit());
                actual.setDate(newPowerPressure.getDate());
                actual.setRawDataFormat(newPowerPressure.getRawDataFormat());
                return powerPressureConverter.sourceToDto(actual);
            }
        }
    }

    @Override
    public PowerPressureCommand updateCommand(PowerPressureCommand powerPressureCommand) {
        if (powerPressureCommand == null) {
            throw new NullReferenceException("PowerPressure not updated.Reference passed is null !!!");
        } else {
            PowerPressure newPowerPressure = powerPressureConverter.commandToSource(powerPressureCommand);
            Optional<PowerPressure> optional = powerPressureRepository.findById(newPowerPressure.getId());
            if (!optional.isPresent()) {
                PowerPressure savedPowerPressure = powerPressureRepository.save(newPowerPressure);
                return powerPressureConverter.sourceToCommand(savedPowerPressure);
            } else {
                PowerPressure actual = optional.get();
                actual.setValue(newPowerPressure.getValue());
                actual.setPressureUnit(newPowerPressure.getPressureUnit());
                actual.setDate(newPowerPressure.getDate());
                actual.setRawDataFormat(newPowerPressure.getRawDataFormat());
                return powerPressureConverter.sourceToCommand(actual);
            }
        }
    }

    @Override
    public PowerPressureDTO getByIdDTO(Long id) {
        if (id == null) {
            throw new NullIdException("PowerPressure id is null.");
        } else {
            Optional<PowerPressure> optional = powerPressureRepository.findById(id);
            if (!optional.isPresent()) {
                throw new PowerPressureNotFoundException("PowerPressure with id " + id + " not found.");
            } else {
                return powerPressureConverter.sourceToDto(optional.get());
            }
        }
    }

    @Override
    public PowerPressureCommand getByIdCommand(Long id) {
        if (id == null) {
            throw new NullIdException("PowerPressure id is null.");
        } else {
            Optional<PowerPressure> optional = powerPressureRepository.findById(id);
            if (!optional.isPresent()) {
                throw new PowerPressureNotFoundException("PowerPressure with id " + id + " not found.");
            } else {
                return powerPressureConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(PowerPressureDTO powerPressureDTO) {
        if (powerPressureDTO == null) {
            throw new NullReferenceException("PowerPressure not deleted.Reference passed is null !!!");
        } else {
            PowerPressure powerPressure = powerPressureConverter.dtoToSource(powerPressureDTO);
            powerPressureRepository.delete(powerPressure);
        }
    }

    @Override
    public void deleteCommand(PowerPressureCommand powerPressureCommand) {
        if (powerPressureCommand == null) {
            throw new NullReferenceException("PowerPressure not deleted.Reference passed is null !!!");
        } else {
            PowerPressure powerPressure = powerPressureConverter.commandToSource(powerPressureCommand);
            powerPressureRepository.delete(powerPressure);
        }
    }

    @Override
    public List<PowerPressureDTO> retrieveDTO(Long userId, String identifier, String dataParameters, String startDate, String endDate, String userCommunity, String tempAverage, String outputFormat, String lat, String lon, String bbox) {
        Identifier identifierEnum = Identifier.valueOf(identifier);
        DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
        UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
        TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
        OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);

        //Find user
        User user = userService.getById(userId);


        //Retrieved data.
        List<PowerPressure> retrievedList = null;//nasaClient.retrievePressure(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

        //Save data to db
        Iterable<PowerPressure> savedData = saveRetrievedData(retrievedList, user);

        return powerPressureConverter.sourceToDto(savedData);

    }

    @Override
    public List<PowerPressureCommand> retrieveCommand(Long userId, String identifier, String dataParameters, String startDate, String endDate, String userCommunity, String tempAverage, String outputFormat, String lat, String lon, String bbox) {
        Identifier identifierEnum = Identifier.valueOf(identifier);
        DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
        UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
        TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
        OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);

        //Find user
        User user = userService.getById(userId);

        //Retrieved data.
        List<PowerPressure> retrievedList = null;// nasaClient.retrievePressure(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

        //Saved data to db
        Iterable<PowerPressure> savedData = saveRetrievedData(retrievedList, user);

        return powerPressureConverter.sourceToCommand(savedData);
    }


    private Iterable<PowerPressure> saveRetrievedData(List<PowerPressure> retrievedList, User user) {
        return powerPressureRepository.saveAll(retrievedList);
    }


}
