package edata.config.rest_client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = {"classpath:config/rest.properties"})
public class RestClientConfig {

    @Value("${nasa.power.status}")
    private String nasaPowerStatus;

    @Value("${openweathermap.status}")
    private String openWeatherMapStatus;



    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder){

        return restTemplateBuilder.build();
    }


}
