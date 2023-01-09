package io.gentjankolicaj.app.edata.extract.job;

import io.gentjankolicaj.app.edata.commons.job.AbstractJobManager;
import io.gentjankolicaj.app.edata.commons.job.Job;
import io.gentjankolicaj.app.edata.extract.yaml.JobManagerConfigYaml;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;


public class JobManager extends AbstractJobManager<JobManagerConfigYaml> {

    public JobManager(JobManagerConfigYaml jobManagerYaml) {
        super(jobManagerYaml);
    }

    @Override
    public void runJobs(Job... jobs) {
        if (jobs.length != 0) {
            for (Job job : jobs)
                executorService.submit(job);
        }
    }

    @Override
    public void runJobs(Collection<Job> jobs) {
        if (CollectionUtils.isNotEmpty(jobs)) {
            for (Job job : jobs)
                executorService.submit(job);
        }
    }
}
