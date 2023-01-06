package io.gentjankolicaj.data.transform.yaml;

import io.gentjankolicaj.data.commons.yaml.AbstractApplicationConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationConfigYaml extends AbstractApplicationConfigYaml<JobManagerConfigYaml> {
    private String name;
    private HttpServerConfigYml httpServer;
    private List<CacheConfigYml> caches;
    private JobManagerConfigYaml jobManager;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public JobManagerConfigYaml getJobManager() {
        return jobManager;
    }
}
