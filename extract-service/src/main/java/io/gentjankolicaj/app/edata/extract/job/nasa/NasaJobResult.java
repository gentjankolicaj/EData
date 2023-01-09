package io.gentjankolicaj.app.edata.extract.job.nasa;

import io.gentjankolicaj.app.edata.commons.job.result.JobResult;
import lombok.Builder;

@Builder
public class NasaJobResult<M, D> extends JobResult<M, D> {
    private M meta;
    private D data;

    @Override
    public M getMeta() {
        return meta;
    }

    @Override
    public D getData() {
        return data;
    }
}
