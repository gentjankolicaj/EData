package edata.api.v1.controller;

import edata.common.domain.PressureUnit;
import edata.common.dto.PressureUnitDTO;
import edata.service.PressureUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PressureUnitRestController.BASE_URL)
public class PressureUnitRestController {

    public final static String BASE_URL="/api/v1/press-unit/";

    private final PressureUnitService pressureUnitService;

    @Autowired
    public PressureUnitRestController(PressureUnitService pressureUnitService) {
        this.pressureUnitService = pressureUnitService;
    }

    @RequestMapping("")
    public List<PressureUnitDTO> getAllPressureUnits(){
       return pressureUnitService.getAllDTO();
    }
}
