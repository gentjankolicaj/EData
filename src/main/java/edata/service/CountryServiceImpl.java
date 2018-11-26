package edata.service;

import edata.common.command.CountryCommand;
import edata.common.domain.Country;
import edata.common.dto.CountryDTO;
import edata.converter.CountryConverter;
import edata.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryConverter countryConverter;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CountryConverter countryConverter) {
        this.countryRepository = countryRepository;
        this.countryConverter = countryConverter;
    }

    @Override
    public List<CountryDTO> getAllDTO() {
        List<CountryDTO> list=new ArrayList<>();
        Iterable<Country> iterable=countryRepository.findAll();
        for(Country temp:iterable){
            list.add(countryConverter.sourceToDto(temp));
        }
        return list;
    }

    @Override
    public List<CountryCommand> getAllCommand() {
        List<CountryCommand> list=new ArrayList<>();
        Iterable<Country> iterable=countryRepository.findAll();
        for(Country temp:iterable){
            list.add(countryConverter.sourceToCommand(temp));
        }
        return list;
    }

    @Override
    public CountryDTO saveDTO(CountryDTO countryDTO) {
        return null;
    }

    @Override
    public CountryCommand saveCommand(CountryCommand countryCommand) {
        return null;
    }

    @Override
    public CountryDTO updateDTO(CountryDTO countryDTO) {
        return null;
    }

    @Override
    public CountryCommand updateCommand(CountryCommand countryCommand) {
        return null;
    }

    @Override
    public CountryDTO getByIdDTO(String id) {
        return null;
    }

    @Override
    public CountryCommand getByIdCommand(String id) {
        return null;
    }

    @Override
    public void deleteDTO(CountryDTO countryDTO) {

    }

    @Override
    public void deleteCommand(CountryCommand countryCommand) {

    }

    @Override
    public List<CountryDTO> getByCountryNameDTO(String countryName) {
        List<CountryDTO> list=new ArrayList<>();
        List<Country> tempList=countryRepository.findCountriesByCountryNameLike(countryName);
        for(Country country:tempList){
            list.add(countryConverter.sourceToDto(country));
        }
        return list;
    }

    @Override
    public List<CountryCommand> getByCountryNameCommand(String countryName) {
        List<CountryCommand> list=new ArrayList<>();
        List<Country> tempList=countryRepository.findCountriesByCountryNameLike(countryName);
        for(Country country:tempList){
            list.add(countryConverter.sourceToCommand(country));
        }
        return list;
    }

    @Override
    public List<CountryDTO> getByPhonePrefixDTO(String phonePrefix) {
        List<CountryDTO> list=new ArrayList<>();
        List<Country> tempList=countryRepository.findCountriesByPhonePrefixLike(phonePrefix);
        for(Country country:tempList){
            list.add(countryConverter.sourceToDto(country));
        }
        return list;
    }

    @Override
    public List<CountryCommand> getByPhonePrefixCommand(String phonePrefix) {
        List<CountryCommand> list=new ArrayList<>();
        List<Country> tempList=countryRepository.findCountriesByPhonePrefixLike(phonePrefix);
        for(Country country:tempList){
            list.add(countryConverter.sourceToCommand(country));
        }
        return list;
    }

    @Override
    public List<CountryDTO> getByIsoCodeDTO(String isoCodes) {
        List<CountryDTO> list=new ArrayList<>();
        List<Country> tempList=countryRepository.findCountriesByCountryNameLike(isoCodes);
        for(Country country:tempList){
            list.add(countryConverter.sourceToDto(country));
        }
        return list;
    }

    @Override
    public List<CountryCommand> getByIsoCodeCommand(String isoCodes) {
        List<CountryCommand> list=new ArrayList<>();
        List<Country> tempList=countryRepository.findCountriesByIsoCodesLike(isoCodes);
        for(Country country:tempList){
            list.add(countryConverter.sourceToCommand(country));
        }
        return list;
    }


}
