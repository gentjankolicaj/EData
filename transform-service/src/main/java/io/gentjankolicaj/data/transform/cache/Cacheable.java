package io.gentjankolicaj.data.transform.cache;

public interface Cacheable<T> {
    public T getValue();

    public Class<?> getClazz();

}
