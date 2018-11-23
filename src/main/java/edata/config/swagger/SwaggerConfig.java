package edata.config.swagger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@PropertySource("classpath:config/swagger.properties")
public class SwaggerConfig {

    @Value("${swagger.document}")
    private String documentType;

    @Autowired
    private ApiInfo apiInfo;


    @Bean
    public Docket getDoket(){
        Docket docket=new Docket(chooseSwaggerDocumentType());
                docket.pathMapping("/")
                .apiInfo(apiInfo);

        return docket;
    }


    private DocumentationType chooseSwaggerDocumentType(){
        if(documentType.equalsIgnoreCase("SPRING_WEB")){
            return DocumentationType.SPRING_WEB;
        }else if(documentType.equalsIgnoreCase("SWAGGER_2")){
            return DocumentationType.SWAGGER_2;
        }else{
            return DocumentationType.SWAGGER_12;
        }
    }

}
