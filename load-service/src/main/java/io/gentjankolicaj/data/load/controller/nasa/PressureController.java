package io.gentjankolicaj.data.load.controller.nasa;

import io.gentjankolicaj.data.load.service.InformationService;
import io.gentjankolicaj.data.load.service.nasa.PowerPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PressureController.BASE_URL)
public class PressureController {

    public static final String BASE_URL = "/nasa/temperature/";

    private final PowerPressureService powerPressureService;
    private final InformationService informationService;

    @Autowired
    public PressureController(PowerPressureService powerPressureService, InformationService informationService) {
        this.powerPressureService = powerPressureService;
        this.informationService = informationService;
    }
}
