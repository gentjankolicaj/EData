package edata.service;

import edata.common.command.CountryCommand;
import edata.common.domain.Country;
import edata.common.dto.CountryDTO;
import edata.converter.CountryConverter;
import edata.exception.resource.CountryNotFoundException;
import edata.exception.resource.IdNullException;
import edata.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if(countryDTO==null){
            throw new CountryNotFoundException("Country not saved.Reference passed is null !!!");
        }else{
            Country savedCountry=countryRepository.save(countryConverter.dtoToSource(countryDTO));
            return countryConverter.sourceToDto(savedCountry);
        }
    }

    @Override
    public CountryCommand saveCommand(CountryCommand countryCommand) {
        if(countryCommand==null){
            throw new CountryNotFoundException("Country not saved.Reference passed is null !!!");
        }else{
            Country savedCountry=countryRepository.save(countryConverter.commandToSource(countryCommand));
            return countryConverter.sourceToCommand(savedCountry);
        }
    }

    @Override
    public CountryDTO updateDTO(CountryDTO countryDTO) {
        if(countryDTO==null){
            throw  new CountryNotFoundException("Country not found.Reference passed is null !!!");
        }else{
            Country newCountry=countryConverter.dtoToSource(countryDTO);
            Optional<Country> optional=countryRepository.findById(newCountry.getCountryName());
            if(!optional.isPresent()){
                CountryDTO savedCountry=countryConverter.sourceToDto(countryRepository.save(newCountry));
                return  savedCountry;
            }else{
                Country actual=optional.get();
                actual.setIsoCodes(newCountry.getIsoCodes());
                actual.setPhonePrefix(newCountry.getPhonePrefix());
                return countryConverter.sourceToDto(actual);
            }
        }
    }

    @Override
    public CountryCommand updateCommand(CountryCommand countryCommand) {
        if(countryCommand==null){
            throw  new CountryNotFoundException("Country not found.Reference passed is null !!!");
        }else{
            Country newCountry=countryConverter.commandToSource(countryCommand);
            Optional<Country> optional=countryRepository.findById(newCountry.getCountryName());
            if(!optional.isPresent()){
                CountryCommand savedCountry=countryConverter.sourceToCommand(countryRepository.save(newCountry));
                return  savedCountry;
            }else{
                Country actual=optional.get();
                actual.setIsoCodes(newCountry.getIsoCodes());
                actual.setPhonePrefix(newCountry.getPhonePrefix());
                return countryConverter.sourceToCommand(actual);
            }
        }
    }

    @Override
    public CountryDTO getByIdDTO(String id) {
        if(id==null){
            throw new IdNullException("Country id is null.");
        }else {
            Optional<Country> optional=countryRepository.findById(id);
            if(!optional.isPresent()){
                throw new CountryNotFoundException("Country with id "+id+" not found.");
            }else{
                return countryConverter.sourceToDto(optional.get());
            }
        }
    }

    @Override
    public CountryCommand getByIdCommand(String id) {
        if(id==null){
            throw new IdNullException("Country id is null.");
        }else {
            Optional<Country> optional=countryRepository.findById(id);
            if(!optional.isPresent()){
                throw new CountryNotFoundException("Country with id "+id+" not found.");
            }else{
                return countryConverter.sourceToCommand(optional.get());
            }
        }
    }

    @Override
    public void deleteDTO(CountryDTO countryDTO) {
        if(countryDTO==null){
            throw new CountryNotFoundException("Country not deleted.Reference passed is null !!!");
        }else{
            Country country=countryConverter.dtoToSource(countryDTO);
             countryRepository.delete(country);
        }

    }

    @Override
    public void deleteCommand(CountryCommand countryCommand) {
        if(countryCommand==null){
            throw new CountryNotFoundException("Country not deleted.Reference passed is null !!!");
        }else{
            Country country=countryConverter.commandToSource(countryCommand);
            countryRepository.delete(country);
        }
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
