package edata.service.nasa;

import edata.client.nasa_power.NasaClient;
import edata.common.command.nasa.power.PowerTemperatureCommand;
import edata.common.domain.User;
import edata.common.domain.nasa.power.PowerTemperature;
import edata.common.dto.nasa.power.PowerTemperatureDTO;
import edata.common.enums.power.*;
import edata.converter.nasa.power.PowerTemperatureConverter;
import edata.exception.resource.NullIdException;
import edata.exception.resource.NullReferenceException;
import edata.exception.resource.PowerTemperatureNotFoundException;
import edata.repository.nasa.power.PowerTemperatureRepository;
import edata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PowerTemperatureServiceImpl implements PowerTemperatureService {

    //todo: implementing not implemented methods from datalayer

    private final PowerTemperatureRepository powerTemperatureRepository;
    private final PowerTemperatureConverter powerTemperatureConverter;
    private final NasaClient nasaClient;
    private final UserService userService;


    @Autowired
    public PowerTemperatureServiceImpl(PowerTemperatureRepository powerTemperatureRepository, PowerTemperatureConverter powerTemperatureConverter, NasaClient nasaClient, UserService userService) {
        this.powerTemperatureRepository = powerTemperatureRepository;
        this.powerTemperatureConverter = powerTemperatureConverter;
        this.nasaClient = nasaClient;
        this.userService = userService;
    }

    @Override
    public List<PowerTemperatureDTO> getAllDTO() {
        List<PowerTemperatureDTO> list = new ArrayList<>();
        Iterable<PowerTemperature> iterable = powerTemperatureRepository.findAll();
        for (PowerTemperature temp : iterable) {
            list.add(powerTemperatureConverter.sourceToDto(temp));
        }
        return list;
    }

    @Override
    public List<PowerTemperatureCommand> getAllCommand() {
        List<PowerTemperatureCommand> list = new ArrayList<>();
        Iterable<PowerTemperature> iterable = powerTemperatureRepository.findAll();
        for (PowerTemperature temp : iterable) {
            list.add(powerTemperatureConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public PowerTemperatureDTO saveDTO(PowerTemperatureDTO powerTemperatureDTO) {
        if (powerTemperatureDTO == null) {
            throw new NullReferenceException("PowerTemperature not saved.Reference passed is null !!!");
        } else {
            PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(powerTemperatureConverter.dtoToSource(powerTemperatureDTO));
            return powerTemperatureConverter.sourceToDto(savedPowerTemperature);
        }
    }

    @Override
    public PowerTemperatureCommand saveCommand(PowerTemperatureCommand powerTemperatureCommand) {
        if (powerTemperatureCommand == null) {
            throw new NullReferenceException("PowerTemperature not saved.Reference passed is null !!!");
        } else {
            PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(powerTemperatureConverter.commandToSource(powerTemperatureCommand));
            return powerTemperatureConverter.sourceToCommand(savedPowerTemperature);
        }
    }

    @Override
    public PowerTemperatureDTO updateDTO(PowerTemperatureDTO powerTemperatureDTO) {
        if (powerTemperatureDTO == null) {
            throw new NullReferenceException("PowerTemperature not updated.Reference passed is null !!!");
        } else {
            PowerTemperature newPowerTemperature = powerTemperatureConverter.dtoToSource(powerTemperatureDTO);
            Optional<PowerTemperature> optional = powerTemperatureRepository.findById(newPowerTemperature.getId());
            if (!optional.isPresent()) {
                PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(newPowerTemperature);
                return powerTemperatureConverter.sourceToDto(savedPowerTemperature);
            } else {
                PowerTemperature actual = optional.get();
                actual.setUser(newPowerTemperature.getUser());
                actual.setValue(newPowerTemperature.getValue());
                actual.setTemperatureUnit(newPowerTemperature.getTemperatureUnit());
                actual.setStartDate(newPowerTemperature.getStartDate());
                actual.setEndDate(newPowerTemperature.getEndDate());
                actual.setUrl(newPowerTemperature.getUrl());
                actual.setIdentifier(newPowerTemperature.getIdentifier());
                actual.setRawDataFormat(newPowerTemperature.getRawDataFormat());
                return powerTemperatureConverter.sourceToDto(actual);
            }
        }
    }

    @Override
    public PowerTemperatureCommand updateCommand(PowerTemperatureCommand powerTemperatureCommand) {
        if (powerTemperatureCommand == null) {
            throw new NullReferenceException("PowerTemperature not updated.Reference passed is null !!!");
        } else {
            PowerTemperature newPowerTemperature = powerTemperatureConverter.commandToSource(powerTemperatureCommand);
            Optional<PowerTemperature> optional = powerTemperatureRepository.findById(newPowerTemperature.getId());
            if (!optional.isPresent()) {
                PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(newPowerTemperature);
                return powerTemperatureConverter.sourceToCommand(savedPowerTemperature);
            } else {
                PowerTemperature actual = optional.get();
                actual.setUser(newPowerTemperature.getUser());
                actual.setValue(newPowerTemperature.getValue());
                actual.setTemperatureUnit(newPowerTemperature.getTemperatureUnit());
                actual.setStartDate(newPowerTemperature.getStartDate());
                actual.setEndDate(newPowerTemperature.getEndDate());
                actual.setUrl(newPowerTemperature.getUrl());
                actual.setIdentifier(newPowerTemperature.getIdentifier());
                actual.setRawDataFormat(newPowerTemperature.getRawDataFormat());
                return powerTemperatureConverter.sourceToCommand(actual);
            }
        }
    }

    @Override
    public PowerTemperatureDTO getByIdDTO(Long id) {
        if (id == null) {
            throw new NullIdException("PowerTemperature id is null.");
        } else {
            Optional<PowerTemperature> optional = powerTemperatureRepository.findById(id);
            if (!optional.isPresent()) {
                throw new PowerTemperatureNotFoundException("PowerTemperature with id " + id + " not found.");
            } else {
                return powerTemperatureConverter.sourceToDto(optional.get());
            }
        }
    }

    @Override
    public PowerTemperatureCommand getByIdCommand(Long id) {
        if (id == null) {
            throw new NullIdException("PowerTemperature id is null.");
        } else {
            Optional<PowerTemperature> optional = powerTemperatureRepository.findById(id);
            if (!optional.isPresent()) {
                throw new PowerTemperatureNotFoundException("PowerTemperature with id " + id + " not found.");
            } else {
                return powerTemperatureConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(PowerTemperatureDTO powerTemperatureDTO) {
        if (powerTemperatureDTO == null) {
            throw new NullReferenceException("PowerTemperature not deleted.Reference passed is null !!!");
        } else {
            PowerTemperature powerTemperature = powerTemperatureConverter.dtoToSource(powerTemperatureDTO);
            powerTemperatureRepository.delete(powerTemperature);
        }
    }

    @Override
    public void deleteCommand(PowerTemperatureCommand powerTemperatureCommand) {
        if (powerTemperatureCommand == null) {
            throw new NullReferenceException("PowerTemperature not deleted.Reference passed is null !!!");
        } else {
            PowerTemperature powerTemperature = powerTemperatureConverter.commandToSource(powerTemperatureCommand);
            powerTemperatureRepository.delete(powerTemperature);
        }
    }

    @Override
    public List<PowerTemperatureDTO> retrieveDTO(Long userId, String identifier, String dataParameters, String startDate, String endDate, String userCommunity, String tempAverage, String outputFormat, String lat, String lon, String bbox) {
        Identifier identifierEnum = Identifier.valueOf(identifier);
        DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
        UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
        TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
        OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);

        //Find user
        User user = userService.getById(userId);

        //Retrieve list
        List<PowerTemperature> retrievedList = nasaClient.retrieveTemperature(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

        //Saved data to db
        Iterable<PowerTemperature> savedData = saveRetrievedList(retrievedList, user);

        return powerTemperatureConverter.sourceToDto(savedData);
    }

    @Override
    public List<PowerTemperatureCommand> retrieveCommand(Long userId, String identifier, String dataParameters, String startDate, String endDate, String userCommunity, String tempAverage, String outputFormat, String lat, String lon, String bbox) {
        Identifier identifierEnum = Identifier.valueOf(identifier);
        DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
        UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
        TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
        OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);


        //Find user
        User user = userService.getById(userId);

        //Retrieve list
        List<PowerTemperature> retrievedList = nasaClient.retrieveTemperature(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

        //Saved data to db
        Iterable<PowerTemperature> savedData = saveRetrievedList(retrievedList, user);


        return powerTemperatureConverter.sourceToCommand(savedData);
    }


    private Iterable<PowerTemperature> saveRetrievedList(List<PowerTemperature> retrievedList, User user) {
        for (PowerTemperature temp : retrievedList) {
            temp.setUser(user);
        }
        return powerTemperatureRepository.saveAll(retrievedList);
    }

}
