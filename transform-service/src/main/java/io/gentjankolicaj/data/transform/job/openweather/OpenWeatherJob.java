package io.gentjankolicaj.data.transform.job.openweather;

import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.transform.yaml.JobConfigYaml;

public class OpenWeatherJob implements Job {
    public OpenWeatherJob(JobConfigYaml jobConfigYaml) {
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
