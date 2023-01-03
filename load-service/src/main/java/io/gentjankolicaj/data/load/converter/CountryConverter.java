package io.gentjankolicaj.data.load.converter;

import io.gentjankolicaj.data.load.common.command.CountryCommand;
import io.gentjankolicaj.data.load.common.domain.Country;
import io.gentjankolicaj.data.load.common.dto.CountryDTO;
import io.gentjankolicaj.data.load.converter.core.MyConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CountryConverter implements MyConverter<Country, CountryDTO, CountryCommand> {

    public CountryConverter() {
    }

    @Override
    public CountryDTO sourceToDto(Country source) {
        if (source == null) {
            return null;
        } else {
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setCountryName(source.getCountryName());
            countryDTO.setIsoCodes(source.getIsoCodes());
            countryDTO.setPhonePrefix(source.getPhonePrefix());
            return countryDTO;
        }

    }

    @Override
    public CountryCommand sourceToCommand(Country source) {
        if (source == null) {
            return null;
        } else {
            CountryCommand countryCommand = new CountryCommand();
            countryCommand.setCountryName(source.getCountryName());
            countryCommand.setIsoCodes(source.getIsoCodes());
            countryCommand.setPhonePrefix(source.getPhonePrefix());
            return countryCommand;

        }

    }

    @Override
    public Country dtoToSource(CountryDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Country country = new Country();
            country.setCountryName(dto.getCountryName());
            country.setIsoCodes(dto.getIsoCodes());
            country.setPhonePrefix(dto.getPhonePrefix());
            return country;
        }
    }

    @Override
    public Country commandToSource(CountryCommand command) {
        if (command == null) {
            return null;
        } else {
            Country country = new Country();
            country.setCountryName(command.getCountryName());
            country.setIsoCodes(command.getIsoCodes());
            country.setPhonePrefix(command.getPhonePrefix());
            return country;
        }
    }

    @Override
    public List<CountryDTO> sourceToDto(List<Country> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<CountryDTO> tempList = new ArrayList<>(source.size());
            for (Country temp : source) {
                tempList.add(sourceToDto(temp));
            }
            return tempList;
        }
    }

    @Override
    public List<CountryCommand> sourceToCommand(List<Country> source) {
        if (source == null || source.size() == 0) {
            return null;
        } else {
            List<CountryCommand> tempList = new ArrayList<>(source.size());
            for (Country temp : source) {
                tempList.add(sourceToCommand(temp));
            }
            return tempList;
        }
    }
}
