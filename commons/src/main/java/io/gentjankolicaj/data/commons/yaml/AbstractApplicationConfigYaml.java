package io.gentjankolicaj.data.commons.yaml;

public abstract class AbstractApplicationConfigYaml<T extends AbstractJobManagerConfigYaml> {

   public abstract String getName();

   public abstract T getJobManager();
}
