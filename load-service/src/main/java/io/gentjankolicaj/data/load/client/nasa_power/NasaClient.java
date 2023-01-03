package io.gentjankolicaj.data.load.client.nasa_power;

import io.gentjankolicaj.data.load.client.core.RestClient;
import io.gentjankolicaj.data.load.common.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.load.common.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.data.load.common.enums.power.*;
import io.gentjankolicaj.data.load.util.nasa.power.PowerPressureParser;
import io.gentjankolicaj.data.load.util.nasa.power.PowerTemperatureParser;
import io.gentjankolicaj.data.load.util.nasa.url_builder.PowerUrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class NasaClient extends RestClient {

    private final RestTemplate restTemplate;
    private final PowerUrlBuilder powerUrlBuilder;


    @Autowired
    public NasaClient(RestTemplate restTemplate, PowerUrlBuilder powerUrlBuilder) {
        this.restTemplate = restTemplate;
        this.powerUrlBuilder = powerUrlBuilder;

    }


    public List<PowerTemperature> retrieveTemperature(Identifier identifier, DataParameters dataParameters,
                                                      String startDate, String endDate,
                                                      UserCommunity userCommunity, TempAverage tempAverage,
                                                      OutputFormat outputFormat, String lat, String lon, String bbox) {
        String urlBuild = powerUrlBuilder.setIdentifier(identifier).setDataParameters(dataParameters)
                .setStartDate(startDate).setEndDate(endDate)
                .setUserCommunity(userCommunity).setTempAverage(tempAverage)
                .setOutputFormat(outputFormat).setLat(lat).setLon(lon).setBbox(bbox).build();

        String rawText = restTemplate.getForObject(urlBuild, String.class);

        return PowerTemperatureParser.parseTemperature(rawText, dataParameters.getValue());

    }

    public List<PowerPressure> retrievePressure(Identifier identifier, DataParameters dataParameters,
                                                String startDate, String endDate,
                                                UserCommunity userCommunity, TempAverage tempAverage,
                                                OutputFormat outputFormat, String lat, String lon, String bbox) {

        String urlBuild = powerUrlBuilder.setIdentifier(identifier).setDataParameters(dataParameters)
                .setStartDate(startDate).setEndDate(endDate)
                .setUserCommunity(userCommunity).setTempAverage(tempAverage)
                .setOutputFormat(outputFormat).setLat(lat).setLon(lon).setBbox(bbox).build();

        String rawText = restTemplate.getForObject(urlBuild, String.class);

        return PowerPressureParser.parsePressure(rawText, dataParameters.getValue());
    }
}
