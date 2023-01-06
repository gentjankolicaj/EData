package io.gentjankolicaj.data.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CacheConfigYaml {
    private String key;
    private int size;
    private long duration;

}
