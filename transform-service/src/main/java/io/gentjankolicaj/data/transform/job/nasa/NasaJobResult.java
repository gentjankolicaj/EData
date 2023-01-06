package io.gentjankolicaj.data.transform.job.nasa;

import io.gentjankolicaj.data.commons.job.result.JobResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NasaJobResult<M, D> extends JobResult<M, D> {
    private M meta;
    private D data;

}
