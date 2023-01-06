package io.gentjankolicaj.data.transform;

import io.gentjankolicaj.data.transform.yaml.ApplicationConfigYaml;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.util.Objects.nonNull;

class ApplicationTest {

    @Test
    void getConfigurationYaml() throws IOException {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(nonNull(applicationConfigYaml));
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getJobManager().getJobs()));
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getHttpServer().getPaths()));
        Assertions.assertTrue(nonNull(applicationConfigYaml.getRedis()));
    }
}