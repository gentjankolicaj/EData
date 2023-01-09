package io.gentjankolicaj.app.edata.transform.yaml;

import io.gentjankolicaj.app.edata.commons.yaml.AbstractJobConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class JobConfigYaml extends AbstractJobConfigYaml {
    private String name;
    private int sleep;
    private int failedAttemptMax;
    private List<String> cacheKeys;


}
