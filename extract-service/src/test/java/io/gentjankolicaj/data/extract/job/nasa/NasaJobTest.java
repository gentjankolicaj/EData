package io.gentjankolicaj.data.extract.job.nasa;

import io.gentjankolicaj.data.extract.yaml.ApiProviderConfigYaml;
import io.gentjankolicaj.data.extract.yaml.ExternalServerConfigYaml;
import io.gentjankolicaj.data.extract.yaml.JobConfigYaml;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class NasaJobTest {

    NasaJob nasaJob;
    NasaRequestWrapper nasaRequestWrapper;

    @BeforeEach
    void setup() {
        nasaRequestWrapper = new NasaRequestWrapper();
        nasaJob = new NasaJob(new JobConfigYaml("nasa-job", 2000, 5, new ApiProviderConfigYaml("nasa", "no-api-key", "anonymous", "none"), new ExternalServerConfigYaml("http://localhost:9000/api/v1/nasa", "POST")), nasaRequestWrapper);
    }

    @Test
    void call() {
    }

    @Test
    void sentRequest() throws IOException, ParseException {
        ExternalServerConfigYaml externalServerConfigYaml = nasaJob.getJobYaml().getExternalServer();
        List<Object> list = new ArrayList<>();
        list.addAll(nasaRequestWrapper.retrievePressureDummy());
        list.addAll(nasaRequestWrapper.retrieveTemperatureDummy());
        nasaJob.sentRequest(externalServerConfigYaml, list);
    }
}