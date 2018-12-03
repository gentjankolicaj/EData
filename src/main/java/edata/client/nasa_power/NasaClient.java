package edata.client.nasa_power;

import edata.client.core.RestClient;
import edata.common.domain.nasa.power.PowerPressure;
import edata.common.domain.nasa.power.PowerTemperature;
import edata.common.enums.power.*;
import edata.util.nasa.power.PowerPressureParser;
import edata.util.nasa.power.PowerTemperatureParser;
import edata.util.nasa.url_builder.PowerUrlBuilder;
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


    public List<PowerTemperature> retrieveTemperature(Identifier identifier,DataParameters dataParameters,
                                                      String startDate,String endDate,
                                                      UserCommunity userCommunity,TempAverage tempAverage,
                                                      OutputFormat outputFormat,String lat,String lon,String bbox){
        String urlBuild=powerUrlBuilder.setIdentifier(identifier).setDataParameters(dataParameters)
                .setStartDate(startDate).setEndDate(endDate)
                .setUserCommunity(userCommunity).setTempAverage(tempAverage)
                .setOutputFormat(outputFormat).setLat(lat).setLon(lon).setBbox(bbox).build();

        String rawText=restTemplate.getForObject(urlBuild,String.class);

        return PowerTemperatureParser.parseTemperature(rawText,dataParameters.getValue());

    }

    public List<PowerPressure> retrievePressure(Identifier identifier,DataParameters dataParameters,
                                                String startDate,String endDate,
                                                UserCommunity userCommunity,TempAverage tempAverage,
                                                OutputFormat outputFormat,String lat,String lon,String bbox){

        String urlBuild=powerUrlBuilder.setIdentifier(identifier).setDataParameters(dataParameters)
                .setStartDate(startDate).setEndDate(endDate)
                .setUserCommunity(userCommunity).setTempAverage(tempAverage)
                .setOutputFormat(outputFormat).setLat(lat).setLon(lon).setBbox(bbox).build();

        String rawText=restTemplate.getForObject(urlBuild,String.class);

        return PowerPressureParser.parsePressure(rawText,dataParameters.getValue());
    }
}
