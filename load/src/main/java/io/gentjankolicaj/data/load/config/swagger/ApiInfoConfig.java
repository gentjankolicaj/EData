package io.gentjankolicaj.data.load.config.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

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
        return new ApiInfo(this.title, this.description, this.version, this.termsOfService, getContact(), this.license, this.licenseUrl);

    }

    @Bean
    public Contact getContact(){
        return new Contact(this.contactFullname, this.contactUrl, this.contactEmail);
    }

}
