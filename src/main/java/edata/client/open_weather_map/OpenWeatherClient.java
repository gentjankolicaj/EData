package edata.client.open_weather_map;

import edata.client.core.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherClient extends RestClient {

    private final RestTemplate restTemplate;

    @Autowired
    public OpenWeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
