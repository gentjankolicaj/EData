package edata.client.nasa_power;

import edata.client.core.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class NasaRestClient extends MyClient {

    private final RestTemplate restTemplate;


    @Autowired
    public NasaRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




}
