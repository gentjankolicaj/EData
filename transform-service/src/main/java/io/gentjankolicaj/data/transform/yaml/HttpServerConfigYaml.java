package io.gentjankolicaj.data.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HttpServerConfigYaml {
    private int port;
    private List<HttpPathConfigYaml> paths;

}
