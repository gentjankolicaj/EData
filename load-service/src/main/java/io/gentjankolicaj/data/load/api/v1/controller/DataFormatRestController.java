package io.gentjankolicaj.data.load.api.v1.controller;

import io.gentjankolicaj.data.load.common.dto.DataFormatDTO;
import io.gentjankolicaj.data.load.service.DataFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(DataFormatRestController.BASE_URL)
public class DataFormatRestController {

    public static final String BASE_URL = "/api/v1/data-format/";

    private final DataFormatService dataFormatService;

    @Autowired
    public DataFormatRestController(DataFormatService dataFormatService) {
        this.dataFormatService = dataFormatService;
    }

    @RequestMapping("")
    public List<DataFormatDTO> getAllDataFormats() {
        return dataFormatService.getAllDTO();
    }
}
