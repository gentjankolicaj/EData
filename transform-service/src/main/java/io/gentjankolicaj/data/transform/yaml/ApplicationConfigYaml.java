package io.gentjankolicaj.data.transform.yaml;

import io.gentjankolicaj.data.commons.yaml.AbstractApplicationConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ApplicationConfigYaml extends AbstractApplicationConfigYaml<JobManagerConfigYaml> {
    private String name;
    private HttpServerConfigYaml httpServer;
    private List<CacheConfigYaml> caches;
    private JobManagerConfigYaml jobManager;
    private RedisConfigYml redis;

}
