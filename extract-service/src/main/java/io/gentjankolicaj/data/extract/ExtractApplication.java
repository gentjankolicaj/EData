package io.gentjankolicaj.data.extract;

import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.commons.util.YamlUtils;
import io.gentjankolicaj.data.extract.job.JobConstants;
import io.gentjankolicaj.data.extract.job.JobManager;
import io.gentjankolicaj.data.extract.job.nasa.NasaJob;
import io.gentjankolicaj.data.extract.job.nasa.NasaRequestWrapper;
import io.gentjankolicaj.data.extract.job.openweather.OpenWeatherJob;
import io.gentjankolicaj.data.extract.job.openweather.OpenWeatherRequestWrapper;
import io.gentjankolicaj.data.extract.yaml.ApplicationConfigYaml;
import io.gentjankolicaj.data.extract.yaml.JobConfigYaml;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class ExtractApplication {
    public static void main(String[] args) throws IOException {
        ApplicationConfigYaml applicationYaml = getConfigurationYaml();
        JobManager jobManager = new JobManager(applicationYaml.getJobManager());
        jobManager.runJobs(getJobsImpl(applicationYaml.getJobManager().getJobs()));
    }

    static ApplicationConfigYaml getConfigurationYaml() throws IOException {
        ApplicationConfigYaml applicationConfigYaml = YamlUtils.read("application.yml", ApplicationConfigYaml.class);
        log.info("{}", applicationConfigYaml);
        return applicationConfigYaml;
    }

    static List<Job> getJobsImpl(List<JobConfigYaml> jobConfigYamls) {
        return List.of(new NasaJob(jobConfigYamls.stream().filter(e -> e.getName().equalsIgnoreCase(JobConstants.NASA_JOB_NAME)).findAny().get(), new NasaRequestWrapper()),
                new OpenWeatherJob(jobConfigYamls.stream().filter(e -> e.getName().equalsIgnoreCase(JobConstants.OPENWEATHER_JOB_NAME)).findAny().get(), new OpenWeatherRequestWrapper()));
    }
}
