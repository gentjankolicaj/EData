package io.gentjankolicaj.app.edata.transform.yaml;

import io.gentjankolicaj.app.edata.commons.yaml.AbstractJobManagerConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class JobManagerConfigYaml extends AbstractJobManagerConfigYaml<JobConfigYaml> {
    private int threadPoolSize;
    private List<JobConfigYaml> jobs;

}
