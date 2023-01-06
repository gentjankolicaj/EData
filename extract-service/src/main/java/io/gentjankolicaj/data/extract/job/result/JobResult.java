package io.gentjankolicaj.data.extract.job.result;


public abstract class JobResult<M, D> {

    public abstract M getMeta();

    public abstract D getData();
}
