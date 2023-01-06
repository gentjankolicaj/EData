package io.gentjankolicaj.data.transform.job;

import java.util.concurrent.Callable;

public interface Job<T> extends Callable<T> {
}
