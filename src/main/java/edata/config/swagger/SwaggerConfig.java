package edata.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDoket(){
        return new Docket(DocumentationType.SWAGGER_2);
    }



    @Bean
    public ApiInfo getApiInfo(){
        // todo replace with proper instance ApiInfo()
      return  null;
    }


}
