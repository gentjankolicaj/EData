package io.gentjankolicaj.app.edata.commons.yaml;

import java.util.List;

public abstract class AbstractJobManagerConfigYaml<T extends AbstractJobConfigYaml> {

    public abstract int getThreadPoolSize();

    public abstract List<T> getJobs();
}
