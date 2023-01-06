package io.gentjankolicaj.data.transform.yaml;

import io.gentjankolicaj.data.commons.yaml.AbstractJobConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JobConfigYaml extends AbstractJobConfigYaml {
    private String name;

    @Override
    public String getName() {
        return name;
    }
}
