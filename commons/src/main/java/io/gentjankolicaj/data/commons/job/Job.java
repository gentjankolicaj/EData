package io.gentjankolicaj.data.commons.job;

import java.util.concurrent.Callable;

public interface Job<T> extends Callable<T> {

}
