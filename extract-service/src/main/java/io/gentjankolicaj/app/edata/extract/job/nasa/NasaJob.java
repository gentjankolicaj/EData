package io.gentjankolicaj.app.edata.extract.job.nasa;

import io.gentjankolicaj.app.edata.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.app.edata.commons.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.app.edata.commons.job.Job;
import io.gentjankolicaj.app.edata.commons.job.result.SimpleMeta;
import io.gentjankolicaj.app.edata.commons.util.http.HttpUtils;
import io.gentjankolicaj.app.edata.extract.enums.ServerType;
import io.gentjankolicaj.app.edata.extract.yaml.ExternalServerConfigYaml;
import io.gentjankolicaj.app.edata.extract.yaml.HttpPathConfigYaml;
import io.gentjankolicaj.app.edata.extract.yaml.JobConfigYaml;
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
    public NasaJobResult call() {
        boolean flag = true;
        int attempt = 0;
        do {
            try {
                List<PowerPressure> powerPressures = nasaRequestWrapper.retrievePressureDummy();
                List<PowerTemperature> powerTemperatures = nasaRequestWrapper.retrieveTemperatureDummy();
                sentTemperatureRequest(jobYaml.getExternalServer(), powerTemperatures);
                sentPressureRequest(jobYaml.getExternalServer(), powerPressures);
                Thread.sleep(jobYaml.getSleep());
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                attempt++;
                log.error("Error : {} ", e.getMessage(), e);
            }
            if (attempt >= jobYaml.getFailedAttemptMax()) {
                return NasaJobResult.builder().meta(new SimpleMeta(1)).build();
            }
        } while (flag);
        return NasaJobResult.builder().meta(new SimpleMeta(0)).build();
    }

    void sentTemperatureRequest(ExternalServerConfigYaml externalServerConfigYaml, List<PowerTemperature> list) throws IOException, ParseException {
        if (externalServerConfigYaml.getHost().contains(ServerType.HTTP.getName())) {
            HttpPathConfigYaml httpPathConfigYaml = externalServerConfigYaml.getPaths().stream().filter(e -> e.getPath().contains("temperature")).findAny().get();
            switch (httpPathConfigYaml.getMethod()) {
                case "POST":
                    for (Object obj : list)
                        HttpUtils.post(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "GET":
                    for (Object obj : list)
                        HttpUtils.get(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "PUT":
                    for (Object obj : list)
                        HttpUtils.put(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "DELETE":
                    for (Object obj : list)
                        HttpUtils.delete(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "OPTIONS":
                    for (Object obj : list)
                        HttpUtils.options(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
            }
        }
    }

    void sentPressureRequest(ExternalServerConfigYaml externalServerConfigYaml, List<PowerPressure> list) throws IOException, ParseException {
        if (externalServerConfigYaml.getHost().contains(ServerType.HTTP.getName())) {
            HttpPathConfigYaml httpPathConfigYaml = externalServerConfigYaml.getPaths().stream().filter(e -> e.getPath().contains("pressure")).findAny().get();
            switch (httpPathConfigYaml.getMethod()) {
                case "POST":
                    for (Object obj : list)
                        HttpUtils.post(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "GET":
                    for (Object obj : list)
                        HttpUtils.get(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "PUT":
                    for (Object obj : list)
                        HttpUtils.put(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "DELETE":
                    for (Object obj : list)
                        HttpUtils.delete(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
                case "OPTIONS":
                    for (Object obj : list)
                        HttpUtils.options(externalServerConfigYaml.getHost() + httpPathConfigYaml.getPath(), obj, String.class);
                    break;
            }
        }
    }


}
