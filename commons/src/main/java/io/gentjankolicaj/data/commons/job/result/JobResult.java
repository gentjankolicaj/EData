package io.gentjankolicaj.data.commons.job.result;


public abstract class JobResult<M, D> {

    public abstract M getMeta();

    public abstract D getData();
}
