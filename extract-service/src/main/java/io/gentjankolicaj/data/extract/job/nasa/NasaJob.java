package io.gentjankolicaj.data.extract.job.nasa;

import io.gentjankolicaj.data.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.commons.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.data.commons.job.Job;
import io.gentjankolicaj.data.commons.util.http.HttpUtils;
import io.gentjankolicaj.data.extract.enums.ServerType;
import io.gentjankolicaj.data.extract.job.result.SimpleMeta;
import io.gentjankolicaj.data.extract.yaml.ExternalServerConfigYaml;
import io.gentjankolicaj.data.extract.yaml.JobConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Getter
@Slf4j
public class NasaJob implements Job<NasaJobResult> {
    private JobConfigYaml jobYaml;
    private NasaRequestWrapper nasaRequestWrapper;

    @Override
    public NasaJobResult call() throws Exception {
        boolean flag = true;
        int attempt = 0;
        do {
            try {
                List<PowerPressure> powerPressures = nasaRequestWrapper.retrievePressureDummy();
                List<PowerTemperature> powerTemperatures = nasaRequestWrapper.retrieveTemperatureDummy();
                sentRequest(jobYaml.getExternalServer(), powerPressures, powerTemperatures);
                Thread.sleep(jobYaml.getSleep());
            } catch (Exception e) {
                attempt++;
                log.error("Error : {} ", e.getMessage(), e);
            }
            if (attempt >= jobYaml.getFailedAttemptMax()) {
                return NasaJobResult.builder().meta(new SimpleMeta(1)).build();
            }
        } while (flag);
        return NasaJobResult.builder().meta(new SimpleMeta(0)).build();
    }

    void sentRequest(ExternalServerConfigYaml externalServerConfigYaml, Object... args) throws IOException, ParseException {
        if (externalServerConfigYaml.getUri().contains(ServerType.HTTP.getName())) {
            switch (externalServerConfigYaml.getMethod()) {
                case "POST":
                    for (Object obj : args)
                        HttpUtils.post(externalServerConfigYaml.getUri(), obj, String.class);
                    break;
                case "GET":
                    for (Object obj : args)
                        HttpUtils.get(externalServerConfigYaml.getUri(), obj, String.class);
                    break;
                case "PUT":
                    for (Object obj : args)
                        HttpUtils.put(externalServerConfigYaml.getUri(), obj, String.class);
                    break;
                case "DELETE":
                    for (Object obj : args)
                        HttpUtils.delete(externalServerConfigYaml.getUri(), obj, String.class);
                    break;
                case "OPTIONS":
                    for (Object obj : args)
                        HttpUtils.options(externalServerConfigYaml.getUri(), obj, String.class);
                    break;
            }
        }
    }


}
