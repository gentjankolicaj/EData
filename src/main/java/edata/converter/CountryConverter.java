package edata.converter;

import edata.common.command.CountryCommand;
import edata.common.domain.Country;
import edata.common.dto.CountryDTO;
import edata.converter.core.MyConverter;
import org.springframework.stereotype.Component;


@Component
public class CountryConverter implements MyConverter<Country, CountryDTO, CountryCommand> {

    public CountryConverter() {
    }

    @Override
    public CountryDTO sourceToDto(Country source) {
        if(source==null){
            return null;
        }else{
            CountryDTO countryDTO=new CountryDTO();
            countryDTO.setCountryName(source.getCountryName());
            countryDTO.setIsoCodes(source.getIsoCodes());
            countryDTO.setPhonePrefix(source.getPhonePrefix());
            return  countryDTO;
        }

    }

    @Override
    public CountryCommand sourceToCommand(Country source) {
        if(source==null){
            return null;
        }else{
           CountryCommand countryCommand=new CountryCommand();
           countryCommand.setCountryName(source.getCountryName());
           countryCommand.setIsoCodes(source.getIsoCodes());
           countryCommand.setPhonePrefix(source.getPhonePrefix());
           return countryCommand;

        }

    }

    @Override
    public Country dtoToSource(CountryDTO dto) {
        if(dto==null){
            return null;
        }else{
            Country country=new Country();
            country.setCountryName(dto.getCountryName());
            country.setIsoCodes(dto.getIsoCodes());
            country.setPhonePrefix(dto.getPhonePrefix());
            return country;
        }
    }

    @Override
    public Country commandToSource(CountryCommand command) {
         if(command==null){
            return null;
        }else{
            Country country=new Country();
            country.setCountryName(command.getCountryName());
            country.setIsoCodes(command.getIsoCodes());
            country.setPhonePrefix(command.getPhonePrefix());
            return country;
        }
    }
}
