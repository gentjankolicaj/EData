package io.gentjankolicaj.data.extract.yaml;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalServerConfigYaml {
    private String uri;
    private String method;
}
