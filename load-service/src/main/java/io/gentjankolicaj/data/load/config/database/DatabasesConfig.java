package io.gentjankolicaj.data.load.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/databases.properties")
public class DatabasesConfig {

    @Value("${databases.number}")
    private String databasesNumber;

    @Value("${second.database.platform}")
    private String platform;

    @Value("${second.database.driver_name}")
    private String secondDbDriverName;

    @Value("${second.database.url}")
    private String secondDbUrl;

    @Value("${second.database.port}")
    private String secondPort;

    @Value("${second.database.username}")
    private String secondDbUsername;

    @Value("${second.database.password}")
    private String secondDbPassword;

    @Value("${second.database.schema}")
    private String secondDbSchema;

    @Value("${second.database.ssl}")
    private String secondDbSSL;


    @Bean
    public MyDatabase getSecondDatabase() {
        MyDatabase secondDatabase = new MyDatabase();
        secondDatabase.setPlatform(this.platform);
        secondDatabase.setDriverName(this.secondDbDriverName);
        secondDatabase.setPort(checkPort(this.secondPort));
        secondDatabase.setUrl(this.secondDbUrl);
        secondDatabase.setUsername(this.secondDbUsername);
        secondDatabase.setPassword(this.secondDbPassword);
        secondDatabase.setSchema(this.secondDbSchema);
        secondDatabase.setSsl(checkSSL(this.secondDbSSL));
        return secondDatabase;
    }


    //To be propely implemented with more logic
    private Integer checkPort(String port) {
        if (port == null || port.equalsIgnoreCase("0")) {
            return new Integer(3306);
        } else
            return Integer.valueOf(port);
    }

    private Boolean checkSSL(String ssl) {
        if (ssl == null || ssl.equals("") || ssl.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        } else
            return Boolean.TRUE;
    }

}
