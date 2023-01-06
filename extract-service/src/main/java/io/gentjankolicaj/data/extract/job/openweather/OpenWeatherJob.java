package io.gentjankolicaj.data.extract.job.openweather;

import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.extract.yaml.JobConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OpenWeatherJob implements Job<Object> {
    private JobConfigYaml jobYaml;
    private OpenWeatherRequestWrapper openWeatherRequestWrapper;

    @Override
    public Object call() throws Exception {
        return null;
    }
}
