package io.gentjankolicaj.data.load.api.v1.controller;

import io.gentjankolicaj.data.load.common.dto.TemperatureUnitDTO;
import io.gentjankolicaj.data.load.service.TemperatureUnitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TemperatureUnitRestController.BASE_URL)
public class TemperatureUnitRestController {

    public final static String BASE_URL="/api/v1/temp-unit/";

    private final TemperatureUnitService temperatureUnitService;

    public TemperatureUnitRestController(TemperatureUnitService temperatureUnitService) {
        this.temperatureUnitService = temperatureUnitService;
    }

    @RequestMapping("")
    public List<TemperatureUnitDTO> getAllTemperatureUnits(){
        return temperatureUnitService.getAllDTO();
    }
}
