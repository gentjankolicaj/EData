package io.gentjankolicaj.app.edata.commons.cache;

public interface Cacheable<T> {
    public T getValue();

    public Class<?> getClazz();

}
