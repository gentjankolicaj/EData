package edata.api.v1.controller;


import edata.common.dto.CountryDTO;
import edata.exception.api.request.CountryBadRequestException;
import edata.service.CountryService;
import edata.validator.CountryRequestDataValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CountryRestController.BASE_URI)
public class CountryRestController {

    public static final String BASE_URI="/api/v1/countries/";

    private final CountryService countryService;
    private final CountryRequestDataValidator requestDataValidator;

    public CountryRestController(CountryService countryService, CountryRequestDataValidator requestDataValidator) {
        this.countryService = countryService;
        this.requestDataValidator = requestDataValidator;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CountryDTO> getAllCountries(){
       return countryService.getAllDTO();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{countryName}")
    public List<CountryDTO> getCountriesByName(@PathVariable("countryName") String countryName){
       if(requestDataValidator.validateFirst(countryName)){
           return countryService.getByCountryNameDTO(countryName);
       }else{
           throw new CountryBadRequestException("Bad request :"+countryName);
       }
    }

}
