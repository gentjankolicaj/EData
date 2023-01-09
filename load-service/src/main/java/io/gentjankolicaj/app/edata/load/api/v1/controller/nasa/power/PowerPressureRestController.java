package io.gentjankolicaj.app.edata.load.api.v1.controller.nasa.power;

import io.gentjankolicaj.app.edata.load.dto.nasa.power.PowerPressureDTO;
import io.gentjankolicaj.app.edata.load.service.nasa.PowerPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PowerPressureRestController.BASE_URL)
public class PowerPressureRestController {

    public static final String BASE_URL = "/api/v1/nasa/power/pressure/";

    private final PowerPressureService powerPressureService;

    @Autowired
    public PowerPressureRestController(PowerPressureService powerPressureService) {
        this.powerPressureService = powerPressureService;
    }

    @GetMapping("")
    public List<PowerPressureDTO> getAllPowerPressures(@RequestParam("identifier") String identifier, @RequestParam("parameters") String parameters,
                                                       @RequestParam("userCommunity") String userCommunity, @RequestParam("startDate") String startDate,
                                                       @RequestParam("endDate") String endDate, @RequestParam("tempAverage") String tempAverage,
                                                       @RequestParam("outputList") String outputList, @RequestParam("lat") String lat,
                                                       @RequestParam("lon") String lon, @RequestParam("bbox") String bbox) {

        if (identifier == null) {
            return powerPressureService.getAllDTO();
        } else {
            return powerPressureService.retrieveDTO(1L, identifier, parameters, startDate, endDate, userCommunity, tempAverage, outputList, lat, lon, bbox);
        }
    }


}
