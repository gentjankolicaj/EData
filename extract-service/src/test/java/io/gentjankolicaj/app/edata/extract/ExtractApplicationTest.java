package io.gentjankolicaj.app.edata.extract;


import io.gentjankolicaj.app.edata.commons.job.Job;
import io.gentjankolicaj.app.edata.extract.yaml.ApplicationConfigYaml;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * Unit test for simple App.
 */
@Slf4j
public class ExtractApplicationTest {


    @Test
    void getConfiguration() throws IOException {
        ApplicationConfigYaml applicationYaml = ExtractApplication.getConfigurationYaml();
        log.info("ExtractApplication yaml {}", applicationYaml);
    }

    @Test
    void getJobsImpl() throws IOException {
        ApplicationConfigYaml applicationYaml = ExtractApplication.getConfigurationYaml();
        List<Job> jobs = ExtractApplication.getJobsImpl(applicationYaml.getJobManager().getJobs());
        Assertions.assertTrue(CollectionUtils.isNotEmpty(jobs));
    }
}
