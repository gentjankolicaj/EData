package io.gentjankolicaj.data.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class HttpServerConfigYaml {
    private int port;
    private SocketConfigYaml socket;
    private List<HttpPathConfigYaml> paths;

}
