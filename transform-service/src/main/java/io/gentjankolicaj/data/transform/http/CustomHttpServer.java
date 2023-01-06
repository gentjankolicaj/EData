package io.gentjankolicaj.data.transform.http;

import io.gentjankolicaj.data.transform.yaml.ApplicationConfigYaml;
import io.gentjankolicaj.data.transform.yaml.CacheConfigYaml;
import io.gentjankolicaj.data.transform.yaml.HttpServerConfigYaml;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomHttpServer {
    private HttpServerConfigYaml httpServerConfigYaml;
    private List<CacheConfigYaml> cacheConfigYms;

    public CustomHttpServer(ApplicationConfigYaml applicationConfigYaml) {
    }

    public void start() {
    }
}
