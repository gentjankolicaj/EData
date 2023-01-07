package io.gentjankolicaj.data.extract.yaml;

import io.gentjankolicaj.data.commons.yaml.AbstractApplicationConfigYaml;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApplicationConfigYaml extends AbstractApplicationConfigYaml<JobManagerConfigYaml> {

    private String name;
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
