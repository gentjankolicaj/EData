package io.gentjankolicaj.data.transform;

import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.commons.util.YamlUtils;
import io.gentjankolicaj.data.transform.cache.LocalCachePool;
import io.gentjankolicaj.data.transform.http.CustomHttpServer;
import io.gentjankolicaj.data.transform.job.JobConstants;
import io.gentjankolicaj.data.transform.job.JobManager;
import io.gentjankolicaj.data.transform.job.nasa.NasaJob;
import io.gentjankolicaj.data.transform.redis.RedisManager;
import io.gentjankolicaj.data.transform.yaml.ApplicationConfigYaml;
import io.gentjankolicaj.data.transform.yaml.JobConfigYaml;
import org.apache.commons.collections.CollectionUtils;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationConfigYaml applicationConfigYaml = getConfigurationYaml();
        LocalCachePool.getInstance().initCaches(applicationConfigYaml.getCaches());
        RedisManager.getInstance().initClient(applicationConfigYaml.getRedis());
        (new CustomHttpServer(applicationConfigYaml.getHttpServer())).start();
        (new JobManager(applicationConfigYaml)).runJobs(getJobsImpl(applicationConfigYaml));
    }

    public static ApplicationConfigYaml getConfigurationYaml() throws IOException {
        return YamlUtils.read("application.yml", ApplicationConfigYaml.class);
    }

    static List<Job> getJobsImpl(ApplicationConfigYaml applicationConfigYaml) {
        if (CollectionUtils.isNotEmpty(applicationConfigYaml.getJobManager().getJobs())) {
            List<JobConfigYaml> jobConfigYamls = applicationConfigYaml.getJobManager().getJobs();
            return List.of(new NasaJob(jobConfigYamls.stream().filter(e -> e.getName().equalsIgnoreCase(JobConstants.NASA_JOB_NAME)).findAny().get()));

        } else
            return List.of();
    }
}
