package io.gentjankolicaj.app.edata.extract.yaml;

import io.gentjankolicaj.app.edata.commons.yaml.AbstractJobManagerConfigYaml;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class JobManagerConfigYaml extends AbstractJobManagerConfigYaml<JobConfigYaml> {
    private int threadPoolSize;
    private List<JobConfigYaml> jobs;

    @Override
    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    @Override
    public List<JobConfigYaml> getJobs() {
        return jobs;
    }
}
