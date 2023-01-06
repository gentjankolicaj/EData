package io.gentjankolicaj.data.transform;

import io.gentjankolicaj.data.commons.util.YamlUtils;
import io.gentjankolicaj.data.transform.yaml.ApplicationConfigYaml;

import java.io.IOException;

/**
 * Hello world!
 */
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationConfigYaml applicationYaml = getConfigurationYaml();
    }

    static ApplicationConfigYaml getConfigurationYaml() throws IOException {
        return YamlUtils.read("application.yml", ApplicationConfigYaml.class);
    }
}
