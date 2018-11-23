package edata.config.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:config/apiInfo.properties")
public class ApiInfoConfig {

    //Contact info
    @Value("${api.info.contact.fullname}")
    private String contactFullname;

    @Value("${api.info.contact.url}")
    private String contactUrl;

    @Value("${api.info.contact.email}")
    private String contactEmail;

    //Other api info
    @Value("${api.info.title}")
    private String title;

    @Value("${api.info.description}")
    private String description;

    @Value("${api.info.version}")
    private String version;

    @Value("${api.info.termsOfService}")
    private String termsOfService;

    @Value("${api.info.licenseUrl}")
    private String licenseUrl;

    @Value("${api.info.license}")
    private String license;


    @Bean
    public ApiInfo getApiInfo(){
        ApiInfo apiInfo=new ApiInfo(this.title,this.description,this.version,this.termsOfService,getContact(),this.license,this.licenseUrl,new ArrayList<>());
        return apiInfo;

    }

    @Bean
    public Contact getContact(){
        Contact contact=new Contact(this.contactFullname,this.contactUrl,this.contactEmail );
        return contact;
    }

}
