package io.gentjankolicaj.data.commons.cache;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractCacheable<T> implements Cacheable<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public Class<?> getClazz() {
        return value.getClass();
    }
}
