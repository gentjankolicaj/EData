package io.gentjankolicaj.data.transform.job.nasa;


import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.commons.job.result.SimpleMeta;
import io.gentjankolicaj.data.transform.yaml.JobConfigYaml;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class NasaJob implements Job<NasaJobResult> {

    private JobConfigYaml jobConfigYaml;

    public NasaJob(JobConfigYaml jobConfigYaml) {
        this.jobConfigYaml = jobConfigYaml;
    }

    @Override
    public NasaJobResult call() throws Exception {
        boolean flag = true;
        int attempt = 0;
        do {
            try {

                Thread.sleep(jobConfigYaml.getSleep());
            } catch (Exception e) {
                attempt++;
                log.error("Error : {} ", e.getMessage(), e);
            }
            if (attempt >= jobConfigYaml.getFailedAttemptMax()) {
                return NasaJobResult.builder().meta(new SimpleMeta(1)).build();
            }
        } while (flag);
        return NasaJobResult.builder().meta(new SimpleMeta(0)).build();
    }
}
