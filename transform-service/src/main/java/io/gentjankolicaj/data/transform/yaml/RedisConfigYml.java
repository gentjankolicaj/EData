package io.gentjankolicaj.data.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RedisConfigYml {
    public int defaultTimeout;
    private String host;
    private int port;
    private String password;
    private boolean useSSL;
    private String databaseNumber;
}
