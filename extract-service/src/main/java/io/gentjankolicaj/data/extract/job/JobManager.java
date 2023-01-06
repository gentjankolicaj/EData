package io.gentjankolicaj.data.extract.job;

import io.gentjankolicaj.data.commons.job.AbstractJobManager;
import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.extract.yaml.JobManagerConfigYaml;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public class JobManager extends AbstractJobManager<JobManagerConfigYaml> {

    public JobManager(JobManagerConfigYaml jobManagerYaml) {
        super(jobManagerYaml);
    }

    @Override
    public void runJobs(Collection<Job> jobs) {
        if (CollectionUtils.isNotEmpty(jobs)) {
            for (Job job : jobs)
                executorService.submit(job);
        }
    }
}
