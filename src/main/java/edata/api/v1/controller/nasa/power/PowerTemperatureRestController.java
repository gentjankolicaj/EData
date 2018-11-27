package edata.api.v1.controller.nasa.power;

import edata.common.domain.nasa.power.PowerTemperature;
import edata.common.dto.nasa.power.PowerTemperatureDTO;
import edata.service.nasa.PowerTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PowerTemperatureRestController.BASE_URL)
public class PowerTemperatureRestController {

    public static final String BASE_URL="/api/v1/nasa/power/temperature/";

    private final PowerTemperatureService powerTemperatureService;

    @Autowired
    public PowerTemperatureRestController(PowerTemperatureService powerTemperatureService) {
        this.powerTemperatureService = powerTemperatureService;
    }

    @RequestMapping("")
    public List<PowerTemperatureDTO> getAllPowerTemperatures(){
        return powerTemperatureService.getAllDTO();
    }
}
