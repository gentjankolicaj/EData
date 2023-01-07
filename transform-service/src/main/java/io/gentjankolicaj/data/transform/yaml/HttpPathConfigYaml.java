package io.gentjankolicaj.data.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class HttpPathConfigYaml {
    private String value;
    private String method;
}
