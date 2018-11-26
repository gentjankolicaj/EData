package edata.client.nasa_power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class NasaClient {

    private final RestTemplate restTemplate;


    @Autowired
    public NasaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




}
