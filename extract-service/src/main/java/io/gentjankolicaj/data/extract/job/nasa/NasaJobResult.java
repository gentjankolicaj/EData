package io.gentjankolicaj.data.extract.job.nasa;

import io.gentjankolicaj.data.extract.job.result.JobResult;
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
