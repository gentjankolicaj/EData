package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.CountryCommand;
import io.gentjankolicaj.data.load.common.dto.CountryDTO;

import java.util.List;

public interface CountryService {

    List<CountryDTO> getAllDTO();
    List<CountryCommand> getAllCommand();

    CountryDTO saveDTO(CountryDTO countryDTO);
    CountryCommand saveCommand(CountryCommand countryCommand);

    CountryDTO updateDTO(CountryDTO countryDTO);
    CountryCommand updateCommand(CountryCommand countryCommand);


    CountryDTO getByIdDTO(String id);
    CountryCommand  getByIdCommand(String id);

    void deleteDTO(CountryDTO countryDTO);
    void deleteCommand(CountryCommand countryCommand);

    List<CountryDTO> getByCountryNameDTO(String countryName);
    List<CountryCommand> getByCountryNameCommand(String countryName);

    List<CountryDTO> getByPhonePrefixDTO(String phonePrefix);
    List<CountryCommand> getByPhonePrefixCommand(String phonePrefix);

    List<CountryDTO> getByIsoCodeDTO(String isoCodes);
    List<CountryCommand>  getByIsoCodeCommand(String isoCodes);
}
