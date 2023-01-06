package io.gentjankolicaj.data.transform.yaml;

import io.gentjankolicaj.data.commons.yaml.AbstractJobConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobConfigYaml extends AbstractJobConfigYaml {
    private String name;
    private int sleep;
    private int failedAttemptMax;
    private String cacheKey;


}
