package io.gentjankolicaj.data.transform.http;

import io.gentjankolicaj.data.transform.yaml.ApplicationConfigYaml;
import io.gentjankolicaj.data.transform.yaml.CacheConfigYaml;
import io.gentjankolicaj.data.transform.yaml.HttpServerConfigYaml;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomHttpServer {
    private HttpServerConfigYaml httpServerConfigYaml;
    private List<CacheConfigYaml> cacheConfigYamls;

    public CustomHttpServer(ApplicationConfigYaml applicationConfigYaml) {
        this.httpServerConfigYaml = applicationConfigYaml.getHttpServer();
        this.cacheConfigYamls = applicationConfigYaml.getCaches();
    }

    public void start() {
    }
}
