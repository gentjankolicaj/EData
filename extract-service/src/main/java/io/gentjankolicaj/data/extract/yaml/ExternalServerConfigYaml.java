package io.gentjankolicaj.data.extract.yaml;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalServerConfigYaml {
    private String name;
    private String host;
    private List<HttpPathConfigYaml> paths;
}
