package io.gentjankolicaj.app.edata.transform;

import io.gentjankolicaj.app.edata.commons.job.Job;
import io.gentjankolicaj.app.edata.commons.util.YamlUtils;
import io.gentjankolicaj.app.edata.transform.cache.LocalCachePool;
import io.gentjankolicaj.app.edata.transform.http.LocalHttpServer;
import io.gentjankolicaj.app.edata.transform.job.JobConstants;
import io.gentjankolicaj.app.edata.transform.job.JobManager;
import io.gentjankolicaj.app.edata.transform.job.nasa.NasaJob;
import io.gentjankolicaj.app.edata.transform.redis.RedisManager;
import io.gentjankolicaj.app.edata.transform.yaml.ApplicationConfigYaml;
import io.gentjankolicaj.app.edata.transform.yaml.JobConfigYaml;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
@Slf4j
public class TransformApplication {
    public static void main(String[] args) throws Exception {
        ApplicationConfigYaml applicationConfigYaml = getConfigurationYaml();
        LocalCachePool.getInstance().initCaches(applicationConfigYaml.getCaches());
        RedisManager.getInstance().initClient(applicationConfigYaml.getRedis());
        LocalHttpServer.getInstance().start(applicationConfigYaml.getHttpServer());
        (new JobManager(applicationConfigYaml)).runJobs(getJobsImpl(applicationConfigYaml));
    }

    public static ApplicationConfigYaml getConfigurationYaml() throws IOException {
        ApplicationConfigYaml applicationConfigYaml = YamlUtils.read("application.yml", ApplicationConfigYaml.class);
        log.info("{}", applicationConfigYaml);
        return applicationConfigYaml;
    }

    static List<Job> getJobsImpl(ApplicationConfigYaml applicationConfigYaml) {
        if (CollectionUtils.isNotEmpty(applicationConfigYaml.getJobManager().getJobs())) {
            List<JobConfigYaml> jobConfigYamls = applicationConfigYaml.getJobManager().getJobs();
            return List.of(new NasaJob(jobConfigYamls.stream().filter(e -> e.getName().equalsIgnoreCase(JobConstants.NASA_JOB_NAME)).findAny().get()));

        } else
            return List.of();
    }
}
