package io.gentjankolicaj.data.commons.job;


import io.gentjankolicaj.data.commons.yaml.AbstractJobManagerConfigYaml;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractJobManager<T extends AbstractJobManagerConfigYaml> {

    protected ExecutorService executorService;
    protected AbstractJobManagerConfigYaml jobManagerYaml;

    public AbstractJobManager(T jobManagerYaml) {
        this.jobManagerYaml = jobManagerYaml;
        this.executorService = setupThreadPool(jobManagerYaml);
    }

    private ExecutorService setupThreadPool(AbstractJobManagerConfigYaml jobManagerYaml) {
        return Executors.newFixedThreadPool(jobManagerYaml.getThreadPoolSize());
    }

    public abstract void runJobs(Collection<Job> jobs);
}
