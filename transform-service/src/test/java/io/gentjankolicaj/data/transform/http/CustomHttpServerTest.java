package io.gentjankolicaj.data.transform.http;

import io.gentjankolicaj.data.transform.Application;
import io.gentjankolicaj.data.transform.yaml.ApplicationConfigYaml;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomHttpServerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void start() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        (new CustomHttpServer(applicationConfigYaml.getHttpServer())).start();
    }
}