package io.gentjankolicaj.data.commons.cache;

public interface Cacheable<T> {
    public T getValue();

    public Class<?> getClazz();

}
