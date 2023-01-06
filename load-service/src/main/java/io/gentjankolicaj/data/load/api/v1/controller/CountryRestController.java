package io.gentjankolicaj.data.load.api.v1.controller;


import io.gentjankolicaj.data.commons.validator.CountryRequestDataValidator;
import io.gentjankolicaj.data.load.common.dto.CountryDTO;
import io.gentjankolicaj.data.load.exception.api.request.CountryBadRequestException;
import io.gentjankolicaj.data.load.service.CountryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CountryRestController.BASE_URI)
public class CountryRestController {

    public static final String BASE_URI = "/api/v1/countries/";

    private final CountryService countryService;
    private final CountryRequestDataValidator requestDataValidator;

    public CountryRestController(CountryService countryService, CountryRequestDataValidator requestDataValidator) {
        this.countryService = countryService;
        this.requestDataValidator = requestDataValidator;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllDTO();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{countryName}")
    public CountryDTO getCountryById(@PathVariable("countryName") String countryName) {
        if (requestDataValidator.validateFirst(countryName)) {
            return countryService.getByIdDTO(countryName);
        } else {
            throw new CountryBadRequestException("Bad request :" + countryName);
        }
    }


    @RequestMapping("*")
    public ResponseEntity<Object> otherNotMappedRequests() {
        return new ResponseEntity<>("Wrong uri", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
