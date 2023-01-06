package io.gentjankolicaj.data.transform.yaml;

import io.gentjankolicaj.data.commons.yaml.AbstractJobManagerConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JobManagerConfigYaml extends AbstractJobManagerConfigYaml<JobConfigYaml> {
    private int threadPoolSize;
    private List<JobConfigYaml> jobs;

}
