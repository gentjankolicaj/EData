package edata.api.v1.controller.nasa.power;

import edata.common.dto.nasa.power.PowerPressureDTO;
import edata.service.nasa.PowerPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PowerPressureRestController.BASE_URL)
public class PowerPressureRestController {

    public static final String BASE_URL="/api/v1/nasa/power/pressure/";

    private final PowerPressureService powerPressureService;

    @Autowired
    public PowerPressureRestController(PowerPressureService powerPressureService) {
        this.powerPressureService = powerPressureService;
    }

    @RequestMapping("")
    public List<PowerPressureDTO> getAllPowerPressures(){
        return powerPressureService.getAllDTO();
    }
}
