package io.gentjankolicaj.data.extract;


import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.extract.yaml.ApplicationConfigYaml;
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
public class ApplicationTest {


    @Test
    void getConfiguration() throws IOException {
        ApplicationConfigYaml applicationYaml = Application.getConfiguration();
        log.info("Application yaml {}", applicationYaml);
    }

    @Test
    void getJobsImpl() throws IOException {
        ApplicationConfigYaml applicationYaml = Application.getConfiguration();
        List<Job> jobs = Application.getJobsImpl(applicationYaml.getJobManager().getJobs());
        Assertions.assertTrue(CollectionUtils.isNotEmpty(jobs));
    }
}
