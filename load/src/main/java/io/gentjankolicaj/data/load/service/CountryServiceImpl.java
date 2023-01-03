package io.gentjankolicaj.data.load.service;

import io.gentjankolicaj.data.load.common.command.CountryCommand;
import io.gentjankolicaj.data.load.common.domain.Country;
import io.gentjankolicaj.data.load.common.dto.CountryDTO;
import io.gentjankolicaj.data.load.converter.CountryConverter;
import io.gentjankolicaj.data.load.exception.resource.CountryNotFoundException;
import io.gentjankolicaj.data.load.exception.resource.NullIdException;
import io.gentjankolicaj.data.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.data.load.repository.CountryRepository;
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
            throw new NullReferenceException("Country not saved.Reference passed is null !!!");
        }else{
            Country savedCountry=countryRepository.save(countryConverter.dtoToSource(countryDTO));
            return countryConverter.sourceToDto(savedCountry);
        }
    }

    @Override
    public CountryCommand saveCommand(CountryCommand countryCommand) {
        if(countryCommand==null){
            throw new NullReferenceException("Country not saved.Reference passed is null !!!");
        }else{
            Country savedCountry=countryRepository.save(countryConverter.commandToSource(countryCommand));
            return countryConverter.sourceToCommand(savedCountry);
        }
    }

    @Override
    public CountryDTO updateDTO(CountryDTO countryDTO) {
        if(countryDTO==null){
            throw new NullReferenceException("Country not found.Reference passed is null !!!");
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
            throw new NullReferenceException("Country not found.Reference passed is null !!!");
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
            throw new NullIdException("Country id is null.");
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
            throw new NullIdException("Country id is null.");
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
            throw new NullReferenceException("Country not deleted.Reference passed is null !!!");
        }else{
            Country country=countryConverter.dtoToSource(countryDTO);
             countryRepository.delete(country);
        }

    }

    @Override
    public void deleteCommand(CountryCommand countryCommand) {
        if(countryCommand==null){
            throw new NullReferenceException("Country not deleted.Reference passed is null !!!");
        }else{
            Country country=countryConverter.commandToSource(countryCommand);
            countryRepository.delete(country);
        }
    }

    @Override
    public List<CountryDTO> getByCountryNameDTO(String countryName) {
        if(countryName==null){
            throw new NullReferenceException("Countries not found by countryName.Reference passed is null !!!");
        }else{
            List<Country> tempList=countryRepository.findCountriesByCountryNameLike(countryName);
            return countryConverter.sourceToDto(tempList);
        }
    }

    @Override
    public List<CountryCommand> getByCountryNameCommand(String countryName) {
        if(countryName==null){
            throw new NullReferenceException("Countries not found by countryName.Reference passed is null !!!");
        }else{
            List<Country> tempList=countryRepository.findCountriesByCountryNameLike(countryName);
            return countryConverter.sourceToCommand(tempList);
        }
    }

    @Override
    public List<CountryDTO> getByPhonePrefixDTO(String phonePrefix) {
        if(phonePrefix==null){
            throw new NullReferenceException("Countries not found by phonePrefix.Reference passed is null !!!");
        }else{
            List<Country> tempList=countryRepository.findCountriesByPhonePrefixLike(phonePrefix);
            return countryConverter.sourceToDto(tempList);
        }

    }

    @Override
    public List<CountryCommand> getByPhonePrefixCommand(String phonePrefix) {
        if(phonePrefix==null){
            throw new NullReferenceException("Countries not found by phonePrefix.Reference passed is null !!!");
        }else{
            List<Country> tempList=countryRepository.findCountriesByPhonePrefixLike(phonePrefix);
            return countryConverter.sourceToCommand(tempList);
        }
    }

    @Override
    public List<CountryDTO> getByIsoCodeDTO(String isoCodes) {
        if(isoCodes==null){
            throw new NullReferenceException("Countries not found by isoCodes.Reference passed is null !!!");
        }else{
            List<Country> tempList=countryRepository.findCountriesByIsoCodesLike(isoCodes);
            return countryConverter.sourceToDto(tempList);
        }
    }

    @Override
    public List<CountryCommand> getByIsoCodeCommand(String isoCodes) {
        if(isoCodes==null){
            throw new NullReferenceException("Countries not found by isoCodes.Reference passed is null !!!");
        }else{
            List<Country> tempList=countryRepository.findCountriesByIsoCodesLike(isoCodes);
            return countryConverter.sourceToCommand(tempList);
        }
    }


}
